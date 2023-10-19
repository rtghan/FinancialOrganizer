package interface_adapter;

public class TestState {
    private String test = "";
    public TestState(TestState copy){
        test = copy.test;
    }

    public TestState(){}

    public String getTest(){return test;}
    public void setTest(String input){this.test = input;}
}
