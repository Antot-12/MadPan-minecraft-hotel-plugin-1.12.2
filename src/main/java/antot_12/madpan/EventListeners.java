package antot_12.madpan;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.block.Block;

public class EventListeners implements Listener {

    private final MadPan plugin;
    private final HotelBuilder hotelBuilder;

    public EventListeners(MadPan plugin) {
        this.plugin = plugin;
        this.hotelBuilder = new HotelBuilder(plugin);
    }

    @EventHandler
    public void onPlayerUseWand(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block targetBlock = event.getClickedBlock();

        if (plugin.getWandManager().isWand(player.getInventory().getItemInMainHand())) {
            // Передаємо координати блоку (x, y, z) замість самого блоку
            hotelBuilder.buildHotel(player, targetBlock.getX(), targetBlock.getY(), targetBlock.getZ());
        }
    }
}
