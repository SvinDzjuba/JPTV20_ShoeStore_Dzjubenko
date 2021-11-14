package entity;

import java.util.Date;

public class History {
    private Client client;
    private Model model;
    private Date givendate;
    private Date returndate;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Date getGivendate() {
        return givendate;
    }

    public void setGivendate(Date givendate) {
        this.givendate = givendate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    @Override
    public String toString() {
        return "History{" + "client=" + client + ", model=" + model + ", givendate=" + givendate + ", returndate=" + returndate + '}';
    }
   
}
