
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
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.block.BlockState;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.block.BlockState;



import net.mcreator.demonicblessing.procedures.DiediCanditoOnEntityTickUpdateProcedure;
import net.mcreator.demonicblessing.procedures.DiediCanditoEntityDiesProcedure;
import net.mcreator.demonicblessing.itemgroup.DemonicBlessingItemGroup;
import net.mcreator.demonicblessing.entity.renderer.DiediCanditoRenderer;
import net.mcreator.demonicblessing.DemonicblessingModElements;  



import java.util.Map;
import java.util.HashMap;
import java.util.EnumSet;

@DemonicblessingModElements.ModElement.Tag
public class DiediCanditoEntity extends DemonicblessingModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
			.size(0.6f, 1.8f)).build("diedi_candito").setRegistryName("diedi_candito");
	public DiediCanditoEntity(DemonicblessingModElements instance) {
		super(instance, 75);
		FMLJavaModLoadingContext.get().getModEventBus().register(new DiediCanditoRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -52429, -3407719, new Item.Properties().group(DemonicBlessingItemGroup.tab))
				.setRegistryName("diedi_candito_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	private static class EntityAttributesRegisterHandler {
		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 1024);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 30);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 500);
			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1);
			ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0.3);
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
			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.TRIDENT));
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new Goal() {
				{
					this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
				}
				public boolean shouldExecute() {
					if (CustomEntity.this.getAttackTarget() != null && !CustomEntity.this.getMoveHelper().isUpdating()) {
						return true;
					} else {
						return false;
					}
				}

				@Override
				public boolean shouldContinueExecuting() {
					return CustomEntity.this.getMoveHelper().isUpdating() && CustomEntity.this.getAttackTarget() != null
							&& CustomEntity.this.getAttackTarget().isAlive();
				}

				@Override
				public void startExecuting() {
					LivingEntity livingentity = CustomEntity.this.getAttackTarget();
					Vector3d vec3d = livingentity.getEyePosition(1);
					CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 2);
				}

				@Override
				public void tick() {
					LivingEntity livingentity = CustomEntity.this.getAttackTarget();
					if (CustomEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
						CustomEntity.this.attackEntityAsMob(livingentity);
					} else {
						double d0 = CustomEntity.this.getDistanceSq(livingentity);
						if (d0 < 32) {
							Vector3d vec3d = livingentity.getEyePosition(1);
							CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 2);
						}
					}
				}
			});
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 2, false));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 0.8));
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, ArthasEntity.CustomEntity.class, false, false));
			this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, (float) 30));
			this.goalSelector.addGoal(8, new SwimGoal(this));
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
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
		    double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			Entity sourceentity = source.getTrueSource(); 
			
            if (source.getDamageType() == "qwe_resictansetypoutofworld")
                return false;
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source.isExplosion())        
			if (source == DamageSource.ANVIL)
				return false;
			if (sourceentity instanceof PlayerEntity) {
            sourceentity.attackEntityFrom(DamageSource.causeMobDamage(this).setDamageAllowedInCreativeMode(), 20);}
            if (source.getTrueSource() instanceof PlayerEntity) { 
				source.getTrueSource().attackEntityFrom(DamageSource.causeMobDamage(this).setDamageIsAbsolute(), 30);}    
			if (source.getTrueSource() instanceof PlayerEntity) { 
				source.getTrueSource().attackEntityFrom(DamageSource.OUT_OF_WORLD, 40);} 
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = source.getTrueSource();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				DiediCanditoEntityDiesProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				DiediCanditoOnEntityTickUpdateProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS);
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

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}
}
