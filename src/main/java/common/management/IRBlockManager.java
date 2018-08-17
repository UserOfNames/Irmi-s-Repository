package main.java.common.management;

import java.util.LinkedList;
import java.util.List;

import main.java.IrmiRepoMod;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Block management class for Irmi's Repo.
 */
@Mod.EventBusSubscriber(modid = IrmiRepoMod.MODID)
public class IRBlockManager {
	
	/**
	 * ItemBlock which indicates no item-block should be added for the given block.
	 */
	public static final ItemBlock NO_ITEM_BLOCK = new ItemBlock(Blocks.AIR);

	private static class RegListEntry {
		private final Block block;
		private final ItemBlock itemBlock;
		RegListEntry(Block block, ItemBlock itemBlock) {
			this.block = block;
			this.itemBlock = itemBlock;
		}
	}

	/**
	 * List of blocks to register.
	 */
	private static final List<RegListEntry> REGISTRY = new LinkedList<RegListEntry>();

	/**
	 * Pre-registration initialization tasks.
	 */
	public static void init() {
		
	}

	/**
	 * Add a block to the list of blocks to register.
	 * @param block The block to add.
	 * @param itemBlock The ItemBlock associated with the given block. If null,
	 * an ItemBlock will be created for the block automatically. If the
	 * constant IRBlockManager.NO_ITEM_BLOCK is given, no item block will be
	 * given to the block. Otherwise the provided argument is used.
	 */
	public static void addBlock(Block block, ItemBlock itemBlock) {
		if (block == null) {
			return;
		}
		if (itemBlock == null) {
			itemBlock = new ItemBlock(block);
		} else if (itemBlock == NO_ITEM_BLOCK) {
			itemBlock = null;
		}
		REGISTRY.add(new RegListEntry(block, itemBlock));
	}

	// Idc, I like the registry system, so I will abstract it away in case it changes.
	// Below this is all the technical stuff translating from my registry to actual FML stuff
	// If things change, unless the new system is reaaaally better, just change below here

	/**
	 * Register blocks themselves.
	 * @param event The registration event.
	 */
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		IrmiRepoMod.info("Registering Blocks");
		for (RegListEntry rle : REGISTRY) {
			IrmiRepoMod.debug("Registering " + rle.block);
			event.getRegistry().register(rle.block);
		}
		IrmiRepoMod.info("Done");
	}

	/**
	 * Register ItemBlocks for the aforementioned blocks.
	 * @param event The registration event.
	 */
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		IrmiRepoMod.info("Registering ITemBlocks");
		for (RegListEntry rle : REGISTRY) {
			if (rle.itemBlock != null) {
				IrmiRepoMod.debug("Registering " + rle.itemBlock);
				event.getRegistry().register(rle.itemBlock);
			}
		}
	}

	/**
	 * Register ItemBlock models for rendering.
	 * @param event The registration event.
	 */
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		IrmiRepoMod.info("Registering ItemBlock Models");
		for (RegListEntry rle : REGISTRY) {
			IrmiRepoMod.debug("Registering for " + rle.block);
			Item i = Item.getItemFromBlock(rle.block);
			ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(i.getRegistryName(), "inventory"));
		}
	}

}
