package baguchi.enchant_with_soul;

import baguchi.enchant_with_soul.data.resources.SoulMobEnchantTypes;
import baguchi.enchant_with_soul.registry.SoulTags;
import baguchi.enchantwithmob.EnchantConfig;
import baguchi.enchantwithmob.api.IEnchantCap;
import baguchi.enchantwithmob.utils.MobEnchantUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = EnchantWithSoul.MODID)
public class CommonEventHandler {
    /*
     * handle the Normal Entity Mob Enchant
     */
    @SubscribeEvent
    public static void onSpawnEntity(FinalizeSpawnEvent event) {
        if (event.getEntity() instanceof IEnchantCap cap) {
            LevelAccessor world = event.getLevel();
            if (!world.isClientSide() && world instanceof ServerLevel serverLevel) {
                LivingEntity livingEntity = event.getEntity();
                float difficultScale = serverLevel.getCurrentDifficultyAt(livingEntity.blockPosition()).getEffectiveDifficulty() - 0.2F;
                float difficultScaleOnPercent = serverLevel.getCurrentDifficultyAt(livingEntity.blockPosition()).getEffectiveDifficulty();


                if (!cap.getEnchantCap().hasEnchant() && EnchantConfig.COMMON.naturalSpawnEnchantedMob.get() && isSpawnEnchantableEntity(event.getEntity())) {

                    if (!(livingEntity instanceof Animal) && !(livingEntity instanceof WaterAnimal) || EnchantConfig.COMMON.spawnEnchantedAnimal.get()) {
                        if (event.getSpawnType() != MobSpawnType.BREEDING && event.getSpawnType() != MobSpawnType.CONVERSION && event.getSpawnType() != MobSpawnType.STRUCTURE && event.getSpawnType() != MobSpawnType.MOB_SUMMONED && event.getSpawnType() != MobSpawnType.SPAWNER && event.getSpawnType() != MobSpawnType.EVENT) {
                            if (world.getRandom().nextFloat() < (SoulConfig.COMMON.difficultyBasePercent.get() * world.getDifficulty().getId()) + difficultScaleOnPercent * SoulConfig.COMMON.effectiveBasePercent.get()) {
                                if (!world.isClientSide()) {
                                    int i = 0;
                                    float scale = 1F;
                                    switch (world.getDifficulty()) {
                                        case EASY:
                                            i = (int) Mth.clamp((5 + world.getRandom().nextInt(5)) * difficultScale * scale, 1, 20);
                                            MobEnchantUtils.addRandomEnchantmentToEntity(livingEntity, cap, world.getRandom(), i, SoulTags.MobEnchantTags.RANDOM_SOUL_SPAWN);
                                            cap.getEnchantCap().setEnchantType(livingEntity, SoulMobEnchantTypes.SOUL);
                                            break;
                                        case NORMAL:
                                            i = (int) Mth.clamp((5 + world.getRandom().nextInt(5)) * difficultScale * scale, 1, 40);

                                            MobEnchantUtils.addRandomEnchantmentToEntity(livingEntity, cap, world.getRandom(), i, SoulTags.MobEnchantTags.RANDOM_SOUL_SPAWN);
                                            cap.getEnchantCap().setEnchantType(livingEntity, SoulMobEnchantTypes.SOUL);
                                            break;
                                        case HARD:
                                            i = (int) Mth.clamp((5 + world.getRandom().nextInt(10)) * difficultScale * scale, 1, 50);

                                            MobEnchantUtils.addRandomEnchantmentToEntity(livingEntity, cap, world.getRandom(), i, SoulTags.MobEnchantTags.RANDOM_SOUL_SPAWN);
                                            cap.getEnchantCap().setEnchantType(livingEntity, SoulMobEnchantTypes.SOUL);
                                            break;
                                    }

                                    livingEntity.setHealth(livingEntity.getMaxHealth());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean isSpawnEnchantableEntity(Entity entity) {
        return !(entity instanceof Player) && !(entity instanceof ArmorStand) && !(entity instanceof Boat) && !(entity instanceof Minecart) && !EnchantConfig.COMMON.ENCHANT_ON_SPAWN_EXCLUSION_MOBS.get().contains(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString());
    }

    @SubscribeEvent
    public static void onEntityIncomingDamage(LivingIncomingDamageEvent event) {
        LivingEntity livingEntity = event.getEntity();

        if (event.getEntity() instanceof IEnchantCap cap) {

            if (cap.getEnchantCap().hasEnchant() && cap.getEnchantCap().getMobEnchantType().is(SoulMobEnchantTypes.SOUL)) {
                event.setAmount(event.getAmount() / 3);
            }
        }

    }

}
