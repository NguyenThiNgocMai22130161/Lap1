package Task2;

import java.util.Calendar;

public class Tapchi extends Anpham{
	String tentapchi;
	public Tapchi(String tieude, int sotrang, int namxuatban, String tacgia, double giatien,
			String tentapchi) {
		super(tieude, sotrang, namxuatban, tacgia, giatien);
		this.tentapchi = tentapchi;
	}
	public String getTentapchi() {
		return tentapchi;
	}
	@Override
	public String loaiAnpham() {
		// TODO Auto-generated method stub
		return "Tạp chí";
	}
	
	

	@Override
	public String toString() {
		return "Tapchi [tentapchi=" + tentapchi + ", tieuDe=" + tieude + ", soTrang=" + sotrang + ", namXuatBan=" + namxuatban
				+ ", tacGia=" + tacgia + ", gia=" + giatien + "]";
	}
	//Kiểm tra ấn phẩm là tạp chí và có thời gian xuất bản cách đây 
    //(2021) 10 năm hay không
	public boolean kiemtraTapchi() {
		int nam = Calendar.getInstance().get(Calendar.YEAR);
		return (nam - getNamxuatban()) >= 10;
	}
}
