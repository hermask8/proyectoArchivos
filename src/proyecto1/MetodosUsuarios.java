/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 *
 * @author ervi
 */
public class MetodosUsuarios {
    public boolean EscribirUsuario(String strPath,String strContenido,String strError)
    {
        File Archivo = new File(strPath);
        
        try
        {
                FileWriter Escribir = new FileWriter(Archivo,true);
                BufferedWriter bw = new BufferedWriter(Escribir);
                bw.write(strContenido + System.lineSeparator());
                bw.close();
                Escribir.close();
                
                return true;
        }
        catch(IOException ex)
        {
            strError= ex.getMessage();
            return false;
        } 
        
    }
    
    public String CopiarImagen(String ruta1, String nombre)
         {
            try
            {
                FileInputStream fis = new FileInputStream(ruta1);
                FileOutputStream fos = new FileOutputStream("C:/MEIA/fotografia/"+nombre+".jpg");
                FileChannel inChannel = fis.getChannel(); 
                FileChannel outChannel = fos.getChannel(); 
                inChannel.transferTo(0, inChannel.size(), outChannel); 
                fis.close(); 
                fos.close();
            }

            catch(IOException e)
            {

            } 
            
            return "C:/MEIA/Fotografias/"+nombre+".jpg";
         }
    
    
    public void escribirDescMaster()
    {
        
    }
}
