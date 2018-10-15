/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import mundo.Copy;

/**
 *
 * @author Inerjanuer
 */
public class Controlador {
    private Copy copy;
    
    public Controlador(){
        copy = new Copy();
    }

   
    public void archivo(String parent, String name) {
        copy.source(parent,name);
    }

    public void generarCopia() throws InterruptedException, IOException {
        copy.archivos();
    }
    
}
