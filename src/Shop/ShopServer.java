/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shop;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XXXXXX
 */
public class ShopServer {
    public static void main(String[] args) {
        try {
            Shop shop = new Shop();
            Registry reg = LocateRegistry.createRegistry(123);
            reg.bind("RemoteShop", shop);
        } catch (RemoteException | AlreadyBoundException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
