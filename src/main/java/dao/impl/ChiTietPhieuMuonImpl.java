package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import dao.ChiTietPhieuMuonDao;
import entity.ChiTietPhieuMuon;
import entity.ChiTietPhieuMuonFK;
import entity.DocGia;
import entity.PhieuMuon;
import entity.Sach;
import util.HibernateUtil;

public class ChiTietPhieuMuonImpl extends UnicastRemoteObject implements ChiTietPhieuMuonDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2921267726005111376L;
	private EntityManager em;
	public ChiTietPhieuMuonImpl() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	public String addChiTietPhieuMuon(ChiTietPhieuMuon chiTietPhieuMuon) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		Session session = em.unwrap(Session.class);
		if(chiTietPhieuMuon.getSoLuong() < 1)
			return "Số lượng ít hơn 1";
		try {
			
			String sql = "Select sum(soLuong) from ChiTietPhieuMuon where sachId = :id and trangThai = 'Chưa trả'";
			Object object = (Object) session.createQuery(sql).setParameter("id", chiTietPhieuMuon.getSach().getId()).getSingleResult();
			int count = (Integer) object;
			Sach sach = (Sach) em.find(Sach.class, chiTietPhieuMuon.getSach().getId());
			
			if( count + chiTietPhieuMuon.getSoLuong() <= sach.getSoLuongBanIn()) {
				tr.begin();
				em.persist(chiTietPhieuMuon);
				tr.commit();
				return "Thêm thành công";
			}else {
				return "Không đủ số sách";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return "Thêm thất bại";
	}
	
	public String addChiTietPhieuMuonById(String phieuMuonId, String sachId, int soLuong) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		Session session = em.unwrap(Session.class);
		if(soLuong < 1)
			return "Số lượng ít hơn 1";
		try {
			
			PhieuMuon phieuMuon = em.find(PhieuMuon.class, phieuMuonId);
			Sach sach = em.find(Sach.class, sachId);
			ChiTietPhieuMuon chiTietPhieuMuon = new ChiTietPhieuMuon(sach, phieuMuon, soLuong, "Chưa trả");
			
			String sql = "Select sum(soLuong) from ChiTietPhieuMuon where sachId = :id and trangThai = 'Chưa trả'";
			Object object = (Object) session.createQuery(sql).setParameter("id", chiTietPhieuMuon.getSach().getId()).getSingleResult();
			System.out.println(object.toString());
			int count = Integer.parseInt(object.toString());
			
			if( count + chiTietPhieuMuon.getSoLuong() <= sach.getSoLuongBanIn()) {
				tr.begin();
				em.persist(chiTietPhieuMuon);
				tr.commit();
				return "Thêm thành công";
			}else {
				return "Không đủ số sách";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return "Thêm thất bại";
	}
	
	public ChiTietPhieuMuon getChiTietPhieuMuonByIdSachAndIdPhieuMuon(String phieuMuonId, String SachId)
			throws RemoteException {
		// TODO Auto-generated method stub
		ChiTietPhieuMuon chiTietPhieuMuon = new ChiTietPhieuMuon();
		EntityTransaction tr = em.getTransaction();
		try {
			
			ChiTietPhieuMuonFK id = new ChiTietPhieuMuonFK();
			id.setPhieuMuon(phieuMuonId);
			id.setSach(SachId);
			chiTietPhieuMuon = (ChiTietPhieuMuon) em.find(ChiTietPhieuMuon.class, id);
			
			return chiTietPhieuMuon;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return chiTietPhieuMuon;
	}

	public String updateChiTietPhieuMuon(ChiTietPhieuMuon chiTietPhieuMuon) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		if(chiTietPhieuMuon.getSoLuong() < 1)
			return "Số lượng ít hơn 1";
		try {
			Sach sach = em.find(Sach.class, chiTietPhieuMuon.getSach().getId());
			
			String sql = "Select sum(soLuong) from ChiTietPhieuMuon where sachId = :id and trangThai = 'Chưa trả'";
			Object object = (Object) session.createQuery(sql).setParameter("id", chiTietPhieuMuon.getSach().getId()).getSingleResult();
			System.out.println(object.toString());
			int count = Integer.parseInt(object.toString());
			
			if( count + chiTietPhieuMuon.getSoLuong() <= sach.getSoLuongBanIn()) {
				tr.begin();
				ChiTietPhieuMuon chiTietPhieuMuonUpdate = new ChiTietPhieuMuon();
				chiTietPhieuMuonUpdate.setSoLuong(chiTietPhieuMuon.getSoLuong());
				chiTietPhieuMuonUpdate.setTrangThai(chiTietPhieuMuon.getTrangThai());
				session.update(chiTietPhieuMuonUpdate);
				tr.commit();
				return "Thêm thành công";
			}else {
				return "Không đủ số sách";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return "Thêm thất bại";
	}

	public boolean deleteChiTietPhieuMuon(ChiTietPhieuMuon chiTietPhieuMuon) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(chiTietPhieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean setTraSach(ChiTietPhieuMuon chiTietPhieuMuon) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			chiTietPhieuMuon.setTrangThai("Đã trả");
			session.update(chiTietPhieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean setTraSachByIdSachAndIdPhieuMuon(String phieuMuonId, String SachId) throws RemoteException {
		// TODO Auto-generated method stub
		ChiTietPhieuMuon chiTietPhieuMuon = new ChiTietPhieuMuon();
		EntityTransaction tr = em.getTransaction();
		Session session = em.unwrap(Session.class);
		try {
			tr.begin();
			ChiTietPhieuMuonFK id = new ChiTietPhieuMuonFK();
			id.setPhieuMuon(phieuMuonId);
			id.setSach(SachId);
			chiTietPhieuMuon = (ChiTietPhieuMuon) em.find(ChiTietPhieuMuon.class, id);
			chiTietPhieuMuon.setTrangThai("Đã trả");
			session.update(chiTietPhieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	public List<ChiTietPhieuMuon> getChiTietPhieuMuonByIdPhieuMuon(String phieuMuonId) throws RemoteException {
		// TODO Auto-generated method stub
		List<ChiTietPhieuMuon> list = new ArrayList<ChiTietPhieuMuon>();
		Session session = em.unwrap(Session.class);;
		EntityTransaction tr = em.getTransaction();
		try {
			
			String sql = "Select ctpm from ChiTietPhieuMuon ctpm where phieuMuonId = :id";
			list = (List<ChiTietPhieuMuon>) session.createQuery(sql).setParameter("id", phieuMuonId).getResultList();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return list;
	}
}
