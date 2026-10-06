package baguchi.enchant_with_soul.data;


import baguchi.enchant_with_soul.EnchantWithSoul;
import baguchi.enchant_with_soul.data.generator.CustomTagProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = EnchantWithSoul.MODID)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        event.createWorldRegistryObjects(RegistryDataGenerator.BUILDER);

        generator.addProvider(true, new CustomTagProvider.MobEnchantTypeTagGenerator(packOutput, event.getWorldLookupProvider()));
        generator.addProvider(true, new CustomTagProvider.MobEnchantTagGenerator(packOutput, event.getWorldLookupProvider()));
    }
}
