package baguchi.sick_of_soul.data;

import baguchi.enchantwithmob.data.resources.registries.MobEnchantTypes;
import baguchi.sick_of_soul.SickOfSoul;
import baguchi.sick_of_soul.data.resources.SoulMobEnchantTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RegistryDataGenerator extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(MobEnchantTypes.MOB_ENCHANT_TYPE_REGISTRY_KEY, SoulMobEnchantTypes::bootstrap);


    public RegistryDataGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of("minecraft", SickOfSoul.MODID));
    }


}