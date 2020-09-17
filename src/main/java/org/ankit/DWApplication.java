package org.ankit;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.ankit.health.TemplateHealthCheck;
import org.ankit.resources.PersonService;

public class DWApplication extends Application<DWConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DWApplication().run(args);
    }

    @Override
    public String getName() {
        return "DW";
    }

    @Override
    public void initialize(final Bootstrap<DWConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DWConfiguration c, final Environment e) {
        final PersonService personService = new PersonService();
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(c.getTemplate());
        e.jersey().register(personService);
        e.healthChecks().register("template", healthCheck);
    }

}
