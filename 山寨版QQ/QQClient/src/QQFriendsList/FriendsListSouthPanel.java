package QQFriendsList;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FriendsListSouthPanel {
	//�²����ȷ�һ��JLabel
	JLabel south_jl = null;
	
	public FriendsListSouthPanel(JPanel jp3) {
		south_jl = new JLabel("test");
		south_jl.setPreferredSize(new Dimension(350,40));
		jp3.add(south_jl);
	}
}
