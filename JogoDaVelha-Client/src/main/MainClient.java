package main;


import java.io.IOException;
import org.json.simple.parser.ParseException;
import view.Login;

/**
 * Classe de inicialização do Jogo da Velha no cliente.
 *
 * @author Fábio e Lucas Nogueira
 * @since 07/2022
 */
public class MainClient {

    public static void main(String[] args) throws IOException, ParseException {

        Login login = new Login();
        login.show();

        //        testConexao();
        
    }

    // Teste de conexão com o servidor.
//    public static void testConexao() throws IOException{        
//        SocketClient cliente = SocketClient.getInstance();
//        String msg = "Cliente enviou uma mensagem...";
//        cliente.init("localhost", 80);
//        cliente.setMensagem(msg);        
//        cliente.call();
//    } 
}
