import org.junit.Assert;
import org.junit.Test;

public class MethodsForArraysTest {
    private MethodsForArrays mfa;

    @Test
    public void testIsPercentOneOrFour() {
        mfa = new MethodsForArrays();
        Assert.assertTrue("True", MethodsForArrays.isPercentOneOrFour(new int[]{1, 2, 3, 5}));
    }

    @Test
    public void testIsPercentOneOrFour1() {
        mfa = new MethodsForArrays();
        Assert.assertTrue("True", MethodsForArrays.isPercentOneOrFour(new int[]{0, 2, 1, 3, 5}));
    }

    @Test
    public void testIsPercentOneOrFour2() {
        mfa = new MethodsForArrays();
        Assert.assertTrue("True", MethodsForArrays.isPercentOneOrFour(new int[]{0, 2, 3, 1}));
    }

    @Test
    public void testIsPercentOneOrFour3() {
        mfa = new MethodsForArrays();
        Assert.assertFalse(MethodsForArrays.isPercentOneOrFour(new int[]{2, 2, 3, 5}));
    }

    @Test (expected = RuntimeException.class)
    public void testElementsAfter4() {
        mfa = new MethodsForArrays();
        Assert.assertArrayEquals(new int[]{}, MethodsForArrays.elementsAfter4(new int[]{1, 2, 3, 5, 5, 5}));
    }
}
