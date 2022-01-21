package gui.components1;

import entity.Model;
import facade.ModelFacade;
import gui.components.renderers.ListModelsCellRenderer;
import java.util.List;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author User
 */

public class ListModelsComponent extends JPanel{
    private JList<Model> list;
    
    public ListModelsComponent(int widthWindow, int heightPanel) {
        initComponents(widthWindow, heightPanel);
    }

    private void initComponents(int widthWindow, int heightPanel) {
        this.setPreferredSize(new Dimension(widthWindow,heightPanel));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        this.add(Box.createRigidArea(new Dimension(0,30)));
        
        list = new JList<>();
        list.setModel(getListModel());
        list.setCellRenderer(new ListModelsCellRenderer());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setAlignmentX(LEFT_ALIGNMENT);
       
       JScrollPane ScrollPane = new JScrollPane(list);
       ScrollPane.setPreferredSize(new Dimension(widthWindow,heightPanel));
       ScrollPane.setMinimumSize(ScrollPane.getPreferredSize());
       ScrollPane.setMaximumSize(ScrollPane.getPreferredSize());
       ScrollPane.setAlignmentX(LEFT_ALIGNMENT);
       ScrollPane.setAlignmentY(TOP_ALIGNMENT);
       this.add(ScrollPane);
    }


    private ListModel<Model> getListModel() {
        ModelFacade modelFacade = new ModelFacade(Model.class);
        List<Model> models = modelFacade.findAll();
        
        DefaultListModel<Model> defaultListModel = new DefaultListModel<>();
        for (Model model : models) {
            defaultListModel.addElement(model);
        }
        return defaultListModel;
    }

    public JList<Model> getList() {
        return list;
    }
    
}