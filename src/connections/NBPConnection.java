package connections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NBPConnection {

    private static HttpURLConnection connection;

    public double getCurrentExchangeRate(String currency) {

        double exchangeRate = 0;

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/"+currency+"/?format=json");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }

            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();

            String rate = responseContent.toString().split("\"mid\":")[1].split("}")[0];

            exchangeRate = Double.parseDouble(rate);

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            connection.disconnect();
        }

        exchangeRate = Math.round(exchangeRate * 100.0) / 100.0;

        return exchangeRate;
    }
}
