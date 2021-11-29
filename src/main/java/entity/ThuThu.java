package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ThuThu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4528546895249649684L;
	
	@Id
	@GeneratedValue(generator = "thuthu_generator")  
	@GenericGenerator(name = "thuthu_generator", strategy = "generator.GeneratorForThuThuId")
	private String id;
	@Column(columnDefinition = "NVarchar(255)")
	private String hoTen;
	@Column(columnDefinition = "NVarchar(255)")
	private String diaChi;
	private String soDienThoai;
	private String Email;
	private String account;
	private String password;
	
	public String getAccount() {
		return account;
	}
	public String getPassword() {
		return password;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
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
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ThuThu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThuThu(String hoTen, String diaChi, String soDienThoai, String email) {
		super();
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		Email = email;
	}
	@Override
	public String toString() {
		return "ThuThu [id=" + id + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai
				+ ", Email=" + Email + "]";
	}
	
	
}
