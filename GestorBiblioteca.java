import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorBiblioteca {
    private List<Prestec> prestecs;
    private static final int MAX_LLIBRES_PER_USUARI = 3;

    public GestorBiblioteca() {
        this.prestecs = new ArrayList<>();
    }

    public void prestarLlibre(Usuari usuari, Llibre llibre) {

        if (usuari.getLlibresPrestats().size() >= MAX_LLIBRES_PER_USUARI) {
            System.out.println("Aquest usuari ja té el màxim de llibres permesos");
            return;
        }

        if (!llibre.esPrestat()) {
            llibre.prestar();
            Prestec prestec = new Prestec(usuari, llibre, LocalDate.now());
            prestecs.add(prestec);
            usuari.afegirLlibre(llibre);

            // Guarda el préstec al fitxer
            try (FileWriter fitxer = new FileWriter("prestecs.txt", true)) {
                fitxer.write(usuari.getNom() + "\n");
                fitxer.write(llibre.getTitol() + "\n");
                fitxer.write(prestec.getDataRetorn() + "\n");
            } catch (IOException e) {
                System.out.println("ERROR guardant préstec: " + e.getMessage());
            }

            System.out.println(usuari.getNom() + " ha agafat el llibre: " + llibre.getTitol());
        } else {
            System.out.println("Aquest llibre ja està prestat.");
        }
    }

    public void consultarHistorial(Usuari usuari) {
        System.out.println("Historial de llibres prestats per " + usuari.getNom() + ":");
        if (usuari.getLlibresPrestats().isEmpty()) {
            System.out.println("No ha prestat cap llibre");
        } else {
            for (int i = 0; i < usuari.getLlibresPrestats().size(); i++) {
                System.out.println("- " + usuari.getLlibresPrestats().get(i));
            }
        }
    }

    public List<Prestec> getPrestecs() {
        return prestecs;
    }

    public void recuperarPrestecs() {
        try (Scanner fitxer = new Scanner(new File("prestecs.txt"))) {
            while (fitxer.hasNextLine()) {
                String nomUsuari = fitxer.nextLine();
                String titolLlibre = fitxer.nextLine();
                String dataRetornStr = fitxer.nextLine();

                // En aquest punt pots buscar l'usuari i el llibre per refer els objectes
                // (assumint que ja has carregat usuaris i llibres abans)

                Usuari usuari = new Usuari(nomUsuari); // millor buscar-lo si existeix
                Llibre llibre = new Llibre(titolLlibre, "Desconegut", "Desconeguda"); // millor buscar-lo si existeix

                Prestec prestec = new Prestec(usuari, llibre, LocalDate.parse(dataRetornStr).minusWeeks(2));
                prestecs.add(prestec);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fitxer de préstecs no trobat.");
        }
    }

}