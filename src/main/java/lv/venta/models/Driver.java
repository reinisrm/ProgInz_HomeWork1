package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "driver_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Driver extends Person{
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idd")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long idd;
	
	@NotNull
	@Column(name = "BusCategory")
	Buscategory busCategory;

	@OneToMany(mappedBy = "drivers")
	@ToString.Exclude
	private Collection<Trip> trip;
	
	
	public Driver(String name, String surname, Buscategory busCategory) {
		super(name, surname);
		this.busCategory = busCategory;
	}
	
	
}
