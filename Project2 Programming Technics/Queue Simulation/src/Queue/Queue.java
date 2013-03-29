package Queue;

import Client.Client;
import Client.ClientFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Vadim
 */
public class Queue implements QueueConstants, IQueue{
    
    private List<Client> clients = new ArrayList<Client>();
    private int queueEmptyTime = 0;
    private int totalWaitingTime = 0;
    private int totalServiceTime = 0;
    private int totalClientNumber = 0;
    
    public Queue(){
    }

    /**
     *
     * @return average service time for the queue.
     */
    @Override
    public double getAverageServiceTime() {
        if( totalClientNumber != 0) return totalServiceTime / totalClientNumber;
        return 0;
    }

    /**
     *
     * @return average time spent by the clients in the queue, until they get served.
     * 
     */
    @Override
    public double getAverageWaitingTime() {
        if ( totalClientNumber != 0 ) return totalWaitingTime / totalClientNumber;
        return 0;
    }
    
    /**
     *
     * @return actual waiting time in the queue.
     */
    @Override
    public int getWaitingTime() {
        int totalWaitingTime = 0;
        for(Client g : clients){
            totalWaitingTime += g.getWaitingTime();
        }
        return totalWaitingTime;
    }

    /**
     *
     * @return number of clients in the queue.
     */
    @Override
    public int getClientsNumber() {
       int number = 0;
        for(Client g : clients){
            number++;
        }
        return number;
    }

    /**
     *
     * @param arrivingTime arriving time of the new-coming client.
     * 
     */
    @Override
    public void addClient(int arrivingTime) {
        Random rand = new Random();
        int waitingTime = 0;
        Client newClient = ClientFactory.createClient(arrivingTime);
        for(Client c : clients){
            waitingTime += c.getServiceTime();
        }
        
        totalServiceTime += newClient.getServiceTime();
        totalWaitingTime += waitingTime;
        totalClientNumber ++;
        
        newClient.setWaitingTime(waitingTime);
        clients.add(newClient);
    }

    /**
     *
     * @return cumulated time of queue being empty.
     */
    @Override
    public int getEmptyQueueTime() {
        return queueEmptyTime;
    }

    /**
     *  if called, the method increments the time, the specified queue is empty.
     */
    @Override
    public void incrementEmptyQueueTime() {
        queueEmptyTime++;
    }

    /**
     *
     * @return last client of the specified queue.
     */
    @Override
    public Client returnLastClient() {
        Client q = clients.get(clients.size() - 1);
        clients.remove(clients.size() - 1);
        return q;
    }

    /**
     *
     * @param client client to be added in the queue.
     * 
     * adds a new client to the queue.
     */
    @Override
    public void addClient(Client client) {
        int waitingTime = 0;
        for(Client c : clients){
            waitingTime += c.getServiceTime();
        }
        client.setWaitingTime(waitingTime);
        clients.add(client);
        
        totalServiceTime += client.getServiceTime();
        totalWaitingTime += waitingTime;
        totalClientNumber ++;
    } 

    /**
     *
     * @param actualSimulationTime the actual time of the simulation
     * 
     * The methods verifies if any of the clients in the queue has finished his
     * job, and if so, removes it.
     */
    @Override
    public void seeIfClientLeaves(int actualSimulationTime) {
        for(Client c : clients){
        if(c.getServiceTime() + c.getWaitingTime() <= actualSimulationTime - c.getArrivingTime()){
            clients.remove(clients.indexOf(c));
            break;
        }
        }
    }
    
    /**
     *
     * @return true if there are no clients in the queue, else returns false.
     */
    @Override
    public boolean isEmpty(){
        if(clients.size() <= 0) return true;
        return false;
    }
    
}
