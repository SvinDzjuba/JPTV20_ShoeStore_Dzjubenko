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
    private JLabel title;
    private JList<Model> list;

    public ListModelsComponent(boolean xORy,String text, int left, int heightPanel, int widthEditor) {
        initComponents(xORy, text, left, heightPanel,widthEditor);
    }

    public ListModelsComponent(String text, int left, int heightPanel, int widthEditor) {
        this.initComponents(false, text, left, heightPanel, widthEditor);
    }
    
    private void initComponents(boolean xORy, String text, int left, int heightPanel,int widthEditor) {
       
       this.setPreferredSize(new Dimension(GuiApp.WIDTH_WINDOW-50,heightPanel));
       this.setMinimumSize(this.getPreferredSize());
       this.setMaximumSize(this.getPreferredSize());
       title = new JLabel(text);
       title.setMinimumSize(title.getPreferredSize());
       title.setMaximumSize(title.getPreferredSize());
       list = new JList<>();
       
       if(xORy){
           this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
           title.setPreferredSize(new Dimension(left,27));
           title.setHorizontalAlignment(JLabel.RIGHT);
           title.setAlignmentY(TOP_ALIGNMENT);
       }else{
           this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
           title.setPreferredSize(new Dimension(GuiApp.WIDTH_WINDOW-50,27));
           title.setHorizontalAlignment(JLabel.CENTER);
           title.setAlignmentY(TOP_ALIGNMENT);
           
           
       }
       title.setFont(new Font("Tahoma",0,12));
       this.add(title);
       this.add(Box.createRigidArea(new Dimension(5,0)));
       list.setModel(getListModel());
       list.setCellRenderer(new ListModelsCellRenderer());
       list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
       list.setLayoutOrientation(JList.HEIGHT);
       JScrollPane scrollPane = new JScrollPane(list);
       scrollPane.setPreferredSize(new Dimension(widthEditor,heightPanel));
       scrollPane.setMinimumSize(scrollPane.getPreferredSize());
       scrollPane.setMaximumSize(scrollPane.getPreferredSize());
       scrollPane.setAlignmentX(LEFT_ALIGNMENT);
       scrollPane.setAlignmentY(TOP_ALIGNMENT);
       this.add(scrollPane);
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