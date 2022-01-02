package gui;

import entity.Model;
import facade.ModelFacade;
import gui.components1.ButtonComponent;
import gui.components1.CaptionComponent;
import gui.components1.EditComponent;
import gui.components1.InfoComponent;
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
    private InfoComponent infoComponent;
    private EditComponent modelNameComponent;
    private EditComponent modelSizeComponent;
    private ButtonComponent buttonComponent;
    private EditComponent modelPriceComponent;
    private EditComponent modelFirmComponent;
    private ListModelsComponent listModelsComponent;
    public GuiApp() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.setPreferredSize(new Dimension(GuiApp.WIDTH_WINDOW,GuiApp.HEIGHT_WINDOW));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        JPanel guestPanel = new JPanel();
        listModelsComponent = new ListModelsComponent(false, "Обувь", GuiApp.HEIGHT_WINDOW, GuiApp.HEIGHT_WINDOW - 80, GuiApp.WIDTH_WINDOW);
        guestPanel.add(listModelsComponent);
        this.add(guestPanel);
        JTabbedPane managerTabbed = new JTabbedPane();
        managerTabbed.setPreferredSize(new Dimension(GuiApp.WIDTH_WINDOW,GuiApp.HEIGHT_WINDOW));
        managerTabbed.setMinimumSize(managerTabbed.getPreferredSize());
        managerTabbed.setMaximumSize(managerTabbed.getPreferredSize());
        this.add(managerTabbed);
        JPanel addModelPanel = new JPanel();
        managerTabbed.addTab("Добавить книгу", addModelPanel);
        addModelPanel.setLayout(new BoxLayout(addModelPanel, BoxLayout.Y_AXIS));
        addModelPanel.add(Box.createRigidArea(new Dimension(0,85)));
        captionComponent = new CaptionComponent("Добавление обуви в магазин", this.getWidth(), 50);
        addModelPanel.add(captionComponent);
        infoComponent = new InfoComponent("", this.getWidth(),27);
        addModelPanel.add(infoComponent);
        addModelPanel.add(Box.createRigidArea(new Dimension(0,10)));
        modelNameComponent = new EditComponent("Название обуви",240, 30, 300);
        addModelPanel.add(modelNameComponent);
        modelSizeComponent = new EditComponent("Размер обуви", 240, 30, 100);
        addModelPanel.add(modelSizeComponent);
        modelPriceComponent = new EditComponent("Цена обуви",240,30,100);
        addModelPanel.add(modelPriceComponent);
        modelFirmComponent = new EditComponent("Фирма обуви",240,30,100);
        addModelPanel.add(modelFirmComponent);
        buttonComponent = new ButtonComponent("Добавить обувь", 30, 350, 150);
        addModelPanel.add(buttonComponent);
        buttonComponent.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model model = new Model();
                if(modelNameComponent.getEditor().getText().isEmpty()){
                    infoComponent.getInfo().setForeground(Color.red);
                    infoComponent.getInfo().setText("Введите название обуви");
                    return;
                }
                model.setModelName(modelNameComponent.getEditor().getText());
                
                if(modelSizeComponent.getEditor().getText().isEmpty()){
                    infoComponent.getInfo().setForeground(Color.red);
                    infoComponent.getInfo().setText("Введите размер обуви цифрами в US");
                    return;
                }
                model.setModelSize(modelSizeComponent.getEditor().getText());
                try {
                    model.setPrice(Float.parseFloat(modelPriceComponent.getEditor().getText()));
                } catch (Exception ex) {
                    infoComponent.getInfo().setForeground(Color.red);
                    infoComponent.getInfo().setText("Введите цену обуви цифрами, если число не целое, пишите через '.'");
                    return;
                }
                if(modelFirmComponent.getEditor().getText().isEmpty()){
                    infoComponent.getInfo().setForeground(Color.red);
                    infoComponent.getInfo().setText("Введите фирма обуви");
                    return;
                }
                model.setShoeFirm(modelFirmComponent.getEditor().getText());
                    
                ModelFacade modelFacade = new ModelFacade(Model.class);
                try {
                    modelFacade.create(model);
                    infoComponent.getInfo().setForeground(Color.BLUE);
                    infoComponent.getInfo().setText("Книга успешно добавлена");
                    modelNameComponent.getEditor().setText("");
                    modelSizeComponent.getEditor().setText("");
                    modelPriceComponent.getEditor().setText("");
                    modelFirmComponent.getEditor().setText("");
                } catch (Exception ex) {
                    infoComponent.getInfo().setForeground(Color.RED);
                    infoComponent.getInfo().setText("Не удалось добавить модель");
                }
               
            }
        });
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuiApp().setVisible(true);
            }
        });
    }
}
