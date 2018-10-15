/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author Inerjanuer
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;

public class Copy {

    private String ubi, dato, rename, ext;

    public void archivos() throws InterruptedException, IOException {
        File source = new File(ubi + "\\" + dato);
        File dest = new File(ubi + "\\"+rename+"_copia"+ext);

        //copy file conventional way using Stream
        // start = System.nanoTime();
        copyFileUsingStream(source, dest);
        JOptionPane.showMessageDialog(null, "Copied file" /*+ "Tiempo estimado de ejecucion= " + (System.nanoTime() - start)*/);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            int i=0;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
                System.out.println( ++i +" "+ length);
            }
        } finally {
            is.close();
            os.close();
        }

    }

    public void source(String parent, String name) {
        ubi = parent;
        dato = name;
        renombrar(name);
    }

    private void renombrar(String name) {
        rename = name.substring(0, name.lastIndexOf("."));
        int cadena=name.length();
        ext = name.substring(name.lastIndexOf("."),cadena);
    }

}
