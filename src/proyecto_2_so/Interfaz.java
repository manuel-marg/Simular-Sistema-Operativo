/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_2_so;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class Interfaz extends javax.swing.JFrame {

    public DefaultTableModel modelNivel_1 = new DefaultTableModel();
    public DefaultTableModel modelNivel_2 = new DefaultTableModel();
    public DefaultTableModel modelNivel_3 = new DefaultTableModel();
    public DefaultTableModel modelReparaciones = new DefaultTableModel();

    boolean control = false;

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("IKEA_Logo.png"));
        setIconImage(icono);
    }

    public void actualizarInterfaz(Cola Nivel_1, Cola Nivel_2, Cola Nivel_3, Cola Reparaciones) {

        System.out.println("Generando la Tabla de Nivel 1");
        String[] tituloNivel_1 = {"Nivel 1"};
        modelNivel_1 = new DefaultTableModel(null, tituloNivel_1);
        for (int i = 0; i < Nivel_1.tamano(); i++) {
            System.out.println("Tamano nivel 1 "+Nivel_1.tamano());
            System.out.println("Escritorio obtenido " +Nivel_1.obtener(i));
            Escritorio escritorio = (Escritorio) Nivel_1.obtener(i);
            String[] row = {"ID: " + escritorio.ID + " - " + escritorio.contador};
            modelNivel_1.addRow(row);
        }

        jTableNivel1.setModel(modelNivel_1);

        System.out.println("Generando la Tabla de Nivel 2");
        String[] tituloNivel_2 = {"Nivel 2"};
        modelNivel_2 = new DefaultTableModel(null, tituloNivel_2);
        for (int i = 0; i < Nivel_2.tamano(); i++) {
            Escritorio escritorio = (Escritorio) Nivel_2.obtener(i);
            String[] row = {"ID: " + escritorio.ID + " - " + escritorio.contador};
            modelNivel_2.addRow(row);
        }
        jTableNivel2.setModel(modelNivel_2);

        System.out.println("Generando la Tabla de Nivel 3");
        String[] tituloNivel_3 = {"Nivel 3"};
        modelNivel_3 = new DefaultTableModel(null, tituloNivel_3);
        for (int i = 0; i < Nivel_3.tamano(); i++) {
            Escritorio escritorio = (Escritorio) Nivel_3.obtener(i);
            String[] row = {"ID: " + escritorio.ID + " - " + escritorio.contador};
            modelNivel_3.addRow(row);
        }
        jTableNivel3.setModel(modelNivel_3);

        System.out.println("Generando la Tabla de Reparciones");
        String[] tituloReparaciones = {"Reparaciones"};
        modelReparaciones = new DefaultTableModel(null, tituloReparaciones);
        for (int i = 0; i < Reparaciones.tamano(); i++) {
            Escritorio escritorio = (Escritorio) Reparaciones.obtener(i);
            String[] row = {"ID: " + escritorio.ID + " - " + escritorio.contador};
            modelReparaciones.addRow(row);
        }
        jTableReparaciones.setModel(modelReparaciones);

    }

    public void cambiarMensaje(String mensaje) {
        jLabelMensajeRobot.setText(mensaje);
    }

    public void cambiarRobotID(String ID) {
        jLabelRobot.setText(ID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelMensajeRobot = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableNivel3 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableReparaciones = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableNivel2 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableNivel1 = new javax.swing.JTable();
        jLabelRobot = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Detección de errores en el ensamblaje");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMensajeRobot.setText(" ");
        jLabelMensajeRobot.setBorder(javax.swing.BorderFactory.createTitledBorder("Mensaje del Robot"));
        jPanel1.add(jLabelMensajeRobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 280, -1));

        jTableNivel3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(jTableNivel3);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 85, 130));

        jTableReparaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(jTableReparaciones);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 85, 130));

        jTableNivel2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(jTableNivel2);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 85, 130));

        jTableNivel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(jTableNivel1);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 85, 130));

        jLabelRobot.setText(" ");
        jLabelRobot.setBorder(javax.swing.BorderFactory.createTitledBorder("Robot"));
        jPanel1.add(jLabelRobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 60, -1));

        jTabbedPane1.addTab("Simulación", jPanel1);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("¿De qué trata el proyecto?"));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Gracias a tu excelente trabajo, Ikea ha decidido contratarte de nuevo para elaborar otra\nsimulación. En este caso, planean la compra de un robot que permitiría la detección de errores\nen el ensamblaje, lo que hará mucho más rápida la siguiente generación escritorios llamados\nArauca, para ello, la simulación debe ser de la siguiente manera:\n\n1. Robot (Procesador): su función es recibir los Arauca uno a uno y realizarles pruebas con el\nfin de determinar si el escritorio está listo para salir al mercado o si requiere alguna mejora.\nCon el fin de poder revisar varios Arauca exhaustivamente, la máquina revisa cada uno por\nun período de 10 segundos. En caso de no poder concluir todavía si el escritorio está\ncompleto o debe mejorarse, se encola para esperar nuevamente por una siguiente\nrevisión.\nTome en cuenta que, por cada revisión, Ikea ha determinado que el escritorio tiene una\nprobabilidad de salir al mercado del 40%, una probabilidad de volver a encolarse por\nnecesitar más tiempo en revisión del 25% y una probabilidad de requerir alguna mejora\ndel 35%. Estos valores son constantes para todos los escritorios durante toda la simulación.\n\n2. Arauca (Proceso): para efectos de la simulación, sólo debe tomar en cuenta que el\nescritorio tiene un ID entero único asociado y alguno de los tres niveles de prioridad\nexpuestos, cada uno de estos niveles con su propia cola:\nNivel 1: prioridad alta, si hay alguno dentro del sistema, debe pasar al robot sobre\nlos de otra prioridad.\nNivel 2: prioridad mediana, pueden pasar al robot siempre y cuando no haya\nningún escritorio de nivel 1.\nNivel 3: prioridad baja, sólo pasan al robot si no hay escritorios de nivel 1 o 2\nencolados.\nPara efectos de las reparaciones o mejoras, todos los Arauca (sin importar su prioridad)\nson colocados en una misma cola y son despachados de ella uno a uno. Por cada vez que\nse actualicen las colas, existe un 45% de probabilidades de que el primer Arauca en esta\ncola salga, y sea colocado en la cola de los Arauca listos para la revisión.\nLos escritorios también tienen asociados un pequeño contador que muestra cuántos\nescritorios distintos a ellos ya han pasado por el robot. Cuando al Arauca le toca el turno\nde ser revisado, este contador se pasa a cero. Por otra parte, cuando el contador llega a 8,\nel escritorio es subido al siguiente nivel de prioridad y el contador se actualiza a cero\nnuevamente (es decir, si el escritorio es de nivel 3, pasaría a ser de nivel 2), este\nfuncionamiento solo aplica para escritorios de nivel 2 y 3.\n\n3. Administrador (Sistema Operativo): se encarga de actualizar las colas del sistema y\ndictarle al robot cuál es el siguiente Arauca que debe revisar. También, cada dos ciclos de\nrevisión (es decir, cada dos escritorios revisados), el administrador agrega un nuevo Arauca\na la cola de su nivel correspondiente. Este evento ocurre con una probabilidad del 70% y\nla prioridad de éste es completamente aleatoria. Se enfatiza que el administrador opera\ncada vez que el robot acaba de terminar de revisar un Arauca, realiza toda la gestión\ndescrita respecto a las colas y finalmente le indica al robot que puede empezar a trabajar\notra vez con el escritorio seleccionado.\n\nLa simulación opera de la siguiente manera: comienza a ejecutarse y se debe crear un Arauca.\nUna vez ahí comienza a operar el robot, después el administrador y así. Se debe mostrar en\npantalla en todo momento las colas que mantiene el administrador, con los ID de los escritorios\nen cada una en el orden en el cual estén, junto con el ID del Arauca que se encuentra en revisión. ");
        jTextArea1.setToolTipText("");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Información", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 250));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Detección de errores en el ensamblaje");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 4, 260, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_2_so/IKEA_Fondo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelMensajeRobot;
    private javax.swing.JLabel jLabelRobot;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableNivel1;
    private javax.swing.JTable jTableNivel2;
    private javax.swing.JTable jTableNivel3;
    private javax.swing.JTable jTableReparaciones;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
