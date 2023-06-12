package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "cashier_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cashier extends Person {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idc")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long idc;
	
	
	
	//OneToMany ticket
	@OneToMany(mappedBy = "cashier")
	@ToString.Exclude
	private Collection<Ticket> ticket;
	
	public Cashier(String name, String surname) {
		super(name, surname);
	}
	
	
}
