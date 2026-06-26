package examples;


import org.testng.annotations.Test;

// Only ONE public class
public class Activity4 {
    @Test
    public void mainTest() {
        System.out.println("Activity4 main class");
    }
}

// Other classes without 'public'
class DemoOne {

    @Test
    public void firstTestCase() {
        System.out.println("I'm in first test case from DemoOne Class");
    }

    @Test
    public void secondTestCase() {
        System.out.println("I'm in second test case from DemoOne Class");
    }
}

class DemoTwo {

    @Test
    public void testCase() {
        System.out.println("I'm in the test case from DemoTwo Class");
    }
}

