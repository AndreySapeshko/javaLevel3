public class MyTests {

    @BeforeSuite
    public void methodBefore() {
        System.out.println("Method Before");
    }

    @Test (priority = 2)
    public void test1 () {
        System.out.println("Test 1");
    }

    @Test (priority = 3)
    public void test2 () {
        System.out.println("Test 2");
    }

    @Test (priority = 4)
    public void test3 () {
        System.out.println("Test 3");
    }

    @Test
    public void test4 () {
        System.out.println("Test 4");
    }

    @Test (priority = 6)
    public void test5 () {
        System.out.println("Test 5");
    }

    @AfterSuite
    public void methodAfter() {
        System.out.println("After method");
    }
}
