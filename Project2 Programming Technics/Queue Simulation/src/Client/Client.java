package Client;

/**
 *
 * @author Vadim
 * 
 * Class that identifies each client in the queue.
 */
public class Client {
    int serviceTime;
    int arrivingTime;
    int waitingTime;
    
    /**
     *
     * @param serviceTime Client's service time
     * @param arrivingTime Client's arriving time
     * 
     * The method creates a client with the given service and arriving times.
     */
    public Client(int serviceTime, int arrivingTime){
        this.serviceTime = serviceTime;
        this.arrivingTime = arrivingTime;      
    }
    
    /**
     *
     * @return service time of the client.
     */
    public int getServiceTime(){
        return serviceTime;
    }
    
    /**
     *
     * @return arriving time of the client;
     */
    public int getArrivingTime(){
        return arrivingTime;
    }
    
    /**
     *
     * @param waitingTime the time, the client has to spend in the que
     * until he will get served.
     * 
     * The method sets the waiting time of the client.
     */
    public void setWaitingTime(int waitingTime){
        this.waitingTime = waitingTime;
    }
    
    /**
     *
     * @return waiting time of the client.
     */
    public int getWaitingTime(){
        return waitingTime;
    }

    
}
