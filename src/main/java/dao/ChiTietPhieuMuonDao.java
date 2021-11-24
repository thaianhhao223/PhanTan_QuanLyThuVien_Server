package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietPhieuMuon;
import entity.DocGia;

public interface ChiTietPhieuMuonDao extends Remote{
	public String addChiTietPhieuMuon(ChiTietPhieuMuon chiTietPhieuMuon) throws RemoteException;
	
	public String addChiTietPhieuMuonById(String phieuMuonId, String sachId, int soLuong) throws RemoteException;
	
	public ChiTietPhieuMuon getChiTietPhieuMuonByIdSachAndIdPhieuMuon(String phieuMuonId, String SachId) throws RemoteException;
	
	public List<ChiTietPhieuMuon> getChiTietPhieuMuonByIdPhieuMuon(String phieuMuonId) throws RemoteException;
	
	public boolean setTraSach(ChiTietPhieuMuon chiTietPhieuMuon) throws RemoteException;
	
	public boolean setTraSachByIdSachAndIdPhieuMuon(String phieuMuonId, String SachId) throws RemoteException;
	
	public boolean updateChiTietPhieuMuon(ChiTietPhieuMuon chiTietPhieuMuon) throws RemoteException;
	
	public boolean deleteChiTietPhieuMuon(ChiTietPhieuMuon chiTietPhieuMuon) throws RemoteException;
}
