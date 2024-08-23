package com.limaTaylor.listaTudo.Repositories;

import com.limaTaylor.listaTudo.Dtos.UserDto;
import com.limaTaylor.listaTudo.Models.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("Test")
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Create one user and should this user is presente")
    void findUserByIdCase1() {
        int userId = 1;
        UserDto data = new UserDto(userId, 1, 1, "Taylor Lima", "Taylor Luiz Meira Lima");
        this.crateUser(data);

        Optional<UserModel> result = this.userRepository.findById(userId);

        assertThat(result.isPresent());
    }
    @Test
    @DisplayName("should not user is present")
    void findUserByIdCase2() {
        int userId = 1;

        Optional<UserModel> result = this.userRepository.findById(userId);

        assertThat(result.isEmpty());
    }

    private UserModel crateUser(UserDto data) {
        UserModel user = new UserModel(data);
        return user;
    }

}
