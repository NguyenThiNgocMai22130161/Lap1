package Task2;

public class Chuongsach {
	String tieude;
    int sotrang;

    public Chuongsach(String tieude, int sotrang) {
        this.tieude = tieude;
        this.sotrang = sotrang;
    }

	public String getTieude() {
		return tieude;
	}

	public int getSotrang() {
		return sotrang;
	}

	@Override
	public String toString() {
		return "Chuongsach [tieude=" + tieude + ", sotrang=" + sotrang + "]";
	}
    
}
