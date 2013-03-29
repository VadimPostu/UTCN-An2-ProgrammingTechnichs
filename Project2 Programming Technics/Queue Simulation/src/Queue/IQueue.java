/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import Client.Client;

/**
 *
 * @author Vadim
 * 
 * Interface that shows all the features of the Queues.
 */
public interface IQueue {
    
    public double getAverageServiceTime();
    
    public double getAverageWaitingTime();
    
    public int getWaitingTime();
    
    public int getClientsNumber();
    
    public void addClient(int arrivingTime);
    
    public int getEmptyQueueTime();
    
    public void incrementEmptyQueueTime();
    
    public Client returnLastClient();
    
    public void addClient(Client client);
    
    public void seeIfClientLeaves(int actualSimulationTime);
    
    public boolean isEmpty();
}
