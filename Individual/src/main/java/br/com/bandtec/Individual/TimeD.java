package br.com.bandtec.Individual;

import org.springframework.http.ResponseEntity;

import java.util.Random;

public class TimeD extends Time {
    public TimeD(Integer codigo, String nome) {
        super(codigo, nome);
    }

    Serie s = new Serie();
    Random pontos = new Random();


    @Override
    public Integer simularPontos() {

    return 15;
        }
}
