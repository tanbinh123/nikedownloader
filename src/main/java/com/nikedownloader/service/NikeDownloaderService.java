package com.nikedownloader.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.garmin.model.tcx.ObjectFactory;
import com.garmin.model.tcx.TrainingCenterDatabaseT;
import com.nikedownloader.converter.NikeJsonConverter;
import com.nikedownloader.model.json.Activities;
import com.nikedownloader.model.json.Activity;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;

@Service
public class NikeDownloaderService {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    private final String USER_AGENT = "Mozilla/5.0";

    private String token;

    @Value("${nike.login.url}")
    private String nikeLoginUrl;


    public InputStream getActivityInputStream(String activityId) throws Exception {

        Activity activity = getActivity(activityId);
        ObjectFactory objectFactory = new ObjectFactory();
        TrainingCenterDatabaseT trainingCenterDatabaseT = NikeJsonConverter.activityJsonToTcx(activity);
        JAXBElement<TrainingCenterDatabaseT> trainingCenterDatabase = objectFactory.createTrainingCenterDatabase(trainingCenterDatabaseT);

        StringWriter sw = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TrainingCenterDatabaseT.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(trainingCenterDatabase, sw);
            jaxbMarshaller.marshal(trainingCenterDatabase, System.out);

        } catch (JAXBException e) {
            logger.info(e.getMessage());
        }

        return new ByteArrayInputStream(sw.getBuffer().toString().getBytes());
    }

    // HTTP POST request
    public void sendPost(String login, char[] password) throws Exception {

        URL obj = new URL(nikeLoginUrl);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "pl-PL,pl;q=0.5");

        String urlParameters = "username=" + login + "&password=" + String.valueOf(password);

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + nikeLoginUrl);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response.toString());
        String accessToken = jsonNode.get("access_token").textValue();
        long expiresIn = jsonNode.get("expires_in").longValue();
        expiresIn += (System.currentTimeMillis() / 1000);
        setToken(accessToken);
    }

    public Activities getActivities(LocalDate dateFrom, LocalDate dateTo, int count) throws Exception {

        final String url = "https://api.nike.com/v1/me/sport/activities/RUNNING?access_token=" + getToken() + "&startDate=" + dateFrom.toString() + "&endDate=" + dateTo.toString() + "&count=" + count;
        StringBuffer response = senGET(url);
        ObjectMapper mapper = new ObjectMapper();
        Activities jsonObject = mapper.readValue(response.toString(), Activities.class);

        return jsonObject;
    }

    public Activity getActivity(String activityId) throws Exception {
        String url = "https://api.nike.com/v1/me/sport/activities/" + activityId + "?access_token=" + getToken();

        StringBuffer response = senGET(url);
        ObjectMapper mapper = new ObjectMapper();
        Activity jsonObject = mapper.readValue(response.toString(), Activity.class);

        return jsonObject;
    }

    private StringBuffer senGET(String url) throws IOException {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        // con.setRequestProperty("access_token", token);

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
        return response;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
