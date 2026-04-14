package utility;
/*
Il programma deve restare in esecuzione fino a quando l’utente non inserisce un comando esplicito di uscita. Il programma deve prevedere due soli stati di navigazione:
menu generale
dettaglio di un Pokémon

All’avvio il programma deve trovarsi nel menu generale.
Nel menu generale l’utente deve poter visualizzare l’elenco di tutti i Pokémon già scoperti (inizialmente nessuno). Nel menu generale l’utente deve poter selezionare un Pokémon tramite il suo identificativo numerico, compreso tra 1 e 155, per entrare nella schermata di dettaglio corrispondente.

Se l’utente entra nel dettaglio di un Pokémon non ancora scoperto, quel Pokémon deve essere segnato come scoperto nel momento in cui viene aperta la sua schermata di dettaglio.

Nella schermata di dettaglio devono essere mostrate le informazioni del Pokémon selezionato. Dalla schermata di dettaglio l’utente deve poter tornare al menu generale tramite un comando dedicato. Dalla schermata di dettaglio l’utente deve poter passare al Pokémon scoperto successivo o precedente.
La navigazione tra Pokémon scoperti deve essere circolare:
se l’utente si trova sull’ultimo Pokémon scoperto e richiede il successivo, il programma deve mostrare il primo Pokémon scoperto (e il contrario).

Nel menu generale l’utente deve poter cercare un Pokémon per nome.
La ricerca per nome deve essere limitata ai soli Pokémon già scoperti.
Se la ricerca non produce risultati, il programma deve comunicarlo in modo esplicito.

Il programma deve gestire in modo chiaro gli input non validi:
Un identificativo esterno all’intervallo 1-155 non deve essere accettato.
Un comando non riconosciuto non deve interrompere il programma, ma deve produrre un messaggio di errore e consentire all’utente di continuare.

Responsabilità
Caricare i dati di tutti i pokémon da un file json
Gestire gli input da console
Rappresentare un Pokémon
Rappresentare un Pokédex
Gestire la navigazione tra i dettagli
Usare un contenitore per ospitare il pokédex che comprenda solo i pokemon noti
Gestire il caso in cui si scopra lo stesso pokemon più di una volta
Gestire la scoperta dei pokémon (aggiunta, eliminazioneeliminaczione e controllo duplicati)
Gestire la ricerca per nome ai soli Pokémon già scoperti e segnalare quando non ci sono risultati
Gestire visualizzazione pokémon scoperti
Gestire le eccezioni ricominciando dalla sezione scelta(se entri nella lista dei pokémon con un id sbagliato ti fà rimettere l’ID anziché lanciare un’eccezione che termini il programma)
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pokedex {
private List<pokemon> allPokemon;
private boolean[] scoperti;




public pokedex(List<pokemon> pks){
    if(pks==null) throw new IllegalArgumentException("la lista non puo essere nulla");
this.allPokemon= new ArrayList<pokemon>();
this.scoperti=new boolean[155];
}

    /**
     * This method find every discovered Pokémon.
     *
     * @return list of discovered Pokémon
     */
    public List<pokemon> getScoperti(){
    List<pokemon>  listaPokemonScoperti= new ArrayList<pokemon>();
    for ( int i =0 ; i<scoperti.length;i++){
        if(scoperti[i]){
            listaPokemonScoperti.add(getPokemon(i));
        }
    }
    return listaPokemonScoperti;
}

    /** usless for return pokemons by index
     *
     * @param index index of a pokemon that would to find
     * @return Pokemon
     */
    public pokemon getPokemon(int index){
        if(index<0 || index>155) throw new IllegalArgumentException("index must to be between 1 and 155");
int n=0;
pokemon trovato = new pokemon();
Iterator<pokemon> itr= allPokemon.iterator();// qui se il pokemon da trovare è il 15 il mio programma si ferma al pokemon 14,
while(n<index) {                              // perchè ovviamente cominciando da 1 tutto cambia.
    trovato = itr.next();
    n++;
}
scoperti[index]=true; // questo perchè in futuro mi servirà per quando un utente vuole scoprire un pokemon.
return trovato;
}

    /**this method return the pokemon thath we would to find by name
     *
     * @param name name of the pokemon
     * @return pokemon
     */
    public pokemon GetPokemonByName(String name){
        if(name==null) throw new IllegalArgumentException("name couldn't be null");
//     Iterator<pokemon> scop= getScoperti().iterator();
//     while(scop.hasNext()){
//         pokemon p = scop.next();
//         if (p.getNome().equals(name)){ // versione meno efficente
//           return  p;
//         } }
            for(pokemon p : getScoperti()){
             if(p.getNome().equals(name))return p; // versione pulitissima
         }
      System.out.println("pokemon non esistente");
     return null;
    }

}


