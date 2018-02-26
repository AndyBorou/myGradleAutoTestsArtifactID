package com.software.testcases;


import com.software.dataWork.DataReader;
import com.software.model.Dog;
import com.software.model.User;
import io.github.sskorol.core.DataSupplier;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;


import java.lang.reflect.Method;
import java.util.logging.Logger;

import static java.util.Optional.ofNullable;
import static com.software.utils.ServiceLoaderUtils.load;
import static org.joor.Reflect.on;


@Slf4j
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

//    @DataSupplier(flatMap = true)
//    public User getDataFromSuppliersAsList(Method method) {
//
//        return ofNullable(method.getDeclaredAnnotation(DataAnot.class))
//                .map(DataAnot::source)
//                .map(source -> JsonUtils.jsonToEntity(source, User.class))
//                .orElseGet(User::dummy);


    // return JsonUtils.jsonToEntity(dataSource, User.class);

//        //работа с Json
//        User user = null;
//        final Gson gson = new Gson();
//        //String  path ="H:\\workspace\\autoTest\\myGradleAutoTestsArtifactID\\src\\test\\resources\\data.json";
//        String path = ClassLoader.getSystemResource(dataSource).getPath();
//
//        try (final FileReader r = new FileReader(path)) {
//            JsonReader reader = new JsonReader(r);
//            user = gson.fromJson(reader, User.class);
//            return user;
//        } catch (IOException e) {
//            e.printStackTrace();
//            log.error("Unable to read {}", dataSource);
//            return User.dummy();
//        }


//        return StreamEx.of(asList(new User("user1", "pass1"), new User("user2", "pass2"))
//                , asList(new User("user3", "pass3"), new User("user4", "pass4"))
//        );
    //   }
//    @DataAnot(source = "data.json")
//    @Test(dataProvider = "getDataFromSuppliersAsList")
//    public void userShouldBeAuthorizedWithValidCredentials4(final User user) {
//        System.out.println("JSON: "+user);
//
//    }

    // берем данные из джсон файла
//    @DataAnot(source = "data.json")
//    @Test(dataProvider = "getDataFromSuppliersAsListWithSoftAssertions", dataProviderClass = DataSuppliers.class)
//    public void userShouldBeAuthorizedWithValidCredentials5(final User... users) {
//
//        //  val username = users[0].getUserName();
//
//        //SoftAssertions проверка всех  Assertions
////        SoftAssertions softAssertions = new SoftAssertions();
////        softAssertions.assertThat(asList(users)).as("user list").hasSize(2);
////        softAssertions.assertThat(users[0].getUserName()).as("user name").isEqualTo("user3");
////
////        //вызов все искл ситуаций
////        softAssertions.assertAll();
//
//      CustomAssertions.asserThat(users[0]).hasUserName("user1");
//
//    }


    @Test
    public void userShouldBeAuthorizedWithValidCredentials4() {

        //тоже самое
//        StreamEx.of(new JsonReader(), new XmlReader())
//                .findFirst(dataReader -> dataReader.getClass().getSimpleName().startsWith("Json"))
//                .map(dataReader -> dataReader.readForm("data.json", User.class))
//                .ifPresent(System.out::println);
//тоже самое

        // находим все имелментации интерфейса
        //ClassLoader можно получить файлы, классы которые загруженные в рантайм
//        StreamEx.of(load(DataReader.class, ClassLoader.getSystemClassLoader()))
//                // находим первый попавшийся класс имя которрого начинаеться с ...
//                .findFirst(dataReader -> dataReader.getClass().getSimpleName().startsWith("Json"))
//                // вызываем в этом классе метод и получаем результат
//                .map(dataReader -> dataReader.readForm("data.json", User.class))
//                // выводим полученный резултат
//                //   .ifPresent(System.out::println);
//                //если ничего не было найдено
//                .orElseThrow(() -> new IllegalArgumentException("didn't found"));


    }

//    @DataSupplier(flatMap = true) nnot work
//    public User setUp(Method method) {
//
//        return ofNullable(method.getDeclaredAnnotation(DataAnot.class))
//                .map(DataAnot::source)
//                .map(source -> )
//                        .findFirst(dataReader -> dataReader.getDataSource("data.json").equals("json"))
//                        .map(dataReader -> dataReader.readForm("data.json", User.class))
//                .orElseGet(User::dummy);
//    }

//    public DataReader getDataReader (final String dataSource){
//        StreamEx.of(load(DataReader.class, ClassLoader.getSystemClassLoader()))
//        .findFirst(dataReader -> dataReader.getClass().getSimpleName().startsWith()
//    }

    public <T> T getObject (final  Class<T> entity, final Object... args){
        return on(entity).create(args).get();
    }

    @DataAnot(source = "data.json")
    @Test
    public void userShouldBeAuthorizedWithValidCredentials5() {

        User user = new User("name1", "pass1");

        // second wat to create new object of the class
        User user2 = on(User.class).create("name2", "pass2").get();

        User user3 = on(user).call("dummy").get();

        System.out.println("user " + user + " | " + "user2 " + user2 +"user3 " + user3);

  //      getObject(User.class);

        Dog dog = getObject(Dog.class);

        Dog dog2 = getObject(Dog.class, "tuz");

        System.out.println(dog2);
        System.out.println(dog);
//        StreamEx.of(load(DataReader.class, ClassLoader.getSystemClassLoader()))
//                .findFirst(dataReader -> dataReader.getDataType("data.json").equals("json"))
//                .map(dataReader -> dataReader.readForm("data.json", User.class))
//                .orElseThrow(() -> new IllegalArgumentException("didn't found"));
    }


}
