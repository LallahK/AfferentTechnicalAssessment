package abdullah.takehometest.afferent;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

    private static Calculator calc = new Calculator();
    
    @Test
    public void testCalculator1() {
        Double expected = Double.valueOf(6.09);
        assertEquals(calc.parse("2+3*(4-1)/2.2"), expected);
    }

    @Test
    public void testCalculator2() {
        Double expected = Double.valueOf(18.8);
        assertEquals(calc.parse("9.4 * 8 / 4"), expected);
    }

    @Test
    public void testCalculator3() {
        Double expected = Double.valueOf(1);
        assertEquals(calc.parse("9-4 * 8 / 4"), expected);
    }

    @Test
    public void testCalculator4() {
        Double expected = Double.valueOf(8);
        assertEquals(calc.parse("(3*3) + 5 -2*3"), expected);
    }

    @Test
    public void testCalculator5() {
        Double expected = null;
        assertEquals(calc.parse("(3*3) + 5 -2*3a"), expected);
    }   
    
    @Test
    public void testCalculator6() {
        Double expected = null;
        assertEquals(calc.parse("abcdefg"), expected);
    }

    @Test
    public void testCalculator7() {
        Double expected = Double.valueOf(-6);
        assertEquals(calc.parse("2-2-2-2-2"), expected);
    }

    @Test
    public void testCalculator8() {
        Double expected = Double.valueOf(-3);
        assertEquals(calc.parse("2+4-6-8+5"), expected);
    }

}
