package mymod.biome;

import mymod.Main;
import mymod.entity.MyEntityZombie;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MyFudgeBiome extends BiomeGenBase
{
    public MyFudgeBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("The Deadly Fudge Land");
        System.out.println("MY BLOCK " + Main.MyBlock_2.blockID);
        this.topBlock = (byte)Main.MyBlock_2.blockID;
        this.fillerBlock = (byte)Main.MyBlock_1.blockID;
        
        this.theBiomeDecorator.bigMushroomsPerChunk = 25;
        this.theBiomeDecorator.flowersPerChunk = 1000;

        this.spawnableCreatureList.add(new SpawnListEntry(EntityCreeper.class, 50, 2, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySkeleton.class, 50, 2, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityZombie.class, 100, 5, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(MyEntityZombie.class, 10, 1, 3));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantZombie.class, 10, 1, 1));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBat.class,100, 5, 15));
        
        this.setMinMaxHeight(0.1F, 0.9F);
        this.setTemperatureRainfall(1.5F, 2.0F);
   
    }
}