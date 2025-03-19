import java.util.Scanner;
import java.util.Stack;

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
        }
    }
    
}
