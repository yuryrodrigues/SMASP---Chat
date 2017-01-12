package view;

import javax.swing.SwingUtilities;
import java.awt.Dimension;

/**
 *
 * @author yury-antergos
 */
public class AlterarServidorGUI extends javax.swing.JPanel {

    private ClienteGUI clGUI;
    
    /**
     * Creates new form AlterarServidor
     */
    public AlterarServidorGUI(ClienteGUI clGUI) {
    	setPreferredSize(new Dimension(380, 226));
        this.clGUI = clGUI;
        
        initComponents();
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBounds(0, 65, 378, 157);
        add(jPanel1);
        jLabel2 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPorta = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        
                jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alterar servidor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 13))); // NOI18N
                jPanel1.setLayout(null);
                
                        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                        jLabel2.setText("Digite o endereço:");
                        jPanel1.add(jLabel2);
                        jLabel2.setBounds(17, 37, 116, 15);
                        
                                txtEndereco.setMargin(new java.awt.Insets(0, 3, 0, 0));
                                jPanel1.add(txtEndereco);
                                txtEndereco.setBounds(140, 30, 220, 30);
                                
                                        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                                        jLabel3.setText("Digite a porta:");
                                        jPanel1.add(jLabel3);
                                        jLabel3.setBounds(17, 77, 90, 15);
                                        
                                                txtPorta.setMargin(new java.awt.Insets(0, 3, 0, 0));
                                                jPanel1.add(txtPorta);
                                                txtPorta.setBounds(140, 70, 220, 30);
                                                
                                                        jButton2.setText("salvar");
                                                        jButton2.addActionListener(new java.awt.event.ActionListener() {
                                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                                jButton2ActionPerformed(evt);
                                                            }
                                                        });
                                                        jPanel1.add(jButton2);
                                                        jButton2.setBounds(140, 110, 220, 30);
                                                                
                                                                // se não tiver iniciado o chat ainda
                                                                // mostra o servidor atual
                                                                txtServidorAtual.setText(clGUI.getCliente().getHost()+":"+clGUI.getCliente().getPorta());     
                                                        jPanel1.getAccessibleContext().setAccessibleName("Alterar servidor");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBounds(0, 0, 378, 56);

        setLayout(null);

        jPanel2.setLayout(null);

        add(jPanel2);
        jLabel1 = new javax.swing.JLabel();
        jPanel2.add(jLabel1);
        jLabel1.setBounds(7, 19, 110, 21);
        
                jLabel1.setText("Servidor atual:");
                txtServidorAtual = new javax.swing.JTextField();
                jPanel2.add(txtServidorAtual);
                txtServidorAtual.setBounds(139, 15, 220, 30);
                
                        txtServidorAtual.setText("localhost:8080");
                        txtServidorAtual.setDisabledTextColor(new java.awt.Color(51, 153, 255));
                        txtServidorAtual.setEnabled(false);
                        txtServidorAtual.setMargin(new java.awt.Insets(0, 3, 0, 0));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(txtEndereco.getText().trim().isEmpty()){
            clGUI.mostrarCaixaDialogo("Digite o endereco do servidor!");
        }
        else{
            if(txtPorta.getText().trim().isEmpty()){
                clGUI.mostrarCaixaDialogo("Digite a porta do servidor!");
            }
            else{
                try{
                    // converte para número
                    int numPorta = Integer.parseInt(txtPorta.getText().trim());

                    // verifica se está dentro da faixa permitida
                    // abaixo de 1024 são reservadas do sistema
                    // 65535 é o limite máximo
                    if(numPorta > 1024 && numPorta <= 65535){
                        // altera a porta de coneção com o servidor
                        clGUI.getCliente().setPorta(numPorta);
                        clGUI.getCliente().setHost(txtEndereco.getText().trim());

                        clGUI.mostrarCaixaDialogo("Servidor alterado. \nDesconecte e conecte novamente no servidor.\n");

                        // fecha a janela pai
                        SwingUtilities.windowForComponent(this).dispose();
                    }
                    else{
                        clGUI.mostrarCaixaDialogo("A porta deve estar entre 1024 e 65535");
                    }
                }
                catch(NumberFormatException ex){
                    clGUI.mostrarCaixaDialogo("A porta deve ter somente números");
                }
                catch(NullPointerException ex){}
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtPorta;
    private javax.swing.JTextField txtServidorAtual;
    // End of variables declaration//GEN-END:variables
}