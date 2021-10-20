/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

public class Model {
    private String ModelName;
    private String ModelSize;
    private float Price;
    private String ShoeFirm;

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
        return "Model{" + "ModelName=" + ModelName + ", ModelSize=" + ModelSize + ", Price=" + Price + ", ShoeFirm=" + ShoeFirm + '}';
    }
   
}

