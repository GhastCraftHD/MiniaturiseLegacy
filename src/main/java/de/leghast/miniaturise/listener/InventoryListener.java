package de.leghast.miniaturise.listener;

import de.leghast.miniaturise.Miniaturise;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryListener implements Listener {

    private Miniaturise main;

    public InventoryListener(Miniaturise main){
        this.main = main;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getView().getTitle().equals("Adjust miniature") && e.getCurrentItem() != null){
            e.setCancelled(true);
            switch (e.getRawSlot()){
                case 4 -> {
                    //UP
                    for (BlockDisplay bd : main.getMiniatureManager().getPlacedMiniature()) {
                        bd.teleport(bd.getLocation().add(0, main.getAdjusterUserInterface().getMoveUnit(), 0));
                    }
                }
                case 5 -> {
                    //NEAR
                    for (BlockDisplay bd : main.getMiniatureManager().getPlacedMiniature()) {
                        bd.teleport(bd.getLocation().add(0, 0, -main.getAdjusterUserInterface().getMoveUnit()));
                    }
                }
                case 12 -> {
                    //LEFT
                    for(BlockDisplay bd : main.getMiniatureManager().getPlacedMiniature()){
                        bd.teleport(bd.getLocation().add(-main.getAdjusterUserInterface().getMoveUnit(), 0, 0));
                    }
                }
                case 14 -> {
                    //RIGHT
                    for(BlockDisplay bd : main.getMiniatureManager().getPlacedMiniature()){
                        bd.teleport(bd.getLocation().add(main.getAdjusterUserInterface().getMoveUnit(), 0, 0));
                    }
                }
                case 21 -> {
                    //FAR
                    for (BlockDisplay bd : main.getMiniatureManager().getPlacedMiniature()) {
                        bd.teleport(bd.getLocation().add(0, 0, main.getAdjusterUserInterface().getMoveUnit()));
                    }
                }
                case 22 -> {
                    //DOWN
                    for (BlockDisplay bd : main.getMiniatureManager().getPlacedMiniature()) {
                        bd.teleport(bd.getLocation().add(0, -main.getAdjusterUserInterface().getMoveUnit(), 0));
                    }
                }
            }
        }
    }

}
