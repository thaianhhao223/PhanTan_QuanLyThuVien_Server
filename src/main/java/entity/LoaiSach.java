package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity	
public class LoaiSach implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6490304271085302270L;

	@Id
	@GeneratedValue(generator = "loaisach_generator")  
	@GenericGenerator(name = "loaisach_generator", strategy = "generator.GeneratorForLoaiSachId")
	private String id;
	
	@Column(columnDefinition = "NVarchar(255)")
	private String tenLoai;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public LoaiSach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiSach(String tenLoai) {
		super();
		this.tenLoai = tenLoai;
	}

	@Override
	public String toString() {
		return "LoaiSach [id=" + id + ", tenLoai=" + tenLoai + "]";
	}
	
	
}
