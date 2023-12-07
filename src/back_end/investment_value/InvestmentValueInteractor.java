package back_end.investment_value;
import back_end.add_investment.AddInvestmentDataAccessInterface;
import entity.Investment;
import entity.Investments;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class InvestmentValueInteractor implements InvestmentValueInputBoundary{
    final private AddInvestmentDataAccessInterface investDAO;
    final private InvestmentValueDataAccessInterface stockDAO;
    final private InvestmentValueOutputBoundary investmentPresenter;

    public InvestmentValueInteractor(AddInvestmentDataAccessInterface investDAO, InvestmentValueDataAccessInterface stockDAO,
                                     InvestmentValueOutputBoundary investmentPresenter) {
        this.investDAO = investDAO;
        this.stockDAO = stockDAO;
        this.investmentPresenter = investmentPresenter;
    }

    @Override
    public void getValueOverTime(InvestmentValueInputData inputData) {
        Investments investments = investDAO.getInvestments();

        // calculate the period over which we are querying stock prices
        LocalDate end = LocalDate.now();
        LocalDate start = inputData.getBeginDate();
        int timeGap = (int) ChronoUnit.DAYS.between(start, end);
        int granularity = inputData.getGranularity();
        int timeDelta = Math.floorDiv(timeGap, granularity);

        // prepare the output data
        Map<LocalDate, Double> investmentValues = new HashMap<LocalDate, Double>();
        String errorMsg = null;
        /*
         * grab 1 less date than the amount of samples we want, as the last sample will be on the end date, instead of
         * i * timeDelta
         */
        for (int i = 0; i < inputData.getGranularity() - 1; i++) {
            // calculate query date
            LocalDate queryDate = start.plusDays(i * timeDelta);
            System.out.println("Querying portfolio value at " + queryDate.toString());

            // get portfolio value at that time
            try{
                investmentValues.put(queryDate, getDateValue(queryDate));
            }
            catch (Exception e) {
                errorMsg = "There were one or more stocks that could not be queried!";
            }

        }

        // handle last date separately
        // get portfolio value at that time
        try{
            investmentValues.put(end, getDateValue(end));
        }
        catch (Exception e) {
            errorMsg = "There were one or more stocks that could not be queried!";
        }

        InvestmentValueOutputData outputData = new InvestmentValueOutputData(investmentValues, errorMsg, getInitialValue());
        investmentPresenter.displayPortfolio(outputData);
    }



    @Override
    public void returnHome() {
        investmentPresenter.returnHome();
    }

    private Double getDateValue(LocalDate queryDate) throws Exception {
        Investments investments = investDAO.getInvestments();
        double value = 0.0;
        String errorMsg = null;
        boolean error = false;
        for (Investment inv: investments.investments) {
            try {
                value += calculatePurchaseValue(inv.getStockName(), queryDate, inv.getQty());
            }
            catch (Exception e){
                System.out.println("A stock was unable to be retrieved.");
                throw e;
            }
        }
        return value;
    }

    private Double getInitialValue() {
        Investments investments = investDAO.getInvestments();
        double value = 0.0;
        String errorMsg = null;
        boolean error = false;
        for (Investment inv: investments.investments) {
            try {
                value += calculatePurchaseValue(inv.getStockName(), inv.getDate(), inv.getQty());
            }
            catch (Exception e){
                System.out.println("A stock was unable to be retrieved.");
            }
        }
        return value;
    }

    private double calculatePurchaseValue(String stockName, LocalDate purchaseDate, double qty) throws Exception {
        double price = stockDAO.getPrice(stockName, purchaseDate);
        return price * qty;
    }
}
