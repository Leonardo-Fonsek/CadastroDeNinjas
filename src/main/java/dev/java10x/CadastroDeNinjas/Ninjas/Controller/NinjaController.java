package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas () {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaModel) {
        return ninjaService.criarNinja(ninjaModel);
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/listarID/{id}")
    public NinjaDTO listarNinjaPorID(@PathVariable Long id){
        return ninjaService.listarNinjaPorID(id);
    }

    // Alterar dados dos ninjas (POST)
    @PutMapping("/alterarID/{Id}")
    public NinjaDTO atualizarNinja(@PathVariable Long Id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(Id, ninjaAtualizado);
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{Id}")
    public void deletarNinjaPorId(@PathVariable Long Id){
        ninjaService.deletarNinjaPorID(Id);
    }

}
