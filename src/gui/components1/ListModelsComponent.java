package gui.components1;

import entity.Model;
import facade.ModelFacade;
import gui.GuiApp;
import gui.components.renderers.ListModelsCellRenderer;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author User
 */

public class ListModelsComponent extends JPanel{
    private JList<Model> list;

    public ListModelsComponent(boolean xORy, int left, int heightPanel, int widthEditor) {
        initComponents(xORy, left, heightPanel,widthEditor);
    }

    public ListModelsComponent(int left, int heightPanel, int widthEditor) {
        this.initComponents(false, left, heightPanel, widthEditor);
    }
    
    private void initComponents(boolean xORy, int left, int heightPanel,int widthEditor) {
       
       this.setPreferredSize(new Dimension(GuiApp.WIDTH_WINDOW-50,heightPanel));
       this.setMinimumSize(this.getPreferredSize());
       this.setMaximumSize(this.getPreferredSize());

       this.add(Box.createRigidArea(new Dimension(10,0)));

       list = new JList<>();
       list.setModel(getListModel());
       list.setCellRenderer(new ListModelsCellRenderer());
       list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       list.setLayoutOrientation(JList.VERTICAL);
       
       JScrollPane verticalScrollPane = new JScrollPane(list);
       verticalScrollPane.setPreferredSize(new Dimension(widthEditor,heightPanel));
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