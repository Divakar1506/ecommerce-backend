package com.ecommerce.model;
//Class: Product
//  - productId (int), name (String), price (double), quantity (int), category (String)
//  - Constructor with validation
//  - Setters/Getters
//  - reduceStock(int amount)
//  - restockProduct(int amount)
//  - getProductValue()
//  - isAvailable()
//  - toString()
import  java.util.*;
class Product{
    private int productId;
    private String name;
    private double price;
    private  int quantity;
    String category;



  Product(int productId,String name,double price, int quantity,String category){
      if(productId<=0){
          throw new IllegalArgumentException("Invalid Product id");
      }
      this.productId=productId;

      if(name==null||name.length()<=3){
          throw new IllegalArgumentException("Invalid Name");
      }
      this.name=name;

      if(price<=0 && price>1000000){
          throw  new IllegalArgumentException("Invalid price");
      }
      this.price=price;

      if(quantity<=0){
          throw new IllegalArgumentException("Quantitiy should be greater than 0");
      }
      this.quantity=quantity;

      if(category==null||category.isEmpty()){
          throw  new IllegalArgumentException("Invalid Category");
      }
      this.category=category;
  }
  public void setProcuctId(int productId){
      if(productId<=0){
          throw new IllegalArgumentException("Invalid Product id");
      }
      this.productId=productId;

  }
  public int getProductId(){
      return productId;
  }
  public  void setName(String name){
      if(name==null||name.length()<=3){
          throw new IllegalArgumentException("Invalid Name");
      }
      this.name=name;
  }
 public String getName(){
      return name;
 }
 public void setPrice(double price){
     if(price<=0 && price>1000000){
         throw  new IllegalArgumentException("Invalid price");
     }
     this.price=price;

  }
  public double getPrice(){
      return  price;
  }
 public void setQuantity(int quantity){
     if(quantity<=0){
         throw new IllegalArgumentException("Quantitiy should be greater than 0");
     }
     this.quantity=quantity;

 }
 public int getQuantity(){
      return quantity;

 }

 public void reduceStock(int amount){
     if(amount<=0){
         throw new IllegalArgumentException("Invalid amount");
     }
      if(quantity <amount){
         throw  new IllegalArgumentException("Insufficient Stock");
     }
      quantity-=amount;
     System.out.println("Stock reduced by" +amount +".New quantity: "+quantity);
 }
 public void restockProduct(int amount){
     if(amount<=0){
         throw new IllegalArgumentException("Invalid amount");
     }
    quantity+=amount;
     System.out.println("New Stock added: "+amount+".New quantity: "+quantity);
 }
 public double getProductValue(){
      return  price*quantity;
 }
 public boolean isAvailable(){
      return quantity>0;
 }

 @Override
  public String toString(){
      return "{Product: "+ "Product Id: ' " +productId
              +'\''+" name: '"+name+ '\''
              + "price: '"+price +'\''
              +"quantity: '"+quantity +'\''
              +"category: '"+category+ '\''+'}';

}
}
