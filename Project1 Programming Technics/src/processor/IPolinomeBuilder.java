package processor;

import polinome.Polinome;

/**
 *
 * @author Postu Vadim
 * Interface that counts some of the features of the builder class
 * 
 */
public interface IPolinomeBuilder {
   Boolean isPolinomeRepresentationValid(String input);
   
   Polinome parsePolinome(String input);
   
   String convertToGeneralForm(String monom);
}
