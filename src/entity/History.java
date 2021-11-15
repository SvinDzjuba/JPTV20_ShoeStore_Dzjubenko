package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class History implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Client client;
    private Model model;
    private Date givendate;
    private Date returndate;
    private Long Id;

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

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "History{" + "client=" + client + ", model=" + model + ", givendate=" + givendate + ", returndate=" + returndate + ", Id=" + Id + '}';
    }
   
}
