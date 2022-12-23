import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SearchF extends JFrame{
	
	private JPanel p;
	private JTextArea area;
	private JLabel label;
	private Button button;
	private Button button2;
	private String s1;
	private JCheckBox c;
	private JLabel l;
	private JScrollPane scroll;
	private JPanel panel;
	private JLabel welcome;
	private JLabel quit;
	private JTextField textfield;
	private JButton sett;
	private JButton fonts;
	private JButton fontsy;
	private JButton fontsi;
	private JButton fontsc;
	private JButton bg;
	private JButton themes;
	private JButton permi;
	private JButton red;
	private JButton cyan;
	private JButton green;
	int xx,xy;
	

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchF frame = new SearchF();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public SearchF(){
		
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 170, 729, 476);
		
		
		 
		 p=new JPanel();
		p.setBackground(Color.white);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		
		
		panel=new JPanel(); 
		panel.setBackground(Color.gray);
		panel.setBounds(0, 0, 729, 70);
		p.add(panel);
		panel.setLayout(null);
		
		welcome=new JLabel("Rarepad"); 
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("Parry Hotter", Font.PLAIN, 25));
		welcome.setForeground(Color.black);
		welcome.setBounds(5, 15, 90, 27);
		panel.add(welcome);
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("uni6.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 l=new JLabel(new ImageIcon(img)); 
		l.setBounds(0, 70, 729, 406);
		l.grabFocus();
		p.add(l);
		
		area = new JTextArea();
		area.setBorder(BorderFactory.createLineBorder(Color.gray));
		area.setFont(new Font(Font.SERIF,Font.BOLD,17));
		area.setBounds(150, 80, 500, 300);
		area.setBackground(Color.cyan);
		p.add(area);
		area.setColumns(10);
		area.setVisible(false);
		
		 scroll = new JScrollPane(area);
        scroll.setBounds(150, 80, 500, 300);
        p.add(scroll);
        setLocationRelativeTo ( null );
        scroll.setVisible(false);
        

    	textfield = new JTextField();
		textfield.setBounds(150, 15, 500, 35);
		textfield.setBackground(Color.cyan);
		Border border = BorderFactory.createLineBorder(Color.black, 2);
		textfield.setBorder(border);
		textfield.setFont(new Font(Font.SERIF,Font.BOLD,17));
		textfield.addActionListener( textfieldSearch() );
		p.add(textfield);
		textfield.setColumns(10);
        
        JLabel label = new JLabel("");
        
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            SearchF.this.setLocation(x - xx, y - xy);  
			}
		});
		
		BufferedImage img2 = null;
		try {
			img2 = ImageIO.read(new File("setting.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		sett=new JButton(); 
		sett.setBounds(10, 100, 50, 50);
		Image dimg = img2.getScaledInstance(sett.getWidth(), sett.getHeight(),
		        Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		  sett.setIcon(imageIcon);
	      sett.grabFocus();
	      sett.setBackground(Color.white);
	      sett.setBorder(null);
	      sett.setVisible(true);
	      p.add(sett);
	      settingClick();
	    
	      fonts = new JButton("font");
	      fonts.setBounds(20, 155, 100, 20);
	      fonts.setBackground(Color.gray);
	      fonts.setForeground(Color.WHITE);
	      fonts.setVisible(false);
	      p.add(fonts);
	      fontClick();
	      
	      
	      fontsy = new JButton("font style");
	      fontsy.setBounds(30, 180, 100, 20);
	      fontsy.setBackground(Color.lightGray);
	      fontsy.setForeground(Color.WHITE);
	      fontsy.setVisible(false);
	      p.add(fontsy);
	      
	      fontsi = new JButton("font size");
	      fontsi.setBounds(30, 205, 100, 20);
	      fontsi.setBackground(Color.lightGray);
	      fontsi.setForeground(Color.WHITE);
	      fontsi.setVisible(false);
	      p.add(fontsi);
	      
	/*      JTextField fonttext1 = new JTextField();
  		fonttext1.setBounds(30, 205, 100, 20);
  		fonttext1.setBackground(Color.lightGray);
	      fonttext1.setForeground(Color.WHITE);
	      fonttext1.setVisible(false);
  		p.add(fonttext1);
  		
	      fontsi.addMouseListener(new MouseAdapter() {
	    	  
	    	  @Override
	    	public void mouseClicked(MouseEvent e) {
	    		fontsi.setVisible(false);
	    		fonttext1.setVisible(true);
	    		try{
	    			Font font = area.getFont();
	    		int a=Integer.parseInt(fonttext1.getText());
	    		area.setFont( font.deriveFont(a) );
	    		}
	    		catch(IllegalArgumentException e1)
	    		{
	    			
	    JOptionPane.showMessageDialog( p, "please enter font in numbers ","Done", JOptionPane.INFORMATION_MESSAGE); 

	    		}
	    	}
		});
	      */
	      fontsc = new JButton("font color");
	      fontsc.setBounds(30, 230, 100, 20);
	      fontsc.setBackground(Color.lightGray);
	      fontsc.setForeground(Color.WHITE);
	      fontsc.setVisible(false);
	      p.add(fontsc);
	      
	      
	      bg = new JButton("Image");
	      bg.setBounds(20, 180, 100, 20);
	      bg.setBackground(Color.gray);
	      bg.setForeground(Color.WHITE);
	      bg.setVisible(false);
	      p.add(bg);
	      ImageClick();
	     
	      
	      themes = new JButton("themes");
	      themes.setBounds(20, 205, 100, 20);
	      themes.setBackground(Color.gray);
	      themes.setForeground(Color.WHITE);
	      themes.setVisible(false);
	      p.add(themes);
	     /* 
	      themes.addMouseListener(new MouseAdapter(){

				@Override
				public void mouseClicked(MouseEvent k) {
					 boolean visible = red.isVisible();
					 if(visible){
						 boolean visible2 = fontsy.isVisible();
						 if(visible2==true){
							 permi.setBounds(20, 340, 100, 20);
							 c.setBounds(30, 365, 100, 20);
							 red.setVisible(true);
								cyan.setVisible(true);
								green.setVisible(true);
						 }
						 c.setBounds(30, 255, 100, 20);
						 permi.setBounds(20, 230, 100, 20);
						red.setVisible(false);
						cyan.setVisible(false);
						green.setVisible(false);
					 }
					 else{
						 permi.setBounds(20, 340, 100, 20);
						 c.setBounds(30, 365, 100, 20);
						 red.setVisible(true);
							cyan.setVisible(true);
							green.setVisible(true);
					 }
				}
				
			});*/
	      
	   /*   red = new JButton();
	      red.setBounds(30, 230, 30, 30);
	      red.setBackground(Color.red);
	      red.setVisible(false);
	      p.add(red);
	      
	      cyan = new JButton();
	      cyan.setBounds(60, 230, 30, 30);
	      cyan.setBackground(Color.cyan);
	      cyan.setVisible(false);
	      p.add(cyan);
	      
	      green = new JButton();
	      green.setBounds(90, 230, 30, 30);
	      green.setBackground(Color.green);
	      green.setVisible(false);
	      p.add(green);*/
	      
	    permi = new JButton("permission");
	    permi.setBounds(20, 230, 100, 20);
	    permi.setBackground(Color.gray);
	    permi.setForeground(Color.WHITE);
	    permi.setVisible(false);
	    p.add(permi);
	    permiClick();
	     
	    c = new JCheckBox("Read Only",false);
		c.setBounds(32, 255, 100, 20);
		c.setBackground(Color.lightGray);
		c.setForeground(Color.white);
		c.setVisible(false);
		p.add(c);
		checkBox();
		
		button2 = new Button("New");
		button2.setBackground(Color.gray);
		button2.setBounds(665, 100, 50, 30);
		p.add(button2);
		button2.setVisible(false);
		newClick();
		
		button = new Button("Save");
		button.setBackground(Color.gray);
		button.setBounds(665, 150, 50, 30);
		p.add(button);
		button.setVisible(false);
		saveClick();
	
		quit = new JLabel("X");
		quit.setHorizontalAlignment(SwingConstants.CENTER);
		quit.setForeground(Color.WHITE);
		quit.setFont(new Font("algeberian",Font.PLAIN,18));
		quit.setBounds(691, 0, 37, 27);
		panel.add(quit);
		quitClick();
		}
	
	Action textfieldSearch(){
		
		Action action = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				String x = null ;
				try{
				 x = textfield.getText();
				
				
				File f=new File("E:\\Study_Material\\Java\\Code\\javabasic");
				
				File arr[] = f.listFiles();
				
				if((s1=checkD(arr, x)).equals(null)){
					System.out.println("file not found");
				}
				else{
					area.setVisible(true);
					area.setText(null);
					scroll.setVisible(true);
					button.setVisible(true);
					l.setVisible(false);
					sett.setVisible(true);
					button2.setVisible(true);
					try(BufferedReader br = new BufferedReader(new FileReader(s1));){
						String d;
						while((d=br.readLine())!=null){
							area.append(d+"\n");
						}
						br.close();
					}
					catch (IOException e2) {
						e2.printStackTrace();
					}
				}
				}
				catch(NullPointerException ne){
JOptionPane.showMessageDialog( p, "error enter correct file name","error", JOptionPane.INFORMATION_MESSAGE); 

				}
			}
		};
		return action;
	
}
	String checkD(File[] arr, String x)  
    { 
		int k = 0;
		String s = null;
        for (File f : arr)
        	
        { 
        	 k=0;
           if(f.isFile())  {
               if(x.equals(f.getName())){
            	   k++;
            	   s=f.getAbsolutePath();
            	   break;
            	 }
           }
            else if(f.isDirectory())  
            {  
                System.out.println("directory : " + f.getName() ); 
                checkD(f.listFiles(),x); 
            } 
       } 
        if(k==0){
        	return null;
        }
        else{
        	return s;
        }
   
}

	void settingClick(){
		
		  sett.addMouseListener(new MouseAdapter(){

				@Override
				public void mouseClicked(MouseEvent k) {
					 boolean visible = fonts.isVisible();
					 if(visible){
						 fonts.setVisible(false);
						 fontsc.setVisible(false);
						 fontsi.setVisible(false);
						 fontsy.setVisible(false);
						 bg.setVisible(false);
						 themes.setVisible(false);
						 permi.setVisible(false);
						 c.setVisible(false);
						 
					 }
					 else{
						 fonts.setVisible(true);
						 bg.setBounds(20, 180, 100, 20);
						 themes.setBounds(20, 205, 100, 20);
						 permi.setBounds(20, 230, 100, 20);
						 c.setBounds(30, 255, 100, 20);
						 bg.setVisible(true);
						 themes.setVisible(true);
						 permi.setVisible(true);
					 }
				}
				
			});
	
	}
	
	void fontClick(){
		
		fonts.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent k) {
				 boolean visible = fontsy.isVisible();
				 if(visible){
					 bg.setBounds(20, 180, 100, 20);
					 themes.setBounds(20, 205, 100, 20);
					 permi.setBounds(20, 230, 100, 20);
					 c.setBounds(30, 255, 100, 20);
					 fontsy.setVisible(false);
					 fontsi.setVisible(false);
					 fontsc.setVisible(false);
				 }
				 else{
					bg.setBounds(20, 255, 100, 20);
					 themes.setBounds(20, 280, 100, 20);
					 permi.setBounds(20, 305, 100, 20);
					 c.setBounds(30, 330, 100, 20);
					 fontsy.setVisible(true);
					 fontsi.setVisible(true);
					 fontsc.setVisible(true);
				 }
			}
			
		});
	}

	
	void ImageClick(){
		
		 bg.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser jc = new JFileChooser();
					jc.setCurrentDirectory(new File("user.home"));
					FileNameExtensionFilter fc = new FileNameExtensionFilter("*.images", "jpg","png");
					jc.addChoosableFileFilter(fc);
					int re = jc.showSaveDialog(null);
					if(re==JFileChooser.APPROVE_OPTION){
						File selected = jc.getSelectedFile();
						String path = selected.getAbsolutePath();
						
						l.setIcon(null);
			            
						BufferedImage img4 = null;
						try {
							img4 = ImageIO.read(new File(path));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 l=new JLabel(new ImageIcon(img4)); 
						l.setBounds(0, 70, 729, 406);
						l.grabFocus();
						p.add(l);
					}
					
				}
			});
	}
	
	void permiClick(){
		 permi.addMouseListener(new MouseAdapter(){

				@Override
				public void mouseClicked(MouseEvent k) {
					 boolean visible = c.isVisible();
					 if(visible){
						
						 c.setVisible(false);
					 }
					 else{
						
						 c.setVisible(true);
					 }
				}
				
			});
	}
	void checkBox(){
		c.addItemListener(new ItemListener() {
		      public void itemStateChanged(ItemEvent e) {
		        if(c.isSelected()){
		        	button.setEnabled(false);
		        	area.setEditable(false);
		        }
		        else{
		        	button.setEnabled(true);
		        	area.setEditable(true);
		        }
		      }
		    });
	}
 

void newClick(){
	button2.addMouseListener(new MouseAdapter(){

		@Override
		public void mouseClicked(MouseEvent arg0) {
			area.setText(null);
			textfield.setText(null);
			
			
					JFrame par = new JFrame();
					 
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("save your file");   
					 
					int userSelection = fileChooser.showSaveDialog(par);
					 
					if (userSelection == JFileChooser.APPROVE_OPTION) {
					    File fileToSave = fileChooser.getSelectedFile();
					    s1=fileToSave.getAbsolutePath();
					
	JOptionPane.showMessageDialog( p, "your file is successfully created in "+fileToSave.getAbsolutePath(),"Done", JOptionPane.INFORMATION_MESSAGE); 
					}		
}
	});
}

void saveClick(){
	
	button.addMouseListener(new MouseAdapter(){

		@Override
		public void mouseClicked(MouseEvent arg0) {
			String s=area.getText();
			try(BufferedWriter wr = new BufferedWriter(new FileWriter(s1));){
				wr.write(s);
				wr.close();
JOptionPane.showMessageDialog( p, "your edit is successfully saved","Done", JOptionPane.INFORMATION_MESSAGE); 
			}
			catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	});
}

void quitClick(){
	quit.addMouseListener(new MouseAdapter(){

		@Override
		public void mouseClicked(MouseEvent arg0) {
			System.exit(0);
		}
		
	});
}
}
