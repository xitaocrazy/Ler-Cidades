package services;

public class Cidade {
	private String ibgeId;
	private String uf;
	private String name;	
	private String capital;
	private String longitude;
	private String latitude;
	private String noAccents;
	private String alternativeNames;
	private String microRegion;
	private String mesoRegion;
	
	
	public Cidade(String ibgeId, String uf, String name, String capital, String longitude, String latitude, String noAccents, 
			String alternativeNames, String microRegion, String mesoRegion) {
	    this.ibgeId = ibgeId;
	    this.uf = uf;
	    this.name = name;
	    this.capital = capital;
	    this.longitude = longitude;
	    this.latitude = latitude;
	    this.noAccents = noAccents;
	    this.alternativeNames = alternativeNames;
	    this.microRegion = microRegion;
	    this.mesoRegion = mesoRegion;
	}
	
	
	public String getIbgeId() {
	    return this.ibgeId;
	}
	   
	public void setIbgeId(String ibgeId) {
		this.ibgeId = ibgeId;
	}
	
	public String getUf() {
	    return this.uf;
	}
	   
	public void setUf(String uf) {
		this.ibgeId = uf;
	}
	
	public String getName() {
	    return this.name;
	}
	   
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCapital() {
	    return this.capital;
	}
	   
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	public String getLongitude() {
	    return this.longitude;
	}
	   
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getLatitude() {
	    return this.latitude;
	}
	   
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getNoAccents() {
	    return this.noAccents;
	}
	   
	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}
	
	public String getAlternativeNames() {
	    return this.alternativeNames;
	}
	   
	public void setAlternativeNames(String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}
	
	public String getMicroRegion() {
	    return this.microRegion;
	}
	   
	public void setMicroRegion(String microRegion) {
		this.name = microRegion;
	}
	
	public String getMesoRegion() {
	    return this.mesoRegion;
	}
	   
	public void setMesoRegion(String mesoRegion) {
		this.name = mesoRegion;
	}
}
