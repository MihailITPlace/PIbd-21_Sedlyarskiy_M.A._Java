package laba1_Egov;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MonorailForm extends JFrame {

	private JPanel contentPane;
	private ITransport monorail;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonorailForm frame = new MonorailForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	public void paint (Graphics g) {
		super.paint(g);
		try {
			if (monorail != null) {
				monorail.Draw(g);
			}
		}
		catch(Exception ex){
			
		}
	}	

	
	public void moveButton(JButton sender) {
		try {
			String name = sender.getToolTipText();	
			switch (name)
			{
            	case "Up":
            		monorail.MoveTransport(Direction.Up);
            		break;
            	case "Down":
            		monorail.MoveTransport(Direction.Down);
            		break;
            	case "Left":
            		monorail.MoveTransport(Direction.Left);
            		break;
            	case "Right":
            		monorail.MoveTransport(Direction.Right);
            		break;
			}
			this.repaint();
		}
		catch (Exception ex) {	
			System.out.print("Монорельс не создан");			
		}
	}
	
	/**
	 * Create the frame.
	 */
	public MonorailForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
					
		
		JButton buttonCreate = new JButton("Создать наследника");
		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
	            try {
					monorail = new Monorail(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000), Color.CYAN, Color.GRAY, true, true, true, 1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            try {
					monorail.SetPosition(70 + (int) (Math.random() * 160), 70 + (int) (Math.random() * 160), MonorailForm.this.getWidth(), MonorailForm.this.getHeight());					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            MonorailForm.this.repaint();
			}
		});
		buttonCreate.setBounds(10, 11, 150, 42);
		contentPane.add(buttonCreate);		
		
		JButton buttonCreateBase = new JButton("Создать базовый");
		buttonCreateBase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
	            try {
					monorail = new ElectricLocomotive(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000), Color.CYAN);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            try {
					monorail.SetPosition(70 + (int) (Math.random() * 160), 70 + (int) (Math.random() * 160), MonorailForm.this.getWidth(), MonorailForm.this.getHeight());					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            MonorailForm.this.repaint();
			}
		});
		buttonCreateBase.setBounds(170, 11, 150, 42);
		contentPane.add(buttonCreateBase);			
		
		JButton buttonUp = new JButton("");
		buttonUp.setToolTipText("Up");
		buttonUp.setIcon(new ImageIcon(MonorailForm.class.getResource("/img/up.png")));
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveButton(buttonUp);	
			}
		});
		buttonUp.setBounds(515, 215, 65, 65);
		contentPane.add(buttonUp);
		
		JButton buttonLeft = new JButton("");
		buttonLeft.setToolTipText("Left");
		buttonLeft.setIcon(new ImageIcon(MonorailForm.class.getResource("/img/left.png")));
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveButton(buttonLeft);	
			}
		});
		buttonLeft.setBounds(440, 291, 65, 65);
		contentPane.add(buttonLeft);
		
		JButton buttonDown = new JButton("");
		buttonDown.setToolTipText("Down");
		buttonDown.setIcon(new ImageIcon(MonorailForm.class.getResource("/img/down.png")));
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveButton(buttonDown);			
			}
		});
		buttonDown.setBounds(515, 291, 65, 65);
		contentPane.add(buttonDown);
		
		JButton buttonRight = new JButton("");
		buttonRight.setToolTipText("Right");
		buttonRight.setIcon(new ImageIcon(MonorailForm.class.getResource("/img/right.png")));
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveButton(buttonRight);
			}
		});
		buttonRight.setBounds(590, 291, 65, 65);
		contentPane.add(buttonRight);
	}
}
