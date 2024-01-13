package proyecto_2_so;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Administrador {

    public Cola Reparaciones;
    public Cola Nivel_1;
    public Cola Nivel_2;
    public Cola Nivel_3;
    public int ciclos;
    public int ID_Control;

    public Administrador(Cola Reparaciones, Cola Nivel_1, Cola Nivel_2, Cola Nivel_3, int ciclos, int ID_Control) {
        this.Reparaciones = Reparaciones;
        this.Nivel_1 = Nivel_1;
        this.Nivel_2 = Nivel_2;
        this.Nivel_3 = Nivel_3;
        this.ciclos = ciclos;
        this.ID_Control = ID_Control;
    }

    public void actualizarColas() {

        System.out.println("Se estan actualizando las colas.");

        System.out.println("Actualizando nivel 1");
        for (int i = 0; i < Nivel_1.tamano(); i++) {
            System.out.println("For Nivel 1 (i): " + i);
            Escritorio escritorio = (Escritorio) Nivel_1.obtener(i);
            escritorio.contador++;
        }

        System.out.println("Actulizando nivel 2");
        ArrayList<Escritorio> ArrayListNivel_2 = new ArrayList<Escritorio>();
        for (int i = 0; i < Nivel_2.tamano(); i++) {
            Escritorio escritorio = (Escritorio) Nivel_2.obtener(i);
            escritorio.contador++;
            if (escritorio.contador == 8) {
                escritorio.nivel = 1;
                ArrayListNivel_2.add(escritorio);
            }
        }

        for (int i = Nivel_2.tamano() - 1; i > -1; i--) {
            Escritorio escritorio = (Escritorio) Nivel_2.obtener(i);
            if (escritorio.contador == 8) {
                Nivel_2.eliminar(i);
            }
        }

        for (int i = 0; i < ArrayListNivel_2.size(); i++) {
            Escritorio escritorio = (Escritorio) ArrayListNivel_2.get(i);
            escritorio.contador = 0;
            Nivel_1.encolar(escritorio);
        }

        System.out.println("Actulizando nivel 3");
        ArrayList<Escritorio> ArrayListNivel_3 = new ArrayList<Escritorio>();
        for (int i = 0; i < Nivel_3.tamano(); i++) {
            Escritorio escritorio = (Escritorio) Nivel_3.obtener(i);
            escritorio.contador++;
            if (escritorio.contador == 8) {
                escritorio.nivel = 2;
                ArrayListNivel_3.add(escritorio);
            }
        }

        for (int i = Nivel_3.tamano() - 1; i > -1; i--) {
            Escritorio escritorio = (Escritorio) Nivel_3.obtener(i);
            if (escritorio.contador == 8) {
                Nivel_3.eliminar(i);
            }
        }

        for (int i = 0; i < ArrayListNivel_3.size(); i++) {
            Escritorio escritorio = (Escritorio) ArrayListNivel_3.get(i);
            escritorio.contador = 0;
            Nivel_2.encolar(escritorio);
        }

        double random = Math.random();

        if (random < 0.45) {
            if (Reparaciones.tamano() > 0) {
                Escritorio escritorio = (Escritorio) Reparaciones.desencolar();
                switch (escritorio.nivel) {
                    case 1:
                        Nivel_1.encolar(escritorio);
                        break;
                    case 2:
                        Nivel_2.encolar(escritorio);
                        break;
                    case 3:
                        Nivel_3.encolar(escritorio);
                        break;
                }
            }
        }
        System.out.println("ACTUALIZACION COMPLETA");
    }

    public void agregarEscritorio() {
        ciclos++;
        if (ciclos == 2) {
            ciclos = 0;
            double random = Math.random();

            if (random < 0.7) {
                int nivel = (int) (Math.random() * 3 + 1);
                ID_Control++;
                int ID = ID_Control;

                Escritorio escritorio = new Escritorio(ID, 0, nivel);

                switch (escritorio.nivel) {
                    case 1:
                        Nivel_1.encolar(escritorio);
                        break;
                    case 2:
                        Nivel_2.encolar(escritorio);
                        break;
                    case 3:
                        Nivel_3.encolar(escritorio);
                        break;
                }

                System.out.println("Se agrego un escritorio a una cola.");
            }
        }
    }

    public void agregarEscritoriosParaPruebas() {

        System.out.println("Empezando a agregar un escritorio");

        int nivel = (int) (Math.random() * 3 + 1);
        ID_Control++;
        int ID = ID_Control;

        Escritorio escritorio = new Escritorio(ID, 0, nivel);

        switch (escritorio.nivel) {
            case 1:
                Nivel_1.encolar(escritorio);
                break;
            case 2:
                Nivel_2.encolar(escritorio);
                break;
            case 3:
                Nivel_3.encolar(escritorio);
                break;
        }

        System.out.println("Termino a agregar un escritorio");

    }

    public Escritorio obtenerEscritorio(Escritorio escritorio, Interfaz vista) throws InterruptedException {

        int delayVerMejor = 100;

        if (escritorio != null) {
            reubicarEscritorio(escritorio);
            escritorio = null;
            TimeUnit.MILLISECONDS.sleep(delayVerMejor);
            vista.actualizarInterfaz(Nivel_1, Nivel_2, Nivel_3, Reparaciones);
        }

        if (Nivel_1.tamano() > 0) {
            escritorio = (Escritorio) Nivel_1.desencolar();
            escritorio.contador = 0;
            System.out.println("Administrador esta retornando un escritorio de la Cola de Nivel 1");
        } else if (Nivel_2.tamano() > 0) {
            escritorio = (Escritorio) Nivel_2.desencolar();
            escritorio.contador = 0;
            System.out.println("Administrador esta retornando un escritorio de la Cola de Nivel 2");
        } else if (Nivel_3.tamano() > 0) {
            escritorio = (Escritorio) Nivel_3.desencolar();
            escritorio.contador = 0;
            System.out.println("Administrador esta retornando un escritorio de la Cola de Nivel 3");
        }

        TimeUnit.MILLISECONDS.sleep(delayVerMejor);
        vista.actualizarInterfaz(Nivel_1, Nivel_2, Nivel_3, Reparaciones);

        TimeUnit.MILLISECONDS.sleep(delayVerMejor);
        actualizarColas();
        vista.actualizarInterfaz(Nivel_1, Nivel_2, Nivel_3, Reparaciones);

        TimeUnit.MILLISECONDS.sleep(delayVerMejor);
        agregarEscritorio();
        //agregarEscritoriosParaPruebas();
        vista.actualizarInterfaz(Nivel_1, Nivel_2, Nivel_3, Reparaciones);

        return escritorio;
    }

    public void reubicarEscritorio(Escritorio escritorio) {

        if (escritorio.contador == -1) {
            // Necesitar más tiempo en revisión
            escritorio.contador = 0;
            switch (escritorio.nivel) {
                case 1:
                    Nivel_1.encolar(escritorio);
                    break;
                case 2:
                    Nivel_2.encolar(escritorio);
                    break;
                case 3:
                    Nivel_3.encolar(escritorio);
                    break;
            }
            System.out.println("El escritorio fue de vuelto a su ultima cola pues requiere de mas tiempo.");
        }

        if (escritorio.contador == -2) {
            // Requerir alguna reparaciones 
            escritorio.contador = 0;
            Reparaciones.encolar(escritorio);
            System.out.println("El escritorio fue colocado en la cola de Reparaciones.");
        }

    }

}
