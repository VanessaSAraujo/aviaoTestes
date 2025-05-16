package org.example;

import org.example.entities.Passenger;
import org.example.facade.PassengerFacade;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PassengerFacade facade = new PassengerFacade();
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n1 - Cadastrar passageiro");
            System.out.println("2 - Listar passageiros");
            System.out.println("3 - Sair");
            System.out.print("Opção: \n");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
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
                    for (Passenger p : facade.list()) {
                        System.out.printf("%d - %s - %s - %s\n", p.getId(), p.getNome(), p.getCpf(), p.getEmail());
                    }
                }
            }
        } while (option != 3);
    }
}