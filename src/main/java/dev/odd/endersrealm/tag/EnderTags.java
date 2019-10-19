package dev.odd.endersrealm.tag;

import dev.odd.endersrealm.EndersRealm;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.FluidTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class EnderTags {
    public static final Tag<Fluid> VAIN;
    
    static {
        VAIN = new FluidTags.CachingTag(new Identifier(EndersRealm.ModId, "vain"));
    }
}