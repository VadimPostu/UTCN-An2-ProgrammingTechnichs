/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Vadim
 */
public class Client {
    int serviceTime;
    int arrivingTime;
    int waitingTime;
    
    public Client(int serviceTime, int arrivingTime){
        this.serviceTime = serviceTime;
        this.arrivingTime = arrivingTime;      
    }
    
    public int getServiceTime(){
        return serviceTime;
    }
    
    public int getArrivingTime(){
        return arrivingTime;
    }
    
    public void setWaitingTime(int waitingTime){
        this.waitingTime = waitingTime;
    }
    
    public int getWaitingTime(){
        return waitingTime;
    }

    
}
