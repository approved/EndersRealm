package dev.odd.endersrealm.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class EndRuneParticle extends SpriteBillboardParticle {

    protected EndRuneParticle(World world, double xPos, double yPos, double zPos, double xVelocity, double yVelocity, double zVelocity) {
        super(world, xPos, yPos, zPos);
        this.setBoundingBoxSpacing(0.02F, 0.02F);
        this.scale *= this.random.nextFloat() * 0.6F + 0.2F;
        this.velocityX = velocityX * 0.20000000298023224D + (Math.random() * 2.0D - 1.0D) * 0.019999999552965164D;
        this.velocityY = velocityY * 0.20000000298023224D + (Math.random() * 2.0D - 1.0D) * 0.019999999552965164D;
        this.velocityZ = velocityZ * 0.20000000298023224D + (Math.random() * 2.0D - 1.0D) * 0.019999999552965164D;
        this.maxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
    }

    @Override
    public void tick() {
      this.prevPosX = this.x;
      this.prevPosY = this.y;
      this.prevPosZ = this.z;
      if (this.maxAge-- <= 0) {
         this.markDead();
      } else {
         this.velocityY += 0.002D;
         this.move(this.velocityX, this.velocityY, this.velocityZ);
         this.velocityX *= 0.8500000238418579D;
         this.velocityY *= 0.8500000238418579D;
         this.velocityZ *= 0.8500000238418579D;
         if (!this.world.isAir(new BlockPos(this.x, this.y, this.z))) {
            this.markDead();
         }

      }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprite;

        public Factory(SpriteProvider spriteProvider_1) {
            this.sprite = spriteProvider_1;
        }

        public Particle method_3012(DefaultParticleType type, World world, double xPos, double yPos, double zPos, double xVelocity, double yVelocity, double zVelocity) {
            EndRuneParticle endRuneParticle = new EndRuneParticle(world, xPos, yPos, zPos, xVelocity, yVelocity, zVelocity);
            endRuneParticle.setSprite(this.sprite);
            return endRuneParticle;
        }

        @Override
        public Particle createParticle(DefaultParticleType type, World world, double xPos, double yPos, double zPos,
                double xVelocity, double yVelocity, double zVelocity) {
                    return new EndRuneParticle(world, xPos, yPos, zPos, xVelocity, yVelocity, zVelocity);
        }
    }
}