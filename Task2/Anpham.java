package Task2;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public abstract class Anpham {
	String tieude;
	int sotrang;
	int namxuatban;
	String tacgia;
	double giatien;
	public Anpham(String tieude, int sotrang, int namxuatban, String tacgia, double giatien ){
		super();
		this.tieude = tieude;
		this.sotrang = sotrang;
		this.namxuatban = namxuatban;
		this.tacgia = tacgia;
		this.giatien = giatien;
	}

public String getTieude() {
		return tieude;
	}

	public int getSotrang() {
		return sotrang;
	}

	public int getNamxuatban() {
		return namxuatban;
	}

	public String getTacgia() {
		return tacgia;
	}

	public double getGiatien() {
		return giatien;
	}

	
public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public void setSotrang(int sotrang) {
		this.sotrang = sotrang;
	}

	public void setNamxuatban(int namxuatban) {
		this.namxuatban = namxuatban;
	}

	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}

	public void setGiatien(double giatien) {
		this.giatien = giatien;
	}

public String loaiAnpham() {
	// TODO Auto-generated method stub
	return " ";
}
public boolean kiemTraXuatBanVaLaTapChi() {
	if (this instanceof Tapchi) {
		int nam = LocalDate.now().getYear();
		return (nam - getNamxuatban() >= 10);

	}
	return false;

}
//Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
public boolean ktTacgia(Anpham ap) {
	return this.getClass().equals(ap.getClass()) && this.tacgia.equals(ap.tacgia);
}
//Tính tổng tiền của tất các ấn phẩm trong nhà sách
public static double tinhTien(List<Anpham> ap) {
	double tongTien = 0.0;
	for (Anpham anpham : ap) {
		tongTien += anpham.getGiatien();
	}
	return tongTien;
}
public int compareTo(Anpham o) {
	// xếp tăng dần theo tieu đề
	int xepTieuDe = this.tieude.compareTo(o.tieude);
	if(xepTieuDe != 0) {
		return xepTieuDe;
	}
	// xếp giảm dần theo năm xuất bản
	return Integer.compare(o.namxuatban, this.namxuatban);
}
}

