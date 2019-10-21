package dev.odd.endersrealm.block;

import dev.odd.endersrealm.EndersRealm;
import dev.odd.endersrealm.fluid.EnderFluid;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnderBlocks {
    public static final Block VAIN;
    public static final Block ENDER_DOMAIN;
    public static final Block FLY_BLOCK;
    public static final Block WIND_COLUMN;

    private static Block register(String blockIdentifier, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(EndersRealm.ModId, blockIdentifier), block);
    }

    static {
        VAIN = register("vain", new EnderFluidBlock(EnderFluid.VAIN, FabricBlockSettings.of(EnderMaterials.VAIN).strength(100.0F, 100.0F).lightLevel(1).dropsNothing().noCollision().build()));
        ENDER_DOMAIN = register("ender_domain", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.PURPLE).strength(3.0F, 1200.0F).build()));
        FLY_BLOCK = register("fly_block", new FlyBlock(FabricBlockSettings.of(Material.STONE).strength(1.0F, 1.0F).sounds(BlockSoundGroup.ANVIL).build()));
        WIND_COLUMN = register("wind_column", new WindColumnBlock(FabricBlockSettings.of(EnderMaterials.WIND_COLUMN).noCollision().dropsNothing().build()));
    }
}