package myclasses;

public class Client {
    private String FirstName; 
    private String LastName;
    private String Phone;
    private Double Money;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public Double getMoney() {
        return Money;
    }

    public void setMoney(Double Money) {
        this.Money = Money;
    }

    @Override
    public String toString() {
        return "Client{" + "FirstName=" + FirstName + ", LastName=" + LastName + ", Phone=" + Phone + ", Money=" + Money + '}';
    }
    
}
