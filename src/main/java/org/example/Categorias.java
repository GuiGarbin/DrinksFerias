package org.example;

public enum Categorias {
    COQUETEL_CLASSICO(1, "Coquetel clássico"),
    LONG_DRINK(2, "Drink Long"),
    SHOT(3, "Shot"),
    SEM_ALCOOL(4, "Sem alcool"),
    CAIPIRINHA(5, "Caipirinha");

    private final int id;
    private final String descricao;

    Categorias(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static Categorias buscarPorId(int idBusca) {
        for (Categorias c : values()) {
            if (c.id == idBusca) {
                return c;
            }
        }
        throw new IllegalArgumentException("Id de categoria inválido: " + idBusca);
    }

    public static boolean existeId(int id) {
        for (Categorias c : values()) {
            if (c.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
