import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MFAMassTest {

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{5, 6, 7, 8}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}},
                {new int[]{}, new int[]{1, 2, 3, 4, 5, 6, 7, 4}},
                {new int[]{2, 3, 1, 5, 6, 7, 8}, new int[]{4, 2, 3, 1, 5, 6, 7, 8}},
                {new int[]{ 5, 6, 7, 8}, new int[]{4, 4, 4, 4, 5, 6, 7, 8}},
                {new int[]{}, new int[]{4, 4, 4, 4, 4, 4, 4, 4}},
                {new int[]{8}, new int[]{1, 2, 3, 0, 5, 6, 4, 8}},
        });
    }

    private int[] a, b;
    private MethodsForArrays mfa;

    public MFAMassTest(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    @Before
    public void init() {
        mfa = new MethodsForArrays();
    }

    @Test
    public void massTestElementsAfter4() {
        Assert.assertArrayEquals(a, MethodsForArrays.elementsAfter4(b));
    }
}
