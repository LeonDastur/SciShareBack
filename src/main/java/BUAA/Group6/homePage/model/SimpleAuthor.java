package BUAA.Group6.homePage.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class SimpleAuthor {
    String name;

    @Field(value = "id")
    String id;

    public SimpleAuthor(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
