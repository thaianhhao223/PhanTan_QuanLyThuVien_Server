package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import dao.SachDao;
import entity.LoaiSach;
import entity.Sach;
import util.HibernateUtil;


public class SachImpl extends UnicastRemoteObject implements SachDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4361249900899026308L;
	private EntityManager em;

	public SachImpl() throws RemoteException{
		em = HibernateUtil.getInstance().getEntityManager();
	}
	
	public boolean addSach(Sach sach) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			System.out.println(sach.getId());
			tr.begin();
			em.persist(sach);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public Sach getSachById(String id) throws RemoteException {
		// TODO Auto-generated method stub
		Sach sach = new Sach();
		EntityTransaction tr = em.getTransaction();
		try {
			
			
			Sach object = (Sach) em.find(Sach.class, id);
			
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return sach;
	}

	public List<Sach> getSachByName(String ten) throws RemoteException {
		// TODO Auto-generated method stub
		List<Sach> sach = new ArrayList<Sach>();
		Session session = em.unwrap(Session.class);;
		EntityTransaction tr = em.getTransaction();
		try {
			
			String sql = "Select s from Sach s where tensach = :ten";
			sach = (List<Sach>) session.createQuery(sql).setParameter("ten", ten).getResultList();
			
			return sach;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return sach;
	}

	public List<Sach> getSachByProducer(String nhaXuatBan) throws RemoteException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
			List<Sach> sach = new ArrayList<Sach>();
			Session session = em.unwrap(Session.class);;
			EntityTransaction tr = em.getTransaction();
			try {
				
				
				String sql = "Select s from Sach s where nhaXuatBan = :nhaXuatBan";
				sach = (List<Sach>) session.createQuery(sql).setParameter("nhaXuatBan", nhaXuatBan).getResultList();
				
				return sach;
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			return sach;
	}

	public boolean addLoaiSachForSach(String sachId, String loaiSachid) throws RemoteException {
		// TODO Auto-generated method stub
		
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			Sach sach = (Sach) em.find(Sach.class, sachId);
			LoaiSach loaiSach = (LoaiSach) em.find(LoaiSach.class, loaiSachid);
			sach.setLoaiSach(loaiSach);
			session.update(sach);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean deleteSachById(String id) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			Sach sach = (Sach) em.find(Sach.class, id);
			session.delete(sach);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean deleteSach(Sach sach) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(sach);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean updateSach(Sach sach) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(sach);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
}
