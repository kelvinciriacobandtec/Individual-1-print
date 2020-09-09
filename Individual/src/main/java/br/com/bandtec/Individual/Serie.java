package br.com.bandtec.Individual;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/br")
public class Serie  {

    private List<Time> lista = new ArrayList<>();

    Random pontos = new Random();



    @PostMapping("/A")
    public void adicionarTime(@RequestBody TimeA a){
        lista.add(a);
    }

    @PostMapping("/D")
    public void adicionarTimeB(@RequestBody TimeD a ){
        lista.add(a);
    }

    @GetMapping("/partida")
    public String partida(){
        for (int i = pontos.nextInt(lista.size()) ; i < lista.size() ; i++ ){
            for (int j = pontos.nextInt(lista.size()) ; j < lista.size() ; j ++) {
                if (i!=j){
                    return String.format("Partida entre %s e %s começou!!! \n\n\nJOGÃOOOO " +
                            "\n\n\nResultado saindo em breve \n \n \nACABOU - Resultado do jogo foi de %d a %d ",
                            lista.get(i).getNome() , lista.get(j).getNome() , pontos.nextInt(5) , pontos.nextInt(5));

                }
            }

        }
        return "Deu ruim em alguma parte";
    }

    @GetMapping("/lista/A")
    public List<Time> getLista() {
        List<Time> getLista = lista.stream().filter(timinho -> timinho instanceof TimeA ).collect(Collectors.toList());

        return getLista;
    }

    @GetMapping("/lista/D")
    public List<Time> getListaD() {
        List<Time> getLista = lista.stream().filter(timinho -> timinho instanceof TimeD ).collect(Collectors.toList());

        return getLista;
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable Integer id){
        lista.remove(id-1);


    }

    @GetMapping("/simular/{time}/{serie}")
    public String simularA(@PathVariable String time ,@PathVariable String serie, TimeA a , TimeD d){
        int partidas = 0 , resultado = 0;
        if (serie.equals("a")) {
            partidas = a.simularPontos();
        }else  if (serie.equals("b")){
            partidas = d.simularPontos();
        }


        for (int i = 0; i < partidas; i++) {
            resultado += pontos.nextInt(3);
        }

       return String.format("A quantidade de pontos simulados que o time %s  da serie: %s fez foi de %d",  time ,serie , resultado);

    }
//    @GetMapping("/simular/{time}")
//    public ResponseEntity simularD(TimeD a ,@PathVariable String time){
//        a.simularPontos(time);
//        return ResponseEntity.status(200).build();
//    }

}




