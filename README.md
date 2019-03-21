# MultiBlock API
A simple API for compatibility with MultiBlocks similar to Doors and Beds

If your Fabric mod contains any blocks that occupy a space larger than normal, this API might be for you! It adds a simple interface which lets you provide the other blocks in your structure. This isn't very useful on it's own, but its main purpose is for mod comparability.

To use the mod, add this to your `build.gradle`

``````
repositories {
	maven { url "https://jitpack.io" }
}
dependencies {
	modCompile "com.github.raphydaphy:MultiBlockAPI:85b44a7"
}
``````

You should also add the dependency to your `fabric.mod.json`.

```````
"requires": {
    "multiblockapi": "*"
}
```````

Once you have setup the mod, simply implement `MultiBlock` on each Multi-Block in your mod. Here is a simple example from Arcane Magic.

``````
public class DoubleBlockBase extends OrientableBlockBase implements MultiBlock
{
    @Override
    public List<BlockPos> getOtherParts(BlockState blockState, BlockPos blockPos)
    {
        return blockState.getBlock() == this ? (blockState.get(HALF) == DoubleBlockHalf.LOWER ? Collections.singletonList(blockPos.up()) : Collections.singletonList(blockPos.down())) : Collections.emptyList();
    }
}
