package GUI;

import Client.Client;
import Queue.QueueConstants;
import Queue.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Vadim
 * 
 * The engine of the simulation. Generates appTime, queues, clients, 
 * tests all kind of situations..
 */
public class QueueSimulation implements QueueConstants {
    
   List<Queue> queueList = new ArrayList<Queue>();
   Queue queueNr1 = new Queue();
   Queue queueNr2 = new Queue();
   Queue queueNr3 = new Queue();
   int simulationTime = 0;
   int lastClientArrivingTime = 0;
   int arrivingTime = 0;
   int timeGap = 0;
   
    public QueueSimulation(){ 
    }
    
    /**
     *
     * @param simulationTime simulation time.
     */
    public void setSimulationTime(int simulationTime){
        this.simulationTime = simulationTime;
    }
    
    /**
     * The method adds a new queue to the list, if there are no active queues.
     */
    public void addInitialQueue(){
        if(simulationTime == 0){
             if(queueList.size() <= 0) queueList.add(queueNr1);
        }
    }
    
    /**
     *  Method that verifies if any client has to leave the queue.
     */
    public void seeIfAnyClientLeaves(){
        for(Queue q : queueList)
                if(!q.isEmpty())
                    q.seeIfClientLeaves(simulationTime);
    }
    
     
    /**
     *  method that randomly adds clients to the queues.
     */
    public void addClientsToQueues(){
        Random arrivingTimeGenerator = new Random();
        int minWaitingTime = 0;
        int queueIndex = 0;
        
        if(queueList.size() != 0){
            minWaitingTime = queueList.get(0).getWaitingTime();
            queueIndex = 0;
        
        for(Queue q : queueList){
             if(q.getWaitingTime() < minWaitingTime)
                {
                    queueIndex = queueList.indexOf(q);
                }
            }
            
        arrivingTime = minimumArrivingTime + arrivingTimeGenerator.nextInt(maximumArrivingTime);
        timeGap = arrivingTime;
        if(simulationTime <= lastClientArrivingTime + arrivingTime) {
            queueList.get(queueIndex).addClient(lastClientArrivingTime + arrivingTime); 
            lastClientArrivingTime += arrivingTime;
            
            }
        }      
    }
    
    /**
     *  method that verifies if the queues are empty, if so, increments their empty time.
     */
    public void seeIfQueueIsEmpty(){
        for(Queue q : queueList)
            if(q.getClientsNumber() == 0) q.incrementEmptyQueueTime();
    }
    
    /**
     *  method that adds queues after a specified amount of time.
     */
    public void addQueueIfTooMuchClients(){
        Queue addedQueue = null;
        int listSize = queueList.size();
        boolean permissionToOpenQueue = false;
        boolean clientMigration = true;
        
        if(simulationTime == 60) {
            queueList.add(queueNr2);
            for(int i = 0; i < queueNr1.getClientsNumber() / 2; i++)
                queueNr2.addClient(queueNr1.returnLastClient());
        }
        if(simulationTime == 120) {
            queueList.add(queueNr3);
            for(int i = 0; i < (queueNr1.getClientsNumber() + queueNr2.getClientsNumber()) / 4; i++){
                if(i % 2 == 0) queueNr3.addClient(queueNr2.returnLastClient());
                else queueNr3.addClient(queueNr1.returnLastClient());
            }
        }   
    }
    
    public static void main(String[] args) {
        QueueSimulation queueSimulation = new QueueSimulation();
        SimulationFrame frame = new SimulationFrame();
        String s = "               ";
        
        
        //simulare pentru 180 de secunde
       for(int j = 0; j < simulationInterval; j++){
            frame.AppTime.setText(j+"");
            if(frame.simulationPaused) {
                j--;
                continue;
            }
            else{
            for(long i = 0; i < 300000000; i++);
           
            queueSimulation.setSimulationTime(j);
            queueSimulation.addInitialQueue();
            queueSimulation.seeIfAnyClientLeaves();
            if(j >= queueSimulation.lastClientArrivingTime) queueSimulation.addClientsToQueues();
            queueSimulation.seeIfQueueIsEmpty();
            queueSimulation.addQueueIfTooMuchClients();
            
            
            for(Queue q : queueSimulation.queueList){
                if(queueSimulation.queueList.indexOf(q) == 0)
                    frame.labelQueue1.setText("Queue1:  "+s+q.getClientsNumber()+s+"  "+s+q.getAverageWaitingTime()+s+"  "+s+q.getAverageServiceTime()+s+"  "+s+q.getEmptyQueueTime());
                else if(queueSimulation.queueList.indexOf(q) == 1)
                    frame.labelQueue2.setText("Queue2:  "+s+q.getClientsNumber()+s+"  "+s+q.getAverageWaitingTime()+s+"  "+s+q.getAverageServiceTime()+s+"  "+s+q.getEmptyQueueTime());
                else if(queueSimulation.queueList.indexOf(q) == 2)
                    frame.labelQueue3.setText("Queue3:  "+s+q.getClientsNumber()+s+"  "+s+q.getAverageWaitingTime()+s+"  "+s+q.getAverageServiceTime()+s+"  "+s+q.getEmptyQueueTime());
            }
    
            }
       }
    }
}
