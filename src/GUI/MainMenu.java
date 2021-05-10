package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener{
	
	JButton menuButton1 = new JButton("Insert Menu");
	JButton menuButton2 = new JButton("View Menu");
	JButton menuButton3 = new JButton("Update Menu");
	JButton menuButton4 = new JButton("Delete Menu");
	JButton startButton = new JButton("Start");
	JButton exitButton = new JButton("Exit");
	
	public MainMenu(){
		initFrame();
	}
	
	private void initFrame() {
		setTitle("College");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		initLabel();
		initMenus();
		initBottomButtons();
		setLocation(200,200);
		setVisible(true);
	}
	
	private void initLabel() {
		JLabel labelTitle = new JLabel("BOBACOOL");
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		labelTitle.setFont(new Font(null, Font.BOLD, 18));
		add(labelTitle, BorderLayout.NORTH);
	}
	
	private void initMenus() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		menuButton1.addActionListener(this);
		menuButton2.addActionListener(this);
		menuButton3.addActionListener(this);
		menuButton4.addActionListener(this);
		panel.add(menuButton1);
		panel.add(menuButton2);
		panel.add(menuButton3);
		panel.add(menuButton4);
		add(panel);	
	}
	
	private void initBottomButtons(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		startButton.setBackground(Color.GREEN);
		startButton.setOpaque(true);
		startButton.setBorderPainted(true);
		startButton.addActionListener(this);
		
		exitButton.setBackground(Color.RED);
		exitButton.setOpaque(true);
		exitButton.setBorderPainted(true);
		exitButton.addActionListener(this);
		
		panel.add(startButton);
		panel.add(exitButton);
		
		add(panel, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(menuButton1)){
			new Create();
			setVisible(false);
		}
		else if(e.getSource().equals(menuButton2)){
			new GetTable();
			setVisible(false);
		}
		else if(e.getSource().equals(menuButton3)){
			new Update();
			setVisible(false);
		}
		else if(e.getSource().equals(menuButton4)){
			new Delete();
			setVisible(false);
		}
		else if(e.getSource().equals(startButton)) {
			System.out.println("Printing Out Note");
			new WriteToFile();
			setVisible(false);
		}
		else if(e.getSource().equals(exitButton)) {
			System.exit(0);
		}
	}

}
