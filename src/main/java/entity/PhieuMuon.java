package entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PhieuMuon")
public class PhieuMuon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2584555279270714844L;

	@Id
	@GeneratedValue(generator = "phieumuon_generator")  
	@GenericGenerator(name = "phieumuon_generator", strategy = "generator.GeneratorForPhieuMuonId")
	private String id;
	
	private Date ngayMuon;
	private Date ngayTra;
	@Column(columnDefinition = "NVarchar(255)")
	private String trangThai = "Chưa trả";
	@OneToOne
	@JoinColumn(name="thuThuId")
	private ThuThu thuThu;
	
	@OneToOne
	@JoinColumn(name="docGiaId")
	private DocGia docGia;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public ThuThu getThuThu() {
		return thuThu;
	}

	public void setThuThu(ThuThu thuThu) {
		this.thuThu = thuThu;
	}

	public DocGia getDocGia() {
		return docGia;
	}

	public void setDocGia(DocGia docGia) {
		this.docGia = docGia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public PhieuMuon() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public PhieuMuon(Date ngayMuon, Date ngayTra, String trangThai, ThuThu thuThu, DocGia docGia) {
		super();
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
		this.trangThai = trangThai;
		this.thuThu = thuThu;
		this.docGia = docGia;
	}

	@Override
	public String toString() {
		return "PhieuMuon [id=" + id + ", ngayMuon=" + ngayMuon + ", ngayTra=" + ngayTra + ", thuThu=" + thuThu
				+ ", docGia=" + docGia + "]";
	}
	
	
	
}
