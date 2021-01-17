package scenario.util;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static final Configuration instance = new Configuration();

    private String baseUrl;
    private String userEmail;
    private String userPassword;

    public static Configuration getInstance() {
        return instance;
    }

    private Configuration() {

        try (InputStream is = ClassLoader.getSystemResourceAsStream("config.properties")) {

            Properties configProps = new Properties();
            configProps.load(is);

            this.baseUrl = configProps.getProperty("base.url");
            this.userEmail = configProps.getProperty("user.email");
            this.userPassword = configProps.getProperty("user.password");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getUserEmail() { return userEmail; }

    public String getUserPassword() { return userPassword; }
}
