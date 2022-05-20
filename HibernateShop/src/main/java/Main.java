import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;

public class Main {
@PersistenceUnit
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
@PersistenceContext
static EntityManager em;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kunde k = new Kunde("Theo", "Test", "theotest@mail.de");
		Artikel a = new Artikel(1L, "Cola", 2.00);
		kundeEinfuegen(k);
		Warenkorb w = new Warenkorb(k, a, 5L);
		artikelEinfuegen(a);
		warenkorbEinfuegen(w);
		showKundeWarenkorb(k.getPnr());
		
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	@Transactional
	public static void kundeEinfuegen(Kunde kunde) {
		
		em = getEntityManager();
		em.getTransaction().begin();
		em.persist(kunde);
		em.getTransaction().commit();
		em.close();
	}
	


	
	public static Kunde getKunde(Long id)
	{
		EntityManager em = getEntityManager();
		Kunde kunde = em.find(Kunde.class, id);
		em.detach(kunde);
		return kunde;
	}
	
	public static void showKundeWarenkorb(Long pnr)
	{
		Kunde k = getKunde(pnr);
		List<Warenkorb> warenkorbList = k.getWarenkorbList();
		System.out.println("Warenkorb von " + k.getVorname() + " " + k.getNachname() + " " + k.getEmail());
		for(Warenkorb warenkorbItem : warenkorbList)
		{
			System.out.println(warenkorbItem.getArtikel().getArtikelname());
		}
	}
	
	public static void artikelEinfuegen(Artikel artikel) {

		em = getEntityManager();
		em.getTransaction().begin();
		em.persist(artikel);
		em.getTransaction().commit();
		em.close();


	}
	public static void warenkorbEinfuegen(Warenkorb warenkorb) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(warenkorb);
		em.getTransaction().commit();

	}
	public static Kunde getKundeFromDB(Long pnr) 
	{
		Kunde kunde = getEntityManager().find(Kunde.class, pnr);
		return kunde;
	}
	

	
	
	
}