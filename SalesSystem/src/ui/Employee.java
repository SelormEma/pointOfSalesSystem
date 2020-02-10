package ui;

import java.awt.Dimension;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.Size2DSyntax;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.ComponentOrientation;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;

import java.awt.SystemColor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenu;
import javax.swing.JMenuItem;



@SuppressWarnings("serial")
public class Employee extends JFrame {

	String tot,p,chkstock,name;
	private JTextField txtSearch;
	public JPanel contentPane;
	//private JTextField textField;
	Connection conn;
	PreparedStatement pst,ps;
	ResultSet rs,rst;
	private DefaultListModel<String> mode;
	double amountpaid;
	int price,quantity,n;
	float change,amount,iniamt,value;
	double balance=0;
	float total;
	public JTextArea ReceiptArea = new JTextArea();
	JList<String> list = new JList<String>();
	private JTextField txtamount;
	private JTextField txtquantity;
	public ArrayList <String> sam=  new ArrayList<String>();
	int it = 0;
	int qty = 0;
	String []arritem = new String[100];
	int []arrqty = new int[100];
	 int maxsize = 10;
	LocalDate date = LocalDate.now();
	String curdate = date.toString();
	LocalDateTime mydate = LocalDateTime.now();
	DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	String formatteddate = mydate.format(dtformat);
	
	
	LocalDateTime mydates = LocalDateTime.now();
	DateTimeFormatter dtformats = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String formatteddates = mydates.format(dtformats);
	
	
	float dailytot;	
	Double dbtotal;
	String dbtoday;
	
	
//	public float dailysales(float dailytot) {
//		
//		dailytot= total;
//		
//		float dailytot1=+dailytot;
//		
//		return dailytot1;
//		
//	}
	
	Welcome a= new Welcome();
	String ab=a.usname;
	
	//Abbreviate String Method
	public  String abbreviateString(String input) {
		if(input.length()<=7) {
			int a= 7-input.length();
			String prod = null;
			for(int i=1;i<=a;i++) {
				 prod =input+".";
			}
			return prod;
		}
		else {
			//return (input.substring(0, maxsize)).trim() +"\n";
			return (input.trim()+"\n"+"\t");
		}
	}
	
	 static private PrintRequestAttributeSet attr;
	 private JTextField textField;

	    

	    

	    static public void print(final Printable printable) {
	        print(printable, true);
	    }

	    static public void print(final Printable printable, final boolean portrait) {
	        print(printable, portrait, new Insets(10, 10, 10, 10));
	    }

	    static public void print(final Printable printable, final boolean portrait, final Insets insets) {
	        PrinterJob pjob = PrinterJob.getPrinterJob();
	        pjob.setPrintable(printable);
	        // create an attribute set to store attributes from the print dialog
	        if (attr == null) {
	            attr = new HashPrintRequestAttributeSet();
	            float leftMargin = insets.left;
	            float rightMargin = insets.right;
	            float topMargin = insets.top;
	            float bottomMargin = insets.bottom;
	            if (portrait) {
	                attr.add(OrientationRequested.PORTRAIT);
	            } else {
	                attr.add(OrientationRequested.LANDSCAPE);
	                leftMargin = insets.top;
	                rightMargin = insets.bottom;
	                topMargin = insets.right;
	                bottomMargin = insets.left;
	            }
	            attr.add(MediaSizeName.ISO_A7);
	            MediaSize mediaSize = MediaSize.ISO.A5;
	            float mediaWidth = mediaSize.getX(Size2DSyntax.MM);
	            float mediaHeight = mediaSize.getY(Size2DSyntax.MM);
	            attr.add(new MediaPrintableArea(
	                    leftMargin, topMargin,
	                    (mediaWidth - leftMargin - rightMargin),
	                    (mediaHeight-15 - topMargin - bottomMargin), Size2DSyntax.MM));
	        }
//	        if (pjob.printDialog(attr)) {
	            try {
	                pjob.print(attr);
	            } catch (PrinterException ex) {
	                ex.printStackTrace();
	            }
//	        }
	    }
	 
	 
	 
	 
	 
	 
	 

	//Font font = new Font();
	
	
	//Title Method
	public void Title() {
		
		
		ReceiptArea.setBackground(SystemColor.inactiveCaptionBorder);
		ReceiptArea.append("\t"+"ABROKWAH VENTURES"+"\n"+"\t"+
				
				"KASOA, NEXT TO SHANKIKI"+"\n"+"\t"+
				"0276289600 / 0548550553"+"\n"+"\t"+"\t"+ "RECEIPT"+"\n"+
				"Product\tQuantity\tPrice\tAmount"+
				//"Item   "+"\t"+"Quantity"+"\t"+"Price"+"\t"+"Total"+"\n"+
				"\n");
	}
	
	//Powered By Method
	public void PoweredBy() {
		

		
		ReceiptArea.append("DATE	"+formatteddate+"\n"+" Powered by SamTec--0276289600"+"\n");
	}

	//public Employee
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Employee frame = new Employee();
					frame.setVisible(true);
					
					UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
					//UIManager.setLookAndFeel("com.pagosoft.plaf.PgsLookAndFeel");
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
	 */
	@SuppressWarnings({ "unused" })
	public Employee() {
		
		
		

		
		
		setResizable(false);

		
		//initComponents();
		//txtSearch.setRequestFocusEnabled(true);
		
//		try {
//			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
		ReceiptArea.setTabSize(5);
		ReceiptArea.setBackground(Color.WHITE);
		ReceiptArea.setEditable(false);
		ReceiptArea.setRows(10);
		ReceiptArea.setColumns(10);
		ReceiptArea.setLineWrap(true);
		//ReceiptArea.setWrapStyleWord(true);
		ReceiptArea.setMargin(new Insets(20, 20, 0, 20));
		
		//ReceiptArea.setAutoscrolls(true);
		Title();
		conn = SqlConnection.Conn();
		//conn=SqlServerConnection.Conns();
		mode=new DefaultListModel<String>();
		
		
		list.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		
		list.setVisible(false);
		list.setModel(mode);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		int h =(int) screen.getHeight();
		int w = (int) screen.getWidth();
		
		
		
		System.out.println(curdate);
		
//		try {
//			String sql = "Insert Into DailySales(Date,total)values(?,?)";
//			pst = conn.prepareStatement(sql);
//			pst.setString(1, curdate);
//			pst.setString(2, dailytot+"");
//			pst.execute();
//			pst.close();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("MenuBar.background"));
		setJMenuBar(menuBar);
		
		JLabel EmployeeNameLabel = new JLabel("New label");
		EmployeeNameLabel.setText("");
		EmployeeNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//set menu bar item to right
		menuBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JMenu mnNewMenu = new JMenu("Enter Customer Name");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.add(textField);
		textField.setColumns(15);
		//textField.setBounds(0, 0, 279, 67);
		menuBar.add(EmployeeNameLabel);
		menuBar.setPreferredSize(new Dimension(100,25));
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Table.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Panel.darkBackground"));
		
		
		
		
		JLabel lblAmount = new JLabel("AMOUNT:");
		lblAmount.setForeground(new Color(0, 0, 0));
		lblAmount.setFont(new Font("Serif", Font.BOLD, 26));
		

		
		txtamount = new JTextField();
		
		
		txtamount.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtamount.setText("0.00");
		amount=(float) Double.parseDouble(txtamount.getText());
		
		txtamount.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtamount.setColumns(10);
		
		JLabel lblBalance = new JLabel("BALANCE:");
		lblBalance.setForeground(new Color(0, 0, 0));
		lblBalance.setFont(new Font("Serif", Font.BOLD, 26));
		
		JTextPane textPanebalance = new JTextPane();
		textPanebalance.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textPanebalance.setEditable(false);
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Panel.darkBackground"));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JScrollPane ReceiptscrollPane = new JScrollPane();
		ReceiptscrollPane.setBounds(17, 11, 326, 448);
		ReceiptscrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		ReceiptscrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		ReceiptscrollPane.setViewportView(ReceiptArea);
		ReceiptArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setBounds(58, 541, 276, 159);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setForeground(Color.BLACK);
		lblImage.setFont(new Font("Serif", Font.BOLD, 19));
		
		
		
		JScrollPane listscrollPane = new JScrollPane();
		listscrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
	
		
		listscrollPane.setViewportView(list);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSearch.setColumns(10);
		
		txtquantity = new JTextField();
		txtquantity.setHorizontalAlignment(SwingConstants.TRAILING);
		txtquantity.setText("1");
		
		txtquantity.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtquantity.setColumns(10);
		
		JButton btnPrint = new JButton("PRINT RECEIPT");
		btnPrint.setForeground(new Color(51, 204, 255));
		btnPrint.setBackground(new Color(255, 255, 255));
		btnPrint.setVisible(false);
		
		//JTextArea textArea = new JTextArea();
		JTextPane textPanetotal = new JTextPane();
		textPanetotal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textPanetotal.setEditable(false);
		
		
		JLabel lblNewLabel = new JLabel("TOTAL:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 26));
		
	btnPrint.setFont(new Font("Serif", Font.BOLD, 24));
		
		
		
		JButton btnTotal = new JButton("TOTAL");
		
		
		btnTotal.setBackground(new Color(255, 255, 255));
		btnTotal.setForeground(new Color(51, 204, 255));
		
		btnTotal.setFont(new Font("Serif", Font.BOLD, 24));
		btnTotal.setVisible(false);
		
		
		
		
		
		JButton btnClearAll = new JButton("CLEAR ALL");
		
		
		
		btnClearAll.setForeground(new Color(51, 204, 255));
		btnClearAll.setFont(new Font("Serif", Font.BOLD, 24));
		btnClearAll.setBackground(new Color(255, 255, 255));
		
		
		
		
		
		//Amount action event
				txtamount.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						txtamount.selectAll();
					}
				});
				
		
		
		//CLEAR ALL ACTION EVENT
		btnClearAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtSearch.setText(null);
				textField.setText(null);
				txtamount.setText("0.00");
				txtquantity.setText("1");
				textPanebalance.setText("0.00");
				textPanetotal.setText("0.00");
				ReceiptArea.setText(null);
				list.setSelectedIndex(0);
				txtSearch.requestFocus();
				total=0;
				Title();
				
			}
		});
		
		
		/// Clear All Key Pressed Event
				btnClearAll.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						int key = arg0.getKeyCode();
						if(key == KeyEvent.VK_ENTER) {
						total=0;
						txtSearch.setText(null);
						txtamount.setText("0.00");
						txtquantity.setText("1");
						textPanebalance.setText("0.00");
						textPanetotal.setText("0.00");
						ReceiptArea.setText(null);
						list.setSelectedIndex(0);
						txtSearch.requestFocus();
						
						
						Title();
						}
						
					}
				});
		
		
		//set search bar action
				txtSearch.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						try {
							mode.removeAllElements();
							String val = txtSearch.getText().trim();
						String query ="Select * from PRODUCT where Name like '%"+val+"%'";
						pst = conn.prepareStatement(query);
						rs=pst.executeQuery();
						
						if(!(val=="")) {
							list.setVisible(true);

							while(rs.next()) {
								
								 name= rs.getString("Name");
								// System.out.println(name);
								mode.addElement(name);
								list.setSelectedIndex(0);
								//comboBox.addItem(rs.getString("Name"));
								
								
							}
							
							pst.close();
							rs.close();
						}
						else {
							list.setVisible(true);

							while(rs.next()) {
								
								
								 name= rs.getString("");
								mode.addElement(name);
								list.setSelectedIndex(0);
								//comboBox.addItem(rs.getString("Name"));
								
								
							}
							
							pst.close();
							rs.close();
						}
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
							//comboBox.setSelectedItem(textField.getText());
							
							//System.out.println(comboBox.toString());
						
						
						finally{
							try{
							rs.close();
							pst.close();

							}
							catch(Exception e){
							}
							}
					
					}
					@Override
					public void keyTyped(KeyEvent e) {
						
						char ch = e.getKeyChar();
						
						char dot = '.';
						if((Character.isDigit(ch))) {
							
							
							e.consume();
							}
						
					}
				});
				
				//String selitem = list.getSelectedValue();
				txtSearch.addKeyListener(new KeyAdapter() {
					@Override
					
					
					
					
					public void keyPressed(KeyEvent e) {
						
						
						
						
						
						int key = e.getKeyCode();
						if(key == KeyEvent.VK_ENTER) {
							
							try {
								
								
								
								ps = conn.prepareStatement("Select Price from PRODUCT where Name=?");
								ps.setString(1, list.getSelectedValue());
								ResultSet rst=ps.executeQuery();
								value = rst.getFloat("Price");
								
//								p=rst.getString("Price").trim();
//								k = Double.parseDouble(p);
								
								rst.close();
								ps.close();
								
								ps = conn.prepareStatement("Select Stock from Product where Name=?");
								ps.setString(1, list.getSelectedValue());
								rst=ps.executeQuery();
								
								String chkstock = rst.getString("Stock");
								System.out.println("Current Stock of "+list.getSelectedValue()+"  is "+ chkstock);
								rst.close();
								ps.close();
								
								
								
								
							} catch (Exception e1) {
								
								// TODO: handle exception
							}
							
							finally{
								try{
									
								rst.close();
								ps.close();

								}
								catch(Exception e2){
								}
								}
							
//							sam.add(" "+list.getSelectedValue()+"\t"+"\t"+txtquantity.getText()+"\t"+"\t"+p+"\n");
//							ReceiptArea.append(sam.get(n));
//							n++;
							//sam.clear();
							
							String cont2 = ReceiptArea.getText();
							if(!cont2.contains(list.getSelectedValue())) {
							quantity=Integer.parseInt(txtquantity.getText());
							//init = (float) (quantity*Double.parseDouble(p));
							
							if(quantity>(Integer.parseInt(chkstock))) {
								
								JOptionPane.showMessageDialog(null, list.getSelectedValue()+" In Stock : "+ chkstock);
								
							}
							else {
							iniamt = (quantity*value);
							total+= iniamt;
							if(list.getSelectedValue()!=null) {
								String a = abbreviateString(list.getSelectedValue())+"\t"+"\t"+txtquantity.getText()+"\t"+value+"\t"+iniamt+"\n";
								ReceiptArea.append(a);
							//ReceiptArea.append(list.getSelectedValue()+"\t"+"\t"+txtquantity.getText()+"\t"+"\t"+value+"\t"+iniamt+"\n");
							textPanetotal.setText(""+total);
							arritem[it]=list.getSelectedValue();
							arrqty[qty]=Integer.parseInt(txtquantity.getText());
							it++;
							qty++;
							
							txtSearch.setText(null);
							
							}
							else {
								JOptionPane.showMessageDialog(null, "Nothing selected");
							}
							}
							}
							else {
								JOptionPane.showMessageDialog(null, "You have selected the item already"+"\n"+ "You must use the quantity field");
							}
						}
//						if(e.getKeyCode()==40) {
//							textField.setFocusable(false);
//						}
//						else if(e.getKeyCode()==38) {
//							textField.setFocusable(true);
//						}
						
						if(e.getKeyCode()==39) {
							txtquantity.requestFocus();
							txtquantity.selectAll();
						}
						if(e.getKeyCode()==40) {
							list.requestFocus();
							
						}
						
						
					}
				});
		
				
				// list key action listener
				list.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
//						if(list.getSelectedIndex()>-1) {
//						
//							try {
//								String sel = list.getSelectedValue();
//								String sql = "Select ItemImage from Product where Name="+sel+"";
//								pst = conn.prepareStatement(sql);
//								rs= pst.executeQuery();
//								
//								if(rs.next()) {
//									//DisplayMemImage.setIcon(format);
//									byte[] imagedatasi = rs.getBytes("ItemImage");
//									
//									ImageIcon formatsasi = new ImageIcon(imagedatasi);
//									
//									Image imgs = formatsasi.getImage();
//				
//									Image newImg = imgs.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
//									
//									 formatsasi = new ImageIcon(newImg);
//									 
//									 lblImage.setIcon(formatsasi);
//								}
//							} catch (SQLException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							
//						}
						int key = e.getKeyCode();
						if(key == KeyEvent.VK_ENTER) {
							
							
							try {
								
								pst = conn.prepareStatement("Select Price from Product where Name=?");
								pst.setString(1, list.getSelectedValue());
								rs=pst.executeQuery();
							
								
								value = rs.getFloat("Price");
//								p=rs.getString("Price").trim();
//								k = Double.parseDouble(p);

								//System.out.println(p);
								rs.close();
								pst.close();
								
								pst = conn.prepareStatement("Select Stock from Product where Name=?");
								pst.setString(1, list.getSelectedValue());
								rs=pst.executeQuery();
								
								 chkstock = rs.getString("Stock");
								System.out.println("Current Stock of "+list.getSelectedValue()+"  is "+ chkstock);
								rs.close();
								pst.close();
								
								
							} catch (Exception e1) {
								
								// TODO: handle exception
							}
							
							finally{
								try{
									//rs=null;
								rs.close();
								pst.close();

								}
								catch(Exception e2){
								}
								}
							
							//ReceiptArea.append(" "+list.getSelectedValue()+"\t"+"\t"+txtquantity.getText()+"\t"+"\t"+p+"\n");
//							sam.add(" "+list.getSelectedValue()+"\t"+"\t"+txtquantity.getText()+"\t"+"\t"+p+"\n");
//							ReceiptArea.append(sam.get(n));
//							n++;
							//sam.clear();
							//txtSearch.setText(null);
							//textPanetotal.setText(""+total);
							
							
							String cont1 = ReceiptArea.getText();
							if(!cont1.contains(list.getSelectedValue())) {
							quantity=Integer.parseInt(txtquantity.getText());
							//init = (float) (quantity*Double.parseDouble(p));
							//total+=quantity*Double.parseDouble(p);

							if(quantity>(Integer.parseInt(chkstock))) {
								
								JOptionPane.showMessageDialog(null, list.getSelectedValue()+" In Stock : "+ chkstock);
								
							}
							else {
							
							iniamt = (quantity*value);
							total+= iniamt;
							
							if(list.getSelectedValue()!=null) {
								String a = abbreviateString(list.getSelectedValue())+"\t"+"\t"+txtquantity.getText()+"\t"+value+"\t"+iniamt+"\n";
								ReceiptArea.append(a);
								//ReceiptArea.append(list.getSelectedValue()+"\t"+"\t"+txtquantity.getText()+"\t"+"\t"+value+"\t"+iniamt+"\n");
								textPanetotal.setText(""+total);
								arritem[it]=list.getSelectedValue();
								arrqty[qty]=Integer.parseInt(txtquantity.getText());
								it++;
								qty++;
								txtSearch.setText(null);
								
								}
								else {
									JOptionPane.showMessageDialog(null, "Nothing selected");
								}
							}
							}
							else {
								
								JOptionPane.showMessageDialog(null, "You have selected the item already"+"\n"+ "You must use the quantity field");
								
							}
							
							
							
						}
						int key1 = e.getKeyCode();
						if(key1 == KeyEvent.VK_LEFT) {
							txtSearch.requestFocus();
							txtSearch.selectAll();
						}
						int key11 = e.getKeyCode();
						if(key11 == KeyEvent.VK_RIGHT) {
							txtquantity.requestFocus();
							txtquantity.selectAll();
							
						}
					}
				});
				
				
				
				//total button event
				btnTotal.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
					
						tot=""+total;
						
						textPanetotal.setText(tot);
						ReceiptArea.append("------------------------------"+"\n");
						ReceiptArea.append("Total:"+"\t"+"\t"+"\t"+tot+"\n"
								+"Amt Paid:"+"\t"+"\t"+"\t"+txtamount.getText().trim()+"\n"
								+"Change:"+"\t"+"\t"+"\t"+textPanebalance.getText()+"\n"+"Purchased by "+textField.getText().trim()+"\n");
						
						PoweredBy();
					}
				});
							
				
				
				//Print Action event
				btnPrint.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
//						MessageFormat header = new MessageFormat("");
//						MessageFormat footer = new MessageFormat("Page{0,number,integer}");
						
						print(ReceiptArea.getPrintable(null,null));
						//ReceiptArea.print();
//							textPane.print(headerFormat, footerFormat, boolean showPrintDialog, 
//								     PrintService service, PrintRequestAttributeSet attributes, boolean interactive);
//							ReceiptArea.print(header, footer, false, 
//								     null, null, false); 
						
//						MessageFormat header = new MessageFormat(" Stock on "+ formatteddate);
//						MessageFormat footer = new MessageFormat(" Page {0,number,integer}            Whatever");
//						     try {
//						         PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
//						         set.add(OrientationRequested.PORTRAIT);
//						         ReceiptArea.print(JTable.PrintMode.FIT_WIDTH, header, footer, false, set, false);
//						         JOptionPane.showMessageDialog(null, "\n" + "JTable was Successfully "
//						                + "\n" + "Printed on your Default Printer");
//						     } catch (java.awt.print.PrinterException e) {
////						         JOptionPane.showMessageDialog(null, "\n" + "Error from Printer Job "
////						                + "\n" + e); 
//						    	 //JOptionPane.showMessageDialog(null,"Contact Admin");
//						     }

					}
				});
								
				
				
				
				
				
				//QUANTITY TEXTFIELD ACTION EVENT
				
				txtquantity.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						
						
						int key = e.getKeyCode();
						if(key == KeyEvent.VK_ENTER) {
							
							try {
								
								ps = conn.prepareStatement("Select Price from PRODUCT where Name=?");
								ps.setString(1, list.getSelectedValue());
							ResultSet rst=ps.executeQuery();
							
							value = rst.getFloat("Price");
//								p=rst.getString("Price").trim();
//								k = Double.parseDouble(p);

								rst.close();
								ps.close();
								
								
								ps = conn.prepareStatement("Select Stock from Product where Name=?");
								ps.setString(1, list.getSelectedValue());
								rst=ps.executeQuery();
								
								 chkstock = rst.getString("Stock");
									System.out.println("Current Stock of "+list.getSelectedValue()+"  is "+ chkstock);
								rst.close();
								ps.close();
								
								
								
								
							} catch (Exception e1) {
								
								// TODO: handle exception
							}
							
							finally{
								try{
									
								rst.close();
								ps.close();

								}
								catch(Exception e2){
								}
								}
							
							//ReceiptArea.append(" "+list.getSelectedValue()+"\t"+"\t"+txtquantity.getText()+"\t"+"\t"+p+"\n");
//							sam.add(" "+list.getSelectedValue()+"\t"+"\t"+txtquantity.getText()+"\t"+"\t"+p+"\n");
//							ReceiptArea.append(sam.get(0));
//							n++;
							//sam.clear();
							//txtSearch.setText(null);
							//txtquantity.setText("1");
							//textPanetotal.setText(""+total);
							
							String cont = ReceiptArea.getText();
							if(!cont.contains(list.getSelectedValue())) {
							quantity=Integer.parseInt(txtquantity.getText());
							if(quantity>(Integer.parseInt(chkstock))) {
								
								JOptionPane.showMessageDialog(null, list.getSelectedValue()+" In Stock : "+ chkstock);
								
							}
							else {
								
								//init = (float) (quantity*Double.parseDouble(p));
								//total+=quantity*Double.parseDouble(p);
								iniamt = quantity*value;
								total+= iniamt;
								
								if(list.getSelectedValue()!=null) {
									String a = abbreviateString(list.getSelectedValue())+"\t"+"\t"+txtquantity.getText()+"\t"+value+"\t"+iniamt+"\n";
									ReceiptArea.append(a);
									//ReceiptArea.append(list.getSelectedValue()+"\t"+"\t"+txtquantity.getText()+"\t"+"\t"+value+"\t"+iniamt+"\n");
									textPanetotal.setText(""+total);
									arritem[it]=list.getSelectedValue();
									arrqty[qty]=Integer.parseInt(txtquantity.getText());
									it++;
									qty++;
									txtSearch.setText(null);
									
									txtquantity.setText("1");
									
									
									}
									else {
										JOptionPane.showMessageDialog(null, "Nothing selected");
									}
								
							}}
							else{
								JOptionPane.showMessageDialog(null, "You have selected the item already"+"\n"+ "You must use the quantity field");
							}
							
						}
//						if(e.getKeyCode()==40) {
//							textField.setFocusable(false);
//						}
//						else if(e.getKeyCode()==38) {
//							textField.setFocusable(true);
//						}
						
						
						
						
						if(e.getKeyCode()==40) {
							list.requestFocus();
							txtquantity.setText("1");
						}
						
						if(e.getKeyChar()=='s'||e.getKeyChar()=='S') {
							
							txtSearch.requestFocus();
							txtquantity.setText("1");
							
						}
						
						if(e.getKeyChar()=='l'||e.getKeyChar()=='L') {
							
							list.requestFocus();
							txtquantity.setText("1");
							
						}
					}
					@Override
					public void keyTyped(KeyEvent e) {
						
						char ch = e.getKeyChar();
						
						char dot = '.';
						if((!Character.isDigit(ch))) {
							
							
							e.consume();
							}
					}
				});
				
					
								//Amount text field events
								
								txtamount.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent arg0) {
										
										txtamount.selectAll();
										if(txtamount.isCursorSet()) {
											txtamount.selectAll();
										}
										
										
									}
								});
								
								
								txtamount.addKeyListener(new KeyAdapter() {
								
									@Override
									
									public void keyReleased(KeyEvent arg0) {
										 amountpaid =Double.parseDouble(txtamount.getText()); 
										balance=amountpaid-total;
										
										String bal=""+balance;
										textPanebalance.setText(bal);
										list.setSelectedIndex(0);
									}
									
									
									
									//@Override
									@Override
									public void keyPressed(KeyEvent arg0) {
										
										int key = arg0.getKeyCode();
										if(key == KeyEvent.VK_ENTER) {
											if(amountpaid>=total) {
												dailytot =dailytot +total;
												System.out.println("dailytot = "+dailytot);
											for(int m=0;m<qty;m++) {
												String ite = arritem[m];
												
												try {
													
													ps = conn.prepareStatement("Select Stock from PRODUCT where Name=?");
													ps.setString(1, ite);
													ResultSet rst=ps.executeQuery();
												
													int stock=rst.getInt("Stock");
													
													System.out.println(ite+" "+ stock);
													stock= stock - arrqty[m];
													
													String sql ="Update Product Set Stock=? where Name=?";
													
													try {
														//PreparedStatement pst = null;
														pst =conn.prepareStatement(sql);
														pst.setInt(1, stock);
														pst.setString(2, ite);
														pst.executeUpdate();
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
												
													System.out.println(ite+" "+ stock);
													rst.close();
													ps.close();
													
													
												} catch (Exception e1) {
													
													// TODO: handle exception
												}
												
												finally{
													try{
														
													rst.close();
													ps.close();

													}
													catch(Exception e2){
													}
													}
												
											}
											
											
											it=0;
											qty=0;
											
											


//											for(ActionListener a: btnTotal.getActionListeners()) {
//									        	   a.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
//									           }
											
//											tot=""+total;
//											
//											textPanetotal.setText(tot);
//											ReceiptArea.append("--------------------------------------"+"\n");
//											ReceiptArea.append("Total:"+"\t"+"\t"+"\t"+tot+"\n"
//													+"Amt Paid:"+"\t"+"\t"+txtamount.getText().trim()+"\n"
//													+"Change:"+"\t"+"\t"+"\t"+textPanebalance.getText()+"\n");
//											
//											PoweredBy();
											
											for(ActionListener c: btnTotal.getActionListeners()) {
									        	   c.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
									           }
											
											for(ActionListener b: btnPrint.getActionListeners()) {
									        	   b.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
									           }
											
											arritem=null;
											
											try {
												
												PreparedStatement pst = conn.prepareStatement("SELECT TODAY FROM DailySales where DATE=?");
												pst.setString(1, curdate);
												ResultSet rs = pst.executeQuery();
												
												int count =0;
												if(rs.next()) {
													 dbtoday =  rs.getString("TODAY");
													
													System.out.println("Count == "+count);
													count++;
													System.out.println("Count == "+count);
												}
												
												if(count ==1) {
													try {
														PreparedStatement ps = conn.prepareStatement(
																"SELECT TOTAL FROM DailySales where DATE=?");
														ps.setString(1, curdate);
														ResultSet rsT = ps.executeQuery();
														String databasetotal = rsT.getString("TOTAL");
														System.out.println("Database total  = "+databasetotal);
														dbtotal = Double.parseDouble(databasetotal);
														rsT.close();
														ps.close();
													} catch (Exception e) {
														// TODO: handle exception
													}
													//JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL");
													String sql ="Update DailySales Set TOTAL=? where Date=?";
													
													
														//PreparedStatement pst = null;
														pst =conn.prepareStatement(sql);
														Double currtot = dbtotal + total;
														pst.setString(1, currtot+"");
														pst.setString(2, curdate);
														pst.executeUpdate();
														pst.close();
												}
												
												else if(count>1) {
													
													JOptionPane.showMessageDialog(null, " CONTACT ADMIN");
													
												}
												else {
													String sql ="Insert Into DailySales(Date,TOTAL)values(?,?)";
														
													PreparedStatement	ps =conn.prepareStatement(sql);
														ps.setString(1, curdate);
														ps.setString(2, dailytot+"");
														ps.execute();
														ps.close();
														
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
											
//											finally{
//												try{
									//
//												//pst.close();
//												ps.close();
									//
//												}
//												catch(Exception e){
//													e.printStackTrace();
//												}
//											}
											
											for(ActionListener c: btnClearAll.getActionListeners()) {
									        	   c.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
									           }
											btnClearAll.requestFocus();
											//total=0;
											
											
										}
											else {
												JOptionPane.showMessageDialog(null, "Amount Paid is Insufficient");
											}
										}
										
										
										
									}
									
									@Override
									
										public void keyTyped(KeyEvent e) {
											
											char ch = e.getKeyChar();
											
											char dot = '.';
											if((!Character.isDigit(ch)&&ch!=dot)) {
											
												e.consume();
												}
										
									}
								});
								
							
								

								//Method to display image for every item
								
								list.addListSelectionListener(new ListSelectionListener() {
									@Override
									public void valueChanged(ListSelectionEvent arg0) {
										if(list.hasFocus()) {
											
											try {
												pst = conn.prepareStatement("Select ItemImage from Product where Name=?");
												pst.setString(1, list.getSelectedValue());
												rs=pst.executeQuery();
												
												
												
												if(rs.next()) {
													//DisplayMemImage.setIcon(format);
													byte[] imagedatasi = rs.getBytes("ItemImage");
													
													ImageIcon formatsasi = new ImageIcon(imagedatasi);
													
													Image imgs = formatsasi.getImage();
								
													Image newImg = imgs.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
													
													 formatsasi = new ImageIcon(newImg);
													 
													 lblImage.setIcon(formatsasi);
												}
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												//e1.printStackTrace();
											}
											
											finally {
												try {
													rs.close();
													pst.close();
												} catch (Exception e) {
													// TODO: handle exception
												}
											}
											
										}
										
									}
								});
																
				
								//List Action Event
//								list.addListSelectionListener(new ListSelectionListener() {
//									public void valueChanged(ListSelectionEvent evt) {
//										
//									
//									if(evt.getValueIsAdjusting()==true) {
//										
//										if(list.getSelectedIndex()>=0) {
//											//String sel = list.getSelectedValue().trim();
//											//String sql = "Select ID from Product where Name="+sel+"";
//											try {
//												pst = conn.prepareStatement("Select ItemImage from Product where Name=?");
//												pst.setString(1, list.getSelectedValue());
//												rs=pst.executeQuery();
//												
//												
//												
//												if(rs.next()) {
//													//DisplayMemImage.setIcon(format);
//													byte[] imagedatasi = rs.getBytes("ItemImage");
//													
//													ImageIcon formatsasi = new ImageIcon(imagedatasi);
//													
//													Image imgs = formatsasi.getImage();
//								
//													Image newImg = imgs.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
//													
//													 formatsasi = new ImageIcon(newImg);
//													 
//													 lblImage.setIcon(formatsasi);
//												}
//											} catch (SQLException e1) {
//												// TODO Auto-generated catch block
//												e1.printStackTrace();
//											}
//											
//											finally {
//												try {
//													rs.close();
//													pst.close();
//												} catch (Exception e) {
//													// TODO: handle exception
//												}
//											}
//											
//										}
//										
//									}
//									
//										
//									}
//								});								
			
				
				//Select only one item in list
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				setExtendedState(MAXIMIZED_BOTH);
				setLocationRelativeTo(null);
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(880)
							.addComponent(txtquantity, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 881, GroupLayout.PREFERRED_SIZE)
						.addComponent(listscrollPane, GroupLayout.PREFERRED_SIZE, 965, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblAmount, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(txtamount, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addGap(275)
							.addComponent(btnClearAll, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(textPanetotal, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addGap(275)
							.addComponent(btnTotal, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblBalance)
							.addGap(60)
							.addComponent(textPanebalance, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addGap(239)
							.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtquantity, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
							.addComponent(listscrollPane, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAmount, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(txtamount, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnClearAll, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPanetotal, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(9)
									.addComponent(btnTotal, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(9)
									.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(9)
									.addComponent(textPanebalance, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
				);
				panel.setLayout(gl_panel);
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(39)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(5))
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
				panel_1.setLayout(null);
				panel_1.add(ReceiptscrollPane);
				panel_1.add(lblImage);
				contentPane.setLayout(gl_contentPane);
				
				
	}
}
	
	
	
	



