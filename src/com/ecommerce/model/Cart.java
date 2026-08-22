package com.ecommerce.model;
import java.util.*;
class Cart{
 private int cartId ;
 private static  int cartCounter=1000;
 private List<CartItem>items;
 private int userId;

 class CartItem{
     private Product product;
     private int quantity;

  CartItem(Product product,int quantity) {
      this.product = product;
      this.quantity = quantity;
  }
  public  Product  getProduct(){
      return product;
  }
  public int getQuantity(){
      return quantity;
  }
  public int getuserId(){
     return userId;
  }
  public  void setQuantity(int quantity){
      this.quantity=quantity;
  }

  }
  public Cart(int userId){
     if(userId<0){
         throw  new IllegalArgumentException("Invalid userid");
     }
     this.cartId=++cartCounter;
     this.userId=userId;
     this.items= new ArrayList<>();
  }


    public void addProduct(Product product,int quantity){
     if(product==null|| quantity<=0){
         throw new IllegalArgumentException("Invalid product");
     }
     for(CartItem item: items){
         if(item.getProduct().equals(product)){
             item.setQuantity(item.getQuantity()+quantity);
               return;
         }
     }
      items.add(new CartItem(product,quantity));
  }

   public void removeProduct(int productId){
     for(CartItem item:items){
        if(item.getProduct().getProductId()==productId){
            items.remove(item);
            System.out.println("Product remove form the cart");
            return;

        }
     }
       System.out.println("Product not found in the cart");
   }

public double getCartTotal(){
   double sum=0;
  for(CartItem item:items){
     sum+= item.getProduct().getPrice()*item.getQuantity();
  }
  return sum;
 }

 public int getItemCount(){
     return items.size();
    }

public void displayCart(){
    if (items.isEmpty()) {
        System.out.println("Cart is empty");
        return;
    }

    System.out.println("=== Cart Items ===");
    for (CartItem item : items) {
        double subtotal = item.getProduct().getPrice() * item.getQuantity();
        System.out.println("Product: " + item.getProduct().getName() +
                ", Price: " + item.getProduct().getPrice() +
                ", Quantity: " + item.getQuantity() +
                ", Subtotal: " + subtotal);
    }
    System.out.println("Cart Total: " + getCartTotal());
}
 public int getCartId(){
     return cartId;
}

public int getUserId(){
     return userId;
}
public List<CartItem> getItems(){

    return items;
}

}

