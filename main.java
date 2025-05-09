/*
 * Codi per provar la gestió de la biblioteca
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Declarem les variables
        Biblioteca biblioteca = new Biblioteca();
        GestorBiblioteca gestor = new GestorBiblioteca();
        Scanner scanner = new Scanner(System.in);
        Usuaris usuaris = new Usuaris();

        // Recuperem les dades de llibres i usuaris
        usuaris.recuperarUsuaris();
        biblioteca.recuperarLlibres();

        int opcio;

        // Mostrem el menú
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Llistar llibres");
            System.out.println("2. Llistar usuaris");
            System.out.println("3. Buscar llibre");
            System.out.println("4. Prestar llibre");
            System.out.println("5. Afegir llibre");
            System.out.println("6. Afegir usuari");
            System.out.println("7. Sortir");
            System.out.print("Escull una opció: ");
            opcio = scanner.nextInt();
            scanner.nextLine();
            
            
            switch (opcio) {
                case 1:
                    // Mostrem els llibres disponibles
                    System.out.println("\nLlibres disponibles: ");
                    for (int i = 0; i < biblioteca.getLlibres().size(); i++) {
                        System.out.println(biblioteca.getLlibres().get(i));
                    }
                    break;

                case 2: 
                    //Mostrem els usuaris
                    System.out.println(usuaris);
                    break;
                case 3:
                    // Busquem llibre pel títol
                    System.out.print("Titol del llibre: ");
                    String titolBuscar = scanner.nextLine();
                    Llibre llibreTrobat = biblioteca.buscarLlibre(titolBuscar);
                    if (llibreTrobat == null) {
                        System.out.println("Aquest llibre no existeix a la biblioteca.");
                    }else{
                        System.out.println("Llibre trobat: " + llibreTrobat);
                    }
                    break;

                case 4:
                    // Prestem llibre
                    // Nom de l'usuari
                    System.out.println("Nom de l'usuari: ");
                    String nom = scanner.nextLine();
                    if (!usuaris.buscar(nom)) {
                        System.out.println("No s'ha trobat l'usuari");
                    } else {
                        Usuari usuari = new Usuari(nom);
                        System.out.print("Titol del llibre a prestar: ");
                        String titolPrestar = scanner.nextLine();                    
                        Llibre llibreAPrestar = biblioteca.buscarLlibre(titolPrestar);
                        if (llibreAPrestar == null) {
                            System.out.println("Aquest llibre no existeix a la biblioteca.");
                        }else{
                            gestor.prestarLlibre(usuari, llibreAPrestar);
                        }
                    }
                    break;

                case 5:
                    // Afegim llibre
                    System.out.println("\nAfegir llibre");
                    System.out.print("Nom del llibre: ");
                    String nomLlibre = scanner.nextLine();
                    System.out.print("Nom de l'autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();
                    biblioteca.afegirLlibre(new Llibre(nomLlibre, autor, categoria));
                    break;
                
                case 6:
                    // Afegim Usuari
                    System.out.println("\nAfegir Usuari:");
                    System.out.print("Nom usuari: ");
                    Usuari usuari = new Usuari (scanner.nextLine());
                    usuari.afegirUsuari();
                    break;
                

                case 7:
                    System.out.println("Fins aviat!");
                    break;
                default:
                System.out.println("Opció no vàlida.");
                    break;
            }
        } while (opcio !=7);


        scanner.close();

    }
}

