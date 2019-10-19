package dev.odd.endersrealm.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.Block.Settings;

@Mixin(Settings.class)
public interface BlockSettingsInvoker {

    @Invoker(value = "strength")
    public Settings setStrength(float strength);

    @Invoker(value = "lightLevel")
    public Settings setLightLevel(int level);

    @Invoker(value = "dropsNothing")
    public Settings doDropNothing();
}