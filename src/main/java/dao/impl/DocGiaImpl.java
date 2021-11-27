package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import dao.DocGiaDao;
import entity.DocGia;
import entity.LoaiSach;
import entity.Sach;
import util.HibernateUtil;

public class DocGiaImpl extends UnicastRemoteObject implements DocGiaDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4212721151697135624L;
	private EntityManager em;
	private Session session;
	public DocGiaImpl() throws RemoteException {
		em = HibernateUtil.getInstance().getEntityManager();
		session = em.unwrap(Session.class);
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
		EntityTransaction tr = session.getTransaction();
		DocGia docGiaupdate = new DocGia();
		try {
			tr.begin();
			// Không thể sử dụng entity được truyền trực tiếp vào, vì sẽ lỗi trùng entity do session quản lý.
			docGiaupdate = (DocGia) em.find(DocGia.class, docGia.getId());
			docGiaupdate.setChucVu(docGia.getChucVu());
			docGiaupdate.setChuyenNganh(docGia.getChuyenNganh());
			docGiaupdate.setEmail(docGia.getEmail());
			docGiaupdate.setHoTen(docGia.getHoTen());
			docGiaupdate.setSoDienThoai(docGia.getSoDienThoai());
			session.update(docGiaupdate);
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

	public List<DocGia> getAllDocGia() throws RemoteException {
		// TODO Auto-generated method stub
		List<DocGia> list = new ArrayList<DocGia>();
		EntityTransaction tr = em.getTransaction();
		try {
			
			String sql = "Select dg from DocGia dg";
			list = (List<DocGia>) session.createQuery(sql).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return list;
	}

}
