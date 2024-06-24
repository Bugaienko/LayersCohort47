package repository;
/*
@date 24.06.2024
@author Sergey Bugaienko
*/

import model.User;
import util.MagicList;
import util.MyList;

public class UserRepository {

    private final MyList<User> users;

    public UserRepository() {
        this.users = new MagicList<>();
    }

    public User addUser(String email, String password) {
        User user = new User(email, password);
        users.add(user);
        return user;
    }

    public boolean isEmailExists(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    public MyList<User> getAllUsers() {
        // Надо бы создать копию списка
        return users;
    }
}
