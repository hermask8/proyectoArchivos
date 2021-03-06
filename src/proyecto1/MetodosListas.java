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
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import static proyecto1.Usuarios.padLeft;

/**
 *
 * @author chris
 */
public class MetodosListas {
    
    
    
    
    
    
    
    
    public void DesactivarBitacoraLista(String nombreLista, String usuario){
        File archivo = new File("C:/MEIA/Bitacora_Listas.txt");
        
    }
    
    public void DesactivarUsuarioListaUsuario(String usuarioCreador,String nombreUsuario, String nombreLista) throws FileNotFoundException, IOException{
        File Archivo = new File("C:/MEIA/Listas_Usuario.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
        String last = br.readLine();
        int cont = 0;
        while(last != null){
            cont++;
            last = br.readLine();
        }
        br.close();
        BufferedReader br2 = new BufferedReader(new FileReader(Archivo));
        last = br2.readLine();
        String [] completo = new String [cont+1];
        cont = 0;
        
        while(last != null){
            completo[cont] = last;
            cont++;
            last = br2.readLine();
        }
        br2.close();
        
        for (int i = 0; i < completo.length; i++) {
            if (completo[i] != null) {
                String separar [] = completo[i].split("//");
            String lista = quitarCaracteres(separar[0]);
            String creador = quitarCaracteres(separar[1]);
            String asociado = quitarCaracteres(separar[2]);
            
            if (lista.equals(nombreLista) && creador.equals(usuarioCreador) && asociado.equals(nombreUsuario)) {
                completo[i] = null;
            }
            }
            
        }
        
        BufferedWriter bw12 = new BufferedWriter(new FileWriter("C:/MEIA/Listas_Usuario.txt"));
        bw12.write("");
        bw12.close();
        
        File Archivo3 = new File("C:/MEIA/Listas_Usuario.txt");
        
        FileWriter Escribir2 = new FileWriter(Archivo3,true);
        BufferedWriter bw2 = new BufferedWriter(Escribir2);
        
        
                
        for (int i = 0; i < completo.length; i++) {
            if (completo[i] != null){
                bw2.write(completo[i] + System.lineSeparator());
            }
        }
        
        
        bw2.close();
        Escribir2.close();
  
            
    }
    
    public String ConvertirATextoTamañoFijo(String nombre, String creador, String asociado,String descripcion, String estatus)
    {
            StringBuilder sb = new StringBuilder();

            sb.append(padLeft(nombre,30,"%"));
            sb.append("//");
            sb.append(padLeft(creador,20,"%"));
            sb.append("//");
            sb.append(padLeft(asociado,20,"%"));
            sb.append("//");
            sb.append(padLeft(descripcion,40,"%"));
            sb.append("//");
            java.util.Date fecha = new Date();
            sb.append(fecha);
            sb.append("//");
            sb.append(String.valueOf(estatus));
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
    
    
    
    public String ObtenerDescriptionMaster(String nombreLista, String usuario) throws FileNotFoundException, IOException{
        File Archivo = new File("C:/MEIA/Listas.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            while (last != null) 
            { 
                String [] separar = last.split("//");
                String lista = quitarCaracteres(separar[0]);
                String us = quitarCaracteres(separar[1]);
                if(us.equals(usuario) && lista.equals(nombreLista)){
                    return quitarCaracteres(separar[2]);
                }
                
                last = br.readLine();
            }
        br.close();
        return "0";
    }
    
    public String ObtenerDescriptionBitacora(String nombreLista, String usuario) throws FileNotFoundException, IOException{
        File Archivo = new File("C:/MEIA/Bitacora_Listas.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            while (last != null) 
            { 
                String [] separar = last.split("//");
                String lista = quitarCaracteres(separar[0]);
                String us = quitarCaracteres(separar[1]);
                if(us.equals(usuario) && lista.equals(nombreLista)){
                    return quitarCaracteres(separar[2]);
                }
                
                last = br.readLine();
            }
        br.close();
        return "0";
    }
    
    
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
    
    public boolean UsuarioExisteListaUsuarios(String nombreLista ,String usuarioCreador, String usuario) throws FileNotFoundException, IOException
    {
        File Archivo = new File("C:/MEIA/Listas_Usuario.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            while (last != null) 
            { 
                if(!last.equals("")){
                    String[] valido = last.split("//");
                
                    String Lista = quitarCaracteres(valido[0]);
                    String Us = quitarCaracteres(valido[1]);
                    String usu = quitarCaracteres(valido[2]);

                    if(Lista.equals(nombreLista) && Us.equals(usuarioCreador) && usu.equals(usuario)){
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
    
    
    
    
    public boolean EstaActivaBitacoraLista(String nombreLista, String usuario) throws FileNotFoundException, IOException{
        
        File Archivo = new File("C:/MEIA/Bitacora_Listas.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            while (last != null) 
            { 
                if(!last.equals("")){
                    String[] valido = last.split("//");
                
                    String Lista = quitarCaracteres(valido[0]);
                    String Us = quitarCaracteres(valido[1]);
                    int estado = Integer.parseInt(quitarCaracteres(valido[4]));

                    if(Lista.equals(nombreLista) && Us.equals(usuario)){
                        if (estado == 1) {
                            br.close();
                            return true;
                        }
                    }
                    last = br.readLine();

                }else{
                    return false;
                }
            }
        br.close();
        return false;
    }
    
    public boolean EstaActivaListaMaster(String nombreLista, String usuario) throws FileNotFoundException, IOException{
        
        File Archivo = new File("C:/MEIA/Listas.txt");
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine();
            while (last != null) 
            { 
                if(!last.equals("")){
                    String[] valido = last.split("//");
                
                    String Lista = quitarCaracteres(valido[0]);
                    String Us = quitarCaracteres(valido[1]);
                    int estado = Integer.parseInt(quitarCaracteres(valido[4]));

                    if(Lista.equals(nombreLista) && Us.equals(usuario)){
                        if (estado == 1) {
                            br.close();
                            return true;
                        }
                    }
                    last = br.readLine();

                }else{
                    return false;
                }
            }
        br.close();
        return false;
    }
    
    
}
