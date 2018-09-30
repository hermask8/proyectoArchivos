/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ervi
 */
public class Usuarios {
    
     String Usuario;
     String Nombre;
     String Apellido;
     String Pasword;
     char Rol;
     Date Fecha;
     String Correo;
     int Telefono;
     String PathFotografia;
     char Status;

     
     
    public static String padLeft(String str, int length, String padChar) 
    {
        String pad = "";
        for (int i = 0; i < length; i++) 
        {
            pad += padChar;
        }
    return pad.substring(str.length()) + str;
    }
        public Usuarios()
        {
            this.Usuario = "";
            this.Nombre = "";
            this.Apellido = "";
            this.Pasword = "";
            this.Rol = '0';
            this.Fecha = new Date(01,01,1000);
            this.Correo = "";
            this.Telefono = 0;
            this.PathFotografia = "";
            this.Status='0';
        }

        public Usuarios(String usuario, String nombre, String apellido, String contraseña, char rol, Date fecha, String correo, int telefono,String pathFoto, char status)
        {
            this.Usuario = usuario;
            this.Nombre = nombre;
            this.Apellido = apellido;
            this.Pasword = contraseña;
            this.Rol = rol;
            this.Fecha = fecha;
            this.Correo = correo;
            this.Telefono = telefono;
            this.PathFotografia = pathFoto;
            this.Status=status;
        }

        public String ConvertirATextoTamañoFijo()
        {
            StringBuilder sb = new StringBuilder();

            sb.append(padLeft(Usuario,20,"%"));
            sb.append("//");
            sb.append(padLeft(Nombre,30,"%"));
            sb.append("//");
            sb.append(padLeft(Apellido,30,"%"));
            sb.append("//");
            sb.append(padLeft(Pasword,40,"%"));
            sb.append("//");
            sb.append(String.valueOf(Rol));
            sb.append("//");
            DateFormat df = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
            String date = df.format(Fecha);
            sb.append(padLeft(date,19,"%"));
            sb.append("//");
            sb.append(padLeft(Correo,40,"%"));
            sb.append("//");
            sb.append(padLeft(String.valueOf(Telefono),10,"%"));
            sb.append("//");
            sb.append(padLeft(PathFotografia,200,"%"));
            sb.append("//");
            sb.append(String.valueOf(Status));
            return sb.toString();
        }

       

        public String ToString()
        {
            return ConvertirATextoTamañoFijo();
        }
}