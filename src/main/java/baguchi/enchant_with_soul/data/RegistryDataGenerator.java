package baguchi.enchant_with_soul.data;

import baguchi.enchant_with_soul.data.resources.SoulMobEnchantTypes;
import baguchi.enchantwithmob.data.resources.registries.MobEnchantTypes;
import net.minecraft.core.RegistrySetBuilder;

public class RegistryDataGenerator {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(MobEnchantTypes.MOB_ENCHANT_TYPE_REGISTRY_KEY, SoulMobEnchantTypes::bootstrap);

}