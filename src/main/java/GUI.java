import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI extends JFrame {
    private JPanel mainPanel;
    private JTextField tSimTxt;
    private JTextField minArivTxt;
    private JTextField maxArivTxt;
    private JTextField minServiceTxt;
    private JTextField maxSericeTxt;
    private JTextField clientiTxt;
    private JTextField coziTxt;
    private JLabel tSim;
    private JLabel minAriv;
    private JLabel maxAriv;
    private JLabel minService;
    private JLabel maxService;
    private JLabel clientiLabel;
    private JLabel coziLabel;
    private JButton startButton;
    private JLabel simulareLabel;
    private JTextArea rez;
    public int timeLimit ;
    public int minArivTime ;
    public int maxArivTime ;
    public int minServiceTime ;
    public int maxServiceTime ;
    public int nrClienti ;
    public int nrCozi ;
    public GUI() {
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tSim = tSimTxt.getText() ;
                timeLimit = Integer.parseInt(tSim) ;
                String minAriv = minArivTxt.getText() ;
                minArivTime = Integer.parseInt(minAriv) ;
                String maxAriv = maxArivTxt.getText() ;
                maxArivTime = Integer.parseInt(maxAriv) ;
                String minStime = minServiceTxt.getText() ;
                minServiceTime = Integer.parseInt(minStime) ;
                String maxStime = maxSericeTxt.getText() ;
                maxServiceTime = Integer.parseInt(maxStime) ;
                String clienti = clientiTxt.getText() ;
                nrClienti = Integer.parseInt(clienti) ;
                String cozi = coziTxt.getText() ;
                nrCozi = Integer.parseInt(cozi) ;

                SimulationManager simulationManager = new SimulationManager(timeLimit,minArivTime,maxArivTime,minServiceTime,maxServiceTime,nrClienti,nrCozi) ;
                Thread t = new Thread(simulationManager) ;
                t.start();
            }
        });
    }
    public int[] getDate(){
        int[] array = {timeLimit,minArivTime,maxArivTime,minServiceTime,maxServiceTime,nrClienti,nrCozi};
        return array ;
    }
    public static void main(String[] args) {
        GUI gui = new GUI() ;
        gui.setContentPane(gui.mainPanel);
        gui.setTitle("SimulatorCozi");
        gui.setSize(400,400);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
