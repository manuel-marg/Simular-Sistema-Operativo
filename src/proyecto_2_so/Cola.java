package proyecto_2_so;

public class Cola {

    Nodo cabeza;

    public Cola() {
        cabeza = new Nodo(null);
    }

    public void encolar(Object dato) {
        Nodo nodoFinal = new Nodo(dato);
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nodoFinal;
    }

    public Object desencolar() {
        Nodo actual = cabeza;
        if (actual.siguiente == null) {
            return "Error";
        }
        Object primero = actual.siguiente.data;

        Nodo temporal = cabeza;
        Nodo siguienteTemporal = null;
        int contador = 0;
        while (temporal != null) {
            siguienteTemporal = temporal.siguiente;
            if (contador == 0) {
                temporal.siguiente = siguienteTemporal.siguiente;
                siguienteTemporal.siguiente = null;
                return siguienteTemporal.data;
            }
            contador++;
            temporal = siguienteTemporal;
        }
        return primero;
    }

    public Object obtener(int indice) {
        Nodo actual = cabeza;
        int contador = 0;
        while (actual != null) {
            if (contador == indice + 1) {
                return actual.data;
            }
            contador++;
            actual = actual.siguiente;
        }
        return null;
    }

    public Object eliminar(int indice) {
        Nodo temporal = cabeza;
        Nodo siguienteTemporal = null;
        int contador = 0;
        while (temporal != null) {
            siguienteTemporal = temporal.siguiente;
            if (contador == indice) {
                temporal.siguiente = siguienteTemporal.siguiente;
                siguienteTemporal.siguiente = null;
                return siguienteTemporal.data;
            }
            contador++;
            temporal = siguienteTemporal;
        }
        return "Error";
    }

    public boolean imprimir() {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.data != null) {
                System.out.print(actual.data + "->");
            }
            actual = actual.siguiente;
        }
        return true;
    }

    public int tamano() {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
}
