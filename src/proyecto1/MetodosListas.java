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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author chris
 */
public class MetodosListas {
    
    
    public String BuscarListaBitacora(String usuario, String nombreLista) throws FileNotFoundException, IOException{
        
        File Archivo = new File("C:/MEIA/Bitacora_Listas.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            while (last != null) 
            { 
                if(!last.equals("")){
                    String[] valido = last.split("//");
                
                    String Lista = quitarCaracteres(valido[0]);
                    String Us = quitarCaracteres(valido[1]);

                    if(Lista.equals(nombreLista) && Us.equals(usuario)){
                        br.close();
                        return Lista;
                    }
                    last = br.readLine();

                }else{
                    return "La lista no existe";
                }
            }
        br.close();
        return "La lista no existe";
    }
    
    public String BuscarListaMaster(String usuario, String nombreLista) throws FileNotFoundException, IOException{
        
        File Archivo = new File("C:/MEIA/Listas.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            while (last != null) 
            { 
                if(!last.equals("")){
                    String[] valido = last.split("//");
                
                    String Lista = quitarCaracteres(valido[0]);
                    String Us = quitarCaracteres(valido[1]);

                    if(Lista.equals(nombreLista) && Us.equals(usuario)){
                        br.close();
                        return Lista;
                    }
                    last = br.readLine();

                }else{
                    return "La lista no existe";
                }
            }
        br.close();
        return "La lista no existe";
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
    
    public boolean listaExiste(String strPath,String usuario, String nombreLista) throws FileNotFoundException, IOException
    {
        File Archivo = new File(strPath);
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            while (last != null) 
            { 
                if(!last.equals("")){
                    String[] valido = last.split("//");
                
                    String Lista = quitarCaracteres(valido[0]);
                    String Us = quitarCaracteres(valido[1]);

                    if(Lista.equals(nombreLista) && Us.equals(usuario)){
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
    
    
    
    
    public boolean bitacoraLLena(int tope) throws FileNotFoundException, IOException{

        int cont = 0;
        File Archivo = new File("C:/MEIA/Bitacora_Listas.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
        String last = br.readLine();
        while (last != null) 
        { 
            last = br.readLine();
            cont++;
        }    
        
        br.close();
        if(cont == tope){
            return true;
        }else{
            return false;
        }    

    }
    
   
    
    public void LlenarBitacora(String strContenido,String strError)
    {
        
        File Archivo = new File("C:/MEIA/Bitacora_Listas.txt");
        
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
    
    public void LlenarListasMaster() throws FileNotFoundException, IOException{
        String strError = "Error";
        List<String> listas = new ArrayList<>();
        
        File Archivo = new File("C:/MEIA/Bitacora_Listas.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
        String last = br.readLine();
        
        while (last != null) { 
            listas.add(last);
            last = br.readLine();
        }
        br.close();
        
        
        if(!VacioLista()){
            File Archivo2 = new File("C:/MEIA/Listas.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(Archivo2)); 
            String last2 = br2.readLine();

            while (last2 != null) { 
                listas.add(last2);
                last2 = br2.readLine();
            }
            br2.close();
 
        }
        
        String [] TodasLasListas = new String[listas.size()];
        
        for (int i = 0; i < listas.size(); i++) {
            TodasLasListas[i] = listas.get(i);
        }
        
        Arrays.sort(TodasLasListas);
        String cadena = "";
        
        for (int i = 0; i < TodasLasListas.length; i++) {
            if(i != TodasLasListas.length - 1){
                cadena = cadena + TodasLasListas[i] + "\r\n";
            }else{
                cadena = cadena + TodasLasListas[i];
            }
        }
        
        
        
        File Archivo3 = new File("C:/MEIA/Listas.txt");
        try
        {
                BufferedWriter bw1 = new BufferedWriter(new FileWriter("C:/MEIA/Listas.txt"));
                bw1.write("");
                bw1.close();
                
                
                FileWriter Escribir = new FileWriter(Archivo3,true);
                BufferedWriter bw = new BufferedWriter(Escribir);
                
                bw.write(cadena + System.lineSeparator());
                bw.close();
                Escribir.close();
                
                
                
                BufferedWriter bw12 = new BufferedWriter(new FileWriter("C:/MEIA/Bitacora_Listas.txt"));
                bw12.write("");
                bw12.close();
                
        }
        catch(IOException ex)
        {
            strError = ex.getMessage();
        } 
        
    }
    
    public boolean VacioLista() throws FileNotFoundException, IOException{
        
        File Archivo = new File("C:/MEIA/Listas.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            
            if(last != null){
                return false;
            }
            
        br.close();
        return true;
    }
    
    public int obtenerTopeBitacora() throws FileNotFoundException, IOException{
        
        int cont = 0;
        File Archivo = new File("C:/MEIA/Desc_Bitacora_Listas.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
        String last = br.readLine();
        
        String [] textocompleto = last.split("//");
        
        br.close();
        return Integer.parseInt(quitarCaracteres(textocompleto[5]));

    }
    
    
}
