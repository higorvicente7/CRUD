package org.example.domain;

public class School {

    private int codInep;
    private String localizacao;
    private String nomeEscola;
    private String endereco;
    private  String logradouro;
    private int cep;
    private String diretorNome;
    private String secretarioNome;

    public School(RegisterSchool register) {
        this.codInep = register.codInep();
        this.localizacao = register.localizacao();
        this.nomeEscola = register.nomeEscola();
        this.endereco = register.endereco();
        this.logradouro = register.logradouro();
        this.cep = register.cep();
        this.diretorNome = register.diretorNome();
        this.secretarioNome = register.secretarioNome();
    }

    public int getCodInep() {
        return codInep;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public String getNomeEscola() {
        return nomeEscola;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getLogradouro() {
        return logradouro;
    }
    public int getCep() {
        return cep;
    }
    public String getDiretorNome() {
        return diretorNome;
    }
    public String getSecretarioNome() {
        return secretarioNome;
    }
    @Override
    public String toString() {
        return  "COD INEP: " + codInep +
                " LOCALIZAÇÃO: " + localizacao +
                " ESCOLA: " + nomeEscola +
                " ENDEREÇO: " + endereco +
                " LOGRADOURO: " + logradouro +
                " CEP: " + cep +
                " DIRETOR: " + diretorNome +
                " SECRETARIO: " + secretarioNome;
    }
}
