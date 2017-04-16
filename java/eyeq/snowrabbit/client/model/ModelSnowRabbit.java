package eyeq.snowrabbit.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSnowRabbit extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer leafRight;
    public ModelRenderer leafLeft;
    public ModelRenderer tail;
    public ModelRenderer eyeRight;
    public ModelRenderer eyeLeft;

    public ModelSnowRabbit() {
        body = new ModelRenderer(this, 0, 0);
        body.addBox(-4F, -4F, -5F, 8, 8, 10);
        body.setRotationPoint(0F, 20F, 0F);
        head = new ModelRenderer(this, 36, 0);
        head.addBox(-3.5F, -3.2F, -6.9F, 7, 7, 2);
        head.setRotationPoint(0F, 20F, 0F);

        leafRight = new ModelRenderer(this, -10, 21);
        leafRight.addBox(-2F, -0.5F, 0F, 4, 1, 10);
        leafRight.setRotationPoint(-3F, 16F, -2F);
        leafRight.rotateAngleX = 0.1F;
        leafRight.rotateAngleY = -0.2F;
        leafLeft = new ModelRenderer(this, -10, 21);
        leafLeft.addBox(-2F, -0.5F, 0F, 4, 1, 10);
        leafLeft.setRotationPoint(3F, 16F, -2F);
        leafLeft.rotateAngleX = 0.1F;
        leafLeft.rotateAngleY = 0.2F;

        tail = new ModelRenderer(this, 14, 0);
        tail.addBox(-1F, -1F, 0F, 2, 2, 1);
        tail.setRotationPoint(0F, 23F, 5F);

        eyeRight = new ModelRenderer(this, 0, 0);
        eyeRight.addBox(-1F, -1F, -1F, 2, 2, 1);
        eyeRight.setRotationPoint(-2F, 20F, -6.5F);
        eyeLeft = new ModelRenderer(this, 0, 0);
        eyeLeft.addBox(-1F, -1F, -1F, 2, 2, 1);
        eyeLeft.setRotationPoint(2F, 20F, -6.5F);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        body.render(scale);
        head.render(scale);
        leafRight.render(scale);
        leafLeft.render(scale);
        tail.render(scale);
        eyeRight.render(scale);
        eyeLeft.render(scale);
    }
}
