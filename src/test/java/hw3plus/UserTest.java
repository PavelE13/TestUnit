package hw3plus;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {
    User adminUser;
    User user1;
    User user2;
    User user3;
    User user4;
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        //cоздаём юзеров
        adminUser = new User("admin", "*", true);
        user1 = new User("bbi", "gg", false);
        user2 = new User("uray", "bb", false);
        user3 = new User("poul", "san", false);
        user4 = new User("pos", "van", false);

        //добавляем юзеров в UserRepository
        userRepository = new UserRepository();
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);
        userRepository.addUser(user4);

        //юзеры проходят аутентификацию
        adminUser.authenticate("admin", "*");
        user1.authenticate("bbi", "gg");
        user2.authenticate("uray", "bb");
        user3.authenticate("poul", "san");
        user4.authenticate("pos", "van");
    }

    @Test
    @DisplayName("Все юзеры прошли аутентификацию успешно!")
    public void testAllUsersAuthenticate() {
        assertTrue(adminUser.authenticate("admin", "*"));
        assertTrue(user1.authenticate("bbi", "gg"));
        assertTrue(user2.authenticate("uray", "bb"));
        assertTrue(user3.authenticate("poul", "sann"));
        assertTrue(user4.authenticate("pos", "van"));
    }

    @Test
    @DisplayName("Все юзеры кроме админов разлогинились")
    public void testLogoutAllUsersExceptAdmins() {
        userRepository.logoutAllUsersExceptAdmins();
        for (User user : userRepository.data) {
            assertEquals(user.isAdmin, user.isAuthenticate);
            assertThat(user.isAdmin).isEqualTo(user.isAuthenticate);
        }
    }
}
