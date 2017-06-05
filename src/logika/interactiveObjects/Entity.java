package logika.interactiveObjects;

import logika.IInteraktiv;

public class Entity implements IInteraktiv {

    private final String name;
    private final String description;
    private final String reward;
    private final String expectedCommand;
    private final int expectedType;

    public Entity(String name, String description, String reward, String expectedCommand, int expectedType) {
        this.name = name;
        this.description = description;
        this.reward = reward;
        this.expectedCommand = expectedCommand;
        this.expectedType = expectedType;
    }

    @Override
    public String getDescription() {
        return description;
    }


    @Override
    public String getName() {
        return name;
    }
}
