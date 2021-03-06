package com.packt.delivery.main;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@Stateless
@LocalBean
public class GeneralProvider {
    
    @Produces
    public Properties getProperties() throws IOException {
        Properties properties = new Properties();
        
        InputStream inputStream = GeneralProvider.class.getResourceAsStream(Optional.ofNullable(System.getProperty("ENV"))
                .map(env -> "/application-" + env + ".properties")
                .orElse("/application.properties"));
        
        properties.load(inputStream);
        
        return properties;
    }
    
    @Produces
    public Client getClient(){
        return ClientBuilder.newClient();
    }
}
