package interface_adapter.add_investment;
import back_end.add_investment.AddInvestmentOutputBoundary;
import back_end.add_investment.AddInvestmentOutputData;
import interface_adapter.ViewManagerModel;
import interface_adapter.home_screen.HomeScreenViewModel;
import view.AddInvestmentView;

public class AddInvestmentPresenter implements AddInvestmentOutputBoundary {
    private final ViewManagerModel viewMM;
    private final AddInvestmentViewModel addInvVM;

    private final HomeScreenViewModel homeScreenVM;

    public AddInvestmentPresenter(ViewManagerModel viewMM, AddInvestmentViewModel andInvVM, HomeScreenViewModel homeScreenVM) {
        this.viewMM = viewMM;
        this.addInvVM = andInvVM;
        this.homeScreenVM = homeScreenVM;
    }

    @Override
    public void prepareSuccessView(AddInvestmentOutputData outputData) {
        AddInvestmentState state = addInvVM.getState();
        state.setError(null);
        this.addInvVM.setState(state);
        this.addInvVM.firePropertyChanged();

        homeScreenVM.update();

        this.viewMM.setActiveView(homeScreenVM.getViewName());
        this.viewMM.firePropertyChanged();
    }

    @Override
    public void cancel() {
        this.viewMM.setActiveView(homeScreenVM.getViewName());
        this.viewMM.firePropertyChanged();
    }
}
