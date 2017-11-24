/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemoteClient;

import Interface.RemoteLogin;
import Interface.RemoteShop;
import Shop.Product;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author XXXXXX
 */
public class Administrator extends User implements Serializable {

    public Administrator(String user, String password) {
        this.setUser(user);
        this.setPassword(password);
    }

    public Administrator(String name, String user, String password) {
        this(user,password);
        this.setName(name);
    }

     
    public void showProducts(RemoteShop shop) throws RemoteException{
        System.out.println("-----------------------------------------");
        for(Product product:shop.getProducts()){
            System.out.println(product.toString());
        }
        System.out.println("-----------------------------------------");
    }
    
    public void insertProduct(RemoteShop shop) throws RemoteException{
        Scanner scn = new Scanner(System.in);
        Product p = null;
        System.out.println("Type it the name product");
        String name = scn.nextLine();
        System.out.println("Type it the value of product");
        float value = scn.nextFloat();
        System.out.println("Type it the number of this product");
        int qtd = scn.nextInt();
        p=new Product(name,value);
        shop.insertProduct(p, qtd);
    }
    
    public void alterProduct(RemoteShop shop) throws RemoteException{
        Scanner scn = new Scanner(System.in);
        System.out.println("Type it the name of product");
        String name = scn.nextLine();
        System.out.println("Type it the new value of this product");
        float value = scn.nextFloat();
        shop.alterProduct(name, value);
    }
    
    public void removeProduct(RemoteShop shop) throws RemoteException{
        Scanner scn = new Scanner(System.in);
        System.out.println("Type it the name of product");
        String name = scn.nextLine();
        shop.removeProduct(name);
    }
}
