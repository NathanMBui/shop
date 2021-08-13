package com.example.eshop.repository;

import com.example.eshop.data.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindUserByName() {
        //given
        UserEntity user = new UserEntity();
        user.setFirstName("Jane");
        user.setLastName("Foster");
        user.setPasswordHash("!#4");
        entityManager.persistAndFlush(user);

        //when
        Optional<UserEntity> returnUser = userRepository.findByFirstName("Jane");

        //then
        then(returnUser).isNotNull();
        then(returnUser.isPresent()).isTrue();
        if (returnUser.isPresent()) {
            then(returnUser.get().getFirstName()).isEqualTo("Jane");
            then(returnUser.get().getLastName()).isEqualTo("Foster");
        }
    }
}
