
/* It's a mini music player together with the GUI interface with lack of some options*/


import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
 
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends JFrame implements ActionListener {
	 
	//creating a button  

	JButton button1 = new JButton();
     JButton button2 = new JButton();
     JButton button3 = new JButton();
     JButton button4 = new JButton();

	
	 
	PlayList playlist = new PlayList();
	
	public MainFrame () {
	

      // adding an image for each button	 
	 ImageIcon play = new ImageIcon("pl.png");
     ImageIcon repeat = new ImageIcon("reload.png");
     ImageIcon insert = new ImageIcon("insert-1.png");
     ImageIcon shuffle = new ImageIcon("shuffle.png");

	 

	 button1.setBounds(25, 280, 10, 10);  // seting a boundery and setting the size of the button 
     button1.setIcon(play); // setting an icon
     button1.setBackground(Color.BLACK); // setting the background color
     button1.addActionListener(this); // setting an action listener to the button as it reaches the button
     button1.setBorderPainted(false); // setting the border 
     button2.setBounds(118, 280, 10, 10);
     button2.setIcon(repeat);
     button2.setBorderPainted(false);
     button2.addActionListener(this);
	 button2.setBackground(Color.BLACK);
     button3.setBounds(210, 280, 60, 50);
     button3.setIcon(shuffle);
     button3.setBorderPainted(false);
     button3.addActionListener(this);
	 button3.setBackground(Color.BLACK);
     button4.setBounds(300, 280, 60, 50);
     button4.setIcon(insert);
     button4.setBorderPainted(false);
     button4.addActionListener(this);
	 button4.addActionListener(this);
	 button4.setBackground(Color.BLACK);

	 ImageIcon image  = new ImageIcon("music.png");  // create an Image
	 this.setIconImage(image.getImage());  // change the icon on the frame
     this.getContentPane().setBackground(Color.BLACK);  // change the color of background
	 this.setTitle("Music player");  // sets title of frame
     

	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // exist out of application
     this.setResizable(false);  // prevent frame from being resized
     this.setSize(500,500);   // sets the dimension
     this.setVisible(true);   // makes frame visible

	 
	  

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		panel2.setBackground(Color.black);
		panel1.setBounds(0, 250, 500, 250);
		
		panel1.add(button1); 
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
	    
		panel1.setBounds(0,0,0,0);
		
		

		
		
		
        
		
	    
		
		this.add(panel2);
		
		this.add(panel1);
		
		
	}
	    // here starts the action that each button performs (play button, insert button, repeat and shuffle) (button1, button2, button3, button4)

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== button4) {
			JFileChooser fc = new JFileChooser();
			fc.setMultiSelectionEnabled(true);
			FileNameExtensionFilter filter = new FileNameExtensionFilter( "mp3 & wav Oudio Files . ", "mp3", "wav");
			fc.setFileFilter(filter);
			fc.setPreferredSize(new Dimension(500,500));
			
			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File[] files = fc.getSelectedFiles();
				for(File file : files) {
				    String absolutePath = file.getAbsolutePath();
				    System.out.println(absolutePath);
				    playlist.addToEnd(absolutePath);
				   
				    
				}
				
				
			}
			
		
	    }
		else if (e.getSource() == button1) { 
			System.out.println("clicked");
		}
		else if(e.getSource()==button2){
			System.out.print("repeated");
		}
		else if(e.getSource()==button3){
			System.out.print("Shuffled");
		}
	}
	
}
