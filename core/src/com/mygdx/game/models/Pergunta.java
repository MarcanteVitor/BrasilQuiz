package com.mygdx.game.models;

public class Pergunta {
    private String texto;
    private String resposta;

    public Pergunta(String texto, String resposta) {
        this.texto = texto;
        this.resposta = resposta;
    }

    public String getTexto() {
        return texto;
    }

    public String getResposta() {
        return resposta;
    }
}
