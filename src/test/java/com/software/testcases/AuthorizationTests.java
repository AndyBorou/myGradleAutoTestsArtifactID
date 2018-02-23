package com.software.testcases;


import com.software.model.User;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;


import java.util.logging.Logger;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;


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

//    @BeforeMethod
//    //Method actualMethod получение доступа к текущему методу, содержит метаданные
//    public void setUp(ITestContext context, Method actualMethod) {
//        System.out.println("Method actualMethod " + actualMethod.getName());
//        System.out.println("Method actualMethod " + actualMethod.getDeclaredAnnotation(Test.class));
//        //обращение к xml файл и получение данных из конеткса - smoke-suite.xml
//        System.out.println("BeforeMethod result: " + context.getCurrentXmlTest().getParameter("browser"));
//    }

    // будет запущено столько раз сколько элемнтов вернет @DataSupplier метод
    //get from @DataProvider annotashions , method
//    @Test(dataProvider = "getDataFromSupplier", dataProviderClass = DataSuppliers.class)
//    public void userShouldBeAuthorizedWithValidCredentials1( User user) {
//        System.out.println("User!!! - " + user.toString());
//        System.out.println("hello from auth test");
//        LOG.info("hello from LOG: ");
//        // throw new UnsupportedOperationException ("no element");
//    }
//
//    // будет запущено столько раз сколько элемнтов вернет @DataSupplier метод
//    //get from @DataProvider annotashions , method
//    @Test(dataProvider = "getStringDataFromSupplier", dataProviderClass = DataSuppliers.class)
//    public void userShouldBeAuthorizedWithValidCredentials2(final String user) {
//        System.out.println("String date!!!   - " + user);
//    }
//
//    // поиск dataProvider по новому имени, User... - три точки это массив, должен быть последним
//    @Test(dataProvider = "new method name", dataProviderClass = DataSuppliers.class)
//    public void userShouldBeAuthorizedWithValidCredentials3(final User... users) {
//        System.out.println("String many users!!!   - " + users);
//    }

    @Test(dataProvider = "getDataFromSuppliersAsList", dataProviderClass = DataSuppliers.class)
    public void userShouldBeAuthorizedWithValidCredentials4(final User... users) {

        //  val username = users[0].getUserName();

        //SoftAssertions проверка всех  Assertions
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(asList(users)).as("user list").hasSize(3);
        softAssertions.assertThat(users[0].getUserName()).as("user name").isEqualTo("user1");

        //вызов все искл ситуаций
        softAssertions.assertAll();
    }

    // берем данные из джсон файла
    @DataAnot(source = "data.json")
    @Test(dataProvider = "getDataFromSuppliersAsListWithSoftAssertions", dataProviderClass = DataSuppliers.class)
    public void userShouldBeAuthorizedWithValidCredentials5(final User... users) {

        //  val username = users[0].getUserName();

        //SoftAssertions проверка всех  Assertions
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(asList(users)).as("user list").hasSize(2);
        softAssertions.assertThat(users[0].getUserName()).as("user name").isEqualTo("user3");

        //вызов все искл ситуаций
        softAssertions.assertAll();
    }
}
