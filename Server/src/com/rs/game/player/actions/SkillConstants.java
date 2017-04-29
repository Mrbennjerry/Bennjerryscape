package com.rs.game.player.actions.skills;

import com.rs.game.item.Item;

public class SkillConstants {
    
    public static final int NEEDLE = 1733, THREAD = 1734;
    
    public static int[] antiUseWith = { 1741, 1743, 6289, 25610, 1745, 2505, 2507, 2509, 24374 }; 
    public static int[] antiUse = { 319, 21776, 1511, 1513, 1515, 1517, 1519, 1521, 1973, 2309 };
    
    public enum Constants {
	
	/*
	 * Order exceptions
	 */
	
	/*
	 * Cooking recipes
	 */
	
	BREAD_DOUGH(1, 1, Skills.COOKING, new Item[] { new Item(1933), new Item(1937) }, new Item(2307), -1, 2, -1),
	//PASTRY_DOUGH(10, 1),
	//PIZZA_DOUGH(35, 1),
	//PITTA_DOUGH(58, 1),
	
	/*
	 * Spinning wheel
	 */
	
	WOOL(1, 2.5, Skills.CRAFTING, new Item[] { new Item(1737) }, new Item(1759), -1, 2, 25824),
	BOWSTRING(1, 15, Skills.CRAFTING, new Item[] { new Item(1779) }, new Item(1777), -1, 2, 25824),
	CROSSBOWSTRING(10, 15, Skills.CRAFTING, new Item[] { new Item(9436) }, new Item(9438), -1, 2, 25824),
	MAGICSTRING(19, 30, Skills.CRAFTING, new Item[] { new Item(6051) }, new Item(6038), -1, 2, 25824),
	ROPE(30, 25, Skills.CRAFTING, new Item[] { new Item(10814) }, new Item(954), -1, 2, 25824),
	
	/**
	 * Clay mould
	 */
	
	RING_UNFIRED(1, 11.3, Skills.CRAFTING, new Item[] { new Item(1761) }, new Item(20052), -1, 2, -1),
	
	/**
	 * Pottery oven
	 */
	
	RING(4, 11, Skills.CRAFTING, new Item[] { new Item(20052) }, new Item(20053), -1, 2, 11601),
	
	POT(1, 6.3, Skills.CRAFTING, new Item[] { new Item(1787) }, new Item(1931), 896, 2, 11601),
	PIE(7, 10, Skills.CRAFTING, new Item[] { new Item(1789) }, new Item(2313), 896, 2, 11601),
	BOWL(8, 15, Skills.CRAFTING, new Item[] { new Item(1791) }, new Item(1923), 896, 2, 11601),
	PLANT(19, 17.5, Skills.CRAFTING, new Item[] { new Item(5352) }, new Item(5350), 896, 2, 11601),
	LID(25, 20, Skills.CRAFTING, new Item[] { new Item(4438) }, new Item(4440), 896, 2, 11601),
	
	CRACKED_COOKING(2, 18, Skills.CRAFTING, new Item[] { new Item(20349) }, new Item(20350), 896, 2, 11601),
	FRAGILE_COOKING(12, 24, Skills.CRAFTING, new Item[] { new Item(20355) }, new Item(20356), 896, 2, 11601),
	COOKING(36, 42.9, Skills.CRAFTING, new Item[] { new Item(20361) }, new Item(20362), 896, 2, 11601),
	STRONG_COOKING(51, 52.5, Skills.CRAFTING, new Item[] { new Item(20367) }, new Item(20368), 896, 2, 11601),
	DECORATED_COOKING(81, 78, Skills.CRAFTING, new Item[] { new Item(20373) }, new Item(20374), 896, 2, 11601),
	
	CRACKED_FISHING(2, 18, Skills.CRAFTING, new Item[] { new Item(20319) }, new Item(20320), 896, 2, 11601),
	FRAGILE_FISHING(15, 30, Skills.CRAFTING, new Item[] { new Item(20325) }, new Item(20326), 896, 2, 11601),
	FISHING(41, 46.8, Skills.CRAFTING, new Item[] { new Item(20331) }, new Item(20332), 896, 2, 11601),
	STRONG_FISHING(53, 54, Skills.CRAFTING, new Item[] { new Item(20337) }, new Item(20338), 896, 2, 11601),
	DECORATED_FISHING(76, 72, Skills.CRAFTING, new Item[] { new Item(20343) }, new Item(20344), 896, 2, 11601),
	
	CRACKED_MINING(1, 16.8, Skills.CRAFTING, new Item[] { new Item(20379) }, new Item(20380), 896, 2, 11601),
	FRAGILE_MINING(17, 31.8, Skills.CRAFTING, new Item[] { new Item(20385) }, new Item(20386), 896, 2, 11601),
	MINING(32, 40.8, Skills.CRAFTING, new Item[] { new Item(20391) }, new Item(20392), 896, 2, 11601),
	STRONG_MINING(48, 49.2, Skills.CRAFTING, new Item[] { new Item(20397) }, new Item(20398), 896, 2, 11601),
	DECORATED_MINING(59, 57, Skills.CRAFTING, new Item[] { new Item(20403) }, new Item(20404), 896, 2, 11601),
	
	IMPIOUS(2, 18, Skills.CRAFTING, new Item[] { new Item(20409) }, new Item(20410), 896, 2, 11601),
	ACCURSED(26, 37.5, Skills.CRAFTING, new Item[] { new Item(20415) }, new Item(20416), 896, 2, 11601),
	INFERNAL(62, 60, Skills.CRAFTING, new Item[] { new Item(20421) }, new Item(20422), 896, 2, 11601),
	
	CRACKED_SMELTING(4, 23.1, Skills.CRAFTING, new Item[] { new Item(20271) }, new Item(20272), 896, 2, 11601),
	FRAGILE_SMELTING(17, 31.8, Skills.CRAFTING, new Item[] { new Item(20277) }, new Item(20278), 896, 2, 11601),
	SMELTING(35, 42, Skills.CRAFTING, new Item[] { new Item(20283) }, new Item(20284), 896, 2, 11601),
	STRONG_SMELTING(49, 50.1, Skills.CRAFTING, new Item[] { new Item(20289) }, new Item(20290), 896, 2, 11601),
	
	CRACKED_WOODCUTTING(4, 23.1, Skills.CRAFTING, new Item[] { new Item(20295) }, new Item(20296), 896, 2, 11601),
	FRAGILE_WOODCUTTING(15, 30, Skills.CRAFTING, new Item[] { new Item(20301) }, new Item(20302), 896, 2, 11601),
	WODDCUTTING(44, 48, Skills.CRAFTING, new Item[] { new Item(20307) }, new Item(20308), 896, 2, 11601),
	STRONG_WOODCUTTING(61, 58.2, Skills.CRAFTING, new Item[] { new Item(20313) }, new Item(20314), 896, 2, 11601),
	
	/**
	 * Pottery wheel
	 */
	
	POT_UNFIRED(1, 6.3, Skills.CRAFTING, new Item[] { new Item(1761) }, new Item(1787), 896, 2, 2642),
	PIE_UNFIRED(7, 15, Skills.CRAFTING, new Item[] { new Item(1761) }, new Item(1789), 896, 2, 2642),
	BOWL_UNFIRED(8, 18, Skills.CRAFTING, new Item[] { new Item(1761) }, new Item(1791), 896, 2, 2642),
	PLANT_UNFIRED(19, 20, Skills.CRAFTING, new Item[] { new Item(1761) }, new Item(5352), 896, 2, 2642),
	LID_UNFIRED(25, 20, Skills.CRAFTING, new Item[] { new Item(1761) }, new Item(4438), 896, 2, 2642),
	
	CRACKED_COOKING_UNFIRED(2, 12, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20349), 896, 2, 2642),
	FRAGILE_COOKING_UNFIRED(12, 16, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20355), 896, 2, 2642),
	COOKING_UNFIRED(36, 28.6, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20361), 896, 2, 2642),
	STRONG_COOKING_UNFIRED(51, 35, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20367), 896, 2, 2642),
	DECORATED_COOKING_UNFIRED(81, 52, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20373), 896, 2, 2642),
	
	CRACKED_FISHING_UNFIRED(2, 12, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20319), 896, 2, 2642),
	FRAGILE_FISHING_UNFIRED(15, 20, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20325), 896, 2, 2642),
	FISHING_UNFIRED(41, 31.2, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20331), 896, 2, 2642),
	STRONG_FISHING_UNFIRED(53, 36, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20337), 896, 2, 2642),
	DECORATED_FISHING_UNFIRED(76, 48, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20343), 896, 2, 2642),
	
	CRACKED_MINING_UNFIRED(1, 11.2, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20379), 896, 2, 2642),
	FRAGILE_MINING_UNFIRED(17, 21.2, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20385), 896, 2, 2642),
	MINING_UNFIRED(32, 27.2, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20391), 896, 2, 2642),
	STRONG_MINING_UNFIRED(48, 30.8, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20397), 896, 2, 2642),
	DECORATED_MINING_UNFIRED(59, 38, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20403), 896, 2, 2642),
	
	IMPIOUS_UNFIRED(2, 12, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20409), 896, 2, 2642),
	ACCURSED_UNFIRED(26, 25, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20415), 896, 2, 2642),
	INFERNAL_UNFIRED(62, 40, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20421), 896, 2, 2642),
	
	CRACKED_SMELTING_UNFIRED(4, 15.4, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20271), 896, 2, 2642),
	FRAGILE_SMELTING_UNFIRED(17, 21.2, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20277), 896, 2, 2642),
	SMELTING_UNFIRED(35, 28, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20283), 896, 2, 2642),
	STRONG_SMELTING_UNFIRED(49, 33.4, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20289), 896, 2, 2642),
	
	CRACKED_WOODCUTTING_UNFIRED(4, 15.4, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20295), 896, 2, 2642),
	FRAGILE_WOODCUTTING_UNFIRED(15, 20, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20301), 896, 2, 2642),
	WODDCUTTING_UNFIRED(44, 32, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20307), 896, 2, 2642),
	STRONG_WOODCUTTING_UNFIRED(61, 38.8, Skills.CRAFTING, new Item[] { new Item(1761, 2) }, new Item(20313), 896, 2, 2642),
	
	/*
	 * Tanning
	 */
	
	LEATHER(1, 0, Skills.CRAFTING, new Item[] { new Item(1739) }, new Item(1741), -1, 0, -1),
	HARDLEATHER(2, 0, Skills.CRAFTING, new Item[] { new Item(1739), new Item(995, 3) }, new Item(1743), -1, 0, -1),
	SNAKESKIN(2, 0, Skills.CRAFTING, new Item[] { new Item(6287), new Item(995, 15) }, new Item(6289), -1, 0, -1),
	SNAKESKIN_TEMPLE(2, 0, Skills.CRAFTING, new Item[] { new Item(7801), new Item(995, 20) }, new Item(25610), -1, 0, -1),
	GREEN_D_LEATHER(2, 0, Skills.CRAFTING, new Item[] { new Item(1753), new Item(995, 20) }, new Item(1745), -1, 0, -1),
	BLUE_D_LEATHER(2, 0, Skills.CRAFTING, new Item[] { new Item(1751), new Item(995, 20) }, new Item(2505), -1, 0, -1),
	RED_D_LEATHER(2, 0, Skills.CRAFTING, new Item[] { new Item(1749), new Item(995, 20) }, new Item(2507), -1, 0, -1),
	BLACK_D_LEATHER(2, 0, Skills.CRAFTING, new Item[] { new Item(1747), new Item(995, 20) }, new Item(2509), -1, 0, -1),
	ROYAL_D_LEATHER(2, 0, Skills.CRAFTING, new Item[] { new Item(24372), new Item(995, 20) }, new Item(24374), -1, 0, -1),
	
	/*
	 * Leatherworking
	 */
	
	LEATHER_GLOVES(1, 13.8, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1059), 25594, 2, -1),
	LEATHER_BOOTS(7, 16.3, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1061), 25594, 2, -1),
	LEATHER_VAMBS(11, 22, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1063), 25594, 2, -1),
	LEATHER_CHAPS(18, 27, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1095), 25594, 2, -1),
	LEATHER_BODY(14, 25, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1129), 25594, 2, -1),
	LEATHER_COWL(9, 18.5, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1167), 25594, 2, -1),
	LEATHER_SHIELD(19, 30, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(25806), 25594, 2, -1),
	COIF(38, 37, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1169), 25594, 2, -1),
	
	HARDLEATHER_GLOVES(25, 32, Skills.CRAFTING, new Item[] { new Item(1743), new Item(THREAD) }, new Item(25875), 1249, 2, -1),
	HARDLEATHER_BOOTS(27, 34, Skills.CRAFTING, new Item[] { new Item(1743), new Item(THREAD) }, new Item(25821), 1249, 2, -1),
	HEARDLEATHER_BODY(28, 35, Skills.CRAFTING, new Item[] { new Item(1743), new Item(THREAD) }, new Item(1131), 1249, 2, -1),
	HARDLEATHER_SHIELD(29, 36, Skills.CRAFTING, new Item[] { new Item(1743), new Item(THREAD) }, new Item(25808), 1249, 2, -1),
	
	IMPHIDE_GLOVES(10, 10, Skills.CRAFTING, new Item[] { new Item(25545), new Item(THREAD) }, new Item(25851), 1249, 2, -1),
	IMPHIDE_BOOTS(11, 10, Skills.CRAFTING, new Item[] { new Item(25545), new Item(THREAD) }, new Item(25853), 1249, 2, -1),
	IMPHIDE_HOOD(12, 20, Skills.CRAFTING, new Item[] { new Item(25545, 2), new Item(THREAD) }, new Item(25845), 1249, 2, -1),
	IMPHIDE_ROBE_BOTTOM(13, 20, Skills.CRAFTING, new Item[] { new Item(25545, 2), new Item(THREAD) }, new Item(25849), 1249, 2, -1),
	IMPHIDE_ROBE_TOP(14, 30, Skills.CRAFTING, new Item[] { new Item(25545, 3), new Item(THREAD) }, new Item(25847), 1249, 2, -1),
	IMPHIDE_BOOK(15, 30, Skills.CRAFTING, new Item[] { new Item(25545, 3), new Item(THREAD) }, new Item(25662), 1249, 2, -1),
	IMPHIDE_WAND(16, 30, Skills.CRAFTING, new Item[] { new Item(25545, 3), new Item(THREAD) }, new Item(25642), 1249, 2, -1),
	IMPHIDE_SHIELD(17, 40, Skills.CRAFTING, new Item[] { new Item(25545, 4), new Item(THREAD) }, new Item(25855), 1249, 2, -1),
	
	SPIDERSILK_GLOVES(20, 12.2, Skills.CRAFTING, new Item[] { new Item(25547), new Item(THREAD) }, new Item(25843), 1249, 2, -1),
	SPIDERSILK_BOOTS(21, 12.5, Skills.CRAFTING, new Item[] { new Item(25547), new Item(THREAD) }, new Item(25843), 1249, 2, -1),
	SPIDERSILK_HOOD(22, 25, Skills.CRAFTING, new Item[] { new Item(25547, 2, -1), new Item(THREAD) }, new Item(25835), 1249, 2, -1),
	SPIDERSILK_ROBE_BOTTOM(23, 25, Skills.CRAFTING, new Item[] { new Item(25547, 2), new Item(THREAD) }, new Item(25839), 1249, 2, -1),
	SPIDERSILK_ROBE_TOP(24, 37.5, Skills.CRAFTING, new Item[] { new Item(25547, 3), new Item(THREAD) }, new Item(25837), 1249, 2, -1),
	SPIDERSILK_ORB(25, 25, Skills.CRAFTING, new Item[] { new Item(25547, 2), new Item(THREAD) }, new Item(25658), 1249, 2, -1),
	SPIDERSILK_WAND(26, 25, Skills.CRAFTING, new Item[] { new Item(25547, 2), new Item(THREAD) }, new Item(25650), 1249, 2, -1),
	
	CARAPACE_GLOVES(30, 12, Skills.CRAFTING, new Item[] { new Item(25551), new Item(THREAD) }, new Item(25865), 1249, 2, -1),
	CARAPACE_BOOTS(31, 12, Skills.CRAFTING, new Item[] { new Item(25551), new Item(THREAD) }, new Item(25863), 1249, 2, -1),
	CARAPACE_HELM(33, 24, Skills.CRAFTING, new Item[] { new Item(25551, 2), new Item(THREAD) }, new Item(25857), 1249, 2, -1),
	CARAPACE_LEGS(34, 24, Skills.CRAFTING, new Item[] { new Item(25551, 2), new Item(THREAD) }, new Item(25861), 1249, 2, -1),
	CARAPACE_TORSO(35, 36, Skills.CRAFTING, new Item[] { new Item(25551, 3), new Item(THREAD) }, new Item(25859), 1249, 2, -1),
	
	BATWING_GLOVES(50, 50, Skills.CRAFTING, new Item[] { new Item(25549), new Item(THREAD) }, new Item(25829), 1249, 2, -1),
	BATWING_BOOTS(52, 50, Skills.CRAFTING, new Item[] { new Item(25549), new Item(THREAD) }, new Item(25833), 1249, 2, -1),
	BATWING_HOOD(54, 100, Skills.CRAFTING, new Item[] { new Item(25549, 2), new Item(THREAD) }, new Item(25825), 1249, 2, -1),
	BATWING_LEGS(55, 100, Skills.CRAFTING, new Item[] { new Item(25549, 2), new Item(THREAD) }, new Item(25831), 1249, 2, -1),
	BATWING_TORSO(56, 150, Skills.CRAFTING, new Item[] { new Item(25549, 3), new Item(THREAD) }, new Item(25827), 1249, 2, -1),
	BATWING_SHIELD(58, 200, Skills.CRAFTING, new Item[] { new Item(25549, 4), new Item(THREAD) }, new Item(25802), 1249, 2, -1),
	BATWING_BOOK(59, 200, Skills.CRAFTING, new Item[] { new Item(25549, 4), new Item(THREAD) }, new Item(25660), 1249, 2, -1),
	BATWING_WAND(61, 200, Skills.CRAFTING, new Item[] { new Item(25549, 4), new Item(THREAD) }, new Item(25648), 1249, 2, -1),
	
	SNAKESKIN_BOOTS(45, 30, Skills.CRAFTING, new Item[] { new Item(6289, 6), new Item(THREAD) }, new Item(6328), 1249, 2, -1),
	SNAKESKIN_VAMBS(47, 35, Skills.CRAFTING, new Item[] { new Item(6289, 8), new Item(THREAD) }, new Item(6330), 1249, 2, -1),
	SNAKESKIN_BANDANA(48, 45, Skills.CRAFTING, new Item[] { new Item(6289, 5), new Item(THREAD) }, new Item(6326), 1249, 2, -1),
	SNAKESKIN_CHAPS(51, 50, Skills.CRAFTING, new Item[] { new Item(6289, 12), new Item(THREAD) }, new Item(6324), 1249, 2, -1),
	SNAKESKIN_BODY(53, 55, Skills.CRAFTING, new Item[] { new Item(6289, 15), new Item(THREAD) }, new Item(6322), 1249, 2, -1),
	
	GREEN_D_VAMBS(57, 62, Skills.CRAFTING, new Item[] { new Item(1745), new Item(THREAD) }, new Item(1065), 1249, 2, -1),
	GREEN_D_CHAPS(60, 124, Skills.CRAFTING, new Item[] { new Item(1745, 2), new Item(THREAD) }, new Item(1099), 1249, 2, -1),
	GREEN_D_BODY(63, 186, Skills.CRAFTING, new Item[] { new Item(1745, 3), new Item(THREAD) }, new Item(1135), 1249, 2, -1),
	GREEN_D_SHIELD(64, 248, Skills.CRAFTING, new Item[] { new Item(1745, 4), new Item(THREAD) }, new Item(25794), 1249, 2, -1),
	
	BLUE_D_VAMBS(66, 70, Skills.CRAFTING, new Item[] { new Item(2505), new Item(THREAD) }, new Item(2487), 1249, 2, -1),
	BLUE_D_CAHPS(68, 140, Skills.CRAFTING, new Item[] { new Item(2505, 2), new Item(THREAD) }, new Item(2493), 1249, 2, -1),
	BLUE_D_BODY(71, 210, Skills.CRAFTING, new Item[] { new Item(2505, 3), new Item(THREAD) }, new Item(2499), 1249, 2, -1),
	BLUE_D_SHIELD(72, 280, Skills.CRAFTING, new Item[] { new Item(2505, 4), new Item(THREAD) }, new Item(25796), 1249, 2, -1),

	RED_D_VAMBS(73, 78, Skills.CRAFTING, new Item[] { new Item(2507), new Item(THREAD) }, new Item(2489), 1249, 2, -1),
	RED_D_CHAPS(75, 156, Skills.CRAFTING, new Item[] { new Item(2507, 2), new Item(THREAD) }, new Item(2495), 1249, 2, -1),
	RED_D_BODY(77, 234, Skills.CRAFTING, new Item[] { new Item(2507, 3), new Item(THREAD) }, new Item(2501), 1249, 2, -1),
	RED_D_SHIELD(78, 312, Skills.CRAFTING, new Item[] { new Item(2507, 4), new Item(THREAD) }, new Item(25798), 1249, 2, -1),

	BLACK_D_VAMBS(79, 86, Skills.CRAFTING, new Item[] { new Item(2509), new Item(THREAD) }, new Item(2491), 1249, 2, -1),
	BLACK_D_CAHPS(82, 172, Skills.CRAFTING, new Item[] { new Item(2509, 2), new Item(THREAD) }, new Item(2497), 1249, 2, -1),
	BLACK_D_BODY(84, 258, Skills.CRAFTING, new Item[] { new Item(2509, 3), new Item(THREAD) }, new Item(2503), 1249, 2, -1),
	BLACK_D_SHIELD(85, 344, Skills.CRAFTING, new Item[] { new Item(2509, 4), new Item(THREAD) }, new Item(25801), 1249, 2, -1),

	RYOAL_D_VAMBS(87, 94, Skills.CRAFTING, new Item[] { new Item(24374), new Item(THREAD) }, new Item(24376), 1249, 2, -1),
	RYOAL_D_CHAPS(89, 188, Skills.CRAFTING, new Item[] { new Item(24374, 2), new Item(THREAD) }, new Item(24379), 1249, 2, -1),
	RYOAL_D_BODY(93, 282, Skills.CRAFTING, new Item[] { new Item(24374, 3), new Item(THREAD) }, new Item(24382), 1249, 2, -1),

	YAKHIDE_LEGS(43, 32, Skills.CRAFTING, new Item[] { new Item(10820), new Item(THREAD) }, new Item(10824), 1249, 2, -1),
	YAKHIDE_TOP(46, 32, Skills.CRAFTING, new Item[] { new Item(10820, 2), new Item(THREAD) }, new Item(10822), 1249, 2, -1),
	
	SPIKY_VAMBS(32, 5.8, Skills.CRAFTING, new Item[] { new Item(1063), new Item(10113) }, new Item(10077), 1249, 2, -1),
	GREEN_SPIKY_VAMBS(32, 5.8, Skills.CRAFTING, new Item[] { new Item(1065), new Item(10113) }, new Item(10079), 1249, 2, -1),
	BLUE_SPIKY_VAMBS(32, 5.8, Skills.CRAFTING, new Item[] { new Item(2487), new Item(10113) }, new Item(10081), 1249, 2, -1),
	RED_SPIKY_VAMBS(32, 5.8, Skills.CRAFTING, new Item[] { new Item(2489), new Item(10113) }, new Item(10083), 1249, 2, -1),
	BLACK_SPIKY_VAMBS(32, 5.8, Skills.CRAFTING, new Item[] { new Item(2491), new Item(10113) }, new Item(10085), 1249, 2, -1),
	ROYAL_SPIKY_VAMBS(32, 5.8, Skills.CRAFTING, new Item[] { new Item(24376), new Item(10113) }, new Item(25553), 1249, 2, -1),
	STUDDED_CHAPS(44, 42, Skills.CRAFTING, new Item[] { new Item(1095), new Item(2370) }, new Item(1097), 1249, 2, -1),
	STUDDED_BODY(41, 40, Skills.CRAFTING, new Item[] { new Item(1129), new Item(2370) }, new Item(1133), 1249, 2, -1),
	STUDDED_GLOVES(42, 409, Skills.CRAFTING, new Item[] { new Item(1059), new Item(2370) }, new Item(25877), 1249, 2, -1),
	STUDDED_BOOTS(43, 42, Skills.CRAFTING, new Item[] { new Item(1061), new Item(2370) }, new Item(25823), 1249, 2, -1),
	STUDDED_SHIELD(45, 43, Skills.CRAFTING, new Item[] { new Item(25806), new Item(2370) }, new Item(25810), 1249, 2, -1),
	
	/*
	 * Crab armor
	 */
	
	CRAB_HELMET(15, 32.5, Skills.CRAFTING, new Item[] { new Item(7538) }, new Item(7539), 1249, 2, -1),
	CRAB_CLAW(15, 32.5, Skills.CRAFTING, new Item[] { new Item(7536) }, new Item(7537), 1249, 2, -1),
	
	/*
	 * Battlestaves
	 */
	
	WATTER_BATTLESTAFF(54, 100, Skills.CRAFTING, new Item[] { new Item(1391), new Item(571) }, new Item(1395), 16448, 2, -1),
	EARTH_BATTLESTAFF(58, 112.5, Skills.CRAFTING, new Item[] { new Item(1391), new Item(575) }, new Item(1399), 16447, 2, -1),
	FIRE_BATTLESTAFF(62, 125, Skills.CRAFTING, new Item[] { new Item(1391), new Item(569) }, new Item(1393), 16449, 2, -1),
	AIR_BATTLESTAFF(66, 137.5, Skills.CRAFTING, new Item[] { new Item(1391), new Item(573) }, new Item(1397), 16446, 2, -1),
	ARMADYL_BATTLESTAFF(77, 150, Skills.CRAFTING, new Item[] { new Item(1391), new Item(21775) }, new Item(21777), 16450, 2, -1),
	
	/*
	 * Snelms
	 */
	
	MYRE_SNELM(15, 32.5, Skills.CRAFTING, new Item[] { new Item(3345) }, new Item(3327), 1249, 2, -1),
	MYRE_SNELM2(15, 32.5, Skills.CRAFTING, new Item[] { new Item(3355) }, new Item(3337), 1249, 2, -1),
	BLOODNTAR_SNELM(15, 32.5, Skills.CRAFTING, new Item[] { new Item(3347) }, new Item(3329), 1249, 2, -1),
	BLOODNTAR_SNELM2(15, 32.5, Skills.CRAFTING, new Item[] { new Item(3357) }, new Item(3339), 1249, 2, -1),
	OCHRE_SNELM(15, 32.5, Skills.CRAFTING, new Item[] { new Item(3349) }, new Item(3331), 1249, 2, -1),
	OCHRE_SNELM2(15, 32.5, Skills.CRAFTING, new Item[] { new Item(3359) }, new Item(3341), 1249, 2, -1),
	BRUISE_SNELM(15, 32.5, Skills.CRAFTING, new Item[] { new Item(3351) }, new Item(3333), 1249, 2, -1),
	BRUISE_SNELM2(15, 32.5, Skills.CRAFTING, new Item[] { new Item(3361) }, new Item(3343), 1249, 2, -1),
	BROKENBARK_SNELM(15, 32.5, Skills.CRAFTING, new Item[] { new Item(3353) }, new Item(3335), 1249, 2, -1),
	
	/*
	 * Amulet Stringing
	 */
	
	MONKEYSPEAK_AMULET(1, 0, Skills.CRAFTING, new Item[] { new Item(4022), new Item(1759) }, new Item(4021), 1249, 2, -1),
	UNBLESSED_SYMBOL(16, 4, Skills.CRAFTING, new Item[] { new Item(1714), new Item(1759) }, new Item(1716), 1249, 2, -1),
	UNPOWERED_SYMBOL(17, 4, Skills.CRAFTING, new Item[] { new Item(1720), new Item(1759) }, new Item(1722), 1249, 2, -1),
	GOLD_AMULET(8, 4, Skills.CRAFTING, new Item[] { new Item(1673), new Item(1759) }, new Item(1692), 1249, 2, -1),
	SAPPHIRE_AMULET(24, 4, Skills.CRAFTING, new Item[] { new Item(1675), new Item(1759) }, new Item(1694), 1249, 2, -1),
	STRUNG_RABBIT_FOOT(37, 4, Skills.CRAFTING, new Item[] { new Item(10134), new Item(1759) }, new Item(10132), 1249, 2, -1),
	EMERALD_AMULET(31, 4, Skills.CRAFTING, new Item[] { new Item(1677), new Item(1759) }, new Item(1696), 1249, 2, -1),
	PRENATURE_AMULET(8, 48, Skills.CRAFTING, new Item[] { new Item(1677), new Item(6038) }, new Item(6041), 1249, 2, -1),
	RUBY_AMULET(50, 4, Skills.CRAFTING, new Item[] { new Item(1679), new Item(1759) }, new Item(1698), 1249, 2, -1),
	DIAMOND_AMULET(70, 4, Skills.CRAFTING, new Item[] { new Item(1681), new Item(1759) }, new Item(1700), 1249, 2, -1),
	DRAGONSTONE_AMULET(80, 4, Skills.CRAFTING, new Item[] { new Item(1683), new Item(1759) }, new Item(1702), 1249, 2, -1),
	ONYX_AMULET(90, 4, Skills.CRAFTING, new Item[] { new Item(6579), new Item(1759) }, new Item(6581), 1249, 2, -1),
	HYDRIX_AMULET(99, 49, Skills.CRAFTING, new Item[] { new Item(31861), new Item(1759) }, new Item(31863), 1249, 2, -1),
	
	/*
	 * Glass blowing
	 */
	
	BEER_GLASS(1, 17.5, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(1919), 884, 2, -1),
	CANDLE_LANTERN(4, 19, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(4527), 884, 2, -1),
	OIL_LAMP(12, 25, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(4525), 884, 2, -1),
	VIAL(33, 35, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(229), 884, 2, -1),
	FISHBOWL(42, 42.5, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(6667), 884, 2, -1),
	UNPOERED_ORB(46, 52.5, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(567), 884, 2, -1),
	LANTERN_LENS(49, 55, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(4542), 884, 2, -1),
	EMPTY_LIGHT_ORB(87, 70, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(10980), 884, 2, -1),
	
	POTION_FLASK(89, 100, Skills.CRAFTING, new Item[] { new Item(23193) }, new Item(23191), 884, 2, -1),

	CRYSTAL_FLASK(89, 150, Skills.CRAFTING, new Item[] { new Item(32845) }, new Item(32843), 884, 2, -1),
	
	/*
	 * Herb cleaning
	 */
	
	GUAM(1, 2.5, Skills.HERBLORE, new Item[] { new Item(199) }, new Item(249), -1, 0, -1),
	SNAKE_WEED(3, 2.5, Skills.HERBLORE, new Item[] { new Item(1525) }, new Item(1526), -1, 0, -1),
	ARDRIGAL(3, 2.5, Skills.HERBLORE, new Item[] { new Item(1527) }, new Item(1528), -1, 0, -1),
	RGOUES_PURSE(3, 2.5, Skills.HERBLORE, new Item[] { new Item(1533) }, new Item(1534), -1, 0, -1),
	SITO_FOIL(3, 2.5, Skills.HERBLORE, new Item[] { new Item(1529) }, new Item(1530), -1, 0, -1),
	VOLENCIA_MOSS(3, 2.5, Skills.HERBLORE, new Item[] { new Item(1531) }, new Item(1532), -1, 0, -1),
	MARRENTILL(9, 5, Skills.HERBLORE, new Item[] { new Item(201) }, new Item(251), -1, 0, -1),
	TARROMIN(5, 3.8, Skills.HERBLORE, new Item[] { new Item(203) }, new Item(253), -1, 0, -1),
	HARRALANDER(20, 6.3, Skills.HERBLORE, new Item[] { new Item(205) }, new Item(255), -1, 0, -1),
	RANARR(25, 7.5, Skills.HERBLORE, new Item[] { new Item(207) }, new Item(257), -1, 0, -1),
	TOADFLAX(30, 8, Skills.HERBLORE, new Item[] { new Item(3049) }, new Item(2998), -1, 0, -1),
	SPIRIT_WEED(35, 7.8, Skills.HERBLORE, new Item[] { new Item(12174) }, new Item(12172), -1, 0, -1),
	IRIT(40, 8.8, Skills.HERBLORE, new Item[] { new Item(209) }, new Item(259), -1, 0, -1),
	WERGALI(41, 9.5, Skills.HERBLORE, new Item[] { new Item(14836) }, new Item(14854), -1, 0, -1),
	AVANTOE(48, 10, Skills.HERBLORE, new Item[] { new Item(211) }, new Item(261), -1, 0, -1),
	KWUARM(54, 11.3, Skills.HERBLORE, new Item[] { new Item(213) }, new Item(263), -1, 0, -1),
	SNAPDRAGON(59, 11.8, Skills.HERBLORE, new Item[] { new Item(3051) }, new Item(3000), -1, 0, -1),
	CADANTINE(65, 12.5, Skills.HERBLORE, new Item[] { new Item(215) }, new Item(265), -1 , 0, -1),
	LANTADYME(67, 13.1, Skills.HERBLORE, new Item[] { new Item(1485) }, new Item(2481), -1 , 0, -1),
	DWARF_WEED(70, 13.8, Skills.HERBLORE, new Item[] { new Item(217) }, new Item(267), -1 , 0, -1),
	TORSTOL(75, 15, Skills.HERBLORE, new Item[] { new Item(219) }, new Item(269), -1 , 0, -1),
	FELLSTALK(91, 16.8, Skills.HERBLORE, new Item[] { new Item(21626) }, new Item(21624), -1 , 0, -1),
	
	/*
	 * Unfinished potions
	 */
	
	COCONUT_MILK(1, 1, Skills.HERBLORE, new Item[] { new Item(5976), new Item(229) }, new Item(5935), 363, 1, -1),
	GUAM_POT(1, 1, Skills.HERBLORE, new Item[] { new Item(249), new Item(227) }, new Item(91), 363, 1, -1),
	SNAKEWEED_MIXTURE(3, 1, Skills.HERBLORE, new Item[] { new Item(1526), new Item(227) }, new Item(737), 363 , 1, -1),
	ARDRIGAL_MIXTURE(3, 1, Skills.HERBLORE, new Item[] { new Item(1528), new Item(227) }, new Item(738), 363 , 1, -1),
	ROGUESPURSE_POT(5, 1, Skills.HERBLORE, new Item[] { new Item(1534), new Item(227) }, new Item(4840), 363 , 1, -1),
	TARROMIN_POT(5, 1, Skills.HERBLORE, new Item[] { new Item(253), new Item(227) }, new Item(95), 363 , 1, -1),
	MARRENTILL_POT(9, 1, Skills.HERBLORE, new Item[] { new Item(251), new Item(227) }, new Item(93), 363 , 1, -1),
	HARRALANDER_POT(18, 1, Skills.HERBLORE, new Item[] { new Item(255), new Item(227) }, new Item(97), 363 , 1, -1),
	RANARR_POT(25, 1, Skills.HERBLORE, new Item[] { new Item(257), new Item(227) }, new Item(99), 363 , 1, -1),
	TOADFLAX_POT(30, 1, Skills.HERBLORE, new Item[] { new Item(2998), new Item(227) }, new Item(3002), 363 , 1, -1),
	SPIRITWEED_POT(35, 1, Skills.HERBLORE, new Item[] { new Item(12172), new Item(227) }, new Item(12181), 363 , 1, -1),
	IRIT_POT(40, 1, Skills.HERBLORE, new Item[] { new Item(259), new Item(227) }, new Item(101), 363 , 1, -1),
	WERGALI_POT(41, 1, Skills.HERBLORE, new Item[] { new Item(14854), new Item(227) }, new Item(14856), 363 , 1, -1),
	AVANTOE_POT(48, 1, Skills.HERBLORE, new Item[] { new Item(261), new Item(227) }, new Item(103), 363 , 1, -1),
	KWUARM_POT(54, 1, Skills.HERBLORE, new Item[] { new Item(263), new Item(227) }, new Item(105), 363 , 1, -1),
	MAGIC_ESSENCEU(57, 1, Skills.HERBLORE, new Item[] { new Item(9017), new Item(227) }, new Item(26809), 363 , 1, -1),
	SNAPDRAGON_POT(59, 17, Skills.HERBLORE, new Item[] { new Item(3000), new Item(227) }, new Item(3004), 363 , 1, -1),
	CADANTINE_POT(65, 1, Skills.HERBLORE, new Item[] { new Item(265), new Item(227) }, new Item(107), 363 , 1, -1),
	LANTADYME_POT(67, 1, Skills.HERBLORE, new Item[] { new Item(2481), new Item(227) }, new Item(2483), 363 , 1, -1),
	ANTIPOISONPU(68, 1, Skills.HERBLORE, new Item[] { new Item(2998), new Item(5935) }, new Item(5942), 363 , 1, -1),
	DWARFWEED_POT(70, 1, Skills.HERBLORE, new Item[] { new Item(267), new Item(227) }, new Item(109), 363 , 1, -1),
	WEAPON_POTP(73, 15, Skills.HERBLORE, new Item[] { new Item(6016), new Item(5935) }, new Item(5936), 363 , 1, -1),
	TORSTOL_POT(75, 1, Skills.HERBLORE, new Item[] { new Item(269), new Item(227) }, new Item(111), 363 , 1, -1),
	ANTIPOISONPPU(79, 17, Skills.HERBLORE, new Item[] { new Item(259), new Item(5935) }, new Item(5951), 363 , 1, -1),
	WEAPON_POTPP(82, 1, Skills.HERBLORE, new Item[] { new Item(2398), new Item(5935) }, new Item(5939), 363 , 1, -1),
	FELLSTALK_POT(91, 1, Skills.HERBLORE, new Item[] { new Item(21624), new Item(227) }, new Item(21628), 363 , 1, -1),
	
	/*
	 * Potions
	 */
	
	ATTACK_POT(1, 25, Skills.HERBLORE, new Item[] { new Item(91), new Item(221) }, new Item(121), 363 , 1, -1),
	RANGING_POT(3, 30, Skills.HERBLORE, new Item[] { new Item(91), new Item(1951) }, new Item(27506), 363 , 1, -1),
	MAGIC_POT(5, 35, Skills.HERBLORE, new Item[] { new Item(95), new Item(1474) }, new Item(27514), 363 , 1, -1),
	STRENGTH_POT(7, 40, Skills.HERBLORE, new Item[] { new Item(95), new Item(225) }, new Item(115), 363 , 1, -1),
	RELICYMS_BALM(8, 40, Skills.HERBLORE, new Item[] { new Item(4840), new Item(1526) }, new Item(4844), 363 , 1, -1),
	DEFENCE_POT(9, 45, Skills.HERBLORE, new Item[] { new Item(948), new Item(93) }, new Item(133), 363 , 1, -1),
	ANTIPOISON(13, 50, Skills.HERBLORE, new Item[] { new Item(235), new Item(93) }, new Item(175), 363 , 1, -1),
	SERUM207(15, 50, Skills.HERBLORE, new Item[] { new Item(592), new Item(95) }, new Item(3410), 363 , 1, -1),
	GUTHIX_REST(18, 59.5, Skills.HERBLORE, new Item[] { new Item(251), new Item(97) }, new Item(4419), 363 , 1, -1),
	RESTORE_POT(22, 62.5, Skills.HERBLORE, new Item[] { new Item(97), new Item(223) }, new Item(127), 363 , 1, -1),
	GUTHIX_BALANCE_U(22, 25, Skills.HERBLORE, new Item[] { new Item(127), new Item(1550) }, new Item(7654), 363 , 1, -1),
	GUTHIX_BALANCE(22, 25, Skills.HERBLORE, new Item[] { new Item(7654), new Item(7650) }, new Item(7662), 363 , 1, -1),
	BLAMISH_OIL(25, 80, Skills.HERBLORE, new Item[] { new Item(97), new Item(1581) }, new Item(1582), 363 , 1, -1),
	ENERGY_POT(26, 67.5, Skills.HERBLORE, new Item[] { new Item(1975), new Item(97) }, new Item(3010), 363 , 1, -1),
	SUPER_FISHING_EXPLOSIBE(31, 55, Skills.HERBLORE, new Item[] { new Item(91), new Item(12630) }, new Item(12633), 363 , 1, -1),
	AGILITY_POT(34, 80, Skills.HERBLORE, new Item[] { new Item(3002), new Item(2152) }, new Item(3034), 363 , 1, -1),
	COMBAT_POT(36, 84, Skills.HERBLORE, new Item[] { new Item(9736), new Item(97) }, new Item(9741), 363 , 1, -1),
	GOBLIN_POT(37, 85, Skills.HERBLORE, new Item[] { new Item(11807), new Item(3002) }, new Item(11810), 363 , 1, -1),
	PRAYER_POT(38, 87.5, Skills.HERBLORE, new Item[] { new Item(99), new Item(231) }, new Item(139), 363 , 1, -1),
	SUMMONING_POT(40, 92, Skills.HERBLORE, new Item[] { new Item(12181), new Item(12654) }, new Item(12142), 363 , 1, -1),
	CRAFTING_POT(42, 95, Skills.HERBLORE, new Item[] { new Item(5004), new Item(14856) }, new Item(14840), 363 , 1, -1),
	SUPER_ATTACK(45, 100, Skills.HERBLORE, new Item[] { new Item(102), new Item(221) }, new Item(145), 363 , 1, -1),
	SUPER_ANTIPOISON(48, 106.3, Skills.HERBLORE, new Item[] { new Item(101), new Item(235) }, new Item(181), 363 , 1, -1),
	FISHING_POT(50, 112.5, Skills.HERBLORE, new Item[] { new Item(103), new Item(231) }, new Item(151), 363 , 1, -1),
	SUPER_ENERGY(52, 117.5, Skills.HERBLORE, new Item[] { new Item(103), new Item(2970) }, new Item(3018), 363 , 1, -1),
	HUNTER_POT(53, 120, Skills.HERBLORE, new Item[] { new Item(103), new Item(10111) }, new Item(1000), 363 , 1, -1),
	SUPER_STRENGTH(55, 125, Skills.HERBLORE, new Item[] { new Item(105), new Item(225) }, new Item(157), 363 , 1, -1),
	MAGIC_ESSENCE(57, 130, Skills.HERBLORE, new Item[] { new Item(26808), new Item(26809) }, new Item(26811), 363 , 1, -1),
	FLETCHING_POT(58, 132, Skills.HERBLORE, new Item[] { new Item(14856), new Item(11525) }, new Item(14848), 363 , 1, -1),
	WEAPON_POISON(60, 137.5, Skills.HERBLORE, new Item[] { new Item(105), new Item(241) }, new Item(187), 363 , 1, -1),
	SUPER_RESTORE(63, 142.5, Skills.HERBLORE, new Item[] { new Item(3004), new Item(223) }, new Item(3026), 363 , 1, -1),
	MIXTURE1(65, 47.5, Skills.HERBLORE, new Item[] { new Item(235), new Item(3026) }, new Item(10911), 363 , 1, -1),
	MIXTURE2(65, 52.5, Skills.HERBLORE, new Item[] { new Item(10915), new Item(1526) }, new Item(10919), 363 , 1, -1),
	SANFEW_SERUM(65, 60, Skills.HERBLORE, new Item[] { new Item(10923), new Item(10937) }, new Item(10927), 363 , 1, -1),
	SUPER_DEFENCE(66, 150, Skills.HERBLORE, new Item[] { new Item(107), new Item(239) }, new Item(163), 363 , 1, -1),
	ANTIPOISONP(68, 155, Skills.HERBLORE, new Item[] { new Item(5942), new Item(6049) }, new Item(5943), 363 , 1, -1),
	ANTIFIRE(69, 157.5, Skills.HERBLORE, new Item[] { new Item(2483), new Item(241) }, new Item(2454), 363 , 1, -1),
	SUPER_RANGING_POTION(72, 162.55, Skills.HERBLORE, new Item[] { new Item(109), new Item(245) }, new Item(169), 363 , 1, -1),
	WEAPON_POISONP(73, 165, Skills.HERBLORE, new Item[] { new Item(5936), new Item(223) }, new Item(5937), 363 , 1, -1),
	SUPER_MAGIC(76, 172.5, Skills.HERBLORE, new Item[] { new Item(3138), new Item(2483) }, new Item(3042), 363 , 1, -1),
	ZAMORAK_BREW(78, 175, Skills.HERBLORE, new Item[] { new Item(111), new Item(247) }, new Item(189), 363 , 1, -1),
	ANTIPOISONPP(79, 177.5, Skills.HERBLORE, new Item[] { new Item(5951), new Item(6051) }, new Item(5952), 363 , 1, -1),
	SARADOMIN_BREW(81, 180, Skills.HERBLORE, new Item[] { new Item(3002), new Item(6693) }, new Item(6687), 363 , 1, -1),
	WEAPON_POISONPP(82, 190, Skills.HERBLORE, new Item[] { new Item(5939), new Item(6018) }, new Item(5940), 363 , 1, -1),
	ADRENALINE_POT(84, 2002, Skills.HERBLORE, new Item[] { new Item(3018), new Item(5972) }, new Item(15301), 363 , 1, -1),
	SUPER_ANTIFIRE(85, 210, Skills.HERBLORE, new Item[] { new Item(2454), new Item(4621) }, new Item(15305), 363 , 1, -1),
	EXTREME_ATTACK(88, 220, Skills.HERBLORE, new Item[] { new Item(261), new Item(145) }, new Item(15309), 363 , 1, -1),
	EXTREME_STRENGTH(89, 230, Skills.HERBLORE, new Item[] { new Item(267), new Item(157) }, new Item(15313), 363 , 1, -1),
	EXTREME_DEFENCE(90, 240, Skills.HERBLORE, new Item[] { new Item(2481), new Item(163) }, new Item(15317), 363 , 1, -1),
	EXTREME_MAGIC(91, 250, Skills.HERBLORE, new Item[] { new Item(3042), new Item(9594) }, new Item(15321), 363 , 1, -1),
	EXTREME_RANGING(92, 260, Skills.HERBLORE, new Item[] { new Item(169), new Item(12539) }, new Item(15325), 363 , 1, -1),
	SUPER_ZAMORAK_BREW(93, 180, Skills.HERBLORE, new Item[] { new Item(189), new Item(245) }, new Item(28201), 363 , 1, -1),
	SUPER_SARADOMIN_BREW(93, 180, Skills.HERBLORE, new Item[] { new Item(6687), new Item(28256) }, new Item(28193), 363 , 1, -1),
	SUPER_GUTHIX_REST(93, 59.5, Skills.HERBLORE, new Item[] { new Item(28253), new Item(4419) }, new Item(28209), 363 , 1, -1),
	SUPER_PRAYER(94, 270, Skills.HERBLORE, new Item[] { new Item(139), new Item(4255) }, new Item(15329), 363 , 1, -1),
	PRAYER_RENEWAL(94, 190, Skills.HERBLORE, new Item[] { new Item(21628), new Item(21622) }, new Item(21632), 363 , 1, -1),
	OVERLOAD(96, 1000, Skills.HERBLORE, new Item[] { new Item(269), new Item(15309), new Item(15313), new Item(15317), new Item(15321), new Item(15325) }, new Item(15333), 363 , 1, -1),
	
	/*
	 * Juju herbs
	 */
	
	ERZILLE(54, 10, Skills.HERBLORE, new Item[] { new Item(19984) }, new Item(19989), -1 , 0, -1),
	UGUNE(55, 11.5, Skills.HERBLORE, new Item[] { new Item(19986) }, new Item(19991), -1 , 0, -1),
	ARGWAY(56, 11.65, Skills.HERBLORE, new Item[] { new Item(19985) }, new Item(19990), -1 , 0, -1),
	SHENGO(57, 11.7, Skills.HERBLORE, new Item[] { new Item(19987) }, new Item(19992), -1 , 0, -1),
	SAMADEN(58, 11.7, Skills.HERBLORE, new Item[] { new Item(19988) }, new Item(19993), -1 , 0, -1),
	
	/*
	 * Unfinished juju potions
	 */
	
	ERZILLE_UNF(54, 1, Skills.HERBLORE, new Item[] { new Item(19989), new Item(19994) }, new Item(19998), 363 , 1, -1),
	UGUNE_UNF(55, 1, Skills.HERBLORE, new Item[] { new Item(19991), new Item(19994) }, new Item(19999), 363 , 1, -1),
	ARGWAY_UNF(56, 1, Skills.HERBLORE, new Item[] { new Item(19990), new Item(19994) }, new Item(20000), 363 , 1, -1),
	SHENGO_UNF(57, 1, Skills.HERBLORE, new Item[] { new Item(19992), new Item(19994) }, new Item(20001), 363 , 1, -1),
	SAMADEN_UNF(58, 1, Skills.HERBLORE, new Item[] { new Item(19993), new Item(19994) }, new Item(20002), 363 , 1, -1),
	
	/*
	 * Todo
	 * Comination, juju, and barbarian potions
	 * Grinding and crushing
	 */
	
	/*
	 * Crushing
	 */
	
	DRAGON_SCALE_DUST(1, 1, Skills.HERBLORE, new Item[] { new Item(243) }, new Item(241), 364, 0, -1),
	UNICORN_HORN_DUST(1, 1, Skills.HERBLORE, new Item[] { new Item(237) }, new Item(235), 364, 0, -1),
	CRUSHED_BIRD_NEST(1, 1, Skills.HERBLORE, new Item[] { new Item(5075) }, new Item(6693), -1 , 0, -1),
	KEBBIT_TEETH_DUST(1, 1, Skills.HERBLORE, new Item[] { new Item(10109) }, new Item(10111), 364, 0, -1),
	GOAT_HORN_DUST(1, 1, Skills.HERBLORE, new Item[] { new Item(9735) }, new Item(9736), 364, 0, -1),
	GROUND_MUD_RUNE(1, 1, Skills.HERBLORE, new Item[] { new Item(4698) }, new Item(9594), 364, 0, -1),
	ANCHOVIE_PASTE(1, 1, Skills.HERBLORE, new Item[] { new Item(319) }, new Item(11266), 364, 0, -1),
	GORAK_CLAW_POWDER(1, 1, Skills.HERBLORE, new Item[] { new Item(9016) }, new Item(9018), 364, 0, -1),
	GROUND_ASHES(1, 1, Skills.HERBLORE, new Item[] { new Item(592) }, new Item(8865), 364, 0, -1),
	GROUND_TOOTH(1, 1, Skills.HERBLORE, new Item[] { new Item(9079) }, new Item(9082), 364, 0, -1),
	DUST_OF_ARMADYL(1, 1, Skills.HERBLORE, new Item[] { new Item(21776) }, new Item(21774, 8), 364, 0, -1),
	
	CHOCOLATE_DUST(1, 1, Skills.COOKING, new Item[] { new Item(1973) }, new Item(1975), 364, 0, -1),
	GROUND_GUAM(1, 1, Skills.COOKING, new Item[] { new Item(249) }, new Item(6681), 364, 0, -1),
	GROUND_SEAWEED(1, 1, Skills.COOKING, new Item[] { new Item(401) }, new Item(6683), 364, 0, -1),
	GROUND_CRAB_MEAT(1, 1, Skills.COOKING, new Item[] { new Item(7518) }, new Item(7527), 364, 0, -1),
	GROUND_COD(1, 1, Skills.COOKING, new Item[] { new Item(341) }, new Item(7528), 364, 0, -1),
	GROUND_KELP(1, 1, Skills.COOKING, new Item[] { new Item(7516) }, new Item(7517), 364, 0, -1),
	BREADCRUMBS(1, 1, Skills.COOKING, new Item[] { new Item(2309) }, new Item(7515), 364, 0, -1),
	
	GUAM_TAR(19, 30, Skills.HERBLORE, new Item[] { new Item(1939, 15), new Item(249) }, new Item(10142, 15), -1 , 0, -1),
	MARRENTILL_TAR(31, 42.5, Skills.HERBLORE, new Item[] { new Item(1939, 15), new Item(251) }, new Item(10143, 15), -1 , 0, -1),
	TARROMIN_TAR(39, 55, Skills.HERBLORE, new Item[] { new Item(1939, 15), new Item(253) }, new Item(10144, 15), -1 , 0, -1),
	HARRALANDER_TAR(44, 72.5, Skills.HERBLORE, new Item[] { new Item(1939, 15), new Item(255) }, new Item(10145, 15), -1 , 0, -1),
	
	/*
	 * Divination
	 *
	 *
	 * Pale
	 */
	DIVINE_CRAYFISH(1, 1, Skills.DIVINATION, new Item[] { new Item(29313, 5), new Item(13435, 20) }, new Item(31080), -1 , 2, -1),
	PORTENT_OF_RESTORATION_I(2, 1, Skills.DIVINATION, new Item[] { new Item(29313, 30), new Item(13433, 1) }, new Item(29209), -1 , 2, -1),
	DIVINE_BRONZE_ROCK(3, 1.2, Skills.DIVINATION, new Item[] { new Item(29313, 20), new Item(436, 20) }, new Item(29294), -1 , 2, -1),
	DIVINE_BRONZE_ROCK2(3, 1.2, Skills.DIVINATION, new Item[] { new Item(438, 20), new Item(29313, 20) }, new Item(29294), -1 , 2, -1),
	DIVINE_KEBBIT(4, 1.3, Skills.DIVINATION, new Item[] { new Item(29313, 25), new Item(9986, 20) }, new Item(29300), -1 , 2, -1),
	ATTUNED_PORTENT_OF_REST_I(5, 1.5, Skills.DIVINATION, new Item[] { new Item(29313, 30), new Item(13433, 20) }, new Item(29259), -1 , 2, -1),
	SIGN_OF_THE_PORTER_I(1, 1, Skills.DIVINATION, new Item[] { new Item(29313, 30), new Item(1656, 1) }, new Item(29275), -1 , 2, -1),
	DIVINE_TREE(7, 1.8, Skills.DIVINATION, new Item[] { new Item(29313, 5), new Item(1511, 20) }, new Item(29304), -1 , 2, -1),
	SIGN_OF_RESPITE_I(8, 2, Skills.DIVINATION, new Item[] { new Item(29313, 25), new Item(3211, 4) }, new Item(29269), -1 , 2, -1),
	BOON_OF_FLICKERING_ENERGY(10, 3, Skills.DIVINATION, new Item[] { new Item(29313, 100) }, new Item(29373), -1 , 2, -1),
	
	/*
	 * Flickering
	 */
	
	DIVINE_HERRING(11, 3, Skills.DIVINATION, new Item[] { new Item(29314, 15), new Item(345, 20) }, new Item(31081), -1 , 2, -1),
	DIVINE_HERB_I(12, 3.1, Skills.DIVINATION, new Item[] { new Item(29314, 5), new Item(249, 10) }, new Item(29310), -1 , 2, -1),
	OAK_LOG(13, 3.3, Skills.DIVINATION, new Item[] { new Item(29314, 2), new Item(1511, 3) }, new Item(1521), -1 , 2, -1),
	PORTENT_OF_REST_II(15, 3.4, Skills.DIVINATION, new Item[] { new Item(29314, 30), new Item(333, 1) }, new Item(29241), -1 , 2, -1),
	RAW_TROUT(16, 3.6, Skills.DIVINATION, new Item[] { new Item(29314, 2), new Item(327, 3) }, new Item(335), -1 , 2, -1),
	IRON_ORE(17, 3.7, Skills.DIVINATION, new Item[] { new Item(29314, 2), new Item(436, 3) }, new Item(440), -1 , 2, -1),
	ATTUNED_PORTENT_OF_REST_II(18, 3.9, Skills.DIVINATION, new Item[] { new Item(29314, 30), new Item(333, 1) }, new Item(29260), -1 , 2, -1),
	DIVINE_IRON(19, 4, Skills.DIVINATION, new Item[] { new Item(29314, 20), new Item(440, 15) }, new Item(29295), -1 , 2, -1),
	BOON_OF_BRIGHT_ENERGY(20, 5, Skills.DIVINATION, new Item[] { new Item(29314, 300) }, new Item(29374), -1 , 2, -1),
	
	/*
	 * Bright
	 */
	
	DIVINE_TROUT(20, 5, Skills.DIVINATION, new Item[] { new Item(29315, 15), new Item(335, 20) }, new Item(31082), -1 , 2, -1),
	DIVINE_OAK_TREE(21, 5.1, Skills.DIVINATION, new Item[] { new Item(29315, 15), new Item(1521, 20) }, new Item(29305), -1 , 2, -1),
	SILVER_ORE(22, 5.2, Skills.DIVINATION, new Item[] { new Item(29315, 2), new Item(440, 3) }, new Item(442), -1 , 2, -1),
	SIGN_OF_RESPITE_II(23, 5.3, Skills.DIVINATION, new Item[] { new Item(29315, 30), new Item(3211, 4) }, new Item(29271), -1 , 2, -1),
	DIVINE_BIRD_SNARE(24, 5.4, Skills.DIVINATION, new Item[] { new Item(29315, 30), new Item(9978, 20) }, new Item(29301), -1 , 2, -1),
	PORTENT_OF_REST_III(25, 5.6, Skills.DIVINATION, new Item[] { new Item(29315, 30), new Item(329, 1) }, new Item(29243), -1 , 2, -1),
	UNCUT_EMERALD(26, 5.7, Skills.DIVINATION, new Item[] { new Item(29315, 2), new Item(1623, 3) }, new Item(1621), -1 , 2, -1),
	ATTUNED_PORTENT_OF_REST_III(27, 5.8, Skills.DIVINATION, new Item[] { new Item(29315, 30), new Item(329, 1) }, new Item(29261), -1 , 2, -1),
	SIGN_OF_THE_PORTER_II(28, 5.9, Skills.DIVINATION, new Item[] { new Item(29315, 35), new Item(1656, 1) }, new Item(29279), -1 , 2, -1),
	COAL(29, 6, Skills.DIVINATION, new Item[] { new Item(29315, 2), new Item(440, 3) }, new Item(453), -1 , 2, -1),
	BOON_OF_GLOWING_ENERGY(30, 7, Skills.DIVINATION, new Item[] { new Item(29315, 500) }, new Item(29375), -1 , 2, -1),
	
	/*
	 * Glowing
	 */
	
	DIVINE_SALMON(30, 7, Skills.DIVINATION, new Item[] { new Item(29316, 45), new Item(331, 20) }, new Item(31083), -1 , 2, -1),
	DIVINE_WILLOW(31, 7.2, Skills.DIVINATION, new Item[] { new Item(29316, 20), new Item(1519, 20) }, new Item(29306), -1 , 2, -1),
	DIVINE_COAL(31, 7.2, Skills.DIVINATION, new Item[] { new Item(29316, 30), new Item(453, 20) }, new Item(29296), -1 , 2, -1),
	WILLOW_LOGS(32, 7.3, Skills.DIVINATION, new Item[] { new Item(29316, 2), new Item(1521, 3) }, new Item(1519), -1 , 2, -1),
	UNCUT_RUBY(33, 7.4, Skills.DIVINATION, new Item[] { new Item(29316, 2), new Item(1621, 3) }, new Item(1619), -1 , 2, -1),
	DIVINE_DEADFALL(34, 7.5, Skills.DIVINATION, new Item[] { new Item(29316, 45), new Item(10113, 24) }, new Item(29302), -1 , 2, -1),
	PORTENT_OF_RESTORATION_IV(35, 7.6, Skills.DIVINATION, new Item[] { new Item(29316, 30), new Item(361, 1) }, new Item(29245), -1 , 2, -1),
	RAW_TUNA(36, 7.7, Skills.DIVINATION, new Item[] { new Item(29316, 2), new Item(335, 4) }, new Item(359), -1 , 2, -1),
	ATTUNED_PORTENT_OF_RESTORATION_IV(37, 7.8, Skills.DIVINATION, new Item[] { new Item(29316, 30), new Item(361, 1) }, new Item(29262), -1 , 2, -1),
	SIGN_OF_RESPITE_III(38, 7.9, Skills.DIVINATION, new Item[] { new Item(29316, 35), new Item(3211, 4) }, new Item(29273), -1 , 2, -1),
	GOLD_ORE(39, 8, Skills.DIVINATION, new Item[] { new Item(29316, 2), new Item(442, 3) }, new Item(444), -1 , 2, -1),
	BOON_OF_SPARKLING_ENERGY(40, 9, Skills.DIVINATION, new Item[] { new Item(29316, 600) }, new Item(29376), -1 , 2, -1),
	
	/*
	 * Sparkling
	 *
	
	DIVINE_LOBSTER(41, 10, Skills.DIVINATION, new Item[] { new Item(29317, 70), new Item(377, 20) }, new Item(31084), -1 , 2, -1),
	UNCUT_DIAMOND(42, 9.1, Skills.DIVINATION, new Item[] { new Item(29317, 2), new Item(1619, 3) }, new Item(1617), -1 , 2, -1),
	DIVINE_MAPLE_TREE(44, 9.3, Skills.DIVINATION, new Item[] { new Item(29317, 25), new Item(1517, 20) }, new Item(29307), -1 , 2, -1),
	PORTENT_OF_RESTORATION_V(45, 9.4, Skills.DIVINATION, new Item[] { new Item(29317, 35), new Item(379, 1) }, new Item(29213), -1 , 2, -1),
	RAW_BASS(46, 9.6, Skills.DIVINATION, new Item[] { new Item(29317, 2), new Item(359, 3) }, new Item(363), -1 , 2, -1),
	ATTUNED_PORTENT_OF_RESTORATION_V(47, 9.7, Skills.DIVINATION, new Item[] { new Item(29317, 35), new Item(379, 1) }, new Item(29263), -1 , 2, -1),
	SIGN_OF_THE_PORTER_III(48, 9.9, Skills.DIVINATION, new Item[] { new Item(29317, 40), new Item(1658) }, new Item(29279), -1 , 2, -1),
	MAPLE_LOGS(49, 10, Skills.DIVINATION, new Item[] { new Item(1519, 3), new Item(29317, 2) }, new Item(1517), -1 , 2, -1),
	BOON_OF_GLEAMING_ENERGY(50, 11, Skills.DIVINATION, new Item[] { new Item(29317, 800) }, new Item(29377), -1 , 2, -1),
	
	/*
	 * Gleaming
	 *
	
	DIVINE_HERB_II(51, 11.3, Skills.DIVINATION, new Item[] { new Item(29318, 20), new Item(259, 20) }, new Item(29310), -1 , 2, -1),
	DIVINE_SWORDFISH(53, 13, Skills.DIVINATION, new Item[] { new Item(29318, 70), new Item(371, 20) }, new Item(31085), -1 , 2, -1),
	PORTENT_OF_RESTORATION_VI(55, 11.5, Skills.DIVINATION, new Item[] { new Item(29318, 40), new Item(373, 1) }, new Item(29214), -1 , 2, -1),
	ATTUNED_PORTENT_OF_RESTORATION_VI(57, 11.8, Skills.DIVINATION, new Item[] { new Item(29318, 40), new Item(373, 1) }, new Item(29264), -1 , 2, -1),
	UNCUT_DRAGONSTONE(58, 12, Skills.DIVINATION, new Item[] { new Item(29318, 2), new Item(1617, 5) }, new Item(1631), -1 , 2, -1),
	BOON_OF_VIBRANT_ENERGY(60, 13, Skills.DIVINATION, new Item[] { new Item(29318, 1000) }, new Item(29378), -1 , 2, -1),
	
	/*
	 * Vibrant
	 *
	
	DIVINE_MITHRIL(61, 13.1, Skills.DIVINATION, new Item[] { new Item(29319, 30), new Item(447, 20) }, new Item(29297), -1 , 2, -1),
	DIVINE_YEW(62, 13.2, Skills.DIVINATION, new Item[] { new Item(29319, 30), new Item(1515, 20) }, new Item(29308), -1 , 2, -1),
	MITHRIL_ORE(63, 13.3, Skills.DIVINATION, new Item[] { new Item(29319, 2), new Item(453, 3) }, new Item(447), -1 , 2, -1),
	GREEN_CHARM(64, 134, Skills.DIVINATION, new Item[] { new Item(29319, 250), new Item(12158, 20) }, new Item(12159, 10), -1 , 2, -1),
	DIVINE_BOX(64, 13.4, Skills.DIVINATION, new Item[] { new Item(29319, 45), new Item(9976, 20) }, new Item(29303), -1 , 2, -1),
	PORTENT_OF_RESTORATION_VII(65, 13.6, Skills.DIVINATION, new Item[] { new Item(29319, 45), new Item(7946, 1) }, new Item(29214), -1 , 2, -1),
	RAW_MONKFISH(66, 13.7, Skills.DIVINATION, new Item[] { new Item(29319, 2), new Item(363, 3) }, new Item(7944), -1 , 2, -1),
	ATTUNED_PORTENT_OF_RESTORATION_VII(67, 13.8, Skills.DIVINATION, new Item[] { new Item(29319, 45), new Item(7946, 1) }, new Item(29264), -1 , 2, -1),
	SIGN_OF_THE_PORTER_IV(68, 13.9, Skills.DIVINATION, new Item[] { new Item(29319, 45), new Item(1658) }, new Item(29281), -1 , 2, -1),
	SIGN_OF_ITEM_PROTECTION(69, 14, Skills.DIVINATION, new Item[] { new Item(29319, 45), new Item(2434, 4) }, new Item(29287), -1 , 2, -1),
	BOON_OF_LUSTROUS_ENERGY(70, 15, Skills.DIVINATION, new Item[] { new Item(29319, 1250) }, new Item(29379), -1 , 2, -1),
	
	/*
	 * LUSTROUS
	 *
	
	YEW_LOGS(72, 15.2, Skills.DIVINATION, new Item[] { new Item(29320, 2), new Item(1517, 3) }, new Item(1515), -1 , 2, -1),
	DIVINE_ADAMANTITE(73, 15.3, Skills.DIVINATION, new Item[] { new Item(29320, 40), new Item(449, 25) }, new Item(29298), -1 , 2, -1),
	CRIMSON_CHARM(74, 154, Skills.DIVINATION, new Item[] { new Item(29320, 750), new Item(12159, 30) }, new Item(12160), -1 , 2, -1),
	PORTENT_OF_RESTORATION_VIII(75, 15.5, Skills.DIVINATION, new Item[] { new Item(29320, 50), new Item(385, 1) }, new Item(29216), -1 , 2, -1),
	ADAMANT_ORE(76, 15.7, Skills.DIVINATION, new Item[] { new Item(29320, 2), new Item(447, 3) }, new Item(449), -1 , 2, -1),
	ATTUNED_PORTENT_OF_RESTORATION_VIII(77, 15.8, Skills.DIVINATION, new Item[] { new Item(29320, 50), new Item(385, 1) }, new Item(29266), -1 , 2, -1),
	SIGN_OF_LIFE(78, 16, Skills.DIVINATION, new Item[] { new Item(29320, 100), new Item(1643, 1) }, new Item(29290), -1 , 2, -1),
	DIVINE_SHARK(79, 16, Skills.DIVINATION, new Item[] { new Item(29320, 60), new Item(383, 20) }, new Item(31086), -1 , 2, -1),
	BOON_OF_BRILLIANT_ENERGY(80, 17, Skills.DIVINATION, new Item[] { new Item(29320, 1500) }, new Item(29380), -1 , 2, -1),
	
	/*
	 * ELDER
	 *
	//todo add nihil parts
	
	DIVINE_SIMULACRUM_I(75, 16, Skills.DIVINATION, new Item[] { new Item(31312, 100) }, new Item(31310), -1 , 2, -1),
	PORTENT_OF_DEGREDATION_I(75, 15.5, Skills.DIVINATION, new Item[] { new Item(31312, 50), new Item(385, 1) }, new Item(31313), -1 , 2, -1),
	ATTUNED_PORTENT_OF_DEGREDATION_I(77, 15.8, Skills.DIVINATION, new Item[] { new Item(31312, 50), new Item(385, 1) }, new Item(31319), -1 , 2, -1),
	SIGN_OF_DEATH(79, 16, Skills.DIVINATION, new Item[] { new Item(31312, 100), new Item(1643, 1) }, new Item(31322), -1 , 2, -1),
	AVIANSIE_TALONS(81, 1, Skills.DIVINATION, new Item[] { new Item(31312, 10), new Item(-1, 1) }, new Item(31421), -1 , 2, -1),
	DEMON_HORN(81, 1, Skills.DIVINATION, new Item[] { new Item(31312, 10), new Item(-1, 1) }, new Item(31420), -1 , 2, -1),
	ICYENE_FEATHER(81, 1, Skills.DIVINATION, new Item[] { new Item(31312, 10), new Item(-1, 1) }, new Item(31419), -1 , 2, -1),
	VAMPYRE_FANGS(81, 1, Skills.DIVINATION, new Item[] { new Item(31312, 10), new Item(-1, 1) }, new Item(31418), -1 , 2, -1),
	PORTENT_OF_DEGREDATION_II(86, 19.3, Skills.DIVINATION, new Item[] { new Item(31312, 50), new Item(15266, 1) }, new Item(31315), -1 , 2, -1),
	ATTUNED_PORTENT_OF_DEGREDATION_II(87, 19.7, Skills.DIVINATION, new Item[] { new Item(31312, 50), new Item(15266, 1) }, new Item(31320), -1 , 2, -1),
	DIVINE_SIMULACRUM_II(92, 16, Skills.DIVINATION, new Item[] { new Item(31312, 100) }, new Item(31311), -1 , 2, -1),
	PORTENT_OF_DEGREDATION_III(97, 23.4, Skills.DIVINATION, new Item[] { new Item(31312, 60), new Item(15277, 1) }, new Item(31317), -1 , 2, -1),
	ATTUNED_PORTENT_OF_DEGREDATION_III(98, 23.6, Skills.DIVINATION, new Item[] { new Item(31312, 60), new Item(15277, 1) }, new Item(31321), -1 , 2, -1),
	PORTENT_OF_DEATH(99, 24, Skills.DIVINATION, new Item[] { new Item(31312, 100), new Item(1643, 1) }, new Item(31324), -1 , 2, -1),
	BOON_OF_ELDER_ENERGY(75, 16, Skills.DIVINATION, new Item[] { new Item(31312, 1375) }, new Item(31325), -1 , 2, -1),
	
	/*
	* Brilliant
	*
	
	DIVINE_HERB_III(82, 17.5, Skills.DIVINATION, new Item[] { new Item(29197, 10), new Item(265, 5) }, new Item(29312), -1 , 2, -1),
	DIVINE_MAGIC(83, 18, Skills.DIVINATION, new Item[] { new Item(29197, 40), new Item(1513, 5) }, new Item(29309), -1 , 2, -1),
	BLUE_CHARM(84, 174, Skills.DIVINATION, new Item[] { new Item(29197, 1500), new Item(12160, 20) }, new Item(12163, 10), -1 , 2, -1),
	BOON_OF_RADIANT_ENERGY(85, 19, Skills.DIVINATION, new Item[] { new Item(29197, 1750) }, new Item(29381), -1 , 2, -1),
	
	/*
	 * RADIANT
	 *
	
	PORTENT_OF_RESTORATION_IX(86, 19.3, Skills.DIVINATION, new Item[] { new Item(29198, 50), new Item(15266, 1) }, new Item(29255), -1 , 2, -1),
	ATTUNED_PORTENT_OF_RESTORATION_IX(87, 19.7, Skills.DIVINATION, new Item[] { new Item(29198, 50), new Item(15266, 1) }, new Item(29267), -1 , 2, -1),
	SIGN_OF_THE_PORTER_V(88, 20, Skills.DIVINATION, new Item[] { new Item(29198, 60), new Item(1660, 1) }, new Item(29283), -1 , 2, -1),
	DIVINE_CAVEFISH(89, 20, Skills.DIVINATION, new Item[] { new Item(29198, 70), new Item(15264, 15) }, new Item(31087), -1 , 2, -1),
	BOON_OF_LUMINOUS_ENERGY(90, 21, Skills.DIVINATION, new Item[] { new Item(29198, 2000) }, new Item(29382), -1 , 2, -1),
	
	/*
	 * Luminous
	 *
	
	DIVINE_ROCKTAIL(91, 21, Skills.DIVINATION, new Item[] { new Item(29323, 80), new Item(15270, 10) }, new Item(31088), -1 , 2, -1),
	PORTENT_OF_ITEM_PROTECTION(92, 21.3, Skills.DIVINATION, new Item[] { new Item(29323, 60), new Item(2434, 4) }, new Item(29289), -1 , 2, -1),
	MAGIC_LOGS(93, 21.7, Skills.DIVINATION, new Item[] { new Item(29323, 2), new Item(1515, 3) }, new Item(1513), -1 , 2, -1),
	DIVINE_RUNE(94, 22, Skills.DIVINATION, new Item[] { new Item(29323, 80), new Item(451, 6) }, new Item(29299), -1 , 2, -1),
	BOON_OF_INCANDESCENT_ENERGY(95, 23, Skills.DIVINATION, new Item[] { new Item(29323, 2250) }, new Item(29383), -1 , 2, -1),
	
	/*
	 * Incandescent
	 *
	
	RUNE_ORE(96, 23.2, Skills.DIVINATION, new Item[] { new Item(29324, 10), new Item(449, 6) }, new Item(451), -1 , 2, -1),
	PORTENT_OF_RESTORATION_X(97, 23.4, Skills.DIVINATION, new Item[] { new Item(29324, 60), new Item(15272, 1) }, new Item(29257), -1 , 2, -1),
	ATTUNED_PORTENT_OF_RESTORATION_X(98, 23.6, Skills.DIVINATION, new Item[] { new Item(29324, 60), new Item(15262, 1) }, new Item(29268), -1 , 2, -1),
	SIGN_OF_THE_PORTER_VI(99, 24, Skills.DIVINATION, new Item[] { new Item(29324, 80), new Item(1662) }, new Item(29285), -1 , 2, -1),
	PORTENT_OF_LIFE(99, 24, Skills.DIVINATION, new Item[] { new Item(29324, 100), new Item(1643) }, new Item(29292), -1 , 2, -1),
	*/
	;
	
	public static Constants getProduct(int id) {
		for(Constants bar : Constants.values()) {
		if(bar.getProduct().getId() == id)
			return bar;
		}
		return null;
	}
    
	private int skill, level, anim, craftTime, object;
	private double experience;
	private Item[] itemsRequired;
	private Item product;
    
	private Constants(int level, double experience, int skill, Item[] itemsRequired, Item product, int anim, int craftTime, int object) {
	    this.skill = skill;
	    this.level = level;
	    this.experience = experience;
	    this.itemsRequired = itemsRequired;
	    this.product = product;
	    this.anim = anim;
	    this.craftTime = craftTime;
	    this.object = object;
	}
    
	public Item[] getItemsRequired() {
	    return itemsRequired;
	}

	public int getLevel() {
	    return level;
	}
	
	public int getSkill() {
	    return skill;
	}

	public Item getProduct() {
	    return product;
	}

	public double getExperience() {
	    return experience;
	}
	
	public int getAnim() {
	    return anim;
	}
	
	public int getCraftTime() {
	    return craftTime;
	}

	public int getObject() {
	    return object;
	}
    }
}
