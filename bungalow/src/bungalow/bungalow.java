package bungalow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

 

public class bungalow extends JFrame {
    private JTextField textBungalowNr;
    private JTextField textStartWoche;
    private JTextField textEndWoche;
    private JTextField textAnzahlPersonen;
    private JTextField textRueckmeldung;

 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

 

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    bungalow frame = new bungalow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

 

    /**
     * Create the frame.
     */
    public bungalow() {
        int[][] reservierungen = new int[10][4];

 


        System.out.println("Buchungen 2023");
        System.out.println("----------------------------");
        System.out.println("Bungalow-Nr: " + reservierungen[0][0]);
        System.out.println("Start-KW: " + reservierungen[0][1]);
        System.out.println("End-KW: " + reservierungen[0][2]);
        System.out.println("Anzahl Personen: " + reservierungen[0][3]);

 

        setBounds(300,300,800,600);
        setAutoRequestFocus(false);
        setPreferredSize(new Dimension(800, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 

        boolean reservierungDurchfuehren = false;

 

        JButton btnReservierungDurchfuehren = new JButton("Reservierung Durchf\u00FChren");
        btnReservierungDurchfuehren.setBounds(27, 250, 200, 60);
        btnReservierungDurchfuehren.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int bungalowNummer = Integer.parseInt(textBungalowNr.getText());
                int startWoche = Integer.parseInt(textStartWoche.getText());
                int endWoche = Integer.parseInt(textEndWoche.getText());
                int anzahlPersonen = Integer.parseInt(textAnzahlPersonen.getText());
                
                
                if(bungalowNummer >= 1 && bungalowNummer <= 10) {
                    if(startWoche >= 1 && startWoche <= 51) {
                        if(endWoche >= 2 && endWoche <= 52) {
                            if(endWoche > startWoche) {
                                reservierungen[bungalowNummer - 1][0] = bungalowNummer;
                                reservierungen[bungalowNummer - 1][1] = startWoche;
                                reservierungen[bungalowNummer - 1][2] = endWoche;
                                reservierungen[bungalowNummer - 1][3] = anzahlPersonen;
                            }
                        }
                    }
                }
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(btnReservierungDurchfuehren);

 

        JButton btnNewButton_2 = new JButton("EXIT");
        btnNewButton_2.setBounds(578, 332, 123, 60);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(btnNewButton_2);

 

        textBungalowNr = new JTextField();
        textBungalowNr.setBounds(159, 21, 164, 40);
        getContentPane().add(textBungalowNr);
        textBungalowNr.setColumns(10);
        
        textStartWoche = new JTextField();
        textStartWoche.setBounds(159, 72, 164, 40);
        textStartWoche.setColumns(10);
        getContentPane().add(textStartWoche);

 

        JLabel lblBungalowNr = new JLabel("Bungalow-Nummer:");
        lblBungalowNr.setBounds(27, 21, 100, 40);
        getContentPane().add(lblBungalowNr);

 

        JLabel lblStartWoche = new JLabel("Start-Woche:");
        lblStartWoche.setBounds(27, 72, 100, 40);
        getContentPane().add(lblStartWoche);

 

        JLabel lblEndWoche = new JLabel("End-Woche:");
        lblEndWoche.setBounds(27, 123, 100, 40);
        getContentPane().add(lblEndWoche);

 

        textEndWoche = new JTextField();
        textEndWoche.setColumns(10);
        textEndWoche.setBounds(159, 123, 164, 40);
        getContentPane().add(textEndWoche);

 

        textAnzahlPersonen = new JTextField();
        textAnzahlPersonen.setColumns(10);
        textAnzahlPersonen.setBounds(159, 173, 164, 40);
        getContentPane().add(textAnzahlPersonen);

 

        JLabel lblAnzahlPersonen = new JLabel("Anzahl Personen:");
        lblAnzahlPersonen.setBounds(27, 174, 100, 40);
        getContentPane().add(lblAnzahlPersonen);

 

        textRueckmeldung = new JTextField();
        textRueckmeldung.setColumns(10);
        textRueckmeldung.setBounds(27, 332, 200, 40);
        getContentPane().add(textRueckmeldung);

 

        JLabel lblAuswahlBungalowAnzeige = new JLabel("Bungalow ausw\u00E4hlen:");
        lblAuswahlBungalowAnzeige.setBounds(425, 21, 120, 40);
        getContentPane().add(lblAuswahlBungalowAnzeige);

 

        JTextArea textBuchungenAnzeigen = new JTextArea();
        textBuchungenAnzeigen.setColumns(10);
        textBuchungenAnzeigen.setBounds(425, 72, 200, 200);
        getContentPane().add(textBuchungenAnzeigen);
        
        JComboBox comboAuswahlBungalow = new JComboBox();
        comboAuswahlBungalow
                .setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        comboAuswahlBungalow.setMaximumRowCount(10);
        comboAuswahlBungalow.setBounds(580, 26, 45, 30);
        getContentPane().add(comboAuswahlBungalow);
        comboAuswahlBungalow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int bungalowNummer = comboAuswahlBungalow.getSelectedIndex() + 1;

 

                textBuchungenAnzeigen.setText("Bungalow-Nr: " + reservierungen[bungalowNummer - 1][0] + "\n"+
                        "Start-KW: " + reservierungen[bungalowNummer - 1][1] + " \n" + 
                        "End-KW: " + reservierungen[bungalowNummer - 1][2] + " \n" +  
                        "Anzahl Personen: " + reservierungen[bungalowNummer - 1][3] + "");
                
            }
        });
    }
}