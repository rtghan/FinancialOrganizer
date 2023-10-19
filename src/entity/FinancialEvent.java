package entity;

public interface FinancialEvent {
    void setAmount(double amount);
    void setCategory(String category);

    double getAmount();
    String getCategory();

}
