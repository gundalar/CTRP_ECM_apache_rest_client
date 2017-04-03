package gov.nih.nci.ctrp.ecm_service_apache_rest_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang.StringUtils;


/**
 * @author Purnima, Reshma
 *
 */
public class RestClient {

    private static final Integer HTTP_SUCCESS_CODE_200 = 200;
    private static final Integer HTTP_SUCCESS_CODE_201 = 201;
    private static final int HTTP_TIME_OUT = 10000;
    private static final Integer HTTP_NOT_FOUND_404 = 404;
    private static final Integer SLEEP_TIME = 5000;


    /**
     * Invokes REST api to get the ECM Microservice.
     * 
     * @param restUrl
     *            - rest URL
     * @param method
     *            - HTTP Method
     * @param postBody
     *            - Post body
     * @return - Response after update
     * @throws Exception
     *             Exception
     * 
     */
    @SuppressWarnings({ "PMD.CyclomaticComplexity" })
    public String sendHTTPRequest(String restUrl, String method, String postBody) throws Exception {
        int httpResponseCode = -1;
        String httpResponseMessage = "";
        System.out.println("url: " + restUrl);
        HttpURLConnection urlConnection = null;

        boolean success = false;
            try {
                urlConnection = makeUrlConnection(restUrl, method, postBody);

                httpResponseCode = urlConnection.getResponseCode();
                if (httpResponseCode == HTTP_SUCCESS_CODE_200 || httpResponseCode == HTTP_SUCCESS_CODE_201) {
                    success = true;
                } else if (httpResponseCode == HTTP_NOT_FOUND_404) {
                    return null;
                }
            } catch (Exception e) {
            	System.out.println("Error: Unable to get response from Rest server (" + httpResponseCode + ") - "
                        + httpResponseMessage + e);
            }
        if (success) {
            return readResponse(urlConnection);
        }  else {
            throw new Exception("Error: Unable to get response from Rest server @" + restUrl);
        }

    }

    private String readResponse(HttpURLConnection urlConnection) throws Exception {
        BufferedReader reader;
        StringBuilder httpResponse = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                httpResponse.append(line);
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                	System.out.println(e.getMessage());
                }
            }

            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            throw new Exception("Error in reading ECM micro service response:  " + e.getMessage(), e);
        }
        return httpResponse.toString();
    }

    /**
     * 
     * @param restUrl the URL to connect to
     * @param method the HTTP method GET/POST/PUT/DELETE
     * @param postBody the jsonStr of the post request body
     * @return http connection to the URL 
     * @throws IOException
     */
    private HttpURLConnection makeUrlConnection(String restUrl, String method, String postBody)
            throws IOException {
        URL url = new URL(restUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setConnectTimeout(HTTP_TIME_OUT);
        urlConnection.setReadTimeout(HTTP_TIME_OUT);
        urlConnection.setRequestMethod(method);
        urlConnection.setRequestProperty("Accept", "application/json");
        urlConnection.setRequestProperty("Content-Type", "application/json");
        urlConnection.setDoOutput(true);

        if ((StringUtils.equals(method, "POST") || StringUtils.equals(method, "PUT") 
                || StringUtils.equals(method, "DELETE"))
                && postBody != null && postBody.length() > 0) {
            System.out.println("postBody: " + postBody);
            setPostBody(urlConnection, postBody);
        } 
        return urlConnection;
    }

    /**
     * Sets post body to the http request.
     * 
     * @param urlConnection
     *            - URL Connection
     * @param postBody
     *            - Post body
     * @throws IOException
     *             - throws IOException
     */
    private void setPostBody(HttpURLConnection urlConnection, String postBody) throws IOException {
        OutputStream outputStream = urlConnection.getOutputStream();
        outputStream.write(postBody.getBytes());
        outputStream.flush();
    }

}
