package dev.odd.endersrealm.block;

import net.fabricmc.fabric.api.block.FabricMaterialBuilder;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;

public class EnderMaterials {
    public static final Material VAIN;
    
    static {
        VAIN = new FabricMaterialBuilder(MaterialColor.PURPLE).allowsMovement().lightPassesThrough().destroyedByPiston().replaceable().liquid().notSolid().build();
    }
}