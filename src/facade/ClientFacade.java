package facade;

import entity.Client;
import javax.persistence.EntityManager;
import tools.Singleton;

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
