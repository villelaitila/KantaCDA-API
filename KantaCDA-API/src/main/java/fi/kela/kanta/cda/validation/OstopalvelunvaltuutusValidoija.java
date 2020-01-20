package fi.kela.kanta.cda.validation;

import fi.kela.kanta.cda.KantaCDAConstants;
import fi.kela.kanta.to.OstopalvelunvaltuutusTO;
import fi.kela.kanta.util.KantaCDAUtil;

public class OstopalvelunvaltuutusValidoija extends Validoija {

	protected static final String VIRHE_OSVA_NULL = "Ostopalvelunvaltuutus ei saa olla null.";
	private static final String VIRHE_OSVA_TYYPPI_PUUTTUU = "Ostopalvelunvaltuutuksen tyyppi puuttuu.";
	private static final String VIRHE_OSVA_VOIMASSAOLO_ALKU_NULL = "Ostopalvelunvaltuutuksen voimassaolon alku aika ei saa olla null.";
	private static final String VIRHE_OSVA_VOIMASSAOLO_LOPPU_NULL = "Ostopalvelunvaltuutuksen voimassaolon loppu aika ei saa olla null.";
	private static final String VIRHE_OSVA_PALVELUNJARJESTAJA_PUUTTUU = "Ostopalvelunvaltuutuksen palvelunjärjestäjän oid puutuu.";
	private static final String VIRHE_OSVA_PALVELUNJARJESTAJAN_NIMI_PUUTTUU = "Ostopalvelunvaltuutuksen palvelunjärjestäjän nimi puutuu.";
	private static final String VIRHE_OSVA_PALVELUNJARJESTAJAN_PALVELUYKSIKKO_PUUTUU = "Ostopalvelunvaltuutuksen palvelunjärjestäjän palveluyksikkö puutuu.";
	private static final String VIRHE_OSVA_PALVELUNJARJESTAJAN_PALVELUYKSIKKO_NIMI_PUUTTUU = "Ostopalvelunvaltuutuksen palvelunjärjestäjän palveluyksikön nimi puutuu.";
	private static final String VIRHE_OSVA_PALVELUNTUOTTAJA_PUUTTUU = "Ostopalvelunvaltuutuksen palveluntuottajan oid puutuu.";
	private static final String VIRHE_OSVA_PALVELUNTUOTTAJAN_NIMI_PUUTTUU = "Ostopalvelunvaltuutuksen palveluntuottajan nimi puutuu.";
	private static final String VIRHE_OSVA_TUOTTAJAN_HAKU_REKISTERI_PUUTTUU = "Ostopalvelunvaltuutuksen palvelun järjestäjän rekisteri, johon tuottajan oikeus hakea asiakirjoja kohdistuu puutuu.";
	private static final String VIRHE_OSVA_TUOTTAJAN_HAKU_REKISTERIN_TARKENNE_PUUTTUU = "Ostopalvelunvaltuutuksen palvelun järjestäjän rekisterin tarkenne, johon tuottajan oikeus hakea asiakirjoja kohdistuu puutuu.";;
	private static final String VIRHE_OSVA_TUOTTAJAN_HAKU_REKISTERIN_TARKENTIMEN_NIMI_PUUTTUU = "Ostopalvelunvaltuutuksen palvelun järjestäjän rekisterin tarkenteen nimi, johon tuottajan oikeus hakea asiakirjoja kohdistuu puutuu.";;
	private static final String VIRHE_OSVA_TUOTTAJAN_TALLENNUS_REKISTERINPITAJA_PUUTTUU = "Ostopalvelunvaltuutuksen palvelun järjestäjän rekisterinpitäjä, johon tuottajan oikeus tallentaa asiakirjoja kohdistuu puutuu.";
	private static final String VIRHE_OSVA_TUOTTAJAN_TALLENNUS_REKISTERI_PUUTTUU = "Ostopalvelunvaltuutuksen palvelun järjestäjän rekisteri, johon tuottajan oikeus tallentaa asiakirjoja kohdistuu puutuu.";
	private static final String VIRHE_OSVA_TUOTTAJAN_TALLENNUS_REKISTERIN_TARKENNE_PUUTTUU = "Ostopalvelunvaltuutuksen palvelun järjestäjän rekisterin tarkenne, johon tuottajan oikeus tallentaa asiakirjoja kohdistuu puutuu.";
	private static final String VIRHE_OSVA_TUOTTAJAN_TALLENNUS_REKISTERIN_TARKENTIMEN_NIMI_PUUTTUU = "Ostopalvelunvaltuutuksen palvelun järjestäjän rekisterin tarkenteen nimi, johon tuottajan oikeus tallentaa asiakirjoja kohdistuu puutuu.";
	private static final String VIRHE_OSVA_POTILAS_NULL = "Ostopalvelunvaltuutuksen potilas ei saa olla null";
	private static final String VIRHE_OSVA_POTILAS_HETU_PUUTTUU = "Ostopalvelunvaltuutuksen potilaan hetu puutuu";
	private static final String VIRHE_OSVA_POTILAS_NIMI_PUUTTUU = "Ostopalvelunvaltuutuksen potilaan nimi puutuu";
	private static final String VIRHE_OSVA_LUOVUTETTAVAN_AINEISTON_ALKU_AIKA_TAI_PALVELUTAPAHTUMAT_PUUTTUU = "Ostopalvelunvaltuutuksen luovutettavan aineiston aikavälin alku aika tai luovutettavat palvelutapahtumat puutuuvat";
	private static final String VIRHE_OSVA_LUOVUTETTAVAN_AINEISTON_LOPPU_AIKA_TAI_PALVELUTAPAHTUMAT_PUUTTUU = "Ostopalvelunvaltuutuksen luovutettavan aineiston aikavälin loppu aika tai luovutettavat palvelutapahtumat puutuuvat";
	private static final String VIRHE_OSVA_TALLENTAJA_PUUTTUU = "Ostopalvelunvaltuutuksen tallentaja puutuu";
	private static final String VIRHE_OSVA_TALLENTAJAN_HETU_PUUTTUU = "Ostopalvelunvaltuutuksen tallentajan hetu puutuu";
	private static final String VIRHE_OSVA_TALLENTAJAN_NIMI_PUUTTUU = "Ostopalvelunvaltuutuksen tallentajan nimi puutuu";
	private static final String VIRHE_OSVA_TALLENTAJAN_PALVELUYKSIKKO_PUUTTUU = "Ostopalvelunvaltuutuksen tallentajan palveluyksikkö puutuu";
	private static final String VIRHE_OSVA_ASIAKIRJANREKISTERINPITAJA_PUUTTUU = "Ostopalvelunvaltuutuksen asiakirjan rekisterinpitäjän oid puutuu.";
	private static final String VIRHE_OSVA_ASIAKIRJANREKISTERINPITAJA_NIMI_PUUTTUU = "Ostopalvelunvaltuutuksen asiakirjan rekisterinpitäjän nimi puutuu.";
	
	
	protected OstopalvelunvaltuutusTO osva;
	
	/**
	 * @return the osva
	 */
	public OstopalvelunvaltuutusTO getOsva() {
		return osva;
	}

	/**
	 * @param osva the osva to set
	 */
	public void setOsva(OstopalvelunvaltuutusTO osva) {
		this.osva = osva;
	}

	public OstopalvelunvaltuutusValidoija(OstopalvelunvaltuutusTO ostopalvelunvaltuutus) {
		setOsva(ostopalvelunvaltuutus);
	}

	/* (non-Javadoc)
	 * @see fi.kela.kanta.cda.validation.Validoija#validoi()
	 * Validoi että osva pitää sisällään kaiken pakollisen jotta asiakirja voidaan muodostaa
	 */
	@Override
	public void validoi() {
		if (null == getOsva()) {
			throw new IllegalArgumentException(VIRHE_OSVA_NULL);
		}
		validoiOstopalvelunAsiakirjanRekisterinpitaja();
		validoiOstopalvelunTyyppi();
		validoiOstopalvelunVoimassaolo();
		validoiOstopalvelunJarjestaja();
		validoiOstopalvelunTuottaja();
		validoiOstopalvelunTuottajanHakuOikeus();
		validoiOstopalvelunTuottajanTallennusOikeus();
		validoiOstopalvelunPotilas();
		validoiOstopalvelunLuovutettavatAsiakirjat();
		validoiOstopalvelunTallentaja();
	}
	
	protected void validoiOstopalvelunAsiakirjanRekisterinpitaja() {
		if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getAsiakirjanRekisterinpitaja())) {
			throw new IllegalArgumentException(VIRHE_OSVA_ASIAKIRJANREKISTERINPITAJA_PUUTTUU);
		}
		if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getAsiakirjanRekisterinpitajaNimi())) {
			throw new IllegalArgumentException(VIRHE_OSVA_ASIAKIRJANREKISTERINPITAJA_NIMI_PUUTTUU);
		}
	}

	protected void validoiOstopalvelunTyyppi() {
		if (0 == getOsva().getOstopalvelunTyyppi()) {
			throw new IllegalArgumentException(VIRHE_OSVA_TYYPPI_PUUTTUU);
		}
		
	}
	
	protected void validoiOstopalvelunVoimassaolo() {
		if (null == getOsva().getValtuutuksenVoimassaoloAlku()) {
			throw new IllegalArgumentException(VIRHE_OSVA_VOIMASSAOLO_ALKU_NULL);
		}
		if (null == getOsva().getValtuutuksenVoimassaoloLoppu()) {
			throw new IllegalArgumentException(VIRHE_OSVA_VOIMASSAOLO_LOPPU_NULL);
		}
	}
	
	protected void validoiOstopalvelunJarjestaja() {
		if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getPalvelunJarjestaja())) {
			throw new IllegalArgumentException(VIRHE_OSVA_PALVELUNJARJESTAJA_PUUTTUU);
		}
		if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getPalvelunJarjestajaNimi())) {
			throw new IllegalArgumentException(VIRHE_OSVA_PALVELUNJARJESTAJAN_NIMI_PUUTTUU);
		}
		if (getOsva().getOstopalvelunTyyppi() == KantaCDAConstants.OstopalvelunTyyppi.POTILASKOHTAINEN_OSTOPALVELU.getTyyppiValue()) {
			if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getPalvelunJarjestajanPalveluyksikko())) {
				throw new IllegalArgumentException(VIRHE_OSVA_PALVELUNJARJESTAJAN_PALVELUYKSIKKO_PUUTUU);
			}
			if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getPalvelunJarjestajanPalveluyksikonNimi())) {
				throw new IllegalArgumentException(VIRHE_OSVA_PALVELUNJARJESTAJAN_PALVELUYKSIKKO_NIMI_PUUTTUU);
			}
		}
	}

	protected void validoiOstopalvelunTuottaja() {
		if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getPalvelunTuottaja())) {
			throw new IllegalArgumentException(VIRHE_OSVA_PALVELUNTUOTTAJA_PUUTTUU);
		}
		if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getPalvelunTuottajanNimi())) {
			throw new IllegalArgumentException(VIRHE_OSVA_PALVELUNTUOTTAJAN_NIMI_PUUTTUU);
		}
		
	}

	protected void validoiOstopalvelunTuottajanHakuOikeus() {
		if (!KantaCDAUtil.onkoNullTaiTyhja(getOsva().getHakuRekisterinpitaja())) {
			if (0 == getOsva().getHakuRekisteri()) {
				throw new IllegalArgumentException(VIRHE_OSVA_TUOTTAJAN_HAKU_REKISTERI_PUUTTUU);
			}
			if (KantaCDAConstants.PotilasasiakirjanRekisteritunnus.TYOTERVEYSHUOLTO.getRekisteritunnusValue() == getOsva().getHakuRekisteri()) {
				if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getHakuRekisterinTarkenne())) {
					throw new IllegalArgumentException(VIRHE_OSVA_TUOTTAJAN_HAKU_REKISTERIN_TARKENNE_PUUTTUU);
				}
				if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getHakuRekisterinTarkentimenNimi())) {
					throw new IllegalArgumentException(VIRHE_OSVA_TUOTTAJAN_HAKU_REKISTERIN_TARKENTIMEN_NIMI_PUUTTUU);
				}
			}
		}
	}

	protected void validoiOstopalvelunTuottajanTallennusOikeus() {
		if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getTallennusRekisterinpitaja())) {
			throw new IllegalArgumentException(VIRHE_OSVA_TUOTTAJAN_TALLENNUS_REKISTERINPITAJA_PUUTTUU);
		}
		if (0 == getOsva().getTallennusRekisteri()) {
			throw new IllegalArgumentException(VIRHE_OSVA_TUOTTAJAN_TALLENNUS_REKISTERI_PUUTTUU);
		}
		if (KantaCDAConstants.PotilasasiakirjanRekisteritunnus.TYOTERVEYSHUOLTO.getRekisteritunnusValue() == osva.getTallennusRekisteri()) {
			if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getTallennusRekisterinTarkenne())) {
				throw new IllegalArgumentException(VIRHE_OSVA_TUOTTAJAN_TALLENNUS_REKISTERIN_TARKENNE_PUUTTUU);
			}
			if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getTallennusRekisterinTarkentimenNimi())) {
				throw new IllegalArgumentException(VIRHE_OSVA_TUOTTAJAN_TALLENNUS_REKISTERIN_TARKENTIMEN_NIMI_PUUTTUU);
			}
		}
		
	}

	protected void validoiOstopalvelunPotilas() {
		if (KantaCDAConstants.OstopalvelunTyyppi.POTILASKOHTAINEN_OSTOPALVELU.getTyyppiValue() == getOsva().getOstopalvelunTyyppi()) {
			if (null == getOsva().getPotilas()) {
				throw new IllegalArgumentException(VIRHE_OSVA_POTILAS_NULL);
			}
			if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getPotilas().getHetu())) {
				throw new IllegalArgumentException(VIRHE_OSVA_POTILAS_HETU_PUUTTUU);
			}
			if (null == getOsva().getPotilas().getNimi() || KantaCDAUtil.onkoNullTaiTyhja(getOsva().getPotilas().getNimi().getKokoNimi())) {
				throw new IllegalArgumentException(VIRHE_OSVA_POTILAS_NIMI_PUUTTUU);
			}
		}
		
	}

	protected void validoiOstopalvelunLuovutettavatAsiakirjat() {
		if (KantaCDAConstants.OstopalvelunTyyppi.POTILASKOHTAINEN_OSTOPALVELU.getTyyppiValue() == getOsva().getOstopalvelunTyyppi()
				&& KantaCDAUtil.onkoNullTaiTyhja(getOsva().getHakuRekisterinpitaja())) {
			if (!getOsva().isKaikkiAsiakirjat()) {
				if (getOsva().getLuovutettavatPalvelutapahtumat().isEmpty()) {
					if (null ==getOsva().getLuovutettavanAineistonAlku()){
						throw new IllegalArgumentException(VIRHE_OSVA_LUOVUTETTAVAN_AINEISTON_ALKU_AIKA_TAI_PALVELUTAPAHTUMAT_PUUTTUU);
					}
					if (null == getOsva().getLuovutettavanAineistonLoppu()) {
						throw new IllegalArgumentException(VIRHE_OSVA_LUOVUTETTAVAN_AINEISTON_LOPPU_AIKA_TAI_PALVELUTAPAHTUMAT_PUUTTUU);
					}
				}
			}
		}
		
	}

	protected void validoiOstopalvelunTallentaja() {
		if (null == getOsva().getAsiakirjanTallentaja()) {
			throw new IllegalArgumentException(VIRHE_OSVA_TALLENTAJA_PUUTTUU);
		}
		if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getAsiakirjanTallentaja().getHetu())) {
			throw new IllegalArgumentException(VIRHE_OSVA_TALLENTAJAN_HETU_PUUTTUU);
		}
		if (null == getOsva().getAsiakirjanTallentaja().getNimi() || KantaCDAUtil.onkoNullTaiTyhja(getOsva().getAsiakirjanTallentaja().getNimi().getKokoNimi()))  {
			throw new IllegalArgumentException(VIRHE_OSVA_TALLENTAJAN_NIMI_PUUTTUU);
		}
		if (KantaCDAUtil.onkoNullTaiTyhja(getOsva().getAmmattihenkilonPalveluyksikko())) {
			throw new IllegalArgumentException(VIRHE_OSVA_TALLENTAJAN_PALVELUYKSIKKO_PUUTTUU);
		}
	}
}
