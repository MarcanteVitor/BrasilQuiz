package com.mygdx.game.utils;

import com.mygdx.game.models.Pergunta;
import java.util.List;
import java.util.Random;

public class PerguntaManager {

    public static Pergunta getPerguntaAleatoria() {
        List<Pergunta> perguntas = PerguntaList.getPerguntas();

        if (perguntas.isEmpty()) {
            System.out.println("Não há mais perguntas disponíveis.");
            return null;
        }

        Random random = new Random();
        int index = random.nextInt(perguntas.size());
        return perguntas.remove(index); // Remove e retorna a pergunta selecionada
    }

    public static void main(String[] args) {
        // Exemplo de uso:
        Pergunta pergunta = getPerguntaAleatoria();
        if (pergunta != null) {
            System.out.println("Pergunta selecionada: " + pergunta.getTexto());
            System.out.println("Resposta: " + pergunta.getResposta());
        }
    }
}
