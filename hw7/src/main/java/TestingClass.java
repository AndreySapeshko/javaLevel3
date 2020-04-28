import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestingClass {

    public int sum(int a, int b) {
        return a + b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public String addStr(String adder, String added) {
        return adder + added;
    }

    public static void start(Class myTestsClass) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        MyTests myTests = (MyTests) myTestsClass.newInstance();
        Method[] methods = myTests.getClass().getMethods();
        boolean isPercentBefore = false;
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getAnnotation(BeforeSuite.class) != null) {
                if (!isPercentBefore) {
                    methods[i].invoke(myTests);
                    isPercentBefore = true;
                } else {
                    throw new RuntimeException("Метод с анатацией @BeforeSuit может быть только один");
                }
            }
        }
        for (int i = 0; i < methods.length; i++) {
            for (Method m : methods) {
                if (m.getAnnotation(Test.class) != null) {
                    if (m.getAnnotation(Test.class).priority() == i) {
                        System.out.print("Priority: " + m.getAnnotation(Test.class).priority() + " ");
                        m.invoke(myTests);
                    }
                }
            }
        }
        for (int i = 6; i > 1; i -= 2) {
            for (Method m : methods) {
                if (m.getAnnotation(Test.class) != null) {
                    if (m.getAnnotation(Test.class).priority() == i) {
                        System.out.print("Priority: " + m.getAnnotation(Test.class).priority() + " ");
                        m.invoke(myTests);
                    }
                }
            }
        }
        boolean isPercentAfter = false;
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getAnnotation(AfterSuite.class) != null) {
                if (!isPercentAfter) {
                    methods[i].invoke(myTests);
                    isPercentAfter = true;
                } else {
                    throw new RuntimeException("Метод с анатацией @AfterSuit может быть только один");
                }
            }
        }
    }

    public static void main(String[] args) {

        try {
            start(MyTests.class);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
