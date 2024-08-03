package com.education.ecommerce.dto;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private UUID userId;
    private String userName;
    private String fullName;
    private String password;
    private String address;
    private Date birthDate;
}
