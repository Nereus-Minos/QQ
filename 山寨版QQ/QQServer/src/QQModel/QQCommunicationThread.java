
/*���ܣ��Ƿ�������ĳ���ͻ��˵�ͨ���߳�(һֱ��ȡ�ͻ��˷��͹���������)*/

package QQModel;

import java.net.*;
import java.util.Iterator;

import QQCommon.Message;
import QQCommon.MessageType;

import java.io.*;

public class QQCommunicationThread extends Thread{

	Socket s;
	
	public QQCommunicationThread(Socket s) {
		this.s = s;
	}
	
	public void run() {
		
		while(true) {
			
			try {
					
					ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
					
					Message ms = (Message)ois.readObject();				
					
					if(ms.getMessageType().equals(MessageType.message_ordinary_message)) {  //������͹���������ͨ��Ϣ��ֱ��ת��
						
								//ת��
						QQCommunicationThread fiendQQCommunicationThread = ClientHashMap.getClientThread(ms.getFriendname());
						
						ObjectOutputStream oos=new ObjectOutputStream(fiendQQCommunicationThread.s.getOutputStream());
						
						oos.writeObject(ms);
						
					}else if(ms.getMessageType().equals(MessageType.message_get_onlinefriends)) {  //������������Ǻ����б��������....
						
						Message ms2 = new Message();   //���Ƿ����ͻ��˵ĺ����б�
						
						ms2.setUsername(ms.getUsername());
						
						ms2.setMessageType(MessageType.message_return_onlinefriends);
						
						ms2.setFriendslist(ClientHashMap.getFriendslist());
						
						ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
						
						oos.writeObject(ms2);
					}			
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
