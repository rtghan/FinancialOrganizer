package back_end.investment_value;
import back_end.add_investment.AddInvestmentDataAccessInterface;
import entity.Investment;
import entity.Investments;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * A class implementing the InvestmentValueInputBoundary, which allows it to support the calculation of a user's
 * investment portfolio given some data and input from the frontend.
 */
public class InvestmentValueInteractor implements InvestmentValueInputBoundary{
    final private AddInvestmentDataAccessInterface investDAO;
    final private InvestmentValueDataAccessInterface stockDAO;
    final private InvestmentValueOutputBoundary investmentPresenter;

    /**
     * The constructor to create an instance of the InvestmentValueInteractor
     * @param investDAO     A data access object which is required in order to retrieve the user's investments
     * @param stockDAO      A data access object which is required to retrieve stock data using an API
     * @param investmentPresenter   The class responsible for making the front end reflect the changes and computations
     *                              done by the back end
     */
    public InvestmentValueInteractor(AddInvestmentDataAccessInterface investDAO, InvestmentValueDataAccessInterface stockDAO,
                                     InvestmentValueOutputBoundary investmentPresenter) {
        this.investDAO = investDAO;
        this.stockDAO = stockDAO;
        this.investmentPresenter = investmentPresenter;
    }

    /**
     * The method that allows this class to calculate the value of the user's investment portfolio at however many points
     * in time (as specified by granularity)
     * @param inputData     An input data object containing the data required to calculate the user's
     *                      investment portfolio values
     */
    @Override
    public void getValueOverTime(InvestmentValueInputData inputData) {
        Investments investments = investDAO.getInvestments();

        // calculate the period over which we are querying stock prices
        LocalDate end = getNearestDayOfWeek(LocalDate.now().minusDays(1));
        LocalDate start = inputData.getBeginDate();
        int timeGap = (int) DAYS.between(start, end);
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
            LocalDate queryDate = getNearestDayOfWeek(start.plusDays(i * timeDelta));
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


    /**
     * A method that allows the user to return back to the main screen, if triggered.
     */
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
            value += calculatePurchaseValue(inv.getStockName(), getNearestDayOfWeek(inv.getDate()), inv.getQty());
        }
        return value;
    }

    private double calculatePurchaseValue(String stockName, LocalDate purchaseDate, double qty) {
        double price = stockDAO.getPrice(stockName, getNearestDayOfWeek(purchaseDate));
        return price * qty;
    }

    private static LocalDate getNearestDayOfWeek(LocalDate date) {
        if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            return date.minusDays(1);
        }
        else if(date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return date.plusDays(1);
        }
        return date;
    }
}
