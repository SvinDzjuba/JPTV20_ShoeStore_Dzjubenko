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
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShoeShopDzjubenko");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    @Override
    public void saveModels(List<Model> models) {
        tx.begin();
            for (int i = 0; i < models.size(); i++) {
                if(models.get(i).getId() == null){
                    em.persist(models.get(i));
                }
                else{
                    em.merge(models.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<Model> loadModels() {
        List<Model> models = null;
        try {
            models = em.createQuery("SELECT model FROM Model model")
                .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return models;
    }
    


    @Override
    public void saveClients(List<Client> clients) {
        tx.begin();
            for (int i = 0; i < clients.size(); i++) {
                if(clients.get(i).getId() == null){
                    em.persist(clients.get(i));
                }
                else{
                    em.merge(clients.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<Client> loadClients() {
        List<Client> clients=null;
        try {
            clients = em.createQuery("SELECT client FROM Client client")
                .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return clients;
    }

    @Override
    public void saveHistories(List<History> histories) {
        tx.begin();
            for (int i = 0; i < histories.size(); i++) {
                if(histories.get(i).getId() == null){
                    em.persist(histories.get(i));
                }
                else{
                    em.merge(histories.get(i));
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
        tx.begin();
            for (int i = 0; i < gains.size(); i++) {
                if (gains.get(i) == null) {
                    em.persist(gains.get(i));
                }
                else{
                    em.merge(gains.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<Gain> loadGains() {
        List<Gain> gains=null;
        try {
            gains = em.createQuery("SELECT gain FROM Gain gain")
                .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return gains;
    }
}
