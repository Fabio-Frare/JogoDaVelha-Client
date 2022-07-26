package controller;

import java.io.IOException;
import java.net.InetAddress;
import org.json.simple.parser.ParseException;
import utils.SocketClient;
import utils.Utils;
import view.ViewJogo;

/**
 * Classe controller responsável por realizar a comunicação centralizada para as
 * demais classes do sistema.
 *
 * @author Fábio e Lucas Nogueira
 * @since 07/2022
 */
public class Controller {

    private Utils utils;
    private String msg;
    private ViewJogo jogo;

    
    

    public void enviarPlayerServer(String addressServer, int portServer, String nomePlayer) throws IOException, ParseException {
        utils = new Utils();
        
        SocketClient cliente = SocketClient.getInstance();       
        cliente.init(addressServer, portServer);
        String addressClient = InetAddress.getLocalHost().getHostAddress();
       
        msg = utils.convertePlayerToJson(nomePlayer, addressClient);
        
        cliente.setMensagem(msg);
//        cliente.start();
        
        String resposta = cliente.call();

        trataDados(resposta);
        
//        System.out.println("Server: " + resposta);

    }
    
    public void trataDados(String msg) throws ParseException {
        
        System.out.println("Trata Dados: " + msg);        
        String operacao = utils.retornaOperacao(msg);
        jogo = new ViewJogo();
        
        switch (operacao) {
            
            case "1": // Liberar o jogo para o player
                jogo.setCaracterPlayer(utils.buscaCaracterPlayer(msg));
                jogo.setLiberado(utils.jogoLiberado(msg));
                jogo.show();
                break;
                
            case "2": // Bloqueia o jogo / número máximo de players                
                String retorno = utils.buscaMensagem(msg);                
                jogo.numeroMaximoPlayers(retorno);
                break;
                        
            case "3": // Recebe atualização
//                SocketClient sc = SocketClient.getInstance();
//                sc.start();
                recebeAtualizacao(msg);
                break;
                
            case "4": // Atualiza servidor
                enviaAtualizacaoServidor();
                break;
        }        
        
    }
    
    public void recebeAtualizacao(String msg) {
        System.out.println("Recebeu atualização: " + msg);
        
    }

    private void enviaAtualizacaoServidor() {
        System.out.println("Envia atualização p/ Servidor: ");
    }


    

}
