package com.mygdx.game.utils;

import com.mygdx.game.models.Pergunta;

import java.util.ArrayList;
import java.util.List;

public class PerguntaList {

    private static List<Pergunta> perguntas = new ArrayList<>(List.of(
            new Pergunta("Qual estado cuja capital é Rio Branco?", "AC"),
            new Pergunta("Qual estado fica no extremo oeste do Brasil?", "AC"),
            new Pergunta("Qual estado é conhecido por sua proximidade com o Peru e Bolívia?", "AC"),

            new Pergunta("Qual estado cuja capital é Maceió?", "AL"),
            new Pergunta("Qual estado faz fronteira com Pernambuco e Sergipe?", "AL"),
            new Pergunta("Qual estado é conhecido pelas praias do litoral nordestino?", "AL"),

            new Pergunta("Qual estado cuja capital é Macapá?", "AP"),
            new Pergunta("Qual estado faz fronteira com a Guiana Francesa?", "AP"),
            new Pergunta("Qual estado é cortado pela linha do Equador?", "AP"),

            new Pergunta("Qual estado cuja capital é Manaus?", "AM"),
            new Pergunta("Qual estado é conhecido pela Floresta Amazônica?", "AM"),
            new Pergunta("Qual estado tem o maior território do Brasil?", "AM"),

            new Pergunta("Qual estado cuja capital é Salvador?", "BA"),
            new Pergunta("Qual estado faz fronteira com Minas Gerais e Sergipe?", "BA"),
            new Pergunta("Qual estado é famoso pelo Carnaval de Salvador?", "BA"),

            new Pergunta("Qual estado cuja capital é Fortaleza?", "CE"),
            new Pergunta("Qual estado faz fronteira com Piauí e Rio Grande do Norte?", "CE"),
            new Pergunta("Qual estado é famoso pela Praia de Jericoacoara?", "CE"),

            new Pergunta("Qual unidade federativa cuja capital é Brasília?", "DF"),
            new Pergunta("Qual unidade federativa abriga o Palácio do Planalto?", "DF"),
            new Pergunta("Qual é o único estado que não possui municípios?", "DF"),

            new Pergunta("Qual estado cuja capital é Vitória?", "ES"),
            new Pergunta("Qual estado faz fronteira com Minas Gerais e Bahia?", "ES"),
            new Pergunta("Qual estado é famoso pela produção de pedras preciosas?", "ES"),

            new Pergunta("Qual estado cuja capital é Goiânia?", "GO"),
            new Pergunta("Qual estado faz fronteira com Mato Grosso e Minas Gerais?", "GO"),
            new Pergunta("Qual estado é conhecido pela produção agrícola no Centro-Oeste?", "GO"),

            new Pergunta("Qual estado cuja capital é São Luís?", "MA"),
            new Pergunta("Qual estado faz fronteira com o Pará e Piauí?", "MA"),
            new Pergunta("Qual estado é famoso pelos Lençóis Maranhenses?", "MA"),

            new Pergunta("Qual estado cuja capital é Cuiabá?", "MT"),
            new Pergunta("Qual estado faz fronteira com Goiás e Rondônia?", "MT"),
            new Pergunta("Qual estado é famoso pelo Pantanal?", "MT"),

            new Pergunta("Qual estado cuja capital é Campo Grande?", "MS"),
            new Pergunta("Qual estado faz fronteira com São Paulo e Mato Grosso?", "MS"),
            new Pergunta("Qual estado abriga uma parte do Pantanal?", "MS"),

            new Pergunta("Qual estado cuja capital é Belo Horizonte?", "MG"),
            new Pergunta("Qual estado faz fronteira com Rio de Janeiro e Bahia?", "MG"),
            new Pergunta("Qual estado é famoso pelas cidades históricas como Ouro Preto?", "MG"),

            new Pergunta("Qual estado cuja capital é Belém?", "PA"),
            new Pergunta("Qual estado faz fronteira com Amazonas e Maranhão?", "PA"),
            new Pergunta("Qual estado é famoso pelo Círio de Nazaré?", "PA"),

            new Pergunta("Qual estado cuja capital é João Pessoa?", "PB"),
            new Pergunta("Qual estado faz fronteira com Pernambuco e Rio Grande do Norte?", "PB"),
            new Pergunta("Qual estado é conhecido por ter o ponto mais oriental das Américas?", "PB"),

            new Pergunta("Qual estado cuja capital é Curitiba?", "PR"),
            new Pergunta("Qual estado faz fronteira com Santa Catarina e São Paulo?", "PR"),
            new Pergunta("Qual estado é famoso pelas Cataratas do Iguaçu?", "PR"),

            new Pergunta("Qual estado cuja capital é Recife?", "PE"),
            new Pergunta("Qual estado faz fronteira com Alagoas e Paraíba?", "PE"),
            new Pergunta("Qual estado é conhecido pelo frevo e o maracatu?", "PE"),

            new Pergunta("Qual estado cuja capital é Teresina?", "PI"),
            new Pergunta("Qual estado faz fronteira com Maranhão e Ceará?", "PI"),
            new Pergunta("Qual estado é conhecido pelo Parque Nacional da Serra da Capivara?", "PI"),

            new Pergunta("Qual estado cuja capital é Rio de Janeiro?", "RJ"),
            new Pergunta("Qual estado faz fronteira com Minas Gerais e São Paulo?", "RJ"),
            new Pergunta("Qual estado é famoso pelo Pão de Açúcar e Cristo Redentor?", "RJ"),

            new Pergunta("Qual estado cuja capital é Natal?", "RN"),
            new Pergunta("Qual estado faz fronteira com Ceará e Paraíba?", "RN"),
            new Pergunta("Qual estado é conhecido pelas Dunas de Genipabu?", "RN"),

            new Pergunta("Qual estado cuja capital é Porto Alegre?", "RS"),
            new Pergunta("Qual estado faz fronteira com Santa Catarina e Uruguai?", "RS"),
            new Pergunta("Qual estado é famoso pela Serra Gaúcha e o vinho?", "RS"),

            new Pergunta("Qual estado cuja capital é Porto Velho?", "RO"),
            new Pergunta("Qual estado faz fronteira com Amazonas e Mato Grosso?", "RO"),
            new Pergunta("Qual estado é conhecido pela Estrada de Ferro Madeira-Mamoré?", "RO"),

            new Pergunta("Qual estado cuja capital é Boa Vista?", "RR"),
            new Pergunta("Qual estado faz fronteira com a Venezuela?", "RR"),
            new Pergunta("Qual estado é o menos populoso do Brasil?", "RR"),

            new Pergunta("Qual estado cuja capital é Florianópolis?", "SC"),
            new Pergunta("Qual estado faz fronteira com Paraná e Rio Grande do Sul?", "SC"),
            new Pergunta("Qual estado é conhecido pelas praias de Balneário Camboriú?", "SC"),

            new Pergunta("Qual estado cuja capital é São Paulo?", "SP"),
            new Pergunta("Qual estado faz fronteira com Minas Gerais e Paraná?", "SP"),
            new Pergunta("Qual estado é o centro econômico do Brasil?", "SP"),

            new Pergunta("Qual estado cuja capital é Aracaju?", "SE"),
            new Pergunta("Qual estado faz fronteira com Bahia e Alagoas?", "SE"),
            new Pergunta("Qual estado é conhecido pelas praias do litoral sul?", "SE"),

            new Pergunta("Qual estado cuja capital é Palmas?", "TO"),
            new Pergunta("Qual estado faz fronteira com Maranhão e Pará?", "TO"),
            new Pergunta("Qual estado foi o último a ser criado no Brasil?", "TO")
    ));

    public static List<Pergunta> getPerguntas() {
        return perguntas;
    }

}
