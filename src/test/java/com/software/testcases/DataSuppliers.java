package com.software.testcases;

import com.software.model.User;
import io.github.sskorol.core.DataSupplier;
import lombok.Data;
import one.util.streamex.StreamEx;

import java.lang.reflect.Method;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.Optional.ofNullable;

public class DataSuppliers {
    //give info in to @Test(DataSupplier = "getData") альтернатива @dataProvider
    @DataSupplier
    public StreamEx getDataFromSupplier() {

        //.of(); при вызове метода конструируеться обект, конструируеться новй обект при
        //помощи билдер паттерна
//        User.of().userName("user1").create();

        return StreamEx.of(new User("user1", "pass1"), new User("user2", "pass2"))
                .filter(user -> !user.getUserName().equals("user1"));
    }

    @DataSupplier
    public String getStringDataFromSupplier() {
        return "testString";
    }

    //name = "new method name" - изменяем имя метода, transpose = true - все буде передано сразу, одной строкой
    @DataSupplier(name = "new method name", transpose = true)
    public StreamEx getDataFromSuppliercahChangeMethodName() {
        return StreamEx.of(new User("user1", "pass1"), new User("user2", "pass2")
                , new User("user3", "pass3"), new User("user4", "pass4")
        );
    }

    //

//    @DataSupplier(flatMap = true)
//    public StreamEx getDataFromSuppliersAsList() {
//        return StreamEx.of(asList(new User("user1", "pass1"), new User("user2", "pass2"))
//                , asList(new User("user3", "pass3"), new User("user4", "pass4"))
//        );
//    }


    @DataSupplier(flatMap = true)
    public StreamEx getDataFromSuppliersAsListWithSoftAssertions(Method method) {

        final String dataSource = ofNullable(method.getDeclaredAnnotation(DataAnot.class))
        .map(DataAnot::source)
        .orElse("give me json");
       // System.out.println("dataSource = " + dataSource);

        return StreamEx.of(asList(new User("user1", "pass1"), new User("user2", "pass2"))
                , asList(new User("user3", "pass3"), new User("user4", "pass4"))
        );
    }

}
