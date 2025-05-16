package org.example;

import org.example.entities.Passageiro;
import org.example.facade.PassageiroFacade;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PassageiroFacade facade = new PassageiroFacade();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1 - Cadastrar passageiro");
            System.out.println("2 - Listar passageiros");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    boolean sucesso = facade.cadastrarPassageiro(nome, cpf, email);
                    System.out.println(sucesso ? "Cadastrado com sucesso!" : "Dados inválidos!");
                }
                case 2 -> {
                    for (Passageiro p : facade.listar()) {
                        System.out.printf("%d - %s - %s - %s\n", p.getId(), p.getNome(), p.getCpf(), p.getEmail());
                    }
                }
            }
        } while (opcao != 3);
    }
}