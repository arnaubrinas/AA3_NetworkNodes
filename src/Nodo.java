

import java.util.ArrayList;

public class Nodo {
    String nombre;
    String ip;
    boolean firewall;
    boolean vulnerable;
    boolean comprometido;
    ArrayList<Nodo> vecinos;

    Nodo(String nombre, String ip, boolean firewall, boolean vulnerable) {
            this.nombre = nombre;
        this.ip = ip;
        this.firewall = firewall;
        this.vulnerable = vulnerable;
        this.comprometido = false;
        this.vecinos = new ArrayList<>();
    }

        
    void conectar(Nodo otro) {
        if (this == otro) return;
        
        if (!this.vecinos.contains(otro)) {
            this.vecinos.add(otro);
        }
        
        if (!otro.vecinos.contains(this)) {
            otro.vecinos.add(this);
        }
    }

    @Override
    public String toString() {
        String resultado = nombre + " (" + ip + ")";
        
        if (firewall) resultado += " [FIREWALL]";
        if (vulnerable) resultado += " [VULN]";
        if (comprometido) resultado += " [PWN]";
        
        return resultado;
    }
}