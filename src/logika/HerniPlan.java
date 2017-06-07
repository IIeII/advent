package logika;


import logika.interactiveObjects.Entity;

import java.util.Random;

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
        Entity donkey = new Entity("осел", "Осел слишком голоден чтобы сдвинутся с места, вот если бы найти морковку...", "Осел ушел, теперь ты можешь продолжить свой путь", null, "Mrkev", CommandType.INVENTORY_ITEM, 0);
        Entity trader = new Entity("торговец", "У торговца есть много морквы, и он с радостью поделиться если ты ему подскажешь что же кроется за буквами S I M P R O ","Торговец любезно отдает тебе морковку, теперь она у тебя в инвентаре!", new InventoryItem("Mrkev"), "prosim", CommandType.COMMAND_ITEM, 0);
        trh.setInteraktivníObjekt(donkey);
        trh.setInteraktivníObjekt(trader);

        Prostor zakoulki = new Prostor("Закаулки", "Закаулки межд домов, полные бродяг и мусора");
        Entity box = new Entity("коробка", "Коробка на дне которой лежит ключ, используй ВЗЯТь чтобы поднять его", "Ключ добавлен тебе в инвентарь", new InventoryItem("ключ"), "взять", CommandType.COMMAND_ITEM, 0);
        Entity arc0 = new Entity("лучник", "Лучник потерявший лук и надежду.. вот если бы вернуть ему лук, он бы присоеденился к твоей армии!","Лучник воспрял духом и присоеденился к вашей армии!", null, "лук", CommandType.INVENTORY_ITEM, 1);
        zakoulki.setInteraktivníObjekt(box);
        zakoulki.setInteraktivníObjekt(arc0);

        Prostor namesti = new Prostor("Площадь","Центральная площадь города");
        Entity arc1 = new Entity("лучник", "Это наемный лучник и пойдет с тобой только если ты ему заплатишь!","Лучник позвякивая монетой присоеденился к вашей армии!", null, "монета", CommandType.INVENTORY_ITEM, 1);
        Entity mag = new Entity("волшебник", "Волшебник который знает слово которое откроет врата битвы, и поделиться лишь с тем кто знает умеет говорить абракадабра ","Волшебное слово для открытия врат битвы - рагнарок!", null, "абракадабра", CommandType.COMMAND_ITEM, 0);
        namesti.setInteraktivníObjekt(arc1);
        namesti.setInteraktivníObjekt(mag);

        Prostor palac = new Prostor("Дворец","Дворец где обитают властьимущие, так же вы замечаете в конце дворца телепорт, интересно куда он ведет");
        Entity arrows = new Entity("стрелы", "Кем-то потеряный колчан стрел, используй ВЗЯТь чтобы поднять его", "Колчан стрел добавлен тебе в инвентарь", new InventoryItem("Стрелы"), "взять", CommandType.COMMAND_ITEM, 0);
        Entity arc2 = new Entity("лучник", "Лучник который совсем заскучал, он пойдет с тобой просто так, только пригласи его с собой коммандой ПОШЛИ!","Лучник присоеденился к вашей армии!", null, "пошли", CommandType.CHANCE_ITEM, 1);
        palac.setInteraktivníObjekt(arrows);
        palac.setInteraktivníObjekt(arc2);

        Prostor ulice = new Prostor("Уличка","Небольшая узкая уличка");
        Entity chest = new Entity("сундук", "Сундук заперт на ключ, и только он сможет его открыть", "В сундуке ты находишь ЛУК и он уже добавлен в твой инвентарь", new InventoryItem("лук"), "ключ", CommandType.INVENTORY_ITEM, 0);
        Entity mag2 = new Entity("фокусник", "У него есть кое-что для тебя, только угадай в какой руке! ","Фокусник разжимает руку а в ней монетка! Теперь она ваша!", new InventoryItem("монета"), "левая", CommandType.CHANCE_ITEM, 0);
        ulice.setInteraktivníObjekt(chest);
        ulice.setInteraktivníObjekt(mag2);

        Prostor aley = new Prostor("Алея","Алея избранных, полна статуй");
        Entity arc3 = new Entity("снайпер", "Лучник потерявший колчан стрел,он бы пошел с тобой, но стрелять нечем","Лучник присоеденился к вашей армии!", null, "стрелы", CommandType.INVENTORY_ITEM, 1);
        Entity arc4 = new Entity("ельф", "Лучник который пойдет с вами, но только если твоя армия победит, ато умирать не охотно!","Лучник присоеденился к вашей армии!", null, "пошли", CommandType.CHANCE_ITEM, 1);
        aley.setInteraktivníObjekt(arc3);
        aley.setInteraktivníObjekt(arc4);

        Prostor trida = new Prostor("Трида","Не знаю что это но что-то увлекательное");
        Entity arc5 = new Entity("лучник", "Лучник уранил свою медаль за доблесть в фонтан, и отчаялся ее найти","Лучник присоеденился к вашей армии!", null, "медаль", CommandType.INVENTORY_ITEM, 1);
        Entity fontan = new Entity("фонтан", "Фонтан просто фонтан, и кажется на дне что-то есть.. попробуй ИСКАТЬ и вдруг тебе повезет", "В очередной раз обшарив дно ты натыкаешься на медаль!", new InventoryItem("медаль"), "искать", CommandType.CHANCE_ITEM, 0);
        trida.setInteraktivníObjekt(arc5);
        trida.setInteraktivníObjekt(fontan);

        Prostor les = new Prostor("Лес","Темный лес с дендронами и эльфами");
        Entity arc6 = new Entity("лучник", "Лучник который повидал многое.. предложи ему пойти с тобой и возможно тебе повезет","Лучник присоеденился к вашей армии!", null, "пошли", CommandType.COMMAND_ITEM, 1);
        Entity guard = new Entity("страж", "Страж который ждет избранного, знающего кодовое слово!", "Страж провалился под землю и путь теперь свободен", null, "рагнарок", CommandType.COMMAND_ITEM, 0);
        les.setInteraktivníObjekt(arc6);
        les.setInteraktivníObjekt(guard);

        Prostor pole = new Prostor("Поле","Поле смертельного сражения");
        Random rand = new Random();
        Entity boss = new Entity("босс", "Страшный монстр который который спрятался в одной из 6ти башен и каждый ход будет убивать 1 вашего лучника. Какую башню АТАКУЕМ первой? !", "Босс побежден! Вы победили! Поздравляем", null, null, CommandType.BOSS, rand.nextInt(7));
        pole.setInteraktivníObjekt(boss);
        // přiřazují se průchody mezi prostory (sousedící prostory)
        trh.setVychod(zakoulki);
        trh.setLock(zakoulki, donkey, "Осел преградил твой путь, к сожалению ты не пройдешь!");

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
        les.setLock(pole, guard, "Страж не пропустит никого, пока не услышит секретное слово!");
                
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
