package eyeq.snowrabbit;

import eyeq.util.client.renderer.ResourceLocationFactory;
import eyeq.util.client.resource.ULanguageCreator;
import eyeq.util.client.resource.lang.LanguageResourceManager;
import eyeq.util.common.registry.UEntityRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import eyeq.snowrabbit.entity.passive.EntitySnowRabbit;
import eyeq.snowrabbit.client.renderer.entity.RenderSnowRabbit;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;

import static eyeq.snowrabbit.SnowRabbit.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
public class SnowRabbit {
    public static final String MOD_ID = "eyeq_snowrabbit";

    @Mod.Instance(MOD_ID)
    protected static SnowRabbit instance;

    private static final ResourceLocationFactory resource = new ResourceLocationFactory(MOD_ID);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        registerEntities();
        if(event.getSide().isServer()) {
            return;
        }
        registerEntityRenderings();
        createFiles();
    }

    public static void registerEntities() {
        UEntityRegistry.registerModEntity(resource, EntitySnowRabbit.class, "SnowRabbit", 0, instance, 0xE3F3F3, 0xFF0202);
        EntityRegistry.addSpawn(EntitySnowRabbit.class, 10, 1, 1, EnumCreatureType.CREATURE, Biomes.ICE_PLAINS, Biomes.ICE_MOUNTAINS, Biomes.COLD_BEACH);
    }

    @SideOnly(Side.CLIENT)
    public static void registerEntityRenderings() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySnowRabbit.class, RenderSnowRabbit::new);
    }

    public static void createFiles() {
        File project = new File("../1.11.2-SnowRabbit");

        LanguageResourceManager language = new LanguageResourceManager();

        language.register(LanguageResourceManager.EN_US, EntitySnowRabbit.class, "Snow Rabbit");
        language.register(LanguageResourceManager.JA_JP, EntitySnowRabbit.class, "雪うさぎ");

        ULanguageCreator.createLanguage(project, MOD_ID, language);
    }
}
