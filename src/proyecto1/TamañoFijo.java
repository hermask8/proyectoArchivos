package proyecto1;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ervi
 */
public class TamañoFijo {
    int posicion;
    int izquierda;
    int derecha;
    String emisor;
    String receptor;
    String mensaje;
    
    public TamañoFijo()
    {
        this.posicion = 0;
        this.izquierda = -1;
        this.derecha =-1;
        this.emisor="";
        this.receptor="";
        this.mensaje="";
    }
    
    public TamañoFijo(int posicion2,int izquierda2,int derecha2,String emisor2,String receptor2,String mensaje2)
    {
        this.posicion = posicion2;
        this.izquierda = izquierda2;
        this.derecha =derecha2;
        this.emisor=emisor2;
        this.receptor=receptor2;
        this.mensaje=mensaje2;
    }
    
    public String ConvertirATextoTamañoFijo()
        {
            StringBuilder sb = new StringBuilder();
            sb.append(posicion);
            sb.append("//");
            sb.append(String.valueOf(izquierda));
            sb.append("//");
            sb.append(String.valueOf(derecha));
            sb.append("//");
            sb.append(emisor);
            sb.append("//");
            sb.append(receptor);
            sb.append("//");
            sb.append(mensaje);
            
            return sb.toString();
        }
    
}
