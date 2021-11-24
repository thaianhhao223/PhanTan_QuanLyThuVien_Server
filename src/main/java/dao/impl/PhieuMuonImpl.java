package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import dao.PhieuMuonDao;
import entity.DocGia;
import entity.PhieuMuon;
import entity.Sach;
import entity.ThuThu;
import util.HibernateUtil;

public class PhieuMuonImpl extends UnicastRemoteObject implements PhieuMuonDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6483264583530921644L;
	private EntityManager em;
	public PhieuMuonImpl() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}
	public String createPhieuMuon(PhieuMuon phieuMuon)
			throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(phieuMuon);
			tr.commit();
			return phieuMuon.getId();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	public PhieuMuon getPhieuMuonById(String id) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		PhieuMuon phieuMuon = new PhieuMuon();
		try {
			tr.begin();
			phieuMuon = (PhieuMuon) em.find(PhieuMuon.class,  id);
			tr.commit();
			return phieuMuon;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return phieuMuon;
	}
	public boolean setThuThuForPhieuMuon(PhieuMuon phieuMuon, String ThuThuId) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			ThuThu thuThu = (ThuThu) em.find(ThuThu.class,  ThuThuId);
			phieuMuon.setThuThu(thuThu);
			session.update(phieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public boolean setDocGiaForPhieuMuon(PhieuMuon phieuMuon, String docGiaId) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			DocGia docGia = (DocGia) em.find(DocGia.class,  docGiaId);
			phieuMuon.setDocGia(docGia);
			session.update(phieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public boolean setThuThuAndDocGiaForPhieuMuon(PhieuMuon phieuMuon, String ThuThuId, String docGiaId)
			throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			ThuThu thuThu = (ThuThu) em.find(ThuThu.class,  ThuThuId);
			DocGia docGia = (DocGia) em.find(DocGia.class,  docGiaId);
			phieuMuon.setThuThu(thuThu);
			phieuMuon.setDocGia(docGia);
			session.update(phieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public boolean setTrangThaiDaTra(PhieuMuon phieuMuon) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			phieuMuon.setTrangThai("Đã trả");
			session.update(phieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public boolean setTrangThaiDaTraById(String phieuMuonId) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			PhieuMuon phieuMuon = (PhieuMuon) em.find(PhieuMuon.class, phieuMuonId);
			phieuMuon.setTrangThai("Đã trả");
			session.update(phieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public boolean updatePhieuMuon(PhieuMuon phieuMuon) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(phieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public boolean deletePhieuMuon(PhieuMuon phieuMuon) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(phieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public boolean deletePhieuMuonById(String phieuMuonId) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			PhieuMuon phieuMuon = (PhieuMuon) em.find(PhieuMuon.class, phieuMuonId);
			session.delete(phieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public List<PhieuMuon> getAllPhieuMuon() throws RemoteException {
		// TODO Auto-generated method stub
		List<PhieuMuon> list = new ArrayList<PhieuMuon>();
		Session session = em.unwrap(Session.class);;
		EntityTransaction tr = em.getTransaction();
		try {
			
			String sql = "Select pm from PhieuMuon pm";
			list = (List<PhieuMuon>) session.createQuery(sql).getResultList();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return list;
	}
	
}
