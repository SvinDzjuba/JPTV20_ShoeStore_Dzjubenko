package gui;

import entity.Model;
import facade.ModelFacade;
import gui.components1.ButtonComponent;
import gui.components1.CaptionComponent;
import gui.components1.EditComponent;
import gui.components1.ListModelsComponent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
        
/**
 *
 * @author User
 */
public class GuiApp extends JFrame{
    public static final int WIDTH_WINDOW = 800;
    public static final int HEIGHT_WINDOW = 600;
    private CaptionComponent captionComponent;
    private EditComponent modelNameComponent;
    private EditComponent modelSizeComponent;
    private ButtonComponent buttonComponent;
    private EditComponent modelPriceComponent;
    private EditComponent modelFirmComponent;
    private ListModelsComponent listModelsComponent;
    private CaptionComponent addModelCaption;
    private CaptionComponent addClientCaption;
    private CaptionComponent addModelInfo;
    
    public GuiApp() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.setPreferredSize(new Dimension(WIDTH_WINDOW,HEIGHT_WINDOW));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setTitle("Shoe Shop");
        
        JTabbedPane managerTabbed = new JTabbedPane();
        managerTabbed.setPreferredSize(new Dimension(WIDTH_WINDOW,HEIGHT_WINDOW));
        managerTabbed.setMinimumSize(managerTabbed.getPreferredSize());
        managerTabbed.setMaximumSize(managerTabbed.getPreferredSize());
        this.add(managerTabbed);
        
        JPanel addModelPanel = new JPanel();
        managerTabbed.addTab("�������� ������", addModelPanel);
            addModelCaption = new CaptionComponent(WIDTH_WINDOW, 170, "���������� �����", 25, 1);
            addModelPanel.add(addModelCaption);
            modelNameComponent = new EditComponent(260, "�������� �����",WIDTH_WINDOW, 35);
            addModelPanel.add(modelNameComponent);
            modelSizeComponent = new EditComponent(260, "������ �����", WIDTH_WINDOW, 35);
            addModelPanel.add(modelSizeComponent);
            modelPriceComponent = new EditComponent(260, "���� �����", WIDTH_WINDOW, 35);
            addModelPanel.add(modelPriceComponent);
            modelFirmComponent = new EditComponent(260, "����� �����", WIDTH_WINDOW, 35);
            addModelPanel.add(modelFirmComponent);
            buttonComponent = new ButtonComponent("�������� �����", WIDTH_WINDOW, 30, 140);
            addModelPanel.add(buttonComponent);
            buttonComponent.getButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Model model = new Model();
                    if(modelNameComponent.getEditor().getText().isEmpty()){
                        addModelInfo.getCaption().setForeground(Color.red);
                        addModelInfo.getCaption().setText("������� �������� �����");
                        return;
                    }
                    model.setModelName(modelNameComponent.getEditor().getText());

                    if(modelSizeComponent.getEditor().getText().isEmpty()){
                        addModelInfo.getCaption().setForeground(Color.red);
                        addModelInfo.getCaption().setText("������� ������ ����� ������� � US");
                        return;
                    }
                    model.setModelSize(modelSizeComponent.getEditor().getText());
                    try {
                        model.setPrice(Float.parseFloat(modelPriceComponent.getEditor().getText()));
                    } catch (Exception ex) {
                        addModelInfo.getCaption().setForeground(Color.red);
                        addModelInfo.getCaption().setText("������� ���� ����� �������, ���� ����� �� �����, ������ ����� '.'");
                        return;
                    }
                    if(modelFirmComponent.getEditor().getText().isEmpty()){
                        addModelInfo.getCaption().setForeground(Color.red);
                        addModelInfo.getCaption().setText("������� ����� �����");
                        return;
                    }
                    model.setShoeFirm(modelFirmComponent.getEditor().getText());

                    ModelFacade modelFacade = new ModelFacade(Model.class);
                    try {
                        modelFacade.create(model);
                        addModelInfo.getCaption().setForeground(Color.BLUE);
                        addModelInfo.getCaption().setText("����� ������� ���������");
                        modelNameComponent.getEditor().setText("");
                        modelSizeComponent.getEditor().setText("");
                        modelPriceComponent.getEditor().setText("");
                        modelFirmComponent.getEditor().setText("");
                    } catch (Exception ex) {
                        addModelInfo.getCaption().setForeground(Color.RED);
                        addModelInfo.getCaption().setText("�� ������� �������� ������");
                    }

                }
            }); 
        
        JPanel addClientPanel = new JPanel();
        managerTabbed.addTab("�������� �������", addClientPanel);
            addClientCaption = new CaptionComponent(WIDTH_WINDOW, 30, "��������� ������", 18, 1);
            
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuiApp().setVisible(true);
            }
        });
    }
}
