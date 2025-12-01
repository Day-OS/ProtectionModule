package com.daytheipc.protectionmodule.block


import net.momirealms.craftengine.bukkit.block.behavior.BukkitBlockBehavior
import net.momirealms.craftengine.core.block.CustomBlock
import net.momirealms.craftengine.core.block.behavior.BlockBehaviorFactory
import net.momirealms.craftengine.core.block.properties.IntegerProperty
import net.momirealms.craftengine.core.util.ResourceConfigUtils
import org.bukkit.Bukkit

class ProtectionModuleBehavior(
    customBlock: CustomBlock,
    private val energyProperty: IntegerProperty,
): BukkitBlockBehavior(customBlock) {

//
//    override fun randomTick(thisBlock: Any, args: Array<out Any>, superMethod: Callable<in Any>) {
//        logger().warn("TEST TEST TEST TEST")
//
//        val blockState = args[0];
//        val optionalState = BlockStateUtils.getOptionalCustomBlockState(blockState);
//        val state = optionalState.get();
//        val energy = state.get(energyProperty)
//
//        if (energy > 0){
//            val newEnergy = energy - 1;
//            state.with(energyProperty, newEnergy).customBlockState().literalObject()
//        }
//
//        super.randomTick(thisBlock, args, superMethod)
//    }

    companion object {
        val FACTORY = Factory()

        class Factory: BlockBehaviorFactory{
            override fun create(
                block: CustomBlock,
                arguments: Map<String, Any>
            ): ProtectionModuleBehavior {
                Bukkit.getServer().consoleSender.sendMessage("AAAAAAAAAAAAAAAAAAAAAAAAAA")
                val property = ResourceConfigUtils.requireNonNullOrThrow(
                    block.getProperty("pm:energy"),
                    "warning.config.block.behavior.protection.missing_energy"
                );
                val energyProperty = property as IntegerProperty
                return  ProtectionModuleBehavior(block, energyProperty)
            }
        }
    }
}