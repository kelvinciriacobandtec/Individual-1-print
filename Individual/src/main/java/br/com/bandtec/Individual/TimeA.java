package br.com.bandtec.Individual;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Random;

public class TimeA extends Time {

    public TimeA(Integer codigo, String nome) {
        super(codigo, nome);
    }

    Serie s = new Serie();


    Random pontos = new Random();

    @Override
    public Integer simularPontos() {

    return 38;
    }

}



