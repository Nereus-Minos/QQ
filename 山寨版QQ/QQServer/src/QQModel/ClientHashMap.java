package QQModel;

import java.util.*;

public class ClientHashMap {

		public static HashMap hm = new HashMap<String, QQCommunicationThread>();	

		public static void addClientThread(String uid, QQCommunicationThread ct)
		//��hm�����һ���ͻ���ͨѶ�߳�
		{
			hm.put(uid, ct);
		}
		
		public static QQCommunicationThread getClientThread(String uid)
		{
			return (QQCommunicationThread)hm.get(uid);
		}
		
		//дһ���������������б�ŵ�һ��String��
		public static String getFriendslist() {
			//ʹ�õ�����
			Iterator it = hm.keySet().iterator();
			String ret = "";
			while(it.hasNext()) {
				
				ret += it.next().toString() + " ";
				
			}
			
			return ret;
		}
		
		
}
