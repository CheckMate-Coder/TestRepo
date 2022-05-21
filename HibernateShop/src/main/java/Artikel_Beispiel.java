import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="Hib_Artikel")
public class Artikel_Beispiel {
	@Column(length = 50)
	private String artikelname;
	
	@Id
	@Column(nullable = false)
	private Long artikelnummer;
	@Column
	private double preis;
	
	@OneToMany(mappedBy = "artikel", fetch=FetchType.EAGER)
	private List<Warenkorb_Beisipiel> warenkorbList;
	
	public Artikel_Beispiel()
	{
	}
	public Artikel_Beispiel(Long artikelnummer, String artikelname, double preis) {
		this.artikelname = artikelname;
		this.artikelnummer = artikelnummer;
		this.preis = preis;
	}


	public String getArtikelname() {
		return artikelname;
	}

	public void setArtikelname(String artikelname) {
		this.artikelname = artikelname;
	}

	public Long getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(Long artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public List<Warenkorb_Beisipiel> getWarenkorbList() {
		return warenkorbList;
	}

	public void setWarenkorbList(List<Warenkorb_Beisipiel> warenkorbList) {
		this.warenkorbList = warenkorbList;
	}

	


}
