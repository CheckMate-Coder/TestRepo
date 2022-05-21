import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;

public class Main_Beispiel {
@PersistenceUnit
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
@PersistenceContext
static EntityManager em;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kunde_Beispiel k = new Kunde_Beispiel("Theo", "Test", "theotest@mail.de");
		Artikel_Beispiel a = new Artikel_Beispiel(1L, "Cola", 2.00);
		kundeEinfuegen(k);
		Warenkorb_Beisipiel w = new Warenkorb_Beisipiel(k, a, 5L);
		artikelEinfuegen(a);
		warenkorbEinfuegen(w);
		showKundeWarenkorb(k.getPnr());
		
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	@Transactional
	public static void kundeEinfuegen(Kunde_Beispiel kunde) {
		
		em = getEntityManager();
		em.getTransaction().begin();
		em.persist(kunde);
		em.getTransaction().commit();
		em.close();
	}
	


	
	public static Kunde_Beispiel getKunde(Long id)
	{
		EntityManager em = getEntityManager();
		Kunde_Beispiel kunde = em.find(Kunde_Beispiel.class, id);
		em.detach(kunde);
		return kunde;
	}
	
	public static void showKundeWarenkorb(Long pnr)
	{
		Kunde_Beispiel k = getKunde(pnr);
		List<Warenkorb_Beisipiel> warenkorbList = k.getWarenkorbList();
		System.out.println("Warenkorb von " + k.getVorname() + " " + k.getNachname() + " " + k.getEmail());
		for(Warenkorb_Beisipiel warenkorbItem : warenkorbList)
		{
			System.out.println(warenkorbItem.getArtikel().getArtikelname());
		}
	}
	
	public static void artikelEinfuegen(Artikel_Beispiel artikel) {

		em = getEntityManager();
		em.getTransaction().begin();
		em.persist(artikel);
		em.getTransaction().commit();
		em.close();


	}
	public static void warenkorbEinfuegen(Warenkorb_Beisipiel warenkorb) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(warenkorb);
		em.getTransaction().commit();

	}
	public static Kunde_Beispiel getKundeFromDB(Long pnr) 
	{
		Kunde_Beispiel kunde = getEntityManager().find(Kunde_Beispiel.class, pnr);
		return kunde;
	}
	

	
	
	
}