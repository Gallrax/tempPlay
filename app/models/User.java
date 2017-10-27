package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: 冯冠凯
 * @Description:
 * @Date: Created on 2017/10/26
 * @Version: 1.0
 */
@Entity
@Table(name = "cx_user")
public class User extends Model {

    public String username;
    public String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static User login(String username, String password) {
        return find("byUsernameAndPassword", username, password).first();
    }
}
