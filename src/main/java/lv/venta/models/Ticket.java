package lv.venta.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "ticket_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Ticket {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idt")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long idt;
	
	@NotNull
	@Column(name = "PurchaseDateTime")
	private LocalDateTime purchaseDateTime;
	
	@NotNull
	@Column(name = "Price") 
    @Min(value = 0, message = "Jabut 0 un ne vairak ka 10000 simboliem")
    @Max(value = 10000, message = "Jabut 0 un ne vairak ka 10000 simboliem")
    private float price;
	
	@NotNull
	@Column(name = "Trip")
	private String trip;
	
	@NotNull
	@Column(name = "IsChild")
	private boolean isChild;
	
	@NotNull
	@Column(name = "Cashier")
	private String cashier;

	public Ticket(LocalDateTime purchaseDateTime, float price, String trip, boolean isChild, String cashier) {
		this.purchaseDateTime = purchaseDateTime;
		this.price = price;
		this.trip = trip;
		this.isChild = isChild;
		this.cashier = cashier;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

