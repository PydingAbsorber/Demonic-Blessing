
package net.mcreator.demonicblessing.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
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
import net.minecraft.entity.projectile.ArrowEntity;


import net.mcreator.demonicblessing.procedures.MiniPekkaOnEntityTickUpdateProcedure;
import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.entity.renderer.MiniPekkaRenderer;
import net.mcreator.demonicblessing.DemonicblessingModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@DemonicblessingModElements.ModElement.Tag
public class MiniPekkaEntity extends DemonicblessingModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
			.size(0.6f, 1.8f)).build("mini_pekka").setRegistryName("mini_pekka");

	public MiniPekkaEntity(DemonicblessingModElements instance) {
		super(instance, 277);
		FMLJavaModLoadingContext.get().getModEventBus().register(new MiniPekkaRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16777216, -16737844, new Item.Properties().group(DemonicBlessingItemGroup.tab))
				.setRegistryName("mini_pekka_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	private static class EntityAttributesRegisterHandler {
		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 2);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 400);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 100);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 10000);
			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 100);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 5);
			event.put(entity, ammma.create());
		}
	}

	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 6000;
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
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, ArthasEntity.CustomEntity.class, false, false));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 0.8));
			this.goalSelector.addGoal(5, new SwimGoal(this));
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
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:puncakes"));
		}

		@Override
        public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
            if(Math.random() < 0.2) 
            {
             return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:megatron"));
            } else return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));

        }

        @Override
        public net.minecraft.util.SoundEvent getDeathSound() {
            return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("demonicblessing:minipekkadies"));
        }

        @Override
        public boolean attackEntityFrom(DamageSource source, float amount) 
        {
            if (source.getImmediateSource() instanceof ArrowEntity)
            return false;
            if (source.getImmediateSource() instanceof AbstractArrowEntity)
            return false;
            if (source == DamageSource.FALL)
            return false;
            if (source.isExplosion())
            return false;
            if (source == DamageSource.LIGHTNING_BOLT)
            return false;
            if (source == DamageSource.OUT_OF_WORLD)
            return false;
            if (source == DamageSource.GENERIC)
            return false;
            if (source == DamageSource.DRAGON_BREATH) 
            return false;
            if (source == DamageSource.MAGIC)
                {
                 return this.attackEntityFrom(DamageSource.WITHER, (float) amount * 0.002F);
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

			MiniPekkaOnEntityTickUpdateProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
