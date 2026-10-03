package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjaPorID(Long Id) {

        return ninjaRepository.findById(Id).orElseThrow(() -> new RuntimeException("Ninja não encontrado com o ID: " + Id));

    }
}
