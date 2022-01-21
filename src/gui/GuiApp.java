package gui;

import entity.*;
import facade.*;
import gui.components1.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.*;
        
/**
 *
 * @author User
 */
public class GuiApp extends JFrame{
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    private EditComponent captionComponent;
    private ButtonComponent buttonComponent;
    
    private EditComponent modelNameComponent;
    private EditComponent modelSizeComponent;
    private EditComponent modelPriceComponent;
    private EditComponent modelFirmComponent;
    
    private CaptionComponent addModelCaption;
    private CaptionComponent addClientCaption;
    private CaptionComponent addModelInfo;
    private CaptionComponent addClientInfo;
    private CaptionComponent buyModelCaption;
    
    private EditComponent clientNameComponent;
    private EditComponent clientLastNameComponent;
    private EditComponent clientPhoneComponent;
    private EditComponent clientMoneyComponent;
    
    private ListModelsComponent modelsList;
    private ListClientsComponent clientsList;
    
    private ButtonComponent buyModelButton;
    private CaptionComponent modelLabel;
    private CaptionComponent clientLabel;
    private CaptionComponent buyModelInfo;
    
    private Date localdateToDate(LocalDate dateToConvert){
        return Date.from(dateToConvert.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    
    public GuiApp() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setTitle("Shoe Shop");
        
        JTabbedPane managerTabbed = new JTabbedPane();
        managerTabbed.setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        managerTabbed.setMinimumSize(managerTabbed.getPreferredSize());
        managerTabbed.setMaximumSize(managerTabbed.getPreferredSize());
        this.add(managerTabbed);
        
        JPanel addModelPanel = new JPanel();
        managerTabbed.addTab("�������� ������", addModelPanel);
            addModelCaption = new CaptionComponent(WINDOW_WIDTH, 130, "���������� �����", 25, 1);
            addModelPanel.add(addModelCaption);
            addModelInfo = new CaptionComponent(WINDOW_WIDTH, 40, "", 14,0);
            addModelPanel.add(addModelInfo);
            modelNameComponent = new EditComponent("�������� �����",270, 30, 250);
            addModelPanel.add(modelNameComponent);
            modelSizeComponent = new EditComponent("������ �����", 270, 30, 50);
            addModelPanel.add(modelSizeComponent);
            modelFirmComponent = new EditComponent("����� �����", 270, 30, 170);
            addModelPanel.add(modelFirmComponent);
            modelPriceComponent = new EditComponent("���� �����", 270, 30, 80);
            addModelPanel.add(modelPriceComponent);
            buttonComponent = new ButtonComponent("�������� �����", WINDOW_WIDTH, 140, 150);
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
            addClientCaption = new CaptionComponent(WINDOW_WIDTH, 130, "���������� ����������", 25, 1);
            addClientPanel.add(addClientCaption);
            addClientInfo = new CaptionComponent(WINDOW_WIDTH, 40, "", 14,0);
            addClientPanel.add(addClientInfo);
            clientNameComponent = new EditComponent("���", WINDOW_WIDTH/3+25, 30, 210);
            addClientPanel.add(clientNameComponent);
            clientLastNameComponent = new EditComponent("�������",  WINDOW_WIDTH/3+25, 30, 210);
            addClientPanel.add(clientLastNameComponent);
            clientPhoneComponent = new EditComponent("����� ��������", WINDOW_WIDTH/3+25, 30, 130);
            addClientPanel.add(clientPhoneComponent);
            clientMoneyComponent = new EditComponent("���������� �����", WINDOW_WIDTH/3+25, 30, 80);
            addClientPanel.add(clientMoneyComponent);
            buttonComponent = new ButtonComponent("�������� �������",  WINDOW_WIDTH, 140, 150);
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
            buyModelCaption = new CaptionComponent(WINDOW_WIDTH, 40, "������� ������", 25, 1);
            buyModelPanel.add(buyModelCaption);
            buyModelInfo = new CaptionComponent(WINDOW_WIDTH, 35, "", 15, 0);
            buyModelPanel.add(buyModelInfo);
            modelLabel = new CaptionComponent(WINDOW_WIDTH, 35, "������", 15, 0);
            buyModelPanel.add(modelLabel);
            modelsList = new ListModelsComponent(WINDOW_WIDTH-150, 128);
            buyModelPanel.add(modelsList);
            clientLabel = new CaptionComponent(WINDOW_WIDTH, 35, "����������", 15, 0);
            buyModelPanel.add(clientLabel);
            clientsList = new ListClientsComponent(WINDOW_WIDTH-150, 145);
            buyModelPanel.add(clientsList);
            buyModelButton = new ButtonComponent("��������� ������", WINDOW_WIDTH, 80, 150);
            buyModelPanel.add(buyModelButton);
            buyModelButton.getButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    History history = new History();
                    
                    if (clientsList.getList().isSelectionEmpty()) {
                        buyModelInfo.getCaption().setText("�������� ����������");
                        buyModelInfo.getCaption().setForeground(Color.red);
                        return;
                    }
                    if (modelsList.getList().isSelectionEmpty()) {
                        buyModelInfo.getCaption().setText("�������� ������");
                        buyModelInfo.getCaption().setForeground(Color.red);
                        return;
                    }
                    if (history.getClient().getMoney() < history.getModel().getPrice()) {
                        buyModelInfo.getCaption().setText("� ���������� ������������ �����");
                        buyModelInfo.getCaption().setForeground(Color.red);
                        return;
                    }
                    
                    history.setClient(clientsList.getList().getSelectedValue());
                    history.setModel(modelsList.getList().getSelectedValue());
                    history.getClient().setMoney(history.getClient().getMoney() - history.getModel().getPrice());
                    history.setBuy(localdateToDate(LocalDate.now()));
                        
                    HistoryFacade historyFacade = new HistoryFacade(History.class);
                    ClientFacade clientFacade = new ClientFacade(Client.class);
                    
                    try {
                        historyFacade.edit(history);
                        buyModelInfo.getCaption().setText("������� ������� ���������!");
                        buyModelInfo.getCaption().setForeground(Color.green);
                        clientFacade.edit(history.getClient());
                        clientsList.getList().clearSelection();
                        modelsList.getList().clearSelection();
                    } catch (Exception e) {
                        buyModelInfo.getCaption().setText("�� ������� ������ ������");
                        buyModelInfo.getCaption().setForeground(Color.red);
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
