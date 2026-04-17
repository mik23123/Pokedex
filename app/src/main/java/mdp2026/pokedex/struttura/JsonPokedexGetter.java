package mdp2026.pokedex.struttura;
import mdp2026.pokedex.utility.*;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;



public class JsonPokedexGetter extends ResourceReader implements pokedexGetter {


    @Override
    public pokedex buildPokedex(String file) {
        String json = leggiFile(file);
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<pokemon>>(){}.getType();// qui raggiro la type erisure, in pratica tutto questo serve perchè la jvm a runtime poi cancella il tipo. In questo modo forziamo il tipo
        List<pokemon> list = gson.fromJson(json, listType);
        return new pokedex(list);
    }
}
