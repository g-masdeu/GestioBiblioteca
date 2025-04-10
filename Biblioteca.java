/*
 * Classe que representa una biblioteca
 */

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    // Propietats de la classe -------------------------------------------------------------------------------
    private List<Llibre> llibres;

    // CONSTRUCTORS ------------------------------------------------------------------------------------------
    // Constructor genèric -> Crea una Biblioteca amb una llista de llibres (buida) --------------------------
    public Biblioteca() {
        this.llibres = new ArrayList<>();
    }

    // Mètodes de la classe ----------------------------------------------------------------------------------
    // Altres mètodes de la classe ---------------------------------------------------------------------------
    // Mètode afegirLlibre -> Afegeix un llibre a la llista de la biblioteca ---------------------------------
    public void afegirLlibre(Llibre llibre) { 
        llibres.add(llibre); 
    }

    // Mètodes buscarLlibre -> Mètode que buscarà un llibre a partir del títol i el retornarà ---------------
    public Llibre buscarLlibre(String titol) {
        for (Llibre llibre : llibres) {
            if (llibre.getTitol().equalsIgnoreCase(titol)) {
                return llibre;
            }
        }
        return null;
    }
    
    // Mètode getLlibres -> Mètode que retornarà una llista amb els llibres de la biblioteca ---------------
    public List<Llibre> getLlibres() {
         return llibres; 
    }
}