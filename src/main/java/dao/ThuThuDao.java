package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Sach;
import entity.ThuThu;

public interface ThuThuDao extends Remote{
	
	/**
	 * @param thuThu
	 * @return Thêm một thủ thư mới, thất bại trả về false, thành công trả về true
	 * @throws RemoteException
	 */
	public boolean addThuThu(ThuThu thuThu) throws RemoteException;
	
	public ThuThu getThuThuById(String id) throws RemoteException;
	
	public List<ThuThu> getAllThuThu() throws RemoteException;
	public boolean updateThuThu(ThuThu thuThu) throws RemoteException;
	
	public boolean deleteThuThu(ThuThu thuThu) throws RemoteException;
	public boolean deleteThuThuById(String id) throws RemoteException;
}
