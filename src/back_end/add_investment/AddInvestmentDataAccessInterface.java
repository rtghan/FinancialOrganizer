package back_end.add_investment;
import entity.Investments;
import java.time.Month;
public interface AddInvestmentDataAccessInterface {
    Investments getInvestments();
    void save(Investments investments);
}
