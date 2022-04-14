
package net.mcreator.demonicblessing.entity;

import net.mcreator.demonicblessing.item.BrokenFrostMourneItem;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;

import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.entity.renderer.ArthasRenderer;
import net.mcreator.demonicblessing.DemonicblessingModElements;

import javax.annotation.Nullable;

@DemonicblessingModElements.ModElement.Tag
public class ArthasEntity extends DemonicblessingModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
			.size(0.6f, 1.8f)).build("arthas").setRegistryName("arthas");
	public ArthasEntity(DemonicblessingModElements instance) {
		super(instance, 133);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ArthasRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16737895, -16764109, new Item.Properties().group(DemonicBlessingItemGroup.tab))
				.setRegistryName("arthas_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	private static class EntityAttributesRegisterHandler {
		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 1);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 5000);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 100);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 5000);
			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1);
			event.put(entity, ammma.create());
		}
	}

	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}


		@Nullable
		@Override
		public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
//			this.getPersistentData().putDouble("posx", this.getPosX());
//			this.getPersistentData().putDouble("posy", this.getPosY());
//			this.getPersistentData().putDouble("posz", this.getPosZ());
//			this.setHomePosAndDistance(this.getPosition(), 10);
			return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getTrueSource() instanceof PlayerEntity) {
				source.getTrueSource().attackEntityFrom(DamageSource.causeMobDamage(this).setDamageIsAbsolute(), amount+7000);
			}
			  if (source.getDamageType() == "qwe_resictansetypoutofworld")
                return false;
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source.getImmediateSource() instanceof AbstractArrowEntity)
		    return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			if (source.isExplosion())
				return false;
			if (source.getDamageType().equals("trident"))
				return false;
			if (source == DamageSource.ANVIL)
				return false;
			if (source == DamageSource.DRAGON_BREATH)
				return false;
			if (source == DamageSource.WITHER)
				return false;
			if (source.getDamageType().equals("witherSkull"))
				return false;
			if (source == DamageSource.OUT_OF_WORLD || source.isDamageAbsolute()) {
				return false;
			}
			return super.attackEntityFrom(source, amount);
		}
		@Override
		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(BrokenFrostMourneItem.block));
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double teperx = this.getPosX();
			double tepery = this.getPosY();
			double teperz = this.getPosZ();
			Double x = this.getPersistentData().getDouble("posx");
			Double y = this.getPersistentData().getDouble("posy");
			Double z = this.getPersistentData().getDouble("posz");
			this.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 60, 3));
			this.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 60, 9));
			this.addPotionEffect(new EffectInstance(Effects.REGENERATION, 60, 9));
			this.addPotionEffect(new EffectInstance(Effects.STRENGTH, 60, 9));
			this.addPotionEffect(new EffectInstance(Effects.GLOWING, 60, 0));
//			if (this.isWithinHomeDistanceCurrentPosition() != true) {
//				this.setHealth(1000.0F);
//				this.setPosition(x,y,z);
//				if (this.getLastAttackedEntity() instanceof ServerPlayerEntity) {
//					this.removeTrackingPlayer((ServerPlayerEntity) this.getLastAttackedEntity());
//				}
//			}
		}

		@Override
		public void awardKillScore(Entity killed, int scoreValue, DamageSource damageSource) {
			super.awardKillScore(killed, scoreValue, damageSource);
			this.setHealth(this.getHealth()+300F);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS);
		@Override
		public void addTrackingPlayer(ServerPlayerEntity player) {
			super.addTrackingPlayer(player);
//			Double x = this.getPersistentData().getDouble("posx");
//			Double y = this.getPersistentData().getDouble("posy");
//			Double z = this.getPersistentData().getDouble("posz");
//			this.setPosition(x,y,z);
//			this.setHomePosAndDistance(this.getPosition(), 10);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(ServerPlayerEntity player) {
			super.removeTrackingPlayer(player);
//			Double x = this.getPersistentData().getDouble("posx");
//			Double y = this.getPersistentData().getDouble("posy");
//			Double z = this.getPersistentData().getDouble("posz");
//			this.setPosition(x,y,z);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void updateAITasks() {
			super.updateAITasks();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}
}
