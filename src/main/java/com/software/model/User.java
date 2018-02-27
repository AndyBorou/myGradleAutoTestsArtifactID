package com.software.model;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by Andrey on 2/23/2018.
 */
// @RequiredArgsConstructor создает кантроллер
//@RequiredArgsConstructor
//@NoArgsConstructor - constractor without parametter
//@Getter create getters fot parameters
//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString

// @Data - создаст Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, lombok.Value

//@Builder(builderMethodName = "of", buildMethodName = "create") - позднее создание обекта
@Data
public class User {

    private final String userName;
    private final String password;

    public static User dummy(){
        return new User ("defU", "defP");
    }
//    public User(final String userName, final String password) {
//        this.userName = userName;
//        this.password = password;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "userName='" + userName + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }

}
