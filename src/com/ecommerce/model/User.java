package com.ecommerce.model;

import java.util.*;
import java.util.concurrent.Semaphore;

class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String phone;

    User(int userId, String name, String email, String password, String phone) {
        //Userid
        if (userId <= 0) {
            throw new IllegalArgumentException("Invalid Userid");
        }
        this.userId = userId;
        //Name
        if (name == null || name.length() <= 3) {
            throw new IllegalArgumentException("User name contains Name");
        }
        for (char na : name.toCharArray()) {
            if (!Character.isLetter(na)) {
                throw  new IllegalArgumentException("Name should contains only letters");
            }
        }
        this.name = name;

        //    * email: valid format (contains @, ends with .com/.edu)
        if (!email.contains("@") || (!email.endsWith(".com") && !email.endsWith(".edu"))){
            throw new IllegalArgumentException("Invalid email id ");
        }
        this.email=email;

//        * password: length >= 8, contains uppercase, lowercase, digit, special char
        if(password.length()<8){
            throw  new IllegalArgumentException("Password should contains minimum of 8 characters");
        }
        boolean hasUpperCase=false;
        boolean hasLowerCase=false;
        boolean hasDigit=false;
        boolean hasSpecialChar=false;

       for(char pa:password.toCharArray()){
           if(Character.isUpperCase(pa)) hasUpperCase=true;
           if(Character.isLowerCase(pa)) hasLowerCase=true;
           if(Character.isDigit(pa)) hasDigit=true;
           if(!Character.isLetterOrDigit(pa)) hasSpecialChar= true;
       }
      if(!hasUpperCase||!hasDigit||!hasLowerCase||!hasSpecialChar){
          throw  new IllegalArgumentException("Password must contain uppercase, lowercase, digit, specialchar");
      }
      this.password=password;

      if(phone.length()<10){
          throw new IllegalArgumentException("Phone number contains minimum 10 digit");
      }
      for(char ch: phone.toCharArray()){
          if(!Character.isDigit(ch)){
              System.out.println(" In valid Phone number");
          }
      }
      this.phone=phone;

     }

//setters and getters
    public void setUserId(int userId){
        if (userId <= 0) {
            throw new IllegalArgumentException("Invalid Userid");
        }
        this.userId = userId;
    }
    public int getUserId(){
        return  userId;
    }

    public void setName(String name){
        if (name == null || name.length() <= 3) {
            throw new IllegalArgumentException("User name contains Name");
        }
        for (char na : name.toCharArray()) {
            if (!Character.isLetter(na)) {
                throw  new IllegalArgumentException("Name should contains only letters");
            }
        }
        this.name = name;

    }
    public  String getName(){
        return name;
    }
    public void setEmail(String email){
        if (!email.contains("@") || (!email.endsWith(".com") && !email.endsWith(".edu"))){
            throw new IllegalArgumentException("Invalid email id ");
        }
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setPassword(String password){
        if(password.length()<8){
            throw  new IllegalArgumentException("Password should contains minimum of 8 characters");
        }
        boolean hasUpperCase=false;
        boolean hasLowerCase=false;
        boolean hasDigit=false;
        boolean hasSpecialChar=false;

        for(char pa:password.toCharArray()){
            if(Character.isUpperCase(pa)) hasUpperCase=true;
            if(Character.isLowerCase(pa)) hasLowerCase=true;
            if(Character.isDigit(pa)) hasDigit=true;
            if(!Character.isLetterOrDigit(pa)) hasSpecialChar= true;
        }
        if(!hasUpperCase||!hasDigit||!hasLowerCase||!hasSpecialChar){
            throw  new IllegalArgumentException("Password must contain uppercase, lowercase, digit, specialchar");
        }
        this.password=password;
    }

    public String getPassword(){
        return password;
    }
    public void setPhone(String  phone){
        if(phone.length()<10){
            throw new IllegalArgumentException("Phone number contains minimum 10 digit");
        }
        for(char ch: phone.toCharArray()){
            if(!Character.isDigit(ch)){
                System.out.println(" In valid Phone number");
            }
        }
        this.phone=phone;

    }
    public String getPhone(){
        return phone;
    }

@Override
    public String toString(){
        return "User{ "+
                "userId="+userId+
                ", name= '"+name+ '\''+
                ",email= '"+email+ '\''+
                ",password= '***' "+
                "' phone' "+phone +'\''+
                '}';
}
}
