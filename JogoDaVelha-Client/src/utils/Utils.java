package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author fabio
 */
public class Utils {
    
    public String convertePlayerToJson (String nome, String address) {
        
        JSONObject playerJson = new JSONObject();  
        playerJson.put("operacao", "1");
        playerJson.put("nome"    , nome);
        playerJson.put("endereco", address);
//        System.out.println("Utils: " + playerJson.toJSONString());

        return playerJson.toJSONString();
    }
    
    public String atualizaPosicaoClicada(String posicaox, String posicaoy, String caracterPlayer) {
        
        JSONObject playerJson = new JSONObject();  
        playerJson.put("operacao", "2");
        playerJson.put("posicaox", posicaox);
        playerJson.put("posicaoy", posicaoy);
        playerJson.put("caracter", caracterPlayer);
        
//        System.out.println("atualizaPosicaoClicada " + playerJson.toJSONString() );

        return playerJson.toJSONString();
    }
    
    
    public String retornaOperacao(String msg) throws ParseException {

        JSONObject jsonObject;
        JSONParser parser = new JSONParser();
        jsonObject        = (JSONObject) parser.parse(msg);
        String operacao   = (String) jsonObject.get("operacao");
        
        return operacao;
    }

    public String buscaMensagem(String msg) throws ParseException {
        
        JSONParser parser = new JSONParser(); 
        JSONObject json = (JSONObject) parser. parse(msg);        
        String resposta = (String) json.get("msg");  
        
        return resposta;
    
    }

    public String buscaCaracterPlayer(String msg) throws ParseException {
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();
        jsonObject        = (JSONObject) parser.parse(msg);
        String caracter   = (String) jsonObject.get("caracter");
        
        return caracter;
    
    }

    public boolean jogoLiberado(String msg) throws ParseException {
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();
        jsonObject        = (JSONObject) parser.parse(msg);
        boolean liberado  =  (boolean) jsonObject.get("liberado");
        
        return liberado;
    
    }




}
