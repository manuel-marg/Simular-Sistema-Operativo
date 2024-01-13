
package proyecto_2_so;

public class Escritorio {
    public int ID;
    public int contador;
    public int nivel;

    public Escritorio(int ID, int contador, int nivel) {
        this.ID = ID;
        this.contador = contador;
        this.nivel = nivel;
    }

    public Escritorio() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
