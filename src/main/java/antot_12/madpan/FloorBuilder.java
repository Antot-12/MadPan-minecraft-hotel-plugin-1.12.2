package antot_12.madpan;

import org.bukkit.Material;
import org.bukkit.World;

public class FloorBuilder {

    private final FurnitureBuilder furnitureBuilder = new FurnitureBuilder();
    private final StairBuilder stairBuilder = new StairBuilder();

    public void buildFloor(World world, int x, int y, int z) {
        Material wallMaterial = Material.WOOD;
        Material floorMaterial = Material.WOOL;

        // Підлога
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                world.getBlockAt(x + i, y, z + j).setType(floorMaterial);
            }
        }

        // Зовнішні стіни
        for (int i = 0; i < 20; i++) {
            for (int k = 1; k <= 3; k++) {
                world.getBlockAt(x + i, y + k, z).setType(wallMaterial);
                world.getBlockAt(x + i, y + k, z + 19).setType(wallMaterial);
                world.getBlockAt(x, y + k, z + i).setType(wallMaterial);
                world.getBlockAt(x + 19, y + k, z + i).setType(wallMaterial);
            }
        }

        // Меблі і двері
        furnitureBuilder.addRooms(world, x, y, z);

        // Сходи між поверхами
        stairBuilder.buildDiagonalStairs(world, x + 9, y, z + 9);
    }
}
