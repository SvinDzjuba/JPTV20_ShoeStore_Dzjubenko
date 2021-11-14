package interfaces;

import entity.Client;
import entity.History;
import entity.Model;
import java.util.List;


public interface Keeping {
    public void saveModel(List<Model> model);
    public List<Model> loadModel();
    public void saveClient(List<Client> client);
    public List<Client> loadClient();
    public void saveHistories(List<History> histories);
    public List<History> loadHistories();           
}
