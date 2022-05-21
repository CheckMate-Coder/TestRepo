import jakarta.persistence.*;

@Entity(name="Hib_Warenkorb")
@IdClass (WarenkorbPK_Beispiel.class)
public class Warenkorb_Beisipiel{
	@ManyToOne
	@JoinColumn(name="pnr", referencedColumnName = "pnr", insertable = false, updatable=false)
	private Kunde_Beispiel kunde;
	@ManyToOne
	@JoinColumn(name="artikelnummer", referencedColumnName = "artikelnummer", insertable = false, updatable=false)
	private Artikel_Beispiel artikel;
	@Column(name="anzahl", nullable=false)
	private Long anzahl;
	@Id
	@Column(name="artikelnummer", nullable=false)
	private Long artikelnummer;
	@Id
	@Column(name="pnr", nullable=false)
	private Long pnr;
	public Warenkorb_Beisipiel() {
	}
	public Warenkorb_Beisipiel(Kunde_Beispiel kunde, Artikel_Beispiel artikel, Long anzahl) {
		this.anzahl = anzahl;
		this.artikel = artikel;
		this.kunde = kunde;
		this.artikelnummer = artikel.getArtikelnummer();
		this.pnr = kunde.getPnr();
	}

	
	
	public void setArtikelnummer(Long artikelnummer)
	{
		this.artikelnummer = artikelnummer;
	}
	public void setPnr(Long pnr)
	{
		this.pnr = pnr;
	}
	public Artikel_Beispiel getArtikel() {
		return artikel;
	}
	public Kunde_Beispiel getKunde() {
		return kunde;
	}

}
