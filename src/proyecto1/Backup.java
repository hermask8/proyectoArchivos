/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.util.Date;

/**
 *
 * @author ervi
 */
public class Backup {
    String RutaAbsoluta; 
    String UsuarioCreacion;
    Date FechaCreacion;
     
        public Backup()
        {
            RutaAbsoluta = "";
            UsuarioCreacion = "";
            FechaCreacion = new Date(1,1,1998);
        }

        public Backup(String AbsolutaRuta, Date CreacionFecha, String CreacionUsuario)
        {
            this.RutaAbsoluta = AbsolutaRuta;
            this.UsuarioCreacion = CreacionUsuario;
            this.FechaCreacion = CreacionFecha;
        }   

        public String ConvertirATextoTamañoFijo()
        {
            StringBuilder sb = new StringBuilder();
            sb.append(RutaAbsoluta);
            sb.append("//");
            sb.append(UsuarioCreacion);
            sb.append("//");
            sb.append(FechaCreacion.toString());
           
            return sb.toString();
        }
}
