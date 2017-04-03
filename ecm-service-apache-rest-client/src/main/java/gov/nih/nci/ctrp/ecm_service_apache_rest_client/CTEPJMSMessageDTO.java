package gov.nih.nci.ctrp.ecm_service_apache_rest_client;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.gson.Gson;


/**
 * 
 * @author Ramakrishna Gundala
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CTEPJMSMessageDTO {

    public CTEPJMSMessageDTO(String jMSMessageID, String text) {
		super();
		this.jMSMessageID = jMSMessageID;
		this.text = text;
	}
    
    public CTEPJMSMessageDTO(String jmsMessageJSON) {
        Gson gson = new Gson();
        CTEPJMSMessageDTO grupoAplicacao = gson.fromJson(jmsMessageJSON, CTEPJMSMessageDTO.class);
        this.jMSMessageID = grupoAplicacao.getjMSMessageID();
        this.text = grupoAplicacao.getText();
    }

	@JsonProperty("jMSMessageID")
    private String jMSMessageID;
    
    @JsonProperty("text")
    private String text;
    
    /**
     * 
     * @return studyProtocolId
     */
    public String getjMSMessageID() {
          return jMSMessageID;
    }

    /**
     * 
     * @param jMSMessageID the jMSMessageID
     */
    public void setjMSMessageID(String jMSMessageID) {
          this.jMSMessageID = jMSMessageID;
     }

     /**
     * 
     * @return studyProtocolId
     */
    public String getText() {
         return text;
      }

     /**
     * 
     * @param text the text
     */
    public void setText(String text) {
       this.text = text;
    }

}
