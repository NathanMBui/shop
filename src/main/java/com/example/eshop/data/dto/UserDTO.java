package com.example.eshop.data.dto;

import com.example.eshop.data.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String email;
    private String passwordHash;
    private boolean isAdmin;
    private boolean isVendor;
    private Date registeredDate;
    private Date lastLogin;
    private String intro;
    private String profile;

    public UserDTO(UserEntity user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.middleName = user.getMiddleName();
        this.lastName = user.getLastName();
        this.mobile = user.getMobile();
        this.email = user.getEmail();
        this.passwordHash = user.getPasswordHash();
        this.isAdmin = user.isAdmin();
        this.isVendor = user.isVendor();
        this.registeredDate = user.getRegisteredDate();
        this.lastLogin = user.getLastLogin();
        this.intro = user.getIntro();
        this.profile = user.getProfile();
    }

    public static Optional<UserDTO> fromOptional(Optional<UserEntity> optionalUser) {
        if (optionalUser.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(new UserDTO(optionalUser.get()));
        }
    }
}
