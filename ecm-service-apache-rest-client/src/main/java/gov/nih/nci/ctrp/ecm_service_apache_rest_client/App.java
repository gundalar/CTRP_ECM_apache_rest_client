package gov.nih.nci.ctrp.ecm_service_apache_rest_client;

import gov.nih.nci.iso21090.Ad;
import gov.nih.nci.iso21090.Adxp;
import gov.nih.nci.iso21090.Enxp;
import gov.nih.nci.iso21090.Ii;
import gov.nih.nci.iso21090.Tel;
import gov.nih.nci.services.organization.OrganizationDTO;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jackson.type.TypeReference;


/**
 * Hello world!
 *
 */
public class App 
{
	
	private static final String APPLICATION_JSON = "application/json";
    public static void main( String[] args ) throws ClientProtocolException, IOException
    
    {
    	  System.out.println("Delaying connecting to CTEP JMS Topic to let the application deployment complete fully...");
          //  Thread.sleep(DateUtils.MILLIS_PER_MINUTE);
            
            System.out.println("Calling CTEP JMS messages Rest URL");
            
            while(true){
            	 try { RestClient client = new RestClient();
                     String response =  client.sendHTTPRequest("http://localhost:3300/api/v1/ecmservice/HealthCareFacility/WA082", "GET", null);
                     if (response != null) {
                         CTEPHealthcareFacilityDTO dto = (CTEPHealthcareFacilityDTO) ECMRestClientHelper
                                 .unmarshallJSON(response, CTEPHealthcareFacilityDTO.class);
                         	System.out.println("HealthcareFacility DTO :" + dto);
                         	printRemoteOrgDataToDebugLog(dto);
                         	printIdentifierSet(dto, "hcf");
                     }
            		 
                 } catch (Exception e) {
                     System.out.println("ERROR when invoking CTEP JMS Messages Rest services");
                     e.printStackTrace();
                 } finally {
                	 try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                 }
            }
            
    }


	public static void  testJMSMessage() throws Exception{
		 RestClient client = new RestClient();
		 
		 String response =  client.sendHTTPRequest("http://localhost:3300/api/v1/ecmservice/jmsMessage", "GET", null);
          if (response != null) {
              List<CTEPJMSMessageDTO> jmsMessages = (List<CTEPJMSMessageDTO>) ECMRestClientHelper
                      .unmarshallJSON(response, new TypeReference<List<CTEPJMSMessageDTO>>() { });
              for(CTEPJMSMessageDTO jmsMessage :jmsMessages){
              	System.out.println(jmsMessage.getjMSMessageID() + " : " + jmsMessage.getText());
              	
              }
          }
		 
	}
    
    public static void testOrganizationImport() throws Exception{
		 RestClient client = new RestClient();
    	String response =  client.sendHTTPRequest("http://localhost:3300/api/v1/ecmservice/Organization/WA002", "GET", null);
        if (response != null) {
            CTEPOrganizationDTO organizationDTO = (CTEPOrganizationDTO) ECMRestClientHelper
                    .unmarshallJSON(response, CTEPOrganizationDTO.class);
         System.out.println(organizationDTO.toString());
         OrganizationDTO localOrganizationDTO = convertOrganizationDTORemoteToLocal(organizationDTO);
         printOrgDataToDebugLog(localOrganizationDTO);
        }
    }
    
    public static void printRemoteOrgDataToDebugLog(CTEPOrganizationDTO dto) {
        System.out.println("*** Importing ctep org ***");
        System.out.println("org.ii.root: " + dto.getIdentifier().getRoot());
        System.out.println("org.ii.extension: " + dto.getIdentifier().getExtension());
        System.out.println("org.status: " + dto.getStatusCode().getCode());
         for (Enxp xp : dto.getName().getPart()) {
            System.out.println("org.name.value: " + xp.getValue());
         }
         for (Adxp adxp : dto.getPostalAddress().getPart()) {
            System.out.println("org.postalAddress.part.type: " + adxp.getType());
            System.out.println("org.postalAddress.part.value: " + adxp.getValue());
            System.out.println("org.postalAddress.part.code: " + adxp.getCode());
         }
         if (dto.getTelecomAddress() == null) {
            System.out.println("org.telecomAddress: null");
         } else {
             for (Tel tel : dto.getTelecomAddress().getItem()) {
                System.out.println("org.telecomAddress.item.value: " + tel.getValue());
             }
         }
     }
    
    
    public static void printRemoteOrgDataToDebugLog(CTEPHealthcareFacilityDTO dto) {
        System.out.println("*** Importing ctep org ***");
        for(Ii identifier : dto.getIdentifier().getItem()){
        	System.out.println("org.ii.root: " + identifier.getRoot());
            System.out.println("org.ii.extension: " + identifier.getExtension());
        }
        
         for (Enxp xp : dto.getName().getPart()) {
            System.out.println("org.name.value: " + xp.getValue());
         }
         for (Ad ad : dto.getPostalAddress().getItem()) {
        	 for (Adxp adxp: ad.getPart()){
        		  System.out.println("org.postalAddress.part.type: " + adxp.getType());
                  System.out.println("org.postalAddress.part.value: " + adxp.getValue());
                  System.out.println("org.postalAddress.part.code: " + adxp.getCode());
                  System.out.println("org.postalAddress.part.type: " + adxp.getCodeSystem());
        	 }
          
         }
         if (dto.getTelecomAddress() == null) {
            System.out.println("org.telecomAddress: null");
         } else {
             for (Tel tel : dto.getTelecomAddress().getItem()) {
                System.out.println("org.telecomAddress.item.value: " + tel.getValue());
             }
         }
     }
    
    private static void printOrgDataToDebugLog(OrganizationDTO dto) {
       System.out.println("*** Importing ctep org ***");
       System.out.println("org.ii.root: " + dto.getIdentifier().getRoot());
       System.out.println("org.ii.extension: " + dto.getIdentifier().getExtension());
       System.out.println("org.status: " + dto.getStatusCode().getCode());
        for (Enxp xp : dto.getName().getPart()) {
           System.out.println("org.name.value: " + xp.getValue());
        }
        for (Adxp adxp : dto.getPostalAddress().getPart()) {
           System.out.println("org.postalAddress.part.type: " + adxp.getType());
           System.out.println("org.postalAddress.part.value: " + adxp.getValue());
           System.out.println("org.postalAddress.part.code: " + adxp.getCode());
           System.out.println("org.postalAddress.part.code: " + adxp.getCodeSystem());
        }
        if (dto.getTelecomAddress() == null) {
           System.out.println("org.telecomAddress: null");
        } else {
            for (Tel tel : dto.getTelecomAddress().getItem()) {
               System.out.println("org.telecomAddress.item.value: " + tel.getValue());
            }
        }
    }
    
    
    private static OrganizationDTO convertOrganizationDTORemoteToLocal(CTEPOrganizationDTO ecmMsOrganizationDTO) {
        OrganizationDTO localOrganizationDTO = new OrganizationDTO();
        localOrganizationDTO.setIdentifier(ecmMsOrganizationDTO.getIdentifier());
        localOrganizationDTO.setName(ecmMsOrganizationDTO.getName());
        localOrganizationDTO.setStatusDate(ecmMsOrganizationDTO.getStatusDate());
        localOrganizationDTO.setStatusCode(ecmMsOrganizationDTO.getStatusCode());
        localOrganizationDTO.setPostalAddress(ecmMsOrganizationDTO.getPostalAddress());
        localOrganizationDTO.setTelecomAddress(ecmMsOrganizationDTO.getTelecomAddress());
        localOrganizationDTO.setFamilyOrganizationRelationships(ecmMsOrganizationDTO
                .getFamilyOrganizationRelationships());
        
        System.out.println("Returning converted organization by ID from ECM MS:" + localOrganizationDTO.toString());
        return localOrganizationDTO;
    }
    
    /**
     * @param dto object
     * @return string representing the @param dto
     */
    public static String toString(CTEPHealthcareFacilityDTO dto) {
        StringBuffer b = new StringBuffer();
        b.append("hcf identifiers: \n");
        b.append(printIdentifierSet(dto, "hcf"));
        b.append(printII("hcf.player", dto.getPlayerIdentifier()));
        b.append(String.format("hcf.status: %s", (dto.getStatus() != null ? dto.getStatus().getCode() : NULL_STRING)));
        b.append('\n');
        return b.toString();
    }
    
    private static String printIdentifierSet(CTEPHealthcareFacilityDTO dto, String prefix) {
        StringBuffer b = new StringBuffer();
        if (dto.getIdentifier() != null) {
            for (Ii ii : dto.getIdentifier().getItem()) {
                b.append(printII(prefix, ii));
            }
        }
        System.out.println(b);
        return b.toString();
    }
    
    private static String printII(String prefix, Ii ii) {
        StringBuffer b = new StringBuffer();
        if (ii != null) {
            b.append(String.format("%s.ii.identifierName: %s", prefix, ii.getIdentifierName()));
            b.append('\n');
            b.append(String.format("%s.ii.extension: %s", prefix, ii.getExtension()));
            b.append('\n');
            b.append(String.format("%s.ii.root: %s", prefix, ii.getRoot()));
            b.append('\n');
        } else {
            b.append(String.format("%s.ii: %s", prefix, NULL_STRING));
            b.append('\n');
        }
        return b.toString();
        
    }
    
    private static final String NULL_STRING = "null";
}
