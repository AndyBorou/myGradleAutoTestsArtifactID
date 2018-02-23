package com.software.testcases;

import com.software.model.User;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.logging.Logger;


public class AuthorizationTests {

    private static final Logger LOG = Logger.getLogger(AuthorizationTests.class.getName());

    //give info in to @Test(dataProvider = "getData") - java 7
//    @DataProvider
//    public Object[][] getData(){}

//    //give info in to @Test(DataSupplier = "getData") альтернатива @dataProvider
//    @DataSupplier
//    public StreamEx getDataFromSupplier() {
//        return StreamEx.of(new User("user1", "pass1"), new User("user2", "pass2"))
//                .filter(user -> !user.getUserName().equals("user1"));
//    }


//    @BeforeMethod
//    public void setUp(ITestContext context) {
//        //обращение к xml файл и получение данных из конеткса - smoke-suite.xml
//        System.out.println("BeforeMethod result: " + context.getCurrentXmlTest().getParameter("browser"));
//    }

    @BeforeMethod
    //Method actualMethod получение доступа к текущему методу, содержит метаданные
    public void setUp(ITestContext context, Method actualMethod) {
        System.out.println("Method actualMethod " + actualMethod.getName());
        System.out.println("Method actualMethod " + actualMethod.getDeclaredAnnotation(Test.class));
        //обращение к xml файл и получение данных из конеткса - smoke-suite.xml
        System.out.println("BeforeMethod result: " + context.getCurrentXmlTest().getParameter("browser"));
    }

    // будет запущено столько раз сколько элемнтов вернет @DataSupplier метод
    //get from @DataProvider annotashions , method
    @Test(dataProvider = "getDataFromSupplier", dataProviderClass = DataSuppliers.class)
    public void userShouldBeAuthorizedWithValidCredentials(final User user) {
        System.out.println("User!!! - " + user.toString());
        System.out.println("hello from auth test");
        LOG.info("hello from LOG: ");
       // throw new UnsupportedOperationException ("no element");
    }

    // будет запущено столько раз сколько элемнтов вернет @DataSupplier метод
    //get from @DataProvider annotashions , method
    @Test(dataProvider = "getStringDataFromSupplier", dataProviderClass = DataSuppliers.class)
    public void userShouldBeAuthorizedWithValidCredentials(final String user) {
        System.out.println("String date!!! - " + user);

    }

}
