package fi.kela.kanta.cda.validation;

import fi.kela.kanta.to.LaakemaarayksenMitatointiTO;
import fi.kela.kanta.to.LaakemaaraysTO;
import fi.kela.kanta.util.KantaCDAUtil;

public class ReseptinMitatointiValidoija extends LaakemaaraysValidoija {

	protected LaakemaarayksenMitatointiTO mitatointi;
	
	public LaakemaarayksenMitatointiTO getMitatointi() {
		return mitatointi;
	}

	public void setMitatointi(LaakemaarayksenMitatointiTO mitatointi) {
		this.mitatointi = mitatointi;
	}

	public ReseptinMitatointiValidoija(LaakemaaraysTO alkuperainenLaakemaarays, LaakemaarayksenMitatointiTO laakemaarayksenMitatointi) {
		super(alkuperainenLaakemaarays);
		setMitatointi(laakemaarayksenMitatointi);
	}

	@Override
	public void validoi() {
		validoiMitatointi();
		validoiAlkuperainenLaakemaarays();
	}
	
	protected void validoiMitatointi() {
		if (null == getMitatointi()) {
		    throw new IllegalArgumentException("Laakemaarayksen mitatointi cannot be null.");
		}
		if (null == getMitatointi().getMitatoija()) {
		    throw new IllegalArgumentException("Laakemaarayksen mitatointi cannot be null.");
		}
		if (KantaCDAUtil.onkoNullTaiTyhja(getMitatointi().getMitatoinninSyyKoodi())) {
		    throw new IllegalArgumentException("Laakemaarayksen mitatoinnin syy koodi cannot be null.");
		}
		if (KantaCDAUtil.onkoNullTaiTyhja(getMitatointi().getMitatoinninPerustelu()) && "5".equals(getMitatointi().getMitatoinninSyyKoodi())) {
		    throw new IllegalArgumentException("Jos muutoksen syy on 'Muu syy' niin laakemaarayksen mitatoinnin perustelu ei voi olla null.");
		}
		validoiHenkilotiedot(getMitatointi().getPotilas());
	    }
	
	/**
     * Validoi alkuperaisen LaakemaraysTOn
     *
     * @param laakemaarays LaakemaaraysTO joka validoidaan
     */
    private void validoiAlkuperainenLaakemaarays() {
	if (null == getAlkuperainenLaakemaarays().getMaarayspaiva()) {
	    throw new IllegalArgumentException("Alkuperaisen laakemaarayksen maarayspaiva cannot be null.");
	}
    }
    
    

}
