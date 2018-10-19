/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ervi
 */
public class VentanaUsuarios extends javax.swing.JFrame {

    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    byte[] imagen;
    FileInputStream entrada;
    FileOutputStream salida;
    public static int numero = 0;
    
    
    
    
    
    public VentanaUsuarios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        txtTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSeleccionarImagen = new javax.swing.JButton();
        btnCrearUsuario = new javax.swing.JButton();
        lblMostrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setText("Crear Cuenta");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/LOGO_MEIA2 (2).png"))); // NOI18N

        jLabel2.setText("Usuario:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido:");

        jLabel5.setText("Correo Electronioc:");

        jLabel6.setText("Contraseña:");

        jLabel7.setText("Fecha de nacimiento:");

        jLabel9.setText("Telefono:");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel10.setText("/");

        jLabel11.setText("/");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Foto de Perfil");

        btnSeleccionarImagen.setText("Seleccionar");
        btnSeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarImagenActionPerformed(evt);
            }
        });

        btnCrearUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCrearUsuario.setText("Crear Cuentra");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        lblMostrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel9))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCorreo)
                                        .addComponent(txtContraseña)
                                        .addComponent(txtUsuario)
                                        .addComponent(txtNombre)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel8))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1)
                                .addGap(110, 110, 110))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnSeleccionarImagen))
                                        .addGap(80, 80, 80))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(btnSeleccionarImagen)
                        .addGap(7, 7, 7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(btnCrearUsuario)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        MetodosBitacora mb = new MetodosBitacora();
        if(!txtUsuario.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtCorreo.getText().isEmpty() 
                && !txtContraseña.getText().isEmpty() && !txtDia.getText().isEmpty() && !txtMes.getText().isEmpty() && !txtAño.getText().isEmpty() 
                && !txtTelefono.getText().isEmpty()){
            
            if (imagen != null) {
                try {
                    boolean validar3 = mb.validarUsuario("C:/MEIA/bitacora.txt", txtUsuario.getText());
                if ((mb.validarUsuario("C:/MEIA/usuarios.txt",txtUsuario.getText()) == true)&& validar3 ==true)  {
                    JOptionPane.showMessageDialog(null,"Nombre de Usuario existente, por favor escoja otro nombre de usuario");
                }else{
                    Date fecha = new Date(Integer.parseInt(txtAño.getText()), Integer.parseInt(txtMes.getText()), Integer.parseInt(txtDia.getText()));
                    MetodosUsuarios mu = new MetodosUsuarios();
                    String path = archivo.getAbsolutePath();
                    //Agregar usuario
                    Usuarios u;
                    if(numero==0)
                    {
                        u = new Usuarios(txtUsuario.getText(),txtNombre.getText(),txtApellido.getText(),txtContraseña.getText(),'1', fecha,txtCorreo.getText(), 
                    Integer.parseInt(txtTelefono.getText()),mu.CopiarImagen(path, txtUsuario.getText()),'0');
                        numero++;
                    }
                    else
                    {
                        u = new Usuarios(txtUsuario.getText(),txtNombre.getText(),txtApellido.getText(),txtContraseña.getText(),'0', fecha,txtCorreo.getText(), 
                    Integer.parseInt(txtTelefono.getText()),mu.CopiarImagen(path, txtUsuario.getText()),'0');
                    }
                    mb.Escribir(u.ConvertirATextoTamañoFijo(),"Error");
                    String ultimaLinea = mb.leerUltimaLinea("C:/MEIA/desc_bitacora.txt");
                    if (ultimaLinea.equals("")) 
                    {
                        Date date = new Date();
                        DescBitacora desBitacora = new DescBitacora(txtUsuario.getText(),date,txtUsuario.getText(),date,txtUsuario.getText(),numero,numero,0,5);
                        mb.LlenarArchivo2(desBitacora.ConvertirATextoTamañoFijo(), "ERROR");
                    }
                    else
                    {
                        String [] ArregloUltima = ultimaLinea.split("//");
                       // SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yy-MM-dd");
                       // Date date = formatoDelTexto.parse(mb.quitarCaracteres(ArregloUltima[2]));
                        Date date = new Date();
                       Date date2 = new Date();
                        DescBitacora desBitacora = new DescBitacora(txtUsuario.getText(),date,txtUsuario.getText(),date2,txtUsuario.getText(),Integer.valueOf(mb.quitarCaracteres(ArregloUltima[5]))+1,Integer.valueOf(mb.quitarCaracteres(ArregloUltima[6]))+1,Integer.valueOf(mb.quitarCaracteres(ArregloUltima[7])),Integer.valueOf(mb.quitarCaracteres(ArregloUltima[8])));
                        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/MEIA/desc_bitacora.txt"));
                        bw.write("");
                        bw.close();
                        mb.LlenarArchivo2(desBitacora.ConvertirATextoTamañoFijo(), "ERROR");
                    }
                    
                    
                    
                   
                    /*
                    DescBitacora db = new DescBitacora();
                    db.NombreSimbolico = txtUsuario.getText();
                    db.usuarioModificacion = txtUsuario.getText();
                    db.NumeroRegistros = numero;
                    numero++;
                    db.RegistrosActivos = numero;
                    Date date = new Date();
                    db.FechaModificacion = date;
                    String ultimaLinea = mb.leerUltimaLinea("C:/MEIA/desc_bitacora.txt");
                    if (!ultimaLinea.equals("")) {
                        String [] ArregloUltima = ultimaLinea.split("//");
                       // ultimaLinea = mb.quitarCaracteres(ArregloUltima[5]);
                        db.NumeroRegistros = Integer.parseInt(ArregloUltima[5])+1;
                        db.MaxReorganizacion = 5;
                        db.UsuarioCreacion = txtUsuario.getText();
                        mb.LlenarArchivo2(db.ConvertirATextoTamañoFijo(), "Error");
                    }else{
                        db.MaxReorganizacion = 5;
                        db.UsuarioCreacion = txtUsuario.getText();
                        db.NumeroRegistros = 1;
                        mb.LlenarArchivo2(db.ConvertirATextoTamañoFijo(), "Error");
                    }
                    */
                     VentanaLogin vl = new VentanaLogin();
                     vl.setVisible(true);
                     this.setVisible(false);
   
                }
            } catch (IOException ex) {
            Logger.getLogger(VentanaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione foto de perfil");
            }
            
        }
        
        
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void btnSeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarImagenActionPerformed
        //Busca la imagen y la muestra
        if(seleccionar.showDialog(null, null) == JFileChooser.APPROVE_OPTION){
            archivo = seleccionar.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("jpg"));
                imagen = AbrirArchivo(archivo);
                ImageIcon iconoimagen = new ImageIcon(imagen);
                Icon icono = new ImageIcon(iconoimagen.getImage().getScaledInstance(lblMostrar.getWidth(), lblMostrar.getHeight(), iconoimagen.getImageLoadStatus()));
                lblMostrar.setIcon(icono);
            }else{
                JOptionPane.showMessageDialog(null,"Archivo no compatible");
            }
        }
    }//GEN-LAST:event_btnSeleccionarImagenActionPerformed

    
    public byte[] AbrirArchivo (File archivo){
        byte[] imagen = new byte[1024*100];
        try{
            entrada = new FileInputStream(archivo);
            entrada.read(imagen);
        }catch(Exception e){
            
        }
        return imagen;
    }
    
    public String GuardarArchivo(File archivo, byte[] imagen){
        String mensaje = null;
        try{
            salida = new FileOutputStream(archivo);
            salida.write(imagen);
            mensaje = "Archivo guardado";
        }catch (Exception e){
            
        }
        return mensaje;
    }
    
    
    
    public static void main(String args[]) {
        
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnSeleccionarImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblMostrar;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtAño;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
