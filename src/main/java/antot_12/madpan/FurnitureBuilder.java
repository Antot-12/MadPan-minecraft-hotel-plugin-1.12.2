package antot_12.madpan;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class FurnitureBuilder {

    public void addRooms(World world, int x, int y, int z) {
        Material bedMaterial = Material.BED;
        Material chestMaterial = Material.CHEST;
        Material furnaceMaterial = Material.FURNACE;
        Material craftingTableMaterial = Material.WORKBENCH;
        Material doorMaterial = Material.WOODEN_DOOR;
        Material glassMaterial = Material.GLASS;

        // Iterate through wings and rooms, adding items
        for (int wing = 0; wing < 2; wing++) {
            for (int room = 0; room < 5; room++) {
                int roomX = x + (wing == 0 ? 0 : 13);
                int roomZ = z + (room * 4);

                // Create room walls
                for (int i = 0; i <= 4; i++) {
                    for (int j = 0; j <= 4; j++) {
                        if (i == 0 || i == 4 || j == 0 || j == 4) {
                            for (int k = 1; k <= 3; k++) {
                                world.getBlockAt(roomX + i, y + k, roomZ + j).setType(Material.WOOD);
                            }
                        }
                    }
                }

                // Add doors
                if (wing == 0) {
                    world.getBlockAt(roomX + 4, y + 1, roomZ + 2).setType(Material.AIR);
                    world.getBlockAt(roomX + 4, y + 2, roomZ + 2).setType(Material.AIR);
                    world.getBlockAt(roomX + 4, y + 1, roomZ + 2).setType(doorMaterial);
                } else {
                    world.getBlockAt(roomX - 1, y + 1, roomZ + 2).setType(Material.AIR);
                    world.getBlockAt(roomX - 1, y + 2, roomZ + 2).setType(Material.AIR);
                    world.getBlockAt(roomX - 1, y + 1, roomZ + 2).setType(doorMaterial);
                }

                // Add basic room setup (bed, furnace, crafting table, chest)
                world.getBlockAt(roomX + 1, y + 1, roomZ + 1).setType(bedMaterial);
                Block furnaceBlock = world.getBlockAt(roomX + 2, y + 1, roomZ + 1);
                furnaceBlock.setType(furnaceMaterial);
                world.getBlockAt(roomX + 3, y + 1, roomZ + 1).setType(craftingTableMaterial);
                Block chestBlock = world.getBlockAt(roomX + 1, y + 1, roomZ + 2);
                chestBlock.setType(chestMaterial);

                // Add windows on exterior side
                world.getBlockAt(roomX, y + 2, roomZ + 2).setType(glassMaterial);

                // Fill the furnace and chest with items
                fillFurnace(furnaceBlock);
                fillChest(chestBlock);
            }
        }
    }

    // Fill furnaces with coal
    public void fillFurnace(Block furnaceBlock) {
        if (furnaceBlock.getState() instanceof org.bukkit.block.Furnace) {
            org.bukkit.block.Furnace furnace = (org.bukkit.block.Furnace) furnaceBlock.getState();
            furnace.getInventory().setFuel(new ItemStack(Material.COAL, 64));  // Add 64 coal
        }
    }

    // Fill chests with a stone pickaxe and cooked beef
    public void fillChest(Block chestBlock) {
        if (chestBlock.getState() instanceof org.bukkit.block.Chest) {
            org.bukkit.block.Chest chest = (org.bukkit.block.Chest) chestBlock.getState();
            chest.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));  // Add stone pickaxe
            chest.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 5));  // Add 5 cooked beef
        }
    }
}
