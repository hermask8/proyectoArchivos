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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author ervi
 */
public class ArbolBinario {
    
    
    public void agregar(String[] usuarioAgregar,int Raiz) throws IOException
    {
        escribir(buscar2("/Users/ervi/Desktop/Lista.txt",String.valueOf(Raiz)),usuarioAgregar,Raiz,3);
        
    }
    
    public void EliminarDato(String datoEliminar,int Raiz) throws IOException
    {
        Eliminar(buscar2("/Users/ervi/Desktop/Lista.txt",String.valueOf(Raiz)),datoEliminar);
        
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
    
    
    public boolean escribir(String[] mensajeComparador,String[] nuevoMensaje,int primero,int posicion) throws IOException
    {
        switch (comparar(nuevoMensaje[posicion],mensajeComparador[posicion])) {
            case 0:
                posicion = posicion+1;
                return escribir(mensajeComparador,nuevoMensaje,primero,posicion);
            case 1:
                if (mensajeComparador[1].equals("-1"))
                {
                    mensajeComparador[1] = nuevoMensaje[0];
                    TamañoFijo miMensaje1 = new TamañoFijo(Integer.valueOf(mensajeComparador[0]),Integer.valueOf(mensajeComparador[1]),Integer.valueOf(mensajeComparador[2]),mensajeComparador[3],mensajeComparador[4],mensajeComparador[5]);
                    TamañoFijo miMensaje2 = new TamañoFijo(Integer.valueOf(nuevoMensaje[0]),Integer.valueOf(nuevoMensaje[1]),Integer.valueOf(nuevoMensaje[2]),nuevoMensaje[3],nuevoMensaje[4],nuevoMensaje[5]);
                    BorrarLineas(mensajeComparador[0],miMensaje1.ConvertirATextoTamañoFijo(),miMensaje2.ConvertirATextoTamañoFijo());
                    return false;
                }
                else
                {
                    return escribir(apuntadorSiguiente(Integer.valueOf(mensajeComparador[1])),nuevoMensaje,primero,posicion);
                }
            case 2:
                if (mensajeComparador[2].equals("-1"))
                {
                    
                    mensajeComparador[2] = nuevoMensaje[0];
                    TamañoFijo miMensaje1 = new TamañoFijo(Integer.valueOf(mensajeComparador[0]),Integer.valueOf(mensajeComparador[1]),Integer.valueOf(mensajeComparador[2]),mensajeComparador[3],mensajeComparador[4],mensajeComparador[5]);
                    TamañoFijo miMensaje2 = new TamañoFijo(Integer.valueOf(nuevoMensaje[0]),Integer.valueOf(nuevoMensaje[1]),Integer.valueOf(nuevoMensaje[2]),nuevoMensaje[3],nuevoMensaje[4],nuevoMensaje[5]);
                    BorrarLineas(mensajeComparador[0],miMensaje1.ConvertirATextoTamañoFijo(),miMensaje2.ConvertirATextoTamañoFijo());
                    return false;
                }
                else
                {
                    return escribir(apuntadorSiguiente(Integer.valueOf(mensajeComparador[2])),nuevoMensaje,primero,posicion);
                }
            default:
                return false;
        }
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
            if (objeto[0].equals(encontrar)) {
                objeto2 = objeto;
            }
            
            last = br2.readLine(); 
        } 
        br2.close();
        return objeto2;
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
    
    public String[] apuntadorSiguiente(int apuntador) throws IOException
    {
        try (Stream<String> lines = Files.lines(Paths.get("/Users/ervi/Desktop/Lista.txt"))) 
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
    
    public int contador() throws IOException
    {
        try (Stream<String> lines = Files.lines(Paths.get("/Users/ervi/Desktop/Lista.txt"))) 
        {
            int numero = (int) lines.count();
            return numero;
        }
        catch(Exception ex)
        {
            return 0;
        }
    }
    
    
    public void Ordenar() throws FileNotFoundException, IOException
    {
            List<String> miLista = new ArrayList<>();
            File Archivo = new File("/Users/ervi/Desktop/Lista.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
            String last = br2.readLine(); 
            while (last != null) 
            { 
                miLista.add(last);
                last = br2.readLine(); 
            } 
            
            Collections.sort(miLista, new Comparator<String>() {
            public int compare(String o1, String o2) {
            return extractInt(o1) - extractInt(o2);
            }

            int extractInt(String s) {
            String num = s.replaceAll("\\D", "");
            return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
            });

            for ( String lineas : miLista ) 
            {
                int numero2 = 0;
                LlenarArchivo("/Users/ervi/Desktop/Lista.txt",lineas,"ERROR");
                numero2++;
            }
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
    
    public void vaciarArchivo() throws FileNotFoundException, IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/ervi/Desktop/Lista.txt"));
        bw.write("");
        bw.close();
    }
    
    public void BorrarLineas(String linea1,String lineaAgregar1,String lineaAgregar2)
    {
        try  
        {
            
            List<String> miLista = new ArrayList<>();
            File Archivo = new File("/Users/ervi/Desktop/Lista.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
            String last = br2.readLine(); 
            while (last != null) 
            { 
                miLista.add(last);
                last = br2.readLine(); 
            } 
            br2.close();
            vaciarArchivo();
            miLista.remove(Integer.valueOf(linea1)-1);
           // miLista.remove(Integer.valueOf(linea2)-1);
            miLista.add(lineaAgregar1);
            miLista.add(lineaAgregar2);
            Collections.sort(miLista, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }

        int extractInt(String s) {
            String num = s.replaceAll("\\D", "");
            return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
         });

            for ( String lineas : miLista ) 
            {
                LlenarArchivo("/Users/ervi/Desktop/Lista.txt",lineas,"ERROR");
            }
            
        }
        catch(Exception ex)
        {
            
        }
    }
    
    public String[] buscarEliminar(String path, String encontrar) throws FileNotFoundException, IOException
    {
        String[] objeto2 = null;
        File Archivo = new File(path);
        BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
        String last = br2.readLine(); 
        while (last != null) 
        { 
            String[] objeto= last.split("//");
            if (objeto[0].equals(encontrar)) {
                objeto2 = objeto;
            }
            
            last = br2.readLine(); 
        } 
        br2.close();
        return objeto2;
    }
    
    String[] padre = null;
    boolean fueIzquierda = false;
    boolean fueDerecha = false;
    public boolean Eliminar(String[] mensajeActual,String datoEliminar) throws IOException
    {
        switch (comparar(datoEliminar, mensajeActual[5])) {
            case 0:
                if (mensajeActual[1].equals("-1") && mensajeActual[2].equals("-1") && padre!=null)
                {
                    if (fueIzquierda==true) {
                        padre[1] = "-1";
                        TamañoFijo miMensaje1 = new TamañoFijo(Integer.valueOf(padre[0]),Integer.valueOf(padre[1]),Integer.valueOf(padre[2]),padre[3],padre[4],padre[5]);
                        BorrarLineasEliminar(padre[0],mensajeActual[0],miMensaje1.ConvertirATextoTamañoFijo());
                        
                    }
                    if (fueDerecha==true) {
                        padre[2] = "-1";
                        TamañoFijo miMensaje1 = new TamañoFijo(Integer.valueOf(padre[0]),Integer.valueOf(padre[1]),Integer.valueOf(padre[2]),padre[3],padre[4],padre[5]);
                        BorrarLineasEliminar(padre[0],mensajeActual[0],miMensaje1.ConvertirATextoTamañoFijo());
                    }
                    
                    reorganizar(mensajeActual[0],"/Users/ervi/Desktop/Lista.txt");
                }
                
                return false;
            case 1:
                if (mensajeActual[1].equals("-1")) {
                    return false;
                }
                else
                {
                    padre = mensajeActual;
                    fueIzquierda = true;
                    fueDerecha = false;
                    return Eliminar(apuntadorSiguiente(Integer.valueOf(mensajeActual[1])),datoEliminar);   
                }
                
            case 2:
                if (mensajeActual[2].equals("-1")) 
                {
                    return false;
                }
                else
                {
                    padre = mensajeActual;
                    fueIzquierda = false;
                    fueDerecha = true;
                    return Eliminar(apuntadorSiguiente(Integer.valueOf(mensajeActual[2])),datoEliminar);   
                }
                
            default:
                return false;
        }
    }
    
    public void BorrarLineasReorganizar(String linea1,String lineaAgregar1)
    {
        try  
        {
            
            List<String> miLista = new ArrayList<>();
            File Archivo = new File("/Users/ervi/Desktop/Lista.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
            String last = br2.readLine(); 
            while (last != null) 
            { 
                miLista.add(last);
                last = br2.readLine(); 
            } 
            br2.close();
            vaciarArchivo();
            miLista.remove(Integer.valueOf(linea1)-1);
           // miLista.remove(Integer.valueOf(linea2)-1);
            miLista.add(lineaAgregar1);
            Collections.sort(miLista, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }

        int extractInt(String s) {
            String num = s.replaceAll("\\D", "");
            return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
         });

            for ( String lineas : miLista ) 
            {
                LlenarArchivo("/Users/ervi/Desktop/Lista.txt",lineas,"ERROR");
            }
            
        }
        catch(Exception ex)
        {
            
        }
    }
    public void BorrarLineasEliminar(String linea1,String linea2,String lineaAgregar1)
    {
        try  
        {
            
            List<String> miLista = new ArrayList<>();
            File Archivo = new File("/Users/ervi/Desktop/Lista.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
            String last = br2.readLine(); 
            while (last != null) 
            { 
                miLista.add(last);
                last = br2.readLine(); 
            } 
            br2.close();
            vaciarArchivo();
            miLista.remove(Integer.valueOf(linea1)-1);
            miLista.remove(Integer.valueOf(linea2)-2);
            miLista.add(lineaAgregar1);
            Collections.sort(miLista, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }

        int extractInt(String s) {
            String num = s.replaceAll("\\D", "");
            return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
         });

            for ( String lineas : miLista ) 
            {
                LlenarArchivo("/Users/ervi/Desktop/Lista.txt",lineas,"ERROR");
            }
            
        }
        catch(Exception ex)
        {
            
        }
    }
    
    public void reorganizar(String posicionEliminado, String path) throws FileNotFoundException, IOException
    {
        String[] objeto2 = null;
        File Archivo = new File(path);
        BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
        String last = br2.readLine(); 
        while (last != null) 
        {
            if (comparar(objeto2[0], posicionEliminado)==2) {
                objeto2[0] = String.valueOf((Integer.valueOf(objeto2[0])-1));
                TamañoFijo miMensaje1 = new TamañoFijo(Integer.valueOf(objeto2[0]),Integer.valueOf(objeto2[1]),Integer.valueOf(objeto2[2]),objeto2[3],objeto2[4],objeto2[5]);
                BorrarLineasReorganizar(objeto2[0],miMensaje1.ConvertirATextoTamañoFijo());
            } 
            if (comparar(objeto2[1], posicionEliminado)==2) {
                objeto2[1] = String.valueOf((Integer.valueOf(objeto2[1])-1)); 
                TamañoFijo miMensaje1 = new TamañoFijo(Integer.valueOf(objeto2[0]),Integer.valueOf(objeto2[1]),Integer.valueOf(objeto2[2]),objeto2[3],objeto2[4],objeto2[5]);
                BorrarLineasReorganizar(objeto2[0],miMensaje1.ConvertirATextoTamañoFijo());
            }
            if (comparar(objeto2[2], posicionEliminado)==2) {
                objeto2[2] = String.valueOf((Integer.valueOf(objeto2[2])-1)); 
                TamañoFijo miMensaje1 = new TamañoFijo(Integer.valueOf(objeto2[0]),Integer.valueOf(objeto2[1]),Integer.valueOf(objeto2[2]),objeto2[3],objeto2[4],objeto2[5]);
                BorrarLineasReorganizar(objeto2[0],miMensaje1.ConvertirATextoTamañoFijo());
            }
            last = br2.readLine();
            
        } 
        br2.close();
    }
    
    public ArrayList<String> grupal(String path, String encontrar) throws FileNotFoundException, IOException
    {
        ArrayList<String> miLista = new ArrayList<>();
        
        
        File Archivo = new File(path);
        BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
        String last = br2.readLine(); 
        while (last != null) 
        { 
            String[] objeto= last.split("//");
            if (objeto[2].equals(encontrar)) {
                miLista.add(last);
            }
            
            last = br2.readLine(); 
        } 
        br2.close();
        return miLista;
    }
    
    public ArrayList<String> MensajesEmisor(String path, String encontrar) throws FileNotFoundException, IOException
    {
        ArrayList<String> miLista = new ArrayList<>();
        
        
        File Archivo = new File(path);
        BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
        String last = br2.readLine(); 
        while (last != null) 
        { 
            String[] objeto= last.split("//");
            if (objeto[3].equals(encontrar)) {
                miLista.add(last);
            }
            
            last = br2.readLine(); 
        } 
        br2.close();
        return miLista;
    }
    
    public ArrayList<String> MensajesReceptor(String path, String encontrar) throws FileNotFoundException, IOException
    {
        ArrayList<String> miLista = new ArrayList<>();
        
        
        File Archivo = new File(path);
        BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
        String last = br2.readLine(); 
        while (last != null) 
        { 
            String[] objeto= last.split("//");
            if (objeto[4].equals(encontrar)) {
                miLista.add(last);
            }
            
            last = br2.readLine(); 
        } 
        br2.close();
        return miLista;
    }
  
}
