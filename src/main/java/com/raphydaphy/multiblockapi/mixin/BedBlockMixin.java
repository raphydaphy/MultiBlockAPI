package com.raphydaphy.multiblockapi.mixin;

import com.raphydaphy.multiblockapi.MultiBlock;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.enums.BedPart;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Collections;
import java.util.List;

@Mixin(BedBlock.class)
public class BedBlockMixin extends HorizontalFacingBlock implements MultiBlock
{
	@Shadow
	@Final
	public static EnumProperty<BedPart> PART;

	protected BedBlockMixin(Settings settings)
	{
		super(settings);
	}

	@Override
	public List<BlockPos> getOtherParts(BlockState state, BlockPos pos)
	{
		if (state.getBlock() != (Object) this) return Collections.emptyList();
		Direction facing = state.get(field_11177); // HorizontalFacingBlock#FACING
		return state.get(PART) == BedPart.HEAD ?  Collections.singletonList(pos.offset(facing.getOpposite())) : Collections.singletonList(pos.offset(facing));
	}
}
