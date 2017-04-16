package eyeq.snowrabbit.client.renderer.entity;

import eyeq.snowrabbit.client.model.ModelSnowRabbit;
import eyeq.util.client.renderer.EntityRenderResourceLocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import static eyeq.snowrabbit.SnowRabbit.MOD_ID;

public class RenderSnowRabbit extends RenderLiving {
    protected static final ResourceLocation textures = new EntityRenderResourceLocation(MOD_ID, "snow_rabbit");

    private static float scale = 0.5F;

    public RenderSnowRabbit(RenderManager renderManager) {
        super(renderManager, new ModelSnowRabbit(), 0.3F);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return textures;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTickTime) {
        GlStateManager.scale(this.scale, this.scale, this.scale);
    }
}
