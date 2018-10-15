/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazApp;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import controlador.Controlador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Inerjanuer
 */
class PanelSeleccion extends JPanel implements ActionListener {

    private JButton btnFile, btnCopy;
    private Controlador ctrl;

    public PanelSeleccion(Controlador ctrl) {
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Seleccion")));
        setLayout(null);
        this.ctrl = ctrl;

        btnFile = new JButton("File");
        btnFile.setBounds(10, 20, 230, 100);

        btnCopy = new JButton("Copy File");
        btnCopy.setBounds(10, 120, 230, 100);

        add(btnFile);
        add(btnCopy);

        btnFile.addActionListener(this);
        btnCopy.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFile) {
            Component parent = (Component) e.getSource();
            JFileChooser fileChooser = new JFileChooser(".");
            int status = fileChooser.showOpenDialog(parent);
            if (status == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                ctrl.archivo(selectedFile.getParent(), selectedFile.getName());
            } else if (status == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "No file has been selected to be copied.");
            }
        }
        if (e.getSource() == btnCopy) {
            try {
                ctrl.generarCopia();
            } catch (InterruptedException | IOException ex) {
                Logger.getLogger(PanelSeleccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
