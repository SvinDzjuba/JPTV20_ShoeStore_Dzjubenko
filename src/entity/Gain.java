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
    private Long id;
    private float AllMoney;
    
    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public float getAllMoney() {
        return AllMoney;
    }

    public void setAllMoney(float AllMoney) {
        this.AllMoney = AllMoney;
    }

    @Override
    public String toString() {
        return "Gain{" + "id=" + id + ", AllMoney=" + AllMoney + '}';
    }

    
}
