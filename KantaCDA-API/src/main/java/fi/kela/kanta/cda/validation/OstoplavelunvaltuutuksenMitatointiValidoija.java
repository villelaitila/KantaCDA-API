package fi.kela.kanta.cda.validation;

import fi.kela.kanta.to.OstopalvelunvaltuutusTO;

public class OstoplavelunvaltuutuksenMitatointiValidoija extends OstopalvelunvaltuutusValidoija {

	public OstoplavelunvaltuutuksenMitatointiValidoija(OstopalvelunvaltuutusTO ostopalvelunvaltuutus) {
		super(ostopalvelunvaltuutus);
	}

	@Override
	public void validoi() {
		if (null == getOsva()) {
			throw new IllegalArgumentException(VIRHE_OSVA_NULL);
		}
		validoiOstopalvelunPotilas();

	}

}
