package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import dao.bobaDAO;


public class Update extends JFrame implements MouseListener, ActionListener{
	
	JButton exitButton = new JButton("Exit");

	JTextField txtKodeMenu;
	JTextField txtNamaMenu;
	JTextField txtHargaMenu;
	JTextField txtStokMenu;
//	JComboBox cnbCity;
//	JRadioButton radioMale;
//	JRadioButton radioFemale;
	ButtonGroup buttonGroup;
	DefaultTableModel tableModel;
	String id = "";
	
	JTable table;
	JButton updateButton;
	
	
	public Update() {
		initJFrame();
	}
	
	private void initJFrame() {
		setTitle("Update Menu");
		setSize(500 , 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		setResizable(false);
		setLocation(200, 200);
		initJTable();
		initFormUpdate();
		addButtonUpdate();
		setVisible(true);
	}
	
	private void initJTable() {
		bobaDAO bobaDAO = new bobaDAO();
		Vector<String> columns = new Vector<>();
		
		columns.add("ID");
		columns.add("Name");
		columns.add("Phone");
		columns.add("City");
		
		Vector<Vector<String>> rows = new Vector<>();
		
		tableModel = new DefaultTableModel(bobaDAO.getCustomerData(), columns) {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
			}
		};
		table = new JTable(tableModel);
		table.isCellEditable(0,0);
		table.addMouseListener(this);
		
		JScrollPane sp = new JScrollPane(table);
		add(sp);
	}

	private void initFormUpdate() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));

		JLabel lblKode = new JLabel("KODE: ");
		txtKodeMenu = new JTextField();
		JLabel lblNama = new JLabel("NAMA: ");
		txtNamaMenu = new JTextField();
		JLabel lblHarga = new JLabel("HARGA: ");
		txtHargaMenu = new JTextField();
		JLabel lblStok = new JLabel("STOCK: ");
		txtStokMenu = new JTextField();
		
		panel.add(lblKode);
		panel.add(txtKodeMenu);
		panel.add(lblNama);
		panel.add(txtNamaMenu);
		panel.add(lblHarga);
		panel.add(txtHargaMenu);
		panel.add(lblStok);
		panel.add(txtStokMenu);
		
		add(panel);
	}
	
	
	
	private void addButtonUpdate() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		updateButton = new JButton("Update Data");
		updateButton.addActionListener(this);
		
		updateButton.setBackground(Color.GREEN);
		updateButton.setOpaque(true);
		updateButton.setBorderPainted(true);
		updateButton.addActionListener(this);
		
		exitButton.setBackground(Color.RED);
		exitButton.setOpaque(true);
		exitButton.setBorderPainted(true);
		exitButton.addActionListener(this);
		
		panel.add(updateButton);
		panel.add(exitButton);
		
		add(panel, BorderLayout.SOUTH);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int selectedRowIndex = table.getSelectedRow();
		id = tableModel.getValueAt(selectedRowIndex, 0).toString();
//		System.out.println(tableModel.getValueAt(selectedRowIndex, 0).toString());
		txtKodeMenu.setText(tableModel.getValueAt(selectedRowIndex, 1).toString());
		txtNamaMenu.setText(tableModel.getValueAt(selectedRowIndex, 2).toString());
		txtHargaMenu.setText(tableModel.getValueAt(selectedRowIndex, 3).toString());
		txtStokMenu.setText(tableModel.getValueAt(selectedRowIndex, 4).toString());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(id.equals("")) {
			JOptionPane.showMessageDialog(null, "Select item you want to update");
		}
		else if(e.getSource().equals(exitButton)) {
			new MainMenu();
			setVisible(false);
		}
		else {
		bobaDAO bobaDAO = new bobaDAO();
		bobaDAO.updateData(id, txtKodeMenu.getText(),txtNamaMenu.getText(),
				txtHargaMenu.getText(),txtStokMenu.getText());
		JOptionPane.showMessageDialog(null, "Success Update Data");
		
		}
	}
}