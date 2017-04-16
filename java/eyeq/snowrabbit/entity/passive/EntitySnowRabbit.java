package eyeq.snowrabbit.entity.passive;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntitySnowRabbit extends EntityAnimal {
    public EntitySnowRabbit(World world) {
        super(world);
        this.setSize(0.3F, 0.3F);
        ((PathNavigateGround) this.getNavigator()).setAvoidSun(true);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, 0.3));
        this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 0.3));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3.0D);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        BlockPos pos = this.getPosition();
        if(this.world.getBlockState(pos).getBlock() == Blocks.SNOW_LAYER) {
            this.world.setBlockState(pos, Blocks.AIR.getDefaultState());
            this.heal(0.8F);
        }

        for(int x = -4; x < 9; ++x) {
            for(int y = -2; y < 1; ++y) {
                for(int z = -4; z < 9; ++z) {
                    if(this.world.getBlockState(pos.add(x, y, z)).getMaterial() == Material.LAVA) {
                        this.onDeath(DamageSource.ON_FIRE);
                        return;
                    }
                }
            }
        }
        if(this.isWet()) {
            this.onDeath(DamageSource.DROWN);
        }
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        this.setDead();
        this.world.setBlockState(this.getPosition(), Blocks.SNOW_LAYER.getDefaultState());
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }
}
