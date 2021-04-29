package TwitchRecommenderBackend.db;


import java.io.IOException;
        import java.io.InputStream;
        import java.util.Properties;

public class MySQLDBUtil {
    private static final String INSTANCE = "database-twitch-app.cfpgngj2dfbe.us-east-1.rds.amazonaws.com";
    private static final String PORT_NUM = "3306";
    private static final String DB_NAME = "twitchRecommender_db";
    public static String getMySQLAddress() throws IOException {
        Properties prop = new Properties();
        String propFileName = "config.properties";

//        https://www.tutorialspoint.com/java/lang/class_getclassloader.htm
        InputStream inputStream = MySQLDBUtil.class.getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);

        String username = prop.getProperty("user");
        String password = prop.getProperty("password");
        return String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s&autoReconnect=true&serverTimezone=UTC&createDatabaseIfNotExist=true",
                INSTANCE, PORT_NUM, DB_NAME, username, password);
    }

}