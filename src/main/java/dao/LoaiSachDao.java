package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.DocGia;
import entity.LoaiSach;
import entity.Sach;

public interface LoaiSachDao extends Remote{
	public boolean addLoaiSach(LoaiSach LoaiSach) throws RemoteException;
	
	public LoaiSach getLoaiSachById(String id) throws RemoteException;
	
	public List<LoaiSach> getAllLoaiSach() throws RemoteException;
	
	public boolean updateLoaiSach(LoaiSach loaiSach)throws RemoteException;
	
	public boolean deleteLoaiSachById(String id)throws RemoteException;
	public boolean deleteLoaiSach(LoaiSach loaiSach)throws RemoteException;
	
}
