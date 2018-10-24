/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author chris
 */
public class DescIndiceLista {
    
    
    public String OrganizacionDeDatos(int registroInicio) throws IOException
        {
            StringBuilder sb = new StringBuilder();

            sb.append(numeroRegistros());
            sb.append("//");
            sb.append(registroInicio);
            sb.append("//");
            sb.append(registrosActivos());
            sb.append("//");
            sb.append(registrosInactivos());
                       
            return sb.toString();
        }
    
    public int registrosActivos() throws FileNotFoundException, IOException{
        
        int cont = 0;
        File Archivo = new File("C:/MEIA/Indice_Lista.txt");
        String [] lineaSeparada;
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
        String last = br.readLine();
        while (last != null) 
        { 
            last = br.readLine();
            lineaSeparada = last.split("//");
            if(quitarCaracteres(lineaSeparada[4]) == "1"){
                cont++;
            }
        }    
        
        br.close();
        
        
        return cont;
    }
    
    public int registrosInactivos() throws FileNotFoundException, IOException{
        
        int cont = 0;
        File Archivo = new File("C:/MEIA/Indice_Lista.txt");
        String [] lineaSeparada;
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
        String last = br.readLine();
        while (last != null) 
        { 
            last = br.readLine();
            lineaSeparada = last.split("//");
            if(quitarCaracteres(lineaSeparada[4]) == "0"){
                cont++;
            }
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
        File Archivo = new File("C:/MEIA/Indice_Lista.txt");
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
