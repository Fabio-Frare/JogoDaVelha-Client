package controller;

import java.io.IOException;
import java.net.InetAddress;
import utils.SocketClient;
import utils.Utils;

/**
 * Classe controller responsável por realizar a comunicação centralizada para as
 * demais classes do sistema.
 *
 * @author Fábio e Lucas Nogueira
 * @since 07/2022
 */
public class Controller {

    private Utils utils;
    private static String msg = "";
    
    

    public void enviarPlayerServer(String addressServer, int portServer, String nomePlayer) throws IOException {
        utils = new Utils();
        
        SocketClient cliente = SocketClient.getInstance();       
        cliente.init(addressServer, portServer);
        String addressClient = InetAddress.getLocalHost().getHostAddress();
       
        msg = utils.convertePlayerToJson(nomePlayer, addressClient);
        
        cliente.setMensagem(msg);
        String resposta = cliente.call();

        System.out.println("Server: " + resposta);

    }

}
