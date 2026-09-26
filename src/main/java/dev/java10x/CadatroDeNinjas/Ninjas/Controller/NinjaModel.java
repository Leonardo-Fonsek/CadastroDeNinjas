package dev.java10x.CadatroDeNinjas.Ninjas.Controller;

import dev.java10x.CadatroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Entity transforma a classe em uma entidade no banco de dados
//JPA = Java persistence API
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;
        private int idade;

        //Um ninja tem uma única missão
        @ManyToOne
        @JoinColumn(name = "Missoes_id") // Criação da Foreign Key ou chave estrangeiroa
        private MissoesModel missao;


}
