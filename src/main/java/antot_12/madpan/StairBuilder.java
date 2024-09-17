package antot_12.madpan;

import org.bukkit.Material;
import org.bukkit.World;

public class StairBuilder {

    public void buildDiagonalStairs(World world, int x, int y, int z) {
        Material stairMaterial = Material.WOOD_STAIRS;

        for (int i = 0; i < 3; i++) {
            world.getBlockAt(x + i, y + i, z).setType(stairMaterial);
            world.getBlockAt(x + i, y + i, z + 1).setType(stairMaterial);
        }

        for (int i = 0; i < 3; i++) {
            world.getBlockAt(x + i, y + 3, z).setType(Material.AIR);
            world.getBlockAt(x + i, y + 3, z + 1).setType(Material.AIR);
        }
    }
}
