package atf.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("environment")
public class EnvironmentProperties {

    private String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
