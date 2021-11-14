package entity;

import java.io.Serializable;

public class Client implements Serializable{
    private String FirstName; 
    private String LastName;
    private String Phone;
    private float Money;

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

    public float getMoney() {
        return Money;
    }

    public void setMoney(float Money) {
        this.Money = Money;
    }

    @Override
    public String toString() {
        return "Client{" + "FirstName=" + FirstName + ", LastName=" + LastName + ", Phone=" + Phone + ", Money=" + Money + '}';
    }
    
}
