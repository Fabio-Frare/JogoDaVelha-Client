package main;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import utils.SocketClient;
import view.ViewLogin;

/**
 * Classe de inicialização do Jogo da Velha no cliente.
 *
 * @author Fábio e Lucas Nogueira
 * @since 07/2022
 */
public class MainClient {

    public static void main(String[] args) throws IOException, ParseException {

        ViewLogin login = new ViewLogin();
        login.show();
        
//        SocketClient socketClient = new SocketClient();  
//        socketClient.start();
        
    }
    
}
