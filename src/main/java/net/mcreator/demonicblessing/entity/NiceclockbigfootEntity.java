
package net.mcreator.demonicblessing.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.block.BlockState;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;


import net.mcreator.demonicblessing.procedures.NiceclockbigfootOnEntityTickUpdateProcedure;
import net.mcreator.demonicblessing.procedures.NiceclockbigfootEntityIsHurtProcedure;
import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.entity.renderer.NiceclockbigfootRenderer;
import net.mcreator.demonicblessing.DemonicblessingModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.AbstractMap;

@DemonicblessingModElements.ModElement.Tag
public class NiceclockbigfootEntity extends DemonicblessingModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
			.size(1f, 4f)).build("niceclockbigfoot").setRegistryName("niceclockbigfoot");

	public NiceclockbigfootEntity(DemonicblessingModElements instance) {
		super(instance, 275);
		FMLJavaModLoadingContext.get().getModEventBus().register(new NiceclockbigfootRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -13421773, -16764109, new Item.Properties().group(DemonicBlessingItemGroup.tab))
				.setRegistryName("niceclockbigfoot_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	private static class EntityAttributesRegisterHandler {
		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 500);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 100);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 5000);
			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 100);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 2);
			event.put(entity, ammma.create());
		}
	}

	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 550;
			setNoAI(false);
			setCustomName(new StringTextComponent("NiceClockBigFoot"));
			setCustomNameVisible(true);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.8, false));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 0.6));
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
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound(
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:robotwalking")),
					0.15f, 1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
		   if(Math.random() < 0.2) 
		    {
		    	 if(Math.random() < 0.5) 
		    	 { 
			        return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:robotattack1"));
			     }  else return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:robotattack2"));

		    } else return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:robotdies"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
		if (source.getImmediateSource() instanceof PlayerEntity)
		return false;
		if (source.getImmediateSource() instanceof PotionEntity)
		return false;
		if (source.getImmediateSource() instanceof ArrowEntity)
		return false;
		if (source.getImmediateSource() instanceof AbstractArrowEntity)
		return false;
		if (source == DamageSource.FALL)
		return false;
		if (source == DamageSource.CACTUS)
		return false;
		if (source == DamageSource.DROWN)
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
		if (source == DamageSource.OUT_OF_WORLD)
		return false;
		if (source == DamageSource.GENERIC)
		return false;
		if (source == DamageSource.LIGHTNING_BOLT)
		{
		return this.attackEntityFrom(DamageSource.MAGIC, (float) amount * 0.02F);
		}
		return super.attackEntityFrom(source, amount);
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;

			NiceclockbigfootOnEntityTickUpdateProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}

		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS);

		@Override
		public void addTrackingPlayer(ServerPlayerEntity player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(ServerPlayerEntity player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void updateAITasks() {
			super.updateAITasks();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}
}
