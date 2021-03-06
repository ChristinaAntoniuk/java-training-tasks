package training;

import java.lang.reflect.Proxy;

public class App {
    public static void main(String[] args) {
        Date date = new Date();
        Notebook notebook = new Notebook();
        notebook.setName("Christina");
        notebook.setSurname("Antoniuk");
        notebook.setPatronymic("Valerievna");
        notebook.setPhoneNumber("+380662322605");
        notebook.setDateOfBirth("04 04 1994");
        System.out.println(notebook.toString());
        System.out.println(notebook.calculationOfDaysToTheBirth());

        Class clazz = Notebook.class;
        Object proxyUser = Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(), new InvHandler(notebook));

        System.out.println(((IUser)proxyUser).getName());
        //((IUser) proxyUser).setSurname("Trump");
    }
}
