package dev.odd.endersrealm.block;

import dev.odd.endersrealm.fluid.EnderFluid;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;

public class EnderBlocks {
    public static final Block VAIN;
    static {
        VAIN = new EnderFluidBlock(EnderFluid.VAIN, FabricBlockSettings.of(EnderMaterials.VAIN).strength(100.0F, 100.0F).lightLevel(1).dropsNothing().noCollision().build());
    }
}