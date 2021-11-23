package entity;

import java.io.Serializable;

public class ChiTietPhieuMuonFK implements Serializable{
	private String sach;
	private String phieuMuon;
	
	public String getSach() {
		return sach;
	}
	public String getPhieuMuon() {
		return phieuMuon;
	}
	public void setSach(String sach) {
		this.sach = sach;
	}
	public void setPhieuMuon(String phieuMuon) {
		this.phieuMuon = phieuMuon;
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
		ChiTietPhieuMuonFK other = (ChiTietPhieuMuonFK) obj;
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
	
	
}
