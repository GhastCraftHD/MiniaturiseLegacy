package de.leghast.miniaturise.ui;

import de.leghast.miniaturise.Miniaturise;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AdjusterUserInterface {

    private Miniaturise main;

    private double moveUnit;

    public AdjusterUserInterface(Miniaturise main){
        this.main = main;
    }

    public void openAdjusterMainPage(Player player){
        Inventory inventory = Bukkit.createInventory(player, 27, "Adjust miniature");

        ItemStack is = new ItemStack(Material.LIME_STAINED_GLASS);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName("Move miniature");

        for(int slot : new int[]{4, 5, 12, 14, 21, 22}){
            inventory.setItem(slot, is);
        }

        player.openInventory(inventory);
    }

    public double getMoveUnit(){
        return moveUnit;
    }

    public void setMoveUnit(double moveUnit){
        this.moveUnit = moveUnit;
    }


}
