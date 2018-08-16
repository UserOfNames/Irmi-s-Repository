package main.java;

import org.apache.logging.log4j.Logger;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Main modification class.
 */
@Mod(useMetadata = true,
	modid = IrmiRepoMod.MODID,
	name = IrmiRepoMod.NAME,
	version = IrmiRepoMod.VERSION)
public class IrmiRepoMod {
	/**
	 * Mod ID.
	 */
	public static final String MODID = "irmirepo";
	/**
	 * Mod name.
	 */
	public static final String NAME = "Irmi's Repository (Of Magical Artifacts)";
	/**
	 * Mod version.
	 * MAJOR.MINOR.PATCH
	 */
	public static final String VERSION = "0.0.0";
	
	/**
	 * Instance of the mod class.
	 */
	@Instance(MODID)
	public static IrmiRepoMod instance;

	/**
	 * Logger instance, provided by preInit
	 */
	private static Logger logger;

	/**
	 * Pre-initialization. Occurs before block/item registration, so
	 * registration-sensitive tasks must occur here, in addition to adding
	 * capabilities and reading the config file.
	 * @param event The event.
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		
	}

	/**
	 * Initialization event. Occurs after all auto-registration events. Usually
	 * world generators, event handlers for world-events (and others) are
	 * registered here, as well as sending IMC (Inter-Mod Communication)
	 * messages.
	 * @param event Event.
	 */
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}

	/**
	 * Post-initialization event. Usually mod-compatability stuff.
	 * @param event Event.
	 */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

	// additional useful methods

	/*
	 * Universal safe logger methods
	 */
	public static void debug(Object o) {
		if (logger == null) {
			return;
		}
		logger.debug(o.toString());
	}

	public static void info(Object o) {
		if (logger == null) {
			return;
		}
		logger.info(o.toString());
	}

	public static void warn(Object o) {
		if (logger == null) {
			return;
		}
		logger.warn(o.toString());
	}

	public static void error(Object o) {
		if (logger == null) {
			return;
		}
		logger.error(o.toString());
	}

	public static void fatal(Object o) {
		if (logger == null) {
			return;
		}
		logger.fatal(o.toString());
	}

	public static void trace(Object o) {
		if (logger == null) {
			return;
		}
		logger.debug(o.toString());
	}
	
	/**
	 * Get a ResourceLocation.
	 * @param name The name of the resource.
	 * @return A ResourceLocation for the given resource.
	 */
	public static ResourceLocation getResLoc(String name) {
		return new ResourceLocation(IrmiRepoMod.MODID, name);
	}

}
