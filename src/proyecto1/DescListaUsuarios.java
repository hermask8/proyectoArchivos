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
public class DescListaUsuarios {
    
    public String OrganizacionDeDatos(String usuarioCreador,int registros, int registrosActivos,int registrosInactivos) throws IOException
        {
            StringBuilder sb = new StringBuilder();

            sb.append(usuarioCreador);
            sb.append("//");
            java.util.Date fecha = new Date();
            sb.append(fecha);
            sb.append("//");
            sb.append(registros);
            sb.append("//");
            sb.append(registrosActivos);
            sb.append("//");
            sb.append(registrosInactivos);
                       
            return sb.toString();
        }
    
    public boolean EstaVacio() throws FileNotFoundException, IOException{
        
        File Archivo = new File("C:/MEIA/Desc_Listas_Usuario.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            
            if(last != null){
                return false;
            }
            
        br.close();
        return true;
    }
    
    public void LlenarDescListaUsuario(String cadena) throws IOException{
        
        String strError = "Error";
        
        BufferedWriter bw12 = new BufferedWriter(new FileWriter("C:/MEIA/Desc_Listas_Usuario.txt"));
        bw12.write("");
        bw12.close();
        
        
        File Archivo = new File("C:/MEIA/Desc_Listas_Usuario.txt");
        try
        {
            BufferedWriter bw1 = new BufferedWriter(new FileWriter("C:/MEIA/Desc_Listas_Usuario.txt"));
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
        File Archivo = new File("C:/MEIA/Listas_Usuario.txt");
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
    
    public int registrosInactivos() throws FileNotFoundException, IOException{
        
        int cont = 0;
        File Archivo = new File("C:/MEIA/Listas_Usuario.txt");
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
        File Archivo = new File("C:/MEIA/Listas_Usuario.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
        String last = br.readLine();
        while (last != null) 
        { 
            
            cont++;
            last = br.readLine();
        }    
        
        br.close();
        
        
        return cont;
    }
    
    
}
