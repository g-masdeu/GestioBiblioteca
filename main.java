/*
 * Codi per provar la gestió de la biblioteca
 */

public class main {
    public static void main(String[] args) {
        System.out.println("Benvingut a la gestió de la biblioteca");
        System.out.println("-----------------------------------------------");

        Biblioteca biblioteca = new Biblioteca();
        Llibre llibre1 = new Llibre("1984", "George Orwell");
        Llibre llibre2 = new Llibre("El petit príncep", "Antoine de Saint-Exupéry");
        biblioteca.afegirLlibre(llibre1);
        biblioteca.afegirLlibre(llibre2);
        Usuari usuari = new Usuari("Carla");
        GestorBiblioteca gestor = new GestorBiblioteca();
        gestor.prestarLlibre(usuari, llibre1);
    }

}