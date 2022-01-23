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
    String[] months = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентебрь", "октябрь", "ноябрь", "декабрь"};


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
                    System.out.println("Всего доброго!!!");
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
        model.setPrice(scanner.nextDouble());
        System.out.println("================================");
            
        modelFacade.create(model);
        //models.add(model);
        //keeper.saveModels(models);
        
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
        client.setMoney(scanner.nextDouble());
        System.out.println("=================================");

        clientFacade.create(client);
        //clients.add(client);
        //keeper.saveClients(clients);

        return client;
    }
        
        
        
    
        private History addHistory(){
            History histories1 = new History();
            System.out.println("Список обуви: ");
            List<Model> models = modelFacade.findAll();
            for (int i = 0; i < models.size(); i++) {
                if(models.get(i)!=null){
                    System.out.println(i+1 + "-" + "Название модели - " + models.get(i).getModelName()+ System.lineSeparator() +
                            "Размер - " + models.get(i).getModelSize() + System.lineSeparator() + 
                            "Фирма - " + models.get(i).getShoeFirm() + System.lineSeparator() +
                            "Цена - " + models.get(i).getPrice());
                    System.out.println("=================================");
                }
            }
            System.out.println("Введите номер обуви: ");
            int numberModel = scanner.nextInt();scanner.nextLine();
            List<Client> clients = clientFacade.findAll();
            for (int i = 0; i < clients.size(); i++) {
                if(clients.get(i) != null){
                    System.out.println(i+1 + "-" + "Имя - " + clients.get(i).getFirstName() + System.lineSeparator() +
                            "Фамилия - " + clients.get(i).getLastName() + System.lineSeparator() +
                            "Номер телефона - " + clients.get(i).getPhone() + System.lineSeparator() +
                            "Количество денежных средств - " + clients.get(i).getMoney());
                }
            }
            System.out.println("Введите номер клиента: ");
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
                System.out.println("Модель " + models.get(numberModel-1).getModelName() + " " +
                        "продана" + " " + clients.get(numberModel-1).getFirstName() + " " +
                        clients.get(numberModel-1).getLastName());
            }
            else{
                System.out.println("Недостаточно средств!");
                
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
                    System.out.println("В продаже нет ни одной обуви.");
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
                    System.out.println("Список клиентов пуст...");
                }
            }
            System.out.println("=============================================");
        }
        
        
        
        
        
        private void printListAllCash(){
            List<Gain> gains = gainFacade.findAll();
            for (int i = 0; i < gains.size(); i++) {
                if(gain != 0){
                    System.out.println("Доход магазина за все время работы: " + gain + " доллара");
                    break;
                }
                else{
                    System.out.println("Магазин пока что ничего не заработал");
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
            System.out.println("Какую модель вы хотите изменить?");
            printListModels();
            System.out.println("==============================================");
            System.out.println("Выберите модель по её ID:");
            int choice = scanner.nextInt();
            long number = scanner.nextLong();
            Model models = modelFacade.find(number);
            if(choice == models.getId()){
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
                        models.setModelName(scanner.nextLine());
                        modelFacade.edit(models);
                        //keeper.saveModels(models);
                        break;
                    case 2:
                        System.out.println("Задайте новый размер модели");
                        models.setModelSize(scanner.nextLine());
                        modelFacade.edit(models);
                        //keeper.saveModels(models);
                        break;
                    case 3:
                        System.out.println("Задайте новую цену модели");
                        models.setPrice(scanner.nextDouble());scanner.nextLine();
                        modelFacade.edit(models);
                        //keeper.saveModels(models);
                        break;
                    case 4:
                        System.out.println("Задайте новую фирму обуви");
                        models.setShoeFirm(scanner.nextLine());
                        modelFacade.edit(models);
                        //keeper.saveModels(models);
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
        
        
        
        
        
        private void changeClient(){
            System.out.println("Какого клиента вы хотите изменить?");
            printListClients();
            System.out.println("Выберите клиента по его ID:");
            long number = scanner.nextLong();scanner.nextLine();
            Client clients = clientFacade.find(number);
            if(number == clients.getId()){

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
                        clients.setFirstName(scanner.nextLine());
                        clientFacade.edit(clients);
                        //keeper.saveClients(clients);
                        break;
                    case 2:
                        System.out.println("Задайте новую Фамилию клиенту");
                        clients.setLastName(scanner.nextLine());
                        clientFacade.edit(clients);
                        //keeper.saveClients(clients);
                        break;
                    case 3:
                        System.out.println("Задайте новый немер телефона клиенту");
                        clients.setPhone(scanner.nextLine());
                        clientFacade.edit(clients);
                        //keeper.saveClients(clients);
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
   
        
        
        
        
        
        private void addMoney(){
            System.out.println("Кому вы хотите добавить денег?");
            printListClients();
            System.out.println("Выберите клиента по его ID:");
            int choice4 = scanner.nextInt();
            long number = scanner.nextLong();
            Client clients = clientFacade.find(number);
            if(choice4 == clients.getId()){
                System.out.println("Введите сумму, которую хотите добавить клиенту:");
                double givemoney = scanner.nextDouble();scanner.nextLine();
                clients.setMoney(clients.getMoney() + givemoney);
                System.out.println("-----------------");
                System.out.println("Теперь у клиента "+clients.getMoney()+" долларов");
                System.out.println("===================================");
            }
            else{
                System.out.println("Такого клиента не существует!");
            }
                
            //keeper.saveClients(clients);
            clientFacade.edit(clients);
        }
        
        
        
        
        private void gainForAMonth(){
            System.out.println("Введите месяц, за который вывести весь доход на экран:");
            int month = scanner.nextInt();
            System.out.println("===============================");
            double monthGain = 0;
            long number = scanner.nextLong();
            History histories = historyFacade.find(number);
            if (histories.getBuy().getMonth()+1 == month) {
                monthGain += histories.getModel().getPrice();
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