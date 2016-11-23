import com.java.training.user.dao.entity.User;
import com.java.training.user.dao.repository.UserRepository;
import com.java.training.user.exception.UserAlreadyExistsException;
import com.java.training.user.exception.UserNotFoundException;
import com.java.training.user.manager.UserManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws UserAlreadyExistsException, UserNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("user-applicationContext.xml");
        UserManager userManager = context.getBean(UserManager.class);
        User user = new User();
        user.setEmail("1111@gmail.com");
        user.setPhoneNumber("a111111");
        user.setUsername("ss111111s");
        user.setPassword("101");
        User user2 = userManager.createUser(user);
        User user3 = userManager.findUserById(user2.getId());
        System.out.println(user3);
    }
}
