package proyecto_2_so;

import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

public class Robot {

    public Escritorio revision(Escritorio escritorio, Interfaz vista) throws InterruptedException {
        System.out.println("Se inicia el proceso de revision en el Robot. (10 seg)");
        vista.cambiarMensaje("En proceso...");
        vista.cambiarRobotID("ID: " + String.valueOf(escritorio.ID));
        TimeUnit.SECONDS.sleep(8);
        Toolkit.getDefaultToolkit().beep();
        String mensaje = "";
        double random = Math.random();
        if (random < 0.25) {
            // Necesitar más tiempo en revisión
            escritorio.contador = -1;
            mensaje = "Necesitar más tiempo en revisión";
            System.out.println("Robot -> Necesitar más tiempo en revisión");
        } else if (random < 0.60) {
            // Requerir alguna mejora o reparacion
            escritorio.contador = -2;
            mensaje = "Requerir alguna reparacion";
            System.out.println("Robot -> Requerir alguna reparacion");
        } else {
            // Salir al mercado
            escritorio = null;
            mensaje = "Salir al mercado";
            System.out.println("Robot -> Salir al mercado");
        }

        vista.cambiarMensaje(mensaje);
        TimeUnit.SECONDS.sleep(2);
        vista.cambiarRobotID(" ");
        vista.cambiarMensaje(" ");

        System.out.println("Se finaliza el proceso de revision en el Robot. (10 seg)");
        return escritorio;
    }

}
