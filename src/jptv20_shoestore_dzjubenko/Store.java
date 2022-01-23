package jptv20_shoestore_dzjubenko;


import java.util.Scanner;
import entity.Client;
import entity.Gain;
import entity.History;
import entity.Model;
import facade.ClientFacade;
import facade.GainFacade;
import facade.HistoryFacade;
import facade.ModelFacade;
//import interfaces.Keeping;
import java.time.LocalDate;
import java.time.ZoneId;
//import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
//import tools.SaverToBase;
//import tools.SaverToFile;


public class Store {
    Scanner scanner = new Scanner(System.in);
    double gain;
    private ModelFacade modelFacade = new ModelFacade(Model.class);
    private ClientFacade clientFacade = new ClientFacade(Client.class);
    private GainFacade gainFacade = new GainFacade(Gain.class);
    private HistoryFacade historyFacade = new HistoryFacade(History.class);
//    private List<Model> models = new ArrayList<>();
//    private List<Client> clients = new ArrayList<>();
//    private List<History> histories = new ArrayList<>();
//    private List<Gain> gains = new ArrayList<>();
    //private Keeping keeper = new SaverToFile();
    //private Keeping keeper = new SaverToBase();
     
    Gain AllCash = new Gain();
    Calendar calendar = Calendar.getInstance();
    Date date = calendar.getTime();
    double allcash;
    String[] months = {"������", "�������", "����", "������", "���", "����", "����", "������", "��������", "�������", "������", "�������"};


    public Store() {
//        models = keeper.loadModels();
//        clients = keeper.loadClients();     
//        histories = keeper.loadHistories();
//        gains = keeper.loadGains();    
    }
    
    
    public void run() {
        List<Gain> gains = gainFacade.findAll();
        for (int i = 0; i < gains.size(); i++) {
            allcash=gains.get(i).getAllMoney();
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
                    System.out.println("����� �������!!!");
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
        model.setPrice(scanner.nextDouble());
        System.out.println("================================");
            
        modelFacade.create(model);
        //models.add(model);
        //keeper.saveModels(models);
        
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
        client.setMoney(scanner.nextDouble());
        System.out.println("=================================");

        clientFacade.create(client);
        //clients.add(client);
        //keeper.saveClients(clients);

        return client;
    }
        
        
        
    
        private History addHistory(){
            History histories1 = new History();
            System.out.println("������ �����: ");
            List<Model> models = modelFacade.findAll();
            for (int i = 0; i < models.size(); i++) {
                if(models.get(i)!=null){
                    System.out.println(i+1 + "-" + "�������� ������ - " + models.get(i).getModelName()+ System.lineSeparator() +
                            "������ - " + models.get(i).getModelSize() + System.lineSeparator() + 
                            "����� - " + models.get(i).getShoeFirm() + System.lineSeparator() +
                            "���� - " + models.get(i).getPrice());
                    System.out.println("=================================");
                }
            }
            System.out.println("������� ����� �����: ");
            int numberModel = scanner.nextInt();scanner.nextLine();
            List<Client> clients = clientFacade.findAll();
            for (int i = 0; i < clients.size(); i++) {
                if(clients.get(i) != null){
                    System.out.println(i+1 + "-" + "��� - " + clients.get(i).getFirstName() + System.lineSeparator() +
                            "������� - " + clients.get(i).getLastName() + System.lineSeparator() +
                            "����� �������� - " + clients.get(i).getPhone() + System.lineSeparator() +
                            "���������� �������� ������� - " + clients.get(i).getMoney());
                }
            }
            System.out.println("������� ����� �������: ");
            int numberClient = scanner.nextInt();scanner.nextLine();
            histories1.setModel(models.get(numberModel - 1));
            histories1.setClient(clients.get(numberClient - 1));
            double MMoney = models.get(numberModel-1).getPrice();
            double CMoney = clients.get(numberClient-1).getMoney();
            if(CMoney >= MMoney){
                clients.get(numberClient-1).setMoney(clients.get(numberClient-1).getMoney()-models.get(numberModel-1).getPrice());
                gain += models.get(numberModel-1).getPrice();
                AllCash.setAllMoney(gain);
                histories1.setBuy(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));                                  
                AllCash();
                
                historyFacade.create(histories1);
                //histories.add(histories1);
                //keeper.saveHistories(histories);
                System.out.println("������ " + models.get(numberModel-1).getModelName() + " " +
                        "�������" + " " + clients.get(numberModel-1).getFirstName() + " " +
                        clients.get(numberModel-1).getLastName());
            }
            else{
                System.out.println("������������ �������!");
                
            }    
            System.out.println("================================");
            

            return histories1;
        }
        
        
        
        
        
        private void printListModels(){
            List<Model> models = modelFacade.findAll();
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
            List<Client> clients = clientFacade.findAll();
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
            List<Gain> gains = gainFacade.findAll();
            for (int i = 0; i < gains.size(); i++) {
                if(gain != 0){
                    System.out.println("����� �������� �� ��� ����� ������: " + gain + " �������");
                    break;
                }
                else{
                    System.out.println("������� ���� ��� ������ �� ���������");
                }
            }
            System.out.println("==========================================");
        }
        
        
        
        
        
        private void AllCash(){
            gainFacade.edit(AllCash);
            //gains.add(AllCash);       
            //keeper.saveGains(gains);
        }
        
        
        
   
              
               
        private void changeModel(){
            System.out.println("����� ������ �� ������ ��������?");
            printListModels();
            System.out.println("==============================================");
            System.out.println("�������� ������ �� � ID:");
            int choice = scanner.nextInt();
            long number = scanner.nextLong();
            Model models = modelFacade.find(number);
            if(choice == models.getId()){
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
                        models.setModelName(scanner.nextLine());
                        modelFacade.edit(models);
                        //keeper.saveModels(models);
                        break;
                    case 2:
                        System.out.println("������� ����� ������ ������");
                        models.setModelSize(scanner.nextLine());
                        modelFacade.edit(models);
                        //keeper.saveModels(models);
                        break;
                    case 3:
                        System.out.println("������� ����� ���� ������");
                        models.setPrice(scanner.nextDouble());scanner.nextLine();
                        modelFacade.edit(models);
                        //keeper.saveModels(models);
                        break;
                    case 4:
                        System.out.println("������� ����� ����� �����");
                        models.setShoeFirm(scanner.nextLine());
                        modelFacade.edit(models);
                        //keeper.saveModels(models);
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
        
        
        
        
        
        private void changeClient(){
            System.out.println("������ ������� �� ������ ��������?");
            printListClients();
            System.out.println("�������� ������� �� ��� ID:");
            long number = scanner.nextLong();scanner.nextLine();
            Client clients = clientFacade.find(number);
            if(number == clients.getId()){

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
                        clients.setFirstName(scanner.nextLine());
                        clientFacade.edit(clients);
                        //keeper.saveClients(clients);
                        break;
                    case 2:
                        System.out.println("������� ����� ������� �������");
                        clients.setLastName(scanner.nextLine());
                        clientFacade.edit(clients);
                        //keeper.saveClients(clients);
                        break;
                    case 3:
                        System.out.println("������� ����� ����� �������� �������");
                        clients.setPhone(scanner.nextLine());
                        clientFacade.edit(clients);
                        //keeper.saveClients(clients);
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
   
        
        
        
        
        
        private void addMoney(){
            System.out.println("���� �� ������ �������� �����?");
            printListClients();
            System.out.println("�������� ������� �� ��� ID:");
            int choice4 = scanner.nextInt();
            long number = scanner.nextLong();
            Client clients = clientFacade.find(number);
            if(choice4 == clients.getId()){
                System.out.println("������� �����, ������� ������ �������� �������:");
                double givemoney = scanner.nextDouble();scanner.nextLine();
                clients.setMoney(clients.getMoney() + givemoney);
                System.out.println("-----------------");
                System.out.println("������ � ������� "+clients.getMoney()+" ��������");
                System.out.println("===================================");
            }
            else{
                System.out.println("������ ������� �� ����������!");
            }
                
            //keeper.saveClients(clients);
            clientFacade.edit(clients);
        }
        
        
        
        
        private void gainForAMonth(){
            System.out.println("������� �����, �� ������� ������� ���� ����� �� �����:");
            int month = scanner.nextInt();
            System.out.println("===============================");
            double monthGain = 0;
            long number = scanner.nextLong();
            History histories = historyFacade.find(number);
            if (histories.getBuy().getMonth()+1 == month) {
                monthGain += histories.getModel().getPrice();
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