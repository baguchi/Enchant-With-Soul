package baguchi.enchant_with_soul.data.resources;

import baguchi.enchant_with_soul.EnchantWithSoul;
import baguchi.enchantwithmob.api.MobEnchantType;
import baguchi.enchantwithmob.data.resources.registries.MobEnchantTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

import java.util.Optional;

public class SoulMobEnchantTypes {
    public static final ResourceKey<MobEnchantType> SOUL = createKey("soul");

    private static ResourceKey<MobEnchantType> createKey(String name) {
        return ResourceKey.create(MobEnchantTypes.MOB_ENCHANT_TYPE_REGISTRY_KEY, Identifier.fromNamespaceAndPath(EnchantWithSoul.MODID, name));
    }

    public static void bootstrap(BootstrapContext<MobEnchantType> context) {

        context.register(SOUL, new MobEnchantType(
                Identifier.fromNamespaceAndPath(EnchantWithSoul.MODID, "textures/entity/soul_layer.png"),
                1.5F,
                Optional.of(ParticleTypes.SCULK_SOUL)
        ));
    }
}