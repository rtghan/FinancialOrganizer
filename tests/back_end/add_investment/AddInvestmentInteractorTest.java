package back_end.add_investment;

import back_end.add_income.AddIncomeDataAccessInterface;
import data_access.MemoryDAO;
import entity.Investment;
import entity.Investments;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AddInvestmentInteractorTest {
    @Test
    void successTest(){
        LocalDate date = LocalDate.now();
        AddInvestmentDataAccessInterface addInvDAO = new MemoryDAO();
        AddInvestmentOutputBoundary successPresenter = new AddInvestmentOutputBoundary() {
            @Override
            public void prepareSuccessView(AddInvestmentOutputData outputData) {
                assertEquals("APPL", outputData.getStockName());
                assertEquals(120, outputData.getQty());
                assertEquals(date, outputData.getDate());
                assertNotNull(addInvDAO.getInvestments());
            }

            @Override
            public void cancel() {

            }
        };

        AddInvestmentInputData addInvestmentInputData = new AddInvestmentInputData("APPL", 120, date);
        AddInvestmentInputBoundary invInteractor = new AddInvestmentInteractor(addInvDAO, successPresenter);
        invInteractor.execute(addInvestmentInputData);

    }

}