package com.owenjr.rebreathergoggles;

import com.owenjr.rebreathergoggles.item.RebreatherHelmetItem;
import com.owenjr.rebreathergoggles.registry.ModArmorMaterials;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(RebreatherGogglesMod.MODID)
public class RebreatherGogglesMod {
    public static final String MODID = "rebreathergoggles";

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredItem<RebreatherHelmetItem> REBREATHER_HELMET = ITEMS.register("rebreather_helmet",
            () -> new RebreatherHelmetItem(ModArmorMaterials.REBREATHER, new Item.Properties().durability(900)));

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> REBREATHER_GOGGLES_TAB = CREATIVE_MODE_TABS.register("rebreather_goggles_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.rebreathergoggles"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> REBREATHER_HELMET.get().getDefaultInstance())
                    .displayItems((parameters, output) -> output.accept(REBREATHER_HELMET.get()))
                    .build());

    public RebreatherGogglesMod(IEventBus modEventBus, ModContainer modContainer) {
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        ModArmorMaterials.ARMOR_MATERIALS.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(REBREATHER_HELMET);
        }
    }
}
