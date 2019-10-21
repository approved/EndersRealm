package dev.odd.endersrealm.block;

import java.util.Random;

import dev.odd.endersrealm.particle.EnderParticles;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateFactory.Builder;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.ViewableWorld;
import net.minecraft.world.World;

public class WindColumnBlock extends Block {

    public static final IntProperty HEIGHT;

    public WindColumnBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateFactory.getDefaultState().with(HEIGHT, 1));
    }

    @Override
    public void onEntityCollision(BlockState blockState_1, World world_1, BlockPos blockPos_1, Entity entity_1) {
        if(!world_1.getBlockState(blockPos_1.up()).isAir()) {
            entity_1.onBubbleColumnCollision(false);
        }
    }

    @Override
    public void onBlockAdded(BlockState oldBlockState, World world, BlockPos blockPos, BlockState newBlockState,
            boolean bool) {
        update(world, blockPos.up(), oldBlockState.get(HEIGHT) + 1);
    }

    @Override
    public void onScheduledTick(BlockState blockState, World world, BlockPos blockPos, Random rand) {
        update(world, blockPos.up(), blockState.get(HEIGHT) + 1);
    }

    public static void update(IWorld world, BlockPos blockPos, int height) {
        if (world.isAir(blockPos) && height <= 20) {
            world.setBlockState(blockPos, EnderBlocks.WIND_COLUMN.getDefaultState().with(HEIGHT, height), 2);
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState blockState, World world, BlockPos blockPos, Random rand) {
        double xPos = (double) blockPos.getX();
        double yPos = (double) blockPos.getY();
        double zPos = (double) blockPos.getZ();

        world.addImportantParticle(EnderParticles.END_RUNES, xPos + 0.5D, yPos, zPos + 0.5D, 0.0D, 0.04D, 0.0D);
        world.addImportantParticle(EnderParticles.END_RUNES, xPos + (double) rand.nextFloat(),
                yPos + (double) rand.nextFloat(), zPos + (double) rand.nextFloat(), 0.0D, 0.04D, 0.0D);
        if (rand.nextInt(200) == 0) {
            world.playSound(xPos, yPos, zPos, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, SoundCategory.BLOCKS,
                    0.2F + rand.nextFloat() * 0.2F, 0.9F + rand.nextFloat() * 0.15F, false);
        }
    }

    @Override
    public int getTickRate(ViewableWorld viewableWorld_1) {
        return 5;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState blockState_1, Direction direction_1, BlockState blockState_2,
            IWorld iWorld_1, BlockPos blockPos_1, BlockPos blockPos_2) {

        if (!blockState_1.canPlaceAt(iWorld_1, blockPos_1)) {
            return Blocks.AIR.getDefaultState();
        }

        return super.getStateForNeighborUpdate(blockState_1, direction_1, blockState_2, iWorld_1, blockPos_1,
                blockPos_2);
    }

    @Override
    public boolean canPlaceAt(BlockState blockState, ViewableWorld viewableWorld, BlockPos blockPos) {
        BlockState lBlockState = viewableWorld.getBlockState(blockPos.down());
        Block block = lBlockState.getBlock();
        return blockState.get(HEIGHT) <= 20 && (block == EnderBlocks.WIND_COLUMN
                || (block == EnderBlocks.FLY_BLOCK && lBlockState.get(FlyBlock.LIT)));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1,
            EntityContext entityContext_1) {
        return VoxelShapes.empty();
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState_1) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> stateFactory) {
        stateFactory.add(HEIGHT);
    }

    static {
        HEIGHT = IntProperty.of("height", 1, 20);
    }
}