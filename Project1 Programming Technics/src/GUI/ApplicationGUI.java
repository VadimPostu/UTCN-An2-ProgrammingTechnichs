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
import polinome.Polinome;
import processor.PolinomeBuilder;

/**
 *
 * @author Vadim Class that builds the application GUI and appeals the functions
 * that execute the requested operations.
 *
 */
public class ApplicationGUI extends JFrame {

    JLabel label = new JLabel();
    JLabel labelAchtung = new JLabel();
    JLabel messageLabel = new JLabel("Some polynome samples");
    JPanel messagePanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JPanel errorPanel = new JPanel();
    JPanel examplePanel = new JPanel();
    JTextField firstPolinome = new JTextField("Write your polinome here");
    JTextField secondPolinome = new JTextField("");
    JTextField polinomeExample1 = new JTextField("-x4+13x3-2x2+7x+9");
    JTextField polinomeExample2 = new JTextField("5x1000+8x4-4");
    JTextField polinomeExample3 = new JTextField("-x5-x4-x3-x2-x-1");
    JTextField polinomeExample4 = new JTextField("-x1");
    JButton buttonSum = new JButton("Suma");
    JButton buttonSubtract = new JButton("Diferenta");
    JButton buttonMultiply = new JButton("Produs");
    JButton buttonDerivate = new JButton("Derivare");
    JFrame frame = new JFrame("Procesare Polinoame");
    GridLayout layout = new GridLayout(10, 2);
    GridLayout panelLayout = new GridLayout(2, 2);

    ApplicationGUI() {
    }

    /**
     * Method that creates the frame of the application.
     */
    public void buildFrame() {
        ActionListener listener;
        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PolinomeBuilder builder = new PolinomeBuilder();
                Polinome polinom1 = new Polinome();
                Polinome polinom2 = new Polinome();
                String pol1 = firstPolinome.getText();
                String pol2 = secondPolinome.getText();

                Boolean arePolinomesValid = true;
                if (!builder.isPolinomeRepresentationValid(pol1)) {
                    // afisez mesaj pentru 1 polinom
                    firstPolinome.setForeground(Color.red);
                    arePolinomesValid = false;
                }
                if (!builder.isPolinomeRepresentationValid(pol2)) {
                    // afisez mesaj pentru 2 polinom
                    secondPolinome.setForeground(Color.red);
                    arePolinomesValid = false;
                }
                if (!arePolinomesValid) {
                    label.setText("Polinomul este reprezentat gresit");
                    return;
                }

                polinom1 = builder.parsePolinome(pol1);
                polinom2 = builder.parsePolinome(pol2);

                String polinom_rezultant = new String();
                if ((JButton) e.getSource() == buttonSum) {
                    polinom_rezultant = polinom1.add(polinom2).toString();
                } else if ((JButton) e.getSource() == buttonSubtract) {
                    polinom_rezultant = polinom1.subtract(polinom2).toString();
                } else if ((JButton) e.getSource() == buttonMultiply) {
                    polinom_rezultant = polinom1.multiply(polinom2).toString();
                } else if ((JButton) e.getSource() == buttonDerivate) {
                    polinom_rezultant = polinom1.derivate().toString();
                }

                label.setText(polinom_rezultant);
            }
        };
        FocusListener focusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                JTextField source = (JTextField) fe.getComponent();
                source.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent fe) {
                
            }
        };

        frame.setLayout(layout);
        labelAchtung.setText("Exemplu de introducere a polinomului: 13x2+17x3+15+24x");
        messagePanel.add(labelAchtung);
        frame.add(messagePanel);
        frame.add(firstPolinome);
        firstPolinome.setSize(10, 50);
        firstPolinome.setFocusable(rootPaneCheckingEnabled);
        firstPolinome.selectAll();
        frame.add(secondPolinome);
        secondPolinome.setSize(10, 50);
        buttonsPanel.add(buttonSum);
        buttonSum.addActionListener(listener);
        buttonsPanel.add(buttonSubtract);
        buttonSubtract.addActionListener(listener);
        buttonsPanel.add(buttonMultiply);
        buttonMultiply.addActionListener(listener);
        buttonsPanel.add(buttonDerivate);
        buttonDerivate.addActionListener(listener);
        errorPanel.add(label);
        label.setText("");
        polinomeExample1.setEditable(false);
        polinomeExample2.setEditable(false);
        polinomeExample3.setEditable(false);
        polinomeExample4.setEditable(false);
        examplePanel.setLayout(panelLayout);
        examplePanel.add(polinomeExample1);
        examplePanel.add(polinomeExample2);
        examplePanel.add(polinomeExample3);
        examplePanel.add(polinomeExample4);

        firstPolinome.addFocusListener(focusListener);
        secondPolinome.addFocusListener(focusListener);

        frame.add(buttonsPanel);
        frame.add(errorPanel);
        frame.add(messageLabel);
        frame.add(examplePanel);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);

    }

    public static void main(String args[]) {
        ApplicationGUI frame = new ApplicationGUI();
        frame.buildFrame();
    }
}
