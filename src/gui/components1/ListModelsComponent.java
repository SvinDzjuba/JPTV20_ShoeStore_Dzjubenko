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
    private JLabel title;
    private JList<Model> list;
    
    public ListModelsComponent(int widthList, String text, int widthWindow, int heightPanel) {
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
        list.setCellRenderer(new ListModelsCellRenderer());
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