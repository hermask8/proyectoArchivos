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
import java.io.PrintWriter;
import javax.swing.DefaultListModel;

/**
 *
 * @author ervi
 */
public class MetodosBitacora {
    
    public void LlenarArchivo(String strPath,String strContenido,String strError)
    {
        
        File Archivo = new File(strPath);
        
        try
        {
                FileWriter Escribir = new FileWriter(Archivo,true);
                BufferedWriter bw = new BufferedWriter(Escribir);
                
                bw.write(strContenido + System.lineSeparator());
                bw.close();
                Escribir.close();
                
        }
        catch(IOException ex)
        {
            strError= ex.getMessage();
        } 
        
    }
    
    public void Escribir(String pathDescBitacora,String pathBitacora,String pathMaster,String strContenido,String strError) throws IOException
    {
        if (ValidarEscritura(pathDescBitacora)==true) {
             File Archivo = new File(pathBitacora);
            if (Archivo.exists()) 
            { 
                BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
                String last = br.readLine(); 
                while (last != null) 
                { 
                    LlenarArchivo(pathMaster,last,strError);
                    last = br.readLine(); 
                } 
            }
            LlenarArchivo(pathMaster,strContenido,strError);
            BufferedWriter bw = new BufferedWriter(new FileWriter(pathBitacora));
            bw.write("");
            bw.close();
        }
        else
        {
            LlenarArchivo(pathBitacora,strContenido,strError);
        }
    }
    
    public String[] retorno(String[] array)
    {
        if (array!=null) {
        array[0] =quitarCaracteres(array[0]);
        array[1] =quitarCaracteres(array[1]);
        array[2] =quitarCaracteres(array[2]);
        array[3] =quitarCaracteres(array[3]);
        array[4] =quitarCaracteres(array[4]);
        array[5] =quitarCaracteres(array[5]);
        array[6] =quitarCaracteres(array[6]);
        array[7] =quitarCaracteres(array[7]);
        array[8] =quitarCaracteres(array[8]);
        array[9] =quitarCaracteres(array[9]);
        return array;    
        }
        else
        {
            return array;
        }
        
    }
    public String[] buscar(String path, String usuario) throws FileNotFoundException, IOException
    {
        String[] objeto2 = null;
        File Archivo = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
        String last = br.readLine(); 
        while (last != null) 
        { 
            String[] objeto= last.split("//");
            String nuevo = quitarCaracteres(objeto[0]);
            if (nuevo.equals(usuario)) {
                objeto2 = objeto;
            }
            
            last = br.readLine(); 
        } 
        return retorno(objeto2);
    }
    
    //Solo validar el vector va vacio osea null
    public String[] login(String pathBitacora, String pathMaster,String usuario) throws IOException
    {
        String[] objeto3 = buscar(pathBitacora,usuario);
        if (objeto3!=null) 
        {
            return objeto3;
        }
        else
        {
            objeto3 = buscar(pathMaster,usuario);
            return objeto3;
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
    
    public boolean validarUsuario(String strPath,String usuario) throws FileNotFoundException, IOException
    {
        boolean validar2 = false;
        File Archivo = new File(strPath);
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            while (last != null) 
            { 
                String[] valido = last.split("//");
                String comparar = quitarCaracteres(valido[0]);
                validar2 = comparar.equals(usuario);
                if (validar2==true) {
                    last = null;
                }
                else
                {
                    last = br.readLine();
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
        String[] objeto = leerUltimaLinea(strPath).split("//");
        int validar = Integer.valueOf(objeto[5]) / Integer.valueOf(objeto[8]) ;
        objeto = null;
        return validar ==0;
    }
    
  
    
    public String quitarCaracteres(String textoEntero)
    {
        StringBuilder texto = new StringBuilder();
        char separador = '%';
        for(int i = 0;i<textoEntero.length(); i++)
        {
            char separador2 = textoEntero.charAt(i);
            if (String.valueOf(separador).equals(String.valueOf(separador2))) {
                texto.append(separador2);
            }
        }
        
        return texto.toString();
    }
    public void escribirDescBitacora()
    {
        
    }
    
    public void escribirDescMaster()
    {
    
    }
}
