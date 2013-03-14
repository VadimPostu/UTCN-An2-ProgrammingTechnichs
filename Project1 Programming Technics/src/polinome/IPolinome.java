package polinome;

import java.util.ArrayList;

/**
 *
 * @author Postu Vadim
 * Interface that enumerates the features of the polYnome class.
 * 
 */
public interface IPolinome
{
   void setMonome(int exponent, int coeficient);
   
   // returns the exponent of the monome with the highest degree
   int getMaximumExponent();
   
   // returns the value of the coeficient or throws exception if not found
   int getCoeficient(int exponent);
   
   ArrayList<Integer> getExponents();
   
   IPolinome add(IPolinome polinome);
   
   IPolinome subtract(IPolinome polinome);
   
   IPolinome multiply(IPolinome polinome);
   
   IPolinome derivate();
}