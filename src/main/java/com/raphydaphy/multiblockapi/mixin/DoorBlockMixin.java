package com.raphydaphy.multiblockapi.mixin;

import com.raphydaphy.multiblockapi.MultiBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Collections;
import java.util.List;

@Mixin(DoorBlock.class)
public class DoorBlockMixin implements MultiBlock
{
	@Shadow @Final public static EnumProperty<DoubleBlockHalf> HALF;

	@Override
	public List<BlockPos> getOtherParts(BlockState state, BlockPos pos)
	{
		return state.getBlock() == (Object)this ? (state.get(HALF) == DoubleBlockHalf.LOWER ? Collections.singletonList(pos.up()) : Collections.singletonList(pos.down())) : Collections.emptyList();
	}
}
