package gov.nih.nci.ctrp.ecm_service_apache_rest_client;

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
        CTEPOrganizationDTO dto = gson.fromJson(jmsMessageJSON, CTEPOrganizationDTO.class);
        this.statusDate = dto.getStatusDate();
		this.familyOrganizationRelationships = dto.getFamilyOrganizationRelationships();
		this.identifier = dto.getIdentifier();
		this.name = dto.getName();
		this.postalAddress = dto.getPostalAddress();
		this.statusCode = dto.getStatusCode();
    }

	/** The m status date. */
    @JsonProperty("statusDate")
    private gov.nih.nci.iso21090.Ts statusDate;
    
    /** The family organization relationships. */
    @JsonProperty("familyOrganizationRelationships")
    private gov.nih.nci.iso21090.DSet familyOrganizationRelationships;
    
	/** The identifier. */
    @JsonProperty("identifier")
    private gov.nih.nci.iso21090.Ii identifier;
    
    /** The name. */
    @JsonProperty("name")
    private gov.nih.nci.iso21090.EnOn name;
    
    /** The postal address. */
    @JsonProperty("postalAddress")
    private gov.nih.nci.iso21090.Ad postalAddress;
    
    /** The status code. */
    @JsonProperty("statusCode")
    private gov.nih.nci.iso21090.Cd statusCode;
    
    /** The telecom address. */
    @JsonProperty("telecomAddress")
    private gov.nih.nci.iso21090.DSet<Tel> telecomAddress;
    
    /**
     * Gets the status date.
     *
     * @return the status date
     */
    public gov.nih.nci.iso21090.Ts getStatusDate() {
		return statusDate;
	}

	/**
	 * Sets the status date.
	 *
	 * @param statusDate the new status date
	 */
	public void setStatusDate(gov.nih.nci.iso21090.Ts statusDate) {
		this.statusDate = statusDate;
	}

	/**
	 * Gets the family organization relationships.
	 *
	 * @return the family organization relationships
	 */
	public gov.nih.nci.iso21090.DSet getFamilyOrganizationRelationships() {
		return familyOrganizationRelationships;
	}

	/**
	 * Sets the family organization relationships.
	 *
	 * @param familyOrganizationRelationships the new family organization relationships
	 */
	public void setFamilyOrganizationRelationships(
			gov.nih.nci.iso21090.DSet familyOrganizationRelationships) {
		this.familyOrganizationRelationships = familyOrganizationRelationships;
	}

	/**
	 * Gets the identifier.
	 *
	 * @return the identifier
	 */
	public gov.nih.nci.iso21090.Ii getIdentifier() {
		return identifier;
	}

	/**
	 * Sets the identifier.
	 *
	 * @param identifier the new identifier
	 */
	public void setIdentifier(gov.nih.nci.iso21090.Ii identifier) {
		this.identifier = identifier;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public gov.nih.nci.iso21090.EnOn getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(gov.nih.nci.iso21090.EnOn name) {
		this.name = name;
	}

	/**
	 * Gets the postal address.
	 *
	 * @return the postal address
	 */
	public gov.nih.nci.iso21090.Ad getPostalAddress() {
		return postalAddress;
	}

	/**
	 * Sets the postal address.
	 *
	 * @param postalAddress the new postal address
	 */
	public void setPostalAddress(gov.nih.nci.iso21090.Ad postalAddress) {
		this.postalAddress = postalAddress;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public gov.nih.nci.iso21090.Cd getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode the new status code
	 */
	public void setStatusCode(gov.nih.nci.iso21090.Cd statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the telecom address.
	 *
	 * @return the telecom address
	 */
	public gov.nih.nci.iso21090.DSet<Tel> getTelecomAddress() {
		return telecomAddress;
	}

	/**
	 * Sets the telecom address.
	 *
	 * @param telecomAddress the new telecom address
	 */
	public void setTelecomAddress(gov.nih.nci.iso21090.DSet<Tel> telecomAddress) {
		this.telecomAddress = telecomAddress;
	}

}
