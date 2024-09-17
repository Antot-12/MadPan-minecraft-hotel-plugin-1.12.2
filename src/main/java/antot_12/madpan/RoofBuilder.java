package antot_12.madpan;

import org.bukkit.Material;
import org.bukkit.World;

public class RoofBuilder {

    public void buildRoof(World world, int x, int y, int z) {
        Material roofMaterial = Material.STEP;  // Кам'яні плити у версії 1.12.2

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                world.getBlockAt(x + i, y, z + j).setType(roofMaterial);
            }
        }
    }
}
