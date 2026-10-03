package dev.java10x.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.Ninjas.Controller.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "rankMissao")
    @Enumerated(EnumType.STRING)
    private rankMissao dificuldade;

    //Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "missao")
    @JsonIgnore
    private List <NinjaModel> ninja;

}
