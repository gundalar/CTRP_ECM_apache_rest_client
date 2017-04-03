package gov.nih.nci.ctrp.ecm_service_apache_rest_client;

import gov.nih.nci.iso21090.Ad;
import gov.nih.nci.iso21090.Ii;
import gov.nih.nci.iso21090.Tel;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.Gson;

/**
 * The Class CTEPHealthcareFacilityDTO.
 *
 * @author Ramakrishna Gundala
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CTEPHealthcareFacilityDTO {
	
    /**
     * Instantiates a new CTEP healthcare facility DTO.
     */
    public CTEPHealthcareFacilityDTO() {
		super();
	}

	/**
	 * Instantiates a new CTEP healthcare facility DTO.
	 *
	 * @param jmsMessageJSON the jms message JSON
	 */
	public CTEPHealthcareFacilityDTO(String jmsMessageJSON) {
        Gson gson = new Gson();
        CTEPHealthcareFacilityDTO dto = gson.fromJson(jmsMessageJSON, CTEPHealthcareFacilityDTO.class);
        this.duplicateOf = dto.getDuplicateOf();
		this.playerIdentifier = dto.getPlayerIdentifier();
		this.identifier = dto.getIdentifier();
		this.name = dto.getName();
		this.postalAddress = dto.getPostalAddress();
		this.status = dto.getStatus();
		this.telecomAddress = dto.getTelecomAddress();
    }
	
	
    /** The duplicate of. */
    @JsonProperty("duplicateOf")
    private gov.nih.nci.iso21090.Ii duplicateOf;
    
    /** The player identifier. */
    @JsonProperty("playerIdentifier")
    private gov.nih.nci.iso21090.Ii playerIdentifier;
    
    /** The m identifier. */
    @JsonProperty("identifier")
    private gov.nih.nci.iso21090.DSet<Ii> identifier;
    
    /** The name. */
    @JsonProperty("name")
    private gov.nih.nci.iso21090.EnOn name;
    
    /** The m postal address. */
    @JsonProperty("postalAddress")
    private gov.nih.nci.iso21090.DSet<Ad> postalAddress;
    
    /** The m status. */
    @JsonProperty("status")
    private gov.nih.nci.iso21090.Cd status;
    
    /** The m telecom address. */
    @JsonProperty("telecomAddress")
    private gov.nih.nci.iso21090.DSet<Tel> telecomAddress;

    /**
     * Gets the duplicate of.
     *
     * @return the duplicate of
     */
    public gov.nih.nci.iso21090.Ii getDuplicateOf() {
		return duplicateOf;
	}

	/**
	 * Sets the duplicate of.
	 *
	 * @param duplicateOf the new duplicate of
	 */
	public void setDuplicateOf(gov.nih.nci.iso21090.Ii duplicateOf) {
		this.duplicateOf = duplicateOf;
	}

	/**
	 * Gets the player identifier.
	 *
	 * @return the player identifier
	 */
	public gov.nih.nci.iso21090.Ii getPlayerIdentifier() {
		return playerIdentifier;
	}

	/**
	 * Sets the player identifier.
	 *
	 * @param playerIdentifier the new player identifier
	 */
	public void setPlayerIdentifier(gov.nih.nci.iso21090.Ii playerIdentifier) {
		this.playerIdentifier = playerIdentifier;
	}

	/**
	 * Gets the identifier.
	 *
	 * @return the identifier
	 */
	public gov.nih.nci.iso21090.DSet<Ii> getIdentifier() {
		return identifier;
	}

	/**
	 * Sets the identifier.
	 *
	 * @param identifier the new identifier
	 */
	public void setIdentifier(gov.nih.nci.iso21090.DSet<Ii> identifier) {
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
	public gov.nih.nci.iso21090.DSet<Ad> getPostalAddress() {
		return postalAddress;
	}

	/**
	 * Sets the postal address.
	 *
	 * @param postalAddress the new postal address
	 */
	public void setPostalAddress(gov.nih.nci.iso21090.DSet<Ad> postalAddress) {
		this.postalAddress = postalAddress;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public gov.nih.nci.iso21090.Cd getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(gov.nih.nci.iso21090.Cd status) {
		this.status = status;
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
