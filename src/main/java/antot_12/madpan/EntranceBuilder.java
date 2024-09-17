package antot_12.madpan;

import org.bukkit.Material;
import org.bukkit.World;

public class EntranceBuilder {

    public void addEntrance(World world, int x, int y, int z) {
        Material carpetMaterial = Material.REDSTONE_BLOCK;
        Material doorMaterial = Material.WOODEN_DOOR;

        // Create a redstone carpet leading outside and inside the hotel
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                world.getBlockAt(x + i + 8, y, z + j).setType(carpetMaterial); // Outside carpet
                world.getBlockAt(x + i + 8, y, z - j - 1).setType(carpetMaterial); // Inside carpet
            }
        }

        // Create a 3x3 entrance
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                world.getBlockAt(x + 10 + i, y + j, z).setType(Material.AIR); // Clear space for doors
            }
        }
        world.getBlockAt(x + 11, y + 1, z).setType(doorMaterial); // Add central door
    }
}
