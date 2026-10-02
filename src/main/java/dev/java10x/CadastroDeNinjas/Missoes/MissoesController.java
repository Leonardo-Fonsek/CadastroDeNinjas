package dev.java10x.CadastroDeNinjas.Missoes;

//Toda vez que utilizamos Controller, estamos criando uma rota para o servidor (LOCALHOST:8080/requisição)

import org.springframework.web.bind.annotation.*;

@RestController //Sinaliza que a classe MissoesController será um conjunto de rotas para nossa API
@RequestMapping ("missoes")// Mapear as API´s
public class MissoesController {


    //GET -- requisição para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missoes listadas com sucesso";
    }

    //POST -- requisição para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada com sucesso";
    }

    //PUT  -- requisição para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada";
    }

    //DELETE  -- requisição para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }

}
