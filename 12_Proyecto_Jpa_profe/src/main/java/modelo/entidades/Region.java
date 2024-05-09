package modelo.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="regions")
public class Region implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="region_id")
	private int regionId;
	@Column(name="region_name")
	private String regionName;
	
	public Region(int regionId, String regionName) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
	}

	public Region() {
		super();
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionName=" + regionName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(regionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Region))
			return false;
		Region other = (Region) obj;
		return regionId == other.regionId;
	}
	
	
	
	

}
