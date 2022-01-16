package gui;

import entity.Client;
import entity.Model;
import facade.ClientFacade;
import facade.ModelFacade;
import gui.components1.ButtonComponent;
import gui.components1.CaptionComponent;
import gui.components1.EditComponent;
import gui.components1.ListClientsComponent;
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
    private ButtonComponent buttonComponent;
    
    private EditComponent modelNameComponent;
    private EditComponent modelSizeComponent;
    private EditComponent modelPriceComponent;
    private EditComponent modelFirmComponent;
    private ListModelsComponent listModelsComponent;
    
    private CaptionComponent addModelCaption;
    private CaptionComponent addClientCaption;
    private CaptionComponent addModelInfo;
    private CaptionComponent addClientInfo;
    
    private EditComponent clientNameComponent;
    private EditComponent clientLastNameComponent;
    private EditComponent clientPhoneComponent;
    private EditComponent clientMoneyComponent;
    
    private CaptionComponent buyModelCaption;
    private ListModelsComponent modelsList;
    private ListClientsComponent clientsList;
    

    
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
            modelNameComponent = new EditComponent("�������� �����",270, 30, 250);
            addModelPanel.add(modelNameComponent);
            modelSizeComponent = new EditComponent("������ �����", 270, 30, 50);
            addModelPanel.add(modelSizeComponent);
            modelPriceComponent = new EditComponent("���� �����", 270, 30, 80);
            addModelPanel.add(modelPriceComponent);
            modelFirmComponent = new EditComponent("����� �����", 270, 30, 170);
            addModelPanel.add(modelFirmComponent);
            buttonComponent = new ButtonComponent("�������� �����", WIDTH_WINDOW, 140, 170);
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
            addClientCaption = new CaptionComponent(WIDTH_WINDOW, 180, "���������� �������", 25, 1);
            addClientPanel.add(addClientCaption);
            clientNameComponent = new EditComponent("���", 310, 30, 210);
            addClientPanel.add(clientNameComponent);
            clientLastNameComponent = new EditComponent("�������", 310, 30, 210);
            addClientPanel.add(clientLastNameComponent);
            clientPhoneComponent = new EditComponent("����� ��������", 310, 30, 130);
            addClientPanel.add(clientPhoneComponent);
            clientMoneyComponent = new EditComponent("���������� �����", 310, 30, 80);
            addClientPanel.add(clientMoneyComponent);
            buttonComponent = new ButtonComponent("�������� �������", WIDTH_WINDOW, 140, 170);
            addClientPanel.add(buttonComponent);
            buttonComponent.getButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Client client = new Client();
                    if(clientNameComponent.getEditor().getText().isEmpty()){
                        addClientInfo.getCaption().setForeground(Color.red);
                        addClientInfo.getCaption().setText("������� ���");
                        return;
                    }
                    client.setFirstName(clientNameComponent.getEditor().getText());
                    //name
                    if(clientLastNameComponent.getEditor().getText().isEmpty()){
                        addClientInfo.getCaption().setForeground(Color.red);
                        addClientInfo.getCaption().setText("������� �������");
                        return;
                    }
                    client.setLastName(clientLastNameComponent.getEditor().getText());
                    //lastname
                    if(clientPhoneComponent.getEditor().getText().isEmpty()){
                        addClientInfo.getCaption().setForeground(Color.red);
                        addClientInfo.getCaption().setText("������� ����� ��������");
                        return;
                    }
                    client.setPhone(clientPhoneComponent.getEditor().getText());
                    //phone
                    try {
                        client.setMoney(Float.parseFloat(clientPhoneComponent.getEditor().getText()));
                    } catch (Exception ex) {
                        addClientInfo.getCaption().setForeground(Color.red);
                        addClientInfo.getCaption().setText("������� ���������� �����, ����� ������������ '.'");
                        return;
                    }
                    //money
                    
                    ClientFacade clientFacade = new ClientFacade(Client.class);
                    try {
                        clientFacade.create(client);
                        addClientInfo.getCaption().setForeground(Color.BLUE);
                        addClientInfo.getCaption().setText("������ ������� ��������");
                        clientNameComponent.getEditor().setText("");
                        clientLastNameComponent.getEditor().setText("");
                        clientPhoneComponent.getEditor().setText("");
                        clientMoneyComponent.getEditor().setText("");
                    } catch (Exception ex) {
                        addClientInfo.getCaption().setForeground(Color.RED);
                        addClientInfo.getCaption().setText("�� ������� �������� �������");
                    }
                }
            });

        JPanel buyModelPanel = new JPanel();
        managerTabbed.addTab("������ ������", buyModelPanel);
            buyModelCaption = new CaptionComponent(WIDTH_WINDOW, 140, "������� ������", 25, 1);
            buyModelPanel.add(buyModelCaption);
            modelsList = new ListModelsComponent("������", 10, 120, WIDTH_WINDOW/2-50);
            buyModelPanel.add(modelsList);
            clientsList = new ListClientsComponent("�������", 400, 120, WIDTH_WINDOW/2-50);
            buyModelPanel.add(clientsList);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuiApp().setVisible(true);
            }
        });
    }
}
