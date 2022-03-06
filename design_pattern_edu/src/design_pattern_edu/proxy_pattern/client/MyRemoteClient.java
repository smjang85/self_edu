package design_pattern_edu.proxy_pattern.client;

import java.rmi.Naming;

import design_pattern_edu.proxy_pattern.server.MyRemote;

public class MyRemoteClient {
	public static void main(String[] args) {
		new MyRemoteClient().go();
	}
	
	public void go() {
		try {
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
			
			String s = service.sayHello();
			
			System.out.println(s);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
