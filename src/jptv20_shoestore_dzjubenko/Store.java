package jptv20_shoestore_dzjubenko;


import java.util.Scanner;
import entity.Client;
import entity.Gain;
import entity.History;
import entity.Model;
import interfaces.Keeping;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import tools.SaverToBase;
//import tools.SaverToFile;


public class Store {
    Scanner scanner = new Scanner(System.in);
    float gain;
    private List<Model> models = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private List<History> histories = new ArrayList<>();
    private List<Gain> gains = new ArrayList<>();
    //private Keeping keeper = new SaverToFile();
    private Keeping keeper = new SaverToBase();
     
    Gain AllCash = new Gain();
    Calendar calendar = Calendar.getInstance();
    Date date = calendar.getTime();
    
    String[] months = {"������", "�������", "����", "������", "���", "����", "����", "������", "��������", "�������", "������", "�������"};

    
    
    public Store() {
        models = keeper.loadModels();
        clients = keeper.loadClients();     
        histories = keeper.loadHistories();
        gains = keeper.loadGains();
        
    }
    
    
    public void run() {
        for (int i = 0; i < gains.size(); i++) {
            gain=gains.get(i).getAllMoney();
        }
        String repeat = "r";
        do{
            System.out.println("������ - 0: ����� �� ���������");
            System.out.println("������ - 1: �������� �����");
            System.out.println("������ - 2: ������ �����");
            System.out.println("������ - 3: ���� ���������� � �������");
            System.out.println("������ - 4: ������ ���� ��������");
            System.out.println("������ - 5: ������ �����");
            System.out.println("������ - 6: ����� �������� �� ��� �����");
            System.out.println("������ - 7: ��������� ���������� ������");
            System.out.println("������ - 8: ��������� ���������� �������");
            System.out.println("������ - 9: ���������� ����� �������");
            System.out.println("������ - 10: ����� �������� �� ������������ �����");
            System.out.printf("�������� ����� ������: ");
            int task = scanner.nextInt();scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = "d";
                    System.out.println("����!");
                    break;
                case 1:
                    System.out.println("---- ���������� ����� ----");
                    addModel();
                    break;
                case 2:
                    System.out.println("---- ������ ����� -----");
                    printListModels();
                    break;
                case 3:
                    System.out.println("---- ���������� ������� ----");
                    addClient();
                    break;
                case 4:
                    System.out.println("----- ������ �������� -----");
                    printListClients();
                    break;
                case 5:
                    System.out.println("------ ������� ����� ------");
                    addHistory();
                    break; 
                case 6:
                    System.out.println("----- ����� �������� �� ��� ����� -----");                    
                    printListAllCash();
                    break;
                case 7:
                    System.out.println("----- �������� ������ -----");
                    changeModel();
                    break;
                case 8:
                    System.out.println("----- �������� ������� -----");
                    changeClient();
                    break;
                case 9:
                    System.out.println("----- �������� ����� ������� -----");
                    addMoney();
                    break;
                case 10:
                    System.out.println("----- ����� �� ������������ ����� -----");
                    gainForAMonth();
                    break;
                default:
                    System.out.println("----- ������� ����� �� ������ ----- ");
            }
        }while("r".equals(repeat));
}
    private Model addModel(){
        Model model = new Model();
        System.out.printf("������� �������� �����: ");
        model.setModelName(scanner.nextLine());
        System.out.printf("������� ������ ����� � US: ");
        model.setModelSize(scanner.nextLine());
        System.out.printf("������� ����� �����: ");
        model.setShoeFirm(scanner.nextLine());
        System.out.printf("������� ���� �����: ");
        model.setPrice(scanner.nextFloat());
        System.out.println("================================");
            
        models.add(model);
        keeper.saveModels(models);
        
        return model;

    }
    private Client addClient(){
        Client client = new Client();
        System.out.printf("������� ��� �������: ");
        client.setFirstName(scanner.nextLine());
        System.out.printf("������� ������� �������: ");
        client.setLastName(scanner.nextLine());
        System.out.printf("������� ����� �������� �������: ");
        client.setPhone(scanner.nextLine());
        System.out.printf("������� ���������� ����� �������: ");
        client.setMoney(scanner.nextFloat());scanner.nextLine();
        System.out.println("=================================");

        clients.add(client);
        keeper.saveClients(clients);

        return client;
    }
        
        
        
    
        private History addHistory(){
            History histories1 = new History();
            System.out.println("������ �����: ");
            for (int i = 0; i < models.size(); i++) {
                if(models.get(i)!=null){
                    System.out.println(models.get(i).toString());
                }
            }
            System.out.println("������� ����� �����: ");
            int numberModel = scanner.nextInt();scanner.nextLine();
            for (int i = 0; i < clients.size(); i++) {
                if(clients.get(i) != null){
                    System.out.println(clients.get(i).toString());
                }
            }
            System.out.println("������� ����� �������: ");
            int numberClient = scanner.nextInt();scanner.nextLine();
            histories1.setModel(models.get(numberModel - 1));
            histories1.setClient(clients.get(numberClient - 1));
            float MMoney = models.get(numberModel-1).getPrice();
            float CMoney = clients.get(numberClient-1).getMoney();
            if(CMoney >= MMoney){
                clients.get(numberClient-1).setMoney(clients.get(numberClient-1).getMoney()-models.get(numberModel-1).getPrice());
                gain += models.get(numberModel-1).getPrice();
                AllCash.setAllMoney(gain);
                histories1.setBuy(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                AllCash();
            }else{
                System.out.println("������������ �������!");
            }    
            System.out.println("================================");
            
            histories.add(histories1);
            keeper.saveHistories(histories);

            return histories1;
        }
        
        
        
        
        
        private void printListModels(){
            for (int i = 0; i < models.size(); i++) {
                if(models.get(i) != null){
                   System.out.println(models.get(i).toString());
                }
                else{
                    System.out.println("� ������� ��� �� ����� �����.");
                }
            }
            System.out.println("================================================");
        }
        
        
        
        
        private void printListClients(){
            for (int i = 0; i < clients.size(); i++) {
                if(clients.get(i) != null){
                    System.out.println(clients.get(i).toString());
                }
                else{
                    System.out.println("������ �������� ����...");
                }
            }
            System.out.println("=============================================");
        }
        
        
        
        
        
        private void printListAllCash(){
            for (int i = 0; i < gains.size(); i++) {
                if(gain != 0){
                    System.out.println("����� �� ��� ����� ������: " + gain + " �������");
                }
                else{
                    System.out.println("������� ���� ��� ������ �� ���������");
                }
            }
            System.out.println("==========================================");
        }
        
        
        
        
        
        private void AllCash(){
            gains.add(AllCash);    
            keeper.saveGains(gains);
        }
        
        
        
   
              
               
        private void changeModel(){
            System.out.println("����� ������ �� ������ ��������?");
            printListModels();
            System.out.println("==============================================");
            System.out.println("�������� ������ �� � ID:");
            int choice = scanner.nextInt();
            for (int i = 0; i < models.size(); i++) {
                if(choice == models.get(i).getId()){

                    System.out.println("��� ������ �� ������ ��������?");
                    System.out.println("-------------------------------");
                    System.out.println("1 - �������� �������� ������");
                    System.out.println("2 - �������� ������ ������");
                    System.out.println("3 - �������� ���� ������");
                    System.out.println("4 - �������� ����� ������");
                    System.out.println("-------------------------------");
                    int choice1 = scanner.nextInt();scanner.nextLine();

                    switch(choice1){
                        case 1:
                            System.out.println("������� ����� �������� �����: ");
                            models.get(i).setModelName(scanner.nextLine());
                            keeper.saveModels(models);
                            break;
                        case 2:
                            System.out.println("������� ����� ������ ������");
                            models.get(i).setModelSize(scanner.nextLine());
                            keeper.saveModels(models);
                            break;
                        case 3:
                            System.out.println("������� ����� ���� ������");
                            models.get(i).setPrice(scanner.nextFloat());scanner.nextLine();
                            keeper.saveModels(models);
                            break;
                        case 4:
                            System.out.println("������� ����� ����� �����");
                            models.get(i).setShoeFirm(scanner.nextLine());
                            keeper.saveModels(models);
                            break;
                        default:
                            System.out.println("������� ����� �� ������");
                        break;
                    }
                    System.out.println("==================================");
                }
                else{
                    System.out.println("����� ����� �� ����������!");         
                }
        }
    }
        
        
        
        
        
        private void changeClient(){
            System.out.println("������ ������� �� ������ ��������?");
            printListClients();
            System.out.println("==============================================");
            System.out.println("�������� ������� �� ��� ID:");
            int choice2 = scanner.nextInt();
            for (int i = 0; i < clients.size(); i++) {
                if(choice2 == clients.get(i).getId()){

                    System.out.println("��� ������ �� ������ ��������?");
                    System.out.println("-------------------------------");
                    System.out.println("1 - �������� ��� �������");
                    System.out.println("2 - �������� ������� �������");
                    System.out.println("3 - �������� ������� �������");
                    System.out.println("-------------------------------");
                    int choice3 = scanner.nextInt();scanner.nextLine();

                    switch(choice3){
                        case 1:
                            System.out.println("������� ����� ��� �������: ");
                            clients.get(i).setFirstName(scanner.nextLine());
                            keeper.saveClients(clients);
                            break;
                        case 2:
                            System.out.println("������� ����� ������� �������");
                            clients.get(i).setLastName(scanner.nextLine());
                            keeper.saveClients(clients);
                            break;
                        case 3:
                            System.out.println("������� ����� ����� �������� �������");
                            clients.get(i).setPhone(scanner.nextLine());
                            keeper.saveClients(clients);
                            break;
                        default:
                            System.out.println("������� ����� �� ������");
                        break;
                    }
                    System.out.println("==================================");
                }
                else{
                    System.out.println("������ ������� �� ����������!");         
                }
            }
        }
   
        
        
        
        
        
        private void addMoney(){
            System.out.println("���� �� ������ �������� �����?");
            printListClients();
            System.out.println("�������� ������� �� ��� ID:");
            int choice4 = scanner.nextInt();
            
            for (int i = 0; i < clients.size(); i++) {
                if(choice4 == clients.get(i).getId()){
                    System.out.println("������� �����, ������� ������ �������� �������:");
                    float givemoney = scanner.nextFloat();scanner.nextLine();
                    clients.get(i).setMoney(clients.get(i).getMoney() + givemoney);
                    System.out.println("-----------------");
                    System.out.println("������ � ������� "+clients.get(i).getMoney()+" ��������");
                    System.out.println("===================================");
                    break;
                }
                else{
                    System.out.println("������ ������� �� ����������!");
                }
                
            }
            keeper.saveClients(clients);
        }
        
        
        
        
        private void gainForAMonth(){
            System.out.println("������� �����, �� ������� ������� ���� ����� �� �����:");
            int month = scanner.nextInt();
            System.out.println("===============================");
            float monthGain = 0;
            for (int i = 0; i < histories.size(); i++) {
                if (histories.get(i).getBuy().getMonth()+1 == month) {
                    monthGain += histories.get(i).getModel().getPrice();
                } 
            }
            if (monthGain != 0) {
               System.out.println("����� �������� �� " + months[month-1] + ": " + monthGain + " ��������"); 
            }
            else{
                System.out.println("����� �� " + months[month-1] + " �������...");
            }
            System.out.println("===============================");
        }
}           