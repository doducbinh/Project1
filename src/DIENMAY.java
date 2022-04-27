
public class DIENMAY extends SANPHAM{
	public DIENMAY(String msp,String tensp,float soluong,float dongia) {
		super(msp,tensp,soluong,dongia);
}
	float tinhtien() {
		float tt=(float) (getDongia()*getSoluong()*(1-0.1));
				return tt;
	}
}
