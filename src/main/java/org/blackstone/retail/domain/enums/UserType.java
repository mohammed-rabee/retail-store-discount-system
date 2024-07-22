package org.blackstone.retail.domain.enums;

import lombok.Getter;

@Getter
public enum UserType {

    EMPLOYEE("EMPLOYEE"),
    AFFILIATE("AFFILIATE"),
    CUSTOMER("CUSTOMER");

    private final String userTypeCode;

    UserType(String userType) {
        this.userTypeCode = userType;
    }
}
