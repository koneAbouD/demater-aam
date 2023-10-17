package africa.box.dm.service.signature;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.stream.FileImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.sun.jna.*;


/**
 * @author GiraffeTree
 * @date 2019/10/25
 */
public class signture {

    public interface JnaLibrary extends Library {

     
        JnaLibrary INSTANCE = Native.load("FP430S", JnaLibrary.class);
        int USB_Open();
        int USB_Close();
        int Lib_GetSignature(int encryptType,byte c[], int timeout);
    }

    static JFrame window;
	static JButton open;
	static JButton signature;
	static JButton close;
	Image myImage;
	static ImageIcon icon=new ImageIcon();
	static JButton button = new JButton();    
	public static void main(String[] args) {
//		Demo();

	}

	 static void Demo() {


			  window=new JFrame("签名�?");
			  window.setLayout(null);
			  window.setSize(1000,800);//设置大小 window.setLocationRelativeTo(null);//设置居中
			  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  window.setResizable(false);//设置窗口不可拉伸改变大小 //设置按钮

			  open=new JButton("open");
			  open.setBounds(150, 50, 100, 50);
			  signature=new JButton("signature");
			  signature.setBounds(250, 50, 100, 50);
			  close=new JButton("close");
			  close.setBounds(350, 50, 100, 50);

			  window.add(open);
			  window.add(signature);
			  window.add(close);

			  open.addActionListener(new openListener());
			  signature.addActionListener(new displayListener());
			  close.addActionListener(new closeListener());





			window.setVisible(true);//设置面板可见
	}


	static class openListener implements ActionListener{
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	int i = JnaLibrary.INSTANCE.USB_Open();
				
	        }
	    }
	static class displayListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        	 new signture.PrintThread().start();
        	
        	//System.out.println("signature"+i);
        	
			       
        	}
    }
	static class closeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	
        	 int i = JnaLibrary.INSTANCE.USB_Close();
        	System.out.println("close"+i);
        }
    }

	public static void createFile(String path,String filename){
        File file=new File(path+"/"+filename);
        
        if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        else {
        	try {
        		file.delete();
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

	 public static void byte2image(byte[] data,String path){
		    if(data.length<3||path.equals("")) return;//判断输入的byte是否为空
		    try{
		    FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
		    imageOutput.write(data, 0, data.length);//将byte写入硬盘
		    imageOutput.close();
		    System.out.println("Make Picture success,Please find image in " + path);
		    } catch(Exception ex) {
		      System.out.println("Exception: " + ex);
		      ex.printStackTrace();
		    }
		  }

	 static  class PrintThread extends Thread {
		 public void run() {  
			 byte c[] = new byte[2048000];
	        	int i = JnaLibrary.INSTANCE.Lib_GetSignature(0,c,60000);
	        	
	        	if(i==0) {
	        		//System.out.println("signature"+i+Arrays.toString(c));
	        		int a1=(int) c[0]*256*256+(int) c[1]*256+(int) c[2];
	        		int a2=(int) c[3]*256*256+(int) c[4]*256+(int) c[5];
	        		byte b[] = new byte[2048000];
	        		System.arraycopy(c,a1+6,b,0,a2);
					
					  String writePath="C:\\DEMATER\\signature";
					  createFile(writePath,"test.png"); 
					  FileOutputStream fos; 
					  byte2image(b,writePath+"\\test.png");
					 
					 
					 System.out.println("signature"+i+"---"+a1+"---"+a2);
	        			
	        	}
	        	
	        	  Image image=Toolkit.getDefaultToolkit().getImage("C:\\DEMATER\\signature\\test.png");
				  icon.setImage(image); 
				  
				  button.setIcon(icon);
				  button.setBounds(150, 100, 480, 217);
				  window.getContentPane().add(button);
				  
				  window.setVisible(true);//设置面板可见
		    }  
	 }
}
