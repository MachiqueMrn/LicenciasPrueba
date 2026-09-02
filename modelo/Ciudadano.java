package modelo;

public class Ciudadano {
    private String nombre;
    private String curp;
    private String telefono;

    // Constructor
    public Ciudadano(String nombre, String curp, String telefono) {
        this.nombre = nombre;
        this.curp = curp;
        this.telefono = telefono;
    }

    // Métodos de comportamiento
    public void mostrarInformacion() {
        System.out.println("Ciudadano: " + nombre + " | CURP: " + curp + " | Tel: " + telefono);
    }

    // Getters
    public String getNombre() { return nombre; }
}