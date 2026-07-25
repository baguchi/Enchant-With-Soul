package baguchi.enchant_with_soul;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class SoulConfig {
    public static final Common COMMON;
    public static final ModConfigSpec COMMON_SPEC;
    public static final Client CLIENT;
    public static final ModConfigSpec CLIENT_SPEC;

    static {
        Pair<Common, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
        Pair<Client, ModConfigSpec> specPair2 = new ModConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = specPair2.getRight();
        CLIENT = specPair2.getLeft();
    }

    public static class Client {

        public Client(ModConfigSpec.Builder builder) {
        }
    }

    public static class Common {
        public final ModConfigSpec.DoubleValue difficultyBasePercent;
        public final ModConfigSpec.DoubleValue effectiveBasePercent;

        public Common(ModConfigSpec.Builder builder) {
            difficultyBasePercent = builder
                    .comment("Set The Difficulty Base Soul Corrupted Mob Spawn Percent. [(Difficulty Base Percent * Difficulty id) + (Effective Difficulty Percent * Effective Difficulty)]")
                    .translation(EnchantWithSoul.MODID + ".config.DifficultyEnchantedSpawnPercent")
                    .defineInRange("Difficulty Enchanted Spawn Percent", 1D, 0.0D, 1D);
            effectiveBasePercent = builder
                    .comment("Set The Effective Difficulty Base Soul Corrupted Mob Spawn Percent [(Difficulty Base Percent * Difficulty id) + (Effective Difficulty Percent * Effective Difficulty)]")
                    .translation(EnchantWithSoul.MODID + ".config.EffectiveDifficultyEnchantedSpawnPercent")
                    .defineInRange("Effective Difficulty Enchanted Spawn Percent", 0.025D, 0.0D, 1D);
        }
    }

}