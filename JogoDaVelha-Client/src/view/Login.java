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

/**
 * View responsável por coletar dados do player.
 *
 * @author Fábio e Lucas Nogueira
 * @since 07/2022
 */
public class Login {

    private JFrame frame;
    private JTextField txfPlayer;
    private JTextField txfClientIP;
    private JTextField txfClientPort;

    public void show() {

        frame = new JFrame("Jogo da Velha");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel nomePlayer = new JLabel("Player");
        nomePlayer.setBounds(10, 20, 80, 25);

        txfPlayer = new JTextField();
        txfPlayer.setBounds(70, 20, 160, 25);

        JLabel clientIP = new JLabel("IP");
        clientIP.setBounds(10, 50, 80, 25);

        txfClientIP = new JTextField();
        txfClientIP.setBounds(70, 50, 160, 25);

        JLabel clientPort = new JLabel("Porta");
        clientPort.setBounds(10, 80, 80, 25);

        txfClientPort = new JTextField();
        txfClientPort.setBounds(70, 80, 160, 25);

        JButton iniciarJogo = new JButton("Iniciar");
        iniciarJogo.setBounds(70, 120, 160, 25);
        
        iniciarJogo.addActionListener(e -> {
            try {
                iniciarJogoListner();
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        panel.add(nomePlayer);
        panel.add(txfPlayer);
        
        panel.add(clientIP);
        panel.add(txfClientIP);
        
        panel.add(clientPort);
        panel.add(txfClientPort);
        
        panel.add(iniciarJogo);

        frame.add(panel);
        frame.getRootPane().setDefaultButton(iniciarJogo);
        frame.setVisible(true);

    }

//    private void iniciarJogoListner() {
//        {
//
//            String usuario = txfPlayer.getText();
//            String senha = String.valueOf(txfClientIP.getPassword());
//
//            if (usuario.equals("fabio") && senha.equals("123")) {
//                // entra no jogo se o usuario for joao e a senha 123
//                Jogo jogo = new Jogo();
//                jogo.show();
//                frame.setVisible(false);  // esconde janela de login
//            } else {
//                // caso contrário, mostra mensagem que não conseguiu entrar
//                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.");
//            }
//        }
//
//    }

    private void iniciarJogoListner() throws IOException {
        
        String player   = txfPlayer.getText();
        String clientIP = txfClientIP.getText();
        int clientPort  = Integer.parseInt(txfClientPort.getText());
         
        if(!player.isEmpty() && !clientIP.isEmpty() && clientPort > 0) {
            Controller controller = new Controller();
            controller.enviarPlayerServer(clientIP, clientPort, player);
        } else {
            JOptionPane.showMessageDialog(null, "Favor informar todos os dados.");
        }
    }
    
}
