package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dao.SachDao;
import dao.impl.SachImpl;

public class AppServer {
	public static void main(String[] args) {
		
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			SachDao sachDao = new SachImpl();
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi://192.168.1.111:1099/sachDao", sachDao);
			System.out.println("Server bound in RMIRegistry");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
