
package proyecto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static proyecto1.Usuarios.padLeft;


public class Listas {
    
    String Nombre;
    String UsuarioCreador;
    String Descripcion;
    int NumeroUsuarios;
    int Estatus;
    
    
    public Listas (String Nombre, String UsuarioCreador, String Description , int NumeroUsuarios, int Estatus){
        this.Nombre = Nombre;
        this.UsuarioCreador = UsuarioCreador;
        this.Descripcion = Description;
        this.NumeroUsuarios = NumeroUsuarios;
        this.Estatus = Estatus;
    }
    
    
    public String ConvertirATextoTamañoFijo()
        {
            StringBuilder sb = new StringBuilder();

            sb.append(padLeft(Nombre,30,"%"));
            sb.append("//");
            sb.append(padLeft(UsuarioCreador,20,"%"));
            sb.append("//");
            sb.append(padLeft(Descripcion,40,"%"));
            sb.append("//");
            sb.append(padLeft(String.valueOf(NumeroUsuarios),40,"%"));
            sb.append("//");
            sb.append(String.valueOf(Estatus));
            return sb.toString();
        }
    
    
    
    
    
}