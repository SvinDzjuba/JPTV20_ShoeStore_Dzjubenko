package jptv20_shoestore_dzjubenko;


import java.util.Scanner;
import entity.Client;
import entity.Gain;
import entity.History;
import entity.Model;
import interfaces.Keeping;
import java.util.ArrayList;
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
    
    public Store() {
        models = keeper.loadModels();
        clients = keeper.loadClients();     
        histories = keeper.loadHistories();
        gains = keeper.loadGains();
    }
    
    
    public void run() {
        String repeat = "r";
        do{
            System.out.println("������ - 0: ����� �� ���������");
            System.out.println("������ - 1: �������� �����");
            System.out.println("������ - 3: ���� ���������� � �������");
            System.out.println("������ - 4: �������� �������");
            System.out.println("������ - 5: ������ �����");
            System.out.println("������ - 6: ����� ��������");
            System.out.println("������ - 7: ��������� ���������� ������");
            System.out.printf("�������� ����� ������: ");
            int task = scanner.nextInt();scanner.nextLine();
            for (int i = 0; i < gains.size(); i++) {
                gain=gains.get(i).getAllMoney();
            }
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
                    System.out.println("----- ����� �������� -----");                    
                    printListAllCash();
                    break;
                case 7:
                    System.out.println("----- �������� ������ -----");
                    changeModel();
                default:
                    System.out.println("----- ������� ����� �� ������ ----- ");
            }
        }while("r".equals(repeat));
}
    private Model addModel(){
        Model model = new Model();
        System.out.printf("������� �������� �����: ");
        model.setModelName(scanner.nextLine());
        System.out.println("");
        System.out.printf("������� ������ ����� � US: ");
        model.setModelSize(scanner.nextLine());
        System.out.println("");
        System.out.printf("������� ����� �����: ");
        model.setShoeFirm(scanner.nextLine());
        System.out.println("");
        System.out.printf("������� ���� �����: ");
        model.setPrice(scanner.nextFloat());
            
        models.add(model);
        keeper.saveModels(models);
        
        return model;

    }
    private Client addClient(){
        Client client = new Client();
        System.out.printf("������� ��� �������: ");
        client.setFirstName(scanner.nextLine());
        System.out.println("");
        System.out.printf("������� ������� �������: ");
        client.setLastName(scanner.nextLine());
        System.out.println("");
        System.out.printf("������� ����� �������� �������: ");
        client.setPhone(scanner.nextLine());
        System.out.println("");
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
            float MMoney = models.get(numberClient-1).getPrice();
            float CMoney = clients.get(numberClient-1).getMoney();
            if(CMoney >= MMoney){
                clients.get(numberClient-1).setMoney(clients.get(numberClient-1).getMoney()-models.get(numberClient-1).getPrice());
                gain += models.get(numberModel-1).getPrice();  
                AllCash();
            }else{
                System.out.println("������������ �������!");
            }          
            
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
                    System.out.println("-----------------------------");
                }
            }
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
        }
        
        
        
        
        
        private void printListAllCash(){
            for (int i = 0; i < gains.size(); i++) {
                  System.out.println(gains.get(i).getAllMoney());  
                }
        }
        
        
        
        
        
        private void AllCash(){
            for (int i = 0; i < gains.size(); i++) {
                if (gains.get(i) != null) {
                    gains.get(i).setAllMoney(gain);    
                }
            }
            keeper.saveGains(gains);
        }
        
        
        
   
        
        
               
        private void changeModel(){
            for (int i = 0; i < models.size(); i++) {
                System.out.println("����� ������ �� ������ ��������?");
                printListModels();
                System.out.println("�������� ������ �� � ID:");
                int choice = scanner.nextInt();
                for (int j = 0; j < models.size(); j++) {
                    if(choice == models.get(i).getId()){
                        System.out.println("��� ������ �� ������ ��������?");
                        System.out.println("");
                        System.out.println("1 - �������� ��� ������");
                        System.out.println("2 - �������� ������ ������");
                        System.out.println("3 - �������� ���� ������");
                        System.out.println("4 - �������� ����� ������");
                        int choice1 = scanner.nextInt();
                        
                        switch(choice1){
                            case 1:
                                models.get(i).setModelName(scanner.nextLine());
                            case 2:
                                models.get(i).setModelSize(scanner.nextLine());
                            case 3:
                                models.get(i).setPrice(scanner.nextFloat());
                            case 4:
                                models.get(i).setShoeFirm(scanner.nextLine()); 
                        }
                        int
                    }
                }
            }
        }
}