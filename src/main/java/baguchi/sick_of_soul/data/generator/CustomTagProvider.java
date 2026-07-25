package baguchi.sick_of_soul.data.generator;

import baguchi.enchantwithmob.api.MobEnchantType;
import baguchi.enchantwithmob.data.resources.registries.MobEnchantTypes;
import baguchi.enchantwithmob.registry.ModTags;
import baguchi.sick_of_soul.SickOfSoul;
import baguchi.sick_of_soul.data.resources.SoulMobEnchantTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;

import java.util.concurrent.CompletableFuture;

public class CustomTagProvider {

    public static class MobEnchantTypeTagGenerator extends TagsProvider<MobEnchantType> {

        public MobEnchantTypeTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
            super(output, MobEnchantTypes.MOB_ENCHANT_TYPE_REGISTRY_KEY, provider, SickOfSoul.MODID);
        }

        @Override
        protected void addTags(HolderLookup.Provider p_256380_) {
            this.tag(ModTags.MobEnchantTypeTags.PREVENT_REMOVE_SELF).add(SoulMobEnchantTypes.SOUL);
        }
    }
}