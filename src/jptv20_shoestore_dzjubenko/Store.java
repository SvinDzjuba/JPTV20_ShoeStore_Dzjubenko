package jptv20_shoestore_dzjubenko;


import java.util.Scanner;
import entity.Client;
import entity.Gain;
import entity.History;
import entity.Model;
import interfaces.Keeping;
import java.util.ArrayList;
import java.util.List;
import tools.SaverToBase;
import tools.SaverToFile;


public class Store {
    Scanner scanner = new Scanner(System.in);
    float gain = 0;
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
            System.out.println("Задача - 0: Выход из программы");
            System.out.println("Задача - 1: Добавить Обувь");
            System.out.println("Задача - 3: Ввод информации о клиенте");
            System.out.println("Задача - 4: Информация о клиенте");
            System.out.println("Задача - 5: Выдать обувь");
            System.out.println("Задача - 6: Доход магазина");
            System.out.printf("Выберите номер задачи: ");
            int task = scanner.nextInt();scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = "d";
                    System.out.println("Пока!");
                    break;
                case 1:
                    System.out.println("---- Добавление обуви ----");
                    addModel();
                    break;
                case 2:
                    System.out.println("---- Список обуви -----");
                    printListModels();
                    break;
                case 3:
                    System.out.println("---- Ввод информация о клиенте ----");
                    addClient();
                    break;
                case 4:
                    System.out.println("----- Клиент -----");
                    printListClients();
                    break;
                case 5:
                    System.out.println("------ Продать обувь ------");
                    addHistory();
                    break; 
                case 6:
                    System.out.println("----- Доход магазина -----");                    
                    System.out.println(gain);
                    
                    break;
                default:
                    System.out.println("----- Введите номер из списка ----- ");
            }
        }while("r".equals(repeat));
}
    private Model addModel(){
        Model model = new Model();
        System.out.printf("Введите название обуви: ");
        model.setModelName(scanner.nextLine());
        System.out.println("");
        System.out.printf("Введите размер обуви в US: ");
        model.setModelSize(scanner.nextLine());
        System.out.println("");
        System.out.printf("Введите фирму обуви: ");
        model.setShoeFirm(scanner.nextLine());
        System.out.println("");
        System.out.printf("Введите цену обуви: ");
        model.setPrice(scanner.nextFloat());
            
        models.add(model);
        keeper.saveModels(models);
        
        return model;

    }
    private Client addClient(){
        Client client = new Client();
        System.out.printf("Введите имя клиента: ");
        client.setFirstName(scanner.nextLine());
        System.out.println("");
        System.out.printf("Введите фамилию клиента: ");
        client.setLastName(scanner.nextLine());
        System.out.println("");
        System.out.printf("Введите номер телефона клиента: ");
        client.setPhone(scanner.nextLine());
        System.out.println("");
        System.out.printf("Введите количество денег клиента: ");
        client.setMoney(scanner.nextFloat());scanner.nextLine();
        System.out.println("=================================");

        clients.add(client);
        keeper.saveClients(clients);
        
        return client;
    }
        
        
        private History addHistory(){
            History histories1 = new History();
            System.out.println("Список обуви: ");
            for (int i = 0; i < gains.size(); i++) {
                gain=gains.get(i).getAllMoney();
            }
            for (int i = 0; i < models.size(); i++) {
                if(models.get(i)!=null){
                    System.out.println(models.get(i).toString());
                }
            }
            System.out.println("Введите номер обуви: ");
            int numberModel = scanner.nextInt();scanner.nextLine();
            for (int i = 0; i < clients.size(); i++) {
                if(clients.get(i) != null){
                    System.out.println(clients.get(i).toString());
                }
            }
            System.out.println("Введите номер клиента: ");
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
                System.out.println("Недостаточно средств!");
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
            break;
            }
        }
        
        private void printListClients(){
            for (int i = 0; i < clients.size(); i++) {
                if(clients.get(i) != null){
                    System.out.println(clients.get(i).toString());
                }
            break;
            }
        }
        
        private void AllCash(){
            for (int i = 0; i < gains.size(); i++) {
                gains.get(i).setAllMoney(gain);
                keeper.saveGains(gains);
            }
        }
}