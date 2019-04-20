
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
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
                System.out.println("|||||| " + responseBody);
                ObjectMapper mp = new ObjectMapper();
                user = mp.readValue(responseBody, User.class);
                System.out.println("++++++ " + user.getFullName());
            } else {
                throw new Exception();
            }
        }
        return user;
    }
    
    
    
}
