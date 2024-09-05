package com.hitchsavan.beeers;

import java.util.ArrayList;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(BeeersMod.MOD_ID, id);

        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        return registeredItem;
    }

    public static final Item BEER_EXAMPLE = register(
        new Item(new Item.Settings().food(
            new FoodComponent(2, 1, false, 1, new ArrayList<FoodComponent.StatusEffectEntry>()))), "base_beer");

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(BEER_EXAMPLE));
    }
}
