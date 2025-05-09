/*
 * Classe que representa una biblioteca
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

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
        try (FileWriter fitxer = new FileWriter("llibres.txt", true)) {
            fitxer.write(llibre.getTitol() + "\n");
            fitxer.write(llibre.getAutor() + "\n");
            fitxer.write(llibre.getCategoria() + "\n");
            fitxer.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
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

    // Mètode recuperarLlibres -> Mètode que recupera els llibres del fitxer .txt
    // ja que no es treballa amb una base de dades
    public void recuperarLlibres() {
        try (Scanner fitxer = new Scanner (new File("llibres.txt"))) {
            while (fitxer.hasNextLine()) {
                String titol = fitxer.nextLine();
                String autor = fitxer.nextLine();
                String categoria = fitxer.nextLine();                
                llibres.add(new Llibre(titol, autor, categoria));
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
    }
}