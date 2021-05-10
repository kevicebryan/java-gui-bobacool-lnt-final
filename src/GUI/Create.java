package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import dao.bobaDAO;

public class Create extends JFrame implements ActionListener {
	JButton saveButton = new JButton("Save");
	JButton cancelButton = new JButton("Cancel");
	
	JTextField txtKodeMenu;
	JTextField txtNamaMenu;
	JTextField txtHargaMenu;
	JTextField txtStokMenu;
	ButtonGroup buttonGroup;
	
	public Create() {
		// TODO Auto-generated constructor stub
		initFrame();
	}
	
	private void initFrame() {
		setSize(350,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2));
		setResizable(false);
		initComponent();
		setLocation(200, 200);
		setVisible(true);
	}
	
	private void initComponent() {
		JLabel lblKode = new JLabel("KODE: ");
		txtKodeMenu = new JTextField();
		JLabel lblNama = new JLabel("NAMA: ");
		txtNamaMenu = new JTextField();
		JLabel lblHarga = new JLabel("HARGA: ");
		txtHargaMenu = new JTextField();
		JLabel lblStok = new JLabel("STOCK: ");
		txtStokMenu = new JTextField();
		add(lblKode);
		add(txtKodeMenu);
		add(lblNama);
		add(txtNamaMenu);
		add(lblHarga);
		add(txtHargaMenu);
		add(lblStok);
		add(txtStokMenu);
		addRadioButton();
	}
	
	private void addRadioButton() {
		buttonGroup = new ButtonGroup();
		add(saveButton);
		add(cancelButton);
		saveButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}
//	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(saveButton)) {
			bobaDAO bobaDAO = new bobaDAO();
			bobaDAO.insertData(txtKodeMenu.getText(),txtNamaMenu.getText(),
					txtHargaMenu.getText(),txtStokMenu.getText());
			JOptionPane.showMessageDialog(null,"Success insert data");
		}
		else if(e.getSource().equals(cancelButton)) {
			setVisible(false);
			new MainMenu();
		}
	}
}
