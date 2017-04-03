package gov.nih.nci.ctrp.ecm_service_apache_rest_client;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;


/**
 * @author Ramakrishna
 *
 */
public class ECMRestClientHelper {

     /**
     * 
     * @param <T> the type
     * @param obj the obj
     * @return the JSON String for the obj
     * @throws IOException IOException
     */
    public static <T> String marshallJSON(T obj)
            throws IOException {

        String responseJSONStr = "";
        ObjectMapper mapper = new ObjectMapper();
        responseJSONStr = mapper.writeValueAsString(obj);

        return responseJSONStr;
    }


     /**
     * 
     * @param jsonString the jsonString
     * @param <T> the <T>
     * @param objClass the objClass
     * @return the Object for the JSONString
     */
    public static <T> T unmarshallJSON(String jsonString, Class<T> objClass) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // JSON from String to Object
             return (mapper.readValue(jsonString, objClass));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * 
     * @param jsonString the jsonString
     * @param <T> the <T>
     * @param valueTypeRef the valueTypeRef
     * @return the Object for the JSONString
     */
    public static <T> T unmarshallJSON(String jsonString, TypeReference<T> valueTypeRef) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // JSON from String to Object
             return (mapper.readValue(jsonString, valueTypeRef));
             
        } catch (Exception e) {
        	 System.out.println(e.getMessage());
            return null;
        }
    }

}
