import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class DanhSachSinhVien {
	private ArrayList<SinhVien> danhSachArrayList;

	public DanhSachSinhVien() {
		this.danhSachArrayList = new ArrayList<SinhVien>();
	}

	public DanhSachSinhVien(ArrayList<SinhVien> danhSachArrayList) {
		this.danhSachArrayList = danhSachArrayList;
	}

	public void themSinhVien(SinhVien sv) {
		danhSachArrayList.add(sv);
	}

	public void inThongTin() {
		for (SinhVien sinhVien : danhSachArrayList) {
			System.out.println(sinhVien.toString());
		}
	}

	public boolean kiemTraDanhSach() {
		return this.danhSachArrayList.isEmpty();
	}

	public int soLuongSinhVien() {
		return this.danhSachArrayList.size();
	}

	public void xoaDanhSach() {
		if (this.soLuongSinhVien() > 0) {
			this.danhSachArrayList.removeAll(danhSachArrayList);
			System.out.println("Lam rong danh sach sinh vien thanh cong ");
		} else {
			System.out.println("danh sach sinh vien dang rong ");
		}
	}

	public boolean kiemTraSinhVien(SinhVien sv) {
		return this.danhSachArrayList.contains(sv);
	}

	public boolean xoaSinhVien(SinhVien sv) {
		return this.danhSachArrayList.remove(sv);
	}

	public void timSinhVien(String ten) {
		for (SinhVien sinhVien : danhSachArrayList) {
			if (sinhVien.getTenSinhVien().indexOf(ten) > 0) {
				System.out.println(sinhVien);
			}
		}
	}

	public void sapXepSinhVienGiamDanTheoDiem() {
		Collections.sort(danhSachArrayList, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				if (o1.getDiemTrungBinh() < o2.getDiemTrungBinh()) {
					return 1;
				} else if (o1.getDiemTrungBinh() > o2.getDiemTrungBinh()) {
					return -1;
				} else {
					return 0;
				}
			}

		});
	}

	public void ghiTapTin(File f) {
		try {
			OutputStream os = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			for (SinhVien sinhVien : danhSachArrayList) {
				oos.writeObject(sinhVien);
			}
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void docTapTin(File file) {
		try {
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			SinhVien sVien= null;
			while (true) {
				Object object = ois.readObject();
				if(object==null) {
					break;
				}
				if(object!=null) {
					sVien = (SinhVien) object;
					this.danhSachArrayList.add(sVien);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
