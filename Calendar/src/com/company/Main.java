package com.company;

import javax.swing.JComboBox;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import Domain.Student;

public class Main extends javax.swing.JFrame {

	GeneticAlgorithm ga;

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JSpinner jSpinner1;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JComboBox<String> jCombobox;
	private boolean flag = false;
	private int comboValue = 0;
	private Student StudentSelected = null;

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
		jLabel3 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jLabel4 = new javax.swing.JLabel();
		jCombobox = new javax.swing.JComboBox<>();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("IART - 2017/2018");

		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("Otimização da Calendarização de Exames");

		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("Nº dias da Época de Exames: ");

		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setText(" ");

		SpinnerModel spinnerModel = new SpinnerNumberModel(10, // initial value
				0, // min
				50, // max
				1);// step
		jSpinner1 = new javax.swing.JSpinner(spinnerModel);

		jButton2.setText("Gerar Novo Calendario");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton1.setText("Executar Algoritmo");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton3.setText("Executar 100xAlgoritmo");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jCombobox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboboxActionPerformed(evt);
			}
		});

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { "09h00", "", null, null, null, null, null, null, null, null, null, null },
						{ "14h00", null, null, null, null, null, null, null, null, null, null, null },
						{ "18h00", null, null, null, null, null, null, null, null, null, null, null } },
				new String[] { "Hora", "Dia 1", "Dia 2", "Dia 3", "Dia 4", "Dia 5", "Dia 6", "Dia 7 ", "Dia 8", "Dia 9",
						"Dia 10", "Dia 11" }));
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
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout
								.createSequentialGroup().addContainerGap()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(282, Short.MAX_VALUE)
								.addComponent(jButton2).addGap(49, 49, 49).addComponent(jButton1).addGap(49, 49, 49)
								.addComponent(jButton3).addGap(49, 49, 49).addComponent(jCombobox)
								.addGap(0, 240, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(282, Short.MAX_VALUE)
								.addComponent(jLabel3)
								.addComponent(jSpinner1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 240, Short.MAX_VALUE))
						.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton2).addComponent(jButton1).addComponent(jButton3)
								.addComponent(jCombobox))
						.addGap(28, 28, 28).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE,
										30, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(28, 28, 28)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(34, 34, 34).addContainerGap(46, Short.MAX_VALUE).addComponent(jLabel4))

		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		ga = new GeneticAlgorithm((Integer) jSpinner1.getValue());
		ga.fullAutofill();
		updateTable();
		this.comboValue = 0;
		this.StudentSelected = null;
		this.jCombobox.removeAllItems();
		this.jCombobox.addItem("All");
		for (int i = 0; i < ga.getStudents().size(); i++) {
			this.jCombobox.addItem(ga.getStudents().get(i).getName());
			;
		}
		flag = true;
		jLabel4.setText("Força do Calendário: " + String.valueOf(ga.getPopulation().getFittest().getCurrentStrength()));
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (flag) {
			ga.solveAlgoritmo();
			updateTable();
			jLabel4.setText(
					"Força do Calendário: " + String.valueOf(ga.getPopulation().getFittest().getCurrentStrength()));
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if (flag) {
			ga.solveAlgoritmo100();
			updateTable();
			jLabel4.setText(
					"Força do Calendário: " + String.valueOf(ga.getPopulation().getFittest().getCurrentStrength()));
		}
	}

	private void jComboboxActionPerformed(java.awt.event.ActionEvent evt) {
		this.comboValue = this.jCombobox.getSelectedIndex();
		if (this.comboValue != -1) {
			if (this.comboValue == 0) {
				this.StudentSelected = null;
			} else {
				this.StudentSelected = ga.getStudents().get(this.comboValue - 1);
			}
			updateTable();
		}
	}

	public void updateTable() {
		jTable1.setModel(new javax.swing.table.DefaultTableModel(ga.getTab(StudentSelected), ga.getHeaders()));
		this.comboValue = 0;
	}
}
