/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author chris
 */
public class Nodo {
    public String dato;
    public String izquierdo;
    public String derecho;
    public String padre;
    
    //necesita el dato ya serializado
    public Nodo(String dato){
        
        this.dato = dato;
        izquierdo = "-1";
        derecho = "-1";
        padre = "-1";
        
    }
    
    public Nodo(String izq, String der, String dato){
        this.dato = dato;
        this.izquierdo = izq;
        this.derecho = der;
    }
    
    public static Nodo ObtenerNodo(int posReg){
       Nodo nodoNuevo;  
       try{
           if (posReg == -1) {
               return null;
           } else {
               FileReader fr = new FileReader("C:/MEIA/Mensajes.txt");
               BufferedReader br = new BufferedReader(fr);

               List<String> datos = br.lines().collect(Collectors.toList());
               
               if (datos.size() > 0) {
                   String dato = datos.get(posReg - 1);

                   nodoNuevo = Serialize.deserialize(dato);
               }
               else 
                   nodoNuevo = null;
           }

           
           return nodoNuevo;
           
       }catch(Exception e){
           
           e.printStackTrace();
           return null;
           
       }
     
    }
}
