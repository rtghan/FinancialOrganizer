package back_end.add_investment;
import entity.Investments;
import java.time.Month;

/**
 * This class enables proper tracking and adding of investments, as it allows them to be saved/previous investments
 * retrieved.
 */
public interface AddInvestmentDataAccessInterface {
    /**
     * Returns an Investments entity (a list of all Investment entities defined by the user) which can be used to add
     * more Investment objects to, or to query.
     * @return
     */
    Investments getInvestments();

    /**
     * Upon changing the Investments entity, we would like to persist its data, so this method allows us to save it.
     * @param investments   An Investments entity, which keeps track of all of the user's investments
     */
    void save(Investments investments);
}
