<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public class BookAPI {
    public static void searchBook(String query) {
        try {
            String urlString = "https://www.googleapis.com/books/v1/volumes?q=" + query.replace(" ", "+");
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray books = jsonResponse.getJSONArray("items");
            
            System.out.println("\nBook Recommendations from Google Books:");
            for (int i = 0; i < Math.min(3, books.length()); i++) {
                JSONObject book = books.getJSONObject(i).getJSONObject("volumeInfo");
                String title = book.getString("title");
                String author = book.has("authors") ? book.getJSONArray("authors").getString(0) : "Unknown";
                System.out.println((i + 1) + ". " + title + " by " + author);
            }

        } catch (Exception e) {
            System.out.println("Error fetching book data: " + e.getMessage());
        }
    }
}
=======
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public class BookAPI {
    public static void searchBook(String query) {
        try {
            String urlString = "https://www.googleapis.com/books/v1/volumes?q=" + query.replace(" ", "+");
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray books = jsonResponse.getJSONArray("items");
            
            System.out.println("\nBook Recommendations from Google Books:");
            for (int i = 0; i < Math.min(3, books.length()); i++) {
                JSONObject book = books.getJSONObject(i).getJSONObject("volumeInfo");
                String title = book.getString("title");
                String author = book.has("authors") ? book.getJSONArray("authors").getString(0) : "Unknown";
                System.out.println((i + 1) + ". " + title + " by " + author);
            }

        } catch (Exception e) {
            System.out.println("Error fetching book data: " + e.getMessage());
        }
    }
}
>>>>>>> 1a94b891536753ea4de59780a52a8e03760e0801
