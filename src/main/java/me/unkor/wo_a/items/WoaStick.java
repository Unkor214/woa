package me.unkor.wo_a.items;

import me.unkor.wo_a.Wo_a;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class WoaStick {
    private static final String itemName = Wo_a.getInstance().getConfig().getString("stick_name");
    private static final Material itemMaterial = Material.STICK;

    public static ItemStack createItemStack() {
        ItemStack woaStickItem = new ItemStack(itemMaterial);

        woaStickItem.editMeta(meta -> {
           meta.setItemName(itemName);
           meta.setMaxStackSize(1);
           meta.getPersistentDataContainer().set(NamespacedKey.fromString("item_type"), PersistentDataType.STRING,
                   itemName);
           meta.setEnchantmentGlintOverride(true);
        });

        return woaStickItem;
    }

    public static Boolean getStickFrom(ItemStack itemStack) {
        ItemMeta itemMeta = itemStack.getItemMeta();

        try {
            String itemName = itemMeta.getPersistentDataContainer().get(NamespacedKey.fromString("item_type"),
                    PersistentDataType.STRING);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
