/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.util.Random;

/**
 *
 * @author Vadim
 */
public class ClientFactory{
    private static int minimumServiceTime = 5;
    private static int maximumServiceTime = 20;
    
    public static Client createClient(int arrivingTime){
        Random rand = new Random();
        int serviceTime = minimumServiceTime + rand.nextInt(maximumServiceTime - minimumServiceTime);
        return new Client(serviceTime, arrivingTime);
    }
}
