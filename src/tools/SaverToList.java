/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Client;
import entity.History;
import entity.Model;
import interfaces.Keeping;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaverToList implements Keeping {

    public void saveModels(List<Model> model) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            fos = new FileOutputStream("model");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(model);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToList.class.getName()).log(Level.INFO, "Нет файла model", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToList.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        }
    }

    @Override
    public List<Model> loadModel() {
        List<Model> model = new ArrayList<>();
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("model");
            ois = new ObjectInputStream(fis);
            model = (List<Model>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToList.class.getName()).log(Level.INFO, "Файл model еще не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToList.class.getName()).log(Level.SEVERE, "Oшибка считывания файла model", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToList.class.getName()).log(Level.INFO, "Класса Model не существует", ex);
        }
        
        return model;
    }

    @Override
    public void saveClient(List<Client> client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Client> loadClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveHistories(List<History> histories) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<History> loadHistories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveModel(List<Model> model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
