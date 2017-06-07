package logika;

import java.util.Random;

/**
 *  Třída PrikazTry implementuje pro hru příkaz která se může stát s určitou pravděpodobností
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Valeria Nekhimchuk
 *@version    pro školní rok 2016/2017
 */
public class PrikazTry implements IPrikaz {

    private static final String NAZEV = "try";
    private HerniPlan plan;
    private Hrac hrac;
    private Random rand;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, získat aktuální prostor
     *  @param hrac copy třída hrac
     */
    public PrikazTry(HerniPlan plan, Hrac hrac) {

        this.plan = plan;
        this.hrac = hrac;
        rand = new Random();
    }

    /**
     *  Provádí příkaz "try". Implementuje mechanismus umožní spouštět příkazy,
     *  které jsou výsledkem nemůže být neustále mění v závislosti na Random
     *
     *@param parametry - jako parametr přijímá příkazy, názvy
     *
     *@return zpráva, kterou vypíše hra hráči
     */
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
