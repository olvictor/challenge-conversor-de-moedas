package br.com.olvictor.modelos;

import java.time.LocalDate;
import java.util.Date;

public class Conversor {
    private String moedaPrimaria;
    private String moedaSecundaria;

    private Date dataAtual;
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

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public void mostrarMenu(){
        System.out.println( """
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
                """);
    }
    @Override
    public String toString() {
        return "Valor : " + valorInicial + "[" +moedaPrimaria+"]" + " Corresponde ao valor final de  =>>>> " + valorFinal + "["+ moedaSecundaria +"]" + " na data : " + this.dataAtual;
    }
}