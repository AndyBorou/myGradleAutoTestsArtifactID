package com.software.assertions;

import com.software.model.User;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * Created by Andrey on 2/23/2018.
 */

public class UserAssert  extends AbstractAssert<UserAssert, User> {

//    public UserAssert(User user, Class<?> selfType) {
//        super(user, selfType);
//    }

    //variable string '%s' there could be putted

    private static String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of:\n<%s>\nto be: <%s>\n but was:\n<%s>";

    public UserAssert(final User user){
        super(user, UserAssert.class);
    }


    public UserAssert hasUserName(final String expectedUserName) {
        isNotNull();

        if (!Objects.areEqual(actual.getUserName(), expectedUserName)){
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "[Username]", actual, expectedUserName, actual.getUserName() );
        }
        return this;
    }


    public UserAssert hasUserPassword(final String expectedUserPassword) {
        isNotNull();

        if (!Objects.areEqual(actual.getPassword(), expectedUserPassword)){
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "[Password]",expectedUserPassword, actual.getPassword() );
        }
        return this;
    }

}
