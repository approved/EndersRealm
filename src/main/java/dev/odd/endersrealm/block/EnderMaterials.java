package dev.odd.endersrealm.block;

import net.fabricmc.fabric.api.block.FabricMaterialBuilder;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;

public class EnderMaterials {
    public static final Material VAIN;
    public static final Material WIND_COLUMN;
    
    static {
        VAIN = new FabricMaterialBuilder(MaterialColor.PURPLE).allowsMovement().lightPassesThrough().destroyedByPiston().replaceable().liquid().notSolid().build();
        WIND_COLUMN = new FabricMaterialBuilder(MaterialColor.AIR).allowsMovement().lightPassesThrough().destroyedByPiston().replaceable().notSolid().build();
    }
}