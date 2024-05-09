package modelo.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="countries")
public class Country implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public int hashCode() {
		return Objects.hash(countryId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Country))
			return false;
		Country other = (Country) obj;
		return Objects.equals(countryId, other.countryId);
	}


	@Id
	@Column(name="country_id")
	private String countryId;
	@Column(name="country_name")
	private String countryName;
	//unidireccional
	@ManyToOne
	@JoinColumn(name="region_id")
	private Region region;
	
	
	public Country() {
		super();
	}


	public Country(String countryId, String countryName, Region region) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.region = region;
	}


	public String getCountryId() {
		return countryId;
	}


	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}


	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", region=" + region + "]";
	}
	
	

}
