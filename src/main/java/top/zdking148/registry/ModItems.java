package top.zdking148.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import top.zdking148.TutorialMod;

public class ModItems {
    public static final Item CITRINE = registryItem("citrine",
            new Item(new FabricItemSettings()));
    public static final Item RAW_CITRINE = registryItem("raw_citrine",
            new Item(new FabricItemSettings()));
    public static Item registryItem(String name, Item item, ItemGroup...itemGroups){
        Item registeredItem = Registry.register(Registries.ITEM,new Identifier(TutorialMod.MOD_ID,name),item);
        for(ItemGroup itemGroup:itemGroups){
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(registeredItem) );
        }
        return registeredItem;
    }
    public static void registerModItem(){
        TutorialMod.LOGGER.debug("Registering mod items for"+ TutorialMod.MOD_ID);
    }
}
