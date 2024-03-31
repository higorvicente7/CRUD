package org.example;
import org.example.domain.Service;
import org.example.domain.RegisterSchool;

import java.util.Scanner;
public class StartApp {
    private static Scanner teclado = new Scanner(System.in);
    private static Service service = new Service();
    public static void main(String[] args) {

        var opcao = exibirMenuPrincipal();
        while (opcao != 0) {
            try {
                switch (opcao) {
                    case 1:
                        cadastro();
                        break;
                    case 2:
                        listarEscolas();
                        break;
                    case 3:
                        apagar();
                        break;
                    case 4:
                        atualizar();
                        break;
                }
            } catch (RuntimeException e){
                System.out.println(e);
                System.out.println("PRESSIONE ENTER PARA SAIR");
                teclado.next();
            }
            opcao = exibirMenuPrincipal();
        }
    }
    private static int exibirMenuPrincipal(){
        System.out.println("""
                    *******************
                    CADASTRO DAS ESCOLA
                    *******************
                    ESCOLHA UMA OPÇÃO
                    1 - CADASTRAR ESCOLA
                    2 - LISTAR ESCOLAS CADASTRADA
                    3 - APAGAR ESCOLA CADASTRADA
                    4 - ATUALIZAR INFORMAÇÕES
                    0 - SAIR""");
        return teclado.nextInt();
    }
    private static int exibirMenuAlteracao(){
        System.out.println("""
                ESCOLHA O QUE DESEJA ALTERAR!
                1 - CODIGO INEP
                2 - LOCALIZAÇÃO
                3 - ESCOLA
                4 - ENDEREÇO
                5 - LOGRADOURO
                6 - CEP
                7 - DIRETOR
                8 - SECRETÁRIO
                0 - RETORNAR MENU PRINCIPAL""");
        return teclado.nextInt();
    }
    private static void atualizar(){
        var op = exibirMenuAlteracao();
        while (op != 0){
            try {
                switch (op){
                    case 1:
                        atualizaInep();
                        break;
                    case 2:
                        atualizarLoc();
                        break;
                    case 3:
                        atualizaNomeEscola();
                        break;
                    case 4:
                        atualizaEndereco();
                        break;
                    case 5:
                        atualizaLogradouro();
                        break;
                    case 6:
                        atualizaCep();
                        break;
                    case 7:
                        atualizaDiretor();
                        break;
                    case 8:
                        atualizaSecretario();
                        break;
                }
            } catch (RuntimeException e){
                System.out.println(e);
            } op = exibirMenuAlteracao();
        }
    }
    private static void atualizaInep(){
            String campo = "codInep";
            System.out.println("DIGITE O INEP DA ESCOLA QUE DESEJA ALTERAR: ");
            int cod = teclado.nextInt();

            System.out.println("DIGITE O NOVO CODIGO: ");
            var newCod = teclado.nextInt();

            service.alterar(cod, campo, String.valueOf(newCod));
            System.out.println("Codigo Alterado com sucesso!");
            System.out.println("Pressione qualquer tecla para retornar ao menu principal");
            teclado.next();
    }
    private static void atualizarLoc(){
        String campo = "localizacao";
        System.out.println("DIGITE O INEP DA ESCOLA: ");
        int cod = teclado.nextInt();

        System.out.println("DIGITE A NOVA LOCALIZAÇÃO");
        String newLoc = teclado.next();

        service.alterar(cod, campo, newLoc);
        System.out.println("LOCALIZAÇÃO ALTERADA COM SUCESSO!!");
        System.out.println("Pressione qualquer tecla para retornar ao menu principal");
        teclado.next();
    }
    private static void atualizaNomeEscola(){
        String campo = "escola";
        System.out.println("DIGITE O INEP DA ESCOLA: ");
        int cod = teclado.nextInt();

        System.out.println("DIGITE O NOVO NOME DA ESCOLA: ");
        String newName = teclado.next();

        service.alterar(cod, campo, newName);
        System.out.println("NOME DA ESCOLA ALTERAD0 COM SUCESSO!!");
        System.out.println("Pressione qualquer tecla para retornar ao menu principal");
        teclado.next();
    }
    private static void atualizaEndereco() {
        String campo = "endereco";
        System.out.println("DIGITE O INEP DA ESCOLA: ");
        int cod = teclado.nextInt();

        System.out.println("DIGITE O NOVO ENDEREÇO DA ESCOLA: ");
        String newEndereco = teclado.next();

        service.alterar(cod, campo, newEndereco);
        System.out.println("ENDEREÇO DA ESCOLA ALTERAD0 COM SUCESSO!!");
        System.out.println("Pressione qualquer tecla para retornar ao menu principal");
        teclado.next();
    }
    private static void atualizaLogradouro() {
        String campo = "logradouro";
        System.out.println("DIGITE O INEP DA ESCOLA: ");
        int cod = teclado.nextInt();

        System.out.println("DIGITE O NOVO LOGRADOURO DA ESCOLA: ");
        String newLogradouro = teclado.next();

        service.alterar(cod, campo, newLogradouro);
        System.out.println("LOGRADOURO DA ESCOLA ALTERAD0 COM SUCESSO!!");
        System.out.println("Pressione qualquer tecla para retornar ao menu principal");
        teclado.next();
    }
    private static void atualizaDiretor() {
        String campo = "diretor";
        System.out.println("DIGITE O INEP DA ESCOLA: ");
        int cod = teclado.nextInt();

        System.out.println("DIGITE O NOME DO DIRETOR: ");
        String newDiretor = teclado.next();

        service.alterar(cod, campo, newDiretor);
        System.out.println("NOME DO DIRETOR ALTERAD0 COM SUCESSO!!");
        System.out.println("Pressione qualquer tecla para retornar ao menu principal");
        teclado.next();
    }
    private static void atualizaSecretario() {
        String campo = "secretario";
        System.out.println("DIGITE O INEP DA ESCOLA: ");
        int cod = teclado.nextInt();

        System.out.println("DIGITE O NOME DO SECRETÁRIO: ");
        String newSecretario = teclado.next();

        service.alterar(cod, campo, newSecretario);
        System.out.println("NOME DO SECRETÁRIO ALTERAD0 COM SUCESSO!!");
        System.out.println("Pressione qualquer tecla para retornar ao menu principal");
        teclado.next();
    }
    private static void atualizaCep(){
        String campo = "cep";
        System.out.println("DIGITE O INEP DA ESCOLA QUE DESEJA ALTERAR: ");
        int cod = teclado.nextInt();

        System.out.println("DIGITE O NOVO CEP: ");
        var newCep = teclado.nextInt();

        service.alterar(cod, campo, String.valueOf(newCep));
        System.out.println("Cep Alterado com sucesso!");
        System.out.println("Pressione qualquer tecla para retornar ao menu principal");
        teclado.next();
    }
        private static void cadastro(){
        System.out.println("Digite o Código do INEP");
        var codInep = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Digite a Localização da Escola");
        var localizacao = teclado.nextLine();

        System.out.println("Digite o Nome da Escola");
        var nomeEscola = teclado.nextLine();

        System.out.println("Digite o Endereço da Escola");
        var endereco = teclado.nextLine();

        System.out.println("Digite o Logradouro");
        var logradouro = teclado.nextLine();

        System.out.println("Digite o CEP da Escola");
        var cep = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Nome do Diretor(a)");
        var nomeDiretor = teclado.nextLine();

        System.out.println("Nome do Secretário(a)");
        var nomeSecretario = teclado.nextLine();

        service.register(new RegisterSchool(codInep, localizacao, nomeEscola,
                endereco, logradouro, cep, nomeDiretor, nomeSecretario));

        System.out.println("Escola Registrada com sucesso!");
        System.out.println("Pressione qualquer tecla para retornar ao menu principal");
        teclado.next();
    }
    private static void listarEscolas(){
        System.out.println("ESCOLAS REGISTRADAS");
        var school = service.listSchool();
        school.stream().forEach(System.out::println);

        System.out.println("Pressione qualquer tecla para retornar ao menu principal");
        teclado.next();
    }
    private static void apagar(){
        System.out.println("DIGITE O CODIGO DA ESCOLA QUE DESEJA APAGAR");
        var cod = teclado.nextInt();
        service.apagar(cod);

        System.out.println("ESCOLA APAGADA COM SUCESSO");
        System.out.println("Pressione qualquer tecla para retornar ao menu principal");
        teclado.next();
    }
}

