
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.concurrent.Cancellable;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SNDJ
 */
public class HttpConnector {  
    
    public User login(String email, String password) throws Exception {
        User user;
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://localhost:8082/login");
            
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("email", email));
            params.add(new BasicNameValuePair("password", password));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            
            CloseableHttpResponse response = client.execute(httpPost);
            
            if (response.getStatusLine().getStatusCode() == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());
                ObjectMapper mp = new ObjectMapper();
                user = mp.readValue(responseBody, User.class);
                System.out.println("Success " + user.getUserType());
            } else {
                System.out.println("Failure " + response.getStatusLine().getStatusCode());
                throw new Exception();
            }
        }
        return user;
    }
     public User createUser(User user) throws Exception {
       
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://localhost:8082/users");
             ObjectMapper mp = new ObjectMapper();
             String userjson = mp.writeValueAsString(user);
            httpPost.setEntity(new StringEntity(userjson));
            
            httpPost.setHeader("content-type", "application/json");
            
            CloseableHttpResponse response = client.execute(httpPost);
            
            if (response.getStatusLine().getStatusCode() == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());
                user = mp.readValue(responseBody, User.class);
            } else {
                throw new Exception();
            }
        }
        return user;
    }
     public User updateUser(User user) throws Exception {
       
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPut httpPut = new HttpPut("http://localhost:8082/users/" +user.getId());
             ObjectMapper mp = new ObjectMapper();
             String userjson = mp.writeValueAsString(user);
            httpPut.setEntity(new StringEntity(userjson));
            
            httpPut.setHeader("content-type", "application/json");
            
            CloseableHttpResponse response = client.execute(httpPut);
            
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println("User update successful");
                String responseBody = EntityUtils.toString(response.getEntity());
                user = mp.readValue(responseBody, User.class);
            } else {
                System.out.println("User update failed: " + response.getStatusLine().getStatusCode());
                throw new Exception();
            }
        }
        return user;
     }

      
    public boolean deleteUser(String uid) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpDelete httpDelete = new HttpDelete("http://localhost:8082/users/" +uid);
            
            CloseableHttpResponse response = client.execute(httpDelete);
            
            if (response.getStatusLine().getStatusCode() == 200) {
                return true;
            } else {
                throw new Exception();
            }
        }
    }
    
      public List<Object> getUsers() throws Exception {
        List<Object> users;
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://localhost:8082/users");
           
            CloseableHttpResponse response = client.execute(httpGet);
            
            if (response.getStatusLine().getStatusCode() == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("|||||| " + responseBody);
                ObjectMapper mp = new ObjectMapper();
                users = mp.readValue(responseBody, List.class);
        
            } else {
                throw new Exception();
            }
        }
        return users;
    }

}
    

