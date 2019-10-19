package dev.odd.endersrealm.item;

import dev.odd.endersrealm.fluid.EnderFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;

public class EnderItems {
    public static final Item VAIN_BUCKET;
    
    static {
        VAIN_BUCKET = (Item)new BucketItem(EnderFluid.VAIN, new Item.Settings().group(ItemGroup.MISC).maxCount(1).recipeRemainder(Items.BUCKET));
    }
}