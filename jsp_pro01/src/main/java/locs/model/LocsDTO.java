package locs.model;

public class LocsDTO {
	private int locsId;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	private String countryId;
	
	public int getLocsId() {
		return locsId;
	}
	
	public void setLocsId(int locsId) {
		this.locsId = locsId;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStateProvince() {
		return stateProvince;
	}
	
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	
	public String getCountryId() {
		return countryId;
	}
	
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "LocsDTO [locsId=" + locsId + ", streetAddress=" + streetAddress + ", postalCode=" + postalCode + ", city="
				+ city + ", stateProvince=" + stateProvince + ", countryId=" + countryId + "]";
	}

}
