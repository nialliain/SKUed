package uk.org.wetdreams.skued.config;

import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;
import uk.org.wetdreams.skued.rest.RestResource;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/servlet")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(RestResource.class);
    }

}