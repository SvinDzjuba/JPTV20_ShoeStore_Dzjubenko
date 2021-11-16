package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class History implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Client client;
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Model model;
    @Temporal(TemporalType.TIMESTAMP)
    private Date buy;

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }
    
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

    public Date getBuy() {
        return buy;
    }

    public void setBuy(Date buy) {
        this.buy = buy;
    }

    @Override
    public String toString() {
        return "History{" + "id=" + id + ", client=" + client + ", model=" + model + ", buy=" + buy + '}';
    }
}
