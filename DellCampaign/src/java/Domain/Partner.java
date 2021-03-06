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
    private String phone;

    /*
    Partner object that contains
    id: Partner ID
    name: Partner Name
    dateCreated: date added to the database
    password: Partner password
    email: Partner email
    phone: Partner phone number
    */
    
    

    public Partner() {
    }

    public Partner(String id, String name, String dateCreated, String password) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Partner{" + "id=" + id + ", name=" + name + ", dateCreated=" + dateCreated + ", password=" + password + ", email=" + email + ", phone=" + phone + '}';
    }
    
    
}
