package logika;

public interface IInteraktiv {
    /**
     * TODO:description
     */
    public String getDescription();

    public String getName();

    public String getExpectedCommand();

    public String getRewardDescription();

    public InventoryItem getReward();

    public int getExpectedType();

    public int getArmyReward();
}
