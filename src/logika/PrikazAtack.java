package logika;

/**
 *  Třída PrikazAtack implementuje pro hru příkaz útok.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Valeria Nekhimchuk
 *@version    pro školní rok 2016/2017
 */
public class PrikazAtack implements IPrikaz {

    private static final String NAZEV = "atack";
    private final HerniPlan plan;
    private final Hrac hrac;
    private Hra hra;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, získat aktuální prostor
     *  @param hrac copy třída hrac
     *  @param hra odkaz na hru, která má ukončena
     */
    public PrikazAtack(HerniPlan plan, Hrac hrac, Hra hra) {

        this.plan = plan;
        this.hrac = hrac;
        this.hra = hra;
    }

    /**
     *  Provádí příkaz "atack". Implementuje mechanismus v konečném místnosti
     *
     *@param parametry - jako parametr přijímá věži k útoku
     *
     *@return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {

        IInteraktiv object = plan.getAktualniProstor().getInteractiveObjectByName("босс");

        if (object == null){
            return "Нет нужды для агресии, тут некого атаковать";
        }

        if (parametry.length == 0) {
            return "Укажи в параметрах какую башню из 6ти ты бы хотел проверить";
        }

        int userInput;

        try {
            userInput = Integer.decode(parametry[0]);
        } catch (NumberFormatException e){
            return "Не верный формат, пожалуйста, укажи цифрой от 1 до 6";
        }

        if (userInput > 6 && userInput < 1){
            return "Ну серьезно, просто укажи число от 1 до 6!";
        }

        if (userInput == object.getArmyReward()){
            hra.setKonecHry(true);
            return "Чудовище поверженно, вы победили! Игра оконченна";
        }

        hrac.decreaseArmy();

        if (hrac.getArmySize() < 1) {
            hra.setKonecHry(true);
            return "Чудовище вас победило, вы ПРОИГРАЛИ! Игра оконченна";
        }

        return "Вы напали на башню но она оказалась пуста! В это время чудовище убило одного из ваших бойцов и теперь в вашей армии всего " + hrac.getArmySize() + " воинов";
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
