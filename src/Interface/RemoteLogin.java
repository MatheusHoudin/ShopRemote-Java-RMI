/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import RemoteClient.User;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author XXXXXX
 */
public interface RemoteLogin extends Remote {
    public boolean validateLogin(String user,String password) throws RemoteException;
    public User doLogin(String user,String password) throws RemoteException;
}
