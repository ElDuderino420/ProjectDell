/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author butwhole
 */
public class Partner {
    private String id,name,dateCreated,password,email;
    int phone;

    /*
    Partner object that contains
    id: Partner ID
    name: Partner Name
    dateCreated: date added to the database
    password: Partner password
    email: Partner email
    phone: Partner phone number
    */
    
    public Partner(String id, String name, String dateCreated, String password, String email, int phone) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    
}
