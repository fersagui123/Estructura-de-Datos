import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SistemaAtencionTienda {

    private Queue<String> fila;
    private Scanner scanner;
    private boolean running;

    public SistemaAtencionTienda(){
        fila = new LinkedList<>();
        scanner = new Scanner(System.in);
        running = true;
    }

    public void iniciar(){
        System.out.println("Sistema de atención en Tienda Iniciado.");
        System.out.println("Comandos Disponibles:");
        System.out.println("LLEGAR [ingresar nombre del cliente] - Agrega un cliente a la fila");
        System.out.println("ATENDER - Atiende al primer cliente en la fila");
        System.out.println("MOSTRAR - Muestra el estado actual de la fila");
        System.out.println("SALIR - Cierra el programa");

        while (running) {
            System.out.print("> ");  
            String input = scanner.nextLine().trim();
            procesarComando(input);
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }

    private void procesarComando(String input) {
        if (input.startsWith("LLEGAR ")) {  
            String nombre = input.substring(7).trim();
            if (nombre.isEmpty()) {
                System.out.println("Error: Debe especificar un nombre después de LLEGAR.");
                return;
            }
            agregarCliente(nombre);
        } else if (input.equals("LLEGAR")) { 
            System.out.println("Error: Debe especificar un nombre después de LLEGAR.");
        } else if (input.equals("ATENDER")) {
            atenderCliente();
        } else if (input.equals("MOSTRAR")) {
            mostrarFila();
        } else if (input.equals("SALIR")) {
            running = false;
        } else {
            System.out.println("Comando incorrecto. Intente de nuevo.");
        }
    }

    private void agregarCliente(String nombre) {
        fila.add(nombre);
        System.out.println(nombre + " ha sido agregado a la fila.");  
    }

    public void atenderCliente() {
        if (fila.isEmpty()) {
            System.out.println("No hay clientes en la fila.");
            return;
        }
    
        String cliente = fila.poll();
        System.out.println("Atendiendo a: " + cliente);  
        mostrarFila();
    }

    public void mostrarFila() {
        if (fila.isEmpty()){
            System.out.println("Fila actual: [vacía]");
            return;
        }

        System.out.print("Fila actual: ");  
        Object[] clientes = fila.toArray();
        for (int i = 0; i < clientes.length; i++) {
            System.out.print(clientes[i]);  
            if (i < clientes.length - 1) {
                System.out.print(", ");  
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SistemaAtencionTienda sistema = new SistemaAtencionTienda();
        sistema.iniciar();
    }        
}