package main.java.common.block;

import main.java.IrmiRepoMod;
import main.java.common.management.IRBlockManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Base for an Irmi's Repo. block.
 */
public class BlockIRBlockBase extends Block {

	/**
	 * Create a simple block. Good enough for a lot of purposes.
	 * @param materialIn The material of the block.
	 * @param name The name of the block.
	 */
	public BlockIRBlockBase(Material materialIn, String name) {
		super(materialIn);
		setRegistryName(IrmiRepoMod.getResLoc(name));
		setUnlocalizedName(name);
		setCreativeTab(IrmiRepoMod.IRMI_REPO_TAB);
		IRBlockManager.addBlock(this, null);
	}

}
