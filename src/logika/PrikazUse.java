package logika;

public class PrikazUse implements IPrikaz {

    private static final String NAZEV = "use";
    private final HerniPlan plan;
    private final Hrac hrac;

    public PrikazUse(HerniPlan plan, Hrac hrac) {

        this.plan = plan;
        this.hrac = hrac;
    }

    @Override
    public String provedPrikaz(String... parametry) {

        String defaultText = "Ты можешь использовать вещи с инвентаря или произнести свою комманду.";
        String errorText = "Ты попытался это сделать, но увы ничего не случилось!";

        String inventoryItems = "В твоем рюкзаке ";
        String inventory1 = "пусто";
        String inventory2 = "недостаточно места для продолжения!";

        if (parametry.length == 0) {
            return defaultText + "\n" + inventoryItems + (hrac.getInventoryItemsNames() == null ? inventory1 : hrac.getInventoryItemsNames());
        }

        IInteraktiv iobject = plan.getAktualniProstor().getInterrectiveObjectByAction(parametry[0]);

        if (iobject != null && iobject.getReward() != null && !hrac.isEnouthSpaceInInventory()){
            return inventoryItems + inventory2;
        }

        if (iobject != null){
            if (iobject.getExpectedType() == CommandType.COMMAND_ITEM){
                plan.getAktualniProstor().removeInteractiveObject(iobject);
                hrac.addItemToInventory(iobject.getReward());
                hrac.addToArmy(iobject.getArmyReward());
                return iobject.getRewardDescription();
            }

            if ((iobject.getExpectedType() == CommandType.INVENTORY_ITEM) && hrac.hasItemInInventory(parametry[0])){
                plan.getAktualniProstor().removeInteractiveObject(iobject);
                hrac.removeItemFromInventory(parametry[0]);
                hrac.addItemToInventory(iobject.getReward());
                hrac.addToArmy(iobject.getArmyReward());
                return iobject.getRewardDescription();
            }
        }

        return errorText;
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
