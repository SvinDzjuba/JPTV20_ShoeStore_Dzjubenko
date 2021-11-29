package facade;

import entity.Client;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import tools.Singleton;

/**
 *
 * @author pupil
 */
public class ClientFacade extends AbstractFacade<Client>{
    
    private EntityManager em;

    public ClientFacade(Class<Client> entityClass) {
        super(entityClass);
        init();
    }
    private void init(){
        Singleton singleton = Singleton.getInstance();
        em = singleton.getEntityManager();
    }
   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
