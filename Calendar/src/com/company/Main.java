package com.company;

public class Main extends javax.swing.JFrame {
	
	GeneticAlgorithm ga;
	
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    
	public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
	
	
	public Main() {
	    initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
    	 jPanel1 = new javax.swing.JPanel();
         jLabel1 = new javax.swing.JLabel();
         jLabel2 = new javax.swing.JLabel();
         jButton2 = new javax.swing.JButton();
         jScrollPane1 = new javax.swing.JScrollPane();
         jTable1 = new javax.swing.JTable();
         
         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

         jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
         jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
         jLabel1.setText("IART - 2017/2018");
         
         jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
         jLabel2.setText(" Otimização da Calendarização de Exames");


         jButton2.setText("Gerar Novo Calendario");
         jButton2.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButton2ActionPerformed(evt);
             }
         });

         jTable1.setModel(new javax.swing.table.DefaultTableModel(
             new Object [][] {
                 {"09h00", "", null, null, null, null, null, null, null, null, null, null},
                 {"14h00", null, null, null, null, null, null, null, null, null, null, null},
                 {"18h00", null, null, null, null, null, null, null, null, null, null, null}
             },
             new String [] {
                 "Hora", "Dia 1", "Dia 2", "Dia 3", "Dia 4", "Dia 5", "Dia 6", "Dia 7 ", "Dia 8", "Dia 9", "Dia 10", "Dia 11"
             }
         ));
         jScrollPane1.setViewportView(jTable1);
         if (jTable1.getColumnModel().getColumnCount() > 0) {
             jTable1.getColumnModel().getColumn(0).setHeaderValue("Hora");
             jTable1.getColumnModel().getColumn(1).setHeaderValue("Dia 1");
             jTable1.getColumnModel().getColumn(2).setHeaderValue("Dia 2");
             jTable1.getColumnModel().getColumn(3).setHeaderValue("Dia 3");
             jTable1.getColumnModel().getColumn(4).setHeaderValue("Dia 4");
             jTable1.getColumnModel().getColumn(5).setHeaderValue("Dia 5");
             jTable1.getColumnModel().getColumn(6).setHeaderValue("Dia 6");
             jTable1.getColumnModel().getColumn(7).setHeaderValue("Dia 7 ");
             jTable1.getColumnModel().getColumn(8).setHeaderValue("Dia 8");
             jTable1.getColumnModel().getColumn(9).setHeaderValue("Dia 9");
             jTable1.getColumnModel().getColumn(10).setHeaderValue("Dia 10");
             jTable1.getColumnModel().getColumn(11).setHeaderValue("Dia 11");
         }

         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addContainerGap()
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                             .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                     .addGroup(jPanel1Layout.createSequentialGroup()
                         .addContainerGap(282, Short.MAX_VALUE)
                         .addComponent(jButton2)
                         .addGap(0, 240, Short.MAX_VALUE))
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                 .addContainerGap())
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                 .addGap(0, 0, Short.MAX_VALUE)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
         );
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(jLabel1)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(jLabel2)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jButton2))
                 .addGap(28, 28, 28)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(34, 34, 34)
                 .addContainerGap(46, Short.MAX_VALUE))
         );

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
         );

         pack();

    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		ga = new GeneticAlgorithm();
	    ga.autofillCalendar();
        updateTable();
    }
    
    private void updateTable(){
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            ga.getTab(),
            ga.getHeaders()
        ));
        
    }
}
