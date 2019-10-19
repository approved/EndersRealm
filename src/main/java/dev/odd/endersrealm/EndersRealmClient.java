package dev.odd.endersrealm;

import dev.odd.endersrealm.block.EnderBlocks;
import dev.odd.endersrealm.fluid.EnderFluid;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ExtendedBlockView;

public class EndersRealmClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FluidRenderHandler vainRenderHandler = new FluidRenderHandler(){
        
            @Override
            public Sprite[] getFluidSprites(ExtendedBlockView view, BlockPos pos, FluidState state) {
                return new Sprite[] {
                    MinecraftClient.getInstance().getBakedModelManager().getBlockStateMaps().getModel(Blocks.WATER.getDefaultState()).getSprite(),
                    MinecraftClient.getInstance().getSpriteAtlas().getSprite(ModelLoader.WATER_FLOW)
                };
            }

            @Override
            public int getFluidColor(ExtendedBlockView view, BlockPos pos, FluidState state) {
                return 0x683C95;
            }
        };

        FluidRenderHandlerRegistry.INSTANCE.register(EnderFluid.VAIN, vainRenderHandler);
        FluidRenderHandlerRegistry.INSTANCE.register(EnderFluid.FLOWING_VAIN, vainRenderHandler);

        ColorProviderRegistry.BLOCK.register((blockState, blockView, pos, layer) -> {
            return 0xFF683C95;
        }, EnderBlocks.ENDER_DOMAIN);

        System.out.println("EndersRealm Client Side Initialized");
    }

}