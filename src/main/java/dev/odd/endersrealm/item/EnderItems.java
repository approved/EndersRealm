package dev.odd.endersrealm.item;

import dev.odd.endersrealm.block.EnderBlocks;
import dev.odd.endersrealm.fluid.EnderFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;

public class EnderItems {
    public static final Item VAIN_BUCKET;
    public static final Item ENDER_DOMAIN;
    public static final Item FLY_BLOCK;
    
    static {
        ENDER_DOMAIN = new BlockItem(EnderBlocks.ENDER_DOMAIN, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
        FLY_BLOCK = new BlockItem(EnderBlocks.FLY_BLOCK, new Item.Settings().group(ItemGroup.REDSTONE));
        VAIN_BUCKET = (Item)new BucketItem(EnderFluid.VAIN, new Item.Settings().group(ItemGroup.MISC).maxCount(1).recipeRemainder(Items.BUCKET));
    }
}