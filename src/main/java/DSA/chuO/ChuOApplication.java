package DSA.chuO;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class ChuOApplication {

	public static void main(String[] args) {


        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new FileInputStream("path/to/serviceAccountKey.json")))
                    .setDatabaseUrl("https://projectchuo-default-rtdb.firebaseio.com")
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FirebaseApp.initializeApp(options);

		SpringApplication.run(ChuOApplication.class, args);



	}

}
