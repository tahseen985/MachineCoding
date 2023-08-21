package DesignKeyValuePair.Controller;

import DesignKeyValuePair.Enum.Methods;
import DesignKeyValuePair.Repository.KeyValueRepo;
import DesignKeyValuePair.Service.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KeyValueRepo keyValueRepo = new KeyValueRepo();
        Service service = new Service(keyValueRepo);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            String[] splited = str.split(" ");
            String expression = splited[0];
            Methods methods = Methods.valueOf(expression);
            switch (methods) {
                case put:
                    try {
                        service.put(splited);
                    } catch (Exception e) {
                        System.out.println("Data Type Error");
                    }
                    break;
                case get:
                    service.get(splited);
                    break;
                case delete:
                    service.delete(splited);
                    break;
                case search:
                    service.search(splited);
                    break;
                case keys:
                    service.getKeys();
                    break;
                case exit:
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
