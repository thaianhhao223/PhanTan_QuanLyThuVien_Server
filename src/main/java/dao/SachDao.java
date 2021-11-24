package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LoaiSach;
import entity.Sach;

public interface SachDao extends Remote{
	
	
	/**
	 * @param sach
	 * @return true: nếu thêm sách thành công, false: Nếu thêm sách thất bại.+
	 * @throws RemoteException
	 */
	public boolean addSach(Sach sach) throws RemoteException;
	/**
	 * @param sachId
	 * @param loaiSachid
	 * @return true: Phân loại sách thành công, false: Phân loại sách thất bại.
	 * @throws RemoteException
	 */
	public boolean addLoaiSachForSach(String sachId, String loaiSachid) throws RemoteException;
	
	/**
	 * @param id
	 * @return Đối tượng Sách, nếu thất bại trả về chuỗi NULL
	 * @throws RemoteException
	 */
	public Sach getSachById(String id) throws RemoteException;
	
	
	public List<Sach> getAllSach() throws RemoteException;
	/**
	 * @param ten
	 * @return Trả về một danh sách các cuốn sách. nếu không tìm thấy thì trả về chuỗi rỗng
	 * @throws RemoteException
	 */
	public List<Sach> getSachByName(String ten) throws RemoteException;
	/**
	 * @param ten
	 * @return Trả về một danh sách các cuốn sách. nếu không tìm thấy thì trả về chuỗi rỗng
	 * @throws RemoteException
	 */ 
	public List<Sach> getSachByProducer(String nhaXuatBan) throws RemoteException;
	
	/**
	 * @param sach
	 * @return cập nhật các thông tin mới nhất cho một đối tượng Sách.
	 * @throws RemoteException
	 */
	public boolean updateSach(Sach sach)throws RemoteException;
	
	/**
	 * @param id
	 * @return Xóa một cuốn sách khi có id
	 * @throws RemoteException
	 */
	public boolean deleteSachById(String id)throws RemoteException;
	
	/**
	 * @param sach
	 * @return Xóa một đối tượng sách khỏi cơ sở dữ liệu
	 * @throws RemoteException
	 */
	public boolean deleteSach(Sach sach)throws RemoteException;
}
