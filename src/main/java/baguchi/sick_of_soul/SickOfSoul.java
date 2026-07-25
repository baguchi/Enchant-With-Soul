package baguchi.sick_of_soul;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(SickOfSoul.MODID)
public class SickOfSoul {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "enchant_with_soul";

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public SickOfSoul(IEventBus modEventBus, Dist dist, ModContainer modContainer) {
        // Register the commonSetup method for modloading

        if (dist.isClient()) {
            modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        }

        modEventBus.addListener(this::commonSetup);

        modContainer.registerConfig(ModConfig.Type.COMMON, SoulConfig.COMMON_SPEC);
        modContainer.registerConfig(ModConfig.Type.CLIENT, SoulConfig.CLIENT_SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

}
