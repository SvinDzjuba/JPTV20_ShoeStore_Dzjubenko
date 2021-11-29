package facade;

import entity.Model;
import javax.persistence.EntityManager;
import tools.Singleton;

public class ModelFacade extends AbstractFacade<Model>{
    
    private EntityManager em;

    public ModelFacade(Class<Model> entityClass) {
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
