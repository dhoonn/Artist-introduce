package DTO;

public class FollowDTO {
	private int fnumber;
	private String mfollow;
	private String mid;
	
	public FollowDTO() {
		
	}

	public int getFnumber() {
		return fnumber;
	}

	public void setFnumber(int fnumber) {
		this.fnumber = fnumber;
	}

	public String getMfollow() {
		return mfollow;
	}

	public void setMfollow(String mfollow) {
		this.mfollow = mfollow;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public FollowDTO(int fnumber, String mfollow, String mid) {
		super();
		this.fnumber = fnumber;
		this.mfollow = mfollow;
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "FollowDTO [fnumber=" + fnumber + ", mfollow=" + mfollow + ", mid=" + mid + "]";
	}

	

	
	
	
}
