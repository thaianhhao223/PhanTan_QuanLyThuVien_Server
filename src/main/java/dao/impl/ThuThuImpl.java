package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import dao.ThuThuDao;
import entity.DocGia;
import entity.Sach;
import entity.ThuThu;
import util.HibernateUtil;

public class ThuThuImpl extends UnicastRemoteObject implements ThuThuDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5890644067730795878L;
	private EntityManager em;
	public ThuThuImpl() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}

	public boolean addThuThu(ThuThu thuThu) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			
			em.persist(thuThu);
			
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}

	public ThuThu getThuThuById(String id) throws RemoteException {
		// TODO Auto-generated method stub
		ThuThu thuThu = new ThuThu();
		EntityTransaction tr = em.getTransaction();
		try {
			
			
			thuThu = (ThuThu) em.find(ThuThu.class, id);
			
			return thuThu;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return thuThu;
	}
	
	public List<ThuThu> getAllThuThu() throws RemoteException {
		// TODO Auto-generated method stub
		List<ThuThu> thuThu = new ArrayList<ThuThu>();
		Session session = em.unwrap(Session.class);;
		EntityTransaction tr = em.getTransaction();
		try {
			
			String sql = "Select tt from ThuThu tt";
			thuThu = (List<ThuThu>) session.createQuery(sql).getResultList();
			
			return thuThu;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return thuThu;
	}
	
	public boolean updateThuThu(ThuThu thuThu) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		ThuThu thuThuUpdate = new ThuThu();
		thuThuUpdate = session.find(ThuThu.class, thuThu.getId());
		thuThuUpdate.setDiaChi(thuThu.getDiaChi());
		thuThuUpdate.setEmail(thuThu.getEmail());
		thuThuUpdate.setHoTen(thuThu.getHoTen());
		thuThuUpdate.setSoDienThoai(thuThu.getSoDienThoai());
		try {
			tr.begin();
			session.update(thuThuUpdate);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean deleteThuThu(ThuThu thuThu) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(thuThu);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean deleteThuThuById(String id) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			ThuThu thuThu = (ThuThu) em.find(ThuThu.class, id);
			session.delete(thuThu);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	
}
