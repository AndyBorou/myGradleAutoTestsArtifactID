package com.software.assertions;

import com.software.model.User;
import lombok.experimental.UtilityClass;

//privite constructions, finil class
@UtilityClass
public class CustomAssertions {

    public static UserAssert asserThat(final User user){
        return new UserAssert(user);
    }
}
