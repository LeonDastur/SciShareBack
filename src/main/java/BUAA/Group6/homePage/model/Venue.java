package BUAA.Group6.homePage.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Venue {
    @Field(value = "raw")
    private String raw;

    public Venue(String raw) {
        this.raw = raw;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }
}
