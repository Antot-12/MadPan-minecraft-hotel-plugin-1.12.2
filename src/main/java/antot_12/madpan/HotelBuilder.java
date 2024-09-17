package antot_12.madpan;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class HotelBuilder {

    private final MadPan plugin;
    private final int floors = 5;  // Кількість поверхів
    private final int roomHeight = 3;  // Висота кімнати до стелі

    private final FloorBuilder floorBuilder;
    private final RoofBuilder roofBuilder;
    private final EntranceBuilder entranceBuilder;

    public HotelBuilder(MadPan plugin) {
        this.plugin = plugin;
        this.floorBuilder = new FloorBuilder();
        this.roofBuilder = new RoofBuilder();
        this.entranceBuilder = new EntranceBuilder();
    }

    // Перевірка, чи гравець тримає чарівну паличку, та будівництво готелю
    public void handleWandUse(Player player, Block targetBlock) {
        if (plugin.getCooldownManager().isOnCooldown(player.getName())) {
            player.sendMessage(ChatColor.RED + "Please wait before spawning another hotel!");
            return;
        }

        if (isValidGroundBlock(targetBlock)) {
            buildHotel(player, targetBlock.getX(), targetBlock.getY(), targetBlock.getZ());
        } else {
            player.sendMessage(ChatColor.RED + "You can only build a hotel on valid ground!");
        }
    }

    // Перевірка валідності блоку для будівництва
    public boolean isValidGroundBlock(Block block) {
        Material type = block.getType();
        return type == Material.GRASS || type == Material.DIRT || type == Material.SAND || type == Material.STONE;
    }

    // Основна функція будівництва готелю
    public void buildHotel(Player player, int x, int y, int z) {
        World world = player.getWorld();

        // Очищення території навколо
        clearArea(world, x - 5, y, z - 5, 30, 30);

        // Побудова поверхів і даху
        for (int i = 1; i <= floors; i++) {
            floorBuilder.buildFloor(world, x, y + (i - 1) * (roomHeight + 1), z);
        }

        roofBuilder.buildRoof(world, x, y + floors * (roomHeight + 1), z);

        // Вхід
        entranceBuilder.addEntrance(world, x, y, z);

        // Повідомлення про завершення будівництва
        player.sendMessage(ChatColor.GREEN + "Hotel built at " + x + ", " + (y - 1) + ", " + z);
        plugin.getCooldownManager().startCooldown(player.getName(), 5);  // Кулдаун 5 секунд
    }

    // Очищення території
    public void clearArea(World world, int x, int y, int z, int width, int length) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < roomHeight + 3; k++) {
                    world.getBlockAt(x + i, y + k, z + j).setType(Material.AIR);
                }
            }
        }
    }
}
