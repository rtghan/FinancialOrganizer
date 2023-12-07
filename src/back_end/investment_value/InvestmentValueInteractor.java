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
        LocalDate end = LocalDate.now().minusDays(1);
        LocalDate start = inputData.getBeginDate();
        int timeGap = (int) ChronoUnit.DAYS.between(start, end);
        System.out.println("Time gap of: " + Integer.toString(timeGap));
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
            double value = getDateValue(queryDate);
            if (value == 0) {
                errorMsg = "There were one or more stocks that could not be queried!";
            }
            investmentValues.put(queryDate, getDateValue(queryDate));
        }

        // handle last date separately
        investmentValues.put(end, getDateValue(end));

        // get portfolio value at time of initial purchase
        double initialValue = getInitialValue();

        System.out.println(investmentValues);
        System.out.println("Initial value: " + initialValue);
        InvestmentValueOutputData outputData = new InvestmentValueOutputData(investmentValues, errorMsg, initialValue);
        investmentPresenter.displayPortfolio(outputData);
    }



    @Override
    public void returnHome() {
        investmentPresenter.returnHome();
    }

    private Double getDateValue(LocalDate queryDate) {
        Investments investments = investDAO.getInvestments();
        double value = 0.0;
        for (Investment inv: investments.investments) {

            value += calculatePurchaseValue(inv.getStockName(), queryDate, inv.getQty());
            try{
                Thread.sleep(200);
            }
            catch (Exception e) {

            }
        }
        return value;
    }

    private Double getInitialValue() {
        Investments investments = investDAO.getInvestments();
        double value = 0.0;
        for (Investment inv: investments.investments) {
            value += calculatePurchaseValue(inv.getStockName(), inv.getDate(), inv.getQty());
        }
        return value;
    }

    private double calculatePurchaseValue(String stockName, LocalDate purchaseDate, double qty) {
        double price = stockDAO.getPrice(stockName, purchaseDate);
        return price * qty;
    }
}
