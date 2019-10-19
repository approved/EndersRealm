package dev.odd.endersrealm.fluid;

import dev.odd.endersrealm.EndersRealm;
import dev.odd.endersrealm.block.EnderBlocks;
import dev.odd.endersrealm.item.EnderItems;
import dev.odd.endersrealm.tag.EnderTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.BaseFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Item;
import net.minecraft.state.StateFactory;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public abstract class EnderFluid extends WaterFluid {

    public static final BaseFluid FLOWING_VAIN;
    public static final BaseFluid VAIN;

    public Fluid getFlowing() {
        return FLOWING_VAIN;
     }
  
     public Fluid getStill() {
        return VAIN;
     }

    public Item getBucketItem() {
        return EnderItems.VAIN_BUCKET;
    }

    public BlockState toBlockState(FluidState fluidState) {
        return (BlockState)EnderBlocks.VAIN.getDefaultState().with(FluidBlock.LEVEL, method_15741(fluidState));
    }

    public boolean matchesType(Fluid fluid) {
        return fluid == VAIN || fluid == FLOWING_VAIN;
    }

    public boolean method_15777(FluidState fluidState, BlockView blockView, BlockPos blockPos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.matches(FluidTags.WATER);
    }

    public static class Flowing extends EnderFluid {
        protected void appendProperties(StateFactory.Builder<Fluid, FluidState> builder) {
           super.appendProperties(builder);
           builder.add(LEVEL);
        }
  
        public int getLevel(FluidState fluidState) {
           return (int)fluidState.get(LEVEL);
        }
  
        public boolean isStill(FluidState fluidState) {
           return false;
        }
     }
  
     public static class Still extends EnderFluid {
        public int getLevel(FluidState fluidState) {
           return 8;
        }
  
        public boolean isStill(FluidState fluidState) {
           return true;
        }
     }

     static {
        FLOWING_VAIN = Registry.register(Registry.FLUID, new Identifier(EndersRealm.ModId, "flowing_vain"), new Flowing());
        VAIN = Registry.register(Registry.FLUID, new Identifier(EndersRealm.ModId, "vain"), new Still());
     }
}