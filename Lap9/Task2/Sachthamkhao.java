package Task2;

import java.util.ArrayList;
import java.util.List;

public class Sachthamkhao extends Anpham{
	String linhvuc;
static List<Chuongsach> chuongsach;
public Sachthamkhao(String tieude, int sotrang, int namxuatban, String tacgia, double giatien, String linhvuc,List<Chuongsach> chuongsach) {
	super(tieude, sotrang, namxuatban, tacgia, giatien);
	this.linhvuc = linhvuc;
	this.chuongsach = chuongsach;
}

public void setLinhvuc(String linhvuc) {
	this.linhvuc = linhvuc;
}

public void setChuongsach(List<Chuongsach> chuongsach) {
	this.chuongsach = chuongsach;
}

public String getLinhvuc() {
	return linhvuc;
}

public List<Chuongsach> getChuongsach() {
	return chuongsach;
}

public void themchuong(Chuongsach chuong) {
	chuongsach.add(chuong);
}

public String loaiAnPham() {
	return "Sach tham khao";
}
@Override
public String toString() {
	return "SachThamKhao [linhVuc=" + linhvuc + ", dsChuong=" + chuongsach+ "]";
}

//Tìm quyển sách tham khảo có chương sách nhiều trang nhất
public int chuongnhieutrangnhat() {
	int chuongnhieutrangnhat = -1;
	for(Chuongsach chuongSach : chuongsach) {
		if(chuongSach.getSotrang() > chuongnhieutrangnhat) {
			chuongnhieutrangnhat = chuongSach.getSotrang();
		}
	}
	return chuongnhieutrangnhat;
}
}
