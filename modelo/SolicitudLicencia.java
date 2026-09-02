package modelo;

public class SolicitudLicencia {
    private int folio;
    private String tipoLicencia;
    private boolean estaAprobada;
    
    // Asociaciones directas (Paso 3 de nuestro diseño)
    private Ciudadano titular;
    private Requisito requisito;

    // Constructor
    public SolicitudLicencia(int folio, String tipoLicencia, Ciudadano titular, Requisito requisito) {
        this.folio = folio;
        this.tipoLicencia = tipoLicencia;
        this.titular = titular;
        this.requisito = requisito;
        this.estaAprobada = false;
    }

    // Métodos de comportamiento
    public void procesarSolicitud() {
        if (requisito.getFueEntregado()) {
            this.estaAprobada = true;
            System.out.println("¡Éxito! La solicitud folio " + folio + " ha sido APROBADA.");
        } else {
            System.out.println("Error: La solicitud folio " + folio + " está RECHAZADA. Faltan documentos.");
        }
    }

    public void consultarEstado() {
        System.out.println("--- Estado del Trámite ---");
        titular.mostrarInformacion();
        System.out.println("Tipo de Licencia: " + tipoLicencia);
        System.out.println("Aprobada: " + (estaAprobada ? "Sí" : "No"));
    }
}