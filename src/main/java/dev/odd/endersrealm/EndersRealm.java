package dev.odd.endersrealm;

import dev.odd.endersrealm.fluid.EnderFluid;
import dev.odd.endersrealm.item.EnderItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.ExtendedBlockView;

public class EndersRealm implements ModInitializer {

    public static final String ModId = "endersrealm";

    @Override
    public void onInitialize() {
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

        Registry.register(Registry.ITEM, new Identifier(ModId, "vain_bucket"), EnderItems.VAIN_BUCKET);

        FluidRenderHandlerRegistry.INSTANCE.register(EnderFluid.VAIN, vainRenderHandler);
        FluidRenderHandlerRegistry.INSTANCE.register(EnderFluid.FLOWING_VAIN, vainRenderHandler);
    }

}