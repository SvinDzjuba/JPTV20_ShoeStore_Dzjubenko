package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author pupil
 */

@Entity
public class Gain implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private float AllMoney;
    private Long Id;

    public float getAllMoney() {
        return AllMoney;
    }

    public void setAllMoney(float AllMoney) {
        this.AllMoney = AllMoney;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Gain{" + "AllMoney=" + AllMoney + ", Id=" + Id + '}';
    }
    
}
