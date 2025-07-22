package com.ar.cpass_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDocument {
    @Id
    private String id;
    private String username;
    private String password;
    private String websiteURL;
}
