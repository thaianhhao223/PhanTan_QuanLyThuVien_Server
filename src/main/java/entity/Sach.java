package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Sach")
public class Sach implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4613995703692759300L;

	@Id
	@GeneratedValue(generator = "sach_generator")  
	@GenericGenerator(name = "sach_generator", strategy = "generator.GeneratorForSachId")
	private String id;
	
	@Column(columnDefinition = "NVarchar(255)")
	private String tenSach;
	@Column(columnDefinition = "NVarchar(255)")
	private String tacGia;
	private Date namXuatBan;
	@Column(columnDefinition = "NVarchar(255)")
	private String nhaXuatBan;
	private int donGia;
	
	@OneToOne
	@JoinColumn(name="loaiSachId")
	private LoaiSach loaiSach;
	
	
	private int soLuongBanIn;

	@OneToMany(mappedBy = "sach")
	@Column(insertable = false)
	private Set<ChiTietPhieuMuon> chiTietPhieuMuon;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public Date getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(Date namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public LoaiSach getLoaiSach() {
		return loaiSach;
	}

	public void setLoaiSach(LoaiSach loaiSach) {
		this.loaiSach = loaiSach;
	}

	public int getSoLuongBanIn() {
		return soLuongBanIn;
	}

	public void setSoLuongBanIn(int soLuongBanIn) {
		this.soLuongBanIn = soLuongBanIn;
	}

	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Sach(String tenSach, String tacGia, Date namXuatBan, String nhaXuatBan, int donGia, int soLuongBanIn) {
		super();
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.namXuatBan = namXuatBan;
		this.nhaXuatBan = nhaXuatBan;
		this.donGia = donGia;
		this.soLuongBanIn = soLuongBanIn;
	}

	@Override
	public String toString() {
		return "Sach [id=" + id + ", tenSach=" + tenSach + ", tacGia=" + tacGia + ", namXuatBan=" + namXuatBan
				+ ", nhaXuatBan=" + nhaXuatBan + ", donGia=" + donGia + ", loaiSach=" + loaiSach + ", soLuongBanIn="
				+ soLuongBanIn + "]";
	}
	
	
}
