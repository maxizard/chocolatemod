package mymod;

import java.awt.Color;

import mymod.armor.MyArmor;
import mymod.biome.MyBiome;
import mymod.biome.MyFudgeBiome;
import mymod.blocks.MyBlock;
import mymod.blocks.MyBlockGen;
import mymod.entity.MyEntityZombie;
import mymod.entity.MyRenderZombie;
import mymod.entity.minion.MyEntityMinion;
import mymod.entity.minion.MyModelMinion;
import mymod.entity.minion.MyRenderMinion;
import mymod.items.MyFood;
import mymod.items.MyItem;
import mymod.items.MyPickaxe;
import mymod.items.MySword;
import mymod.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


/* 	MOD INFO */
	@Mod( modid = "mymod", name = "The Chocolate Mod", version = "1.0")
	@NetworkMod(clientSideRequired=true, serverSideRequired=false)	


public class Main {

/*	PROXY INFO */
	@SidedProxy(clientSide = "mymod.proxies.ClientProxy", serverSide = "mymod.proxies.CommonProxy")
	public static CommonProxy proxy;
		
	
/**	
 * DECLARATION SECTION 
 * *********************************************************** */

	//  DECLARE THE SWORD 
    public static Item MySword_1;
    //  DECLARE THE PICKAXE 
    public static Item MyPickaxe_1;
//  DECLARE NEW TOOL MATERIAL
    /**Harvest Level,Max Uses, Efficiency,Damage, Enchantability,*/  
    public static EnumToolMaterial MyToolMaterial = EnumHelper.addToolMaterial("Chocolate Chunk", 500, 100, 5000.0F, .0F, 10);
//  DECLARE THE ITEM
    public static Item MyItem_1;
//  DECLARE THE FIRST FOOD
    public static MyFood MyFood_1;
//  DECLARE THE FIRST BLOCK
    public static Block MyBlock_1;
//  DECLARE THE ARMOR
    public static Item MyHelmet_1;
    public static Item MyChest_1;
    public static Item MyLeggings_1;
    public static Item MyBoots_1;
//  DECLARE THE ARMOR MATERIAL
    public static EnumArmorMaterial MyArmorMaterial_1 = EnumHelper.addArmorMaterial("Chocolate Chunk", 50, new int[]{5, 5, 5, 5}, 25);
//  DECLARE THE FIRST BIOME
    public static  BiomeGenBase MyBiome_1;
//  DECLARE THE SECOND BIOME
    public static  BiomeGenBase MyFudgeBiome_1;
//  DECLARE THE MOD ID
    static int MyEntityID = 300;

//  SEARCH FOR UNIQUE ID    
    public static int getUniqueEntityId() {
        do {
            MyEntityID++;
        }
        while (EntityList.getStringFromID(MyEntityID) != null);
        return MyEntityID++;
    }

//  DECLARE A NEW EGG
    public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor) {
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
    }
//  DECLARE THE SECOND FOOD
    public static MyFood MyFood_2;
//  DECLARE THE SECOND BLOCK
    public static Block MyBlock_2;	
    
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


@EventHandler	
	public  void preInit( FMLPreInitializationEvent event ) 
	{
/**	
 * LOAD SECTION 
 * *********************************************************** */ 

//  LOAD THE SWORD
    MySword_1 = new MySword(2021, MyToolMaterial , "MySword_1");
    GameRegistry.registerItem(MySword_1, "MySword_1");
    LanguageRegistry.addName(MySword_1, "Chocolate Sword");
    
//  LOAD THE PICKAXE
    MyPickaxe_1 = new MyPickaxe(2022, EnumToolMaterial.IRON, "MyPickaxe_1");
    GameRegistry.registerItem(MyPickaxe_1, "MyPickaxe_1");
    LanguageRegistry.addName(MyPickaxe_1, "Chocolate Pickaxe");
//  LOAD THE ITEM
    MyItem_1 = new MyItem(2030, "MyItem_1").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(16);
    GameRegistry.registerItem(MyItem_1, "MyItem_1");
    LanguageRegistry.addName(MyItem_1, "Chocolate Chunk");
    
//  LOAD THE FIRST FOOD
    /**itemID, healAmount, saturationModifier (f), isWolfsFaveFood, TextureName*/
    MyFood_1 = new MyFood(2040, 1, 0.1F, true, "MyFood_1");
    MyFood_1.setAlwaysEdible();
    MyFood_1.setCreativeTab(CreativeTabs.tabFood);
 
    GameRegistry.registerItem(MyFood_1, "MyFood_1");
    
    LanguageRegistry.addName(MyFood_1, "Chocolate Milk");
    
//  LOAD THE FIRST BLOCK 
    MyBlock_1 = new MyBlock(250, Material.rock, "MyBlock_1").setLightValue(0.9375F).setResistance(2000).setHardness(3.0F).setStepSound(Block.soundStoneFootstep);
    GameRegistry.registerBlock(MyBlock_1, "MyBlock_1");
    LanguageRegistry.addName(MyBlock_1, "Choclate Ore");
	MinecraftForge.setBlockHarvestLevel(MyBlock_1, "pickaxe", 2);
	
//  LOAD THE SECOND BLOCK
    
    MyBlock_2 = new MyBlock(251, Material.rock, "MyBlock_2").setLightValue(0.9375F).setResistance(2000).setHardness(11.0F).setStepSound(Block.soundStoneFootstep);
    GameRegistry.registerBlock(MyBlock_2, "MyBlock_2");
    LanguageRegistry.addName(MyBlock_2, "Blocklate"); 
	MinecraftForge.setBlockHarvestLevel(MyBlock_2, "pickaxe", 2);  
    
	
//  LOAD HELMET 
    MyHelmet_1 = new MyArmor(2060, MyArmorMaterial_1, 0, 0, "myarmor");
    GameRegistry.registerItem(MyHelmet_1, "MyHelmet_1");
    LanguageRegistry.addName(MyHelmet_1, "Chocolate Helmet");      

//LOAD CHESTPLATE
    MyChest_1 = new MyArmor(2061, MyArmorMaterial_1, 0, 1, "myarmor");
    GameRegistry.registerItem(MyChest_1, "MyChest_1");
    LanguageRegistry.addName(MyChest_1, "Chocolate Chestplate");

//LOAD LEGGINGS    
    MyLeggings_1 = new MyArmor(2062, MyArmorMaterial_1, 0, 2, "myarmor");
    GameRegistry.registerItem(MyLeggings_1, "MyLeggings_1");
    LanguageRegistry.addName(MyLeggings_1, "Chocolate Leggings");

//LOAD BOOTS   
    MyBoots_1 = new MyArmor(2063, MyArmorMaterial_1, 0, 3, "myarmor");
    GameRegistry.registerItem(MyBoots_1, "MyBoots_1");
    LanguageRegistry.addName(MyBoots_1, "Chocolate Boots");
    
//  LOAD THE FIRST BIOME
    MyBiome_1 = new MyBiome(30);
    GameRegistry.addBiome(MyBiome_1);
    
//  LOAD THE SECOND BIOME
    MyFudgeBiome_1 = new MyFudgeBiome(31);
    GameRegistry.addBiome(MyFudgeBiome_1);
    
//  REGISTER YOUR ENTITY
    EntityRegistry.registerGlobalEntityID(MyEntityZombie.class, "Chocolate Ghost", EntityRegistry.findGlobalUniqueEntityId());
    EntityRegistry.addSpawn(MyEntityZombie.class, 15, 1, 2, EnumCreatureType.monster, BiomeGenBase.desertHills); 
    EntityRegistry.addSpawn(MyEntityZombie.class, 25, 1, 2, EnumCreatureType.monster, MyBiome_1);     
    registerEntityEgg(MyEntityZombie.class, (new Color(73, 52, 21)).getRGB(), (new Color(135, 96, 39)).getRGB());
    RenderingRegistry.registerEntityRenderingHandler(MyEntityZombie.class, new MyRenderZombie());
    ModLoader.addLocalization("entity.Chocolate Ghost.name", "Chocolate Ghost");
    
//  LOAD THE SECOND FOOD
    /**itemID, healAmount, saturationModifier (f), isWolfsFaveFood, TextureName*/
    MyFood_2 = new MyFood(2041, 1, 0.1F, true, "Chocolate Bar");
    MyFood_2.setAlwaysEdible();
    MyFood_2.setCreativeTab(CreativeTabs.tabFood);
    
   //  REGISTER YOUR ENTITY
        EntityRegistry.registerGlobalEntityID(MyEntityMinion.class, "Minion", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(MyEntityMinion.class, 50, 1, 5, EnumCreatureType.creature, BiomeGenBase.desert);     
        EntityRegistry.addSpawn(MyEntityMinion.class, 50, 1, 5, EnumCreatureType.monster, MyBiome_1);  
        registerEntityEgg(MyEntityMinion.class, (new Color(255, 0, 0)).getRGB(), (new Color(0, 0, 0)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityMinion.class, new MyRenderMinion(new MyModelMinion(), 0.3F));
        ModLoader.addLocalization("entity.Minion.name", "Minion");
	
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	}


@EventHandler
	public static void init( FMLInitializationEvent event ) 
	{
	
/**	
 * RECIPES SECTION 
 * *********************************************************** */

//  SWORD RECIPE  
    GameRegistry.addRecipe(new ItemStack(MySword_1, 1), new Object[]
    {
            "P",
            "P",
            "S",
        'S', Item.stick,
        'P', MyItem_1
    });
//  PICKAXE RECIPE  
    GameRegistry.addRecipe(new ItemStack(MyPickaxe_1, 1), new Object[]
    {
            "PPP",
            " S ",
            " S ",
        'S', Item.stick,
        'P', MyItem_1
    });
//  ITEM RECIPE         
    GameRegistry.addRecipe(new ItemStack(MyItem_1, 1), new Object[]
    {
            
            "P",
            
        'P', Block.cocoaPlant
    });
// FIRST FOOD RECIPE         
    GameRegistry.addRecipe(new ItemStack(MyFood_1, 1), new Object[]
    {
    	    "I",
            "S",
            
        'S',Item.bucketMilk,
        'I', MyItem_1
    });
//  FIRST BLOCK SMELTING RECIPE
    GameRegistry.addSmelting(MyBlock_1.blockID, (new ItemStack(MyItem_1, 1)), 25);
//  HELMET RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyHelmet_1, 1), new Object[]
    {
            "XXX",
            "X X",
            "XXX",
        'X', MyItem_1,
    });         

//  CHESTPLATE RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyChest_1, 1), new Object[]
    {
            "X X",
            "XXX",
            "XXX",
        'X', MyItem_1,
    });         

//  LEGGINGS RECIPE 
    GameRegistry.addRecipe(new ItemStack(MyLeggings_1, 1), new Object[]
    {
            "XXX",
            "X X",
            "X X",
        'X', MyItem_1,
    });         

//  BOOTS RECIPE    
    GameRegistry.addRecipe(new ItemStack(MyBoots_1, 1), new Object[]
    {
            "X X",
            "X X",
        'X', MyItem_1,
    });
//SECOND FOOD RECIPE         
    GameRegistry.addRecipe(new ItemStack(MyFood_2, 1), new Object[]
    {
    	    " I ",
            "SIS",
            "SSS",
        'S',Item.silk,
        'I',MyItem_1,
    });
  //SECOND BLOCK RECIPE         
    GameRegistry.addRecipe(new ItemStack(MyFood_2, 1), new Object[]
    {
    	    "III",
            "IBI",
            "III",
        'B',MyBlock_1,
        'I',MyItem_1,
    });
    
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */
//  REGISTER THE ORE GENERATION 
    GameRegistry.registerWorldGenerator(new MyBlockGen());
//  REMOVE OTHER BIOMES
    GameRegistry.removeBiome(BiomeGenBase.beach);
    GameRegistry.removeBiome(BiomeGenBase.desert);
    //GameRegistry.removeBiome(BiomeGenBase.desertHills);
    GameRegistry.removeBiome(BiomeGenBase.extremeHills);
    GameRegistry.removeBiome(BiomeGenBase.extremeHillsEdge);
    GameRegistry.removeBiome(BiomeGenBase.forest);
    GameRegistry.removeBiome(BiomeGenBase.forestHills);
    GameRegistry.removeBiome(BiomeGenBase.frozenOcean);
    GameRegistry.removeBiome(BiomeGenBase.frozenRiver);
    GameRegistry.removeBiome(BiomeGenBase.iceMountains);
    GameRegistry.removeBiome(BiomeGenBase.icePlains);
    GameRegistry.removeBiome(BiomeGenBase.jungle);
    GameRegistry.removeBiome(BiomeGenBase.jungleHills);
    GameRegistry.removeBiome(BiomeGenBase.mushroomIsland);
    GameRegistry.removeBiome(BiomeGenBase.ocean);
    GameRegistry.removeBiome(BiomeGenBase.plains);
    GameRegistry.removeBiome(BiomeGenBase.river);
    GameRegistry.removeBiome(BiomeGenBase.swampland);
    GameRegistry.removeBiome(BiomeGenBase.taiga);
    GameRegistry.removeBiome(BiomeGenBase.taigaHills);
        


/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}
	
}
