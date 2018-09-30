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
    
    public boolean validarUsuario(String strPath,String contra) throws FileNotFoundException, IOException
    {
        boolean validar2 = false;
        File Archivo = new File(strPath);
        if (Archivo.exists()) 
        { 
            BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            while (last != null) 
            { 
                String[] valido = last.split("|");
                String contrase = valido[3].substring(valido[3].indexOf("%") + 1);
                validar2 = contrase.equals(contra);
            } 
        }
        return validar2;
    }
    
    public boolean EscribirDescBitacora()
    {
        return false;
    }
    
    public String leerUltimaLinea(String strPath) throws FileNotFoundException, IOException
    {
        String lastLine= "";
        File Archivo = new File(strPath);
        if (Archivo.exists()) 
        { 
            BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine(); 
            while (last != null) 
            { 
            lastLine = last; 
            last = br.readLine(); 
            } 
        }
        return lastLine;
    }
    
    public boolean ValidarEscritura(String strPath ) throws IOException
    {
        String[] objeto = leerUltimaLinea(strPath).split("|");
        int validar = Integer.valueOf(objeto[5]) / Integer.valueOf(objeto[8]) ;
        objeto = null;
        return validar ==0;
    }
    
    public void escribirMaster()
    {
        
    }
    
    public void escribirDescBitacora()
    {
        
    }
    
    public void escribirDescMaster()
    {
    
    }
}
