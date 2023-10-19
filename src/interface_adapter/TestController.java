package interface_adapter;

import use_case.TestBudgetBoundry;

public class TestController {
    final TestBudgetBoundry testExpenseBoundry;

    public TestController(TestBudgetBoundry testExpenseBoundry) {
        this.testExpenseBoundry = testExpenseBoundry;
    }

    public void testBudget(){

    }
}
