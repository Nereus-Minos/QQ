package QQModel;

import java.util.HashMap;

import QQFriendsList.FriendsList;

public class QQFriendsListMap {

	public static HashMap hmQQFriendsList = new HashMap<String, FriendsList>();	

	public static void addFriendsList(String id, FriendsList ct)  //��������idΪuser��friendid�����
	//��hm�����һ���ͻ���ͨѶ�߳�
	{
		hmQQFriendsList.put(id, ct);
	}
	public static FriendsList getFriendsList(String id)
	{
		return (FriendsList)hmQQFriendsList.get(id);
	}

	
}
