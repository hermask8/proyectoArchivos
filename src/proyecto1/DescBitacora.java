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
public class DescBitacora {
    
    String NombreSimbolico;
    Date fechaCreacion;
    String UsuarioCreacion;
    Date FechaModificacion;
    int NumeroRegistros;
    int RegistrosActivos;
    int RegistrosInactivos;
    int MaxReorganizacion;
     
        public DescBitacora()
        {
            this.NombreSimbolico = "";
            this.fechaCreacion = new Date(1,1,1987);
            this.UsuarioCreacion = "";
            this.FechaModificacion = new Date(1,1,1987);
            this.NumeroRegistros = 0;
            this.RegistrosActivos = 0;
            this.RegistrosInactivos = 0;
            this.MaxReorganizacion = 0;
        }

        public DescBitacora(String nombreSimbolico, Date CreacionFecha, String CreacionUsuario, Date ModificacionFecha, int RegistrosNumero, int ActivosRegistros,int InactivosRegistros, int organizacionMax)
        {
            this.NombreSimbolico = nombreSimbolico;
            this.fechaCreacion = CreacionFecha;
            this.UsuarioCreacion = CreacionUsuario;
            this.FechaModificacion = ModificacionFecha;
            this.NumeroRegistros = RegistrosNumero;
            this.RegistrosActivos = ActivosRegistros;
            this.RegistrosInactivos = InactivosRegistros;
            this.MaxReorganizacion = organizacionMax;
        }   

        public String ConvertirATextoTamañoFijo()
        {
            StringBuilder sb = new StringBuilder();
            sb.append(NombreSimbolico);
            sb.append("//");
            sb.append(fechaCreacion.toString());
            sb.append("//");
            sb.append(UsuarioCreacion);
            sb.append("//");
            sb.append(FechaModificacion.toString());
            sb.append("//");
            sb.append(NumeroRegistros);
            sb.append("//");
            sb.append(RegistrosActivos);
            sb.append("//");
            sb.append(RegistrosInactivos);
            sb.append("//");
            sb.append(MaxReorganizacion);
            
            return sb.toString();
        }
    
}
