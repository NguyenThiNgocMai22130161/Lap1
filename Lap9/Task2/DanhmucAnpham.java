package Task2;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhmucAnpham {
	List<Anpham> dsAnPham;
	private PublicKey[] publications;

	/**
	 * @param dsAnPham
	 */
	public DanhmucAnpham(List<Anpham> dsAnPham) {
		this.dsAnPham = dsAnPham;
	}
	public int tinhTongTien() {
		int tongTien = 0;
		for(Anpham anPham : dsAnPham) {
			tongTien += anPham.getGiatien();
		}
		return tongTien;
	}
	
	public Sachthamkhao NhieuTrangNhat () {
		Sachthamkhao nhieuTrangNhat = null;
		int maxSoTrang = -1;
		
		for(Anpham apham : dsAnPham) {
			if(apham instanceof Sachthamkhao) {
				Sachthamkhao sach = (Sachthamkhao) apham;
				int chuongnhieutrangnhat = sach.chuongnhieutrangnhat();
				
				if(chuongnhieutrangnhat > maxSoTrang) {
					maxSoTrang = chuongnhieutrangnhat;
					nhieuTrangNhat = sach;
				}
			}
		}
		return nhieuTrangNhat;
		
	}
	public boolean coTapChi(String tenTapChi) {
		for (Anpham apham: dsAnPham) {
			if(apham instanceof Tapchi) {
				Tapchi tapChi = (Tapchi) apham;
				if(tapChi.getTentapchi().equals(tenTapChi)) {
					return true;
				}
			}
		}
		return false;
	}
	public List<Anpham> xuatBan1NamTrc(int nam){
		List<Anpham> result = new ArrayList<>();
		if(dsAnPham != null) {
			for(Anpham apham : dsAnPham) {
				if( apham instanceof Tapchi) {
					Tapchi tapChi = (Tapchi) apham;
					if(tapChi.getNamxuatban() == nam) {
						result.add(tapChi);
					}
				}
			}
		}
		return result;
		
	}
	public Map<Integer, Integer> anPhamTheoNam() {
		Map<Integer, Integer> thongKe = new HashMap<>();
		for(Anpham apham : dsAnPham) {
			int namXuatBan = apham.getNamxuatban();
			thongKe.put(namXuatBan, thongKe.getOrDefault(namXuatBan, 0) +1);
			
		}
		for( Map.Entry<Integer, Integer> entry : thongKe.entrySet()) {
			System.out.println("Năm" +entry.getKey()+": " + entry.getValue()+ " ấn phẩm");
		}
		return thongKe;
	}
	@Override
	public String toString() {
		return "DanhMucAnPham [dsAnPham=" + dsAnPham + "]";
	}
}
