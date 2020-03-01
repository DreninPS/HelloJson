import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FirstApi {

    public static void main(String[] args) throws ClientProtocolException, IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5");

        try {
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        List<Data> data = new Gson().fromJson(rd, new TypeToken<List<Data>>() {}.getType());
            System.out.println(data);
        }
        catch (Exception e) {
            System.out.println("Нет ответа или Интернета");
        }


    }
    public class Data{
        public String ccy;
        public String base_ccy;
        public String buy;
        public String sale;

        @Override
        public String toString() {
            return '\n' + "Exchange " +
                    "ccy='" + ccy + '\'' +
                    ", baseCcy='" + base_ccy + '\'' +
                    ", buy='" + buy + '\'' +
                    ", sale='" + sale + '\'';
        }

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
