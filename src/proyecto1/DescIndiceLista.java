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
import java.util.Date;

/**
 *
 * @author chris
 */
public class DescIndiceLista {
    
    
    public String OrganizacionDeDatos(int numeroRegistros,int registroInicio,int registrosActivos, int registrosInactivos) throws IOException
        {
            StringBuilder sb = new StringBuilder();

            sb.append(numeroRegistros);
            sb.append("//");
            sb.append(registroInicio);
            sb.append("//");
            sb.append(registrosActivos);
            sb.append("//");
            sb.append(registrosInactivos);
                       
            return sb.toString();
        }
    
    public int ObtenerRaiz() throws IOException{
        File Archivo = new File("C:/MEIA/Desc_Indice_Lista_Usuarios.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
        String last = br.readLine();
        String [] lineaSeparada = last.split("//");
        
        return Integer.valueOf(lineaSeparada[1]);
        
    }
    
    public void LlenarDescIndice(String cadena) throws IOException{
        
        String strError = "Error";
        
        BufferedWriter bw12 = new BufferedWriter(new FileWriter("C:/MEIA/Desc_Bitacora_Listas.txt"));
        bw12.write("");
        bw12.close();
        
        
        File Archivo = new File("C:/MEIA/Desc_Bitacora_Listas.txt");
        try
        {
            BufferedWriter bw1 = new BufferedWriter(new FileWriter("C:/MEIA/Desc_Bitacora_Listas.txt"));
            bw1.write("");
            bw1.close();
            
            
            FileWriter Escribir = new FileWriter(Archivo,true);
            BufferedWriter bw = new BufferedWriter(Escribir);
            
                
            bw.write(cadena + System.lineSeparator());
            bw.close();
            Escribir.close();
                
        }
        catch(IOException ex)
        {
            strError= ex.getMessage();
        } 
    }
    
    public int registrosActivos() throws FileNotFoundException, IOException{
        
        int cont = 0;
        File Archivo = new File("C:/MEIA/Indice_Listas_Usuario.txt");
        String [] lineaSeparada;
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
        String last = br.readLine();
        while (last != null) 
        { 
            
            lineaSeparada = last.split("//");
            if(quitarCaracteres(lineaSeparada[2]) == "1"){
                cont++;
            }
            last = br.readLine();
        }    
        
        br.close();
        
        
        return cont;
    }
    
    public boolean EstaVacio() throws FileNotFoundException, IOException{
        
        File Archivo = new File("C:/MEIA/Indice_Lista.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            
            if(last != null){
                return false;
            }
            
        br.close();
        return true;
    }
    
    
    public int registrosInactivos() throws FileNotFoundException, IOException{
        
        int cont = 0;
        File Archivo = new File("C:/MEIA/Indice_Listas_Usuario.txt");
        String [] lineaSeparada;
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
        String last = br.readLine();
        while (last != null) 
        { 
            
            lineaSeparada = last.split("//");
            if(quitarCaracteres(lineaSeparada[3]) == "0"){
                cont++;
            }
            last = br.readLine();
        }    
        
        br.close();
        
        
        return cont;
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
    
    public int numeroRegistros() throws FileNotFoundException, IOException{
        
        int cont = 0;
        File Archivo = new File("C:/MEIA/Indice_Listas_Usuario.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
        String last = br.readLine();
        while (last != null) 
        { 
            last = br.readLine();
            cont++;
        }    
        
        br.close();
        
        
        return cont;
    }
    
    
    
    
}
