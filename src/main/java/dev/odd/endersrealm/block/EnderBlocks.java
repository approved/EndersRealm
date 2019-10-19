package dev.odd.endersrealm.block;

import dev.odd.endersrealm.EndersRealm;
import dev.odd.endersrealm.fluid.EnderFluid;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnderBlocks {
    public static final Block VAIN;
    public static final Block ENDER_DOMAIN;

    private static Block Register(String blockIdentifier, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(EndersRealm.ModId, blockIdentifier), block);
    }

    static {
        VAIN = Register("vain", new EnderFluidBlock(EnderFluid.VAIN, FabricBlockSettings.of(EnderMaterials.VAIN).strength(100.0F, 100.0F).lightLevel(1).dropsNothing().noCollision().build()));
        ENDER_DOMAIN = Register("ender_domain", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.PURPLE).strength(3.0F, 1200.0F).build()));
    }
}