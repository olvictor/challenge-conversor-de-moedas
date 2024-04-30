package br.com.olvictor.modelos;

public class Conversor {
    // HttpClient client = HttpClient.newHttpClient();

    // HttpRequest request = HttpRequest.newBuilder()
    //             .uri(URI.create("https://v6.exchangerate-api.com/v6/bca5c0770a25fea411050681/latest/USD"))
    //             .build();

    // HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    private String moedaPrimaria;
    private String moedaSecundaria;

    private int valorInicial;
    private Double valorFinal;
    public String getPrincipal(){
        return this.moedaPrimaria;
    }
    public int getValorInicial(){ return this.valorInicial; }
    public void setMoedaPrimaria(String p){
        this.moedaPrimaria =  p;
    }

    public String getMoedaSecundaria(){
        return this.moedaSecundaria;
    }

    public void setMoedaSecundaria(String s){
        this.moedaSecundaria =  s;
    }

    public void setResultado (double valor){ this.valorFinal = valor; }
    public void setValorInicial (int valor){ this.valorInicial = valor; }
    @Override
    public String toString() {
        return "Valor : " + valorInicial + "[" +moedaPrimaria+"]" + " Corresponde ao valor final de  =>>>> " + valorFinal + "["+ moedaSecundaria +"]";
    }
}