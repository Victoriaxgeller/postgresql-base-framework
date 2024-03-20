package postgres.utils;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class PropertyLoader {

    private String db_url;
    private String user;
    private String password;

    public PropertyLoader() {
        readProps();
    }

    private void readProps() {
        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            db_url = prop.getProperty("db.url");
            user = prop.getProperty("db.user");
            password = prop.getProperty("db.password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
