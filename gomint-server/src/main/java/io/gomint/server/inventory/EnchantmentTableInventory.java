package io.gomint.server.inventory;

import io.gomint.inventory.item.ItemStack;
import io.gomint.inventory.item.ItemType;
import io.gomint.math.Location;
import io.gomint.math.Vector;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.entity.tileentity.EnchantTableTileEntity;
import io.gomint.server.inventory.item.Items;
import io.gomint.server.network.type.WindowType;
import io.gomint.server.world.block.Block;

/**
 * @author geNAZt
 * @version 1.0
 */
public class EnchantmentTableInventory extends ContainerInventory {

    /**
     * Construct a new container inventory
     *
     * @param owner of the container (mostly a tile or normal entity)
     */
    public EnchantmentTableInventory(Items items, InventoryHolder owner) {
        super(items, owner, 2);
    }

    @Override
    public WindowType getType() {
        return WindowType.ENCHANTMENT;
    }

    @Override
    public void onOpen(EntityPlayer player) {

    }

    @Override
    public void onClose(EntityPlayer player) {
        // Get the position
        Block enchanter = ((EnchantTableTileEntity) this.owner).getBlock();
        Vector enchanterVector = new Vector(enchanter.getPosition());

        // Drop the players items
        for (ItemStack content : this.contents) {
            if (content.getItemType() != ItemType.AIR) {
                enchanter.getWorld().createItemDrop(enchanterVector.add(0, .5f, 0), content);
            }
        }

        // Clear this inventory just to be safe
        clear();
    }

}
