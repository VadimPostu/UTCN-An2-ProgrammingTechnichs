package processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import polinome.Polinome;

/**
 *
 * @author Vadim this class takes the given polynome, checks for eventual
 * spelling mistakes, splitts the given polynome into monomes and returns them 
 * into a general form.
 *
 */
public class PolinomeBuilder implements IPolinomeBuilder {

   public static String aux1 = new String();

   public PolinomeBuilder() {
   }

   /**
    *
    * @param input
    * @return method that checks the spelling errors, if there are no such, 
    * it allows the flow of the application to go on.
    * 
    */
   @Override
   public Boolean isPolinomeRepresentationValid(String input) {
      if(input.isEmpty()) return false;
          
      String[] allow = {"-", "+", "x", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
      String aux;
      int error_detector = 0;
      for (int i = 0; i < input.length(); i++) {
         error_detector = 0;
         aux = input.substring(i, i + 1);
         for (int j = 0; j < allow.length; j++) {
            if (aux.equals(allow[j])) {
               error_detector++;
            }
         }
         if (error_detector == 0) {
            return false;
         }
      }
      return true;
   }

   /**
    *
    * @param input the function parsePolinome recieves the the Polinome string
    * and returns the polinome instance <coeficient, exponent> pairs.
    * @return
    */
   @Override
   public Polinome parsePolinome(String input) {
      Polinome polinom = new Polinome();

      String[] negativeGroups = input.split("[-]");
      List<String> monoms = new ArrayList<String>();
      int index = 0;
      Integer exponent;
      Integer coeficient;

      for (String g : negativeGroups) {
         if (g.isEmpty()) {
            continue;
         }
         String[] groupMonoms = g.split("[+]");

         for (int j = 0; j < groupMonoms.length; ++j) {
            monoms.add(j == 0 ? "-" + groupMonoms[j] : groupMonoms[j]);
         }
      }

      if (!"-".equals(input.substring(0, 1))) {
         monoms.set(0, monoms.get(0).replace("-", ""));
      }
      for (int i = 0; i < monoms.size(); i++) {
         monoms.set(i, convertToGeneralForm(monoms.get(i)));
      }
      for (String g : monoms) {
         String[] coef = g.split("[x]+");
         coeficient = Integer.parseInt(coef[0]);
         exponent = Integer.parseInt(coef[1]);
         polinom.setMonome(exponent, coeficient);
      }

      return polinom;
   }

   /**
    *
    * @param monom this function takes each of the monoms of the polynomial
    * function and changes it to a "coeficient"+"x"+"exponent" form.
    *
    * @return
    */
   public static String convertToGeneralForm(String monom) {
      if (!monom.contains("x")) {
         monom = monom + "x0";
      }
      if (monom.contains("x") && (monom.length() == monom.indexOf("x") + 1)) {
         monom = monom + "1";
      }
      if (monom.indexOf("x") == 0) {
         monom = "1" + monom;
      }
      if ((monom.indexOf("x") == 1) && (monom.indexOf("-") == 0)) {
         monom = monom.substring(0, 1) + "1" + monom.substring(1, monom.length());
      }
      return monom;
   }
}
