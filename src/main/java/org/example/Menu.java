package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    boolean sistemaAtivo=true;
    BancoDeDrinks banco = new BancoDeDrinks();

    public Menu(){
    }

    public void iniciar(){
        carregarDadosIniciais();

        while(sistemaAtivo) {
            System.out.println("1.Adicionar drink:");
            System.out.println("2.Visualizar drink:");
            System.out.println("0.Sair:");
            int opcao = (int) recebeNumero();
            switch (opcao) {
                case 1:
                    cadastrarDrink();
                    break;
                case 2:
                    mostrarDrinks();
                    break;
                case 0:
                    sistemaAtivo=false;
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }

        scanner.close();
    }

    private void cadastrarDrink(){
        System.out.println("Qual o nome do drink?");
        String nome = scanner.nextLine();
        ArrayList<String> listaDeIngredientes = new ArrayList<>();
        System.out.println("Quantos ingredientes vão no drink?");
        int numero = (int) recebeNumero();
        for (int i = 0; i < numero; i++) {
            System.out.println("Qual o ingrediente " + (i+1));
            listaDeIngredientes.add(scanner.nextLine());
        }
        ArrayList<String> modoPreparo = new ArrayList<>();
        System.out.println("Digite o modo de preparo (passo a passo).");
        System.out.println("Pressione [Enter] vazio para finalizar a lista:");

        int passoPreparo = 1;
        while (true) {
            System.out.print("Passo " + passoPreparo + ": ");
            String passo = scanner.nextLine();

            if (passo.trim().isEmpty()) {
                break;
            }

            modoPreparo.add(passo);
            passoPreparo++;
        }
        System.out.println("Selecione a categoria do drink.");
        for(Categorias categorias:Categorias.values()){
            System.out.println(categorias.getId() + ". " + categorias.getDescricao());
        }
        int idCategoria = (int) recebeNumero();
        while (!Categorias.existeId(idCategoria)){
            System.out.println("Numero invalido, tente novamente");
            idCategoria = (int) recebeNumero();
        }
        Categorias categoria = Categorias.buscarPorId(idCategoria);
        System.out.println("Qual a nota para o drink?");
        float nota = recebeNumero();
        while(nota<0||nota>5){
            System.out.println("O sistema de notas vai de 0 a 5, avalie novamente.");
            nota=recebeNumero();
        }
        Drinks drink = new Drinks(nome, listaDeIngredientes, nota, modoPreparo, categoria, null);
        banco.adicionarDrink(drink);
    }

    private void carregarDadosIniciais(){
        // --- Drink 1: Whiskey Sour ---
        ArrayList<String> ing1 = new ArrayList<>(Arrays.asList("Whiskey", "Suco de Limão", "Xarope de Açúcar", "Clara de Ovo"));

        ArrayList<String> prep1 = new ArrayList<>();
        prep1.add("Coloque todos os ingredientes na coqueteleira com gelo.");
        prep1.add("Agite vigorosamente por 15 segundos.");
        prep1.add("Coe para um copo baixo com gelo novo.");
        prep1.add("Decore com uma casca de limão.");

        Drinks d1 = new Drinks("Whiskey Sour", ing1, 4.8f,prep1, Categorias.SHOT, null);
        banco.adicionarDrink(d1);


        // --- Drink 2: Mojito ---
        ArrayList<String> ing2 = new ArrayList<>(Arrays.asList("Rum Branco", "Hortelã", "Suco de Limão", "Água com Gás"));

        ArrayList<String> prep2 = new ArrayList<>();
        prep2.add("Macere a hortelã com o suco de limão no copo.");
        prep2.add("Adicione o rum e encha de gelo.");
        prep2.add("Complete com água com gás.");
        prep2.add("Misture suavemente com uma colher bailarina.");

        Drinks d2 = new Drinks("Mojito", ing2, 4.5f,prep2, Categorias.LONG_DRINK, null);
        banco.adicionarDrink(d2);

        // --- Drink 3: Suco Detox ---
        ArrayList<String> ing3 = new ArrayList<>(Arrays.asList("Couve", "Limão", "Gengibre", "Água de Coco"));

        ArrayList<String> prep3 = new ArrayList<>();
        prep3.add("Lave bem as folhas de couve.");
        prep3.add("Bata tudo no liquidificador até ficar homogêneo.");
        prep3.add("Coe se preferir uma textura mais líquida.");
        prep3.add("Sirva imediatamente sem adoçar.");

        Drinks d3 = new Drinks("Suco Detox", ing3, 5.0f,prep3, Categorias.SEM_ALCOOL, null);
        banco.adicionarDrink(d3);
    }

    private void mostrarDrinks(){
        ArrayList<Drinks> listaRecebida = banco.listarDrinks();
        for (int i=0;i<listaRecebida.size();i++) {
            System.out.println("Nome do drink " + (i+1) + " : " + listaRecebida.get(i).getNome());
        }
        System.out.println("Qual drink gostaria de ver os detalhes?");
        int indiceDrink = (int) recebeNumero();
        Drinks drinkEncontrado = banco.buscarPorIndice(indiceDrink-1);
        if(drinkEncontrado!=null){
            System.out.println(drinkEncontrado);
        } else {
            System.out.println("Drink não encontrado\n");
        }
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
