package gun35_runners_reports.runners;

import org.junit.runner.JUnitCore;

public class JUnitRunner {

    public static void main(String[] args) {

        // JUbit nesnesi olusturuluyor
        JUnitCore junit = new JUnitCore();

        // run edilecek class'lar array olarak belirtiliyor
        junit.run(Runner3_JUnit.class);


    }
}
