public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);
}
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void testFindByName() {

        User user = new User();
        user.setName("John");

        repository.save(user);

        List<User> users = repository.findByName("John");

        assertEquals(1, users.size());
        assertEquals("John", users.get(0).getName());
    }
}