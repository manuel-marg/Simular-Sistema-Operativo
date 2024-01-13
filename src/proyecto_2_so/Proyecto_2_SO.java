package proyecto_2_so;

import java.util.concurrent.TimeUnit;

public class Proyecto_2_SO {

    public static void main(String[] args) throws InterruptedException {
        Interfaz vista = new Interfaz();
        vista.setVisible(true);

        Cola Nivel_1 = new Cola();
        Cola Nivel_2 = new Cola();
        Cola Nivel_3 = new Cola();
        Cola Reparaciones = new Cola();
        Administrador administrador = new Administrador(Reparaciones, Nivel_1, Nivel_2, Nivel_3, 0, 0);
        Robot robot = new Robot();
        
        Escritorio escritorio = null;
        while (true) {
            escritorio = administrador.obtenerEscritorio(escritorio, vista);
            if (escritorio != null) {
                try {
                    escritorio = robot.revision(escritorio, vista);
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException ex) {
                    System.out.println("Error.");
                }
            } else {
                System.out.println("No se pudo obtener escritorios del Administrador.");
            }
        }
    }

}
