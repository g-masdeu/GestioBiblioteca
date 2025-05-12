public class Llibre {
    private String titol;
    private String autor;
    private String categoria;
    private boolean prestat;

    public Llibre(String titol, String autor, String categoria) {
        this.titol = titol;
        this.autor = autor;
        this.categoria = categoria; 
        this.prestat = false;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public boolean esPrestat() {
        return prestat;
    }

    public void prestar() {
        prestat = true;
    }

    public void retornar() {
        prestat = false;
    }

    @Override
    public String toString() {
        return titol + " de " + autor + " [" + categoria + "]" + (prestat ? " (En préstec)" : " (Disponible)");
    }
}