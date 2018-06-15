package QQFriendsList;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

import QQChat.ChatFrame;
import QQModel.ChatFrameHashMap;

public class FriendsListCenterPanel implements MouseListener{
	
	JLabel []firends = null;
	
	JLabel []blacklist = null;
	
	//������ʾ˭��˭����
	String name = null;
	
	CardLayout cl;
//	//�в����ȷ�һ��ѡ�����,���ĸ�JPanel
	JTabbedPane center_jtp = null;
	JPanel center_jp1 = null, center_jp2 = null, center_jp3 = null, center_jp4 =null;
		//	center_jp1Ϊ�����б���CardLayout�����ĸ�JPanel��friends�ͺ������������б���������JPanel
	JPanel center_friends_jp = null, center_blacklist_jp = null, center_fold_jp = null;
			//center_friends_jp�з�����JPanel
	JPanel center_friends_center_jp = null, center_friends_north_jp = null, center_friends_south_jp = null;
				//center_friends_north_jp��center_friends_south_jp����һ��JLabel
	JLabel center_friends_north_jl = null, center_friends_south_jl = null;
				//center_friends_center_jp��n��JLabel,�Ժ�Ҫ�����ݿ��л��
	JScrollPane center_friends_js = null;
	JButton center_friends_jb = null;
	Vector<JLabel> center_friends_jls = null;
		
			//center_blacklist_jp�з�����JPanel
	JPanel center_blacklist_center_jp = null, center_blacklist_north_jp = null, center_blacklist_south_jp = null;
				//center_blacklist_north_jp��center_blacklist_center_jp����һ��JLabel
	JLabel center_blacklist_north_jl = null, center_blacklist_center_jl = null;
				//center_blacklist_center_jp��n��JLabel,�Ժ�Ҫ�����ݿ��л��
	JScrollPane center_blacklist_js = null;
	JButton center_blacklist_jb = null;
	Vector<JLabel> center_blacklist_jls = null;
	
			//center_fold_jp������JLabel
	JLabel center_fold_jp_jl1 = null, center_fold_jp_jl2 = null;
	
	public FriendsListCenterPanel(JPanel jp2, String Name) {
		
		this.name = Name;
		
		center_jtp = new JTabbedPane();
		center_jp1 = new JPanel();
		center_jp2 = new JPanel();
		center_jp3 = new JPanel();
		center_jp4 = new JPanel();
		
		
		//������
		center_friends_jp = new JPanel();
		center_friends_jp.setLayout(new BorderLayout());
		
		center_friends_center_jp = new JPanel(new GridLayout(10,1,4,0));
		center_friends_north_jp = new JPanel();
		center_friends_north_jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		center_friends_south_jp = new JPanel();
		center_friends_south_jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		//center_friends_north_jp��center_friends_south_jp����һ��JLabel
		center_friends_north_jl = new JLabel("friends",new ImageIcon("Image/friendslist/jiantou.jpg"),JLabel.LEFT);
		center_friends_south_jl = new JLabel("blacklist",new ImageIcon("Image/friendslist/jiantou.jpg"),JLabel.LEFT);
		
		
		
		/*center_friends_center_jp*/
		firends=new JLabel[10];
		
		for(int i = 0; i <firends.length; i++) {	
			firends[i] = new JLabel(i+1+"",new ImageIcon("Image/friendslist/touxiang.jpg"),JLabel.LEFT);
			firends[i].setPreferredSize(new Dimension(360,71));
			firends[i].setOpaque(true);
			
			firends[i].setEnabled(false);
			
			//�������
			firends[i].addMouseListener(this);
			center_friends_center_jp.add(firends[i]);
		}
		
		center_friends_js = new JScrollPane(center_friends_center_jp);
		center_friends_js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		center_friends_js.setPreferredSize(new Dimension(360,360));  //����üӲ�Ȼ��������С�������Ĵ�С������û�й���Ч��
		
		center_friends_jp.add(center_friends_js,"Center");
		/*center_friends_center_jp*/
		
		
		
		/*center_friends_north_jp*/
		center_friends_north_jl.addMouseListener(this);
		center_friends_north_jl.setPreferredSize(new Dimension(350,25));
		center_friends_north_jl.setOpaque(true);
		center_friends_north_jp.add(center_friends_north_jl);
		center_friends_north_jp.setPreferredSize(new Dimension(0, 30));
		center_friends_jp.add(center_friends_north_jp,"North");
		/*center_friends_north_jp*/
		
		/*center_friends_south_jp*/	
		center_friends_south_jl.addMouseListener(this);
		center_friends_south_jl.setPreferredSize(new Dimension(350,25));
		center_friends_south_jl.setOpaque(true);
		center_friends_south_jp.add(center_friends_south_jl);
		center_friends_south_jp.setPreferredSize(new Dimension(0, 25));
		center_friends_jp.add(center_friends_south_jp,"South");
		/*center_friends_south_jp*/
		
		
		//��������
		center_blacklist_jp = new JPanel();
		center_blacklist_jp.setLayout(new BorderLayout());
		
		center_blacklist_south_jp = new JPanel(new GridLayout(10,1,4,0));
		center_blacklist_north_jp = new JPanel();
		center_blacklist_north_jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		center_blacklist_center_jp = new JPanel();
		center_blacklist_center_jp.setLayout(new FlowLayout(FlowLayout.LEFT));
		//center_friends_north_jp��center_friends_center_jp����һ��JLabel
		center_blacklist_north_jl = new JLabel("friends",new ImageIcon("Image/friendslist/jiantou.jpg"),JLabel.LEFT);
		center_blacklist_center_jl = new JLabel("blacklist",new ImageIcon("Image/friendslist/jiantou.jpg"),JLabel.LEFT);
		
		/*center_friends_center_jp*/
		blacklist=new JLabel[10];
		for(int i = 0; i <blacklist.length; i++) {	
			blacklist[i] = new JLabel(i+1+"",new ImageIcon("Image/friendslist/blacklist.jpg"),JLabel.LEFT);
			blacklist[i].setPreferredSize(new Dimension(360,71));
			blacklist[i].setOpaque(true);
			//�������
			blacklist[i].addMouseListener(this);
			center_blacklist_south_jp.add(blacklist[i]);
		}
		center_blacklist_js = new JScrollPane(center_blacklist_south_jp);
		center_blacklist_js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		center_blacklist_js.setPreferredSize(new Dimension(360,360));  //����üӲ�Ȼ��������С�������Ĵ�С������û�й���Ч��
		
		center_blacklist_jp.add(center_blacklist_js,"South");
		/*center_friends_center_jp*/
		
		/*center_friends_north_jp*/
		center_blacklist_north_jl.addMouseListener(this);
		center_blacklist_north_jl.setPreferredSize(new Dimension(350,25));
		center_blacklist_north_jl.setOpaque(true);
		center_blacklist_north_jp.add(center_blacklist_north_jl);
		center_blacklist_north_jp.setPreferredSize(new Dimension(0, 30));
		center_blacklist_jp.add(center_blacklist_north_jp,"North");
		/*center_friends_north_jp*/
		
		/*center_friends_center_jp*/	
		center_blacklist_center_jl.addMouseListener(this);
		center_blacklist_center_jl.setPreferredSize(new Dimension(350,25));
		center_blacklist_center_jl.setOpaque(true);
		center_blacklist_center_jp.add(center_blacklist_center_jl);
		center_blacklist_center_jp.setPreferredSize(new Dimension(0, 25));
		center_blacklist_jp.add(center_blacklist_center_jp,"Center");
		/*center_friends_south_jp*/
		
		
		//�۵��б�
		//center_fold_jp1��center_fold_jp2�ֱ������JPanel������ֱ��һ��JLabel
		center_fold_jp = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		center_fold_jp_jl1 = new JLabel("friends",new ImageIcon("Image/friendslist/jiantou.jpg"),JLabel.LEFT);
		center_fold_jp_jl1.addMouseListener(this);
		center_fold_jp_jl1.setOpaque(true);
		center_fold_jp_jl1.setPreferredSize(new Dimension(350,25));
		center_fold_jp_jl2 = new JLabel("blacklist",new ImageIcon("Image/friendslist/jiantou.jpg"),JLabel.LEFT);
		center_fold_jp_jl2.addMouseListener(this);
		center_fold_jp_jl2.setOpaque(true);
		center_fold_jp_jl2.setPreferredSize(new Dimension(350,25));
		center_fold_jp.add(center_fold_jp_jl1);
		center_fold_jp.add(center_fold_jp_jl2);
	
		
		/*center_jp1���óɿ�Ƭ����*/
		cl = new CardLayout();
		center_jp1.setLayout(cl);			
		center_jp1.add(center_friends_jp, "1");
		center_jp1.add(center_blacklist_jp, "2");				
		center_jp1.add(center_fold_jp, "3");
		
		
		center_jtp.setFont(new Font("����",Font.BOLD,16));
		center_jtp.add("����",center_jp1 );
		center_jtp.add("�����¼",center_jp2 );
		center_jtp.add("Ⱥ��",center_jp3 );
		center_jtp.add("�ռ�",center_jp4 );
		
		jp2.add(center_jtp);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==center_friends_south_jl)
		{
			cl.show(center_jp1,"2");
		}else if(arg0.getSource()==center_friends_north_jl)
		{
			cl.show(center_jp1, "3");
		}else if(arg0.getSource()==center_blacklist_north_jl)
		{
			cl.show(center_jp1, "1");
		}else if(arg0.getSource()==center_blacklist_center_jl)
		{
			cl.show(center_jp1, "3");
		}else if(arg0.getSource()==center_fold_jp_jl1)
		{
			cl.show(center_jp1, "1");
		}else if(arg0.getSource()==center_fold_jp_jl2)
		{
			cl.show(center_jp1, "2");
		}
		//˫��������Ի���
		else if(arg0.getClickCount()==2)  //��ʾ˫��
		{
			//�õ��ú��ѵı��
			String friendname=((JLabel)arg0.getSource()).getText();
	
				ChatFrame chat = new ChatFrame(name, friendname);
				
				//��chat���뵽HashMap��
				ChatFrameHashMap.addChatFrame(name+friendname, chat);

		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel temporary_jl=(JLabel)arg0.getSource();
		temporary_jl.setBackground(new Color(180,168,181));
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel temporary_jl=(JLabel)arg0.getSource();
		temporary_jl.setBackground(null);
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	//���º����б�
	public void updateFriendslist(String friends[]) {
		
		for(int i = 0; i < friends.length; i++) {
			
			this.firends[Integer.parseInt(friends[i])-1].setEnabled(true);
		}
	}
	
}
