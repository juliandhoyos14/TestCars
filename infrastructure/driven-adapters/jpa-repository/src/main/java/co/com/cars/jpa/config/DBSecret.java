package co.com.cars.jpa.config;

import lombok.Builder;
import lombok.Getter;
@Builder
@Getter
public class DBSecret {
    private String url;
    private String host;
    private String username;
    private String password;
    private String schema;
    private String dbname;
    private String port;
    private String engine;
}
