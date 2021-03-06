package QQCommon;

import java.io.Serializable;
import java.util.Date;

//信息传送流
public class Message implements Serializable{
	private String MessageType;    //1表示登录成功，2表示登录失败，3表示普通文本消息
	private String username;
	private String friendname;
	private String message;
	private Date time;
	private String friendslist;

	public String getMessageType() {
		return MessageType;
	}

	public void setMessageType(String messageType) {
		MessageType = messageType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFriendname() {
		return friendname;
	}

	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getFriendslist() {
		return friendslist;
	}

	public void setFriendslist(String friendslist) {
		this.friendslist = friendslist;
	}
}
