/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shop;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author XXXXXX
 */
public class Product implements Serializable {
    
    private String name;
    private float value;
    
    public Product(){
        super();
    }
    
    public Product(String name,float value){
        this.setName(name);
        this.setValue(value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
    
    @Override
    public String toString(){
        return "Product name:"+this.name+" Value:"+this.value;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    
}
