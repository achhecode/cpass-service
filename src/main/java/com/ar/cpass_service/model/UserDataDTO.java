package com.ar.cpass_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDTO {
    private String id;
    private String username;
    private String password;
    private String websiteURL;
}
