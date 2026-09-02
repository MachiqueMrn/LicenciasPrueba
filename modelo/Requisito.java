package modelo;

public class Requisito {
    private String nombreDocumento;
    private boolean fueEntregado;

    // Constructor
    public Requisito(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
        this.fueEntregado = false; // Por defecto inicia sin entregarse
    }

    // Métodos de comportamiento
    public void marcarComoEntregado() {
        this.fueEntregado = true;
        System.out.println("El documento '" + nombreDocumento + "' ha sido recibido.");
    }
    
    public boolean getFueEntregado() { return fueEntregado; }
}