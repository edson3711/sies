/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Fornecedor;

import ConectaBanco.ConexaoBD;
import ModeloBeans.BeansFornecedor;
import ModeloBeans.ModeloTabela;
import ModeloDao.DaoFornecedor;
import Principal.Menu;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author edson
 */
public class ListaFornecedor extends javax.swing.JFrame {

    //chama telas
    AddFornecedor add = new AddFornecedor(this, rootPaneCheckingEnabled);
    EditFornecedor edit = new EditFornecedor(this, rootPaneCheckingEnabled);
    // chama benas e dao
    BeansFornecedor BEANS = new BeansFornecedor();
    DaoFornecedor DAO = new DaoFornecedor();
    // chama conexão
    ConexaoBD conex = new ConexaoBD();
    // uso interno
    String resposta = "",resposta_inativos = "", Status;
    int codigo;

    /**
     * Creates new form ListaUsuario
     */
    public ListaFornecedor() {
        initComponents();
//        PreencheTabela();

//        jMenuItem4.setVisible(false);
    }

    public void ValidaPermissao() {
        String Permissao = Menu.jLabelPermissao.getText();
        jCheckBoxMenuItem2.setEnabled(false);
        jCheckBoxMenuItem3.setEnabled(false);
        if (Permissao.equals("0")) {
            System.out.println("ValidaPermissao() Permissao =" + Permissao);
            jCheckBoxMenuItem2.setEnabled(true);
            jCheckBoxMenuItem3.setEnabled(true);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Lista = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Lista_inativos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fornecedores");
        setResizable(false);

        jTable_Lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_Lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Lista);

        jTabbedPane1.addTab("Ativos", jScrollPane1);

        jTable_Lista_inativos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_Lista_inativos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Lista_inativosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Lista_inativos);

        jTabbedPane1.addTab("Inativos", jScrollPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, 0));
        jMenuItem1.setText("Novo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator2);

        jCheckBoxMenuItem2.setText("Ativa Editar");
        jCheckBoxMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem2MousePressed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem2);

        jCheckBoxMenuItem3.setText("Ativa Excluir");
        jCheckBoxMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCheckBoxMenuItem3MousePressed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem3);
        jMenu1.add(jSeparator3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem4.setText("Atualizar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, 0));
        jMenuItem2.setText("Buscar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator4);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem3.setText("Sair");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        add.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        resposta = JOptionPane.showInputDialog(rootPane, "Digite sua busca ! ", "", 1);
        System.out.println("resp =" + resposta);
        if (resposta == null) {
            resposta = "";
        } else {
        }
        PreencheTabela();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jTable_ListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ListaMouseClicked
        int op = 3;
        if (evt.getClickCount() == 2) {

            if (jCheckBoxMenuItem2.isSelected()) {

                Object[] options = {"Editar", "Cancelar"};
                op = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Opção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                System.out.println("resutado=" + op);
            } else if (jCheckBoxMenuItem3.isSelected()) {
                Object[] options = {"Excluir", "Cancelar"};
                op = JOptionPane.showOptionDialog(null, "Deseja realmente realizar esta operação?", "Excluir item", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                System.out.println("resutado=" + op);
            } else {
                Object[] options = {"Ativar/Desativar", "Cancelar"};
                op = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Opção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                System.out.println("resutado=" + op);
            }

            codigo = (int) jTable_Lista.getValueAt(jTable_Lista.getSelectedRow(), 0);
            Status = "" + jTable_Lista.getValueAt(jTable_Lista.getSelectedRow(), 1);

            if (jCheckBoxMenuItem3.isSelected()) {
                System.err.println("APAGADO");
                if (op == 0) {
                    ExcluirItem();
                }
                PreencheTabela();
            } else if (jCheckBoxMenuItem2.isSelected()) {
                if (op == 0) {
                    edit.RecebeId(codigo);
                    edit.Chama();
                    edit.setVisible(true);
                }
            } else {
                if (op == 0) {
                    UpdateStatus();
                }
                PreencheTabela();
            }
        }
        if (evt.getClickCount() == 1) {

            try {

                codigo = (int) jTable_Lista.getValueAt(jTable_Lista.getSelectedRow(), 0);
                Status = "" + jTable_Lista.getValueAt(jTable_Lista.getSelectedRow(), 2);
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_jTable_ListaMouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        resposta = "";
        PreencheTabela();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jCheckBoxMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2MouseClicked

    }//GEN-LAST:event_jCheckBoxMenuItem2MouseClicked

    private void jCheckBoxMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem3MouseClicked

    }//GEN-LAST:event_jCheckBoxMenuItem3MouseClicked

    private void jCheckBoxMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem3MousePressed
        jCheckBoxMenuItem2.setSelected(false);
    }//GEN-LAST:event_jCheckBoxMenuItem3MousePressed

    private void jCheckBoxMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2MousePressed
        jCheckBoxMenuItem3.setSelected(false);
    }//GEN-LAST:event_jCheckBoxMenuItem2MousePressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.dispose();
//       JOptionPane.showMessageDialog(rootPane, "sair");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jTable_Lista_inativosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Lista_inativosMouseClicked
        int op = 3;
        if (evt.getClickCount() == 2) {

            if (jCheckBoxMenuItem2.isSelected()) {

                Object[] options = {"Editar", "Cancelar"};
                op = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Opção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                System.out.println("resutado=" + op);
            } else if (jCheckBoxMenuItem3.isSelected()) {
                Object[] options = {"Excluir", "Cancelar"};
                op = JOptionPane.showOptionDialog(null, "Deseja realmente realizar esta operação?", "Excluir item", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                System.out.println("resutado=" + op);
            } else {
                Object[] options = {"Ativar/Desativar", "Cancelar"};
                op = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Opção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                System.out.println("resutado=" + op);
            }

            codigo = (int) jTable_Lista_inativos.getValueAt(jTable_Lista_inativos.getSelectedRow(), 0);
            Status = "" + jTable_Lista_inativos.getValueAt(jTable_Lista_inativos.getSelectedRow(), 1);

            if (jCheckBoxMenuItem3.isSelected()) {
                System.err.println("APAGADO");
                if (op == 0) {
                    ExcluirItem();
                }
                PreencheTabela();
            } else if (jCheckBoxMenuItem2.isSelected()) {
                if (op == 0) {
                    edit.RecebeId(codigo);
                    edit.Chama();
                    edit.setVisible(true);
                }
            } else {
                if (op == 0) {
                    UpdateStatus();
                }
                PreencheTabela();
            }
        }
        if (evt.getClickCount() == 1) {

            try {

                codigo = (int) jTable_Lista_inativos.getValueAt(jTable_Lista_inativos.getSelectedRow(), 0);
                Status = "" + jTable_Lista_inativos.getValueAt(jTable_Lista_inativos.getSelectedRow(), 2);
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_jTable_Lista_inativosMouseClicked

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
            java.util.logging.Logger.getLogger(ListaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaFornecedor().setVisible(true);
            }
        });
    }

    public void PreencheTabela() {
        resposta_inativos = resposta;
        PreencheTabela_Inativos();
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Codigo ", "Status", "Nome", "Descrição", "telefone", "Observação", "Registro"};
        conex.conexao();
        conex.executaSql2("SELECT *  FROM tbl_fornecedor inner join public.tbl_usuario on id_usuario=fornecedor_usuario_id where (coalesce((fornecedor_nome)) ||' '||coalesce((fornecedor_descricao))ilike '%" + resposta + "%') and fornecedor_status=1    order by fornecedor_id asc ");
        try {
            conex.rs.first();
            do {

                String status = conex.rs.getString("fornecedor_status");

                if (status.equals("0")) {
                    status = "Inativo";
                } else if (status.equals("1")) {
                    status = "Ativo";
                } else if (status.equals("2")) {
                    status = "Alterado";
                } else if (status.equals("3")) {
                    status = "Excluido";

                } else {

                }
                String MenuMinhaData = conex.rs.getString("fornecedor_registro");
                String MenuMeuUsuario = conex.rs.getString("nome_usuario");
                dados.add(new Object[]{conex.rs.getInt("fornecedor_id"), status,
                    conex.rs.getString("fornecedor_nome"), conex.rs.getString("fornecedor_descricao"), conex.rs.getString("fornecedor_telefone"),
                    conex.rs.getString("fornecedor_observacao"), MenuMeuUsuario + " - " + MenuMinhaData});

            } while (conex.rs.next());
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(rootPane, ex);
//            Logger.getLogger(UsuarioJIF.class.getName()).log(Level.SEVERE, null, ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);

        jTable_Lista.setModel(modelo);
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        jTable_Lista.setRowSorter(sorter);
        jTable_Lista.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTable_Lista.getColumnModel().getColumn(0).setResizable(true);
        jTable_Lista.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTable_Lista.getColumnModel().getColumn(1).setResizable(true);
        jTable_Lista.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTable_Lista.getColumnModel().getColumn(2).setResizable(true);
        jTable_Lista.getColumnModel().getColumn(3).setPreferredWidth(180);
        jTable_Lista.getColumnModel().getColumn(3).setResizable(true);
        jTable_Lista.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTable_Lista.getColumnModel().getColumn(4).setResizable(true);
        jTable_Lista.getColumnModel().getColumn(5).setPreferredWidth(180);
        jTable_Lista.getColumnModel().getColumn(5).setResizable(true);
        jTable_Lista.getColumnModel().getColumn(6).setPreferredWidth(180);
        jTable_Lista.getColumnModel().getColumn(6).setResizable(true);

//  jTable_Lista.getColumnModel().getColumn(5).isCellVisible(false);
        jTable_Lista.getTableHeader().setReorderingAllowed(false);
        jTable_Lista.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable_Lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conex.desconecta();
        resposta = "";
    }

    public void PreencheTabela_Inativos() {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Codigo inativo", "Status", "Nome", "Descrição", "telefone", "Observação", "Registro"};
        conex.conexao();
        conex.executaSql2("SELECT *  FROM tbl_fornecedor inner join public.tbl_usuario on id_usuario=fornecedor_usuario_id where (coalesce((fornecedor_nome)) ||' '||coalesce((fornecedor_descricao))ilike '%" + resposta + "%') and fornecedor_status=0   order by fornecedor_id asc ");
        try {
            conex.rs.first();
            do {

                String status = conex.rs.getString("fornecedor_status");

                if (status.equals("0")) {
                    status = "Inativo";
                } else if (status.equals("1")) {
                    status = "Ativo";
                } else if (status.equals("2")) {
                    status = "Alterado";
                } else if (status.equals("3")) {
                    status = "Excluido";

                } else {

                }
                String MenuMinhaData = conex.rs.getString("fornecedor_registro");
                String MenuMeuUsuario = conex.rs.getString("nome_usuario");
                dados.add(new Object[]{conex.rs.getInt("fornecedor_id"), status,
                    conex.rs.getString("fornecedor_nome"), conex.rs.getString("fornecedor_descricao"), conex.rs.getString("fornecedor_telefone"),
                    conex.rs.getString("fornecedor_observacao"), MenuMeuUsuario + " - " + MenuMinhaData});

            } while (conex.rs.next());
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(rootPane, ex);
//            Logger.getLogger(UsuarioJIF.class.getName()).log(Level.SEVERE, null, ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);

        jTable_Lista_inativos.setModel(modelo);
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
        jTable_Lista_inativos.setRowSorter(sorter);
        jTable_Lista_inativos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTable_Lista_inativos.getColumnModel().getColumn(0).setResizable(true);
        jTable_Lista_inativos.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTable_Lista_inativos.getColumnModel().getColumn(1).setResizable(true);
        jTable_Lista_inativos.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTable_Lista_inativos.getColumnModel().getColumn(2).setResizable(true);
        jTable_Lista_inativos.getColumnModel().getColumn(3).setPreferredWidth(180);
        jTable_Lista_inativos.getColumnModel().getColumn(3).setResizable(true);
        jTable_Lista_inativos.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTable_Lista_inativos.getColumnModel().getColumn(4).setResizable(true);
        jTable_Lista_inativos.getColumnModel().getColumn(5).setPreferredWidth(180);
        jTable_Lista_inativos.getColumnModel().getColumn(5).setResizable(true);
        jTable_Lista_inativos.getColumnModel().getColumn(6).setPreferredWidth(180);
        jTable_Lista_inativos.getColumnModel().getColumn(6).setResizable(true);

//  jTable_Lista_inativos.getColumnModel().getColumn(5).isCellVisible(false);
        jTable_Lista_inativos.getTableHeader().setReorderingAllowed(false);
        jTable_Lista_inativos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable_Lista_inativos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conex.desconecta();
        resposta_inativos  = "";
    }

    public void UpdateStatus() {

        BEANS.setFornecedor_id(codigo);
        if (Status.equals("Ativo")) {
            BEANS.setFornecedor_status(0);
        } else if (Status.equals("Inativo")) {
            BEANS.setFornecedor_status(1);
        } else {
            BEANS.setFornecedor_status(1);
        }
        DAO.UpdateStatus(BEANS);

    }

    public void ExcluirItem() {
        // verifica para excluir
        String PedidoExcluir = "";
        // senha para excluir
        String SenhaParaExcluir;
        try {
            SenhaParaExcluir = Menu.jLabel_Password.getText();
        } catch (Exception e) {
            SenhaParaExcluir = "1";
        }

        PedidoExcluir = JOptionPane.showInputDialog(rootPane, "Digite senha para excluir ! ", "", 1);
        if (PedidoExcluir == null) {
            PedidoExcluir = "";
        } else {
            if (PedidoExcluir.equals(SenhaParaExcluir)) {
                System.out.println("tudo certo para apagar");
                BEANS.setFornecedor_id(codigo);
                DAO.ExcluirItem(BEANS);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Senha incorreta .");
                System.out.println("erro para apagar");
            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    public static javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_Lista;
    private javax.swing.JTable jTable_Lista_inativos;
    // End of variables declaration//GEN-END:variables
}
