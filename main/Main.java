package main;

import java.util.Scanner;

import modelo.Ciudadano;
import modelo.Requisito;
import modelo.SolicitudLicencia;

import java.util.ArrayList; // Importamos la herramienta para crear listas

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // ¡NUEVO! Creamos nuestro "archivero virtual" para guardar muchas solicitudes
        ArrayList<SolicitudLicencia> listaSolicitudes = new ArrayList<>();
        
        boolean salir = false;
        int contadorFolios = 1001; // Para que el folio avance automáticamente

        System.out.println("=".repeat(50));
        System.out.println("    VENTANILLA DE TRÁMITES CIUDADANOS");
        System.out.println("=".repeat(50));

        while (!salir) {
            System.out.println("\n");
            System.out.println("=".repeat(50));
            System.out.println("    MENÚ PRINCIPAL");
            System.out.println("=".repeat(50));
            System.out.println("1. Registrar nuevo trámite de licencia");
            System.out.println("2. Consultar historial de trámites (Todas las solicitudes)");
            System.out.println("3. Salir del sistema");
            System.out.print("Elija una opción (1-3): ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del teclado

            if (opcion == 1) {
                System.out.println("\n");
                System.out.println("=".repeat(50));
                System.out.println("    A. Datos del Ciudadano");
                System.out.println("=".repeat(50));
                System.out.print("Nombre completo: ");
                String nombre = scanner.nextLine();
                System.out.print("CURP: ");
                String curp = scanner.nextLine();
                System.out.print("Teléfono: ");
                String telefono = scanner.nextLine();
                
                // Creamos al ciudadano
                Ciudadano ciudadano = new Ciudadano(nombre, curp, telefono);
                
                System.out.println("\n");
                System.out.println("=".repeat(50));
                System.out.println("    B. Datos del Trámite");
                System.out.println("=".repeat(50));
                System.out.print("Tipo de licencia (Ej. Primera Vez / Renovación): ");
                String tipoLicencia = scanner.nextLine();
                
                // Creamos el requisito
                Requisito requisito = new Requisito("Identificación Oficial y Comprobante");
                System.out.print("¿El ciudadano entregó todos los documentos? (1 = Sí / 2 = No): ");
                int entrego = scanner.nextInt();
                
                if (entrego == 1) {
                    requisito.marcarComoEntregado();
                }
                
                // Creamos la solicitud con el folio actual
                SolicitudLicencia nuevaSolicitud = new SolicitudLicencia(contadorFolios, tipoLicencia, ciudadano, requisito);
                nuevaSolicitud.procesarSolicitud();
                
                // ¡LA MAGIA OCURRE AQUÍ! Guardamos la solicitud terminada en nuestra lista
                listaSolicitudes.add(nuevaSolicitud);
                
                // Aumentamos el folio para el siguiente ciudadano
                contadorFolios++; 
                
            } else if (opcion == 2) {
                System.out.println("\n");
                System.out.println("=".repeat(50));
                System.out.println("    HISTORIAL DE TRÁMITES REGISTRADOS");
                System.out.println("=".repeat(50));
                
                // Verificamos si el archivero está vacío
                if (listaSolicitudes.isEmpty()) {
                    System.out.println("Aún no hay ningún trámite registrado en el sistema.");
                } else {
                    // Recorremos la lista para mostrar cada solicitud guardada
                    for (int i = 0; i < listaSolicitudes.size(); i++) {
                        System.out.println("\nRegistro #" + (i + 1) + ":");
                        // Sacamos la solicitud de la posición 'i' y consultamos su estado
                        listaSolicitudes.get(i).consultarEstado();
                    }
                }
                
            } else if (opcion == 3) {
                salir = true;
                System.out.println("\nCerrando la ventanilla... ¡Se han guardado " + listaSolicitudes.size() + " trámites hoy!");
                
            } else {
                System.out.println("\nOpción no válida. Por favor, intente de nuevo.");
            }
        }

        scanner.close();
    }
}