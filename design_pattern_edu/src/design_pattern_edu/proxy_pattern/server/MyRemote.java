package design_pattern_edu.proxy_pattern.server;

import java.rmi.Remote;

public interface MyRemote extends Remote{
	public String sayHello();
}
