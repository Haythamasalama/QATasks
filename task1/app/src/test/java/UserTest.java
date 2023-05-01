
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UserTest {
    @Test
    public void appHasAGreeting() {
        User user = new User();

        user.setName("Haytham Salama");
        user.setEmail("haythamasalama@gmail.com");

        Assertions.assertSame("Haytham Salama",user.getName());
        Assertions.assertSame("haythamasalama@gmail.com",user.getEmail());
    }
}
