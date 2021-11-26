package app;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dao.ChiTietPhieuMuonDao;
import dao.DocGiaDao;
import dao.LoaiSachDao;
import dao.PhieuMuonDao;
import dao.SachDao;
import dao.ThuThuDao;
import dao.impl.ChiTietPhieuMuonImpl;
import dao.impl.DocGiaImpl;
import dao.impl.LoaiSachImpl;
import dao.impl.PhieuMuonImpl;
import dao.impl.SachImpl;
import dao.impl.ThuThuImpl;

public class AppServer {
	public static void main(String[] args) {
		
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			SachDao sachDao = new SachImpl();
			DocGiaDao docGiaDao = new DocGiaImpl();
			ThuThuDao thuThuDao = new ThuThuImpl();
			PhieuMuonDao phieuMuonDao = new PhieuMuonImpl();
			ChiTietPhieuMuonDao chiTietPhieuMuonDao = new ChiTietPhieuMuonImpl();
			LoaiSachDao loaiSachDao = new LoaiSachImpl();
			
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi://192.168.1.111:1099/sachDao", sachDao);
			Naming.bind("rmi://192.168.1.111:1099/docGiaDao", docGiaDao);
			Naming.bind("rmi://192.168.1.111:1099/thuThuDao", thuThuDao);
			Naming.bind("rmi://192.168.1.111:1099/phieuMuonDao", phieuMuonDao);
			Naming.bind("rmi://192.168.1.111:1099/chiTietPhieuMuonDao", chiTietPhieuMuonDao);
			Naming.bind("rmi://192.168.1.111:1099/loaiSachDao", loaiSachDao);
			
			System.out.println("Server bound in RMIRegistry");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
