package dev.odd.endersrealm.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.IWorld;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class FlyBlock extends Block {
    public static final BooleanProperty LIT;

    public FlyBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(LIT, false));
    }

    @Override
    public void onScheduledTick(BlockState blockState, World world, BlockPos blockPos, Random rand) {
        if (blockState.get(LIT)) {
            WindColumnBlock.update(world, blockPos.up(), 1);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState blockState_1, Direction direction_1, BlockState blockState_2,
            IWorld iWorld_1, BlockPos blockPos_1, BlockPos blockPos_2) {
        if (direction_1 == Direction.UP && blockState_2.getBlock() == Blocks.AIR) {
            iWorld_1.getBlockTickScheduler().schedule(blockPos_1, this, getTickRate(iWorld_1));
        }

        return super.getStateForNeighborUpdate(blockState_1, direction_1, blockState_2, iWorld_1, blockPos_1,
                blockPos_2);
    }

    @Override
    public int getTickRate(ViewableWorld viewableWorld_1) {
        return 20;
    }

    @Override
    public void onBlockAdded(BlockState oBlockState, World world, BlockPos blockPos, BlockState nBlockState,
            boolean boolean_1) {
        world.getBlockTickScheduler().schedule(blockPos, this, this.getTickRate(world));
    }

    protected void appendProperties(StateFactory.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    static {
        LIT = RedstoneTorchBlock.LIT;
    }
}