package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.bobaDAO;

public class GetTable extends JFrame implements ActionListener{

	
	JButton createMenuButton = new JButton("Create");
	JButton exitButton = new JButton("Exit");
	
	public GetTable() {
		initBottomButtons();
		initFrame();
		initJTable();
	}
	
	private void initBottomButtons() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		createMenuButton.setBackground(Color.GREEN);
		createMenuButton.setOpaque(true);
		createMenuButton.setBorderPainted(true);
		createMenuButton.addActionListener(this);
		
		exitButton.setBackground(Color.RED);
		exitButton.setOpaque(true);
		exitButton.setBorderPainted(true);
		exitButton.addActionListener(this);
		
		panel.add(createMenuButton);
		panel.add(exitButton);
		
		add(panel, BorderLayout.SOUTH);
	}
	
	private void initFrame() {
		setTitle("View Table");
		setSize(350,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	private void initJTable() {
		bobaDAO bobaDAO = new bobaDAO();
		Vector<String> columns = new Vector<>();
		
		columns.add("Kode");
		columns.add("Nama");
		columns.add("Harga");
		columns.add("Stok");
		
		Vector<Vector<String>> rows = new Vector<>();
		
		DefaultTableModel tableModel = new DefaultTableModel(bobaDAO.getCustomerData(), columns) {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
			}
		};
		JTable table = new JTable(tableModel);
		table.isCellEditable(0,0);
		JScrollPane sp = new JScrollPane(table);
		add(sp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(createMenuButton)) {
			new Create();
			setVisible(false);
		}
		else if(e.getSource().equals(exitButton)) {
			new MainMenu();
			setVisible(false);
		}
	}
	}