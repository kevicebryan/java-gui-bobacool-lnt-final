package GUI;

import javax.swing.*;
import java.awt.event.*; 
import javax.swing.table.DefaultTableModel;
import dao.bobaDAO;
import java.awt.*;
import java.util.Vector;


public class Delete extends JFrame implements MouseListener, ActionListener{

	JButton exitButton = new JButton("Exit");
	
	JTable table;
	DefaultTableModel tableModel;
	JButton btnDelete;
	String id ="";
	
	public Delete() {
		initJFrame();
	}
	
	private void initJFrame() {
		setTitle("Delete Data");
		setSize(400 , 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		setResizable(false);
		setLocation(200, 200);
		initJTable();
		initDeleteButton();
		setVisible(true);
	}
	private void initJTable() {
		bobaDAO bobaDAO = new bobaDAO();
		bobaDAO.start();
		
		Vector<String> columns = new Vector<>();
		columns.add("Kode");
		columns.add("Nama");
		columns.add("Harga");
		columns.add("Stok");
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
	
	private void initDeleteButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		
		btnDelete.setBackground(Color.GREEN);
		btnDelete.setOpaque(true);
		btnDelete.setBorderPainted(true);
		btnDelete.addActionListener(this);
		
		exitButton.setBackground(Color.RED);
		exitButton.setOpaque(true);
		exitButton.setBorderPainted(true);
		exitButton.addActionListener(this);
		
		panel.add(btnDelete);
		panel.add(exitButton);
		
		add(panel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(id.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Select Menu ");
		}
		else if(e.getSource().equals(exitButton)) {
			setVisible(false);
			new MainMenu();
		}
		else {
			bobaDAO bobaDAO = new bobaDAO();
			bobaDAO.deleteData(id);
			JOptionPane.showMessageDialog(null, "Success Menu Deleted!");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		 int selectedRowIdx = table.getSelectedRow();
		 id = tableModel.getValueAt(selectedRowIdx, 0).toString();
		 JOptionPane.showMessageDialog(null, "Selected "+ id);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}