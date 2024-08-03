package com.education.ecommerce.request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String userName;
    private String fullName;
    private String password;
    private String address;
    private Date birthDate;
}
