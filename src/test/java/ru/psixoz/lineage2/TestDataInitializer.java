package ru.psixoz.lineage2;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import ru.psixoz.lineage2.model.ref.*;
import ru.psixoz.lineage2.model.template.CollectionBonus;
import ru.psixoz.lineage2.model.template.CollectionTemplate;
import ru.psixoz.lineage2.model.template.Item;
import ru.psixoz.lineage2.model.template.ItemTemplate;
import ru.psixoz.lineage2.port.out.ref.CollectionRepository;
import ru.psixoz.lineage2.usecase.common.CommandUseCase;

import static java.util.Arrays.asList;

@CommandUseCase
@RequiredArgsConstructor
public class TestDataInitializer implements ApplicationRunner {
    final CollectionRepository collectionRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Create enchantType
        EnchantType bonusEnchantType = new EnchantType("BONUS_ENCHANT", "Бонус от коллекции");
        EnchantType equipmentEnchantType = new EnchantType("EQUIPMENT_ENCHANT", "Заточка обмундирования");
        //Create enchant
        Enchant bonusReduceDamageMinusOneEnchant = new Enchant("DAMAGE_MINUS_1", "-1%", bonusEnchantType);
        Enchant bonusReduceDamageMinusFiveEnchant = new Enchant("DAMAGE_MINUS_5", "-5%", bonusEnchantType);
        Enchant bonusReducePhysicalCriticalDamageMinusTwentyEnchant = new Enchant("PHYSICAL_CRITICAL_DAMAGE_MINUS_20", "-20%", bonusEnchantType);

        Enchant zeroEnchant = new Enchant("ZERO", "0", equipmentEnchantType);
        Enchant plusOneEnchant = new Enchant("PLUS_ONE", "+1", equipmentEnchantType);
        Enchant plusNineEnchant = new Enchant("PLUS_NINE", "+9", equipmentEnchantType);

        //Create item type
        ItemType itemTypeMagic = new ItemType("MAGIC_ARMOR", "Магический доспех");
        ItemType itemTypeLight = new ItemType("LIGHT_ARMOR", "Легкий доспех");
        ItemType itemTypeHeavy = new ItemType("HEAVY_ARMOR", "Тяжелый доспех");

        //Reduce damage description
        BonusDescription reduceDamageDescription = new BonusDescription("REDUCE_DAMAGE", "Получаемый урон");
        BonusDescription reducePhysicalCriticalDamageDescription = new BonusDescription("REDUCE_PHYSICAL_CRITICAL_DAMAGE", "Получаемый урон от физ. крит. атак");

        Item item1 = new Item();
        item1.setName("Ботинки Синего Волка");
        Item item2 = new Item();
        item2.setName("Шлем Синего Волка");


        CollectionTemplate collectionTemplate = new CollectionTemplate();
        collectionTemplate.setCollectionType(CollectionType.WARRIOR);
        collectionTemplate.setName("Коллекция новичка");

        CollectionBonus bonus = new CollectionBonus();
        bonus.setEnchant(bonusReduceDamageMinusOneEnchant);
        bonus.setDescription(reduceDamageDescription);
        collectionTemplate.setCollectionBonus(bonus);

        ItemTemplate itemTemplate1 = new ItemTemplate();
        itemTemplate1.setItem(item1);
        itemTemplate1.setType(itemTypeMagic);
        itemTemplate1.setEnchant(zeroEnchant);

        ItemTemplate itemTemplate2 = new ItemTemplate();
        itemTemplate2.setItem(item1);
        itemTemplate2.setType(itemTypeLight);
        itemTemplate2.setEnchant(zeroEnchant);

        ItemTemplate itemTemplate3 = new ItemTemplate();
        itemTemplate3.setItem(item1);
        itemTemplate3.setType(itemTypeLight);
        itemTemplate3.setEnchant(plusOneEnchant);

        collectionTemplate.getItemsCollection().addItem(asList(itemTemplate1, itemTemplate2, itemTemplate3));

        collectionRepository.save(collectionTemplate);

        CollectionTemplate collectionTemplate1 = new CollectionTemplate();
        collectionTemplate1.setCollectionType(CollectionType.WARRIOR);
        collectionTemplate1.setName("Коллекция опытного воина");

        CollectionBonus bonus1 = new CollectionBonus();
        bonus1.setEnchant(bonusReduceDamageMinusFiveEnchant);
        bonus1.setDescription(reduceDamageDescription);
        collectionTemplate1.setCollectionBonus(bonus1);

        ItemTemplate itemTemplate4 = new ItemTemplate();
        itemTemplate4.setItem(item1);
        itemTemplate4.setType(itemTypeHeavy);
        itemTemplate4.setEnchant(plusOneEnchant);

        ItemTemplate itemTemplate5 = new ItemTemplate();
        itemTemplate5.setItem(item2);
        itemTemplate5.setType(itemTypeLight);
        itemTemplate5.setEnchant(plusNineEnchant);

        ItemTemplate itemTemplate6 = new ItemTemplate();
        itemTemplate6.setItem(item2);
        itemTemplate6.setType(itemTypeMagic);
        itemTemplate6.setEnchant(plusNineEnchant);

        collectionTemplate1.getItemsCollection().addItem(asList(itemTemplate4, itemTemplate5, itemTemplate6));

        collectionRepository.save(collectionTemplate1);


        CollectionTemplate collectionTemplate2 = new CollectionTemplate();
        collectionTemplate2.setCollectionType(CollectionType.COMMON);
        collectionTemplate2.setName("Коллекция жира");

        CollectionBonus bonus2 = new CollectionBonus();
        bonus2.setEnchant(bonusReducePhysicalCriticalDamageMinusTwentyEnchant);
        bonus2.setDescription(reducePhysicalCriticalDamageDescription);
        collectionTemplate2.setCollectionBonus(bonus2);

        collectionTemplate2.getItemsCollection().addItem(asList(itemTemplate1, itemTemplate2, itemTemplate3, itemTemplate4, itemTemplate5, itemTemplate6));

        collectionRepository.save(collectionTemplate2);

    }
}
