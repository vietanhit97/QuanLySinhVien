import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DanhSachSinhVien  danhSachSinhVien = new DanhSachSinhVien();
		int luaChon=0;
		while (true) {
			System.out.println("MENU ---------- ");
			System.out.println(
			  "1.	Thêm sinh viên vào danh sách.\n"
			+ "2.	In danh sách sinh viên ra màn hình.\n"
			+ "3.	Kiểm tra danh sách có rỗng hay không.\n"
			+ "4.	Lấy ra số lượng sinh viên trong danh sách.\n"
			+ "5.	Làm rỗng danh sách sinh viên.\n"
			+ "6.	Kiểm tra sinh viên có tồn tại trong danh sách hay không, dựa trên mã sinh viên.\n"
			+ "7.	Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên.\n"
			+ "8.	Tìm kiếm tất cả sinh viên dựa trên Tên được nhập từ bàn phím.\n"
			+ "9.	Xuất ra danh sách sinh viên có điểm từ cao đến thấp.\n"
			+ "10.	Lưu danh sách sinh viên xuống tập tin.\n"
			+ "11.	Đọc sách sinh viên từ tập tin.\n"
			+ "0.   Thoát khỏi chương trình");
			System.out.println("Vui lòng chọn chức năng: ");
			luaChon = sc.nextInt();
			sc.nextLine();
			switch (luaChon) {
			case 1: {
				System.out.println("Nhập số sinh viên muốn thêm mới :");
				int soLuongSinhVien = sc.nextInt();
				for(int i = 0 ; i<soLuongSinhVien;i++) {
					sc.nextLine();
					System.out.println("Nhập mã sinh viên : ");
					String maSinhVien = sc.nextLine();
					System.out.println("Nhập tên sinh vien :");
					String tenSinhVien = sc.nextLine();
					System.out.println("Nhập lớp học sinh viên");
					int lopHoc = sc.nextInt();
					System.out.println("Nhập điểm trung bình sinh vien :");
					double diemTrungBinh = sc.nextDouble();
					SinhVien sv = new SinhVien(maSinhVien, tenSinhVien, lopHoc, diemTrungBinh);
					danhSachSinhVien.themSinhVien(sv);
				}
				break;
			}
			case 2 : {
				danhSachSinhVien.inThongTin();
				break;
			}
			case 3 :{
				if(danhSachSinhVien.kiemTraDanhSach()) {
					System.out.println("danh sach sinh vien dang rong " +danhSachSinhVien.kiemTraDanhSach() );
				}else {
					System.out.println("danh sach sinh vien da ton tai "+danhSachSinhVien.kiemTraDanhSach());
				}
				
				 break;
			}
			case 4: {
				System.out.println(danhSachSinhVien.soLuongSinhVien());
				break;
			}
			case 5 :{
				danhSachSinhVien.xoaDanhSach();
				break;
			}
			case 6 : {
				System.out.println("nhap ma sinh vien can kiem tra :");
				String maString = sc.nextLine();
				SinhVien sVien = new SinhVien(maString);
				System.out.println(danhSachSinhVien.kiemTraSinhVien(sVien));
				break;
			}
			case 7 : {
				System.out.println("nhap ma sinh vien can xoa :");
				String maString = sc.nextLine();
				SinhVien sVien = new SinhVien(maString);
				danhSachSinhVien.xoaSinhVien(sVien);
				break;
			}
			case 8 :{
				System.out.println("nhap ten sinh vien can tim :");
				String tenString = sc.nextLine();
				danhSachSinhVien.timSinhVien(tenString);
				break;
			}
			case 9 :{
				danhSachSinhVien.sapXepSinhVienGiamDanTheoDiem();
				danhSachSinhVien.inThongTin();
				break;
			}
			case 10 :{
				System.out.println("nhap duong dan file :");
				String duongDanString = sc.nextLine();
				File file = new File(duongDanString);
				danhSachSinhVien.ghiTapTin(file);
				break;
			}
			case 11 :{
				System.out.println("nhap duong dan file :");
				String duongDanString = sc.nextLine();
				File file = new File(duongDanString);
				danhSachSinhVien.docTapTin(file);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + luaChon);
			}
		}
	}
}
