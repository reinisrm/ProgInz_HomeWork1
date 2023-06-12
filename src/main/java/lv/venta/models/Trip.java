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
import jakarta.validation.constraints.Pattern;
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
	public long idtr;
	
	@Column(name = "Cities") 
	@NotNull
	@Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+")
	@Size(min = 3, max = 20)
	private String cities;
	
	@Column(name = "Driver")
	@NotNull
	@Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+")
	@Size(min = 3, max = 30)
	private String driver;
	
	@Column(name = "StartDateTime")
	@NotNull
	private LocalDateTime startDateTime;
	
	@Column(name = "Duration")
	@NotNull
	@Size(min = 3, max = 50)
	private String duration;

	@ManyToOne
	@JoinColumn(name = "Idd")
	private Driver tripDriver;
	
	@OneToMany(mappedBy = "")
	@ToString.Exclude
	private Collection<Ticket> ticketTrip;
	
	@ManyToMany(mappedBy = "trips")
	private Collection<City> cityTrip = new ArrayList<>(); 
	
	
	public Trip(String cities, String driver, LocalDateTime startDateTime, String duration) {
		this.cities = cities;
		this.driver = driver;
		this.startDateTime = startDateTime;
		this.duration = duration;
	}
	
	
	
	

}
