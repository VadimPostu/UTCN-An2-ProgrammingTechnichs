/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Random;

/**
 *
 * @author Vadim
 */
public class QueueSimulation implements Queue.QueueConstants {

   public void simulateQueues(){
       int lastClientArrivingTime = 0;
       Random arrivingTimeGenerator = new Random();
       
       //simulare pentru 5000 de secunde
       for(long j = 0; j < simulationInterval; j++){
            for(long i = 0; i < 1200000000; i++);
            int arrivingTime = minimumArrivingTime + arrivingTimeGenerator.nextInt(maximumArrivingTime);
        
        }
       
   }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
