/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Interface.RemoteLogin;
import RemoteClient.Administrator;
import RemoteClient.Client;
import RemoteClient.User;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author XXXXXX
 */
public class Login extends UnicastRemoteObject implements RemoteLogin {
    
    private ArrayList<Client> clients;
    private ArrayList<Administrator> administrators;
    
    private User userLogged = null;
    
    public Login() throws RemoteException{
        super();
        this.clients = new ArrayList<>();
        this.administrators = new ArrayList<>();
        this.initializeUsers();
    }

    
    private void initializeUsers() {
        this.clients.add(new Client("user1","pass1",40,"Jhon"));
        this.clients.add(new Client("user2","pass2",60,"Mary"));
        this.clients.add(new Client("user3","pass3",30,"Mertzek"));
        this.clients.add(new Client("user4","pass4",3,"Hasmussem"));
        
        this.administrators.add(new Administrator("Robert","adm1","adm1"));
        this.administrators.add(new Administrator("Carl","adm2","adm2"));
    }

//    @Override
//    public Client doLogin(Client client) throws RemoteException {
//        int indexClient = this.clients.indexOf(client);
//        return this.clients.get(indexClient);
//    }

    @Override
    public boolean validateLogin(String user, String password) throws RemoteException {
        for(Client c:this.clients){
            if(c.getUser().equals(user)&&c.getPassword().equals(password)){
                this.userLogged = c;
                return true;
            }
        }
        for(Administrator a:this.administrators){
            if(a.getUser().equals(user)&&a.getPassword().equals(password)){
                this.userLogged = a;
                return true;
            }
        }
        return false;
    }

   

    @Override
    public User doLogin(String user, String password) throws RemoteException {
        if(this.validateLogin(user, password)){
            return this.userLogged;
        }else{
            return null;
        }
    }

    
    
}
