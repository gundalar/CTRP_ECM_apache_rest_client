package gov.nih.nci.ctrp.ecm_service_apache_rest_client;


import gov.nih.nci.iso21090.Ad;
import gov.nih.nci.iso21090.Cd;
import gov.nih.nci.iso21090.DSet;
import gov.nih.nci.iso21090.Ii;
import gov.nih.nci.iso21090.Ts;
import gov.nih.nci.services.person.BasePersonDTO;
import java.io.Serializable;

public abstract class AbstractPersonDTO extends BasePersonDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Ii m_identifier;
    private Ad m_postalAddress;
    private Cd m_statusCode;
    private Cd m_sexCode;
    private DSet m_raceCode;
    private DSet m_ethnicGroupCode;
    private Ts m_birthDate;
    private Ts m_statusDate;

    public AbstractPersonDTO() {
    }

    public Ii getIdentifier() {
        return this.m_identifier;
    }

    public void setIdentifier(Ii obj) {
        this.m_identifier = obj;
    }

    public Ad getPostalAddress() {
        return this.m_postalAddress;
    }

    public void setPostalAddress(Ad obj) {
        this.m_postalAddress = obj;
    }

    public Cd getStatusCode() {
        return this.m_statusCode;
    }

    public void setStatusCode(Cd obj) {
        this.m_statusCode = obj;
    }

    public Cd getSexCode() {
        return this.m_sexCode;
    }

    public void setSexCode(Cd obj) {
        this.m_sexCode = obj;
    }

    public DSet getRaceCode() {
        return this.m_raceCode;
    }

    public void setRaceCode(DSet obj) {
        this.m_raceCode = obj;
    }

    public DSet getEthnicGroupCode() {
        return this.m_ethnicGroupCode;
    }

    public void setEthnicGroupCode(DSet obj) {
        this.m_ethnicGroupCode = obj;
    }

    public Ts getBirthDate() {
        return this.m_birthDate;
    }

    public void setBirthDate(Ts obj) {
        this.m_birthDate = obj;
    }

    public Ts getStatusDate() {
        return this.m_statusDate;
    }

    public void setStatusDate(Ts obj) {
        this.m_statusDate = obj;
    }
}