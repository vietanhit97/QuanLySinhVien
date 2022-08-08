import java.io.Serializable;
import java.util.Objects;

public class SinhVien implements Comparable<SinhVien>,Serializable{
	private String maSinhVien ;
	private String tenSinhVien;
	private int namSinh ;
	private double diemTrungBinh;
	
	public SinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public SinhVien(String maSinhVien, String tenSinhVien, int namSinh, double diemTrungBinh) {
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.namSinh = namSinh;
		this.diemTrungBinh = diemTrungBinh;
	}
	
	public String getMaSinhVien() {
		return maSinhVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSinhVien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Objects.equals(maSinhVien, other.maSinhVien);
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public double getDiemTrungBinh() {
		return diemTrungBinh;
	}

	public void setDiemTrungBinh(double diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}
	

	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", tenSinhVien=" + tenSinhVien + ", namSinh=" + namSinh
				+ ", diemTrungBinh=" + diemTrungBinh + "]";
	}
	@Override
	public int compareTo(SinhVien o) {
		return this.maSinhVien.compareTo(o.maSinhVien);
	}
	
}
