package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    ArrayList<Drinks> listaDeDrinks = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    boolean f=true;

    public Menu(){
        // --- Drink 1: Whiskey Sour ---
        ArrayList<String> ing1 = new ArrayList<>(Arrays.asList("Whiskey", "Suco de Limão", "Xarope de Açúcar", "Clara de Ovo"));
        Drinks d1 = new Drinks("Whiskey Sour", ing1, 4.8f);
        listaDeDrinks.add(d1);

        // --- Drink 2: Mojito ---
        ArrayList<String> ing2 = new ArrayList<>(Arrays.asList("Rum Branco", "Hortelã", "Suco de Limão", "Água com Gás"));
        Drinks d2 = new Drinks("Mojito", ing2, 4.5f);
        listaDeDrinks.add(d2);

        // --- Drink 3: Negroni ---
        ArrayList<String> ing3 = new ArrayList<>(Arrays.asList("Gin", "Campari", "Vermute Rosso"));
        Drinks d3 = new Drinks("Negroni", ing3, 4.2f);
        listaDeDrinks.add(d3);

        while(f) {
            System.out.println("1.Adicionar drink:");
            System.out.println("2.Visualizar drink:");
            System.out.println("0.Sair:");
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    System.out.println("Qual o nome do drink?");
                    String nome = scanner.nextLine();
                    ArrayList<String> listaDeIngredientes = new ArrayList<>();
                    System.out.println("Quantos ingredientes vão no drink?");
                    int numero = (int) recebeNumero();
                    for (int i = 0; i < numero; i++) {
                        System.out.println("Qual o ingrediente " + (i+1));
                        listaDeIngredientes.add(scanner.nextLine());
                    }
                    System.out.println("Qual a nota para o drink?");
                    float nota = recebeNumero();
                    scanner.nextLine();
                    Drinks drink = new Drinks(nome, listaDeIngredientes, nota);
                    listaDeDrinks.add(drink);
                    break;
                case 2:
                    for (Drinks d : listaDeDrinks) {
                        System.out.println("Nome: " + d.getNome());
                    }
                    System.out.println("Qual drink gostaria de ver os detalhes?");
                    int det = scanner.nextInt();
                    scanner.nextLine();
                    if(det>0&&det<listaDeDrinks.size()){
                        System.out.println(listaDeDrinks.get(det-1));
                    } else {
                        System.out.println("Numero invalido\n");
                    }

                    break;
                case 0:
                    f=false;
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }

        scanner.close();
    }

    private float recebeNumero(){
        boolean entradaValida = false;
        float numero=0;
        while (!entradaValida) {
            try {
                numero = scanner.nextFloat();
                scanner.nextLine();
                if(numero<0){
                    System.out.println("Numero invalido.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite apenas números. Tente novamente.");
            }
        }
        return numero;
    }
}
