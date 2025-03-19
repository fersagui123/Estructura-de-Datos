import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class EditorTexto {
    private Stack<String> texto;
    private Stack<String> deshechos;

    public EditorTexto(){
        this.texto = new Stack<>();
        this.deshechos = new Stack<>();
    }

    public void agregarLinea(String linea) {
        texto.push(linea);
        deshechos.clear();
    }

    public void deshacer(){
        if (!texto.isEmpty()) {
            deshechos.push(texto.pop());
        } else {
            System.out.println("No hay acciones para deshacer");
        }
    }
    
    public void rehacer() {
        if (!deshechos.isEmpty()){
            texto.push(deshechos.pop());
        } else {
            System.out.println("No hay acciones para rehacer");
        }
    }

    public void mostrar() {
        if (texto.isEmpty()) {
            System.out.println("Texto vacío");    
        } else {
            // Convertir el stack a una lista para mostrar en el orden correcto
            ArrayList<String> lineasOrdenadas = new ArrayList<>(texto);
            for (int i = 0; i < lineasOrdenadas.size(); i++) {
                System.out.println((i+1) + ": " + lineasOrdenadas.get(i));
            }
        }
    }

    public void ejecutar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Editor de texto iniciado. Comandos válidos: Deshacer, Rehacer, Mostrar, Salir");
        System.out.println("Escribe texto para agregar una línea o un comando para ejecutar una acción:");
        
        while (true) {
            String entrada = scanner.nextLine().trim();

            switch (entrada) {
                case "Deshacer":
                    deshacer();
                    break;

                case "Rehacer":
                    rehacer();
                    break;

                case "Mostrar":
                    mostrar();
                    break;

                case "Salir":
                    System.out.println("Contenido final:");
                    mostrar();
                    scanner.close();
                    return;
                                
                default:
                    // Agregar el texto como una nueva línea
                    agregarLinea(entrada);
                    System.out.println("Línea agregada");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        editor.ejecutar();
    }
}