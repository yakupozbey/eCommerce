package com.education.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String userName;
    private String fullName;
    private String password;
    private String address;
    private Date birthDate;

}
