/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    List<Client> clients = new ArrayList<Client>();
    int queueEmptyTime = 0;

    @Override
    public double getAverageServiceTime() {
        double totalServiceTime = 0; 
        int clientsNumber = 0;
        for(Client g : clients){
            totalServiceTime += g.getServiceTime();
            clientsNumber++;
        }
        
        return totalServiceTime / clientsNumber;
    }

    @Override
    public double getAverageWaitingTime() {
        double totalWaitingTime = 0;
        int clientsNumber = 0;
        for(Client g : clients){
            totalWaitingTime += g.getWaitingTime();
            clientsNumber++;
        }
        
        return totalWaitingTime / clientsNumber;
    }

    @Override
    public int getClientsNumber() {
       int number = 0;
        for(Client g : clients){
            number++;
        }
        return number;
    }

    @Override
    public void addClient(int arrivingTime) {
        Random rand = new Random();
        clients.add(ClientFactory.createClient(arrivingTime));
    }

    @Override
    public int getEmptyQueueTime() {
        return queueEmptyTime;
    }

    @Override
    public void incrementEmptyQueueTime() {
        queueEmptyTime++;
    }
    
    
    
    
    
}
