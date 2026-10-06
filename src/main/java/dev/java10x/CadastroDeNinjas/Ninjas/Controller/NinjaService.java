package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaMapper ninjaMapper, NinjaRepository ninjaRepository) {
        this.ninjaMapper = ninjaMapper;
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjaPorID(Long Id) {
        return ninjaRepository.findById(Id).orElseThrow(() -> new RuntimeException("Ninja não encontrado com o ID: " + Id));
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){

         NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
         ninjaModel = ninjaRepository.save(ninjaModel);
         return ninjaMapper.map(ninjaModel);

    }

    public void deletarNinjaPorID(Long Id){
        ninjaRepository.deleteById(Id);
    }

    public NinjaModel atualizarNinjaPorID( Long Id, NinjaModel ninjaAtualizado){

        if(ninjaRepository.existsById(Id)){
            ninjaAtualizado.setId(Id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

}
