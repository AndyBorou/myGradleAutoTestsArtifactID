package com.software.testcases;

import com.software.model.User;
import io.github.sskorol.core.DataSupplier;
import one.util.streamex.StreamEx;

public class DataSuppliers {
    //give info in to @Test(DataSupplier = "getData") альтернатива @dataProvider
    @DataSupplier
    public StreamEx getDataFromSupplier() {
        return StreamEx.of(new User("user1", "pass1"), new User("user2", "pass2"))
                .filter(user -> !user.getUserName().equals("user1"));
    }

    @DataSupplier
    public String getStringDataFromSupplier() {
        return "testString";
    }

}
