package antot_12.madpan;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WandManager {

    private final MadPan plugin;

    public WandManager(MadPan plugin) {
        this.plugin = plugin;
    }

    public void giveWand(Player player) {
        ItemStack wand = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = wand.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "WAND Creator");
        wand.setItemMeta(meta);
        player.getInventory().setItem(4, wand);
    }

    public boolean isWand(ItemStack item) {
        return item != null && item.getType() == Material.DIAMOND_AXE &&
                item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("WAND Creator");
    }
}
