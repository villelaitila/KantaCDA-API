package fi.kela.kanta.cda.validation;

import org.codehaus.plexus.util.StringUtils;

import fi.kela.kanta.to.LaakemaaraysTO;

public class ReseptinUusimisValidoija extends LaakemaaraysValidoija {

	protected LaakemaaraysTO uusi;
	
	public LaakemaaraysTO getUusi() {
		return uusi;
	}

	public void setUusi(LaakemaaraysTO uusi) {
		this.uusi = uusi;
	}

	public ReseptinUusimisValidoija(LaakemaaraysTO alkuperainenLaakemaarays, LaakemaaraysTO uusi) {
		super(alkuperainenLaakemaarays);
		setUusi(uusi);
	}

	@Override
	public void validoi() {
		validoiAlkuperainenLaakemaarays();
		validoiLaakemaaraysUusiminen();
	}

    /**
     * Validoi cda:n muodostamisen kannalta tarvittavien parametrien tilan.
     */
    protected void validoiLaakemaaraysUusiminen() {

	if (null == getUusi()) {
	    throw new IllegalArgumentException("Uusittu lääkemääräys ei saa olla null.");
	}
	if (null == getUusi().getMaarayspaiva()) {
	    throw new IllegalArgumentException("Uusitun lääkemääräyksen 'määräyspäivä' ei saa olla null.");
	}
	if (StringUtils.isEmpty(getUusi().getOid())) {
	    throw new IllegalArgumentException("Uusitun lääkemääräyksen 'oid' pitää löytyä.");
	}
	if (null == getUusi().getMaarayspaiva()) {
	    throw new IllegalArgumentException("Uusitun lääkemääräyksen 'setid' pitää löytyä.");
	}
	validoiHenkilotiedot(getUusi().getPotilas());
    }

    /**
     * Validoi alkuperäisen LaakemaraysTOn
     *
     * @param laakemaarays LaakemaaraysTO joka validoidaan
     */
    public void validoiAlkuperainenLaakemaarays() {

	if (null == getAlkuperainenLaakemaarays()) {
	    throw new IllegalArgumentException("Alkuperäinen lääkemääräys ei saa olla null.");
	}
	if (null == getAlkuperainenLaakemaarays().getMaarayspaiva()) {
	    throw new IllegalArgumentException("Alkuperäisen lääkemääräyksen 'määräyspäivä' ei saa olla null.");
	}
	if (StringUtils.isEmpty(getAlkuperainenLaakemaarays().getOid())) {
	    throw new IllegalArgumentException("Alkuperäisen lääkemääräyksen 'oid' pitää löytyä.");
	}
	if (null == getAlkuperainenLaakemaarays().getMaarayspaiva()) {
	    throw new IllegalArgumentException("Alkuperäisen lääkemääräyksen 'setid' pitää löytyä.");
	}
    }

}
