/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
    
    public boolean ExisteUsuarioBitacora(String usuario) throws FileNotFoundException, IOException{
        
        File Archivo = new File("C:/MEIA/bitacora.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            while (last != null) 
            { 
                if(!last.equals("")){
                    String[] valido = last.split("//");
                
                    String us = quitarCaracteres(valido[0]);
                    

                    if(us.equals(usuario)){
                        br.close();
                        return true;
                    }
                    last = br.readLine();

                }else{
                    return false;
                }
            }
        br.close();
        return false;
        
    }
    
    public boolean ExisteUsuarioMaster(String usuario) throws FileNotFoundException, IOException{
        
        File Archivo = new File("C:/MEIA/usuarios.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            while (last != null) 
            { 
                if(!last.equals("")){
                    String[] valido = last.split("//");
                
                    String us = quitarCaracteres(valido[0]);
                    
                    if(us.equals(usuario)){
                        br.close();
                        return true;
                    }
                    last = br.readLine();

                }else{
                    return false;
                }
            }
        br.close();
        return false;
        
    }
    
    public String quitarCaracteres(String textoEntero)
    {
        StringBuilder texto = new StringBuilder();
        char separador = '%';
        for(int i = 0;i<textoEntero.length(); i++)
        {
            char separador2 = textoEntero.charAt(i);
            if (!String.valueOf(separador).equals(String.valueOf(separador2))) {
                texto.append(separador2);
            }
        }
        
        return texto.toString();
    }
    
}
