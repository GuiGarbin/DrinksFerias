package org.example;

import java.util.ArrayList;

public class Drinks {
    private String nome;
    private ArrayList<String> ingredientes;
    private float nota;

    public Drinks(String nome, ArrayList<String> ingredientes, float nota) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.nota = nota;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Adiciona o título do objeto principal
        sb.append("Nome: ").append(this.nome).append("\n");
        sb.append("Lista de ingredientes:\n");

        // Percorre a lista interna e vai adicionando ao StringBuilder
        if (this.ingredientes.isEmpty()) {
            sb.append("  (Vazio)");
        } else {
            for (String i : this.ingredientes) {
                sb.append("  - ").append(i).append("\n");
            }
        }
        sb.append("Nota: ").append(this.nota).append("\n");

        return sb.toString();
    }


    public String getNome() {
        return nome;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public float getNota() {
        return nota;
    }
}
