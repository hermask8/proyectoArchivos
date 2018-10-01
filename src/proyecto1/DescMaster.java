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
public class DescMaster {
     String NombreSimbolico;
    Date fechaCreacion;
    String UsuarioCreacion;
    Date FechaModificacion;
    int NumeroRegistros;
    int RegistrosActivos;
    int RegistrosInactivos;
     
        public DescMaster()
        {
            this.NombreSimbolico = "";
            this.fechaCreacion = new Date(1,1,1987);
            this.UsuarioCreacion = "";
            this.FechaModificacion = new Date(1,1,1987);
            this.NumeroRegistros = 0;
            this.RegistrosActivos = 0;
            this.RegistrosInactivos = 0;
        }

        public DescMaster(String nombreSimbolico, Date CreacionFecha, String CreacionUsuario, Date ModificacionFecha, int RegistrosNumero, int ActivosRegistros,int InactivosRegistros)
        {
            this.NombreSimbolico = nombreSimbolico;
            this.fechaCreacion = CreacionFecha;
            this.UsuarioCreacion = CreacionUsuario;
            this.FechaModificacion = ModificacionFecha;
            this.NumeroRegistros = RegistrosNumero;
            this.RegistrosActivos = ActivosRegistros;
            this.RegistrosInactivos = InactivosRegistros;
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
            
            return sb.toString();
        }
}
