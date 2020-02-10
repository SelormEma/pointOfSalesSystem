package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.JobAttributes;
import java.awt.PageAttributes;
import java.awt.PrintJob;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class Administrator extends JFrame {

	private JPanel contentPane;
	Connection conn =null;
	private JTextField txtItemName;
	private JTextField txtItemPrice;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField RItextField;
	private JTable RItable;
	private JTextField RISearch;
	private JTable CIPtable;
	private JTextField CIPSEARCH;
	private JTextField CIPtxtPrice;
	
	@SuppressWarnings("unused")
	private ImageIcon format =null;
	@SuppressWarnings("unused")
	private ImageIcon formats =null;
	String filename = null;
	String filenames = null;
	
	//int s=0;
	byte[] person =null;
	byte[] persons = null;
	private JTable VStable;
	private JTextField VStxtSearch;
	private JTextField USSEARCH;
	private JTable UStable;
	private JTextField UStextField;
	private JTextField textFieldStock;
	LocalDateTime mydate = LocalDateTime.now();
	DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	String formatteddate = mydate.format(dtformat);
	private JTable VDStable;
	private JTextField txtItemNumber;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator frame = new Administrator();
					frame.setVisible(true);
					
					
					//UIManager.setLookAndFeel("com.pagosoft.plaf.PgsLookAndFeel");
					UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
					// Is your UI already created? So you will have to update the component-tree
					// of your current frame (or actually all of them...)
					SwingUtilities.updateComponentTreeUI(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public Administrator() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administrator.class.getResource("/ui/4420652-young-happy-people-smiling-over-white-background.jpg")));
		setExtendedState(MAXIMIZED_BOTH);
		//conn=SqlServerConnection.Conns();
		conn = SqlConnection.Conn();
			JPanel RemoveItemsPanel = new JPanel();

			
			JLabel USlabel = new JLabel("");
			RemoveItemsPanel.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(JOptionPane.showConfirmDialog(contentPane, "Confirm if you want to exit", "Sales System", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
				System.exit(1);
				}
				
			}
		});
		
		JMenuItem menulogout = new JMenuItem("Logout");
		mnFile.add(menulogout);
		mnFile.add(menuExit);
		
		JMenu mnEmployee = new JMenu("Employee");
		menuBar.add(mnEmployee);
		
		JMenuItem mntmAdd = new JMenuItem("Add Employee");
		mnEmployee.add(mntmAdd);
		
		JMenuItem mntmDeleteEmployee = new JMenuItem("Delete Employee");
		mnEmployee.add(mntmDeleteEmployee);
		
		JMenuItem mntmChangeDetails = new JMenuItem("Change Details");
		mnEmployee.add(mntmChangeDetails);
		
		JMenu mnAdministrator = new JMenu("Administrator ");
		menuBar.add(mnAdministrator);
		
		JMenuItem mntmAddAdministrator = new JMenuItem("Add Administrator ");
		mnAdministrator.add(mntmAddAdministrator);
		
		JMenuItem menuItem_2 = new JMenuItem("Change Details");
		mnAdministrator.add(menuItem_2);
		
		JMenu mnDiscount = new JMenu("Discount");
		menuBar.add(mnDiscount);
		
		JMenuItem mntmAddDiscount = new JMenuItem("Add Discount(%)");
		mnDiscount.add(mntmAddDiscount);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel Controlpanel = new JPanel();
		Controlpanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Control Panel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel MainPanel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Controlpanel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(MainPanel, GroupLayout.PREFERRED_SIZE, 1087, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(MainPanel, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(Controlpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		MainPanel.setLayout(null);
			JPanel UpdateStockPanel = new JPanel();
			UpdateStockPanel.setVisible(false);
			
			UpdateStockPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "UPDATE STOCK", TitledBorder.LEADING, TitledBorder.ABOVE_BOTTOM, null, new Color(0, 0, 0)));
			UpdateStockPanel.setVisible(false);
				JPanel ViewStockPanel = new JPanel();
				ViewStockPanel.setVisible(false);
				
				ViewStockPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "VIEW STOCK", TitledBorder.LEADING, TitledBorder.ABOVE_BOTTOM, null, new Color(0, 0, 0)));
				ViewStockPanel.setVisible(false);
				JPanel ViewDailySalesPanel = new JPanel();
				ViewDailySalesPanel.setVisible(false);
				
				ViewDailySalesPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "VIEW DAILY SALES", TitledBorder.LEADING, TitledBorder.ABOVE_BOTTOM, null, new Color(0, 0, 0)));
				ViewDailySalesPanel.setVisible(false);
				
				
				
				//	UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
				
					
				JLabel ItemImg = new JLabel("IMAGE");
				
				JPanel AddItemsPanel = new JPanel();
				AddItemsPanel.setVisible(false);
				
				AddItemsPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "ADD NEW ITEM", TitledBorder.LEADING, TitledBorder.ABOVE_BOTTOM, null, new Color(0, 0, 0)));
				AddItemsPanel.setVisible(false);
				AddItemsPanel.setBounds(0, 0, 1087, 682);
				MainPanel.add(AddItemsPanel);
				AddItemsPanel.setLayout(null);
				
				JButton btnSubmitNewitem = new JButton("SUBMIT");
				
				btnSubmitNewitem.setFont(new Font("Serif", Font.PLAIN, 15));
				btnSubmitNewitem.setBounds(462, 555, 208, 67);
				AddItemsPanel.add(btnSubmitNewitem);
				
				txtItemName = new JTextField();
				txtItemName.setFont(new Font("Serif", Font.PLAIN, 30));
				txtItemName.setBounds(407, 43, 279, 67);
				AddItemsPanel.add(txtItemName);
				txtItemName.setColumns(10);
				
				txtItemPrice = new JTextField();
				txtItemPrice.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						
						char ch = e.getKeyChar();
						
						char dot = '.';
						if((!Character.isDigit(ch)&&ch!=dot)) {
						
							e.consume();
							}
					
				}
				});
				txtItemPrice.setHorizontalAlignment(SwingConstants.CENTER);
				txtItemPrice.setText("0.00");
				txtItemPrice.setFont(new Font("Serif", Font.PLAIN, 30));
				txtItemPrice.setColumns(10);
				txtItemPrice.setBounds(409, 302, 277, 67);
				AddItemsPanel.add(txtItemPrice);
				
				JLabel lblItemName = new JLabel("ITEM NAME:");
				lblItemName.setFont(new Font("Serif", Font.PLAIN, 39));
				lblItemName.setHorizontalAlignment(SwingConstants.CENTER);
				lblItemName.setBounds(112, 52, 279, 42);
				AddItemsPanel.add(lblItemName);
				
				JLabel lblItemPrice = new JLabel("ITEM PRICE:");
				lblItemPrice.setFont(new Font("Serif", Font.PLAIN, 39));
				lblItemPrice.setHorizontalAlignment(SwingConstants.CENTER);
				lblItemPrice.setBounds(112, 311, 277, 42);
				AddItemsPanel.add(lblItemPrice);
				
				JButton btnAddImage = new JButton("ADD IMAGE");
				btnAddImage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JFileChooser chooser = new JFileChooser();
						chooser.showOpenDialog(null);
						File f = chooser.getSelectedFile();
						filenames = f.getAbsolutePath();
						
						
						
						try {
							
							File image = new File(filenames);
							ImageIcon MyImage = new ImageIcon(filenames);
							
							Image img = MyImage.getImage();
							Image newImg = img.getScaledInstance(ItemImg.getWidth(), ItemImg.getHeight(), Image.SCALE_SMOOTH);
							
							 format = new ImageIcon(newImg);
							ItemImg.setIcon(new ImageIcon(newImg));
							FileInputStream  fis = new FileInputStream(image);
							
							ByteArrayOutputStream bos = new ByteArrayOutputStream();
							
							
							byte[] buf = new byte[1024];
							
							for(int readNum; (readNum =fis.read(buf))!= -1;) {
							
								bos.write(buf,0,readNum);
							
							}
							
							
							persons = bos.toByteArray();
							
							
							fis.close();
						} catch (Exception e2) {
							// TODO: handle exception
						}
						finally{
							try{
							rs.close();
							pst.close();

							}
							catch(Exception e){
							}
							}
					}
				});
				btnAddImage.setFont(new Font("Serif", Font.PLAIN, 15));
				btnAddImage.setBounds(816, 555, 208, 67);
				AddItemsPanel.add(btnAddImage);
				
				JButton btnClearAll = new JButton("CLEAR ALL");
				btnClearAll.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						txtItemName.setText(null);
						txtItemPrice.setText("0.00");
						textFieldStock.setText("0");
						ItemImg.setIcon(null);
						txtItemNumber.setText(null);
						
						
					}
				});
				btnClearAll.setFont(new Font("Serif", Font.PLAIN, 15));
				btnClearAll.setBounds(155, 555, 208, 67);
				AddItemsPanel.add(btnClearAll);
				
				JPanel Imagepanel = new JPanel();
				Imagepanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
				Imagepanel.setBounds(754, 113, 308, 283);
				AddItemsPanel.add(Imagepanel);
				Imagepanel.setLayout(null);
				
				
				ItemImg.setBounds(24, 24, 265, 231);
				Imagepanel.add(ItemImg);
				ItemImg.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel lblStock = new JLabel("STOCK:");
				lblStock.setHorizontalAlignment(SwingConstants.CENTER);
				lblStock.setFont(new Font("Serif", Font.PLAIN, 39));
				lblStock.setBounds(112, 450, 277, 42);
				AddItemsPanel.add(lblStock);
				
				textFieldStock = new JTextField();
				textFieldStock.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						
						char ch = e.getKeyChar();
						
						char dot = '.';
						if((!Character.isDigit(ch))) {
						
							e.consume();
							}
					
				}
				});
				textFieldStock.setHorizontalAlignment(SwingConstants.CENTER);
				textFieldStock.setText("0");
				textFieldStock.setFont(new Font("Serif", Font.PLAIN, 30));
				textFieldStock.setColumns(10);
				textFieldStock.setBounds(409, 441, 277, 67);
				AddItemsPanel.add(textFieldStock);
				
				JLabel lblItemNumber = new JLabel("ITEM NUMBER:");
				lblItemNumber.setHorizontalAlignment(SwingConstants.CENTER);
				lblItemNumber.setFont(new Font("Serif", Font.PLAIN, 39));
				lblItemNumber.setBounds(77, 183, 314, 42);
				AddItemsPanel.add(lblItemNumber);
				
				txtItemNumber = new JTextField();
				txtItemNumber.setFont(new Font("Serif", Font.PLAIN, 30));
				txtItemNumber.setColumns(10);
				txtItemNumber.setBounds(407, 174, 279, 67);
				AddItemsPanel.add(txtItemNumber);
				
				
				
				
				btnSubmitNewitem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(txtItemName.getText().contentEquals("")|| txtItemPrice.getText().contentEquals("") || textFieldStock.getText().contentEquals("")|| txtItemNumber.getText().contentEquals("")) {
							JOptionPane.showMessageDialog(null, "Addition UnSuccessful");
						}
						else {
						if(JOptionPane.showConfirmDialog(contentPane, "Confirm if you want to add", "Sales System", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
							
							String query="INSERT INTO PRODUCT(NAME,PRICE,Stock,ItemImage,ItemNumber)VALUES(?,?,?,?,?)";
							
							try {
								pst= conn.prepareStatement(query);
								pst.setString(1, txtItemName.getText());
								pst.setString(2, txtItemPrice.getText());
								pst.setString(3, textFieldStock.getText());
								pst.setBytes(4, persons);
								pst.setString(5, txtItemNumber.getText());
								pst.execute();
								
								rs.close();
								pst.close();
								
//								txtItemName.setText(null);
//								txtItemNumber.setText(null);
//								txtItemPrice.setText("0.00");
//								textFieldStock.setText("0");
//								ItemImg.setIcon(null);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							finally {
								try {
									rs.close();
									pst.close();
									for(ActionListener c: btnClearAll.getActionListeners()) {
							        	   c.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
							           }
								} catch (SQLException e) {
									
								}
								
							}
							
							
						}
					}
					}
				});
				ViewDailySalesPanel.setBounds(0, 0, 1087, 682);
				MainPanel.add(ViewDailySalesPanel);
				ViewDailySalesPanel.setLayout(null);
				
				JScrollPane VDSscrollPane = new JScrollPane();
				VDSscrollPane.setBounds(12, 12, 810, 647);
				ViewDailySalesPanel.add(VDSscrollPane);
				
				VDStable = new JTable();
				VDSscrollPane.setViewportView(VDStable);
				VDStable.setRowHeight(30);
				VDStable.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ID", "NAME"
						}
					));
					
					
					
				VDStable.setFont(new Font("Serif", Font.PLAIN, 15));
				
				DefaultTableCellRenderer stringRenderer3 = (DefaultTableCellRenderer)
						VDStable.getDefaultRenderer(String.class);
				VDStable.getDefaultRenderer(Integer.class);
				
				stringRenderer3.setHorizontalAlignment(SwingConstants.CENTER);
				ViewStockPanel.setBounds(0, 0, 1087, 682);
				MainPanel.add(ViewStockPanel);
				ViewStockPanel.setLayout(null);
				
				JLabel labelCurrentStock = new JLabel("");
				labelCurrentStock.setBounds(838, 167, 237, 55);
				ViewStockPanel.add(labelCurrentStock);
				labelCurrentStock.setHorizontalAlignment(SwingConstants.CENTER);
				labelCurrentStock.setFont(new Font("Segoe UI Symbol", Font.BOLD, 22));
				labelCurrentStock.setBackground(Color.WHITE);
				
				JLabel labelVSItem = new JLabel("");
				labelVSItem.setBounds(838, 196, 237, 55);
				ViewStockPanel.add(labelVSItem);
				labelVSItem.setHorizontalAlignment(SwingConstants.CENTER);
				labelVSItem.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
				labelVSItem.setBackground(Color.WHITE);
				
				JScrollPane scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(12, 12, 808, 644);
				ViewStockPanel.add(scrollPane_2);
				
				VStable = new JTable();
				VStable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						int row = VStable.getSelectedRow();
						String VSTableclick =(VStable.getModel().getValueAt(row, 1).toString());
						
						labelVSItem.setText(VSTableclick);
						
						try {
							
							String query = "SELECT STOCK FROM PRODUCT WHERE Name=?";
							
							pst= conn.prepareStatement(query);
							pst.setString(1, VSTableclick);
							rs = pst.executeQuery();
							
							String a = rs.getString("STOCK");
							labelCurrentStock.setText(a);
							
							
							
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						finally{
							try{
							rs.close();
							pst.close();

							}
							catch(Exception e){
							}
							}
						
						
					}
				});
				scrollPane_2.setViewportView(VStable);
				VStable.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ID", "NAME", "PRICE", "STOCK"
						}
					));
				VStable.setRowHeight(30);
				VStable.setFont(new Font("Serif", Font.PLAIN, 15));
				
				DefaultTableCellRenderer stringRenderer21 = (DefaultTableCellRenderer)
					     VStable.getDefaultRenderer(String.class);
				VStable.getDefaultRenderer(Integer.class);
				
				VStxtSearch = new JTextField();
				VStxtSearch.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						try {
							
							
							String val = VStxtSearch.getText().trim();
							String query ="Select ID,ItemNumber,NAME,PRICE,STOCK from PRODUCT where Name like '%"+val+"%'";
							
							pst =conn.prepareStatement(query);
							//pst.setString(1, Search.getText());
							
							rs = pst.executeQuery();
							//ResultSet rss = pst.executeQuery();
							
							
							VStable.setModel(DbUtils.resultSetToTableModel(rs));
							
							
							
							//JOptionPane.showMessageDialog(null, "Saved Successfully");
							rs.close();
							pst.close();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						finally{
							try{
							rs.close();
							pst.close();

							}
							catch(Exception e){
							}
							}
						
					}
				});
				VStxtSearch.setBounds(841, 12, 234, 50);
				ViewStockPanel.add(VStxtSearch);
				VStxtSearch.setFont(new Font("Serif", Font.PLAIN, 30));
				VStxtSearch.setColumns(10);
				
				JButton VSPrintbutton = new JButton("PRINT");
				VSPrintbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						MessageFormat header = new MessageFormat(" Stock on "+ formatteddate);
						MessageFormat footer = new MessageFormat(" Page {0,number,integer}            Whatever");
						     try {
						         PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
						         set.add(OrientationRequested.PORTRAIT);
						         VStable.print(JTable.PrintMode.FIT_WIDTH, header, footer, false, set, false);
						         JOptionPane.showMessageDialog(null, "\n" + "Stock was Successfully "
						                + "\n");
						     } catch (java.awt.print.PrinterException e) {
//						         JOptionPane.showMessageDialog(null, "\n" + "Error from Printer Job "
//						                + "\n" + e); 
						    	 //JOptionPane.showMessageDialog(null,"Contact Admin");
						     }

						
					}
				});
				VSPrintbutton.setToolTipText("Print Current Stock");
				VSPrintbutton.setFont(new Font("Serif", Font.PLAIN, 15));
				VSPrintbutton.setBounds(853, 377, 208, 67);
				ViewStockPanel.add(VSPrintbutton);
			UpdateStockPanel.setBounds(0, 0, 1087, 682);
			MainPanel.add(UpdateStockPanel);
			UpdateStockPanel.setLayout(null);
			
			JScrollPane USscrollPane = new JScrollPane();
			USscrollPane.setBounds(12, 12, 808, 644);
			UpdateStockPanel.add(USscrollPane);
			
			UStable = new JTable();
			UStable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					int USrow = UStable.getSelectedRow();
					//String USTableclick =(UStable.getModel().getValueAt(USrow, 0).toString());
					String click =(UStable.getModel().getValueAt(USrow, 1).toString());
					USlabel.setText(click);
					//UStextField.setText(USTableclick);
					
				}
			});
			USscrollPane.setViewportView(UStable);
			UStable.setRowHeight(30);
			UStable.setFont(new Font("Serif", Font.PLAIN, 15));
			
			UStable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID", "NAME", "PRICE", "STOCK"
					}
				));
			UStable.setRowHeight(30);
			UStable.setFont(new Font("Serif", Font.PLAIN, 15));
			
			DefaultTableCellRenderer stringRenderer2 = (DefaultTableCellRenderer)
					UStable.getDefaultRenderer(String.class);
			UStable.getDefaultRenderer(Integer.class);
			
			stringRenderer2.setHorizontalAlignment(SwingConstants.CENTER);
			
			USSEARCH = new JTextField();
			USSEARCH.setToolTipText("SEARCH");
			USSEARCH.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {

					try {
						
						
						String val = USSEARCH.getText().trim();
						String query ="Select ID,ItemNumber,NAME,PRICE,STOCK from PRODUCT where Name like '%"+val+"%'";
						
						pst =conn.prepareStatement(query);
						//pst.setString(1, Search.getText());
						
						rs = pst.executeQuery();
						//ResultSet rss = pst.executeQuery();
						
						
						UStable.setModel(DbUtils.resultSetToTableModel(rs));
						
						
						
						//JOptionPane.showMessageDialog(null, "Saved Successfully");
						rs.close();
						pst.close();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					finally{
						try{
						rs.close();
						pst.close();

						}
						catch(Exception e){
						}
						}
				}
			});
			USSEARCH.setFont(new Font("Serif", Font.PLAIN, 30));
			USSEARCH.setColumns(10);
			USSEARCH.setBounds(841, 12, 234, 50);
			UpdateStockPanel.add(USSEARCH);
			
			UStextField = new JTextField();
			
			UStextField.setToolTipText("UPDATE");
			UStextField.setFont(new Font("Serif", Font.PLAIN, 30));
			UStextField.setColumns(10);
			UStextField.setBounds(841, 425, 234, 50);
			UpdateStockPanel.add(UStextField);
			
			
			USlabel.setHorizontalAlignment(SwingConstants.CENTER);
			USlabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
			USlabel.setBackground(Color.WHITE);
			USlabel.setBounds(838, 269, 237, 55);
			UpdateStockPanel.add(USlabel);
			
			JButton btnUpdate = new JButton("UPDATE");
			
			btnUpdate.setFont(new Font("Serif", Font.PLAIN, 15));
			btnUpdate.setBounds(854, 508, 208, 67);
			UpdateStockPanel.add(btnUpdate);
			JPanel ChangeItemPricePanel = new JPanel();
			
			JLabel lblItem = new JLabel("");
			lblItem.setHorizontalAlignment(SwingConstants.CENTER);
			lblItem.setBackground(Color.WHITE);
			ChangeItemPricePanel.setVisible(false);
			
			ChangeItemPricePanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "CHANGE ITEM PRICE", TitledBorder.LEADING, TitledBorder.ABOVE_BOTTOM, null, new Color(0, 0, 0)));
			ChangeItemPricePanel.setVisible(false);
			ChangeItemPricePanel.setBounds(0, 0, 1087, 682);
			MainPanel.add(ChangeItemPricePanel);
			ChangeItemPricePanel.setLayout(null);
			
			JScrollPane CIPscrollPane = new JScrollPane();
			CIPscrollPane.setBounds(12, 12, 808, 644);
			ChangeItemPricePanel.add(CIPscrollPane);
			
			CIPtable = new JTable();
			CIPtable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					int row = CIPtable.getSelectedRow();
					String Tableclick =(CIPtable.getModel().getValueAt(row, 1).toString());
					
					lblItem.setText(Tableclick);
					
					
				}
			});
			CIPscrollPane.setViewportView(CIPtable);
			CIPtable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "NAME", "PRICE"
				}
			));
			CIPtable.setRowHeight(30);
			CIPtable.setFont(new Font("Serif", Font.PLAIN, 15));
			
			
			DefaultTableCellRenderer stringRenderer1 = (DefaultTableCellRenderer)
				     CIPtable.getDefaultRenderer(String.class);
			CIPtable.getDefaultRenderer(Integer.class);
			
			CIPSEARCH = new JTextField();
			CIPSEARCH.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					
					
					try {
						
						
						String val = CIPSEARCH.getText().trim();
						String query ="Select ID,ItemNumber,NAME,PRICE,STOCK from PRODUCT where Name like '%"+val+"%'";
						
						pst =conn.prepareStatement(query);
						//pst.setString(1, Search.getText());
						
						rs = pst.executeQuery();
						//ResultSet rss = pst.executeQuery();
						
						
						CIPtable.setModel(DbUtils.resultSetToTableModel(rs));
						
						
						
						//JOptionPane.showMessageDialog(null, "Saved Successfully");
						rs.close();
						pst.close();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					finally{
						try{
						rs.close();
						pst.close();

						}
						catch(Exception e){
						}
						}
					
				}
			});
			CIPSEARCH.setFont(new Font("Serif", Font.PLAIN, 30));
			CIPSEARCH.setColumns(10);
			CIPSEARCH.setBounds(841, 12, 234, 50);
			ChangeItemPricePanel.add(CIPSEARCH);
			
			
			lblItem.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
			lblItem.setBounds(838, 196, 237, 55);
			ChangeItemPricePanel.add(lblItem);
			
			CIPtxtPrice = new JTextField();
			CIPtxtPrice.setFont(new Font("Serif", Font.PLAIN, 30));
			CIPtxtPrice.setColumns(10);
			CIPtxtPrice.setBounds(832, 313, 234, 50);
			ChangeItemPricePanel.add(CIPtxtPrice);
			
			JButton btnChangePrice = new JButton("CHANGE PRICE");
			
			//Change Price Button Event
			btnChangePrice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(JOptionPane.showConfirmDialog(contentPane, "Confirm if you want to Change Price of Item", "Sales System", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {

					if(lblItem!=null) {
						
						String sql ="Update Product Set Price=? where Name=?";
						
						
						
						try {
							//PreparedStatement pst = null;
							pst =conn.prepareStatement(sql);
							pst.setString(1, CIPtxtPrice.getText());
							pst.setString(2, lblItem.getText());
							

							pst.execute();
							
							//JOptionPane.showMessageDialog(null, "Update Successful");
							pst.close();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						finally{
							try{
							rs.close();
							pst.close();

							}
							catch(Exception e){
							}
							}
						
					}
					
					
					lblItem.setText(null);
					CIPtxtPrice.setText(null);
					CIPSEARCH.setText(null);
					}
					
				}
			});
			btnChangePrice.setFont(new Font("Serif", Font.PLAIN, 15));
			btnChangePrice.setBounds(841, 410, 208, 67);
			ChangeItemPricePanel.add(btnChangePrice);
			
			stringRenderer21.setHorizontalAlignment(SwingConstants.CENTER);
			stringRenderer1.setHorizontalAlignment(SwingConstants.CENTER);
		
		stringRenderer1.setHorizontalAlignment(SwingConstants.CENTER);
		
		RemoveItemsPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "REMOVE ITEMS", TitledBorder.LEADING, TitledBorder.ABOVE_BOTTOM, null, new Color(0, 0, 0)));
		RemoveItemsPanel.setBounds(0, 0, 1087, 682);
		MainPanel.add(RemoveItemsPanel);
		RemoveItemsPanel.setLayout(null);
		
		RItextField = new JTextField();
		RItextField.setEditable(false);
		RItextField.setHorizontalAlignment(SwingConstants.CENTER);
		RItextField.setBounds(897, 186, 147, 50);
		RItextField.setFont(new Font("Serif", Font.PLAIN, 30));
		RItextField.setColumns(10);
		RemoveItemsPanel.add(RItextField);
		
		JButton RIbtnDelete = new JButton("DELETE");
		RIbtnDelete.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e1) {
				
				int key = e1.getKeyCode();
				if(key == KeyEvent.VK_ENTER) {
				
				if(JOptionPane.showConfirmDialog(contentPane, "Confirm if you want to delete", "Sales System", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {

					
					
					 String slsa= "DELETE FROM Product WHERE ID=?";
			            
			            try {
			            	int i = Integer.parseInt(RItextField.getText());
			            	PreparedStatement pst  = conn.prepareStatement(slsa);
							pst.setInt(1,i );
							pst.executeUpdate();
							
							
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			            
			            finally{
			            	try{
			            	rs.close();
			            	pst.close();

			            	}
			            	catch(Exception e){
			            	}
			            	}
			            
			            RItextField.setText(null);
			            RISearch.setText(null);
			            
			            
					}
				}
			}
		});
		//Delete Button Event
		RIbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(JOptionPane.showConfirmDialog(contentPane, "Confirm if you want to delete", "Sales System", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {

				
				
				 String slsa= "DELETE FROM Product WHERE ID=?";
		            
		            try {
		            	int i = Integer.parseInt(RItextField.getText());
		            	PreparedStatement pst  = conn.prepareStatement(slsa);
						pst.setInt(1,i );
						pst.executeUpdate();
						
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		            finally{
		            	try{
		            	rs.close();
		            	pst.close();

		            	}
		            	catch(Exception e){
		            	}
		            	}
		            
		            RItextField.setText(null);
		            RISearch.setText(null);
		            
		            
				}
				
			}
		});
		RIbtnDelete.setBounds(867, 265, 208, 67);
		RIbtnDelete.setFont(new Font("Serif", Font.PLAIN, 15));
		RemoveItemsPanel.add(RIbtnDelete);
		
		JLabel lblItemId = new JLabel("ITEM ID");
		lblItemId.setBounds(897, 116, 147, 42);
		lblItemId.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemId.setFont(new Font("Serif", Font.PLAIN, 39));
		RemoveItemsPanel.add(lblItemId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 810, 647);
		RemoveItemsPanel.add(scrollPane);
		
		RItable = new JTable();
		RItable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int row = RItable.getSelectedRow();
				String Tableclick =(RItable.getModel().getValueAt(row, 0).toString());
				
				RItextField.setText(Tableclick);
				RIbtnDelete.requestFocus();
				
			}
		});
		scrollPane.setViewportView(RItable);
		RItable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NAME"
			}
		));
		
		
		RItable.setRowHeight(30);
		RItable.setFont(new Font("Serif", Font.PLAIN, 15));
		
		RISearch = new JTextField();
		RISearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				//String sql ="Select ID, NAME from Product where Name=?";
				
				
				
				try {
					
					
					String val = RISearch.getText().trim();
					String query ="Select ID,ItemNumber,NAME,PRICE,STOCK from PRODUCT where Name like '%"+val+"%'";
					
					pst =conn.prepareStatement(query);
					//pst.setString(1, Search.getText());
					
					rs = pst.executeQuery();
					//ResultSet rss = pst.executeQuery();
					
					
					RItable.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					//JOptionPane.showMessageDialog(null, "Saved Successfully");
					rs.close();
					pst.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				finally{
					try{
					rs.close();
					pst.close();

					}
					catch(Exception e){
					}
					}
				
			}
		});
		RISearch.setFont(new Font("Serif", Font.PLAIN, 30));
		RISearch.setColumns(10);
		RISearch.setBounds(841, 12, 234, 50);
		RemoveItemsPanel.add(RISearch);
		//table.setBorder(new MatteBorder(1, 5, 1, 1, (Color) new Color(0, 51, 102)));
		DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer)
			     RItable.getDefaultRenderer(String.class);
		RItable.getDefaultRenderer(Integer.class);
		
		stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnAddItem = new JButton("ADD NEW ITEM");
		btnAddItem.setFont(new Font("Serif", Font.PLAIN, 15));
		
		
		JButton btnRemoveItem = new JButton("REMOVE ITEM");
		btnRemoveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ViewDailySalesPanel.setVisible(false);
				UpdateStockPanel.setVisible(false);
				ViewStockPanel.setVisible(false);
				ChangeItemPricePanel.setVisible(false);
				AddItemsPanel.setVisible(false);
				RemoveItemsPanel.setVisible(true);
				
				
				if(conn != null) {
					String sql ="SELECT ID,ItemNumber,NAME FROM Product";
					
					try {
						pst = conn.prepareStatement(sql);
						rs = pst.executeQuery();
						RItable.setModel(DbUtils.resultSetToTableModel(rs));
						

						}
					
					
					catch (Exception e2) {
						// TODO: handle exception
						//JOptionPane.showMessageDialog(null, e2);
						System.out.println(e2);
					}
					finally{
						try{
						rs.close();
						pst.close();

						}
						catch(Exception e){
						}
						}
				
				
					RItextField.setText(null);	
				
			}
				
				
				
				
				
				
			}
		});
		btnRemoveItem.setFont(new Font("Serif", Font.PLAIN, 15));
		
		JButton btnChangeItemPrice = new JButton("CHANGE ITEM PRICE");
		btnChangeItemPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				ViewDailySalesPanel.setVisible(false);
				UpdateStockPanel.setVisible(false);
				ViewStockPanel.setVisible(false);
				ChangeItemPricePanel.setVisible(true);
				AddItemsPanel.setVisible(false);
				RemoveItemsPanel.setVisible(false);
				
				
				
				
				
				if(conn != null) {
					String sql ="SELECT ID,ItemNumber,NAME,PRICE,STOCK FROM Product";
					
					try {
						pst = conn.prepareStatement(sql);
						rs = pst.executeQuery();
						CIPtable.setModel(DbUtils.resultSetToTableModel(rs));
						

						}
					
					
					catch (Exception e2) {
						// TODO: handle exception
						//JOptionPane.showMessageDialog(null, e2);
						System.out.println(e2);
					}
					finally{
						try{
						rs.close();
						pst.close();

						}
						catch(Exception e){
						}
						}
				
				
				
			}
				
				
				
				
				
				
			}
		});
		btnChangeItemPrice.setFont(new Font("Serif", Font.PLAIN, 15));
		
		JButton btnViewStock = new JButton("VIEW STOCK");
		btnViewStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ViewDailySalesPanel.setVisible(false);
				UpdateStockPanel.setVisible(false);
				ViewStockPanel.setVisible(true);
				ChangeItemPricePanel.setVisible(false);
				AddItemsPanel.setVisible(false);
				RemoveItemsPanel.setVisible(false);
				
				
				if(conn != null) {
					String sql ="SELECT ID,ItemNumber,NAME,PRICE,STOCK FROM Product";
					
					try {
						pst = conn.prepareStatement(sql);
						rs = pst.executeQuery();
						VStable.setModel(DbUtils.resultSetToTableModel(rs));
						

						}
					
					
					catch (Exception e2) {
						// TODO: handle exception
						//JOptionPane.showMessageDialog(null, e2);
						System.out.println(e2);
					}
					finally{
						try{
						rs.close();
						pst.close();

						}
						catch(Exception e){
						}
						}
				
				
				
			}
				
			}
		});
		btnViewStock.setFont(new Font("Serif", Font.PLAIN, 15));
		
		JButton btnUpdateStock = new JButton("UPDATE STOCK");
		btnUpdateStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ViewDailySalesPanel.setVisible(false);
				UpdateStockPanel.setVisible(true);
				ViewStockPanel.setVisible(false);
				ChangeItemPricePanel.setVisible(false);
				AddItemsPanel.setVisible(false);
				RemoveItemsPanel.setVisible(false);
				USlabel.setText(null);
				UStextField.setText(null);
				USSEARCH.setText(null);
				
				
				if(conn != null) {
					String sql ="SELECT ID,NAME,PRICE,STOCK FROM Product";
					
					try {
						pst = conn.prepareStatement(sql);
						rs = pst.executeQuery();
						UStable.setModel(DbUtils.resultSetToTableModel(rs));
						

						}
					
					
					catch (Exception e2) {
						// TODO: handle exception
						//JOptionPane.showMessageDialog(null, e2);
						System.out.println(e2);
					}
					finally{
						try{
						rs.close();
						pst.close();

						}
						catch(Exception e){
						}
						}
				
				
				
			}
				
			}
		});
		btnUpdateStock.setFont(new Font("Serif", Font.PLAIN, 15));
		
		JButton btnViewDailySales = new JButton("VIEW DAILY SALES");
		btnViewDailySales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ViewDailySalesPanel.setVisible(true);
				UpdateStockPanel.setVisible(false);
				ViewStockPanel.setVisible(false);
				ChangeItemPricePanel.setVisible(false);
				AddItemsPanel.setVisible(false);
				RemoveItemsPanel.setVisible(false);
				if(conn != null) {
					String sql ="SELECT DATE,TOTAL FROM DAILYSALES";
					
					try {
						pst = conn.prepareStatement(sql);
						rs = pst.executeQuery();
						VDStable.setModel(DbUtils.resultSetToTableModel(rs));
						

						}
					
					
					catch (Exception e2) {
						// TODO: handle exception
						//JOptionPane.showMessageDialog(null, e2);
						System.out.println(e2);
					}
					finally{
						try{
						rs.close();
						pst.close();

						}
						catch(Exception e){
						}
						}
				
				
				
			}
				
			}
		});
		btnViewDailySales.setFont(new Font("Serif", Font.PLAIN, 15));
		GroupLayout gl_Controlpanel = new GroupLayout(Controlpanel);
		gl_Controlpanel.setHorizontalGroup(
			gl_Controlpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Controlpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Controlpanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddItem, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnViewDailySales, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdateStock, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnViewStock, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChangeItemPrice, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemoveItem, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_Controlpanel.setVerticalGroup(
			gl_Controlpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Controlpanel.createSequentialGroup()
					.addGap(29)
					.addComponent(btnAddItem, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(btnRemoveItem, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnChangeItemPrice, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(btnViewStock, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(btnUpdateStock, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(btnViewDailySales, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		
		
		
		
		
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			AddItemsPanel.setVisible(true);	
			
			ViewDailySalesPanel.setVisible(false);
			UpdateStockPanel.setVisible(false);
			ViewStockPanel.setVisible(false);
			ChangeItemPricePanel.setVisible(false);
			
			RemoveItemsPanel.setVisible(false);
		
				
				
			}
		});
	
		//Update Stock Action Event
			
		UStextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String name=USlabel.getText();
				String num=UStextField.getText();
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER) {
					
					if(num.contentEquals("")) {
						JOptionPane.showMessageDialog(null, "Update UnSuccessful");
					}
					else {
						String sql ="Update Product Set Stock=? where Name=?";
						
						
						try {
							//PreparedStatement pst = null;
							pst =conn.prepareStatement(sql);
							pst.setString(1, UStextField.getText());
							pst.setString(2, USlabel.getText());
							

							pst.execute();
							
							//JOptionPane.showMessageDialog(null, "Update Successful");
							pst.close();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						finally{
							try{
							rs.close();
							pst.close();

							}
							catch(Exception e1){
							}
							
						
					}
					
					
					USlabel.setText(null);
					UStextField.setText(null);
					USSEARCH.setText(null);
					
					}
					}
				}
			
		});
		
		
		//Update Stock Action Event
		
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=USlabel.getText();
				String num=UStextField.getText();
				
					
					if(num.contentEquals("")) {
						JOptionPane.showMessageDialog(null, "Update UnSuccessful");
					}
					else {
						String sql ="Update Product Set Stock=? where Name=?";
						
						
						try {
							//PreparedStatement pst = null;
							pst =conn.prepareStatement(sql);
							pst.setString(1, UStextField.getText());
							pst.setString(2, USlabel.getText());
							

							pst.execute();
							
							//JOptionPane.showMessageDialog(null, "Update Successful");
							pst.close();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						finally{
							try{
							rs.close();
							pst.close();

							}
							catch(Exception e1){
							}
							
						
					}
					
					
					USlabel.setText(null);
					UStextField.setText(null);
					USSEARCH.setText(null);
					
					
					}
				
			}
		});
		
		
		
		Controlpanel.setLayout(gl_Controlpanel);
		contentPane.setLayout(gl_contentPane);
		
	}
}
