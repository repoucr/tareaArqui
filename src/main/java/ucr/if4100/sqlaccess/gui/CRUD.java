/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.if4100.sqlaccess.gui;

import java.util.List;
import ucr.if4100.sqlaccess.business.concrete.AccountBiz;
import ucr.if4100.sqlaccess.business.concrete.ClientBiz;
import ucr.if4100.sqlaccess.common.bean.client;
import ucr.if4100.sqlaccess.data.AccountData;
import ucr.if4100.sqlaccess.data.ClientData;

/**
 *
 * @author Wilmata
 */
public class CRUD extends javax.swing.JFrame {

    /**
     * Creates new form CRUD
     */
    public CRUD() {
        initComponents();
        fillClientsTable();
       
    }
    ClientBiz clientData = new ClientBiz();
    AccountBiz accountData = new AccountBiz();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void fillClientsTable() {
        List<client> client = clientData.getClients();
        if (client.size() > 0) {
            String[][] arrayTableClient = new String[client.size()][5];
            for (int i = 0; i < client.size(); i++) {
                arrayTableClient[i][0] = client.get(i).getId();
                arrayTableClient[i][1] = client.get(i).getFirstName();
                arrayTableClient[i][2] = client.get(i).getLastName();
                arrayTableClient[i][3] = client.get(i).getAddress();
                arrayTableClient[i][4] = client.get(i).getBirthdate();

                clientTable.setModel(new javax.swing.table.DefaultTableModel(arrayTableClient, new String[]{"ID", "First Name", "Last Name", "Address", "Birthday"}));
            }
        } else {
            String[][] arrayTableClient = new String[client.size()][5];
            clientTable.setModel(new javax.swing.table.DefaultTableModel(arrayTableClient, new String[]{"ID", "First Name", "Last Name", "Address", "Birthday"}));
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane13 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        insertAccount = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        insertInterno = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        monedaComboBox = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        borrarButton = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        clientTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        insertCedulaTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        insertNombreTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        insertApellidosTextField = new javax.swing.JTextField();
        insertDireccionTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        insertFechaTextField = new javax.swing.JTextField();
        insertClientButton = new javax.swing.JButton();
        updateClientButton = new javax.swing.JButton();

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane13.setViewportView(jTable5);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane14.setViewportView(jTable6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(198, 239, 255));

        jPanel8.setBackground(new java.awt.Color(229, 240, 246));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("Número de cuenta");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 118, -1, -1));
        jPanel8.add(insertAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 138, 110, -1));

        jLabel12.setText("Número interno");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 164, -1, -1));
        jPanel8.add(insertInterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 184, 110, -1));

        jLabel13.setText("Tipo de moneda");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 215, -1, -1));

        monedaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Colones", "Dólares", "Euros" }));
        jPanel8.add(monedaComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 235, 110, -1));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel8.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 11, 17, 389));

        jButton5.setText("Agregar");
        jPanel8.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        jButton7.setText("Borrar");
        jPanel8.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(jTable1);

        jPanel8.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 510, 100));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(jTable2);

        jPanel8.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 510, 100));

        jButton1.setText("jButton1");
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, -1, -1));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 414, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cuentas", jPanel3);

        jPanel4.setBackground(new java.awt.Color(229, 240, 246));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setText("Retiro");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 142, -1));

        jButton10.setText("Buscar");
        jPanel4.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        jLabel20.setText("Monto");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 10));
        jPanel4.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 140, -1));

        jButton11.setText("Retiro");
        jPanel4.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 70, -1));

        jLabel21.setText("Cliente");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 60, -1));

        jLabel22.setText("jLabel22");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 150, 20));

        jLabel23.setText("Fondos");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel24.setText("jLabel24");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 150, 20));
        jPanel4.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, 90));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 60, 370));

        jLabel25.setText("Depósito");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 142, -1));

        jButton12.setText("Buscar");
        jPanel4.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

        jLabel26.setText("Cliente");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 60, -1));

        jLabel27.setText("jLabel22");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 150, 20));

        jLabel28.setText("Fondos");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));

        jLabel29.setText("jLabel24");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 150, 20));

        jLabel30.setText("Monto");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, 10));
        jPanel4.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 140, -1));

        jButton13.setText("Depósito");
        jPanel4.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, -1, -1));

        jTabbedPane1.addTab("Depósito/Retiro", jPanel4);

        jPanel5.setBackground(new java.awt.Color(229, 240, 246));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setText("Monto");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));
        jPanel5.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 370, 160, -1));

        jButton14.setText("Aceptar");
        jPanel5.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, -1, -1));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(jTable4);

        jPanel5.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 630, 95));

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane15.setViewportView(jTable7);

        jPanel5.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 630, 95));

        jTabbedPane1.addTab("Transferencias", jPanel5);

        jPanel6.setBackground(new java.awt.Color(229, 240, 246));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setText("Cuentas");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, -1, -1));

        jLabel33.setText("Movimientos");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 23, -1, -1));

        jLabel34.setText("Cliente");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 213, -1, -1));

        jLabel35.setText("jLabel35");
        jPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 233, 177, -1));

        jLabel36.setText("Saldo");
        jPanel6.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 253, -1, -1));

        jLabel37.setText("jLabel37");
        jPanel6.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 273, 177, -1));

        jButton15.setText("Reporte");
        jPanel6.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 347, -1, -1));

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane16.setViewportView(jTable8);

        jPanel6.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 290, 95));

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane17.setViewportView(jTable9);

        jPanel6.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 330, 100));

        jTabbedPane1.addTab("Estado de cuenta", jPanel6);

        jPanel2.setBackground(new java.awt.Color(229, 240, 246));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(229, 240, 246));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 0, -1, 449));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 11, 17, 398));

        jButton4.setText("Borrar");
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(935, 350, -1, -1));

        borrarButton.setText("Borrar");
        borrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarButtonActionPerformed(evt);
            }
        });
        jPanel2.add(borrarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, -1, -1));

        clientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        clientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientTableMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(clientTable);

        jPanel2.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 450, 270));

        jLabel1.setText("Cédula");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        insertCedulaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertCedulaTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(insertCedulaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 137, -1));

        jLabel2.setText("Nombre");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        insertNombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertNombreTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(insertNombreTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 137, -1));

        jLabel3.setText("Apellidos");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        jPanel2.add(insertApellidosTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 137, -1));
        jPanel2.add(insertDireccionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 137, -1));

        jLabel4.setText("Dirección");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel5.setText("Fecha de nacimiento");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));
        jPanel2.add(insertFechaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 137, -1));

        insertClientButton.setText("Agregar");
        insertClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertClientButtonActionPerformed(evt);
            }
        });
        jPanel2.add(insertClientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        updateClientButton.setText("Actualizar");
        updateClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateClientButtonActionPerformed(evt);
            }
        });
        jPanel2.add(updateClientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));

        jTabbedPane1.addTab("Usuarios", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertCedulaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertCedulaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertCedulaTextFieldActionPerformed

    private void insertNombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertNombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertNombreTextFieldActionPerformed

    private void insertClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertClientButtonActionPerformed
    clientData.insertClient(insertCedulaTextField.getText().toString(), insertNombreTextField.getText().toString(), insertApellidosTextField.getText().toString(), insertDireccionTextField.getText().toString(), insertFechaTextField.getText().toString());
    }//GEN-LAST:event_insertClientButtonActionPerformed

    private void updateClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateClientButtonActionPerformed
      clientData.updateClient(insertCedulaTextField.getText().toString(), insertNombreTextField.getText().toString(), insertApellidosTextField.getText().toString(), insertDireccionTextField.getText().toString(), insertFechaTextField.getText().toString());
    }//GEN-LAST:event_updateClientButtonActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void borrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarButtonActionPerformed
        clientData.deleteClient(insertCedulaTextField.getText().toString());
    }//GEN-LAST:event_borrarButtonActionPerformed

    private void clientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientTableMouseClicked
       insertCedulaTextField.setText(clientTable.getValueAt(clientTable.getSelectedRow(), 0).toString().toString());
       insertNombreTextField.setText(clientTable.getValueAt(clientTable.getSelectedRow(), 1).toString().toString());
       insertApellidosTextField.setText(clientTable.getValueAt(clientTable.getSelectedRow(), 2).toString().toString());
       insertDireccionTextField.setText(clientTable.getValueAt(clientTable.getSelectedRow(), 3).toString().toString()); 
       insertFechaTextField.setText(clientTable.getValueAt(clientTable.getSelectedRow(), 4).toString().toString());
    }//GEN-LAST:event_clientTableMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarButton;
    private javax.swing.JTable clientTable;
    private javax.swing.JTextField insertAccount;
    private javax.swing.JTextField insertApellidosTextField;
    private javax.swing.JTextField insertCedulaTextField;
    private javax.swing.JButton insertClientButton;
    private javax.swing.JTextField insertDireccionTextField;
    private javax.swing.JTextField insertFechaTextField;
    private javax.swing.JTextField insertInterno;
    private javax.swing.JTextField insertNombreTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JComboBox<String> monedaComboBox;
    private javax.swing.JButton updateClientButton;
    // End of variables declaration//GEN-END:variables
}
