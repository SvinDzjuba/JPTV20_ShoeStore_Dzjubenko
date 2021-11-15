package interfaces;

import entity.Client;
import entity.Gain;
import entity.History;
import entity.Model;
import java.util.List;

/**
 *
 * @author pupil
 */
public interface Keeping {
    public void saveModels(List<Model> models);
    public List<Model> loadModels();
    public void saveClients(List<Client> clients);
    public List<Client> loadClients();
    public void saveHistories(List<History> histories);
    public List<History> loadHistories();
    public void saveGains(List<Gain> gains);
    public List<Gain> loadGains();
}
