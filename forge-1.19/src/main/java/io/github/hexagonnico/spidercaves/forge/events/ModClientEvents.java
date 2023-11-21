package io.github.hexagonnico.spidercaves.forge.events;

import io.github.hexagonnico.spidercaves.RegistryManager;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Client events running on the mod event bus.
 *
 * @author Nico
 */
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = RegistryManager.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

    /**
     * Adds mod items to creative tabs.
     *
     * @param event Creative tab event
     */
    @SubscribeEvent
    public static void creativeTabEvent(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab().equals(CreativeModeTabs.COMBAT)) {
            event.accept(RegistryManager.SPIDER_HELMET);
            event.accept(RegistryManager.SPIDER_CHESTPLATE);
            event.accept(RegistryManager.SPIDER_LEGGINGS);
            event.accept(RegistryManager.SPIDER_BOOTS);
        } else if(event.getTab().equals(CreativeModeTabs.INGREDIENTS)) {
            event.accept(RegistryManager.SPIDER_FANG);
        } else if(event.getTab().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            event.accept(RegistryManager.WEB_COVERED_CHEST);
        }
    }

    /**
     * Registers entity and block entity renderers.
     *
     * @param event Register renderers event
     */
    @SubscribeEvent
    public static void registerRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(RegistryManager.WEB_COVERED_CHEST_ENTITY.get(), ChestRenderer::new);
    }
}
