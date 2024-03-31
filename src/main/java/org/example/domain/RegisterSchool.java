package org.example.domain;

public record RegisterSchool(int codInep, String localizacao,
                             String nomeEscola, String endereco,
                             String logradouro, int cep, String diretorNome,
                             String secretarioNome) {
}
