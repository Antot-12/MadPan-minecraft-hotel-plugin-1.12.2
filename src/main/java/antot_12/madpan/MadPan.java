package antot_12.madpan;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class MadPan extends JavaPlugin implements Listener {

    private WandManager wandManager;
    private HotelBuilder hotelBuilder;
    private CooldownManager cooldownManager;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[MadPan] Plugin enabled!");

        wandManager = new WandManager(this);
        hotelBuilder = new HotelBuilder(this);
        cooldownManager = new CooldownManager();

        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[MadPan] Plugin disabled!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        wandManager.giveWand(event.getPlayer());
    }

    @EventHandler
    public void onPlayerUseWand(PlayerInteractEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();

        if (item != null && item.getType() == Material.DIAMOND_AXE && wandManager.isWand(item)) {
            if (event.getClickedBlock() != null && event.getAction().toString().contains("RIGHT_CLICK")) {
                hotelBuilder.handleWandUse(event.getPlayer(), event.getClickedBlock());
            }
        }
    }

    public CooldownManager getCooldownManager() {
        return cooldownManager;
    }

    public WandManager getWandManager() {
        return wandManager;
    }
}
