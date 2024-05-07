import br.com.olvictor.modelos.Conversor;
import br.com.olvictor.services.consumoAPI;
import br.com.olvictor.modelos.responseDTO;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;

import java.net.http.HttpClient;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        try{

        Scanner  sc = new Scanner(System.in);
        Conversor conversor = new Conversor();
        String apiKey = "bca5c0770a25fea411050681";

        boolean continuarLoop = true;
        while(continuarLoop){
            conversor.mostrarMenu();
            int option = sc.nextInt();

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
            Date dataAtual = new Date();
            conversor.setDataAtual(dataAtual);
            String  urlRequest = "https://v6.exchangerate-api.com/v6/"+ apiKey+"/pair/"+ conversor.getPrincipal()+"/"+ conversor.getMoedaSecundaria()+"/"+ valor;
            consumoAPI consumo = new consumoAPI();

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            responseDTO moeda = gson.fromJson(consumo.buscarDados(urlRequest), responseDTO.class);

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