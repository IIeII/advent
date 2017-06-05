package logika.interactiveObjects;

import logika.IInteraktiv;

public class Entity implements IInteraktiv {

    private final String name;
    private final String description;
    private final String rewardDescription;
    private final String reward;
    private final String expectedCommand;
    private final int expectedType;

    public Entity(String name, String description, String rewardDescription, String reward, String expectedCommand, int expectedType) {
        this.name = name;
        this.description = description;
        this.rewardDescription = rewardDescription;
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

    @Override
    public String getExpectedCommand() {
        return expectedCommand;
    }

    @Override
    public String getRewardDescription() {
        return rewardDescription;
    }

    @Override
    public String getReward() {
        return reward;
    }

    @Override
    public int getExpectedType() {
        return expectedType;
    }
}
