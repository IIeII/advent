package logika;


import logika.interactiveObjects.Entity;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor trh = new Prostor("Рынок","Рынок где можно встретить много странных личностей");
        Entity donkey = new Entity("DONKEY", "Donkey which is kolaspsing your way", "Осел ушел, теперь ты можешь продолжить свой путь", null, "Mrkev", CommandType.INVENTORY_ITEM);
        Entity trader = new Entity("TRADER", "Trader which has a lot of carrots, but wants to know what is S I M P R O ","Торговец любезно отдает тебе морковку, теперь она у тебя в инвентаре!", "Mrkev", "prosim", CommandType.COMMAND_ITEM);
        trh.setInteraktivníObjekt(donkey);
        trh.setInteraktivníObjekt(trader);

        Prostor zakoulki = new Prostor("Закаулки", "Закаулки межд домов, полные бродяг и мусора");
        Prostor namesti = new Prostor("Площадь","Центральная площадь города");
        Prostor palac = new Prostor("Дворец","Дворец где обитают властьимущие");
        Prostor ulice = new Prostor("Уличка","Небольшая узкая уличка");
        Prostor aley = new Prostor("Алея","Алея избранных, полна статуй");
        Prostor trida = new Prostor("Трида","Не знаю что это но что-то увлекательное");
        Prostor les = new Prostor("Лес","Темный лес с дендронами и эльфами");
        Prostor pole = new Prostor("Поле","Поле смертельного сражения");

        // přiřazují se průchody mezi prostory (sousedící prostory)
        trh.setVychod(zakoulki);
        trh.setLock(zakoulki, donkey, "Осел козел преградил путь, ты не пройдешь!");

        zakoulki.setVychod(namesti);
        zakoulki.setVychod(ulice);
        zakoulki.setVychod(trh);

        namesti.setVychod(zakoulki);
        namesti.setVychod(aley);
        namesti.setVychod(palac);

        palac.setVychod(ulice);//teleport
        palac.setVychod(namesti);

        aley.setVychod(namesti);
        aley.setVychod(trida);

        ulice.setVychod(zakoulki);
        ulice.setVychod(trida);
        ulice.setVychod(les);

        les.setVychod(ulice);
        les.setVychod(pole);
                
        aktualniProstor = trh;  // hra začíná v trh
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

}
