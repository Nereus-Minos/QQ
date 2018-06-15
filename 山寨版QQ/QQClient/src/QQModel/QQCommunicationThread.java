
/*���ܣ��Ƿ������Ϳͻ��˵�ͨ���߳�(һֱ�����������͹���������)*/

package QQModel;

import java.net.*;

import QQChat.ChatFrame;
import QQCommon.Message;
import QQCommon.MessageType;

import java.io.*;

public class QQCommunicationThread extends Thread{

	public Socket s;
	
	public QQCommunicationThread(Socket s) {
		this.s = s;
	}
	
	public void run() {
		
		while(true) {
			
			try {
					
				//����
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				
				Message ms = (Message)ois.readObject();				//���չ�����user��friendʹ����
				
				if(ms.getMessageType().equals(MessageType.message_ordinary_message)) {
					
								//��ʾ
					ChatFrame chat = ChatFrameHashMap.getChatFrame(ms.getFriendname()+ms.getUsername());
					
					chat.showMessage(ms);
					
				}else if(ms.getMessageType().equals(MessageType.message_return_onlinefriends)) {
					
					String friendslist = ms.getFriendslist();
					String friends[] = friendslist.split(" ");

					
					//�ڴ˸��º��������б�
					QQFriendsListMap.getFriendsList(ms.getUsername()).updateFriendslist(friends);
					
				}	
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
