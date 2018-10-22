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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author ervi
 */
public class MetodosLista{
    MetodosBitacora mb = new MetodosBitacora();
    public boolean escribir(String[] usuario,String[] usuarioAsociado,int primero,int posicion) throws IOException
    {
        switch (comparar(usuarioAsociado[posicion],usuario[posicion])) {
            case 0:
                posicion = posicion+1;
                return escribir(usuario,usuarioAsociado,primero,posicion);
            case 1:
                if (primero==Integer.valueOf(usuario[0]))
                {
                    
                    usuarioAsociado[5] = usuario[0];
                    
                    IndiceListaUsuario miLista  = new IndiceListaUsuario(Integer.valueOf(usuario[0]),usuario[1],usuario[2],usuario[3],usuario[4],Integer.valueOf(usuario[5]),usuario[6]);
                    IndiceListaUsuario miLista2  = new IndiceListaUsuario(Integer.valueOf(usuarioAsociado[0]),usuarioAsociado[1],usuarioAsociado[2],usuarioAsociado[3],usuarioAsociado[4],Integer.valueOf(usuarioAsociado[5]),usuarioAsociado[6]);
                    quitarApuntadoresInservibles(miLista.ToString(),miLista2.ToString(),"");
                    sobreEscribir(miLista.ToString(),miLista2.ToString(),"");
                }
                else
                {
                    String[] anterior = buscar("C:/meia",usuario[0]);
                    anterior[5] = usuarioAsociado[0];
                    usuarioAsociado[5] = usuario[0];
                    IndiceListaUsuario miLista  = new IndiceListaUsuario(Integer.valueOf(anterior[0]),anterior[1],anterior[2],anterior[3],anterior[4],Integer.valueOf(anterior[5]),anterior[6]);
                    IndiceListaUsuario miLista2  = new IndiceListaUsuario(Integer.valueOf(usuarioAsociado[0]),usuarioAsociado[1],usuarioAsociado[2],usuarioAsociado[3],usuarioAsociado[4],Integer.valueOf(usuarioAsociado[5]),usuarioAsociado[6]);
                    quitarApuntadoresInservibles(miLista.ToString(),miLista2.ToString(),"");
                    sobreEscribir(miLista.ToString(),miLista2.ToString(),"");
                    
                }
                return false;
            case 2:
                if (Integer.valueOf(usuario[5])==-1) 
                {
                    usuario[5] = usuarioAsociado[0];
                    IndiceListaUsuario miLista  = new IndiceListaUsuario(Integer.valueOf(usuario[0]),usuario[1],usuario[2],usuario[3],usuario[4],Integer.valueOf(usuario[5]),usuario[6]);
                    IndiceListaUsuario miLista2  = new IndiceListaUsuario(Integer.valueOf(usuarioAsociado[0]),usuarioAsociado[1],usuarioAsociado[2],usuarioAsociado[3],usuarioAsociado[4],Integer.valueOf(usuarioAsociado[5]),usuarioAsociado[6]);
                    quitarApuntadoresInservibles(miLista.ToString(),miLista2.ToString(),"");
                    sobreEscribir(miLista.ToString(),miLista2.ToString(),"");
                    return false;
                }
                else
                {
                    usuario = apuntadorSiguiente(Integer.valueOf(usuario[5]));
                    return escribir(usuario,usuarioAsociado,primero,posicion);
                }
                
            default:
                return false;
        }
    }
    
    public void agregar(String[] usuarioAgregar) throws IOException
    {
        escribir(buscar2("C:meia","0"),usuarioAgregar,1,2);
    }
    public void quitarApuntadoresInservibles(String registro1,String registro2,String registro3) throws FileNotFoundException, IOException
    {
        String pathDescBitacora = "C:/MEIA/desc_bitacora.txt";
        String pathBitacora = "C:/MEIA/bitacora.txt";
        String pathMaster = "C:/MEIA/usuarios.txt";
        String pathDescUsuario = "C:/MEIA/desc_usuario.txt";
        File Archivo = new File(pathBitacora);
        BufferedReader br = new BufferedReader(new FileReader(Archivo));  
        String last = br.readLine();  
        while (last != null) 
        { 
            if (!registro1.equals("") && !registro2.equals("") && registro2.equals("") ) 
            {
                String[] excepto = last.split("//");
                if(!excepto[0].equals(registro1) || !excepto[0].equals(registro2))
                {
                    LlenarArchivo(pathMaster,last,"ERROR");
                }
            }
            else if(!registro1.equals("") && !registro2.equals("") && !registro2.equals(""))
            {
                String[] excepto = last.split("//");
                if(!excepto[0].equals(registro1) || !excepto[0].equals(registro2) || !excepto[0].equals(registro3) )
                {
                    LlenarArchivo(pathMaster,last,"ERROR");
                }
            }
            last = br.readLine(); 
        } 
        br.close();
    }
     public void sobreEscribir(String registro1, String registro2, String registro3) throws FileNotFoundException, IOException
     {
        String pathDescBitacora = "C:/MEIA/desc_bitacora.txt";
        String pathBitacora = "C:/MEIA/bitacora.txt";
        String pathMaster = "C:/MEIA/usuarios.txt";
        String pathDescUsuario = "C:/MEIA/desc_usuario.txt";
        File Archivo = new File(pathBitacora);
        BufferedReader br = new BufferedReader(new FileReader(Archivo));  
        String last = br.readLine();  
        while (last != null) 
        { 
            LlenarArchivo(pathMaster,last,"ERROR");
            last = br.readLine(); 
        } 
        if (!registro1.equals("") && !registro2.equals("") && registro2.equals("") ) 
        {
            LlenarArchivo(pathMaster,registro1,"ERROR");
            LlenarArchivo(pathMaster,registro2,"ERROR");
        }
        else if(!registro1.equals("") && !registro2.equals("") && !registro2.equals(""))
        {
            LlenarArchivo(pathMaster,registro1,"ERROR");
            LlenarArchivo(pathMaster,registro2,"ERROR");
            LlenarArchivo(pathMaster,registro3,"ERROR");
        }
        br.close();
    
     }
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
    public int comparar(String primero, String segundo)
    {
        if (primero.compareTo(segundo)==0) {
            return 0;
        }
        else if(primero.compareTo(segundo)<0)
        {
            return 1;
        }
        else if(primero.compareTo(segundo)>0)
        {
            return 2;
        }
        else
            return 3;
    }
    
    
    public String[] encontrarEnArchivo(int posicion)
    {
        String[] lista = new String[6];
        return lista;
    }
    public String[] apuntadorSiguiente(int apuntador) throws IOException
    {
        try (Stream<String> lines = Files.lines(Paths.get("file.txt"))) 
        {
            String line = lines.skip(apuntador-1).findFirst().get();
            String[] especificLine = line.split("//");
            return especificLine;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    private void escribir(String nombreLista, String usuario, String[] encontrarEnArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void Eliminar(String nomLista, String nomUsuario)
    {
        
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
    
    public String[] buscar(String path, String siguiente) throws FileNotFoundException, IOException
    {
        String[] objeto2 = null;
        File Archivo = new File(path);
        BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
        String last = br2.readLine(); 
        while (last != null) 
        { 
            String[] objeto= last.split("//");
            String nuevo = quitarCaracteres(objeto[5]);
            if (nuevo.equals(siguiente)) {
                objeto2 = objeto;
            }
            
            last = br2.readLine(); 
        } 
        br2.close();
        return retorno(objeto2);
    }
    public String[] buscar2(String path, String encontrar) throws FileNotFoundException, IOException
    {
        String[] objeto2 = null;
        File Archivo = new File(path);
        BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
        String last = br2.readLine(); 
        while (last != null) 
        { 
            String[] objeto= last.split("//");
            String nuevo = quitarCaracteres(objeto[0]);
            if (nuevo.equals(encontrar)) {
                objeto2 = objeto;
            }
            
            last = br2.readLine(); 
        } 
        br2.close();
        return retorno(objeto2);
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
        return array;    
        }
        else
        {
            return array;
        }
        
    }
    
}