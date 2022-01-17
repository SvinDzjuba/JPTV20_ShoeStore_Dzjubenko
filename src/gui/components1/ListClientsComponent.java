package gui.components1;

import entity.Client;
import facade.ClientFacade;
import gui.components.renderers.ListClientsCellRenderer;
import java.util.List;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author User
 */

public class ListClientsComponent extends JPanel{
    private JLabel title;
    private JList<Client> list;
    
    public ListClientsComponent(int widthList, String text, int widthWindow, int heightPanel) {
        initComponents(widthList, text, widthWindow, heightPanel);
    }

    private void initComponents(int widthList, String text, int widthWindow, int heightPanel) {
        this.setPreferredSize(new Dimension(widthWindow, heightPanel));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        title = new JLabel(text);
        title.setPreferredSize(new Dimension(widthWindow/3, 25));
        title.setMinimumSize(title.getPreferredSize());
        title.setMaximumSize(title.getPreferredSize());
        title.setHorizontalAlignment(JLabel.RIGHT);
        title.setAlignmentY(TOP_ALIGNMENT);
        title.setFont(new Font("Tahoma", 0, 12));
        this.add(title);
        
        this.add(Box.createRigidArea(new Dimension(10,0)));
        
        list = new JList<>();
        list.setModel(getListModel());
        list.setCellRenderer(new ListClientsCellRenderer());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
       
       JScrollPane verticalScrollPane = new JScrollPane(list);
       verticalScrollPane.setPreferredSize(new Dimension(widthWindow,heightPanel));
       verticalScrollPane.setMinimumSize(verticalScrollPane.getPreferredSize());
       verticalScrollPane.setMaximumSize(verticalScrollPane.getPreferredSize());
       verticalScrollPane.setAlignmentX(LEFT_ALIGNMENT);
       verticalScrollPane.setAlignmentY(TOP_ALIGNMENT);
       this.add(verticalScrollPane);
    }

    private ListModel<Client> getListModel() {
        ClientFacade clientFacade = new ClientFacade(Client.class);
        List<Client> clients = clientFacade.findAll();
        
        DefaultListModel<Client> defaultListModel = new DefaultListModel<>();
        for (Client client : clients) {
            defaultListModel.addElement(client);
        }
        return defaultListModel;
    }

    public JList<Client> getList() {
        return list;
    }
    
}