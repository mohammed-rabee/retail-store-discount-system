package org.blackstone.retail.object_mother;

import org.blackstone.retail.domain.entity.User;
import org.blackstone.retail.domain.enums.UserType;
import org.blackstone.retail.util.DateUtil;

public class UserObjectMother {

    public static User getEmployeeUser() {

        User user = new User();
        user.setUserID(1L);
        user.setUserType(UserType.EMPLOYEE);
        return user;
    }

    public static User getAffiliateUser() {

        User user = new User();
        user.setUserID(1L);
        user.setUserType(UserType.AFFILIATE);
        return user;
    }

    public static User get_1_years_customer_user() {

        User user = new User();
        user.setUserID(1L);
        user.setUserType(UserType.CUSTOMER);
        user.setCreatedAt(DateUtil.get_1_years_old_instant());
        return user;
    }

    public static User get_3_years_customer_user() {

        User user = new User();
        user.setUserID(1L);
        user.setUserType(UserType.CUSTOMER);
        user.setCreatedAt(DateUtil.get_2_years_old_instant());
        return user;
    }
}
