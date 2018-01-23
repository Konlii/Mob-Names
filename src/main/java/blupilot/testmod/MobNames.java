package blupilot.testmod;

import blupilot.testmod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = MobNames.MODID, name = MobNames.NAME, version = MobNames.MODVERSION, useMetadata = true)
public class MobNames {
	public static final String MODID = "mobnames";
	public static final String NAME = "Mob Names";
	public static final String MODVERSION = "0.0.3";

	@SidedProxy(clientSide = "blupilot.testmod.proxy.ClientProxy", serverSide = "blupilot.testmod.proxy.ClientProxy")
	public static CommonProxy proxy;

	@Mod.Instance
	public static MobNames instance;

	public static Logger logger;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}

}
