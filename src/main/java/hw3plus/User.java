package hw3plus;

public class User {
        String name;
        String password;
        boolean isAdmin = false;
        boolean isAuthenticate = false;

        public User(String name, String password, boolean isAdmin) {
            this.name = name;
            this.password = password;
            this.isAdmin = isAdmin;
        }

        public boolean getIsAdmin() {
            return isAdmin;
        }

        public boolean authenticate(String name, String password) {
            isAuthenticate = this.name.equals(name) && this.password.equals(password);
            return isAuthenticate;    }
}
