package hw3plus;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        data.add(user);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logoutAllUsersExceptAdmins() {
        for (User user : data) {
            if (!user.getIsAdmin()) {
                user.isAuthenticate = false;
            }
        }
    }
}
