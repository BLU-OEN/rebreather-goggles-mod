package com.owenjr.rebreathergoggles.registry;

import com.owenjr.rebreathergoggles.RebreatherGogglesMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.Map;

public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, RebreatherGogglesMod.MODID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> REBREATHER = ARMOR_MATERIALS.register("rebreather",
            () -> new ArmorMaterial(
                    Map.of(ArmorItem.Type.HELMET, 2),
                    9,
                    SoundEvents.ARMOR_EQUIP_IRON,
                    () -> Ingredient.of(Items.GLASS_PANE),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RebreatherGogglesMod.MODID, "rebreather"))),
                    0.0F,
                    0.0F));
}
