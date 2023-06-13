package lv.venta.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "trip_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Trip {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idtr")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int idtr;
	
	@NotNull
	@Column(name = "StartDateTime")
	@NotNull
	private LocalDateTime startDateTime;
	
	@Column(name = "Duration")
	@NotNull
	@Size(min = 3, max = 50)
	private String duration;
	
	
	
	
	//ManyToMany cities
	@ManyToMany(mappedBy = "trips")
	@ToString.Exclude
	private Collection<City> cities = new ArrayList<>(); 
	
	//ManyToOne Driver
	@ManyToOne
	@ToString.Exclude
	@JoinColumn(name = "Idd")
	private Driver driver;
	
	//OneToMany ticket
	@OneToMany(mappedBy = "trip")
	@ToString.Exclude
	private Collection<Ticket> ticket;
	
	
	
	
	public Trip(ArrayList<City> cities, Driver driver, LocalDateTime startDateTime, String duration) {
		this.cities = cities;
		this.driver = driver;
		this.startDateTime = startDateTime;
		this.duration = duration;
	}
	
	public void addCity(City city) {
		
		if (!cities.contains(city)) {
			cities.add(city);
		}
		
	}
	

	
	
	

}
