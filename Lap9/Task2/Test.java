package Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Test {
private static final int Anpham = 0;
private static final int Comparator = 0;

public static void main(String[] args) {
	//Tao ds an pham
	List<Anpham> anphams = new ArrayList<>();
	
	//Tạo chương
	List<Chuongsach> chuong = new ArrayList<>();
	Chuongsach c1 = new Chuongsach("Chương 1", 50);
	Chuongsach c2 = new Chuongsach("Chương 2", 30);
	chuong.add(c1);
	chuong.add(c2);
	
	//Tạo và thêm các ấn phẩm vào danh mục
	//anphams.add(new Anpham("New York", 100, 1990, "Ben", 5000));
	Sachthamkhao s1 = new Sachthamkhao("Toán", 200, 2020, "Nguyễn Thị Ngọc Mai", 25.5, "Giáo dục",chuong);
	Sachthamkhao s2 = new Sachthamkhao("Văn", 400, 2021, "Nguyễn Thị Ngọc Mai", 25.0, "Giáo dục", chuong);
	Tapchi t1 = new Tapchi("New York", 100, 1990, "Ben", 5000, "Tạp chí thời trang");
    Tapchi t2 = new Tapchi("Thanh niên", 200, 2021, "Nguyễn Thị Ngọc Ly", 2000, "Đoàn Thanh niên");
    
    //test cau6
	String stk = s1.loaiAnpham();
	System.out.println("Loại ấn phẩm: " + stk);
    String tc = t1.loaiAnpham();
	System.out.println("Loại ấn phẩm: " + tc);
	
	//Tạo danh mục ấn phẩm 
    anphams.add(s1);
    anphams.add(s2);
    anphams.add(t1);
    anphams.add(t2);
    System.out.println(anphams);
    
     //test cau7
    boolean kt = t1.kiemtraTapchi();
    System.out.println(kt);
    
    //test cau8
    boolean kt2 = t1.ktTacgia(t2);
    boolean kt3 = s1.ktTacgia(s2);
    System.out.println(kt2);
    System.out.println(kt3);
    
    //test cau9
    DanhmucAnpham anpham = new DanhmucAnpham(anphams);
	int tongTien = anpham.tinhTongTien();
	System.out.println("Tổng tiền các ấn phẩm trong nhà sách: "+ tongTien);
    
    //test cau10
    DanhmucAnpham apham = new DanhmucAnpham(anphams);
    Sachthamkhao s = apham.NhieuTrangNhat();
    System.out.println("Quyển sách tham khảo có chương sách nhiều trang nhất:" + s);
 	
    //test cau11
    boolean b1 = apham.coTapChi("Tuoi hoc tro");
	boolean b2 = apham.coTapChi("Da bong so 1");
	System.out.println("Ấn phẩm có chứa tạp chí có tên cho trước ko: "+ b1);
	System.out.println("Ấn phẩm có chứa tạp chí có tên cho trước ko: "+ b2);
	
	//test cau12
	int namChoTruoc = 2014;
	List<Anpham> tapChi = apham.xuatBan1NamTrc(namChoTruoc);
	System.out.println("Danh sách tạp chí đc xuất bản từ năm cho trước: " + Arrays.toString(tapChi.toArray()));
	
	//test cau13
	Collections.sort(anphams,new Comparator<Anpham>() {

		@Override
		public int compare(Task2.Anpham o1, Task2.Anpham o2) {
			// TODO Auto-generated method stub
			return o1.tacgia.compareTo(o2.tacgia);
		}
	});
	System.out.println("Danh sách các ấn phẩm đã được sắp xếp: " + Arrays.toString(anphams.toArray()));
	
	//test cau14
	Map<Integer, Integer> thongKe = apham.anPhamTheoNam();
	System.out.println("Thống kê ấn phâm theo năm:");
	for (Map.Entry<Integer, Integer> entry :thongKe.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}
}
