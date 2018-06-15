package QQModel;

import java.net.*;
import java.util.Iterator;

import QQCommon.*;

import java.io.*;

public class QQCommunication {

	ServerSocket ss = null;
	Socket s = null;
	
	public QQCommunication() {

		try {			
			ss = new ServerSocket(9999);
			
			
			while(true) {

			s = ss.accept();

			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());			
			User user = (User)ois.readObject();
			Message ms = new Message();
			if(user.getPassage().equals("123456")) {
				ms.setMessageType(MessageType.message_succeed);
				oos.writeObject(ms);			
				
				//���ý����̷߳ŵ�HashMap��
				QQCommunicationThread QQCommunicationThread = new QQCommunicationThread(s);
				
				ClientHashMap.addClientThread(user.getName(), QQCommunicationThread);
					
				Thread t = new Thread(QQCommunicationThread);
				t.start();	
				
				
				//���������ߺ��ѷ������º����б�	
				String onlinefirend ;
				
				Message ms2 = new Message();   //���Ƿ����ͻ��˵ĺ����б�

				ms2.setMessageType(MessageType.message_return_onlinefriends);
				
				ms2.setFriendslist(ClientHashMap.getFriendslist());			
				
				ObjectOutputStream oos2= null;
				
				//ʹ�õ�����
				Iterator it = ClientHashMap.hm.keySet().iterator();

				while(it.hasNext()) {					
					try {
						onlinefirend = it.next().toString();
						
						oos2=new ObjectOutputStream(ClientHashMap.getClientThread(onlinefirend).s.getOutputStream());
						
						ms2.setUsername(onlinefirend);
						
						oos2.writeObject(ms2);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}else {
				ms.setMessageType(MessageType.message_fail);
				oos.writeObject(ms);
				s.close();
			}	
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null != ss) {
					ss.close();	
				}
				if(null != s) {
					s.close();	
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	
	}

}
