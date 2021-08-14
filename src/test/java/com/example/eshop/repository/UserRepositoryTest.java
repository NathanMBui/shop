package com.example.eshop.repository;

import com.example.eshop.data.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;

public class UserRepositoryTest extends RepositoryTestBase {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindUserByName() {
        //given
        User user = new User();
        user.setFirstName("Jane");
        user.setLastName("Foster");
        user.setPasswordHash("!#4");
        entityManager.persistAndFlush(user);

        //when
        Optional<User> returnUser = userRepository.findByFirstName("Jane");

        //then
        then(returnUser).isNotNull();
        then(returnUser.isPresent()).isTrue();
        if (returnUser.isPresent()) {
            then(returnUser.get().getFirstName()).isEqualTo("Jane");
            then(returnUser.get().getLastName()).isEqualTo("Foster");
        }
    }
}
