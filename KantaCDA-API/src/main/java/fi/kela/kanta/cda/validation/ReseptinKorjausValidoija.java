package fi.kela.kanta.cda.validation;

import org.codehaus.plexus.util.StringUtils;

import fi.kela.kanta.to.LaakemaarayksenKorjausTO;
import fi.kela.kanta.to.LaakemaaraysTO;
import fi.kela.kanta.util.KantaCDAUtil;

public class ReseptinKorjausValidoija extends LaakemaaraysValidoija {

	protected static final String VIRHE_KORJAUS_NULL = "Laakemaarayksen korjaus ei saa olla null.";
    protected static final String VIRHE_KORJAAJA_NULL = "Laakemaarayksen korjaaja ei saa olla null.";
    protected static final String VIRHE_KORJAUKSEN_SYY_KOODI_NULL_TAI_TYHJA = "Laakemaarayksen korjauksen syy koodi ei saa olla null tai tyhja.";
    protected static final String VIRHE_KORJAUKSEN_PERUSTELU_NULL_TAI_TYHJA = "Laakemaarayksen korjauksen perustelu ei saa olla null tai tyhja.";
    protected static final String VIRHE_ALKUPERAINEN_LAAKEMAARAYS_NULL = "Alkuperäinen lääkemääräys ei saa olla null.";
    protected static final String VIRHE_ALKUPERAISEN_LAAKEMAARAYKSEN_MAARAYSPAIVA_NULL = "Alkuperäisen lääkemääräyksen 'määräyspäivä' ei saa olla null.";
    protected static final String VIRHE_ALKUPERAISEN_LAAKEMAARAYKSEN_OID_NULL = "Alkuperäisen lääkemääräyksen 'oid' pitää löytyä.";
    protected static final String VIRHE_ALKUPERAISEN_LAAKEMAARAYKSEN_SETID_NULL = "Alkuperäisen lääkemääräyksen 'setid' pitää löytyä.";

	protected LaakemaarayksenKorjausTO korjaus;
	public LaakemaarayksenKorjausTO getKorjaus() {
		return korjaus;
	}

	public void setKorjaus(LaakemaarayksenKorjausTO korjaus) {
		this.korjaus = korjaus;
	}

	public ReseptinKorjausValidoija(LaakemaarayksenKorjausTO laakemaarayksenKorjaus, LaakemaaraysTO alkuperainenLaakemaarays) {
		super(alkuperainenLaakemaarays);
		setKorjaus(laakemaarayksenKorjaus);
	}
	
	public void validoiKorjaus() {

		if (null == getKorjaus()) {
		    throw new IllegalArgumentException(VIRHE_KORJAUS_NULL);
		}
		if (null == getKorjaus().getKorjaaja()) {
		    throw new IllegalArgumentException(VIRHE_KORJAAJA_NULL);
		}
		if (KantaCDAUtil.onkoNullTaiTyhja(getKorjaus().getKorjauksenSyyKoodi())) {
		    throw new IllegalArgumentException(VIRHE_KORJAUKSEN_SYY_KOODI_NULL_TAI_TYHJA);
		}

		if ("5".equals(getKorjaus().getKorjauksenSyyKoodi()) && KantaCDAUtil.onkoNullTaiTyhja(getKorjaus().getKorjauksenPerustelu())) {
		    throw new IllegalArgumentException(VIRHE_KORJAUKSEN_PERUSTELU_NULL_TAI_TYHJA);
		}
	}
	
	/**
     * Validoi alkuperäisen LaakemaraysTOn
     *
     * @param laakemaarays LaakemaaraysTO joka validoidaan
     */
    public void validoiAlkuperainenLaakemaarays() {
    	if (null == getAlkuperainenLaakemaarays()) {
    		throw new IllegalArgumentException(VIRHE_ALKUPERAINEN_LAAKEMAARAYS_NULL);
    	}
		if (null == getAlkuperainenLaakemaarays().getMaarayspaiva()) {
		    throw new IllegalArgumentException(VIRHE_ALKUPERAISEN_LAAKEMAARAYKSEN_MAARAYSPAIVA_NULL);
		}
		if (StringUtils.isEmpty(getAlkuperainenLaakemaarays().getOid())) {
		    throw new IllegalArgumentException(VIRHE_ALKUPERAISEN_LAAKEMAARAYKSEN_OID_NULL);
		}
		if (StringUtils.isEmpty(getAlkuperainenLaakemaarays().getSetId())) {
		    throw new IllegalArgumentException(VIRHE_ALKUPERAISEN_LAAKEMAARAYKSEN_SETID_NULL);
		}
    }

	@Override
	public void validoi() {
		validoiKorjaus();
		validoiAlkuperainenLaakemaarays();
	}
	
}
