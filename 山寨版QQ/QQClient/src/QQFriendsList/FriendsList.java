package QQFriendsList;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class FriendsList extends JFrame{

	//����JFrame��Ϊ������
	JPanel jp1 = null, jp2 = null, jp3 =null;

	//�ϲ�
	FriendsListNorthPanel NorthPanel = null;
	
	//�в�
	FriendsListCenterPanel CenterPanel = null;
	
	//�²�
	FriendsListSouthPanel SouthPanel = null;

	

	public FriendsList(String Name) {

		//�ϲ�
		jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
		NorthPanel = new FriendsListNorthPanel(jp1);
		this.add(jp1, "North");		
		
		//�в�
		jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		CenterPanel = new FriendsListCenterPanel(jp2, Name); 
		this.add(jp2, "Center");			
		
		//�²�
		jp3 = new JPanel();
		SouthPanel = new FriendsListSouthPanel(jp3);		
		this.add(jp3,"South");
		
		this.setTitle(Name);
		this.setSize(380, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//���º����б�
	public void updateFriendslist(String friends[]) {
		
		CenterPanel.updateFriendslist(friends);
	}

}
