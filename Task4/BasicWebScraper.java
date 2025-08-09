import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlainJavaScraper {

    public static void main(String[] args) {
        String url = "https://example-ecommerce-site.com"; // Replace with your target URL

        try {
            // Fetch HTML content
            String html = fetchHTML(url);

            // Write data to CSV
            FileWriter csvWriter = new FileWriter("products.csv");
            csvWriter.append("Name,Price,Rating\n");

            // Regex to extract product name, price, and rating
            Pattern productPattern = Pattern.compile(
                "<div class=\"product\">.*?<h2>(.*?)</h2>.*?<span class=\"price\">(.*?)</span>.*?<span class=\"rating\">(.*?)</span>",
                Pattern.DOTALL);

            Matcher matcher = productPattern.matcher(html);

            while (matcher.find()) {
                String name = matcher.group(1).trim();
                String price = matcher.group(2).trim();
                String rating = matcher.group(3).trim();

                System.out.println("Name: " + name + ", Price: " + price + ", Rating: " + rating);

                // Write to CSV
                csvWriter.append(name).append(",");
                csvWriter.append(price).append(",");
                csvWriter.append(rating).append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
            System.out.println("✅ Data saved to products.csv");

        } catch (IOException e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }

    // Method to fetch HTML from a URL
    private static String fetchHTML(String urlToRead) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;

        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
}