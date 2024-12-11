package bean;
public class Carrier {
    private int id;
    private String carrierName;
    private int discount30Days;
    private int discount60Days;
    private int discount90Days;
    private int bulkBookingDiscount;
    private int refund2Days;
    private int refund10Days;
    private int refund20Days;
    private int silverUserDiscount;
    private int goldUserDiscount;
    private int platinumUserDiscount;
    //public Carrier() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public int getDiscount30Days() {
		return discount30Days;
	}
	public void setDiscount30Days(int discount30Days) {
		this.discount30Days = discount30Days;
	}
	public int getDiscount60Days() {
		return discount60Days;
	}
	public void setDiscount60Days(int discount60Days) {
		this.discount60Days = discount60Days;
	}
	public int getDiscount90Days() {
		return discount90Days;
	}
	public void setDiscount90Days(int discount90Days) {
		this.discount90Days = discount90Days;
	}
	public int getBulkBookingDiscount() {
		return bulkBookingDiscount;
	}
	public void setBulkBookingDiscount(int bulkBookingDiscount) {
		this.bulkBookingDiscount = bulkBookingDiscount;
	}
	public int getRefund2Days() {
		return refund2Days;
	}
	public void setRefund2Days(int refund2Days) {
		this.refund2Days = refund2Days;
	}
	public int getRefund10Days() {
		return refund10Days;
	}
	public void setRefund10Days(int refund10Days) {
		this.refund10Days = refund10Days;
	}
	public int getRefund20Days() {
		return refund20Days;
	}
	public void setRefund20Days(int refund20Days) {
		this.refund20Days = refund20Days;
	}
	public int getSilverUserDiscount() {
		return silverUserDiscount;
	}
	public void setSilverUserDiscount(int silverUserDiscount) {
		this.silverUserDiscount = silverUserDiscount;
	}
	public int getGoldUserDiscount() {
		return goldUserDiscount;
	}
	public void setGoldUserDiscount(int goldUserDiscount) {
		this.goldUserDiscount = goldUserDiscount;
	}
	public int getPlatinumUserDiscount() {
		return platinumUserDiscount;
	}
	public void setPlatinumUserDiscount(int platinumUserDiscount) {
		this.platinumUserDiscount = platinumUserDiscount;
	}
}
