package gov.nih.nci.ctrp.ecm_service_apache_rest_client.workingcode;

import gov.nih.nci.iso21090.Tel;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.Gson;

/**
 * The Class CTEPOrganizationDTO.
 *
 * @author Ramakrishna Gundala
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CTEPOrganizationDTO {

    /**
     * Instantiates a new CTEP organization DTO.
     */
    public CTEPOrganizationDTO() {
        super();
    }

    /**
     * Instantiates a new CTEP organization DTO.
     *
     * @param jmsMessageJSON the jms message JSON
     */
    public CTEPOrganizationDTO(String jmsMessageJSON) {
        Gson gson = new Gson();
        CTEPOrganizationDTO dto = gson.fromJson(jmsMessageJSON,
                CTEPOrganizationDTO.class);
        this.statusDate = dto.getstatusDate();
        this.familyOrganizationRelationships = dto
                .getfamilyOrganizationRelationships();
        this.identifier = dto.getidentifier();
        this.name = dto.getname();
        this.postalAddress = dto.getpostalAddress();
        this.statusCode = dto.getstatusCode();
    }

    /** The m status date. */
    @JsonProperty("statusDate")
    private gov.nih.nci.iso21090.Ts statusDate;

    /** The m family organization relationships. */
    @JsonProperty("familyOrganizationRelationships")
    private gov.nih.nci.iso21090.DSet familyOrganizationRelationships;

    /** The m identifier. */
    @JsonProperty("identifier")
    private gov.nih.nci.iso21090.Ii identifier;

    /** The m name. */
    @JsonProperty("name")
    private gov.nih.nci.iso21090.EnOn name;

    /**
     * Gets the m status date.
     *
     * @return the m status date
     */
    public gov.nih.nci.iso21090.Ts getstatusDate() {
        return statusDate;
    }

    /**
     * Sets the m status date.
     *
     * @param statusDateParam the new status date
     */
    public void setstatusDate(gov.nih.nci.iso21090.Ts statusDateParam) {
        this.statusDate = statusDate;
    }

    /**
     * Gets the m family organization relationships.
     *
     * @return the m family organization relationships
     */
    public gov.nih.nci.iso21090.DSet getfamilyOrganizationRelationships() {
        return familyOrganizationRelationships;
    }

    /**
     * Sets the m family organization relationships.
     *
     * @param familyOrganizationRelationshipsParam
     *            the new family organization relationships
     */
    public void setfamilyOrganizationRelationships(
            gov.nih.nci.iso21090.DSet familyOrganizationRelationshipsParam) {
        this.familyOrganizationRelationships = familyOrganizationRelationshipsParam;
    }

    /**
     * Gets the m identifier.
     *
     * @return the m identifier
     */
    public gov.nih.nci.iso21090.Ii getidentifier() {
        return identifier;
    }

    /**
     * Sets the m identifier.
     *
     * @param identifierParam the new identifier
     */
    public void setidentifier(gov.nih.nci.iso21090.Ii identifierParam) {
        this.identifier = identifierParam;
    }

    /**
     * Gets the m name.
     *
     * @return the m name
     */
    public gov.nih.nci.iso21090.EnOn getname() {
        return name;
    }

    /**
     * Sets the m name.
     *
     * @param nameParam the new name
     */
    public void setname(gov.nih.nci.iso21090.EnOn nameParam) {
        this.name = nameParam;
    }

    /**
     * Gets the m postal address.
     *
     * @return the m postal address
     */
    public gov.nih.nci.iso21090.Ad getpostalAddress() {
        return postalAddress;
    }

    /**
     * Sets the m postal address.
     *
     * @param postalAddressParam
     *            the new m postal address
     */
    public void setpostalAddress(gov.nih.nci.iso21090.Ad postalAddressParam) {
        this.postalAddress = postalAddressParam;
    }

    /**
     * Gets the m status code.
     *
     * @return the m status code
     */
    public gov.nih.nci.iso21090.Cd getstatusCode() {
        return statusCode;
    }

    /**
     * Sets the m status code.
     *
     * @param statusCodeParam
     *            the new m status code
     */
    public void setstatusCode(gov.nih.nci.iso21090.Cd statusCodeParam) {
        this.statusCode = statusCodeParam;
    }

    /**
     * Gets the m telecom address.
     *
     * @return the m telecom address
     */
    public gov.nih.nci.iso21090.DSet<Tel> gettelecomAddress() {
        return telecomAddress;
    }

    /**
     * Sets the m telecom address.
     *
     * @param telecomAddressParam
     *            the new m telecom address
     */
    public void settelecomAddress(gov.nih.nci.iso21090.DSet<Tel> telecomAddressParam) {
        this.telecomAddress = telecomAddressParam;
    }

    /** The m postal address. */
    @JsonProperty("postalAddress")
    private gov.nih.nci.iso21090.Ad postalAddress;

    /** The m status code. */
    @JsonProperty("statusCode")
    private gov.nih.nci.iso21090.Cd statusCode;

    /** The m telecom address. */
    @JsonProperty("telecomAddress")
    private gov.nih.nci.iso21090.DSet<Tel> telecomAddress;

}
