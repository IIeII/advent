package logika;


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
        Prostor trh = new Prostor("Рынок","domeček, ve kterém bydlí Karkulka");
        Prostor zakoulki = new Prostor("Закаулки", "chaloupka, ve které bydlí babička Karkulky");
        Prostor namesti = new Prostor("Площадь","temný les, ve kterém lze potkat vlka");
        Prostor palac = new Prostor("Дворец","temný les, ve kterém lze potkat vlka");
        Prostor ulice = new Prostor("Уличка","stará plesnivá jeskyně");
        Prostor aley = new Prostor("Алея","les s jahodami, malinami a pramenem vody");
        Prostor trida = new Prostor("Хз","les s jahodami, malinami a pramenem vody");
        Prostor les = new Prostor("Лес","les s jahodami, malinami a pramenem vody");
        Prostor pole = new Prostor("Поле","les s jahodami, malinami a pramenem vody");

        // přiřazují se průchody mezi prostory (sousedící prostory)
        trh.setVychod(zakoulki);

        zakoulki.setVychod(namesti);
        zakoulki.setVychod(ulice);

        namesti.setVychod(zakoulki);
        namesti.setVychod(aley);
        namesti.setVychod(palac);

        palac.setVychod(ulice);

        aley.setVychod(namesti);
        aley.setVychod(trida);

        ulice.setVychod();

                
        aktualniProstor = trh;  // hra začíná v domečku
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
