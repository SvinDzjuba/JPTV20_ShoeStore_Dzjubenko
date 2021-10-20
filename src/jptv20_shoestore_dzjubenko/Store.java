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
            System.out.println("������ - 0: ����� �� ���������");
            System.out.println("������ - 1: �������� �����");
            System.out.println("������ - 2: ������ �����");
            System.out.println("������ - 3: ���� ���������� � �������");
            System.out.println("������ - 4: ���������� � �������");
            System.out.println("������ - 5: ������ �����");
            System.out.println("������ - 6: ������ �������� �����");
            System.out.printf("�������� ����� ������: ");
            int task = scanner.nextInt();scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = "d";
                    System.out.println("����!");
                    break;
                case 1:
                    System.out.println("---- ���������� ����� ----");
                    for (int i = 0; i < model.length; i++) {
                        if(model[i] == null){
                            model[i] = addModel();
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("---- ������ ����� -----");
                    for (int i = 0; i < model.length; i++) {
                        if(model[i] != null){
                            System.out.println(model[i].toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("---- ���� ���������� � ������� ----");
                    for (int i = 0; i < client.length; i++) {
                        if(client[i] == null){
                            client[i] = addClient();
                            break;
                        }
                    }
                case 4:
                    System.out.println("----- ������ -----");
                    for (int i = 0; i < client.length; i++) {
                        if(client[i] != null){
                            System.out.println(client[i].toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("------ ������� ����� ------");
                    for (int i = 0; i < client.length; i++) {
                        if(histories[i] == null){
                            histories[i] = addHistory();
                            break;
                        }

                    }
                    break; 
                case 6:
                    System.out.println("----- ����� �������� -----");                    
                    System.out.println(gain);
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
            
            return client;
        }
        
        
        private History addHistory(){
            History histories1 = new History();
            System.out.println("������ �����: ");
            for (int i = 0; i < model.length; i++) {
                if(model[i]!=null){
                    System.out.println(model[i].toString());
                }
            }
            System.out.println("������� ����� �����: ");
            int numberModel = scanner.nextInt();scanner.nextLine();
            for (int i = 0; i < client.length; i++) {
                if(client[i] != null){
                    System.out.println(client[i].toString());
                }
            }
            System.out.println("������� ����� �������: ");
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
                System.out.println("������������ �������!");
            }            
            
            
            return histories1;
        }
}