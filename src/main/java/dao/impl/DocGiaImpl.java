package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import dao.DocGiaDao;
import entity.DocGia;
import entity.Sach;
import util.HibernateUtil;

public class DocGiaImpl extends UnicastRemoteObject implements DocGiaDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4212721151697135624L;
	private EntityManager em;
	
	public DocGiaImpl() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
	}
	
	public boolean addDocGia(DocGia docGia) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			
			em.persist(docGia);
			
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public DocGia getDocGiaById(String id) throws RemoteException {
		// TODO Auto-generated method stub
		DocGia docGia = new DocGia();
		EntityTransaction tr = em.getTransaction();
		try {
			docGia = (DocGia) em.find(DocGia.class, id);
			return docGia;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return docGia;
	}

	public boolean updateDocGia(DocGia docGia) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(docGia);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean deleteDocGiaById(String id) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			DocGia docGia = (DocGia) em.find(DocGia.class, id);
			session.delete(docGia);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	public boolean deleteDocGia(DocGia docGia) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		EntityTransaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(docGia);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

}
