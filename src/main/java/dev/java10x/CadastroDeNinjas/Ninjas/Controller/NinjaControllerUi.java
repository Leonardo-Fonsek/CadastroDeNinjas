package dev.java10x.CadastroDeNinjas.Ninjas.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
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

}
