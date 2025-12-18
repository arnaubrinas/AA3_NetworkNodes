import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Red {
    ArrayList<Nodo> nodos;

    Red() {
        nodos = new ArrayList<>();
    }

    void agregarNodo(Nodo n) {
        nodos.add(n);
    }

    void conectar(Nodo a, Nodo b) {
        a.conectar(b);
        b.conectar(a);
    }
    
    void mostrar() {
        System.out.println("El GRAFO");
        for (Nodo n : nodos) {
            System.out.print(n + " --> ");
            System.out.println(n.getVecinos());
        }
    }
    
    void resetCompromisos() {
        for (Nodo n : nodos) {
            n.comprometido = false;
        }
    }

    void escanearDesde(Nodo origen) {
        resetCompromisos();
        
        Queue<Nodo> cola = new LinkedList<>();
        ArrayList<Nodo> visitados = new ArrayList<>();
        
        cola.add(origen);
        visitados.add(origen);
        
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            
            if (actual.vulnerable) {
                actual.comprometido = true;
            }
            
            if (actual.firewall) {
                continue;
            }
            
            for (Nodo vecino : actual.vecinos) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }

    Nodo buscarPorIP(String ip) {
        for (Nodo n : nodos) {
            if (n.ip.equals(ip)) {
                return n;
            }
        }
        return null;
    }
  
    int contarVulnerablesAlcanzables(Nodo origen) {
       return 0; //no l'hem conseguit fer ja que no trobabm laz manera que ens
       //  compiles perque ens donaba error i no trobabem la funció per completar
    }

    String listarVecinosDe(Nodo n) {
        if (n == null) return "";
        
        String resultado = "";
        for (Nodo vecino : n.vecinos) {
            resultado += vecino.nombre + " ";
        }
        return resultado;
    }

    ArrayList<Nodo> nodosAislados() {
        ArrayList<Nodo> aislados = new ArrayList<>();
        
        for (Nodo n : nodos) {
            if (n.vecinos.size() == 0) {
                aislados.add(n);
            }
        }
        
        return aislados;
    }
}