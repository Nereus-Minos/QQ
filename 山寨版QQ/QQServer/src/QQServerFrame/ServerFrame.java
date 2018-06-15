package QQServerFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import QQModel.*;

public class ServerFrame extends JFrame implements ActionListener{
	
	ServerStartThread ServerStartThread = null;
	
	JPanel jp = null;
	JButton jb1 = null, jb2 = null;
	
	public static void main(String[] arg0) {
		ServerFrame ServerFrame = new ServerFrame();
	}
	
	public ServerFrame() {
		
		jp = new JPanel();
		jb1 = new JButton("����������");
		jb1.addActionListener(this);
		jb1.setActionCommand("����������");
		jb2 = new JButton("�رշ�����");
		jb2.addActionListener(this);
		jb2.setActionCommand("�رշ�����");
		
		jp.add(jb1);
		jp.add(jb2);
		this.add(jp);
		
		this.setSize(550, 420);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("����������")) {
			
			if(null == ServerStartThread)
				ServerStartThread = new ServerStartThread();
	
		}
		
		if(arg0.getActionCommand().equals("�رշ�����")) {
			
			System.exit(0);
			
		}
	}
	
}
