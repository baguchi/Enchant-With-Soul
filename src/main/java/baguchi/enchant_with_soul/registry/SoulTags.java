package baguchi.enchant_with_soul.registry;

import baguchi.enchant_with_soul.EnchantWithSoul;
import baguchi.enchantwithmob.mobenchant.MobEnchant;
import baguchi.enchantwithmob.registry.MobEnchants;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;

public class SoulTags {
    public static class MobEnchantTags {
        public static final TagKey<MobEnchant> RANDOM_SOUL_SPAWN = create("random_soul_spawn");

        private static TagKey<MobEnchant> create(String p_341202_) {
            return TagKey.create(MobEnchants.MOB_ENCHANT_REGISTRY, Identifier.fromNamespaceAndPath(EnchantWithSoul.MODID, p_341202_));
        }
    }
}
