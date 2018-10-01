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
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.swing.DefaultListModel;

/**
 *
 * @author ervi
 */
public class MetodosBitacora {
    
    public void LlenarArchivo(String strPath,String strContenido,String strError)
    {
        
        File Archivo5 = new File(strPath);
        
        try
        {
                FileWriter Escribir = new FileWriter(Archivo5,true);
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
    public void LlenarArchivo2(String strContenido,String strError)
    {
        
        File Archivo5 = new File("C:/MEIA/desc_bitacora.txt");
        
        try
        {
                FileWriter Escribir2 = new FileWriter(Archivo5,true);
                BufferedWriter bw = new BufferedWriter(Escribir2);
                
                bw.write(strContenido + System.lineSeparator());
                bw.close();
                Escribir2.close();
                
        }
        catch(IOException ex)
        {
            strError= ex.getMessage();
        } 
        
    }
    public void Escribir(String strContenido,String strError) throws IOException
    {
        String pathDescBitacora = "C:/MEIA/desc_bitacora.txt";
        String pathBitacora = "C:/MEIA/bitacora.txt";
        String pathMaster = "C:/MEIA/usuarios.txt";
        String pathDescUsuario = "C:/MEIA/desc_usuario.txt";
        if (ValidarEscritura(pathDescBitacora)==true) {
             File Archivo = new File(pathBitacora);
             File Archivo2 = new File(pathDescBitacora);
            if (Archivo.exists()) 
            { 
                BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
                BufferedReader br2 = new BufferedReader(new FileReader(Archivo2)); 
                String last = br.readLine(); 
                String last2 = br2.readLine(); 
                while (last != null) 
                { 
                    LlenarArchivo(pathMaster,last,strError);
                    LlenarArchivo2(last2,strError);
                    last = br.readLine(); 
                    last2 = br2.readLine();
                } 
                br.close();
                br2.close();
            }
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(pathBitacora));
            bw.write("");
            bw.close();
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(pathDescBitacora));
            bw2.write("");
            bw2.close();
            LlenarArchivo(pathBitacora,strContenido,strError);
        }
        else
        {
            LlenarArchivo(pathBitacora,strContenido,strError);
        }
    }
    
    public void Backup(String ori, String des){
        File origen = new File("C:/MEIA");
        File destino = new File(des);
        try{
            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);
            
            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
              out.write(buf, 0, len);
            }

            in.close();
            out.close();
            
        }catch(IOException e){
            e.printStackTrace();
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
        BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
        String last = br2.readLine(); 
        while (last != null) 
        { 
            String[] objeto= last.split("//");
            String nuevo = quitarCaracteres(objeto[0]);
            if (nuevo.equals(usuario)) {
                objeto2 = objeto;
            }
            
            last = br2.readLine(); 
        } 
        br2.close();
        return retorno(objeto2);
    }
    
    //Solo validar el vector va vacio osea null
    public String[] login(String usuario) throws IOException
    {
        String pathBitacora = "C:/MEIA/usuarios.txt";
        String pathMaster = "C:/MEIA/bitacora.txt";
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
        br.close();
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
        
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine(); 
            while (last != null) 
            { 
            lastLine = last; 
            last = br.readLine(); 
            } 
        br.close();
        return lastLine;
    }
    
    public boolean ValidarEscritura(String strPath ) throws IOException
    {
        if (!leerUltimaLinea(strPath).equals("")) {
            String[] objeto = leerUltimaLinea(strPath).split("//");
        int validar = Integer.valueOf(objeto[5]) / Integer.valueOf(objeto[8]);
        objeto = null;
        return validar == 0;
        }else{
            return false;
        }
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
    public void escribirDescBitacora()
    {
        
    }
    
    public void escribirDescMaster()
    {
    
    }
}
