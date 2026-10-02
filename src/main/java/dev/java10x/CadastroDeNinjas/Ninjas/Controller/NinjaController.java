package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas () {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrar ninja";
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar ninja por ID";
    }

    // Alterar dados dos ninjas (POST)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar ninja por ID";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId(){
        return "Ninja deletado por ID";
    }

}
