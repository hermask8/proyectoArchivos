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
public class MetodosLista2{
    MetodosBitacora mb = new MetodosBitacora();
    public void BorrarLineas5(String lineaEliminar,String linea1)
    {
        try  
        {
            int numero = 0;
            List<String> miLista = new ArrayList<>();
            File Archivo = new File("C:/MEIA/lista1.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
            String last = br2.readLine(); 
            while (last != null) 
            { 
                miLista.add(last);
                last = br2.readLine();
                numero++;
            } 
            br2.close();
            vaciarArchivo();
            miLista.remove(Integer.valueOf(lineaEliminar)-1);
            miLista.add(linea1);
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
                if (numero2<=numero)
                {
                    LlenarArchivo("C:/MEIA/lista1.txt",lineas,"ERROR");
                    numero2++;
                }
                
            }
            
        }
        catch(Exception ex)
        {
            
        }
    }
    public void BorrarLineas4(String linea1)
    {
        try  
        {
            int numero = 0;
            List<String> miLista = new ArrayList<>();
            File Archivo = new File("C:/MEIA/lista1.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
            String last = br2.readLine(); 
            while (last != null) 
            { 
                miLista.add(last);
                last = br2.readLine();
                numero++;
            } 
            br2.close();
            vaciarArchivo();
            miLista.remove(Integer.valueOf(linea1)-1);
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
                if (numero2<=numero)
                {
                    LlenarArchivo("C:/MEIA/lista1.txt",lineas,"ERROR");
                    numero2++;
                }
                
            }
            
        }
        catch(Exception ex)
        {
            
        }
    }
   public void eliminar(String nombre, String primero) throws IOException
    {
        
        String[] user = buscarUser("C:/MEIA/lista1.txt",nombre);
        
        if(user[0].equals(primero))
        {
            BorrarLineas4(user[0]);
            CasoBase2(user[0]);
            CasoBase(user[0]);
        }
        else if (!user[0].equals(primero) && !user[5].equals("-1")) 
        {
            String[] buscar = buscar("C:/MEIA/lista1.txt",user[0]);
            BorrarLineas4(user[0]);
            buscar[5] = user[5];
            IndiceListaUsuario miLista  = new IndiceListaUsuario(Integer.valueOf(buscar[0]),buscar[1],buscar[2],buscar[3],buscar[4],Integer.valueOf(buscar[5]),buscar[6]);
            BorrarLineas5(buscar[0],miLista.ToString());
            CasoBase(user[0]);
            CasoBase2(user[0]);
        }
        
        else if (user[5].equals("-1")) 
        {
            String[] buscar = buscar("C:/MEIA/lista1.txt",user[0]);
            BorrarLineas4(user[0]);
            buscar[5] = "-1";
            IndiceListaUsuario miLista  = new IndiceListaUsuario(Integer.valueOf(buscar[0]),buscar[1],buscar[2],buscar[3],buscar[4],Integer.valueOf(buscar[5]),buscar[6]);
            BorrarLineas5(buscar[0],miLista.ToString());
            CasoBase(user[0]);
            CasoBase2(user[0]);
        }
        
    }
    
    public void Ordenar() throws FileNotFoundException, IOException
    {
            List<String> miLista = new ArrayList<>();
            File Archivo = new File("C:/MEIA/lista1.txt");
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
                LlenarArchivo("C:/MEIA/lista1.txt",lineas,"ERROR");
                numero2++;
            }
    }
    public void CasoBase2(String registroEliminado) throws FileNotFoundException, IOException
    {
        try  
        {
            List<String> miLista = new ArrayList<>();
            File Archivo = new File("C:/MEIA/lista1.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
            String last = br2.readLine(); 
            while (last != null) 
            { 
                miLista.add(last);
                last = br2.readLine(); 
            } 
            br2.close();
            vaciarArchivo();
            for ( String lineas : miLista ) 
            {
                String[] lines = lineas.split("//");
                int numero = comparar(lines[0],registroEliminado);
                if (numero==2) 
                {
                    lines[0] = String.valueOf(Integer.valueOf(lines[0])-1); 
                    lines[1] = "1."+String.valueOf(Integer.valueOf(lines[0])); 
                }
                
                IndiceListaUsuario porLinea = new IndiceListaUsuario(Integer.valueOf(lines[0]),lines[1],lines[2],lines[3],lines[4],Integer.valueOf(lines[5]),lines[6]);
                LlenarArchivo("C:/MEIA/lista1.txt",porLinea.ToString(),"ERROR");
            }
            
        }
        catch(Exception ex)
        {
            
        }
    }
    public void CasoBase(String registroEliminado) throws FileNotFoundException, IOException
    {
        try  
        {
            List<String> miLista = new ArrayList<>();
            File Archivo = new File("C:/MEIA/lista1.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
            String last = br2.readLine(); 
            while (last != null) 
            { 
                miLista.add(last);
                last = br2.readLine(); 
            } 
            br2.close();
            vaciarArchivo();
            for ( String lineas : miLista ) 
            {
                String[] lines = lineas.split("//");
                if (!lines[5].equals("-1")) 
                {
                    int numero = comparar(lines[5],registroEliminado);
                    if (numero==2) 
                    {
                        lines[5] = String.valueOf(Integer.valueOf(lines[5])-1); 
                    }
                }
                
                IndiceListaUsuario porLinea = new IndiceListaUsuario(Integer.valueOf(lines[0]),lines[1],lines[2],lines[3],lines[4],Integer.valueOf(lines[5]),lines[6]);
                LlenarArchivo("C:/MEIA/lista1.txt",porLinea.ToString(),"ERROR");
            }
            
        }
        catch(Exception ex)
        {
            
        }
    }
    
    public void BorrarLineas3(String linea1,String lineaAgregar1)
    {
        try  
        {
            int numero = 0;
            List<String> miLista = new ArrayList<>();
            File Archivo = new File("C:/MEIA/lista1.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
            String last = br2.readLine(); 
            while (last != null) 
            { 
                miLista.add(last);
                last = br2.readLine();
                numero++;
            } 
            br2.close();
            vaciarArchivo();
            miLista.remove(Integer.valueOf(linea1)-1);
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
                int numero2 = 0;
                if (numero2<=numero)
                {
                    LlenarArchivo("C:/MEIA/lista1.txt",lineas,"ERROR");
                    numero2++;
                }
                
            }
            
        }
        catch(Exception ex)
        {
            
        }
    }
    
    public void BorrarLineas(String linea1,String linea2,String lineaAgregar1,String lineaAgregar2)
    {
        try  
        {
            
            List<String> miLista = new ArrayList<>();
            File Archivo = new File("C:/MEIA/lista1.txt");
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
                LlenarArchivo("C:/MEIA/lista1.txt",lineas,"ERROR");
            }
            
        }
        catch(Exception ex)
        {
            
        }
    }
    
    public void BorrarLineas2(String linea1,String lineaAgregar1,String lineaAgregar2)
    {
        try  
        {
            int numero = 0;
            List<String> miLista = new ArrayList<>();
            File Archivo = new File("C:/MEIA/lista1.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
            String last = br2.readLine(); 
            while (last != null) 
            { 
                miLista.add(last);
                last = br2.readLine();
                numero++;
            } 
            br2.close();
            vaciarArchivo();
            miLista.remove(Integer.valueOf(linea1)-1);
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
                int numero2 = 0;
                if (numero2<=numero)
                {
                    LlenarArchivo("C:/MEIA/lista1.txt",lineas,"ERROR");
                    numero2++;
                }
                
            }
            
        }
        catch(Exception ex)
        {
            
        }
    }
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
                 
                    BorrarLineas(usuario[0],usuarioAsociado[0],miLista.ToString(),miLista2.ToString());
                }
                else
                {
                    String[] anterior = buscar("C:/MEIA/lista1.txt",usuario[0]);
                    anterior[5] = usuarioAsociado[0];
                    usuarioAsociado[5] = usuario[0];
                    IndiceListaUsuario miLista  = new IndiceListaUsuario(Integer.valueOf(anterior[0]),anterior[1],anterior[2],anterior[3],anterior[4],Integer.valueOf(anterior[5]),anterior[6]);
                    IndiceListaUsuario miLista2  = new IndiceListaUsuario(Integer.valueOf(usuarioAsociado[0]),usuarioAsociado[1],usuarioAsociado[2],usuarioAsociado[3],usuarioAsociado[4],Integer.valueOf(usuarioAsociado[5]),usuarioAsociado[6]);
                   // vaciarArchivo();
                    BorrarLineas2(anterior[0],miLista.ToString(),miLista2.ToString());
                    
                    
                }
                return false;
            case 2:
                if (Integer.valueOf(usuario[5])==-1) 
                {
                    usuario[5] = usuarioAsociado[0];
                    IndiceListaUsuario miLista  = new IndiceListaUsuario(Integer.valueOf(usuario[0]),usuario[1],usuario[2],usuario[3],usuario[4],Integer.valueOf(usuario[5]),usuario[6]);
                    IndiceListaUsuario miLista2  = new IndiceListaUsuario(Integer.valueOf(usuarioAsociado[0]),usuarioAsociado[1],usuarioAsociado[2],usuarioAsociado[3],usuarioAsociado[4],Integer.valueOf(usuarioAsociado[5]),usuarioAsociado[6]);
                    //vaciarArchivo();
                    BorrarLineas(usuario[0],usuarioAsociado[0],miLista.ToString(),miLista2.ToString());
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
        escribir(buscar2("C:/MEIA/lista1.txt","1"),usuarioAgregar,1,2);
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
        try (Stream<String> lines = Files.lines(Paths.get("C:/MEIA/lista1.txt"))) 
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
    
     public void vaciarArchivo() throws FileNotFoundException, IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/MEIA/lista1.txt"));
        bw.write("");
        bw.close();
    }
     
     public String[] buscarUser(String path, String siguiente) throws FileNotFoundException, IOException
    {
        String[] objeto2 = null;
        File Archivo = new File(path);
        BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
        String last = br2.readLine(); 
        while (last != null) 
        { 
            String[] objeto= last.split("//");
            String nuevo = quitarCaracteres(objeto[4]);
            if (nuevo.equals(siguiente)) {
                objeto2 = objeto;
            }
            
            last = br2.readLine(); 
        } 
        br2.close();
        return retorno(objeto2);
    }
    
}
