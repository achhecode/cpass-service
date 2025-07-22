package com.ar.cpass_service.util;

import com.ar.cpass_service.entity.UserDataDocument;
import com.ar.cpass_service.model.UserDataDTO;

public class UserDataMapper {

    public static UserDataDTO toDTO(UserDataDocument doc) {
        return new UserDataDTO(doc.getId(), doc.getUsername(), doc.getPassword(), doc.getWebsiteURL());
    }

    public static UserDataDocument toDocument(UserDataDTO dto) {
        return new UserDataDocument(dto.getId(), dto.getUsername(), dto.getPassword(), dto.getWebsiteURL());
    }
}
