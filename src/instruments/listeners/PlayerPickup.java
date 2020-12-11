package instruments.listeners;

import instruments.Instrument;
import instruments.Instruments;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPickup implements Listener {

    private Instruments instance = Instruments.getInstance();

    @EventHandler
    public void onPlayerPickup(PlayerPickupItemEvent event) {
        Player p = event.getPlayer();

        if(!instance.getInstrumentManager().containsKey(p)) return;

        Instrument instrument = instance.getInstrumentManager().get(p);

        if(instrument.isHotBarMode()) {
            event.setCancelled(true);
            return;
        }
    }
}
