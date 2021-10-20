package jptv20_shoestore_dzjubenko;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import myclasses.Client;
import myclasses.History;
import myclasses.Model;


public class Store {
    Scanner scanner = new Scanner(System.in);
    float gain = 0;
    private Model[] model = new Model[10];
    private Client[] client = new Client[10];
    private History[] histories = new History[10];
    public void run() {
        String repeat = "r";
        do{
            System.out.println("Задача - 0: Выход из программы");
            System.out.println("Задача - 1: Добавить Обувь");
            System.out.println("Задача - 2: Список обуви");
            System.out.println("Задача - 3: Ввод информации о клиенте");
            System.out.println("Задача - 4: Информация о клиенте");
            System.out.println("Задача - 5: Выдать обувь");
            System.out.println("Задача - 6: Список выданной обуви");
            System.out.printf("Выберите номер задачи: ");
            int task = scanner.nextInt();scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = "d";
                    System.out.println("Пока!");
                    break;
                case 1:
                    System.out.println("---- Добавление обуви ----");
                    for (int i = 0; i < model.length; i++) {
                        if(model[i] == null){
                            model[i] = addModel();
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("---- Список обуви -----");
                    for (int i = 0; i < model.length; i++) {
                        if(model[i] != null){
                            System.out.println(model[i].toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("---- Ввод информация о клиенте ----");
                    for (int i = 0; i < client.length; i++) {
                        if(client[i] == null){
                            client[i] = addClient();
                            break;
                        }
                    }
                case 4:
                    System.out.println("----- Клиент -----");
                    for (int i = 0; i < client.length; i++) {
                        if(client[i] != null){
                            System.out.println(client[i].toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("------ Продать обувь ------");
                    for (int i = 0; i < client.length; i++) {
                        if(histories[i] == null){
                            histories[i] = addHistory();
                            break;
                        }

                    }
                    break; 
                case 6:
                    System.out.println("----- Доход магазина -----");                    
                    System.out.println(gain);
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
            
            return client;
        }
        
        
        private History addHistory(){
            History histories1 = new History();
            System.out.println("Список обуви: ");
            for (int i = 0; i < model.length; i++) {
                if(model[i]!=null){
                    System.out.println(model[i].toString());
                }
            }
            System.out.println("Введите номер обуви: ");
            int numberModel = scanner.nextInt();scanner.nextLine();
            for (int i = 0; i < client.length; i++) {
                if(client[i] != null){
                    System.out.println(client[i].toString());
                }
            }
            System.out.println("Введите номер клиента: ");
            int numberClient = scanner.nextInt();scanner.nextLine();
            histories1.setModel(model[numberModel - 1]);
            histories1.setClient(client[numberClient - 1]);
            Calendar c = new GregorianCalendar();
            float MMoney = model[numberClient-1].getPrice();
            float CMoney = client[numberClient-1].getMoney();
            float finMoney = 0;
            if(CMoney >= MMoney){
                finMoney = CMoney - MMoney;   
                client[numberClient-1].setMoney(client[numberClient-1].getMoney()-model[numberClient-1].getPrice());
                gain += model[numberModel-1].getPrice();        
            }else{
                System.out.println("Недостаточно средств!");
            }            
            
            
            return histories1;
        }
}