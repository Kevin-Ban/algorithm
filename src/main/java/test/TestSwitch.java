package test;

public class TestSwitch {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String classPath = "test.TestPerson";
        Class clazz = Class.forName(classPath);
        if (clazz.equals(TestPerson.class)) {
            TestAnnotion data = (TestAnnotion) clazz.getAnnotation(TestAnnotion.class);
            TestPerson person = (TestPerson) clazz.newInstance();
            person.setPassword("密码");
            person.setName("姓名");
            System.out.println(person);
        }
    }
}
