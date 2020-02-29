import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstApi {

    public static void main(String[] args) throws ClientProtocolException, IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String lineOne = "[{\"ccy\":\"USD\",\"base_ccy\":\"UAH\",\"buy\":\"24.25000\",\"sale\":\"24.70000\"}]";
        String line = "";
        System.out.println(line);

        while ((line = rd.readLine()) != null) {
            System.out.println(line);
       // lineOne=line;
        }
        System.out.println(lineOne);

        Data data = new Gson().fromJson(lineOne, Data.class);
//        System.out.println("ccy = "+data.ccy+"Base ccy = "+data.base_ccy);
//        System.out.println(data);
//        Gson data = new Gson().fromJson(line, Gson.class);
//        System.out.println("ccy = "+data.ccy+"Base ccy = "+data.base_ccy);

    }
    public class Data{
        public String ccy;
        public String base_ccy;
        public String buy;
        public String sale;

//        @Override
 //       public String toString(){
 //           return "Movie [ccy=" + ccy + ", director=" + base_ccy + ",actors=" + buy + "]";
//        }


        public String getCcy() {
            return ccy;
        }

        public void setCcy(String ccy) {
            this.ccy = ccy;
        }

        public String getBase_ccy() {
            return base_ccy;
        }

        public void setBase_ccy(String base_ccy) {
            this.base_ccy = base_ccy;
        }

        public String getBuy() {
            return buy;
        }

        public void setBuy(String buy) {
            this.buy = buy;
        }

        public String getSale() {
            return sale;
        }

        public void setSale(String sale) {
            this.sale = sale;
        }
    }
}
