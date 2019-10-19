package dev.odd.endersrealm;

import dev.odd.endersrealm.block.EnderBlocks;
import dev.odd.endersrealm.item.EnderItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EndersRealm implements ModInitializer {

    public static final String ModId = "endersrealm";

    @Override
    public void onInitialize() {

        Registry.register(Registry.ITEM, new Identifier(ModId, "ender_domain"), new BlockItem(EnderBlocks.ENDER_DOMAIN, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(ModId, "vain_bucket"), EnderItems.VAIN_BUCKET);
    }

}