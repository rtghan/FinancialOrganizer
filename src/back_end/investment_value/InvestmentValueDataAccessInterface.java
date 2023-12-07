package back_end.investment_value;

import java.time.LocalDate;

public interface InvestmentValueDataAccessInterface {
    Double getPrice(String stockName, LocalDate purchaseDate) throws Exception;
}
