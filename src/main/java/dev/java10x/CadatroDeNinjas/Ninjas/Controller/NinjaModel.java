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
        @Column (name = "id")
        private Long id;

        @Column (name = "nome")
        private String nome;

        @Column(unique = true)
        private String email;

        @Column (name = "img_url")
        private String imgUrl;

        @Column (name = "Idade")
        private int idade;

        //Um ninja tem uma única missão
        @ManyToOne
        @JoinColumn(name = "Missoes_id") // Criação da Foreign Key ou chave estrangeiroa
        private MissoesModel missao;

}
