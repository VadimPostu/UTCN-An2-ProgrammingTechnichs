/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

/**
 *
 * @author Vadim
 */
public interface IQueue {
    
    public double getAverageServiceTime();
    
    public double getAverageWaitingTime();
    
    public int getClientsNumber();
    
    public void addClient(int arrivingTime);
    
    public int getEmptyQueueTime();
    
    public void incrementEmptyQueueTime();
}
