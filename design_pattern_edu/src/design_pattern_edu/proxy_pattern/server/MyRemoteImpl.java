package design_pattern_edu.proxy_pattern.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
	public MyRemoteImpl() throws RemoteException {}

	public String sayHello() {
		return "server says, 'Hey'";
	}
	
	public static void main(String[] args) {
		try {
			MyRemote service = new MyRemoteImpl();
			Naming.rebind("RemoteHello", service);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
