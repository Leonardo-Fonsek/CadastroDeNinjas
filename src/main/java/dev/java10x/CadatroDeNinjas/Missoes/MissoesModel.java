package dev.java10x.CadatroDeNinjas.Missoes;

import dev.java10x.CadatroDeNinjas.Ninjas.Controller.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String nome;
    private rankMissao dificuldade;

    //Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "missao")
    private List <NinjaModel> ninja;

    public MissoesModel() {
    }

    public MissoesModel(Long id, String nome, rankMissao dificuldade) {
        this.id = id;
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public rankMissao getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(rankMissao dificuldade) {
        this.dificuldade = dificuldade;
    }
}
