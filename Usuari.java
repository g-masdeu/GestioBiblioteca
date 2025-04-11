/*
 * Classe Usuari -> Classe que representa un Usuari de la biblioteca
 */
import java.util.ArrayList;
import java.util.List;

public class Usuari {

    // Propietats de la classe ------------------------------------------------------------------------------------
    private String nom;
    private List<Llibre> llibresPrestats;

    // CONSTRUCTORS -----------------------------------------------------------------------------------------------
    // Cosntructor genèric -> Constructor que crea un Usuari amb un nom i una llista de llibres prestats ----------
    public Usuari(String nom) {
        this.nom = nom;
        this.llibresPrestats = new ArrayList<>();
    }

    // MÈTODES DE LA CLASSE --------------------------------------------------------------------------------------
    // Getters ---------------------------------------------------------------------------------------------------
    // getNom -> funció que retorna el nom de l'usuari -----------------------------------------------------------
    public String getNom() { 
        return nom; 
    }

    // getLlibresPrestats -> Funció que retorna els llibres prestats a l'usuari ---------------------------------
    public List<Llibre> getLlibresPrestats() {
        return llibresPrestats; 
    }

    // Altres Mètodes -------------------------------------------------------------------------------------------
    // Afegir Llibre -> Mètode que afegeix un llibre a la llista de llibres prestats ----------------------------
    public void afegirLlibre(Llibre llibre) { 
        llibresPrestats.add(llibre); 
    }

    // Retornar Llibre -> Funció que elimina un llibre de la llista de llibres prestats -------------------------
    public void retornarLlibre(Llibre llibre) { 
        llibresPrestats.remove(llibre); 
    }
}