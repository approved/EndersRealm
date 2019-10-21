package dev.odd.endersrealm.particle;

import dev.odd.endersrealm.EndersRealm;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnderParticles {
    public static final DefaultParticleType END_RUNES;

    private static DefaultParticleType register(Identifier identifier, boolean alwaysSpawn) {
      return Registry.register(Registry.PARTICLE_TYPE, identifier, FabricParticleTypes.simple(alwaysSpawn));
   }

    static {
        END_RUNES = register(new Identifier(EndersRealm.ModId, "end_runes"), false);
    }
}