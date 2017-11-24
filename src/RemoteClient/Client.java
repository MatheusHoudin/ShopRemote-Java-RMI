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
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author XXXXXX
 */
public class Client extends User implements Serializable {
    private float money;
    private ArrayList<Product> products;

    public Client(){
        this.setProducts(new ArrayList<>());
    }
    public Client(float money){
        this();
        this.setMoney(money);
    }

    public Client(String user, String password, float money,String name) {
        this(money);
        this.setUser(user);
        this.setPassword(password);
        this.setName(name);
    }
    
      public Client(String user, String password) {
        this.setUser(user);
        this.setPassword(password);
    }
    
    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode()==obj.hashCode(); 
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.getUser());
        hash = 89 * hash + Objects.hashCode(this.getPassword());
        return hash;
    }

    public int doLogin(RemoteLogin login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void showProducts(RemoteShop shop) throws RemoteException{
        System.out.println("-----------------------------------------");
        for(Product product:shop.getProducts()){
            System.out.println(product.toString());
        }
        System.out.println("-----------------------------------------");
    }
    public void sellProduct(RemoteShop shop,String productName) throws RemoteException{
        Product p = shop.sellProduct(productName, this);
        if(p!=null){
            this.getProducts().add(p);
            this.setMoney(this.getMoney()-p.getValue());
            System.out.println("Successful purchase");
        }else{
            System.out.println("Unsuccessful purchase");
        }
        System.out.println("Current money: "+this.getMoney());
    }
    
    public void showMyProducts(){
         System.out.println("-----------------------------------------");
        for(Product product:this.products){
            System.out.println(product.toString());
        }
        System.out.println("-----------------------------------------");
    }
    
}
