/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor_appointment_booking_system;

/**
 *
 * @author Labasan
 */
public class AdminData {
    private int accountID;
    private String firstname, lastname, username,contact, email;
    
    public AdminData(int accID, String fname, String lname, String contact, String email){
        this.accountID = accID;
        this.firstname = fname;
        this.lastname = lname;
        this.contact = contact;
        this.email = email;
       // this.username = user;
    }
    
    public int getAccountID(){
        return accountID;
    }
    public String getFirstname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public String getContact(){
        return contact;
    }
    public String getEmail(){
        return email;
    }
    public String getUsername(){
        return username;
    }
    
    
    public void setAccountID(int accID){
        this.accountID = accID;
    }
    public void setFirstname(String fname){
        this.firstname = fname;
    }
    public void setLastname(String lname){
        this.lastname = lname;
    }
    public void setContact(String contact){
        this.contact = contact;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setUsername(String user){
        this.username = user;
    }
    
    
}
