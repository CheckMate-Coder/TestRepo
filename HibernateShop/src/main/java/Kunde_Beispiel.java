import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
@Entity
@DiscriminatorValue("Kunde")
public class Kunde_Beispiel extends Person_Beispiel {
	@Column(name="email")
	private String email;
	public Kunde_Beispiel() {
		super();
	}
	public Kunde_Beispiel(String vorname, String nachname, String email) {
		super(vorname, nachname);
		this.email=email;
		
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	

	@OneToMany(mappedBy="kunde", fetch=FetchType.EAGER)
	private List<Warenkorb_Beisipiel> warenkorbList = new ArrayList<Warenkorb_Beisipiel>();
	
	
	public List<Warenkorb_Beisipiel> getWarenkorbList()
	{
		return warenkorbList;
	}
	@Override
	public String toString()
	{
		return "Kundennr: " + super.getPnr()  + " Vorname" + super.getVorname();
	}


	
}
