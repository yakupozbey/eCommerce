package com.education.ecommerce.response;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse extends BaseResponse{
    private UUID userId;
    private String userName;
    private String fullName;

}
