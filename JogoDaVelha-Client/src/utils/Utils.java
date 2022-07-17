package utils;

import java.util.ArrayList;
import java.util.List;
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
        playerJson.put("nome", nome);
        playerJson.put("endereco", address);
//        System.out.println("Utils: " + playerJson.toJSONString());

        return playerJson.toJSONString();
    }
    
    public String retornaOperacao(String msg) throws ParseException {

        JSONObject jsonObject;
        JSONParser parser = new JSONParser();
        jsonObject        = (JSONObject) parser.parse(msg);
        String operacao   = (String) jsonObject.get("operacao");
        
        return operacao;
    }
    
//    public Pessoa converteJsonToPessoa(String msg) throws ParseException {
//        
//        JSONParser parser = new JSONParser(); 
//        JSONObject json = (JSONObject) parser. parse(msg);
//        
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNome((String) json.get("nome"));
//        pessoa.setCpf((String) json.get("cpf"));
//        pessoa.setEndereco((String) json.get("endereco"));
//        
//        return pessoa;        
//
//    }
//
//    public String converteEmpresaToJson (Empresa empresa, String operacao) {
//
//     JSONObject empresaJson = new JSONObject();  
//     empresaJson.put("operacao", operacao);
//     empresaJson.put("entidade", "empresa");
//     empresaJson.put("nome"    , empresa.getNome());
//     empresaJson.put("cnpj"     , empresa.getCnpj());      
//
//     return empresaJson.toJSONString();
// }
//    
//    public Empresa converteJsonToEmpresa(String msg) throws ParseException {
//        
//        JSONParser parser = new JSONParser(); 
//        JSONObject json = (JSONObject) parser. parse(msg);
//        
//        Empresa empresa = new Empresa();
//        empresa.setNome((String) json.get("nome"));  
//        empresa.setCnpj((String) json.get("cnpj"));
//        
//        return empresa;        
//    }
//    
//    public String retornaOperacao(String msg) throws ParseException {
//        
//        JSONObject jsonObject;
//        JSONParser parser = new JSONParser();        
//        jsonObject = (JSONObject) parser.parse(msg);
//        
//        String operacao = (String) jsonObject.get("operacao");
//        
//        return operacao;
//    }
//    
//    public String retornaEntidade(String msg) throws ParseException {
//        
//        JSONObject jsonObject;
//        JSONParser parser = new JSONParser();        
//        jsonObject = (JSONObject) parser.parse(msg);
//        
//        String entidade = (String) jsonObject.get("entidade");
//        
//        return entidade;
//    }
//    
//    public String retornaOperacaoToJson(String operacao){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("operacao", operacao);
//        String jsonOperacao = jsonObject.toJSONString();
//        
//        return jsonOperacao;
//    }
//
//    public List<Empresa> converteJsonToEmpresas(String msg) throws ParseException {
//        List<Empresa> listaEmpresa = new ArrayList<>();
//        JSONParser    parser       = new JSONParser();
//        JSONObject    json         = (JSONObject) parser.parse(msg);
//        
//        for(int i = 0; i < json.size(); i++){
//            String sEmpresa = json.get(String.valueOf(i)).toString();
//            Empresa empresa = converteJsonToEmpresa(sEmpresa);
//
//            listaEmpresa.add(empresa);
//        }
//        
//        return listaEmpresa;
//    }

    public String buscaMensagem(String msg) throws ParseException {
        
        JSONParser parser = new JSONParser(); 
        JSONObject json = (JSONObject) parser. parse(msg);        
        String resposta = (String) json.get("msg");  
        
        return resposta;
    
    }




}
