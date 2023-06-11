package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "person_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {
	
	@Column(name = "Name") 
	@NotNull
	@Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+")
	@Size(min = 3, max = 20)
	private String name;
	
	@Column(name = "Surname") 
	@NotNull
	@Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņģ\\ ]+")
	@Size(min = 3, max = 20)
	private String surname;

	public Person (String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	
	
	
	
	
	
	
	
	
}