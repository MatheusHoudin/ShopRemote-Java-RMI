/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.rmi.AccessException;
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
public class RemoteLogin {
    public static void main(String[] args) {
        try {
            Login login = new Login();
            Registry reg = LocateRegistry.createRegistry(321);
            reg.bind("RemoteLogin", login);
        } catch (RemoteException | AlreadyBoundException ex) {
            Logger.getLogger(RemoteLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
