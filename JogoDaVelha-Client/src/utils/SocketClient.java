package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável pelo tratamento de sockets na conversação entre cliente e servidor.
 *
 * @author Fabio e Lucas Nogueira
 * @since 07/2022
 */
public class SocketClient {

    private static String ADDRESS;
    private static int PORT;
    private static Socket socket;
    private String msg;

    private static SocketClient ss;

    private SocketClient() throws IOException {
    }

    public static SocketClient getInstance() {
        if (ss == null) {
            try {
                ss = new SocketClient();
            } catch (IOException ex) {
                Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ss;
    }

    public void init(String address, int port) {
        ADDRESS = address;
        PORT    = port;
    }

    public void setMensagem(String msg) {
        this.msg = msg;
    }

    public String call() throws IOException {
        socket = new Socket(ADDRESS, PORT);
        
        enviarDados();
        String res = receberDados();
        socket.close();

        return res;
    }

    private void enviarDados() throws IOException {
        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println(msg);
        pr.flush();
    }

    private String receberDados() throws IOException {
        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf    = new BufferedReader(in);
        String str           = bf.readLine();
        
        return str;
    }

}
