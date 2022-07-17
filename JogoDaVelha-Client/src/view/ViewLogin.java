package view;

import controller.Controller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.json.simple.parser.ParseException;

/**
 * View responsável por coletar dados do player e enviar ao servidor.
 *
 * @author Fábio e Lucas Nogueira
 * @since 07/2022
 */
public class ViewLogin {

    private JFrame frame;
    private JTextField txfNomePlayer;
    private JTextField txfAddressServer;
    private JTextField txfPortServer;

    public void show() {

        frame = new JFrame("Jogo da Velha");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel nomePlayer = new JLabel("Player");
        nomePlayer.setBounds(10, 20, 80, 25);

        txfNomePlayer = new JTextField();
        txfNomePlayer.setBounds(70, 20, 160, 25);

        JLabel addressServer = new JLabel("IP");
        addressServer.setBounds(10, 50, 80, 25);

        txfAddressServer = new JTextField();
        txfAddressServer.setBounds(70, 50, 160, 25);

        JLabel portServer = new JLabel("Porta");
        portServer.setBounds(10, 80, 80, 25);

        txfPortServer = new JTextField();
        txfPortServer.setBounds(70, 80, 160, 25);

        JButton iniciarJogo = new JButton("Iniciar");
        iniciarJogo.setBounds(70, 120, 160, 25);
        
        iniciarJogo.addActionListener((var e) -> {
            try {
                iniciarJogoListner();
            } catch (IOException | ParseException ex) {
                Logger.getLogger(ViewLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

       metodoAuxiliarAlimentaCampos();
        
        panel.add(nomePlayer);
        panel.add(txfNomePlayer);
        
        panel.add(addressServer);
        panel.add(txfAddressServer);
        
        panel.add(portServer);
        panel.add(txfPortServer);
        
        panel.add(iniciarJogo);

        frame.add(panel);
        frame.getRootPane().setDefaultButton(iniciarJogo);
        frame.setVisible(true);

    }

    private void iniciarJogoListner() throws IOException, ParseException {
        
        String nomePlayer    = txfNomePlayer.getText();
        String addressServer = txfAddressServer.getText();
        int portServer       = Integer.parseInt(txfPortServer.getText());
         
        if(!nomePlayer.isEmpty() && !addressServer.isEmpty() && portServer > 0) {
            Controller controller = new Controller();
            controller.enviarPlayerServer(addressServer, portServer, nomePlayer); 
            frame.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Favor informar todos os dados.");
        }
    }
    
    private void metodoAuxiliarAlimentaCampos() {
        txfNomePlayer.setText("Fabio");
        txfAddressServer.setText("Localhost");
        txfPortServer.setText("80");   
    }
    
}
