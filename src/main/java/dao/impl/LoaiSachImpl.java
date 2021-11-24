package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import dao.LoaiSachDao;
import entity.LoaiSach;
import entity.PhieuMuon;
import entity.Sach;
import util.HibernateUtil;

public class LoaiSachImpl extends UnicastRemoteObject implements LoaiSachDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4117138339403775760L;
	private EntityManager em;
	public LoaiSachImpl() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}
	public boolean addLoaiSach(LoaiSach LoaiSach) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			
			em.persist(LoaiSach);
			
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public LoaiSach getLoaiSachById(String id) throws RemoteException {
		// TODO Auto-generated method stub
		LoaiSach loaisach = new LoaiSach();
		EntityTransaction tr = em.getTransaction();
		try {
			
			
			String sql = "Select * from Sach where id = :id";
			loaisach = (LoaiSach) em.find(LoaiSach.class, id);
			
			return loaisach;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return loaisach;
	}
	public boolean updateLoaiSach(LoaiSach loaiSach) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(loaiSach);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public boolean deleteLoaiSachById(String id) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			LoaiSach loaisach = (LoaiSach) em.find(LoaiSach.class, id);
			session.delete(loaisach);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public boolean deleteLoaiSach(LoaiSach loaiSach) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(loaiSach);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	public List<LoaiSach> getAllLoaiSach() throws RemoteException {
		// TODO Auto-generated method stub
		List<LoaiSach> list = new ArrayList<LoaiSach>();
		Session session = em.unwrap(Session.class);;
		EntityTransaction tr = em.getTransaction();
		try {
			
			String sql = "Select ls from LoaiSach ls";
			list = (List<LoaiSach>) session.createQuery(sql).getResultList();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return list;
	}

}
