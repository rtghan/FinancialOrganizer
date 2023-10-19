package app;

import interface_adapter.TestController;
import interface_adapter.TestViewModel;
import interface_adapter.ViewManagerModel;
import use_case.TestBudgetBoundry;
import view.TestView;

import javax.swing.*;
import java.io.IOException;

//public class TestFactory {
//    public static TestView create(ViewManagerModel viewManagerModel, TestViewModel testViewModel) {
//
//        try {
//            TestController signupController = createTestUseCase(viewManagerModel, testViewModel);
//            return new TestView(signupController, testViewModel);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not open user data file.");
//        }
//
//        return null;
//    }
//
//    public static TestController createTestUseCase(ViewManagerModel viewManagerModel, TestViewModel testViewModel){
//        //TestBudgetBoundry testBudgetBoundry = new
//
//    }
//
//}
