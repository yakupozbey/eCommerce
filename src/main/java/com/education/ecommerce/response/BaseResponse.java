package com.education.ecommerce.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private String errorCode;
    private String errorMessage;
}
