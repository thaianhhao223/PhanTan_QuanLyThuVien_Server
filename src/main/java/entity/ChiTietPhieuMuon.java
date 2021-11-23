package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ChiTietPhieuMuonFK.class)
public class ChiTietPhieuMuon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 650045888457403672L;

	@Id
	@ManyToOne
	@JoinColumn(name="sachId")
	private Sach sach;
	
	@Id
	@ManyToOne
	@JoinColumn(name="phieuMuonId")
	private PhieuMuon phieuMuon;
	
	private int soLuong;
	
	@Column(columnDefinition = "NVarchar(255)")
	private String trangThai =  "Chưa trả";
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public PhieuMuon getPhieuMuon() {
		return phieuMuon;
	}

	public void setPhieuMuon(PhieuMuon phieuMuon) {
		this.phieuMuon = phieuMuon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public ChiTietPhieuMuon() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phieuMuon == null) ? 0 : phieuMuon.hashCode());
		result = prime * result + ((sach == null) ? 0 : sach.hashCode());
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
		ChiTietPhieuMuon other = (ChiTietPhieuMuon) obj;
		if (phieuMuon == null) {
			if (other.phieuMuon != null)
				return false;
		} else if (!phieuMuon.equals(other.phieuMuon))
			return false;
		if (sach == null) {
			if (other.sach != null)
				return false;
		} else if (!sach.equals(other.sach))
			return false;
		return true;
	}

	

	public ChiTietPhieuMuon(Sach sach, PhieuMuon phieuMuon, int soLuong, String trangThai) {
		super();
		this.sach = sach;
		this.phieuMuon = phieuMuon;
		this.soLuong = soLuong;
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuMuon [sach=" + sach + ", phieuMuon=" + phieuMuon + ", soLuong=" + soLuong + "]";
	}
	
	
}
