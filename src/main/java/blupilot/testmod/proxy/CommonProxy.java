package blupilot.testmod.proxy;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.Arrays;
import java.util.Random;

import static blupilot.testmod.ConfigHandler.blacklistedModids;
import static blupilot.testmod.ConfigHandler.names;

@Mod.EventBusSubscriber
public class CommonProxy {
	public static Random rand = new Random();

	// I'm leaving the init/register stuff here in case I wanna do something with them in the future or something
	public void preInit(FMLPreInitializationEvent e) {
	}
	public void init(FMLInitializationEvent e) {
	}
	public void postInit(FMLPostInitializationEvent e) {
	}
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
	}
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
	}

	@SubscribeEvent
	public static void entityJoinWorld(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		EntityEntry entry;
		String modid;
		if (entity instanceof IAnimals) {

			entry = EntityRegistry.getEntry(entity.getClass());
			modid = entry.getRegistryName().getResourceDomain();
			String entName = entity.getCustomNameTag();

			// If the blacklistedModids array doesn't contain the modid of the mob,
			// and if the mob has a null or empty name, assign a random name from the list
			if (!Arrays.asList(blacklistedModids).contains(modid)) {
				if (entName == null || entName == "") {
					entity.setCustomNameTag(names[rand.nextInt(names.length)]);
				}
			}
		}
	}
}
