package org.example;

import java.util.ArrayList;

public class BancoDeDrinks {
    private final ArrayList<Drinks> listaDeDrinks = new ArrayList<>();

    public BancoDeDrinks(){
    }

    public void adicionarDrink(Drinks d){
        listaDeDrinks.add(d);
    }

    public ArrayList<Drinks> listarDrinks(){
        return new ArrayList<>(this.listaDeDrinks);
    }

    public Drinks buscarPorIndice(int indice){
        if(indice>=0 && indice<listaDeDrinks.size()){
            return listaDeDrinks.get(indice);
        }
        return null;
    }
}
