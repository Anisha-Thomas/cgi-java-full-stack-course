package org.demo.employee;

public class Location {
	public int locationId;
	public String city;
	public String country;
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Location(int locationId, String city, String country) {
		this.locationId = locationId;
		this.city = city;
		this.country = country;
	}
	public Location() {

	}
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", city=" + city + ", country=" + country + "]";
	}
	
}
