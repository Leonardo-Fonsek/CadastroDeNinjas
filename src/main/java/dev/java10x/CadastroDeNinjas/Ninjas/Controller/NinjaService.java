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

    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    public void deletarNinjaPorID(Long Id){
        ninjaRepository.deleteById(Id);
    }

    public void atualizarNinjaPorID( Long Id, NinjaModel ninjaAtualizado){
        NinjaModel ninjaASerAlterado = listarNinjaPorID(Id);

        ninjaASerAlterado.setNome(ninjaAtualizado.getNome());
        ninjaASerAlterado.setEmail(ninjaAtualizado.getEmail());
        ninjaASerAlterado.setIdade(ninjaAtualizado.getIdade());
        ninjaASerAlterado.setMissao(ninjaAtualizado.getMissao());

        ninjaRepository.save(ninjaASerAlterado);

    }

}
