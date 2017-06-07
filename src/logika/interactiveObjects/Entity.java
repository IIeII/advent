package logika.interactiveObjects;

import logika.IInteraktiv;
import logika.InventoryItem;

public class Entity implements IInteraktiv {

    private final String name;
    private final String description;
    private final String rewardDescription;
    private final InventoryItem reward;
    private final String expectedCommand;
    private final int expectedType;
    private final int armyReward;

    public Entity(String name, String description, String rewardDescription, InventoryItem reward, String expectedCommand, int expectedType, int armyReward) {
        this.name = name;
        this.description = description;
        this.rewardDescription = rewardDescription;
        this.reward = reward;
        this.expectedCommand = expectedCommand;
        this.expectedType = expectedType;
        this.armyReward = armyReward;
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
    public InventoryItem getReward() {
        return reward;
    }

    @Override
    public int getExpectedType() {
        return expectedType;
    }

    @Override
    public int getArmyReward() {
        return armyReward;
    }
}
