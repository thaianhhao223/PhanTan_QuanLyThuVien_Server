package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class DocGia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3931650085881171874L;
	
	@Id
	@GeneratedValue(generator = "docgia_generator")  
	@GenericGenerator(name = "docgia_generator", strategy = "generator.GeneratorForDocGiaId")
	private String id;
	
	@Column(columnDefinition = "NVarchar(255)")
	private String hoTen;
	private String soDienThoai;
	private String email;
	@Column(columnDefinition = "NVarchar(255)")
	private String chucVu;
	@Column(columnDefinition = "NVarchar(255)")
	private String chuyenNganh;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getChuyenNganh() {
		return chuyenNganh;
	}
	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public DocGia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DocGia(String hoTen, String soDienThoai, String email, String chucVu, String chuyenNganh) {
		super();
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.chucVu = chucVu;
		this.chuyenNganh = chuyenNganh;
	}
	@Override
	public String toString() {
		return "DocGia [id=" + id + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai + ", email=" + email
				+ ", chucVu=" + chucVu + ", chuyenNganh=" + chuyenNganh + "]";
	}
	
	
}
