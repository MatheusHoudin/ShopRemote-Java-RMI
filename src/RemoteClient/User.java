/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemoteClient;

import java.io.Serializable;

/**
 *
 * @author XXXXXX
 */
public class User implements Serializable {
    private String user;
    private String password;
    private String name;
    
    public User(){
        super();
    }
    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
