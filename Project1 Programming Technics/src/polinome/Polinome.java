package polinome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Vadim Postu 
 * 
 * Class that stores and performs diverse actions on the
 * given polynomials.
 *
 */
public class Polinome implements IPolinome {

    private HashMap<Integer, Integer> monomes;

    public Polinome() {
        monomes = new HashMap<Integer, Integer>();
    }

    /**
     *
     * @param exponent  monome exponent  
     * @param coeficient  monome coeficient
     * 
     * setMonome - method that puts a monome into the existing polynomial.
     * 
     * 
     */
    @Override
    public void setMonome(int exponent, int coeficient) {
        if (monomes.containsKey(exponent)) {
            monomes.put(exponent, monomes.get(exponent) + coeficient);
        } else {
            monomes.put(exponent, coeficient);
        }

       if (monomes.get(exponent) == 0) {
            monomes.remove(exponent);
        }
    }

    /**
     *
     * @return the maximal value of the exponent in the polinome.
     * 
     */
    @Override
    public int getMaximumExponent() {
        int maxExponent = 0;
        for (int exponent : monomes.keySet()) {
            if (exponent > maxExponent) {
                maxExponent = exponent;
            }
        }
        return maxExponent;
    }

    /**
     *
     * @return a ArrayList containing all the exponents
     * of the given polynomial function.
     *
     */
    @Override
    public ArrayList<Integer> getExponents() {
        ArrayList<Integer> exponents = new ArrayList<Integer>();
        for (int value : monomes.keySet()) {
            exponents.add(value);
        }

        Collections.sort(exponents);
        Collections.reverse(exponents);

        return exponents;
    }

    /**
     *
     * @param exponent - the exponent who's coefficient we are searching for.
     * @return the coefficient that belongs to the given exponent.
     * 
     */
    @Override
    public int getCoeficient(int exponent) {
        if (!monomes.containsKey(exponent)) {
            return 0;
        }
        return (int) monomes.get(exponent);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int exponent : this.getExponents()) {
            builder.append(formatMonome(exponent, this.getCoeficient(exponent)));
        }
            
        if(monomes.isEmpty()) 
            builder.append("0");
       
        if(this.getMaximumExponent() > 0) {
            if (this.getCoeficient(this.getMaximumExponent()) > 0) {
                builder.deleteCharAt(0);
            }
        }
        return builder.toString();
    }

    private String formatMonome(int exponent, int coeficient) {
        if (coeficient == 0) {
            return "";
        }
        if (exponent == 0) {
            if (exponent == this.getMaximumExponent())
                 return "" + coeficient;
            else return (coeficient > 0) ? "+" + coeficient : coeficient + "";
        }

        String exponentString = (exponent == 1) ? "" : exponent + "";
        String coeficientString;
        if (coeficient == 1) {
            coeficientString = "+";
        } else if (coeficient == -1) {
            coeficientString = "-";
        } else {
            coeficientString = (coeficient > 0) ? "+" + coeficient : coeficient + "";
        }

        return coeficientString + "x" + exponentString;
    }

    /**
     *
     * @param polinome the polynome to be added.
     * @return The sum of the polynome stored in the class and the polinome 
     * recieved as parameter.
     * 
     */
    @Override
    public IPolinome add(IPolinome polinome) {
        Polinome sum = new Polinome();

        for (int exp : this.getExponents()) {
            sum.setMonome(exp, this.getCoeficient(exp));
        }
        for (int exp : polinome.getExponents()) {
            sum.setMonome(exp, polinome.getCoeficient(exp));
        }
        return sum;
    }

    /**
     *
     * @param polinome the polynome to be substracted.
     * @return the difference between the polynome stored in the class and
     * the one recieved as parameter.
     *
     */
    @Override
    public IPolinome subtract(IPolinome polinome) {
        Polinome difference = new Polinome();

        for (int exp : this.getExponents()) {
            difference.setMonome(exp, this.getCoeficient(exp));
        }
        for (int exp : polinome.getExponents()) {
            difference.setMonome(exp, -polinome.getCoeficient(exp));
        }

        return difference;
    }

    /**
     *
     * @param polinome the polynome to be multiplied by.
     * @return product of the polynome stored in the class and the polinome 
     * recieved as parameter.
     *
     */
    @Override
    public IPolinome multiply(IPolinome polinome) {
        Polinome result = new Polinome();

        for (int thisExponent : this.getExponents()) {
            for (int polinomeExponent : polinome.getExponents()) {
                result.setMonome(thisExponent + polinomeExponent, this.getCoeficient(thisExponent) * polinome.getCoeficient(polinomeExponent));
            }
        }

        return result;
    }

    /**
     *
     * @return the derivate of the polynomial stored in the class. 
     * 
     */
    @Override
    public IPolinome derivate() {
        Polinome result = new Polinome();

        for (int exp : this.getExponents()) {
            if (exp != 0) {
                result.setMonome(exp - 1, this.getCoeficient(exp) * exp);
            }
            else result.setMonome(0, 0);
        }

        return result;
    }
}
