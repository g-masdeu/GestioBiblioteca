import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorBiblioteca {
    private List<Prestec> prestecs;
    private static final int MAX_LLIBRES_PER_USUARI =3;

    public GestorBiblioteca() {
        this.prestecs = new ArrayList<>();
    }

    public void prestarLlibre(Usuari usuari, Llibre llibre) {

        if (usuari.getLlibresPrestats().size() >= MAX_LLIBRES_PER_USUARI) {
            System.out.println("Aquest usuari ja té el màxim de llibres permesis");
            return;
        }

        if (!llibre.esPrestat()) {
            llibre.prestar();
            Prestec prestec = new Prestec(usuari, llibre, LocalDate.now());
            prestecs.add(prestec);
            usuari.afegirLlibre(llibre);
            System.out.println(usuari.getNom() + " ha agafat el llibre: " + llibre.getTitol());
        } else {
            System.out.println("Aquest llibre ja està prestat.");
        }
    }

    public void consultarHistorial(Usuari usuari) {
        System.out.println("Historial de llibres prestats per " + usuari.getNom()+ ":");
        if (usuari.getLlibresPrestats().isEmpty()) {
            System.out.println("No ha prestat cap llibre");
        }else {
            for (int i = 0; i < usuari.getLlibresPrestats().size(); i++) {
                System.out.println("- " + usuari.getLlibresPrestats().get(i));
            }
        }
    }
    public List<Prestec> getPrestecs() { return prestecs;}
}