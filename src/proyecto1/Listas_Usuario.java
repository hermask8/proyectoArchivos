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
import static proyecto1.Usuarios.padLeft;

/**
 *
 * @author chris
 */
public class Listas_Usuario {
    
    String Nombre;
    String UsuarioCreador;
    String UsuarioAsociado;
    String Descripcion;
    int NumeroUsuarios;
    int Estatus;
    
    public Listas_Usuario (String Nombre, String UsuarioCreador,String UsuarioAsociado, String Description , int Estatus){
        this.Nombre = Nombre;
        this.UsuarioCreador = UsuarioCreador;
        this.UsuarioAsociado = UsuarioAsociado;
        this.Descripcion = Description;
        this.Estatus = Estatus;
    }
    
    
    public String ConvertirATextoTamañoFijo()
        {
            StringBuilder sb = new StringBuilder();

            sb.append(padLeft(Nombre,30,"%"));
            sb.append("//");
            sb.append(padLeft(UsuarioCreador,20,"%"));
            sb.append("//");
            sb.append(padLeft(UsuarioAsociado,20,"%"));
            sb.append("//");
            sb.append(padLeft(Descripcion,40,"%"));
            sb.append("//");
            java.util.Date fecha = new Date();
            sb.append(fecha);
            sb.append("//");
            sb.append(String.valueOf(Estatus));
            return sb.toString();
        }
    
    
    
    public void LlenarListaUsuario(String cadena) throws IOException{
        
        String strError = "Error";
        
        
        File Archivo = new File("C:/MEIA/Listas_Usuario.txt");
        try
        {
           
            
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
    
    public boolean UsuarioExisteLista(String nombreLista, String usuario) throws FileNotFoundException, IOException{
        
        File Archivo = new File("C:/MEIA/Listas_Usuario.txt");
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
