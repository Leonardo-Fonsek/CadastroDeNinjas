package dev.java10x.CadatroDeNinjas.Missoes;

public enum rankMissao {

    A("Muito difícil", 10),
    B("Difícil moderado", 8),
    C("Médio",5),
    D("Pacífico", 1);

    private String descricao;
    private int dificuldade;

    rankMissao(String descricao, int dificuldade){
        this.descricao = descricao;
        this.dificuldade = dificuldade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
}
