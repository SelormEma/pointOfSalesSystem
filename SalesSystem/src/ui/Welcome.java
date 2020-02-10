package ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Welcome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txtUsername;
	private JPasswordField passwordField;
	Connection conn = null;
	PreparedStatement pst,ps = null;
	ResultSet rs,rst = null;
	public String usname;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public Welcome() {
		conn = SqlConnection.Conn();
		//conn= SqlServerConnection.Conns();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		int h = (int)screen.getHeight();
		int w = (int)screen.getWidth();
		setBounds(100, 100, 1366, 768);
		
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JPanel Welcomepanel = new JPanel();
		Welcomepanel.setBackground(new Color(0, 51, 102));
		Welcomepanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel LoginPanel = new JPanel();
		LoginPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JComboBox comboBox = new JComboBox();
		
		LoginPanel.setVisible(false);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex() ==1 || comboBox.getSelectedIndex() ==2) {
					
					LoginPanel.setVisible(true);	
					
				}
				
				if(comboBox.getSelectedIndex() ==0) {
					
					LoginPanel.setVisible(false);	
					
				}
				
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Login", "Administrator", "Employee"}));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(Welcomepanel, GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBox, 0, 366, Short.MAX_VALUE)
						.addComponent(LoginPanel, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(Welcomepanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(LoginPanel, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE))
		);
		Welcomepanel.setLayout(null);
		
		
		
		comboBox.setSelectedIndex(1);
		
		JLabel Logolabel = new JLabel("");
		
		Logolabel.setBounds(0, 0, 994, 708);
		Welcomepanel.add(Logolabel);
		
		//SET AN IMAGE TO PREFERRED LABEL WIDTH AND HEIGHT 
		ImageIcon MyImages = new ImageIcon(Welcome.class.getResource("/ui/4420652-young-happy-people-smiling-over-white-background.jpg"));
		
		Image imgs = MyImages.getImage();
		
		
		ImageIcon formats = new ImageIcon(imgs);
		
		Image newImg = imgs.getScaledInstance(Logolabel.getWidth(), Logolabel.getHeight(), Image.SCALE_SMOOTH);
		
		formats = new ImageIcon(newImg);
		
		Logolabel.setIcon(formats);
		
	//	Image a = formats.getImage();
	
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtUsername = new JTextField();
		txtUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem()=="Employee") {
					//comboBox.setFocusable(false);
				txtUsername.requestFocus();
				}
			}
		});
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				//usname=txtUsername.getText();
				
				
				if(comboBox.getSelectedItem()=="Employee") {
					//comboBox.setFocusable(false);
				//txtUsername.requestFocus();
				
				try {
					
					
					//String query = "SELECT * FROM Details where Name=? and Password=?";
					PreparedStatement pst = conn.prepareStatement("SELECT * FROM EmployeeLogin where Username=? and Password=?");
					pst.setString(1, txtUsername.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int count =0;
					while(rs.next()) {
						
						count = count+1;
						usname = rs.getString("Username");
					}
					
					if(count ==1) {
						JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL");
						//dispose();
						hide();
						Employee frame = new Employee();
						frame.setVisible(true);
					}
					
					else if(count>1) {
						
						JOptionPane.showMessageDialog(null, " DUPLICATE USERNAME / PASSWORD");
						
					}
					else {
						JOptionPane.showMessageDialog(null, "INCORRECT USERNAME / PASSWORD");
						passwordField.setText("");
					}
					
				
					
					pst.close();
					 rs.close();
				} 
			
				 
				
				catch (Exception e2)
				{
					// TODO: handle exception
					//JOptionPane.showMessageDialog(null, e2);
					e2.printStackTrace();
				}
				
				finally{
					try{
					rs.close();
					pst.close();

					}
					catch(Exception e){
					}

				
//				if(txtUsername.getText().matches(usname) && passwordField.getText().matches(pword)) {
//					hide();
//					Employee frame = new Employee();
//					frame.setVisible(true);
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Incorrect Username/Password"+"\n"+"Try Again");
//				}
				
				
			}
				}
			}
			});
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setBackground(new Color(0, 51, 102));
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblNewLabel = new JLabel("WELCOME TO MALSAM SUPERMARKET");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_LoginPanel = new GroupLayout(LoginPanel);
		gl_LoginPanel.setHorizontalGroup(
			gl_LoginPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_LoginPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_LoginPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LoginPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_LoginPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_LoginPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, 201, 201, 201)
								.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
						.addGroup(gl_LoginPanel.createSequentialGroup()
							.addGap(118)
							.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
					.addGap(28))
				.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
				.addGroup(gl_LoginPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_LoginPanel.setVerticalGroup(
			gl_LoginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LoginPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(68)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(gl_LoginPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(77)
					.addGroup(gl_LoginPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(88)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(174))
		);
		
		
		
		
		
		
		
		
		
		
		//Password Field Enter Key Pressed Action Event
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.getKeyCode()==10) {
					
				
				  for(ActionListener a: btnSubmit.getActionListeners()) {
		        	   a.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
		           }
				}
			}
		});
		
		
		
		
		
		
		
		
		
		LoginPanel.setLayout(gl_LoginPanel);
		contentPane.setLayout(gl_contentPane);
		setExtendedState(MAXIMIZED_BOTH);
	}
}
