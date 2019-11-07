package mainGui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import service.*;

public class client {
	private JFrame jFrame = new JFrame("邮件发送");
    private Container c = jFrame.getContentPane();
    private JLabel l1=new JLabel("Email:");
    private JLabel l2=new JLabel("Subject:");
    private JLabel l3=new JLabel("Context:");
    private JButton b1=new JButton("Check");
    private JButton b2=new JButton("Send");
    private JButton b3=new JButton("Clear");
    private JTextField t1=new JTextField();
    private JTextField t2=new JTextField();
    private JTextArea t3=new JTextArea();
    JScrollPane js=new JScrollPane(t3);
    
    public client() {
        jFrame.setBounds(600, 200, 500, 400);
        c.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        jFrame.setVisible(true);
    }
	
	public void init()
	 {
		 l1.setBounds(30, 50, 40, 30);
		 l2.setBounds(30, 100, 50, 30);
		 l3.setBounds(30, 150, 50, 30);
		 b1.setBounds(380, 50, 80, 30);
		 b2.setBounds(380, 100, 80, 30);
		 b3.setBounds(380, 200, 80, 30);
		 t1.setBounds(80, 50, 280, 30);
		 t2.setBounds(80, 100, 280, 30);
		 //t3.setBounds(80, 150, 280, 150);
		 t1.setText("1513924418@qq.com,2272001335@qq.com");
		 t2.setText("---主题---");
		 t3.setText("---正文---");
		 js.setBounds(80, 150, 280, 150);
		 js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		 jFrame.add(b1);
		 jFrame.add(b2);
		 jFrame.add(b3);
		 jFrame.add(t1);
		 jFrame.add(t2);
		 //jFrame.add(t3);
		 jFrame.add(js);
		 jFrame.add(l1);
		 jFrame.add(l2);
		 jFrame.add(l3);
		 b1.addActionListener(new ActionListener(){
		    	 public void actionPerformed(ActionEvent e){
		    		 String str=t1.getSelectedText();
		    		 //String[] s=new String[]{str};
		    		 System.out.println(str);
		    		 WebserviceImplService f=new WebserviceImplService();
		    		 WebserviceImpl w=f.getWebserviceImplPort();
		    		 boolean b=w.validateEmailAddress(str);
		    		 if(b) {
		    			 JOptionPane.showMessageDialog(null, "邮件地址格式正确！");
		    		 }
		    	 }
		 });
		 
		 b2.addActionListener(new ActionListener(){
	    	 public void actionPerformed(ActionEvent e){
	    		 String Str1=t1.getText();
	    		 String Str2=t2.getText();
	    		 String Str3=t3.getText();
	    		 System.out.println(Str1);
	    		 System.out.println(Str2);
	    		 System.out.println(Str3);
	    		 WebserviceImplService f=new WebserviceImplService();
	    		 WebserviceImpl w=f.getWebserviceImplPort();
	    		 String[] strArr = Str1.split(",");
	    		 List<String> l=Arrays.asList(strArr);
	    		 w.sendEmailBatch(l, Str2, Str3);
	    		 JOptionPane.showMessageDialog(null, "发送成功！");
	    	 }
		 });
		 
		 b3.addActionListener(new ActionListener(){
	    	 public void actionPerformed(ActionEvent e){
	    		 t1.setText(null);
	    		 t2.setText(null);
	    		 t3.setText(null);
	    	 }
		 });
	 }
	 

	public static void main(String[] args) {
		new client();        //创建窗口
	}

}

