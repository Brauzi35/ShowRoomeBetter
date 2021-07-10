package logic.model;

public class Place {
	//represents a place 
	
	protected String name;
	private int capacity;
	protected String address;
	private String free;
	
	public Place(String name, int capacity, String address, String free) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.address = address;
		this.free = free;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String isFree() {
		return free;
	}
	public void setFree(String free) {
		this.free = free;
	}
	
	
	
	
}
