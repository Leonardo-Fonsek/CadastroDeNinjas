package dev.java10x.CadastroDeNinjas.Missoes;

//Toda vez que utilizamos Controller, estamos criando uma rota para o servidor (LOCALHOST:8080/requisição)

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Sinaliza que a classe MissoesController será um conjunto de rotas para nossa API
@RequestMapping ("/missoes")// Mapear as API´s
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //GET -- requisição para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    //GET - Listar por ID
    @GetMapping("/listar/{Id}")
    public MissoesModel listarMissaoPorID(@PathVariable Long Id){
        return missoesService.listarMissaoPorID(Id);
    }

    //POST -- requisição para criar as missoes
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    //PUT -- requisição para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada";
    }

    //DELETE  -- requisição para deletar as missoes
    @DeleteMapping("/deletar/{Id}")
    public void deletarMissao(@PathVariable Long Id){
        missoesService.deletarMissao(Id);
    }



}
