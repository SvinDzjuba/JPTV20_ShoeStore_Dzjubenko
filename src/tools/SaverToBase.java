package tools;

import entity.Client;
import entity.Gain;
import entity.History;
import entity.Model;
import interfaces.Keeping;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class SaverToBase implements Keeping{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV20_ShoeStore_DzjubenkoPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    @Override
    public void saveModels(List<Model> books) {
        tx.begin();
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getId() == null){
                    em.persist(books.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<Model> loadModels() {
        List<Model> books=null;
        try {
            books = em.createQuery("SELECT book FROM Model book")
                .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return books;
    }
    


    @Override
    public void saveClients(List<Client> readers) {
        tx.begin();
            for (int i = 0; i < readers.size(); i++) {
                if(readers.get(i).getId() == null){
                    em.persist(readers.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<Client> loadClients() {
         List<Client> readers=null;
        try {
            readers = em.createQuery("SELECT reader FROM Client reader")
                .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return readers;
    }

    @Override
    public void saveHistories(List<History> histories) {
        tx.begin();
            for (int i = 0; i < histories.size(); i++) {
                if(histories.get(i).getId() == null){
                    em.persist(histories.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<History> loadHistories() {
         List<History> histories=null;
        try {
            histories = em.createQuery("SELECT history FROM History history")
                .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return histories;
    }

    @Override
    public void saveGains(List<Gain> gains) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Gain> loadGains() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}