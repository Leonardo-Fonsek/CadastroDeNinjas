package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas () {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaModel) {
         NinjaDTO novoNinja = ninjaService.criarNinja(ninjaModel);

         return ResponseEntity.status(HttpStatus.CREATED)
                 .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/listarID/{Id}")
    public ResponseEntity<?> listarNinjaPorID(@PathVariable Long Id){
        NinjaDTO ninjaPorID = ninjaService.listarNinjaPorID(Id);

        if(ninjaPorID != null){
            return ResponseEntity.ok(ninjaPorID);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + Id + " não existe nos nossos registros!");
        }
    }

    // Alterar dados dos ninjas (POST)
    @PutMapping("/alterarID/{Id}")
    public ResponseEntity<String> atualizarNinja(@PathVariable Long Id, @RequestBody NinjaDTO ninjaAtualizado){

        if(ninjaService.listarNinjaPorID(Id) != null){
            NinjaDTO ninjaAntigo = ninjaService.listarNinjaPorID(Id);
            NinjaDTO ninjaNovo = ninjaService.atualizarNinja(Id, ninjaAtualizado);
            return ResponseEntity.ok("Ninja " + ninjaAntigo.getNome() + " Alterado para " + ninjaNovo.getNome());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID " + Id + " não encontrado para alteração.");
        }

    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar/{Id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long Id){
        if(ninjaService.listarNinjaPorID(Id) != null){
            ninjaService.deletarNinjaPorID(Id);
            return ResponseEntity.ok("Ninja com o ID " + Id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o ID " + Id + " não foi encontrado.");
        }
    }

}
