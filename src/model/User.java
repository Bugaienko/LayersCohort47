package model;
/*
@date 24.06.2024
@author Sergey Bugaienko
*/

import util.MagicList;
import util.MyList;

public class User {
    private String email;
    private String password;
    private final MyList<Car> userCars;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.userCars = new MagicList<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", userCars=" + userCars +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MyList<Car> getUserCars() {
        return userCars;
    }
}
