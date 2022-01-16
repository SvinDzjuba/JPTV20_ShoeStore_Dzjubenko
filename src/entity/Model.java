package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Model implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ModelName;
    private String ModelSize;
    private float Price;
    private String ShoeFirm;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String ModelName) {
        this.ModelName = ModelName;
    }

    public String getModelSize() {
        return ModelSize;
    }

    public void setModelSize(String ModelSize) {
        this.ModelSize = ModelSize;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getShoeFirm() {
        return ShoeFirm;
    }

    public void setShoeFirm(String ShoeFirm) {
        this.ShoeFirm = ShoeFirm;
    }

    @Override
    public String toString() {
        return "Model{" + "id=" + id + ", ModelName=" + ModelName + ", ModelSize=" + ModelSize + ", Price=" + Price + ", ShoeFirm=" + ShoeFirm + '}';
    }

}

