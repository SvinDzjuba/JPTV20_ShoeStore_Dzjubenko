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
    private JList<Client> list;
    
    public ListClientsComponent(int widthWindow, int heightPanel) {
        initComponents(widthWindow, heightPanel);
    }

    private void initComponents(int widthWindow, int heightPanel) {
        this.setPreferredSize(new Dimension(widthWindow, heightPanel));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        this.add(Box.createRigidArea(new Dimension(0,40)));
        
        list = new JList<>();
        list.setModel(getListModel());
        list.setCellRenderer(new ListClientsCellRenderer());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setAlignmentX(RIGHT_ALIGNMENT);
       
       JScrollPane scrollPane = new JScrollPane(list);
       scrollPane.setPreferredSize(new Dimension(widthWindow,heightPanel));
       scrollPane.setMinimumSize(scrollPane.getPreferredSize());
       scrollPane.setMaximumSize(scrollPane.getPreferredSize());
       scrollPane.setAlignmentX(LEFT_ALIGNMENT);
       scrollPane.setAlignmentY(TOP_ALIGNMENT);
       this.add(scrollPane);
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