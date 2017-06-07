package logika;

import java.util.Random;

public class PrikazTry implements IPrikaz {

    private static final String NAZEV = "try";
    private HerniPlan plan;
    private Hrac hrac;
    private Random rand;

    public PrikazTry(HerniPlan plan, Hrac hrac) {

        this.plan = plan;
        this.hrac = hrac;
        rand = new Random();
    }
    @Override
    public String provedPrikaz(String... parametry) {

        String defaultText = "Ты можешь попытать удачу в некоторых ситуациях, ищи подсказки в диалогах.";
        String errorText = "Ты попытался это сделать, но увы ничего не случилось, может попробуешь еще?";

        String inventoryItems = "В твоем рюкзаке ";
        String inventory2 = "недостаточно места для продолжения!";

        if (parametry.length == 0) {
            return defaultText;
        }

        IInteraktiv iobject = plan.getAktualniProstor().getInterrectiveObjectByAction(parametry[0]);

        if (iobject != null && iobject.getReward() != null && !hrac.isEnouthSpaceInInventory()){
            return inventoryItems + inventory2;
        }

        if (iobject != null){
            if ((iobject.getExpectedType() == CommandType.CHANCE_ITEM) && rand.nextBoolean()){
                plan.getAktualniProstor().removeInteractiveObject(iobject);
                hrac.addItemToInventory(iobject.getReward());
                hrac.addToArmy(iobject.getArmyReward());
                return iobject.getRewardDescription();
            }
        }

        return errorText;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }

}
