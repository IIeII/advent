package logika;

/**
 *  Třída PrikazCheck implementuje pro hru příkaz útok.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Valeria Nekhimchuk
 *@version    pro školní rok 2016/2017
 */
public class PrikazCheck implements IPrikaz {

    private static final String NAZEV = "check";
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, získat aktuální prostor
     */
    public PrikazCheck(HerniPlan plan) {

        this.plan = plan;
    }

    /**
     *  Provádí příkaz "check". To vám umožní komunikovat s objekty ve prostoru
     *
     *@param parametry - jako parametr přijímá název objektu
     *
     *@return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {

        String wrongParam = "Не понимаю о чем ты. Проверь комманду";

        if (parametry.length == 0) {
            return "Укажи в параметрах какой обьект ты бы хотел проверить";
        }

        IInteraktiv object = plan.getAktualniProstor().getInteractiveObjectByName(parametry[0]);

        if (object != null){
            return object.getDescription();
        }

        return wrongParam;
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
