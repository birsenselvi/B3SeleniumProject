package gun34_hooks_scenarioOutline.test1.stepdefs;

import io.cucumber.java.*;

public class Hooks {

    // cucumberda ilk calisacak olan method
    // method static olmali
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }


    // her senaryo öncesi calisir
    @Before(order = 1)
    public void before1(){
        System.out.println("Before 1");
    }

    // her senaryo öncesi calisir
    @Before("@reg")
    public void before2(){
        System.out.println("Before 2");
    }

    // her step öncesi run olur
    @BeforeStep
    public void beforeStep(){
        System.out.println("before Step");
    }

    // her step sonrasi run olur
    @AfterStep
    public void afterStep(){
        System.out.println("after step");
    }


    // her senaryo sonrasi calisir
    @After(order = 1)
    public void after1(){
        System.out.println("After 1");
    }

    // her senaryo sonrasi calisir
    @After("@reg")
    public void after2(){
        System.out.println("After 2");
    }


    // cucumberda son calisacak olan method
    // static olma zorunda
    @AfterAll
    public static void afterAll(){
        System.out.println("After All");
    }
}
