package dev.odd.endersrealm;

import dev.odd.endersrealm.item.EnderItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EndersRealm implements ModInitializer {

    public static final String ModId = "endersrealm";

    @Override
    public void onInitialize() {

        Registry.register(Registry.ITEM, new Identifier(ModId, "ender_domain"), EnderItems.ENDER_DOMAIN);
        Registry.register(Registry.ITEM, new Identifier(ModId, "fly_block"), EnderItems.FLY_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ModId, "vain_bucket"), EnderItems.VAIN_BUCKET);
    }

}