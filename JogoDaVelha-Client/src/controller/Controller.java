
package controller;

import java.io.IOException;
import utils.SocketClient;

/**
 * Classe controller responsável por realizar a comunicação centralizada para as demais classes do sistema.
 *
 * @author Fábio e Lucas Nogueira
 * @since 07/2022
 */
public class Controller {
    
    

    public void enviarPlayerServer(String address, int port, String player ) throws IOException {        
        SocketClient cliente = SocketClient.getInstance();
        cliente.init(address, port);
        cliente.setMensagem(player);        
        String resposta = cliente.call(); 
        
        System.out.println("Server: " + resposta);
    
    }
    

    
    
    
}
