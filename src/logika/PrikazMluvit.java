package logika;

public class PrikazMluvit implements IPrikaz {

    private static final String NAZEV = "action";
    private final Prostor aktualniProstor;
    private final Hrac hrac;

    public PrikazMluvit(Prostor aktualniProstor, Hrac hrac) {

        this.aktualniProstor = aktualniProstor;
        this.hrac = hrac;
    }

    @Override
    public String provedPrikaz(String... parametry) {

        String defaultText = "Ты можешь использовать вещи с инвентаря или произнести свою комманду.";
        String errorText = "Ты попытался это сделать, но увы ничего не случилось!";

        String inventoryItems = "В твоем рюкзаке ";
        String inventory1 = "пусто";

        if (parametry.length == 0) {
            return defaultText + "\n" + inventoryItems + (hrac.getInventoryItemsNames() == null ? inventory1 : hrac.getInventoryItemsNames());
        }

        IInteraktiv iobject = aktualniProstor.getInterrectiveObjectByAction(parametry[0]);
        if (iobject != null){
            if (iobject.getExpectedType() == CommandType.COMMAND_ITEM){
                aktualniProstor.removeInteractiveObject(iobject);
                if (iobject.getReward() != null){
                    hrac.addItemToInventory(iobject.getReward());
                }
                return iobject.getRewardDescription();
            }

            if ((iobject.getExpectedType() == CommandType.INVENTORY_ITEM) && ){

            }
        }

        return errorText;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
