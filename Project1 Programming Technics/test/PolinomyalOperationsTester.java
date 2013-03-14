import org.junit.Test;
import static org.junit.Assert.*;
import polinome.Polinome;
import processor.PolinomeBuilder;

/**
 *
 * @author Vadim
 *
 */
public class PolinomyalOperationsTester {

    public PolinomyalOperationsTester() {
    }

    @Test
    public void testPolinomeOperations() {
        PolinomeBuilder builder = new PolinomeBuilder();
        Polinome polinom1 = new Polinome();
        Polinome polinom2 = new Polinome();
        // test 1
        String pol1 = "2";
        String pol2 = "1";
        polinom1 = builder.parsePolinome(pol1);
        polinom2 = builder.parsePolinome(pol2);
        assertEquals("3", polinom1.add(polinom2).toString());

        // test 2
        pol1 = "1";
        pol2 = "1";
        polinom1 = builder.parsePolinome(pol1);
        polinom2 = builder.parsePolinome(pol2);
        assertEquals("0", polinom1.subtract(polinom2).toString());

        // test 3
        pol1 = "-x";
        pol2 = "-x-1";
        polinom1 = builder.parsePolinome(pol1);
        polinom2 = builder.parsePolinome(pol2);
        assertEquals("1", polinom1.subtract(polinom2).toString());

        // test 4
        pol1 = "x";
        pol2 = "1";
        polinom1 = builder.parsePolinome(pol1);
        polinom2 = builder.parsePolinome(pol2);
        assertEquals("x", polinom1.multiply(polinom2).toString());

        // test 5
        pol1 = "3x2+12x";
        pol2 = "x3-x2-15x";
        polinom1 = builder.parsePolinome(pol1);
        polinom2 = builder.parsePolinome(pol2);
        assertEquals("x3+2x2-3x", polinom1.add(polinom2).toString());

        // test 6
        pol1 = "1";
        pol2 = "x";
        polinom1 = builder.parsePolinome(pol1);
        polinom2 = builder.parsePolinome(pol2);
        assertEquals("0", polinom1.derivate().toString());
        
        // test 7
        pol1 = "3x2+4x+1";
        pol2 = "x";
        polinom1 = builder.parsePolinome(pol1);
        polinom2 = builder.parsePolinome(pol2);
        assertEquals("6x+4", polinom1.derivate().toString());
    }
}
