package logika;

/**
 *  Třída PrikazLookAround implementuje pro hru příkaz prozkoumat prostor.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Valeria Nekhimchuk
 *@version    pro školní rok 2016/2017
 */
public class PrikazLookAround implements IPrikaz {

    private static final String NAZEV = "prozkoumej";
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, získat aktuální prostor
     */
    public PrikazLookAround(HerniPlan plan) {

        this.plan = plan;
    }

    /**
     *  Provádí příkaz "prozkoumej".
     *  Dovolit hráči se rozhlédnout po místnosti a vrací seznam objektů,
     *  se kterými můžete komunikovat
     *
     *@param parametry - jako parametry se neočekává
     *
     *@return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {

        String result = "Осмотревшись вокруг вы видите: ";
        String emptySpace = "Осмотревшись Вы не замечаете ничего интересного вокруг";
        String wrongParam = "Не понимаю о чем ты. Проверь комманду";

        if (parametry.length == 0) {
            return plan.getAktualniProstor().getObjectNames() == null ? emptySpace : result + plan.getAktualniProstor().getObjectNames();
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
