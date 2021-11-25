package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiSach;
import entity.PhieuMuon;

/**
 * @author THAI ANH HAO
 * 
 */
public interface PhieuMuonDao extends Remote {

	/**
	 * @param phieuMuon
	 * @return Nếu thành công trả về PhieuMuonId, dùng để thêm cho chi tiết phiếu mượn ở bước kế tiếp. Nếu thất bại trả về Thêm thất bại
	 * @throws RemoteException
	 */
	public String createPhieuMuon(PhieuMuon phieuMuon) throws RemoteException;
	
	
	/**
	 * @param id
	 * @return Trả về một đối tượng phiếu mượn
	 * @throws RemoteException
	 */
	public PhieuMuon getPhieuMuonById(String id) throws RemoteException;
	
	public List<PhieuMuon> getAllPhieuMuon() throws RemoteException;
	
	public List<PhieuMuon> getPhieuMuonQuaHan() throws RemoteException;
	
	public List<PhieuMuon> getPhieuMuonDaTra() throws RemoteException;
	
	public boolean setThuThuForPhieuMuon(PhieuMuon phieuMuon, String ThuThuId) throws RemoteException;
	public boolean setDocGiaForPhieuMuon(PhieuMuon phieuMuon, String docGiaId) throws RemoteException;
	public boolean setThuThuAndDocGiaForPhieuMuon(PhieuMuon phieuMuon, String ThuThuId, String docGiaId) throws RemoteException;
	
	public boolean setTrangThaiDaTra(PhieuMuon phieuMuon)throws RemoteException;
	public boolean setTrangThaiDaTraById(String phieuMuonId)throws RemoteException;
	
	public boolean updatePhieuMuon(PhieuMuon phieuMuon)throws RemoteException;
	
	public boolean deletePhieuMuon(PhieuMuon phieuMuon)throws RemoteException;
	public boolean deletePhieuMuonById(String phieuMuonId)throws RemoteException;
}
