package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class ThreadAuxiliar extends Thread {
    
    public String retorno = " ";
    
    public ThreadAuxiliar() {
//        start();
    }
    
    
    @Override
    public void run() {
        SocketClient socketClient = SocketClient.getInstance();
        try {
            System.out.println("Thread Aux");
           retorno = socketClient.receberDados();           
        } catch (IOException ex) {
            Logger.getLogger(ThreadAuxiliar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }
    
    
}
