/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_meia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author chris
 */
public class UsarioExiste {
    
    public Boolean Existe(String usuario) throws FileNotFoundException, IOException{
        
        File Archivo = new File("C:/MEIA/bitacora.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
        String last = br.readLine();
        int cont = 0;
        while(last != null){
            String [] separar =last.split("//");
            if(quitarCaracteres(separar[0]).equals(usuario)){
                return true;
            }
            last = br.readLine();
        }
        
        File Archivo2 = new File("C:/MEIA/usuarios.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(Archivo2)); 
        String last2 = br2.readLine();
        
        while(last2 != null){
            String [] separar = last2.split("//");
            if(quitarCaracteres(separar[0]).equals(usuario)){
                return true;
            }
            last2 = br2.readLine();
        }
        
        return false;
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
    
    
}
