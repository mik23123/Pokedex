package mdp2026.pokedex.struttura;
import mdp2026.pokedex.utility.*;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
enum stato{
    menu,
    dettaglio,
    uscita;
}


public  class menu  extends ScannerTextInput{
private stato statoCorrente;
private pokedex pokedex;
private int pokemonCorrente;

    /**
     *
     * @param p the pokedex for starting menu
     */
    public menu(pokedex p ){
    if(p==null) throw new IllegalArgumentException("il poxkedex è nullo");
    this.pokedex=p;
    this.statoCorrente=stato.menu;
    this.pokemonCorrente=0;

}
    /**
     * this is the method thath start anything
     */
public void start(){
    while(statoCorrente!=stato.uscita){
        switch (statoCorrente)
        {
            case  menu: gestioneMenu(); break;

            case dettaglio: gestioneDettaglio(); break;

        }
    }

}
    /**
     * this is for manage the menu statment
     */
public void gestioneMenu(){
    System.out.println("inserisci il numero identificativo del pokemon che vuoi scoprire, 0 per uscire ");
    int n = Integer.parseInt(readInput());
    if(n>0 && n<=155) {
        pokemon pk = pokedex.getPokemon(n);
   System.out.println(pk.toString());
        pokemonCorrente=pokedex.getScoperti().indexOf(pokedex.getPokemon(n));
statoCorrente=stato.dettaglio;

    }

else if(n==0) statoCorrente=stato.uscita;
else throw new IllegalArgumentException("numero inserito non valido");
    }

    /**
     * this is for manage the dettaglio statment
     */
    public void gestioneDettaglio(){


    String  comando = readInput();
int index=0 ;
       switch(comando)
                   {
       case "avanti":
        pokemonCorrente= (pokemonCorrente+1)%pokedex.getScoperti().size();
          System.out.println(pokedex.getScoperti().get(pokemonCorrente)+"controllo indice " + pokemonCorrente);
          break;
        case "indietro" :
            pokemonCorrente= (pokemonCorrente-1+pokedex.getScoperti().size())%pokedex.getScoperti().size();
            System.out.println(pokedex.getScoperti().get(pokemonCorrente)+"controllo indice " + pokemonCorrente);
        break;
        case "esci" :
            statoCorrente=stato.menu;
            break;
    }

}
}




