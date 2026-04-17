package mdp2026.pokedex.struttura;

public class main {
    public static  void main(String[] args) {
        JsonPokedexGetter jsonPokedexGetter = new JsonPokedexGetter();

        pokedex pokedex1 = jsonPokedexGetter.buildPokedex("data.json");

        menu menu1 = new menu(pokedex1);
        menu1.start();


    }
}
