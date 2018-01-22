package blupilot.testmod;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = MobNames.MODID, name = MobNames.MODID + "/" + MobNames.MODID)
@Mod.EventBusSubscriber(modid = MobNames.MODID)
public class ConfigHandler {

	@Config.Comment({"A list of names that mobs will be randomly generated with"})
	public static String[] names = new String[] {
			"Yurem","Nelson","Mylie","Jasmine","Luke","Peter","Libby","Tabitha","Jovanni",
			"Julie", "Keyon","Memphis","Ryland","Broderick","Holden","Clarence","Savannah","Abby","Albert","Ryleigh",
			"Daniel", "Dylan","Shiloh","Makayla","Slade","Londyn","Salvador","Braylon","Sidney","Hayden","Yahir",
			"Davion","Jimmy","Braedon","Kira","Freddy","Mylee","Paityn","Camron","Hunter","Brielle","Ava","Harper",
			"Jazlene","Nathaly","Casey","Keenan","Rylan","Michelle","Jazlyn","Madalynn","Tate","Jakayla","Chad","Brett",
			"Eleanor","Bradyn","Katrina","John","Jax","Jonah","Jensen","Kane","Zoie","Giancarlo","Caden","Evangeline",
			"Terrance","Trent","Jaelyn","Bronson","Cameron","Denzel","Eugene","Amir","Meredith","Taylor","Edgar",
			"Ramon","Kaylynn","Chanel","Ralph","Noah","Kamila","Ashtyn","Karla","Jenna","Amelia","Talan","Quinten",
			"Izabella","Tania","Camille","David","Darien","Isai","Karen","Yuliana","Miles","Alexia"
	};

	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(MobNames.MODID)) {
			ConfigManager.sync(event.getModID(), Config.Type.INSTANCE); // Sync config values
		}
	}

}
