package app;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
import entity.ChiTietPhieuMuon;
import entity.DocGia;
import entity.LoaiSach;
import entity.PhieuMuon;
import entity.Sach;
import entity.ThuThu;
import util.HibernateUtil;


public class App {
	public static void main(String[] args) throws RemoteException{		
		
		EntityManager em = HibernateUtil.getInstance().getEntityManager();
		
		SachDao sachDao = new SachImpl();
		
		//Thêm sách
//		Date date = Date.valueOf("1987-1-1");
//		Sach sach = new Sach("Rừng Na Uy", "Murakami Haruki", date, "Hào nè", 10, 5);
////		Sach sach = new Sach("Sach002", "!001 đêm", "Aladin", date, "Kim Đồng", 0, null, 0);
//		
//		if(sachDao.addSach(sach))
//			System.out.println("Thành công");
//		
		//Lấy sách bằng id
//		Sach sach = sachDao.getSachById("SACH20211121755330");
//		System.out.println(sach.toString());
		
		// Lấy sách bằng tên sách.
//		List<Sach> listsach = sachDao.getSachByName("Tôi là ai - và nếu vậy thì bao nhiêu?");
//		for (int i = 0; i < listsach.size(); i++) {
//			System.out.println(listsach.get(i).toString());
//		}
		
//		List<Sach> listsach = sachDao.findSachByKeyWord("Sách Việt");
//		for (int i = 0; i < listsach.size(); i++) {
//			System.out.println(listsach.get(i).toString());
//		}
		
//		List<Sach> listsach = sachDao.getSachByProducer("Sách Việt");
//		for (int i = 0; i < listsach.size(); i++) {
//			System.out.println(listsach.get(i).toString());
//		}
		
		//Loại sách
		LoaiSachDao loaiSachDao = new LoaiSachImpl();
		
//		sachDao.addLoaiSachForSach("SACH20211121959724", "LoaiSach20211121291558");
//		
//		LoaiSach loaiSach = new LoaiSach("Thiếu nhi");
//		if(loaiSachDao.addLoaiSach(loaiSach))
//			System.out.println("Thêm loại sách thành công!");
		
		ThuThuDao thuThuDao = new ThuThuImpl();
		
//		ThuThu thuThu = new ThuThu("Thái Anh Hào", "Vĩnh Long", "12329312", "asxcc@gmail.com");
//		if(thuThuDao.addThuThu(thuThu))
//			System.out.println("Thêm thủ thư thành công");
		
//		ThuThu thuThu = thuThuDao.getThuThuById("ThuThu20211123985775");
//		System.out.println(thuThu.toString());
		
		DocGiaDao docGiaDao = new DocGiaImpl();
		
//		List<DocGia> list = docGiaDao.findDocGiaByKeyWord("ha");
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
//		DocGia docGia = new DocGia("Thái Anh Hào", "0923021093", "thaihao@gmail.com", "Sinh viên", "Công nghệ thông tin");
//		
//		if(docGiaDao.addDocGia(docGia))
//			System.out.println("Thêm đọc giả thành công");
		
//		DocGia docGia =  docGiaDao.getDocGiaById("DocGia20211123716576");
//		docGia.setChucVu("Trưởng khoa");
//		docGiaDao.updateDocGia(docGia);
		
		PhieuMuonDao phieuMuonDao = new PhieuMuonImpl();
		
		java.util.Date date = new java.util.Date();
//		Date ngayMuon = new Date(date.getTime());
//		Date ngayMuon = Date.valueOf("2021-11-25");
//		Date ngayTra = Date.valueOf("2021-11-27");
//		
//		DocGia docGia = docGiaDao.getDocGiaById("DocGia20211129595506");
//		ThuThu thuThu = thuThuDao.getThuThuById("ThuThu20211129902342");
//		PhieuMuon phieuMuon = new PhieuMuon(ngayMuon, ngayTra, "Chưa trả", thuThu, docGia);
//		String check = phieuMuonDao.createPhieuMuon(phieuMuon);
//		System.out.println(check);
		
//		phieuMuonDao.setTrangThaiDaTraById("PhieuMuon20211125120513");
//		
//		List<PhieuMuon> list = phieuMuonDao.getPhieuMuonQuaHan();
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
		
//		List<PhieuMuon> list = phieuMuonDao.findPhieuMuonByKeyWord("615");
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
		
//		List<PhieuMuon> list = phieuMuonDao.getPhieuMuonDaTra();
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
		
		ChiTietPhieuMuonDao chiTietPhieuMuonDao = new ChiTietPhieuMuonImpl();
	
//		String check = chiTietPhieuMuonDao.addChiTietPhieuMuonById("PhieuMuon20211123289177", "SACH20211123175734",1);
//		System.out.println(check);
		
//		Sach sach = sachDao.getSachById("SACH20211123175734");
//		boolean ktr = chiTietPhieuMuonDao.isSachEnough(sach, 5);
//		System.out.println(ktr);
		
//		boolean ktr = chiTietPhieuMuonDao.deleteChiTietPhieuMuonByPhieuMuonId("PhieuMuon20211128192465");
//		System.out.println(ktr);
	}
}
