/*
 * Codi per provar la gestió de la biblioteca
 */

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        GestorBiblioteca gestor = new GestorBiblioteca();
        Scanner scanner = new Scanner(System.in);

        Usuari usuari = new Usuari("Carla");

        biblioteca.afegirLlibre(new Llibre("1984", "George Orwell","ciencia"));
        biblioteca.afegirLlibre(new Llibre("El petit príncep", "Antonie de Saint-Exupéry","Aventura"));
        biblioteca.afegirLlibre(new Llibre("Crim i càstig", "Fiódor Dostoiveski","Ficcion"));

        int opcio;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Llistar llibres");
            System.out.println("2. Buscar llibre");
            System.out.println("3. Prestar llibre");
            System.out.println("4. Sortir");
            System.out.print("Escull una opció: ");
            opcio = scanner.nextInt();
            scanner.nextLine();
            
            
            switch (opcio) {
                case 1:
                    System.out.println("\nLlibres disponibles: ");
                    for (int i = 0; i < biblioteca.getLlibres().size(); i++) {
                        System.out.println(biblioteca.getLlibres().get(i));
                    }
                    break;
                case 2:
                    System.out.print("Titol del llibre: ");
                    String titolBuscar = scanner.nextLine();
                    Llibre llibreTrobat = biblioteca.buscarLlibre(titolBuscar);
                    if (llibreTrobat == null) {
                        System.out.println("Aquest llibre no existeix a la biblioteca.");
                    }else{
                        System.out.println("Llibre trobat: " + llibreTrobat);
                    }
                    break;

                case 3:
                    System.out.print("Titol del llibre a prestar: ");
                    String titolPrestar = scanner.nextLine();
                    Llibre llibreAPrestar = biblioteca.buscarLlibre(titolPrestar);
                    if (llibreAPrestar == null) {
                        System.out.println("Aquest llibre no existeix a la biblioteca.");
                    }else{
                        gestor.prestarLlibre(usuari, llibreAPrestar);
                    }
                    break;
                case 4:
                    System.out.println("Fins aviat!");
                    break;
                default:
                System.out.println("Opció no vàlida.");
                    break;
            }
        } while (opcio !=4);


        scanner.close();

    }
}

