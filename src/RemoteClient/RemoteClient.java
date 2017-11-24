/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemoteClient;

import Interface.RemoteLogin;
import Interface.RemoteShop;
import Shop.Product;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XXXXXX
 */
public class RemoteClient {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry(123);
            Registry reg2 = LocateRegistry.getRegistry(321);
            RemoteShop shop = (RemoteShop) reg.lookup("RemoteShop");
            RemoteLogin login = (RemoteLogin) reg2.lookup("RemoteLogin");
            User userApp = null;
            Scanner scn = new Scanner(System.in);
            while(true){
                System.out.println("------------------------WELCOME------------------------");
                System.out.println("Enter your username");
                String user = scn.nextLine();
                System.out.println("Enter your password");
                String password = scn.nextLine();
                
                userApp = login.doLogin(user, password);
                
                if(userApp!=null){
                    if(userApp instanceof Client){
                        Client myClient = (Client) userApp;
                        while (true) {
                            System.out.println("------------------------WELCOME " + myClient.getName() + "------------------------");
                            System.out.println("Options:");
                            System.out.println("1 - Purchase product");
                            System.out.println("2 - View shop products");
                            System.out.println("3 - View my products");
                            System.out.println("0 - Exit");
                            System.out.println("Choise an option:");
                            int option = scn.nextInt();
                            scn.nextLine();
                            switch (option) {
                                case 1:
                                    System.out.println("Type it the product name");
                                    String productName = scn.nextLine();
                                    myClient.sellProduct(shop, productName);
                                    break;
                                case 2:
                                    myClient.showProducts(shop);
                                    break;
                                case 3:
                                    myClient.showMyProducts();
                                    break;
                                case 0:
                                    System.exit(0);
                                default:
                                    System.out.println("Invalid option");
                            }
                        }
                    }else if(userApp instanceof Administrator){
                        Administrator adm = (Administrator) userApp;
                        while(true){
                            System.out.println("------------------------WELCOME " + adm.getName() + "------------------------");
                            System.out.println("Options:");
                            System.out.println("1 - Insert product");
                            System.out.println("2 - View shop products");
                            System.out.println("3 - Alter product");
                            System.out.println("4 - Delete product");
                            System.out.println("0 - Exit");
                            System.out.println("Choise an option:");
                            int option = scn.nextInt();
                            switch(option){
                                case 1:
                                    adm.insertProduct(shop);
                                    break;
                                case 2:
                                    adm.showProducts(shop);
                                    break;
                                case 3:
                                    adm.alterProduct(shop);
                                    break;
                                case 4:
                                    adm.removeProduct(shop);
                                    break;
                                case 0:
                                    System.exit(0);
                                default:
                                    System.out.println("Invalid option");
                            }
                        }
                        
                    }
                }else{
                    System.out.println("This Client does not exist");
                }
                
            }
            
        } catch (NotBoundException | RemoteException ex) {
            Logger.getLogger(RemoteClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
