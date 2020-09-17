package org.ankit;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;

public class DWConfiguration extends Configuration {

    private String template;

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}
