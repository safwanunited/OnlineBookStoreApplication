package com.revature.bookproject.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="delivery")
public class DeliveryMan {
    @Id
    @GeneratedValue
    private int id;
    @Column(name="userName")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    public DeliveryMan() {
        super();
        // TODO Auto-generated constructor stub
    }
    public DeliveryMan(String userName, String password, String email) {
        super();
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
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
    @Override
    public String toString() {
        return "DeliveryMan [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + "]";
    }
    
    
}