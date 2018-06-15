package QQModel;

import java.net.*;

import QQCommon.*;
import QQFriendsList.FriendsList;

import java.io.*;

//���ӷ�����
public class QQCommunication {
	private boolean flag = false;
	public Socket s = null;
	
	public boolean sentLogInInformation(Object o) {
		
		try {
				s = new Socket("127.0.0.1", 9999);
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(o);
				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message ms = (Message)ois.readObject();
				if(ms.getMessageType().equals(MessageType.message_succeed)) {
					flag = true;
					User user = (User)o;
						
					//�������б�ŵ�HashMap��
					
					FriendsList FriendsList = new FriendsList(user.getName());
					
					QQFriendsListMap.addFriendsList(user.getName(), FriendsList);
					
					//���ý����̷߳ŵ�HashMap��
									
					QQCommunicationThread QQCommunicationThread = new QQCommunicationThread(s);
					ServerHashMap.addClientThread(user.getName(), QQCommunicationThread);				
					Thread t = new Thread(QQCommunicationThread);
					t.start();
					
				}else {
					
				}		
	
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

		}
		
		return flag;
	
	}
}
