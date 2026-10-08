package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaMapper ninjaMapper, NinjaRepository ninjaRepository) {
        this.ninjaMapper = ninjaMapper;
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaDTO> listarNinjas() {

        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listarNinjaPorID(Long Id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(Id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){

         NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
         ninjaModel = ninjaRepository.save(ninjaModel);
         return ninjaMapper.map(ninjaModel);

    }

    public void deletarNinjaPorID(Long Id){
        ninjaRepository.deleteById(Id);
    }

    public NinjaDTO atualizarNinja( Long Id, NinjaDTO ninjaDTO){

            Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(Id);

            if(ninjaExistente.isPresent()) {
                NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
                ninjaAtualizado.setId(Id);
                NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
                return ninjaMapper.map(ninjaSalvo);
            }
            return null;
    }

}
