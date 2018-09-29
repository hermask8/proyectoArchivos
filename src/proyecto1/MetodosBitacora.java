/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;

/**
 *
 * @author ervi
 */
public class MetodosBitacora {
    
    public boolean LlenarArchivo(String strPath,String strContenido,String strError)
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
    
    public boolean Obtener(String strPath,String strError)
    {
        File Archivo = new File(strPath);
        if(!Archivo.exists())
        {
            strError="No existe el archivo";
            return false;
        }
        else
        {
            FileReader LecturaArchivo;
            try {
                LecturaArchivo = new FileReader(Archivo);
                BufferedReader LeerArchivo = new BufferedReader(LecturaArchivo);
                String Linea="";
                try {
                    Linea=LeerArchivo.readLine();
                    String[] split;
                    DefaultListModel modeloNombre= new DefaultListModel();
                    DefaultListModel modeloApellido= new DefaultListModel(); 
                    while(Linea != null)
                    {
                        if(!"".equals(Linea))
                        {
                            split=Linea.split(",");
                            modeloNombre.addElement(split[0]);
                            modeloApellido.addElement(split[1]);
                        }
                        Linea=LeerArchivo.readLine();
                    }

                    LecturaArchivo.close();
                    LeerArchivo.close();
                    
                    //lstNombres.setModel(modeloNombre);
                    //lstApellidos.setModel(modeloApellido);
                    strError="";
                    return true;
                    
                } catch (IOException ex) {
                    strError= ex.getMessage();
                    return false;
                }
            } catch (FileNotFoundException ex) {
                strError= ex.getMessage();
                return false;
            }
        }
    }
    
    public boolean ValidarLLeno()
    {
        return false;
    }
    
    public boolean EscribirDescVitacora()
    {
        return false;
    }
    
    
}
