package QQModel;

import java.util.HashMap;

import QQChat.ChatFrame;

public class ChatFrameHashMap {

	public static HashMap hmChat = new HashMap<String, ChatFrame>();	

	public static void addChatFrame(String id, ChatFrame ct)  //��������idΪuser��friendid�����
	//��hm�����һ���ͻ���ͨѶ�߳�
	{
		hmChat.put(id, ct);
	}
	public static ChatFrame getChatFrame(String id)
	{
		return (ChatFrame)hmChat.get(id);
	}
}
