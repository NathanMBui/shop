package com.example.eshop.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    @NotBlank(message = "mobile is required")
    @Pattern(message = "mobile number is invalid",
    regexp = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")
    private String mobile;
    @Email
    private String email;
    @NotNull
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordHash;
    private boolean isAdmin;
    private boolean isVendor;
    private Date registeredDate;
    private Date lastLogin;
    private String intro;
    private String profile;
}
