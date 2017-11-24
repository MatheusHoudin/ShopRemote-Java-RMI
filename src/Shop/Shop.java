/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shop;

import Interface.RemoteShop;
import RemoteClient.Client;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author XXXXXX
 */
public class Shop extends UnicastRemoteObject implements RemoteShop {
    private ArrayList<Product> products;
    
    public Shop() throws RemoteException{
        super();
        this.createProducts();
    }
    @Override
    public Product sellProduct(String name, Client cl) throws RemoteException {
        Product p = this.findProductOnShop(name);
        if(p!=null && p.getValue()<=cl.getMoney()){
            cl.setMoney(cl.getMoney()-p.getValue());
            this.products.remove(p);
            return p;
        }
        return null;
    }

    @Override
    public ArrayList<Product> getProducts() throws RemoteException {
        return this.products;
    }
    
    private void createProducts(){
        this.products = new ArrayList<>();
        this.products.add(new Product("Ball",10));
        this.products.add(new Product("Racket",5));
        this.products.add(new Product("Apple",2));
        this.products.add(new Product("Shirt",20));
        this.products.add(new Product("Hat",17));
        this.products.add(new Product("Door",60));
    }
    
    private Product findProductOnShop(String nameProduct){
        for(Product p:this.products){
            if(p.getName().equals(nameProduct)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void insertProduct(Product product,int qtd) throws RemoteException {
        if(qtd>0){
            for(;qtd!=0;qtd--){
                this.products.add(product);
            }
        }
    }

    @Override
    public void alterProduct(String nameProduct,float newValue) throws RemoteException {
        for(Product p:this.products){
            if(p.getName().equals(nameProduct)){
                p.setValue(newValue);
                break;
            }
        }
    }

    @Override
    public void removeProduct(String nameProduct) throws RemoteException {
        for(Iterator<Product> it = this.products.iterator();it.hasNext();){
            Product p = it.next();
            if(p.getName().equals(nameProduct)){
                it.remove();
            }
        }
    }

    
}
