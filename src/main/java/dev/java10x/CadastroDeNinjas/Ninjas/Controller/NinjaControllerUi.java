package dev.java10x.CadastroDeNinjas.Ninjas.Controller;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final MissoesService missoesService;
    private final NinjaService ninjaService;

    public NinjaControllerUi(MissoesService missoesService, NinjaService ninjaService) {
        this.missoesService = missoesService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas"; //Tem que retornar o nome da página que renderiza
    }

    @GetMapping("/deletar/{Id}")
    public String deletarNinjaPorId(@PathVariable Long Id){
        ninjaService.deletarNinjaPorID(Id);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/listarID/{Id}")
    public String listarNinjaPorID(@PathVariable Long Id, Model model){
        NinjaDTO ninjaPorID = ninjaService.listarNinjaPorID(Id);

        if(ninjaPorID != null){
            model.addAttribute("ninja", ninjaPorID);
            return "detalhesNinja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarNinjas";
        }
    }

    @GetMapping("/criar")
    public String formularioCriar(Model model) {

        model.addAttribute("ninja", new NinjaDTO());
        model.addAttribute("missoes", missoesService.listarMissoes());
        return "criarNinjaForm";

    }

    @PostMapping("/criar")
    public String salvarNinja(
            @ModelAttribute NinjaDTO ninja,
            @RequestParam(required = false) Long missaoId) {
         {
            if(missaoId != null){
                MissoesModel missao = missoesService.listarMissaoPorID(missaoId);
                ninja.setMissao(missao);
            }
            ninjaService.criarNinja(ninja);
            return "redirect:/ninjas/ui/listar";
        }
    }

    @GetMapping("/alterar/{id}")
    public String formularioAlterar(@PathVariable Long id, Model model){
        NinjaDTO ninja = ninjaService.listarNinjaPorID(id);
        model.addAttribute("ninja", ninja);
        model.addAttribute("missoes", missoesService.listarMissoes());
        return "alterarNinjaForm";
    }

    @PostMapping("/alterarID/{id}")
    public String salvarAlteracao(
            @PathVariable Long id,
            @ModelAttribute NinjaDTO ninja,
            @RequestParam(required = false) Long missaoId) {

        if(missaoId != null){
            MissoesModel missao = missoesService.listarMissaoPorID(missaoId);
            ninja.setMissao(missao);
        }

        ninjaService.atualizarNinja(id, ninja);
        return "redirect:/ninjas/ui/listar";

    }

}
