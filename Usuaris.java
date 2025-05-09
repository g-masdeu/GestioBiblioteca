/*
 * Classe que representa els usuaris
 */

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Usuaris {

    // Propietats de la classe usuaris
    private List <Usuari> usuaris;

    // Constructor de la classe
    public Usuaris () {
        this.usuaris = new ArrayList<>();
    }
    
    // Mètodes de la classe
    // toString -> Mètode que imprimeix per pantalla els usuaris
    public String toString () {
        String missatge = "Usuaris de la biblioteca: "; 
        // Afegim el nom de cada ususaria a una linia nova
        for (int i = 0; i < usuaris.size(); i++) {
            missatge += "\n\t" + usuaris.get(i).getNom();
        }

        return missatge;
    }

    // recuperarUsuaris -> Mètode que recuperarà els usuaris guardats al fitxer
    // ja que no treballem amb una db, utilitzem fitxers per guardar informació
    public void recuperarUsuaris () {
        try (Scanner fitxer = new Scanner (new File ("usuaris.txt"))){
            while (fitxer.hasNextLine()) {
                usuaris.add(new Usuari(fitxer.nextLine()));
            }
            fitxer.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    //buscar() -> Mètode per buscar un usuari a la llista
    public boolean buscar (String nom) {
        boolean trobat = false;
        int i = 0;
        while(!trobat && i < usuaris.size()) {
            if (usuaris.get(i).getNom().equalsIgnoreCase(nom)) {
                trobat = true;
            } else {
                i++;
            }
        }

        return trobat;
    }

    
    // Afegir Usuari -> funció que guarda al fitxer el nou usuari
    // No guarda els llibres que té de préstec
    public void afegirUsuari(Usuari usuari) {
        usuaris.add(usuari);
        usuari.afegirUsuari();
    }
}
