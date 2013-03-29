package Client;

import java.util.Random;

/**
 *
 * @author Vadim
 * 
 * Class that is creates new clients.
 */
public class ClientFactory{
    private static int minimumServiceTime = 3;
    private static int maximumServiceTime = 10;
    
    /**
     *
     * @param arrivingTime arriving time of the new client.
     * @return the new client.
     */
    public static Client createClient(int arrivingTime){
        Random rand = new Random();
        int serviceTime = minimumServiceTime + rand.nextInt(maximumServiceTime - minimumServiceTime);
        return new Client(serviceTime, arrivingTime);
    }
}
