package main.enterprise;

import main.api.Accountant;

import java.util.ServiceLoader;
//PS C:\Users\Rastishka_gang\IdeaProjects\modulesdemo\out\artifacts>  java -cp "main.api.jar;main.enterprise.jar;main.labor.market.jar;main.university.jar" main.enterprise.Main
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Enterprise World!");
        ServiceLoader <Accountant> loader = ServiceLoader.load(Accountant.class);
        for (var accountant : loader) {
            System.out.println(accountant.getClass().getSimpleName());
            accountant.doJob();
        }
        Class<?> aClass = Class.forName("main.university.AccountantImpl");
        Accountant accountant = (Accountant) aClass.getConstructor().newInstance();
        accountant.doJob();
        System.out.println("Done!");
    }
}
