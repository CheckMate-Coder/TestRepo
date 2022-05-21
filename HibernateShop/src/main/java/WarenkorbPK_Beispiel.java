import java.util.Objects;

public class WarenkorbPK_Beispiel{
	private Long artikelnummer;
	private Long pnr;
	
	public boolean equals(Object other) {
		if(other instanceof WarenkorbPK_Beispiel) {
			final WarenkorbPK_Beispiel otherWarenkorbPK = (WarenkorbPK_Beispiel) other;
			final boolean areEqual=
					(otherWarenkorbPK.artikelnummer.equals(artikelnummer))
					&& otherWarenkorbPK.pnr.equals(pnr);
			return areEqual;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(artikelnummer, pnr);
	}
}
