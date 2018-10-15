/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazApp;

import controlador.Controlador;
import javax.swing.JFrame;

/**
 *
 * @author Inerjanuer
 */
public class InterfazApp extends JFrame {

    private Controlador ctrl;
    private PanelSeleccion pnlSeleccion;

    public InterfazApp(Controlador ctrl) {

        setTitle("Copy");
        getContentPane().setLayout(null);

        this.ctrl = ctrl;

        pnlSeleccion = new PanelSeleccion(ctrl);
        pnlSeleccion.setBounds(10, 10, 250, 250);

        getContentPane().add(pnlSeleccion);

        setSize(280, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        InterfazApp frMain = new InterfazApp(new Controlador());
        frMain.setLocationRelativeTo(null);
        frMain.setVisible(true);
    }
}
