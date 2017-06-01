package logika;

public class PrikazProzkoumej implements IPrikaz {

    private static final String NAZEV = "prozkoumej";
    private Prostor aktualniProstor;

    public PrikazProzkoumej(Prostor aktualniProstor) {

        this.aktualniProstor = aktualniProstor;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        return null;
    }

    @Override
    public String getNazev() {
        return null;
    }
}
