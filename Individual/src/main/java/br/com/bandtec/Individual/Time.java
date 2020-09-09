package br.com.bandtec.Individual;

import org.springframework.http.ResponseEntity;

public abstract class Time {

    private Integer codigo;
    private String nome;


    public Time(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    abstract Integer simularPontos();



    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Time{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
