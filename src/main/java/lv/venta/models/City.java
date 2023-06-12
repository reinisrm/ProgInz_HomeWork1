package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "city_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class City {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idc")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idc;
	
	@NotNull
	@Column(name = "Title")
	private String title;
	
	@Column(name = "AddressOfStation")
	@NotNull
	private String addressOfStation;
	
	
	
	//ManyToMany Trip
	@ManyToMany 
	@JoinTable(name = "trip_city_table",
	joinColumns = @JoinColumn(name="Idtr"),
	inverseJoinColumns = @JoinColumn(name="Idc"))
	private Collection<Trip> trip;

	public City(String title, String addressOfStation) {
		this.title = title;
		this.addressOfStation = addressOfStation;
	}
	
	
	
}
