package baguchi.enchant_with_soul.data.generator;

import baguchi.enchant_with_soul.EnchantWithSoul;
import baguchi.enchant_with_soul.data.resources.SoulMobEnchantTypes;
import baguchi.enchant_with_soul.registry.SoulTags;
import baguchi.enchantwithmob.api.MobEnchantType;
import baguchi.enchantwithmob.data.resources.registries.MobEnchantTypes;
import baguchi.enchantwithmob.mobenchant.MobEnchant;
import baguchi.enchantwithmob.registry.MobEnchants;
import baguchi.enchantwithmob.registry.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class CustomTagProvider {

    public static class MobEnchantTypeTagGenerator extends TagsProvider<MobEnchantType> {

        public MobEnchantTypeTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper existingFileHelper) {
            super(output, MobEnchantTypes.MOB_ENCHANT_TYPE_REGISTRY_KEY, provider, EnchantWithSoul.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider p_256380_) {
            this.tag(ModTags.MobEnchantTypeTags.PREVENT_REMOVE_SELF).add(SoulMobEnchantTypes.SOUL);
        }
    }

    public static class MobEnchantTagGenerator extends TagsProvider<MobEnchant> {

        public MobEnchantTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper existingFileHelper) {
            super(output, MobEnchants.MOB_ENCHANT_REGISTRY, provider, EnchantWithSoul.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider p_256380_) {
            this.tag(SoulTags.MobEnchantTags.RANDOM_SOUL_SPAWN).add(MobEnchants.MULTISHOT.getKey())
                    .add(MobEnchants.POISON.getKey()).add(MobEnchants.POISON_CLOUD.getKey())
                    .add(MobEnchants.STRONG.getKey());
        }
    }
}