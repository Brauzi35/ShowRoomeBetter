package logic.engclasses.bean;

public class PlaceBean {

	protected String nameBean;
	private int capacityBean;
	protected String addressBean;
	private String freeBean; //free is used to get who has booked this place
	
	
	public String getName() {
		return nameBean;
	}
	public void setName(String name) {
		this.nameBean = name;
	}
	public int getCapacity() {
		return capacityBean;
	}
	public void setCapacity(int capacity) {
		this.capacityBean = capacity;
	}
	public String getAddress() {
		return addressBean;
	}
	public void setAddress(String address) {
		this.addressBean = address;
	}
	public String isFree() {
		return freeBean;
	}
	public void setFree(String free) {
		this.freeBean = free;
	}
}
