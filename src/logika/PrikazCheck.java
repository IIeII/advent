package logika;

public class PrikazCheck implements IPrikaz {

    private static final String NAZEV = "check";
    private HerniPlan plan;


    public PrikazCheck(HerniPlan plan) {

        this.plan = plan;
    }

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

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
