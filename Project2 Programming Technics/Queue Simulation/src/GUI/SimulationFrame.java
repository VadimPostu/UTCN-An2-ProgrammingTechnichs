package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Vadim
 * 
 * GUI of the app.
 */
public class SimulationFrame extends JFrame{
    JTextField AppTime = new JTextField();
    JLabel labelQueue1 = new JLabel();
    JLabel labelQueue2 = new JLabel();
    JLabel labelQueue3 = new JLabel();
    JLabel outputLabel = new JLabel();
    JPanel outputPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel emptyPanel = new JPanel();
    JButton buttonStop = new JButton("Pauza");
    JButton buttonContinue = new JButton("Continua");
    JFrame frame = new JFrame("Queue Simulation");
    GridLayout layout = new GridLayout(10, 2);
    GridLayout panelLayout = new GridLayout(2, 2);
    boolean simulationPaused = false;

    SimulationFrame() {
       this.buildFrame();
    }
    
    public void buildFrame(){
        String s = "  ";
        frame.setLayout(layout);
        outputLabel.setText("Queue:"+s+"   Nr. of Clients:  "+s+"  avg. Waiting Time:  "+s+" avg. Service Time: "+s+" empty Queue Time:");
        frame.add(outputLabel);
        
        frame.add(AppTime);
        AppTime.setEditable(false);
        
        frame.add(emptyPanel);
        frame.add(labelQueue1);
        
        frame.add(emptyPanel);
        frame.add(labelQueue2);
        
        frame.add(emptyPanel);
        frame.add(labelQueue3);
       
        buttonPanel.add(buttonStop);
        buttonPanel.add(buttonContinue);

        frame.add(emptyPanel);
        frame.add(buttonPanel);

        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    simulationPaused = true;
             }
        };
        ActionListener listener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    simulationPaused = false;
             }
        };
        this.buttonStop.addActionListener(listener1);
        this.buttonContinue.addActionListener(listener2);
    }
    
}
