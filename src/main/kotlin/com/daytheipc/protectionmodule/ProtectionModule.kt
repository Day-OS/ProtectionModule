package com.daytheipc.protectionmodule

import com.daytheipc.protectionmodule.block.ProtectionModuleBehavior
import net.momirealms.craftengine.bukkit.block.behavior.BukkitBlockBehaviors
import net.momirealms.craftengine.core.block.behavior.BlockBehaviors
import net.momirealms.craftengine.core.block.properties.IntegerProperty
import net.momirealms.craftengine.core.block.properties.Properties
import org.bukkit.plugin.java.JavaPlugin
import net.momirealms.craftengine.core.util.Key

class ProtectionModule : JavaPlugin() {
    override fun onEnable() {
        logger.info("ProtectionModule onEnable - checking registry")
        val key = Key.from("pm:battery")
        val factory = net.momirealms.craftengine.core.registry.BuiltInRegistries.BLOCK_BEHAVIOR_FACTORY.getValue(key)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    override fun onLoad() {
        BlockBehaviors.register(
            Key.from("pm:battery"),
            ProtectionModuleBehavior.FACTORY
        )
        logger.info("ProtectionModule loaded!")
    }
}
