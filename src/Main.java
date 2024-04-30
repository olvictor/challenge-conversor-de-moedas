import br.com.olvictor.modelos.Conversor;
import br.com.olvictor.modelos.responseDTO;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;

import java.net.http.HttpClient;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        try{

        Scanner  sc = new Scanner(System.in);
        Conversor conversor = new Conversor();
        boolean continuarLoop = true;
        while(continuarLoop){
            System.out.println("""
                **********************************************
                Seja bem vindo/a  ao conversor de moedas =]


                1) Dólar =>> Peso Argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real Brasileiro
                4) Real Brasileiro =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso Colombiano =>> Dólar
                7) Sair

                Escolha uma opção válida:

                **********************************************
                """);  int option = sc.nextInt();

            switch (option) {
                case 1:
                    conversor.setMoedaPrimaria("USD");
                    conversor.setMoedaSecundaria("ARS");
                    break;
                case 2:
                    conversor.setMoedaPrimaria("ARS");
                    conversor.setMoedaSecundaria("USD");
                    break;
                case 3:
                    conversor.setMoedaPrimaria("USD");
                    conversor.setMoedaSecundaria("BRL");
                    break;
                case 4:
                    conversor.setMoedaPrimaria("BRL");
                    conversor.setMoedaSecundaria("USD");
                    break;
                case 5:
                    conversor.setMoedaPrimaria("USD");
                    conversor.setMoedaSecundaria("COP");
                    break;
                case 6:
                    conversor.setMoedaPrimaria("COP");
                    conversor.setMoedaSecundaria("USD");
                    break;
                case 7:
                    continuarLoop = false;
                    break;
                default:
                    throw new Exception("Opção inválida .");
            }
            if(continuarLoop == false){
                return ;
            }
            System.out.println("Digite o valor que deseja converter : ");
            int valor = sc.nextInt();
            conversor.setValorInicial(valor);

            HttpClient client = HttpClient.newHttpClient();
            String apiKey = "bca5c0770a25fea411050681";

            String  urlRequest = "https://v6.exchangerate-api.com/v6/"+ apiKey+"/pair/"+ conversor.getPrincipal()+"/"+ conversor.getMoedaSecundaria()+"/"+ valor;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlRequest))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            var resposta = response.body();

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            responseDTO moeda = gson.fromJson(resposta, responseDTO.class);
            conversor.setResultado(moeda.conversion_result());
            System.out.println(conversor);
        }
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}