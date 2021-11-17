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
    
    String[] months = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентебрь", "октябрь", "ноябрь", "декабрь"};

    
    
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
            System.out.println("Задача - 0: Выход из программы");
            System.out.println("Задача - 1: Добавить Обувь");
            System.out.println("Задача - 2: Список обуви");
            System.out.println("Задача - 3: Ввод информации о клиенте");
            System.out.println("Задача - 4: Список всех клиентов");
            System.out.println("Задача - 5: Выдать обувь");
            System.out.println("Задача - 6: Доход магазина за все время");
            System.out.println("Задача - 7: Изменение информации модели");
            System.out.println("Задача - 8: Изменение информации клиента");
            System.out.println("Задача - 9: Добавление денег клиенту");
            System.out.println("Задача - 10: Доход магазина за определенный месяц");
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
                    System.out.println("---- Добавление клиента ----");
                    addClient();
                    break;
                case 4:
                    System.out.println("----- Список клиентов -----");
                    printListClients();
                    break;
                case 5:
                    System.out.println("------ Продать обувь ------");
                    addHistory();
                    break; 
                case 6:
                    System.out.println("----- Доход магазина за все время -----");                    
                    printListAllCash();
                    break;
                case 7:
                    System.out.println("----- Изменить модель -----");
                    changeModel();
                    break;
                case 8:
                    System.out.println("----- Изменить клиента -----");
                    changeClient();
                    break;
                case 9:
                    System.out.println("----- Добавить денег клиенту -----");
                    addMoney();
                    break;
                case 10:
                    System.out.println("----- Доход за определенный месяц -----");
                    gainForAMonth();
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
        System.out.printf("Введите размер обуви в US: ");
        model.setModelSize(scanner.nextLine());
        System.out.printf("Введите фирму обуви: ");
        model.setShoeFirm(scanner.nextLine());
        System.out.printf("Введите цену обуви: ");
        model.setPrice(scanner.nextFloat());
        System.out.println("================================");
            
        models.add(model);
        keeper.saveModels(models);
        
        return model;

    }
    private Client addClient(){
        Client client = new Client();
        System.out.printf("Введите имя клиента: ");
        client.setFirstName(scanner.nextLine());
        System.out.printf("Введите фамилию клиента: ");
        client.setLastName(scanner.nextLine());
        System.out.printf("Введите номер телефона клиента: ");
        client.setPhone(scanner.nextLine());
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
            float MMoney = models.get(numberModel-1).getPrice();
            float CMoney = clients.get(numberClient-1).getMoney();
            if(CMoney >= MMoney){
                clients.get(numberClient-1).setMoney(clients.get(numberClient-1).getMoney()-models.get(numberModel-1).getPrice());
                gain += models.get(numberModel-1).getPrice();
                AllCash.setAllMoney(gain);
                histories1.setBuy(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                AllCash();
            }else{
                System.out.println("Недостаточно средств!");
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
                    System.out.println("В продаже нет ни одной обуви.");
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
                    System.out.println("Список клиентов пуст...");
                }
            }
            System.out.println("=============================================");
        }
        
        
        
        
        
        private void printListAllCash(){
            for (int i = 0; i < gains.size(); i++) {
                if(gain != 0){
                    System.out.println("Доход за все время работы: " + gain + " доллара");
                }
                else{
                    System.out.println("Магазин пока что ничего не заработал");
                }
            }
            System.out.println("==========================================");
        }
        
        
        
        
        
        private void AllCash(){
            gains.add(AllCash);    
            keeper.saveGains(gains);
        }
        
        
        
   
              
               
        private void changeModel(){
            System.out.println("Какую модель вы хотите изменить?");
            printListModels();
            System.out.println("==============================================");
            System.out.println("Выберите модель по её ID:");
            int choice = scanner.nextInt();
            for (int i = 0; i < models.size(); i++) {
                if(choice == models.get(i).getId()){

                    System.out.println("Что именно вы хотите изменить?");
                    System.out.println("-------------------------------");
                    System.out.println("1 - изменить Название модели");
                    System.out.println("2 - изменить Размер модели");
                    System.out.println("3 - изменить Цену модели");
                    System.out.println("4 - изменить Фирму модели");
                    System.out.println("-------------------------------");
                    int choice1 = scanner.nextInt();scanner.nextLine();

                    switch(choice1){
                        case 1:
                            System.out.println("Задайте новое название обуви: ");
                            models.get(i).setModelName(scanner.nextLine());
                            keeper.saveModels(models);
                            break;
                        case 2:
                            System.out.println("Задайте новый размер модели");
                            models.get(i).setModelSize(scanner.nextLine());
                            keeper.saveModels(models);
                            break;
                        case 3:
                            System.out.println("Задайте новую цену модели");
                            models.get(i).setPrice(scanner.nextFloat());scanner.nextLine();
                            keeper.saveModels(models);
                            break;
                        case 4:
                            System.out.println("Задайте новую фирму обуви");
                            models.get(i).setShoeFirm(scanner.nextLine());
                            keeper.saveModels(models);
                            break;
                        default:
                            System.out.println("ВВЕДИТЕ НОМЕР ИЗ СПИСКА");
                        break;
                    }
                    System.out.println("==================================");
                }
                else{
                    System.out.println("Такой обуви не существует!");         
                }
        }
    }
        
        
        
        
        
        private void changeClient(){
            System.out.println("Какого клиента вы хотите изменить?");
            printListClients();
            System.out.println("==============================================");
            System.out.println("Выберите клиента по его ID:");
            int choice2 = scanner.nextInt();
            for (int i = 0; i < clients.size(); i++) {
                if(choice2 == clients.get(i).getId()){

                    System.out.println("Что именно вы хотите изменить?");
                    System.out.println("-------------------------------");
                    System.out.println("1 - изменить Имя клиента");
                    System.out.println("2 - изменить Фамилию клиента");
                    System.out.println("3 - изменить Телефон клиента");
                    System.out.println("-------------------------------");
                    int choice3 = scanner.nextInt();scanner.nextLine();

                    switch(choice3){
                        case 1:
                            System.out.println("Задайте новое Имя клиенту: ");
                            clients.get(i).setFirstName(scanner.nextLine());
                            keeper.saveClients(clients);
                            break;
                        case 2:
                            System.out.println("Задайте новую Фамилию клиенту");
                            clients.get(i).setLastName(scanner.nextLine());
                            keeper.saveClients(clients);
                            break;
                        case 3:
                            System.out.println("Задайте новый немер телефона клиенту");
                            clients.get(i).setPhone(scanner.nextLine());
                            keeper.saveClients(clients);
                            break;
                        default:
                            System.out.println("ВВЕДИТЕ НОМЕР ИЗ СПИСКА");
                        break;
                    }
                    System.out.println("==================================");
                }
                else{
                    System.out.println("Такого клиента не существует!");         
                }
            }
        }
   
        
        
        
        
        
        private void addMoney(){
            System.out.println("Кому вы хотите добавить денег?");
            printListClients();
            System.out.println("Выберите клиента по его ID:");
            int choice4 = scanner.nextInt();
            
            for (int i = 0; i < clients.size(); i++) {
                if(choice4 == clients.get(i).getId()){
                    System.out.println("Введите сумму, которую хотите добавить клиенту:");
                    float givemoney = scanner.nextFloat();scanner.nextLine();
                    clients.get(i).setMoney(clients.get(i).getMoney() + givemoney);
                    System.out.println("-----------------");
                    System.out.println("Теперь у клиента "+clients.get(i).getMoney()+" долларов");
                    System.out.println("===================================");
                    break;
                }
                else{
                    System.out.println("Такого клиента не существует!");
                }
                
            }
            keeper.saveClients(clients);
        }
        
        
        
        
        private void gainForAMonth(){
            System.out.println("Введите месяц, за который вывести весь доход на экран:");
            int month = scanner.nextInt();
            System.out.println("===============================");
            float monthGain = 0;
            for (int i = 0; i < histories.size(); i++) {
                if (histories.get(i).getBuy().getMonth()+1 == month) {
                    monthGain += histories.get(i).getModel().getPrice();
                } 
            }
            if (monthGain != 0) {
               System.out.println("Доход магазина за " + months[month-1] + ": " + monthGain + " долларов"); 
            }
            else{
                System.out.println("Доход за " + months[month-1] + " нулевой...");
            }
            System.out.println("===============================");
        }
}           