package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.DocGia;
import entity.Sach;

public interface DocGiaDao extends Remote{
	
	public boolean addDocGia(DocGia docGia) throws RemoteException;
	
	public DocGia getDocGiaById(String id) throws RemoteException;
	
	public boolean updateDocGia(DocGia docGia) throws RemoteException;
	
	public boolean deleteDocGiaById(String id) throws RemoteException;
	public boolean deleteDocGia(DocGia docGia) throws RemoteException;
}
