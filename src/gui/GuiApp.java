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
    
    private LabelComponent addModelCaption;
    private LabelComponent addClientCaption;
    private LabelComponent addModelInfo;
    private LabelComponent addClientInfo;
    private LabelComponent buyModelCaption;
    
    private EditComponent clientNameComponent;
    private EditComponent clientLastNameComponent;
    private EditComponent clientPhoneComponent;
    private EditComponent clientMoneyComponent;
    
    private ListModelsComponent modelsList;
    private ListClientsComponent clientsList;
    
    private ButtonComponent buyModelButton;
    
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
            addModelCaption = new LabelComponent(WINDOW_WIDTH, 120, "���������� �����", 25, 1);
            addModelPanel.add(addModelCaption);
            addModelInfo = new LabelComponent(WINDOW_WIDTH, 50, "", 15, 0);
            addModelPanel.add(addModelInfo);
            modelNameComponent = new EditComponent(250, "�������� �����", WINDOW_WIDTH, 30);
            addModelPanel.add(modelNameComponent);
            modelSizeComponent = new EditComponent(50, "������ �����", WINDOW_WIDTH, 30);
            addModelPanel.add(modelSizeComponent);
            modelFirmComponent = new EditComponent(200, "����� �����", WINDOW_WIDTH, 30);
            addModelPanel.add(modelFirmComponent);
            modelPriceComponent = new EditComponent(70, "���� �����", WINDOW_WIDTH, 30);
            addModelPanel.add(modelPriceComponent);
            buttonComponent = new ButtonComponent("�������� �����", WINDOW_WIDTH, 155, 170);
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
            addClientCaption = new LabelComponent(WINDOW_WIDTH, 120, "���������� �������", 25, 1);
            addClientPanel.add(addClientCaption);
            addClientInfo = new LabelComponent(WINDOW_WIDTH, 50, "", 15, 0);
            addClientPanel.add(addClientInfo);
            clientNameComponent = new EditComponent(WINDOW_WIDTH/3, "���", WINDOW_WIDTH, 30);
            addClientPanel.add(clientNameComponent);
            clientLastNameComponent = new EditComponent(200, "�������", WINDOW_WIDTH, 30);
            addClientPanel.add(clientLastNameComponent);
            clientPhoneComponent = new EditComponent(200, "����� ��������", WINDOW_WIDTH, 30);
            addClientPanel.add(clientPhoneComponent);
            clientMoneyComponent = new EditComponent(50, "���������� �����", WINDOW_WIDTH, 30);
            addClientPanel.add(clientMoneyComponent);
            buttonComponent = new ButtonComponent("�������� �������", WINDOW_WIDTH, 140, 170);
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
        buyModelPanel.setLayout(new BorderLayout());
        managerTabbed.addTab("������ ������", buyModelPanel);
            buyModelCaption = new LabelComponent(WINDOW_WIDTH, 150, "������� ������", 25, 1);
            buyModelPanel.add(buyModelCaption);
            modelsList = new ListModelsComponent(150, "������", 200, 150);
            buyModelPanel.add(modelsList);
            clientsList = new ListClientsComponent(600, "����������", WINDOW_WIDTH, 350);
            buyModelPanel.add(clientsList);
            buyModelButton = new ButtonComponent("��������� ������", WINDOW_WIDTH, 30, 150);
            buyModelPanel.add(buyModelButton);
            buyModelButton.getButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    History history = new History();
                    
                    if (clientsList.getList().isSelectionEmpty()) {
                        buyModelCaption.getCaption().setText("�������� ����������");
                        buyModelCaption.getCaption().setForeground(Color.red);
                        return;
                    }
                    if (modelsList.getList().isSelectionEmpty()) {
                        buyModelCaption.getCaption().setText("�������� ������");
                        buyModelCaption.getCaption().setForeground(Color.red);
                        return;
                    }
                    if (history.getClient().getMoney() < history.getModel().getPrice()) {
                        buyModelCaption.getCaption().setText("� ���������� ������������ �������� �������");
                        buyModelCaption.getCaption().setForeground(Color.red);
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
                        buyModelCaption.getCaption().setText("������� ������� ���������!");
                        buyModelCaption.getCaption().setForeground(Color.green);
                        clientFacade.edit(history.getClient());
                        clientsList.getList().clearSelection();
                        modelsList.getList().clearSelection();
                    } catch (Exception e) {
                        buyModelCaption.getCaption().setText("�� ������� ������ ������");
                        buyModelCaption.getCaption().setForeground(Color.red);
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
