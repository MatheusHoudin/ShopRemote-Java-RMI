/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import RemoteClient.Client;
import Shop.Product;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author XXXXXX
 */
public interface RemoteShop extends Remote {
    
    public Product sellProduct(String name,Client cl) throws RemoteException;
    
    public ArrayList<Product> getProducts() throws RemoteException;
    
    public void insertProduct(Product product,int qtd) throws RemoteException;
    
    public void alterProduct(String nameProduct,float newValue) throws RemoteException;
    
    public void removeProduct(String nameProduct) throws RemoteException;
    
}
