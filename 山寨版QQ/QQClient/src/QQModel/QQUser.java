package QQModel;

//��֤�Ƿ�ΪUser������true��false
public class QQUser {
	
	//дһ����֤����
	public boolean isQQUser(Object o) {

		return new QQCommunication().sentLogInInformation(o) ;
	}
}
