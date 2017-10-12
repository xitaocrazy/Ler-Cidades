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
	
	@Override
	public String toString() {
		return "Cidade [ibge_id= " + this.ibgeId 
				+ " , uf=" + this.uf
		    	+ " , name=" + this.name
		    	+ " , capital=" + this.capital
		    	+ " , lon=" + this.longitude
		    	+ " , lat=" + this.latitude
		    	+ " , no_accents=" + this.noAccents
		    	+ " , alternative_names=" + this.alternativeNames
		    	+ " , microregion=" + this.microRegion
		    	+ " , mesoregion=" + this.mesoRegion + "]";
	}

	@Override
	public int hashCode() {
	    int hashCode = 1;
	    hashCode = (hashCode * 31) ^ (this.ibgeId != null ? this.ibgeId.hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (this.uf != null ? this.uf.hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (this.name != null ? this.name.hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (this.capital != null ? this.capital.hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (this.longitude != null ? this.longitude.hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (this.latitude != null ? this.latitude.hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (this.noAccents != null ? this.noAccents.hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (this.alternativeNames != null ? this.alternativeNames.hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (this.microRegion != null ? this.microRegion.hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (this.mesoRegion != null ? this.mesoRegion.hashCode() : 0);
	    return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null){
	    	return false;
	    }      
	    if (this == obj) {
	        return true;
	    }
	    if (getClass() != obj.getClass()) {
	        return false;
	    }
	    
	    Cidade other = (Cidade) obj;
	    if (!this.ibgeId.equals(other.getIbgeId()) || 
	    	!this.uf.equals(other.getUf()) ||
	    	!this.name.equals(other.getName()) ||
	    	!this.capital.equals(other.getCapital()) ||
	    	!this.longitude.equals(other.getLongitude()) ||
	    	!this.latitude.equals(other.getLatitude()) ||
	    	!this.noAccents.equals(other.getNoAccents()) ||
	    	!this.alternativeNames.equals(other.getAlternativeNames()) ||
	    	!this.microRegion.equals(other.getMicroRegion()) ||
	    	!this.mesoRegion.equals(other.getMesoRegion())) {
	        return false;
	    }
	    	    
	    return true;
	}
}
