package proyecto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyecto_meia.BDD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chris
 */
public class VentanaVistaUsuarios extends javax.swing.JFrame {

    String AsociadosCrear = "";
    String UsuariosCrear = "";
    int contMiembro = 0;
    int contAsociados = 0;
    MetodosBitacora mb = new MetodosBitacora();
    
    public VentanaVistaUsuarios() {
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

        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        lblMostrar = new javax.swing.JLabel();
        btnGuardarCambios = new javax.swing.JButton();
        btnEstado = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnCrearLista5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNombreLista = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNombreB = new javax.swing.JTextField();
        Asociado = new javax.swing.JLabel();
        txtAsociadoB = new javax.swing.JTextField();
        btnAgregarAsociadoB = new javax.swing.JButton();
        btnEliminarAsociadoB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblMostrarLista = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/LOGO_MEIA2 (2).png"))); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblUsuario.setText("Nombre de Usuario");

        jLabel3.setText("Contraseña:");

        jLabel4.setText("Correo Electronico:");

        jLabel5.setText("Fecha de nacimiento:");

        jLabel6.setText("/");

        jLabel7.setText("/");

        jLabel8.setText("Telefono");

        jLabel9.setText("Foto de perfil:");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setActionCommand("btnSeleccionar");

        lblMostrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnGuardarCambios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardarCambios.setText("Guardar Cambios");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        btnEstado.setText("Darse de baja");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Listas de Amigos"));

        btnCrearLista5.setText("Crear Lista");
        btnCrearLista5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearLista5ActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Nombre:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Buscar Lista");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Crear Lista");

        jLabel15.setText("Nombre:");

        Asociado.setText("Asociado:");

        btnAgregarAsociadoB.setText("Agregar");
        btnAgregarAsociadoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAsociadoBActionPerformed(evt);
            }
        });

        btnEliminarAsociadoB.setText("Eliminar");
        btnEliminarAsociadoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAsociadoBActionPerformed(evt);
            }
        });

        jLabel2.setText("Descripcion:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Lista Activa:");

        lblMostrarLista.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMostrarLista.setText("-----");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMostrarLista)
                        .addGap(148, 148, 148))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(Asociado)
                                .addGap(18, 18, 18)
                                .addComponent(txtAsociadoB, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarAsociadoB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarAsociadoB))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(24, 24, 24)
                                .addComponent(txtNombreB, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 35, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel2))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(17, 17, 17)))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreLista, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnCrearLista5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnCrearLista5)
                .addGap(43, 43, 43)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMostrarLista)
                    .addComponent(jLabel11))
                .addGap(47, 47, 47)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNombreB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAsociadoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Asociado)
                    .addComponent(btnAgregarAsociadoB)
                    .addComponent(btnEliminarAsociadoB))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        btnEnviar.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnEnviar.setText("Enviar Mensaje");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton2.setText("Ver Mensajes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel8)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSeleccionar)
                            .addComponent(lblMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(30, 30, 30)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lblUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSeleccionar)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGap(15, 15, 15)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addGap(17, 17, 17)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)
                                            .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addComponent(btnEstado)
                                .addGap(34, 34, 34))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardarCambios, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEnviar)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnCrearLista5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearLista5ActionPerformed
        MetodosListas ml = new MetodosListas();
        MetodosDescBitacora mdb = new MetodosDescBitacora();

        if(txtNombreLista.getText() == ""){
            JOptionPane.showMessageDialog(null,"Primero Ingrese el nombre de la lista");
        }else{
            try {

                if(ml.listaExiste("C:/MEIA/Bitacora_Listas.txt", lblUsuario.getText(), txtNombreLista.getText()) ||
                    ml.listaExiste("C:/MEIA/Listas.txt", lblUsuario.getText(), txtNombreLista.getText())  ){
                    
                    if (ml.EstaActivaBitacoraLista(txtNombreLista.getText(), lblUsuario.getText()) || ml.EstaActivaListaMaster(txtNombreLista.getText(), lblUsuario.getText())) {
                        JOptionPane.showMessageDialog(null,"EL nombre escogido para la lista ya existe");
                    }else{
                        Listas l = new Listas(txtNombreLista.getText(), lblUsuario.getText(),txtDescripcion.getText(), contMiembro, 1);
                    String linea = l.ConvertirATextoTamañoFijo();
                        if(mdb.EstaVacio()){
                        
                        String desc = mdb.OrganizacionDeDatos(lblUsuario.getText(), 1,1,0, 5);
                        mdb.LlenarDescBitacora(desc);
                        if(ml.bitacoraLLena(mdb.obtenerTopeBitacora())){
                            ml.LlenarListasMaster();
                            ml.LlenarBitacora(linea, "Error");
                            String desc2 = mdb.OrganizacionDeDatos(lblUsuario.getText(), 1,1,0, 5);
                            mdb.LlenarDescBitacora(desc2);
                            JOptionPane.showMessageDialog(null,"Lista creada exitosamente");
                        }else{
                            ml.LlenarBitacora(linea, "Error");
                            String desc2 = mdb.OrganizacionDeDatos(lblUsuario.getText(), 1,1,0, 5);
                            mdb.LlenarDescBitacora(desc2);
                            JOptionPane.showMessageDialog(null,"Lista creada exitosamente");
                        }

                        }else{
                            if(ml.bitacoraLLena(mdb.obtenerTopeBitacora())){
                                ml.LlenarListasMaster();
                                ml.LlenarBitacora(linea, "Error");
                                String desc2 = mdb.OrganizacionDeDatos(lblUsuario.getText(), mdb.numeroRegistros(),mdb.registrosActivos(),mdb.registrosInactivos() , mdb.obtenerTopeBitacora());
                                mdb.LlenarDescBitacora(desc2);
                                JOptionPane.showMessageDialog(null,"Lista creada exitosamente");
                            }else{
                                ml.LlenarBitacora(linea, "Error");
                                String desc2 = mdb.OrganizacionDeDatos(lblUsuario.getText(), mdb.numeroRegistros(),mdb.registrosActivos(),mdb.registrosInactivos() , mdb.obtenerTopeBitacora());
                                mdb.LlenarDescBitacora(desc2);
                                JOptionPane.showMessageDialog(null,"Lista creada exitosamente");
                            }
                        } 
                    }
                    

                }else{
                    
                    Listas l = new Listas(txtNombreLista.getText(), lblUsuario.getText(),txtDescripcion.getText(), contMiembro, 1);
                    String linea = l.ConvertirATextoTamañoFijo();
                        if(mdb.EstaVacio()){
                        
                        String desc = mdb.OrganizacionDeDatos(lblUsuario.getText(), 1,1,0, 5);
                        mdb.LlenarDescBitacora(desc);
                        if(ml.bitacoraLLena(mdb.obtenerTopeBitacora())){
                            ml.LlenarListasMaster();
                            ml.LlenarBitacora(linea, "Error");
                            String desc2 = mdb.OrganizacionDeDatos(lblUsuario.getText(), 1,1,0, 5);
                            mdb.LlenarDescBitacora(desc2);
                            JOptionPane.showMessageDialog(null,"Lista creada exitosamente");
                        }else{
                            ml.LlenarBitacora(linea, "Error");
                            String desc2 = mdb.OrganizacionDeDatos(lblUsuario.getText(), 1,1,0, 5);
                            mdb.LlenarDescBitacora(desc2);
                            JOptionPane.showMessageDialog(null,"Lista creada exitosamente");
                        }

                        }else{
                            if(ml.bitacoraLLena(mdb.obtenerTopeBitacora())){
                                ml.LlenarListasMaster();
                                ml.LlenarBitacora(linea, "Error");
                                String desc2 = mdb.OrganizacionDeDatos(lblUsuario.getText(), mdb.numeroRegistros(),mdb.registrosActivos(),mdb.registrosInactivos() , mdb.obtenerTopeBitacora());
                                mdb.LlenarDescBitacora(desc2);
                                JOptionPane.showMessageDialog(null,"Lista creada exitosamente");
                            }else{
                                ml.LlenarBitacora(linea, "Error");
                                String desc2 = mdb.OrganizacionDeDatos(lblUsuario.getText(), mdb.numeroRegistros(),mdb.registrosActivos(),mdb.registrosInactivos() , mdb.obtenerTopeBitacora());
                                mdb.LlenarDescBitacora(desc2);
                                JOptionPane.showMessageDialog(null,"Lista creada exitosamente");
                            }
                        }    
                }

            } catch (IOException ex) {
                Logger.getLogger(VentanaVistaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnCrearLista5ActionPerformed
    public String leerUltimaLinea(String strPath) throws FileNotFoundException, IOException
    {
        String lastLine= "";
        File Archivo = new File(strPath);
        
        BufferedReader br = new BufferedReader(new FileReader(Archivo)); 
            String last = br.readLine(); 
            while (last != null) 
            { 
            lastLine = last; 
            last = br.readLine(); 
            } 
        br.close();
        return lastLine;
    }
    
    private void btnAgregarAsociadoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAsociadoBActionPerformed
       
        MetodosUsuarios mu = new MetodosUsuarios();
        MetodosListas ml = new MetodosListas();
        DescListaUsuarios dlu = new DescListaUsuarios();
        MetodosBitacora mb = new MetodosBitacora();
        try {
            String [] usuarioActual = mb.login(txtAsociadoB.getText());
            if(usuarioActual==null)
            {
                JOptionPane.showMessageDialog(null,"Usuario no se encuentra");
            }
            else
            {
                if(!ml.UsuarioExisteListaUsuarios(lblMostrarLista.getText(),lblUsuario.getText(), txtAsociadoB.getText() )){
                try {
                    String desc = "";
                    if(ml.ObtenerDescriptionBitacora(lblMostrarLista.getText(), lblUsuario.getText()).equals("0")){
                        if(ml.ObtenerDescriptionMaster(lblMostrarLista.getText(), lblUsuario.getText()).equals("0")){
                            
                        }else{
                            desc = ml.ObtenerDescriptionMaster(lblMostrarLista.getText(), lblUsuario.getText());
                        }
                    }else{
                        desc = ml.ObtenerDescriptionBitacora(lblMostrarLista.getText(), lblUsuario.getText());
                    }
                    
                    Listas_Usuario lu = new Listas_Usuario(lblMostrarLista.getText(),lblUsuario.getText(),txtAsociadoB.getText(),desc,1);
                    lu.ConvertirATextoTamañoFijo();
                    String cadena = lu.ConvertirATextoTamañoFijo();
                    lu.LlenarListaUsuario(cadena);
                    String cadena2 = dlu.OrganizacionDeDatos(txtAsociadoB.getText(), dlu.numeroRegistros(),dlu.registrosActivos(), dlu.registrosInactivos());
                    dlu.LlenarDescListaUsuario(cadena2);
                    //Agrego nuevo dato a la lista indizada 
                     MetodosLista2 misMetodos = new MetodosLista2();
                    IndiceListaUsuario nuevo = new IndiceListaUsuario(dlu.numeroRegistros(), "1."+String.valueOf(dlu.numeroRegistros()),lblMostrarLista.getText(), lblUsuario.getText(), txtAsociadoB.getText(), -1, "1");
                    String[] nuevo2 = nuevo.ToString().split("//");
                    
                    DescIndiceLista miDesc = new DescIndiceLista();
                    File Archivo = new File("C:/MEIA/Indice_Listas_Usuario.txt"); //
                    int numero =(int) Archivo.length();
                    if (numero==0) {
                        misMetodos.LlenarArchivo("C:/MEIA/Indice_Listas_Usuario.txt", nuevo.ToString(), "ERROR");
                        
                        
                        misMetodos.LlenarArchivo("C:/MEIA/Desc_Indice_Lista_Usuarios.txt", miDesc.OrganizacionDeDatos( 1,1,1,0), "ERROR");
                    }
                    else
                    {
                        
                        misMetodos.agregar(nuevo2,miDesc.ObtenerRaiz());
                        String linea = miDesc.OrganizacionDeDatos( dlu.numeroRegistros(),miDesc.ObtenerRaiz(),dlu.numeroRegistros(),0);
                        misMetodos.vaciarArchivo6();
                        misMetodos.LlenarArchivo("C:/MEIA/Desc_Indice_Lista_Usuarios.txt", linea, "ERROR");
                    }
                   
                   
                    
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(VentanaVistaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null,"El usuario ya existe dentro de la lista");
            }
            }
        } catch (IOException ex) {
            Logger.getLogger(VentanaVistaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_btnAgregarAsociadoBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MetodosListas ml = new MetodosListas();
        
        try {
            if(ml.BuscarListaBitacora(lblUsuario.getText(), txtNombreB.getText()).equals("La lista no existe")){
                lblMostrarLista.setText(ml.BuscarListaMaster(lblUsuario.getText(),txtNombreB.getText()));
            }else{
                lblMostrarLista.setText(ml.BuscarListaBitacora(lblUsuario.getText(), txtNombreB.getText()));
            }
        } catch (IOException ex) {
            Logger.getLogger(VentanaVistaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarAsociadoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAsociadoBActionPerformed
        // TODO add your handling code here:
        MetodosLista2 misMetodos = new MetodosLista2();
         DescIndiceLista miDesc = new DescIndiceLista();
         MetodosListas ml = new MetodosListas();
       
        try {
            misMetodos.eliminar(txtAsociadoB.getText(), String.valueOf(miDesc.ObtenerRaiz()));
        } catch (IOException ex) {
            Logger.getLogger(VentanaVistaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ml.DesactivarUsuarioListaUsuario(lblUsuario.getText(), txtAsociadoB.getText(), lblMostrarLista.getText());
            DescListaUsuarios dlu = new DescListaUsuarios();
            dlu.OrganizacionDeDatos(txtAsociadoB.getText(), dlu.numeroRegistros(), dlu.registrosActivos(), dlu.registrosInactivos());
        } catch (IOException ex) {
            Logger.getLogger(VentanaVistaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
    }//GEN-LAST:event_btnEliminarAsociadoBActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        VistaEnviarMensaje vem = new VistaEnviarMensaje();
        vem.setVisible(true);
        vem.lblUsuario.setText(lblUsuario.getText());
        this.setVisible(false);
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ventanaMensajes misMensajes = new ventanaMensajes();
        misMensajes.setVisible(true);
        misMensajes.usuarioLog=lblUsuario.getText();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaVistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVistaUsuarios().setVisible(true);
            }
        });
    }
    
    public String[] retornoInformacion(String path, String usuario) throws IOException
    {
        
        MetodosBitacora mb = new MetodosBitacora();
        String[] nuevo= mb.buscar(path, usuario);
        for(int i=0; i<nuevo.length;i++)
        {
            nuevo[i] = mb.quitarCaracteres(nuevo[i]);
        }
        return nuevo;
    }
    
    public void llenartxt(String path,String usuario) throws IOException
    {
        String nuevos[] = retornoInformacion(path,usuario);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Asociado;
    private javax.swing.JButton btnAgregarAsociadoB;
    private javax.swing.JButton btnCrearLista5;
    private javax.swing.JButton btnEliminarAsociadoB;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnEstado;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblMostrar;
    private javax.swing.JLabel lblMostrarLista;
    public javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtAsociadoB;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtNombreB;
    private javax.swing.JTextField txtNombreLista;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
