package logika;

public class PrikazProzkoumej implements IPrikaz {

    private static final String NAZEV = "prozkoumej";
    private Prostor aktualniProstor;

    public PrikazProzkoumej(Prostor aktualniProstor) {

        this.aktualniProstor = aktualniProstor;
    }

    @Override
    public String provedPrikaz(String... parametry) {

        String result = "Осмотревшись вокруг вы видите: ";
        String emptySpace = "Осмотревшись Вы не замечаете ничего интересного вокруг";
        String wrongParam = "Не понимаю о чем ты. Проверь комманду";

        if (parametry.length == 0) {
            return aktualniProstor.getObjectNames() == null ? emptySpace : result + aktualniProstor.getObjectNames();
        }

        IInteraktiv object = aktualniProstor.getInteractiveObjectByName(parametry[0]);

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
