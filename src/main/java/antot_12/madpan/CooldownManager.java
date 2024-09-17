package antot_12.madpan;

import java.util.HashSet;
import java.util.Set;
import org.bukkit.scheduler.BukkitRunnable;

public class CooldownManager {

    private final Set<String> cooldownPlayers = new HashSet<>();

    public boolean isOnCooldown(String playerName) {
        return cooldownPlayers.contains(playerName);
    }

    public void startCooldown(String playerName, int seconds) {
        cooldownPlayers.add(playerName);
        new BukkitRunnable() {
            @Override
            public void run() {
                cooldownPlayers.remove(playerName);
            }
        }.runTaskLater(MadPan.getPlugin(MadPan.class), seconds * 20);
    }
}
