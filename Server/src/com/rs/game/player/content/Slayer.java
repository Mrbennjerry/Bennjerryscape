package com.rs.game.player.content;

import java.io.Serializable;
import java.util.List;

import com.rs.game.Animation;
import com.rs.game.Entity;
import com.rs.game.World;
import com.rs.game.WorldObject;
import com.rs.game.item.Item;
import com.rs.game.npc.NPC;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;
import com.rs.game.player.SlayerManager;
import com.rs.game.tasks.WorldTask;
import com.rs.game.tasks.WorldTasksManager;
import com.rs.utils.ShopsHandler;
import com.rs.utils.Utils;

public class Slayer {

	public enum SlayerMaster implements Serializable {
	    	//done
		SPRIA(8462, 85, 1, new int[]
		{ 0, 0, 0 }, new int[]
		{ 15, 50 }, SlayerTask.BANSHEE, SlayerTask.BAT, SlayerTask.BEAR, SlayerTask.BIRD, SlayerTask.CAVE_BUG, SlayerTask.CAVE_SLIME, SlayerTask.COW, SlayerTask.CRAWLING_HAND, SlayerTask.DESERT_LIZARD, SlayerTask.DOG, SlayerTask.DWARF, SlayerTask.GHOST, SlayerTask.GOBLIN, SlayerTask.ICEFIEND, SlayerTask.MINOTAUR, SlayerTask.MONKEY, SlayerTask.PIG, SlayerTask.SCORPION, SlayerTask.SKELETON, SlayerTask.SPIDER, SlayerTask.TROLL, SlayerTask.WOLF, SlayerTask.ZOMBIE),
		//done
		TURAEL(8480, 3, 1, new int[]
		{ 0, 0, 0 }, new int[]
		{ 15, 50 }, SlayerTask.BANSHEE, SlayerTask.BAT, SlayerTask.BEAR, SlayerTask.BIRD, SlayerTask.CAVE_BUG, SlayerTask.CAVE_SLIME, SlayerTask.COW, SlayerTask.CRAWLING_HAND, SlayerTask.DESERT_LIZARD, SlayerTask.DOG, SlayerTask.DWARF, SlayerTask.GHOST, SlayerTask.GOBLIN, SlayerTask.ICEFIEND, SlayerTask.MINOTAUR, SlayerTask.MONKEY, SlayerTask.PIG, SlayerTask.SCORPION, SlayerTask.SKELETON, SlayerTask.SPIDER, SlayerTask.TROLL, SlayerTask.WOLF, SlayerTask.ZOMBIE),
		//done
		MAZCHNA(8481, 20, 1, new int[]
		{ 2, 5, 15 }, new int[]
		{ 40, 85 }, SlayerTask.BANSHEE, SlayerTask.BAT, SlayerTask.BEAR, SlayerTask.CATABLEPON, SlayerTask.CAVE_CRAWLER, SlayerTask.CAVE_SLIME, SlayerTask.COCKATRICE, SlayerTask.CRAWLING_HAND, SlayerTask.CYCLOPS, SlayerTask.DESERT_LIZARD, SlayerTask.DOG, SlayerTask.FLESH_CRAWLER, SlayerTask.GHOUL, SlayerTask.GHOST, SlayerTask.GROTWORM, SlayerTask.HILL_GIANT, SlayerTask.HOBGOBLIN, SlayerTask.ICE_WARRIOR, SlayerTask.KALPHITE, SlayerTask.PYREFIEND, SlayerTask.ROCKSLUG, SlayerTask.SKELETON, SlayerTask.VAMPYRE, SlayerTask.WALL_BEAST, SlayerTask.WOLF, SlayerTask.ZOMBIE),
		//done
		ACHTRYN(8465, 20, 1, new int[]
		{ 2, 5, 15 }, new int[]
		{ 40, 85 }, SlayerTask.BANSHEE, SlayerTask.BAT, SlayerTask.BEAR, SlayerTask.CATABLEPON, SlayerTask.CAVE_CRAWLER, SlayerTask.CAVE_SLIME, SlayerTask.COCKATRICE, SlayerTask.CRAWLING_HAND, SlayerTask.CYCLOPS, SlayerTask.DESERT_LIZARD, SlayerTask.DOG, SlayerTask.FLESH_CRAWLER, SlayerTask.GHOUL, SlayerTask.GHOST, SlayerTask.GROTWORM, SlayerTask.HILL_GIANT, SlayerTask.HOBGOBLIN, SlayerTask.ICE_WARRIOR, SlayerTask.KALPHITE, SlayerTask.PYREFIEND, SlayerTask.ROCKSLUG, SlayerTask.SKELETON, SlayerTask.VAMPYRE, SlayerTask.WALL_BEAST, SlayerTask.WOLF, SlayerTask.ZOMBIE),
		//done
		VANNAKA(1597, 40, 1, new int[]
		{ 4, 20, 60 }, new int[]
		{ 60, 120 }, SlayerTask.ABERRANT_SPECTRE, SlayerTask.ANKOU, SlayerTask.BANSHEE, SlayerTask.BASILISK, SlayerTask.BLOODVELD, SlayerTask.BRINE_RAT, SlayerTask.COCKATRICE, SlayerTask.CROCODILE, SlayerTask.CYCLOPS, SlayerTask.DUST_DEVIL, SlayerTask.EARTH_WARRIOR, SlayerTask.GHOUL, SlayerTask.GREEN_DRAGON, SlayerTask.GROTWORM, SlayerTask.HARPIE_BUG_SWARM, SlayerTask.HILL_GIANT, SlayerTask.ICE_GIANT, SlayerTask.ICE_WARRIOR, SlayerTask.INFERNAL_MAGE, SlayerTask.JELLY, SlayerTask.JUNGLE_HORROR, SlayerTask.LESSER_DEMON, SlayerTask.MOLANISK, SlayerTask.MOSS_GIANT, SlayerTask.OGRE, SlayerTask.OTHERWORLDLY_BEING, SlayerTask.PYREFIEND, SlayerTask.SHADE, SlayerTask.SHADOW_WARRIOR, SlayerTask.TROLL, SlayerTask.TUROTH, SlayerTask.VAMPYRE, SlayerTask.WEREWOLF),
		//done
		CHAELDAR(1598, 70, 1, new int[]
		{ 10, 50, 100 }, new int[]
		{ 110, 170 }, SlayerTask.ABERRANT_SPECTRE, SlayerTask.BANSHEE, SlayerTask.BASILISK, SlayerTask.BLOODVELD, SlayerTask.BLUE_DRAGON, SlayerTask.BRINE_RAT, SlayerTask.BRONZE_DRAGON, SlayerTask.CAVE_CRAWLER, SlayerTask.CAVE_HORROR, SlayerTask.CRAWLING_HAND, SlayerTask.DAGANNOTH, SlayerTask.DUST_DEVIL, /*SlayerTask.ELF_WARRIOR*/ SlayerTask.FEVER_SPIDER, SlayerTask.FIRE_GIANT, SlayerTask.FUNGAL_MAGE, SlayerTask.GARGOYLE, SlayerTask.GRIFOLAPINE, SlayerTask.GRIFOLAROO, SlayerTask.GROTWORM, SlayerTask.HARPIE_BUG_SWARM, SlayerTask.JUNGLE_STRYKEWYRM, SlayerTask.INFERNAL_MAGE, SlayerTask.JELLY, SlayerTask.JUNGLE_HORROR, SlayerTask.KALPHITE, SlayerTask.KURASK, SlayerTask.LESSER_DEMON, SlayerTask.ZYGOMITE, SlayerTask.SHADOW_WARRIOR, SlayerTask.TROLL, SlayerTask.TUROTH, SlayerTask.VYREWATCH, SlayerTask.WARPED_TORTOISE),
		//done
		SUMONA(7780, 85, 35, new int[]
		{ 12, 60, 180 }, new int[]
		{ 120, 185 }, SlayerTask.ABERRANT_SPECTRE, SlayerTask.ABYSSAL_DEMON, SlayerTask.AQUANITE, SlayerTask.AUTOMATON, SlayerTask.BANSHEE, SlayerTask.BASILISK, SlayerTask.BLACK_DEMON, SlayerTask.BLOODVELD, SlayerTask.BLUE_DRAGON, SlayerTask.CAVE_CRAWLER, SlayerTask.CAVE_HORROR, SlayerTask.DAGANNOTH, SlayerTask.DESERT_STRYKEWYRM, SlayerTask.DUST_DEVIL, /*SlayerTask.ELF_WARRIOR*/ SlayerTask.FIRE_GIANT, SlayerTask.FUNGAL_MAGE, SlayerTask.GARGOYLE, SlayerTask.GREATER_DEMON, SlayerTask.GRIFOLAPINE, SlayerTask.GRIFOLAROO, SlayerTask.GROTWORM, SlayerTask.HELLHOUND, SlayerTask.IRON_DRAGON, SlayerTask.JUNGLE_STRYKEWYRM, SlayerTask.KALPHITE, SlayerTask.KURASK, SlayerTask.JADINKO, SlayerTask.NECHRYAEL, SlayerTask.RED_DRAGON, SlayerTask.SCABARITE, SlayerTask.SPIRITUAL_MAGE, SlayerTask.SPIRITUAL_WARRIOR, SlayerTask.TERROR_DOG, SlayerTask.TROLL, SlayerTask.TUROTH, SlayerTask.VYREWATCH, SlayerTask.WARPED_TORTOISE),
		//done
		DURADEL(8466, 100, 50, new int[]
		{ 15, 75, 225 }, new int[]
		{ 130, 200 }, SlayerTask.ABERRANT_SPECTRE, SlayerTask.ABYSSAL_DEMON, SlayerTask.AIRUT, SlayerTask.AQUANITE, SlayerTask.ASCENSION_MEMBERS, SlayerTask.AUTOMATON, SlayerTask.AVIANSIE, SlayerTask.BLACK_DEMON, SlayerTask.BLACK_DRAGON, SlayerTask.BLOODVELD, SlayerTask.DAGANNOTH, SlayerTask.DARK_BEAST, SlayerTask.DESERT_STRYKEWYRM, SlayerTask.DUST_DEVIL, SlayerTask.FIRE_GIANT, SlayerTask.FUNGAL_MAGE, SlayerTask.GANODERMIC, SlayerTask.GARGOYLE, SlayerTask.GORAK, SlayerTask.GREATER_DEMON, SlayerTask.GRIFALOPINE, SlayerTask.GRIFALOROO, SlayerTask.GROTWORM, SlayerTask.HELLHOUND, SlayerTask.ICE_STRYKEWYRM, SlayerTask.IRON_DRAGON, SlayerTask.JUNGLE_STRYKEWYRM, SlayerTask.KALPHITE, SlayerTask.MITHRIL_DRAGON, SlayerTask.JADINKO, SlayerTask.NECHRYAEL, SlayerTask.SCABARITE, SlayerTask.SKELETAL_WYVERN, SlayerTask.SPIRITUAL_MAGE, SlayerTask.STEEL_DRAGON, SlayerTask.SUQAH, SlayerTask.VYREWATCH, SlayerTask.WARPED_TERRORBIRD, SlayerTask.WATERFIEND),
		//done
		LAPALOK(8467, 100, 50, new int[]
		{ 15, 75, 225 }, new int[]
		{ 130, 200 }, SlayerTask.ABERRANT_SPECTRE, SlayerTask.ABYSSAL_DEMON, SlayerTask.AIRUT, SlayerTask.AQUANITE, SlayerTask.ASCENSION_MEMBERS, SlayerTask.AUTOMATON, SlayerTask.AVIANSIE, SlayerTask.BLACK_DEMON, SlayerTask.BLACK_DRAGON, SlayerTask.BLOODVELD, SlayerTask.DAGANNOTH, SlayerTask.DARK_BEAST, SlayerTask.DESERT_STRYKEWYRM, SlayerTask.DUST_DEVIL, SlayerTask.FIRE_GIANT, SlayerTask.FUNGAL_MAGE, SlayerTask.GANODERMIC, SlayerTask.GARGOYLE, SlayerTask.GORAK, SlayerTask.GREATER_DEMON, SlayerTask.GRIFALOPINE, SlayerTask.GRIFALOROO, SlayerTask.GROTWORM, SlayerTask.HELLHOUND, SlayerTask.ICE_STRYKEWYRM, SlayerTask.IRON_DRAGON, SlayerTask.JUNGLE_STRYKEWYRM, SlayerTask.KALPHITE, SlayerTask.MITHRIL_DRAGON, SlayerTask.JADINKO, SlayerTask.NECHRYAEL, SlayerTask.SCABARITE, SlayerTask.SKELETAL_WYVERN, SlayerTask.SPIRITUAL_MAGE, SlayerTask.STEEL_DRAGON, SlayerTask.SUQAH, SlayerTask.VYREWATCH, SlayerTask.WARPED_TERRORBIRD, SlayerTask.WATERFIEND),
		//done
		KURADAL(9085, 110, 75, new int[]
		{ 18, 90, 270 }, new int[]
		{ 120, 250 }, SlayerTask.ABERRANT_SPECTRE, SlayerTask.ABYSSAL_DEMON, SlayerTask.AIRUT, SlayerTask.ASCENSION_MEMBERS, SlayerTask.AUTOMATON, SlayerTask.AVIANSIE, SlayerTask.BLACK_DEMON, SlayerTask.BLACK_DRAGON, SlayerTask.BLOODVELD, SlayerTask.BLUE_DRAGON, SlayerTask.CELESTIAL_DRAGON, SlayerTask.DAGANNOTH, SlayerTask.DARK_BEAST, SlayerTask.DESERT_STRYKEWYRM, SlayerTask.DUST_DEVIL, SlayerTask.FIRE_GIANT, SlayerTask.GANODERMIC, SlayerTask.GARGOYLE, SlayerTask.GLACOR, SlayerTask.GRIFOLAPINE, SlayerTask.GRIFOLAROO, SlayerTask.GROTWORM, SlayerTask.HELLHOUND, SlayerTask.ICE_STRYKEWYRM, SlayerTask.IRON_DRAGON, SlayerTask.JUNGLE_STRYKEWYRM, SlayerTask.KALPHITE, SlayerTask.LAVA_STRYKEWYRM, SlayerTask.LIVING_ROCK, SlayerTask.MITHRIL_DRAGON, SlayerTask.JADINKO, SlayerTask.NECHRYAEL, SlayerTask.NIHIL, SlayerTask.SKELETAL_WYVERN, SlayerTask.SPIRITUAL_MAGE, SlayerTask.STEEL_DRAGON, SlayerTask.SUQAH, SlayerTask.TERROR_DOG, SlayerTask.TORMENTED_DEMON, SlayerTask.TZHAAR, SlayerTask.VYREWATCH, SlayerTask.WARPED_TORTOISE, SlayerTask.WATERFIEND /*, SlayerTask.ADAMANT_DRAGON, SlayerTask.EDIMMUS, SlayerTask.KALGERION_DEMON, SlayerTask.MUSPAH*/),
		
		MORVRAN(-1, 120, 85, new int[]
		{ 20, 100, 300 }, new int[]
		{ 130, 260 }, SlayerTask.ABYSSAL_DEMON);

		private SlayerTask[] task;
		private int[] tasksRange, pointsRange;
		private int requriedCombatLevel, requiredSlayerLevel, npcId;

		private SlayerMaster(int npcId, int requriedCombatLevel, int requiredSlayerLevel, int[] pointsRange, int[] tasksRange, SlayerTask... task) {
			this.npcId = npcId;
			this.requriedCombatLevel = requriedCombatLevel;
			this.requiredSlayerLevel = requiredSlayerLevel;
			this.pointsRange = pointsRange;
			this.tasksRange = tasksRange;
			this.task = task;
		}

		public int getNPCId() {
			return npcId;
		}

		public int getRequiredCombatLevel() {
			return requriedCombatLevel;
		}

		public int getRequiredSlayerLevel() {
			return requiredSlayerLevel;
		}

		public SlayerTask[] getTask() {
			return task;
		}

		public int[] getTasksRange() {
			return tasksRange;
		}

		public int[] getPointsRange() {
			return pointsRange;
		}

		public static boolean startInteractionForId(Player player, int npcId, int option) {
			for (SlayerMaster master : SlayerMaster.values()) {
				if (master.getNPCId() == npcId) {
					if (option == 1)
						player.getDialogueManager().startDialogue("SlayerMasterD", npcId, master);
					else if (option == 2)
						player.getDialogueManager().startDialogue("QuickTaskD", master);
					else if (option == 3)
						ShopsHandler.openShop(player, 29);
					else if (option == 4)
						player.getSlayerManager().sendSlayerInterface(SlayerManager.BUY_INTERFACE);
					return true;
				}
			}
			return false;
		}
	}

	public enum SlayerTask implements Serializable {// 79 matches out of 117
	    
	    	AIRUT(1, new String[] {
	    		"Airuts can be found west of the Phoenix lair and in Kuradal's dungeon."
	    	}),
	    	
		MIGHTY_BANSHEE(37, new String[] {}),
		
		BANSHEE(15, new String[] { 
			"Banshees require earmuffs to kill and can be found",
			"in Slayer tower and Pollnivneach slayer dungeon."}, MIGHTY_BANSHEE),
		
		BAT(1, new String[] {
			"Bats can be found in Taverly dungeon, around Slayer",
			"tower, and Keep le faye." }),

		AVIANSIE(1, 0.8, new String[] {
			"Aviansies can be found in God wars dungeon.  They requre a range weapon to",
			"be attacked."
		}),
		CHICKEN(1, new String[] {}),
		CHOMPY_BIRD(1, new String[] {}),
		DUCK(1, new String[] {}),

		BIRD(1, new String[]
		{
			"Birds are a type of species found throughout Runescape in different forms.",
			"It's recomended that you bring range weapons to fight these monsters.",
			"Avansies are the strongest and most widely known type of bird.",
			"Chickens are great for a fast task." }, AVIANSIE, CHICKEN, CHOMPY_BIRD, DUCK),
		
		BEAR(1, new String[] { 
			"Bears can be found east of Ardougne and in forests",
			"around Runescape." }),

		CAVE_BUG(7, new String[] {
			"Cave bugs can be found in Lumbridge swamp caves and Taverly slayer dungeon."
		}),

		CAVE_SLIME(17, new String[] {
			"Cave slime can be found in Lumbridge swamp caves.",
			"They are poisonous so it is recommended to bring antipoisons."
		}),
		
		COW(1, new String[] {
			"Cows can be found in Lumbridge and Taverly."
		}),

		ZOMBIE_HAND(5, new String[] {}),
		SKELETAL_HAND(5, new String[] {}),

		CRAWLING_HAND(5, new String[] {
			"Crawling hands can be found on the first floor of Slayer tower."
		}, ZOMBIE_HAND, SKELETAL_HAND),

		BLACK_GUARD(1, new String[] {}),
		
		DWARF(1, new String[] {
			"Dwarves can be found north of falador."
		}, BLACK_GUARD),

		LIZARD(22, null),

		DESERT_LIZARD(22, new String[] {
			"Desert lizards can only be slain using ice coolers, so buy a lot of them.",
			"They can be found east of Pollnivneach and are labelled on the map.",
			"A water source is recommended to deal with the desert heat."
		}, LIZARD),

		REVENANT(1, 0.65, new String[] {}),

		CAVE_GOBLIN_GUARD(1, new String[] {}),
		SERGEANT_GRIMSPIKE(1, new String[] {}),
		SERGEANT_STEELWILL(1, new String[] {}),
		SERGEANT_STRONGSTACK(1, new String[] {}),
		
		GOBLIN(1, new String[] {
			"Goblins can be found as low level as the ones in Lumbridge, or as high level",
			"as the sergeants of Bandos in God wars dungeon."
		}, CAVE_GOBLIN_GUARD, SERGEANT_GRIMSPIKE, SERGEANT_STEELWILL, SERGEANT_STRONGSTACK),

		ICEFIEND(1, new String[] {
			"Icefiends can be found on top of Ice mountain north of Falador.",
			"Higher level versions can be found in God wars dungeon."
		}),

		MINOTAUR(1, new String[] {
			"Minotaurs can be found in the Stronghold of security or in Turael's basement."
		}),
		
		MONKEY(1, new String[] {
			"Monkeys can be found all around Ape atoll."}),

		SCORPION(1, new String[] {
			"Scorpions can be found in the Dwarven mine underneath Falador."
		}),

		SKELETAL(1, new String[] {}),
		
		SKELETON(1, new String[] {
			"Skeletons can be found Taverly dungeon, Stronghold of security,",
			"and Edgeville dungeon."
		}, SKELETAL_HAND, SKELETAL),
		
		PIG(1, new String[] {
			"Pigs can be found at the farm south of Falador."
		}),

		SPIDER(1, new String[] {
			"Spiders can be found in Varrock sewers and the Stronghold of security."
		}),

		WOLF(1, new String[] {
			"Wolves can be found west of Taverly, atop White wolf mountain."
		}),

		ZOMBIE(1, new String[] {
			"Zombies can be found in Varrock sewer and Stronghold of security."
		}),

		CATABLEPON(1, new String[] {
			"Catablepons can be found in the Stronghold of security."
		}),

		CAVE_CRAWLER(10, new String[] {
			"Cave crawlers can be found in Fremennik slayer dungeon, Lumbridge",
			"swamp caves, and Pollnivneach slayer dungeon.",
			"They are poisonous so antipoisons are recommended."
		}),

		WILD_DOG(1, new String[] {}),
		JACKAL(1, new String[] {}),

		DOG(1, new String[] {}, JACKAL, WILD_DOG),

		FLESH_CRAWLER(1, new String[] {
			"Flesh crawlers can be found in the Stronghold of security."
		}),

		HOBGOBLIN(1, new String[] {
			"Hobgoblins can be found in Edgeville dungeon, God wars dungeon,",
			"and Asgarnian ice dungeon."
		}),

		KALPHITE(1, new String[] {
			"Kalphites can be found in the Exiled kalphite hive and the Kalphite",
			"hive."
		}),

		ROCKSLUG(20, new String[] {
			"Rockslugs can be found in Fremennik slayer dungeon and Lumbridge",
			"swamp caves."
		}),

		ROCK_SLUG(20, new String[] {
			"Rockslugs can be found in Fremennik slayer dungeon and Lumbridge",
			"swamp caves."
		}, ROCKSLUG),

		HOLE_IN_THE_WALL(35, new String[] {
			"Wall beasts are found in Lumbridge swamp caves.",
			"A spiny helmet is required to fight these beasts."
		}),

		WALL_BEAST(35, new String[] {
			"Wall beasts are found in Lumbridge swamp caves.",
			"A spiny helmet is required to fight these beasts."
		}, HOLE_IN_THE_WALL),

		ABERRANT_SPECTRE(60, new String[] {
			"Aberrant spectres can be found in Slayer tower and Pollnivneach",
			"slayer dungeon.  They have an extremely potent stench that drains",
			"stats and life points very quickly, so a nose peg is recommended."
		}),

		ANKOU(1, new String[] {
			"Ankou are found in the Stronghold of security and Forinthry dungeon."
		}),

		BASILISK(40, new String[] {
			"Baskilisks are found in Fremennik slayer dungeon and Pollnivneach slayer",
			"dungeon.  They require a mirror shield or equivalent to fight."
		}),

		BLOODVELD(50, new String[] {
			"Bloodvelds can be found in Slayer tower and God wars dungeon."
		}),

		BRINE_RAT(47, new String[] {
			"Brine rats can be found northwest of the Fremennik lodestone.",
			"A spade is required to gain entrance to their lair.",
			"Dig near a little tree east of the dock atop the snow."
		}),

		COCKATRICE(25, new String[] {
			"Cockatrice are found exclusively in Fremennik slayer dungeon.",
			"They have a stat draining attack, so protection in the form of a",
			"Mirror shield, Mask of stone, or Mask of reflection is advised."
		}),

		CROCODILE(1, 0.5, new String[] {
			"Crocodiles can be found near water in the Kharidian desert.",
			"A water source is recommended to deal with the desert heat."
		}),

		CYCLOPS(1, new String[] {
			"Cycopses can be found in the Warrior's guild, God wars dungeon,",
			"and the Ardougne zoo."
		}),

		CYCLOPSE(1, new String[] {
			"Cycopses can be found in the Warrior's guild, God wars dungeon,",
			"and the Ardougne zoo."
		}, CYCLOPS),

		DUST_DEVIL(65, new String[] {
			"Dust devils can be found in the Smoke dungeon and Chaos tunnels.",
			"A face mask or equivalent is required to kill them."
		}),

		EARTH_WARRIOR(1, 0.5, new String[] {
			"Earth warriors can be found in Edgeville dungeon and Chaos dungeon."
		}),

		GHOUL(1, new String[] {
			"Ghouls can be found west and north of Canifis."
		}),

		GREEN_DRAGON(1, new String[] {
			"Green dragons can be found in Forinthry dungeon and plenty in the",
			"Wilderness.  An anti-dragon/dragonfire shield is highly recommended."
		}),

		YOUNG_GROTWORM(1, new String[] {}),
		GIANT_WORM(1, new String[] {}),
		MATURE_GROTWORM(1, new String[] {}),
		
		GROTWORM(1, 0.64, new String[] {}, YOUNG_GROTWORM, GIANT_WORM, MATURE_GROTWORM),

		HARPIE_BUG_SWARM(33, new String[] {
			"Harpie bug swarms can be found east of the Jogre dungeon on Karamja.",
			"A lit bug lantern must be equipped to deal any damage to them."
		}),

		HILL_GIANT(1, new String[] {
			"Hill giants can be found in Edgeville dungeon and Taverly dungeon."
		}),

		ICE_GIANT(1, new String[] {
			"Ice giants can be found in Asgarnian ice dungeon, Chaos tunnels, and atop",
			"White wolf mountain."
		}),

		ICE_WARRIOR(1, new String[] {
			"Ice warriors can be found on White wolf mountain and Asgarnian",
			"ice dungeon."
		}),

		INFERNAL_MAGE(45, new String[] {
			"Infernal magi are found in Slayer tower and Chaos tunnels."
		}),

		JELLY(52, new String[] {
			"Jellies can be found in Fremennik slayer dungeon and Chaos tunnels."
		}),

		CAVE_HORROR(58, new String[] {
			"Cave horrors can be found on the island of Mos Le'Harmless.",
			"A Witchwood icon and a light source are essential to fighting them."
		}),
		
		JUNGLE_HORROR(1, 0.64, new String[] {
			"Jungle horrors can be found on the island of Mos Le'Harmless.",
			"If you wish to fight Cave horrors, a Witchwood icon and a light source",
			"are essential."
		}, CAVE_HORROR),

		LESSER_DEMON(1, new String[] {
			"Lesser demons can be found in Forinthry dungeon, Taverly dungeon,",
			"and throughout the Wilderness."
		}),

		MOLANISK(39, new String[] {
			"Molanisks can be found in the Dorgesh-Kaan south dungeon.",
			"A Slayer bell is necessary to fight them."
		}),

		MOSS_GIANT(1, new String[] {
			"Moss giants can be found in Varrock sewers, Brimhaven dungeon, and",
			"Chaos tunnels."
		}),

		OGRE(1, new String[] {
			"Ogres can be found by Gu'Tanoth, south of Yanille."
		}),

		OTHERWORLDLY_BEING(1, new String[] {
			"Otherworldly beings can be found south-west of Zanaris."
		}),

		PYREFIEND(30, new String[] {
			"Pyrefiends can be found in Fremennik slayer dungeon and God wars",
			"dungeon."
		}),

		SHADE(1, new String[] {
			"Shades are found lurking around Mort'ton and the nearby swamps."
		}),

		SHADOW_WARRIOR(1, new String[] {
			"Shadow warriors can be found in the basement of the Legend's guild."
		}),

		TUROTH(55, new String[] {
			"Turoths can be found in the Fremennik slayer dungeon, Chaos tunnels,",
			"and the Pollnivneach slayer dungeon.  A leaf-blade spear, a leaf-bladed",
			"sword, a Slayer Dart spell, or broad arrows/bolts are required to hurt them.",
		}),

		VAMPYRE(1, new String[] {
			"Feral vampyres are found in the Haunted woords east of Canifis.",
		}),

		WEREWOLF(1, new String[] {
			"Werewolves can be found in Canifis."
		}),

		BLUE_DRAGON(1, 0.8, new String[] {
			"Blue dragons can be found in Taverly dungeon and Kuradal's dungeon.",
			"An anti-dragon/dragonfire shield is highly recommended."
		}),

		BRONZE_DRAGON(1, 0.35, new String[] {
			"Bronze dragons can be found in Brimhaven dungeon and the Chaos tunnels.",
			"An anti-dragon/dragonfire shield along with an antifire is highly recommended."
		}),

		DAGANNOTH(1, 0.96, new String[] {
			"Dagannoths can be found in the Lighthouse basement."
		}),

		//not finished
		//ELF_WARRIOR(1, 0.49, new String[] {}),

		FEVER_SPIDER(42, new String[] {
			"Fever spiders can be found in the brewery basement on Braindeath island.",
			"Slayer gloves must be worn while fighting them."
		}),

		FIRE_GIANT(1, new String[] {
			"Fire giants can be found in Waterfall dungeon, Chaos tunnels, and Brimhaven dungeon."
		}),

		FUNGAL_MAGE(1, new String[] {
			"Fungal magi can be found in Polypore dungeon.",
			"Getting close to them can be dangerous without the use of neem oil."
		}),

		GARGOYLE(75, new String[] {
			"Gargoyles can be found in Kuradal's dungeon, Choas tunnels, and Slayer tower."
		}),

		GRIFOLAPINE(88, 0.316, new String[] {
			"Grifolapines can be found in Polypore dungeon.  Neem oil or attacking from range",
			"is recommended when fighting them."
		}),

		GRIFOLAROO(82, 0.316, new String[] {
			"Grifolaroos can be found in Polypore dungeon."
		}),

		GRIFALOPINE(88, 0.316, new String[] {
			"Grifolapines can be found in Polypore dungeon.  Neem oil or attacking from range",
			"is recommended when fighting them."
		}, GRIFOLAPINE),

		GRIFALOROO(82, 0.316, new String[] {
			"Grifolaroos can be found in Polypore dungeon."
		}, GRIFOLAROO),

		JUNGLE_STRYKEWYRM(73, new String[] {
			"Jungle strykewyrms can be found north-east of Mobilising armies."
		}),

		KURASK(70, new String[] {
			"Kurasks can be found in Fremennik slayer dungeon and Pollnivneach slayer dungeon.",
			"They must be slain with either a leaf-bladed sword, leaf-bladed spear, a Slayer dart",
			"spell, or broad arrows/bolts."
		}),

		FUNGI(57, 0.81, new String[] {}),

		ZYGOMITE(57, new String[] {
			"Zygomites appear as Fungi until provoked.  They can be found in Zanaris, near the",
			"Cosmic altar.  Fungicide spray is required to kill them."
		}, FUNGI),

		VYRELORD(31, 0.68, new String[] {}),
		VYRELADY(31, 0.68, new String[] {}),
		
		VYREWATCH(31, 0.68, new String[] {
			"Vyrewatch can be found east of Burgh de Rott, in Meiyerditch, and Darkmeyer."
		}, VYRELORD, VYRELADY),

		WARPED_TORTOISE(56, new String[] {
			"Warped tortoises can be found in the Poison waste slayer dungeon, west of Castle",
			"wars.  A crossbow and Mitril grapple is required to get there.  A crystal chime",
			"is required to deal damage to them."
		}),

		ABYSSAL_DEMON(85, new String[] {
			"Abyssal demons can be found in Slayer tower and Kuradal's dungeon."
		}),

		AQUANITE(78, 0.96, new String[] {
			"Aquanites can be found at the end of Fremennik slayer dungeon."
		}),

		AUTOMATON(67, new String[] {
			"Automatons can be found in Guthix's cave, west of Legends' guild."
		}),
		
		BLACK_DEMON(1, new String[] {
			"Black demons can be found in Taverly dungeon, Brimhaven dungeon, and the",
			"Chaos tunnels."
		}),

		DESERT_STRYKEWYRM(77, 0.64, new String[] {
			"Desert strykewyrms are found east of Al Kharid."
		}),

		GREATER_DEMON(1, new String[] {
			"Greater demons can be found in Brimhaven dungeon, Forinthry dungeon, Kuradal's",
			"dungeon, and throughout the Wilderness."
		}),

		HELLHOUND(1, 0.92, new String[] {
			"Hellhounds can be found in Taverly dungeon, God wars dungeon, and Forinthry",
			"dungeon."
		}),

		IRON_DRAGON(1, 0.468, new String[] {
			"Iron dragons can be found in Brimhaven dungeon and Kuradal's dungeon.",
			"An anti-dragon/dragonfire shield along with an antifire is highly recommended."
		}),
		
		MUTATED_JADINKO_MALE(91, 0.88, new String[] {}),
		MUTATED_JADINKO_GAURD(86, 0.88, new String[] {}),
		MUTATED_JADINKO_BABY(80, 0.88, new String[] {}),

		JADINKO(1, 0.88, new String[] {
			"Jadinkos can be found in the Jadinko lair, east of Shilo village."
		}, MUTATED_JADINKO_MALE, MUTATED_JADINKO_GAURD, MUTATED_JADINKO_BABY),
		
		NECHRYAEL(80, 0.88, new String[] {
			"Nechryaels can be found in Slayer tower and the Chaos tunnels."
		}),

		RED_DRAGON(1, 0.43, new String[] {
			"Red dragons can be found in Brimhaven dungeon.",
			"An anti-dragon/dragonfire shield is highly recommended."
		}),

		LOCUST(1, 0.4, new String[] {}),
		SCABARAS(1, 0.4, new String[] {}),
		SCARAB(1, 0.4, new String[] {}),
		
		SCABARITE(1, 0.4, new String[] {
			"Scabarites can be found in Sophanem dungeon"
		}, LOCUST, SCABARAS, SCARAB),

		SPIRITUAL_MAGE(83, 0.96, new String[] {
			"Spiritual mages can be found in God wars dungeon."
		}),

		SPIRITUAL_WARRIOR(68, new String[] {
			"Spiritual mages can be found in God wars dungeon."
		}),

		TERROR_DOG(40, 0.28, new String[] {
			"Terror dogs can be found in Tarn's lair."
		}),

		ROCK(1, 1.033, new String[] {}),
		
		TROLL(1, 1.033, new String[] {
			"Trolls can be found around Death plateau, north of Burthorpe."
		}, ROCK),
		
		RORARIUS(1, new String[] {}),
		GLADIUS(1, new String[] {}),
		CAPSARIUS(1, new String[] {}),
		SCUTARIUS(1, new String[] {}),
		LEGIO_PRIMUS(1, new String[] {}),
		LEGIO_SECUNDUS(1, new String[] {}),
		LEGION_TERTIUS(1, new String[] {}),
		LEGION_QUARTUS(1, new String[] {}),
		LEGION_QUINTUS(1, new String[] {}),
		LEGIO_SEXTUS(1, new String[] {}),
		
		ASCENSION_MEMBERS(1, new String[] {
			"The Order of Ascension can be found the Monastery of ascension, beneath Feldip hills."
		}),

		BLACK_DRAGON(1, 0.36, new String[] {
			"Black dragons can be found in Taverly dungeon.",
			"An anti-dragon/dragonfire shield is highly recommended."
		}),
		
		CELESTIAL_DRAGON(1, 0.36, new String[] {
			"Celestial dragons can be found in the Dragontooth island resource dungeon.",
			"An anti-dragon/dragonfire shield aswell as an antifire is highly recommended."
		}),

		DARK_BEAST(90, new String[] {
			"Dark beasts can be found in Kuradal's dungeon."
		}),

		GANODERMIC(95, 0.356, new String[] {
			"Ganodermic creatures can be found on the lower levels of the Polypore dungeon."
		}),

		GORAK(1, 0.4, new String[] {
			"Goraks can be found in God wars dungeon and the Gorak plane.  The Gorak",
			"plane can be accessed by fairy ring code d-i-r."
		}),

		ICE_STRYKEWYRM(93, 0.64, new String[] {
			"Ice strykewyrms can be found in a cave northeast of the Rellekka lodestone."
		}),

		MITHRIL_DRAGON(1, 0.136, new String[] {
			"Mithril dragons can be found in the Ancient cavern and Brimhaven resource dungeon.",
			"An anti-dragon/dragonfire shield along with an antifire is highly recommended."
		}),

		SKELETAL_WYVERN(72, 0.36, new String[] {
			"Skeletal wyverns can be found in the Asgarnian ice dungeon.  A dragonfire shield",
			"or elemental shield ir required to negate their breath.  Wyrmfire potions are also",
			"effective."
		}),

		STEEL_DRAGON(1, 0.432, new String[] {
			"Steel dragons can be found in Kuradal's dungeon and Brimhaven dungeon.",
			"An anti-dragon/dragonfire shield along with an antifire is highly recommended."
		}),

		SUQAH(1, 0.4, new String[] {
			"Suqah can be found on Lunar isle."
		}),

		WARPED_TERRORBIRD(56, new String[] {
			"Warped terrorbirds can be found in the Poison waste slayer dungeon.",
			"They require a Crystal chime to be killed."
		}),

		WATERFIEND(1, new String[] {
			"Waterfiends can be found in the Ancient cavern and Chaos tunnels."
		}),

		LIVING_ROCK(1, 0.74, new String[] {
			"Living rock cratures can be found in Living rock caverns."
		}),
		
		LAVA_STRYKEWYRM(94, 0.60, new String[] {
			"Lava strykewyrms can be found in the Wilderness, south of the Lava maze."
		}),
		
		GHOST(1, new String[] {
			"Ghosts come in many forms such as Revenants and Aberrant spectres.",
			"They can be found in Varrock sewers and Taverly dungeon."
		}, REVENANT, ABERRANT_SPECTRE),
		
		TORMENTED_DEMON(1, 0.30, new String[] {
			"Tormented demons can be found in the Ancient guthix temple."
		}),

		TZHAAR(1, 0.44, new String[] {
			"TzHaar are a race that inhabit the TzHaar city."
		}),
		
		NEX(1, new String[] {}),
		
		NIHIL(76, 0.60, new String[] {
			"Nihils can be found in Freneskae."
		}),
		
		GLACOR(1, 0.10, new String[] {
			"Glacors can be found in Glacor cave.  They can be reached with fairy ring code",
			"d-k-q."
		}),
		
		ADAMANT_DRAGON(90, 0.30, new String[] {
			"Adamant dragons can be found in the Adamant dragon dungeon inside Brimhaven",
			"dungeon."
		}),
		
		CHAOS_GIANT(1, 0.60, new String[] {
			"Chaos giants can be found in a cave at the end of the Barendir caves."
		}),
		
		KALGERION_DEMON(90, 0.60, new String[] {
			"Kal'gerion demons can be found by Daemonheim in the Kal'gerion resource",
			"dungeon."
		}),
		
		//todo
		//MUSPAH
		
		EDIMMU(90, new String[] {
			"Edimmu are found in the Edimmu resource dungeon if Prifddinas."
		});

		private String[] tips;
		private double taskFactor;
		private SlayerTask[] alternatives;
		private int levelRequried;

		private SlayerTask(int levelRequried, double taskFactor, String[] tips, SlayerTask... alternatives) {
			this.levelRequried = levelRequried;
			this.taskFactor = taskFactor;
			this.tips = tips;
			this.alternatives = alternatives;
		}

		private SlayerTask(int levelRequried, String[] tips, SlayerTask... alternatives) {
			this(levelRequried, 1, tips, alternatives);
		}

		public String[] getTips() {
			return tips;
		}

		public SlayerTask[] getAlternatives() {
			return alternatives;
		}

		public int getLevelRequried() {
			return levelRequried;
		}

		public String getName() {
			return Utils.formatPlayerNameForDisplay(toString());
		}

		public double getTaskFactor() {
			return taskFactor;
		}
	}

	public static boolean canAttackNPC(int slayerLevel, String name) {
		return slayerLevel >= getLevelRequirement(name);
	}

	public static int getLevelRequirement(String name) {
		for (SlayerTask task : SlayerTask.values()) {
			if (name.toLowerCase().contains(task.toString().replace("_", " ").toLowerCase()))
				return task.getLevelRequried();
		}
		return 1;
	}

	public static boolean hasNosepeg(Entity target) {
		if (!(target instanceof Player))
			return true;
		Player targetPlayer = (Player) target;
		int hat = targetPlayer.getEquipment().getHatId();
		return hat == 4168 || hasSlayerHelmet(target);
	}

	public static boolean hasEarmuffs(Entity target) {
		if (!(target instanceof Player))
			return true;
		Player targetPlayer = (Player) target;
		int hat = targetPlayer.getEquipment().getHatId();
		return hat == 4166 || hat == 13277 || hasSlayerHelmet(target);
	}

	public static boolean hasMask(Entity target) {
		if (!(target instanceof Player))
			return true;
		Player targetPlayer = (Player) target;
		int hat = targetPlayer.getEquipment().getHatId();
		return hat == 1506 || hat == 4164 || hat == 13277 || hasSlayerHelmet(target);
	}

	public static boolean hasWitchWoodIcon(Entity target) {
		if (!(target instanceof Player))
			return true;
		Player targetPlayer = (Player) target;
		int hat = targetPlayer.getEquipment().getAmuletId();
		return hat == 8923;
	}

	public static boolean hasSlayerHelmet(Entity target) {
		if (!(target instanceof Player))
			return true;
		Player targetPlayer = (Player) target;
		int hat = targetPlayer.getEquipment().getHatId();
		return hat == 13263 || hat == 14636 || hat == 14637 || hasFullSlayerHelmet(target);
	}

	public static boolean hasFullSlayerHelmet(Entity target) {
		if (!(target instanceof Player))
			return true;
		Player targetPlayer = (Player) target;
		int hat = targetPlayer.getEquipment().getHatId();
		return hat == 15492 || hat == 15496 || hat == 15497 || (hat >= 22528 && hat <= 22550);
	}

	public static boolean hasReflectiveEquipment(Entity target) {
		if (!(target instanceof Player))
			return true;
		Player targetPlayer = (Player) target;
		int shieldId = targetPlayer.getEquipment().getShieldId();
		return shieldId == 4156;
	}

	public static boolean hasSpinyHelmet(Entity target) {
		if (!(target instanceof Player))
			return true;
		Player targetPlayer = (Player) target;
		int hat = targetPlayer.getEquipment().getHatId();
		return hat == 4551 || hasSlayerHelmet(target);
	}

	public static boolean isUsingBell(final Player player) {
		player.lock(3);
		player.setNextAnimation(new Animation(6083));
		List<WorldObject> objects = World.getRegion(player.getRegionId()).getAllObjects();
		if (objects == null)
			return false;
		for (final WorldObject object : objects) {
			if (!object.withinDistance(player, 3) || object.getId() != 22545)
				continue;
			player.getPackets().sendGameMessage("The bell re-sounds loudly throughout the cavern.");
			WorldTasksManager.schedule(new WorldTask() {

				@Override
				public void run() {
					NPC npc = World.spawnNPC(5751, player, -1, true);
					npc.getCombat().setTarget(player);
					WorldObject o = new WorldObject(object);
					o.setId(22544);
					World.spawnObjectTemporary(o, 30000);
				}
			}, 1);
			return true;
		}
		return false;
	}

	public static boolean isBlackMask(int requestedId) {
		return requestedId >= 8901 && requestedId <= 8920;
	}

	private static final int[] SLAYER_HELMET_PARTS =
	{ 8921, 4166, 4164, 4551, 4168 };
	private static final int[] FULL_SLAYER_HELMET_PARTS =
	{ 13263, 15490, 15488 };

	public static boolean createSlayerHelmet(Player player, int itemUsed, int itemUsedWith) {
		if (itemUsed == itemUsedWith)
			return false;
		boolean firstCycle = false, secondCycle = false, full = false;
		for (int parts : SLAYER_HELMET_PARTS) {
			if (itemUsed == parts)
				firstCycle = true;
			if (itemUsedWith == parts)
				secondCycle = true;
		}
		if (!firstCycle || !secondCycle) {
			firstCycle = false;
			secondCycle = false;
			for (int parts : FULL_SLAYER_HELMET_PARTS) {
				if (itemUsed == parts)
					firstCycle = true;
				if (itemUsedWith == parts)
					secondCycle = true;
			}
			full = true;
		}
		if (firstCycle && secondCycle) {
			if (!player.getSlayerManager().hasLearnedSlayerHelmet()) {
				player.getPackets().sendGameMessage("You don't know what to do with these parts. You should talk to an expert, perhaps they know how to assemble these parts.");
				return false;
			} else if (player.getSkills().getLevel(Skills.CRAFTING) < 55) {
				player.getPackets().sendGameMessage("You need a Crafting level of 55 in order to assemble a slayer helmet.");
				return false;
			}
			for (int parts : (full ? FULL_SLAYER_HELMET_PARTS : SLAYER_HELMET_PARTS))
				if (!player.getInventory().containsItem(parts, 1))
					return false;
			for (int parts : (full ? FULL_SLAYER_HELMET_PARTS : SLAYER_HELMET_PARTS))
				player.getInventory().deleteItem(parts, 1);
			player.getInventory().addItem(new Item(full ? 15492 : FULL_SLAYER_HELMET_PARTS[0], 1));
			player.getPackets().sendGameMessage(full ? "You attach two parts to your slayer helmet." : "You combine all parts of the helmet.");
			return true;
		}
		return false;
	}

	public static void dissasembleSlayerHelmet(Player player, boolean full) {
		if (!(player.getInventory().getFreeSlots() >= (full ? 2 : 4))) {
			player.getPackets().sendGameMessage("You don't have enough space in your inventory to dissassemble the helmet.");
			return;
		}
		player.getInventory().deleteItem(full ? 15492 : 13263, 1);
		if (full) {
			for (int parts : FULL_SLAYER_HELMET_PARTS)
				player.getInventory().addItemDrop(parts, 1);
		} else {
			for (int parts : SLAYER_HELMET_PARTS)
				player.getInventory().addItemDrop(parts, 1);
		}
	}

	public static boolean isSlayerHelmet(Item item) {
		return item.getName().toLowerCase().contains("slayer helm");
	}
}
