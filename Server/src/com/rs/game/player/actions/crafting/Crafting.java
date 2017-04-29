package com.rs.game.player.actions.crafting;

import com.rs.game.Animation;
import com.rs.game.WorldObject;
import com.rs.game.item.Item;
import com.rs.game.player.Player;
import com.rs.game.player.Skills;
import com.rs.game.player.actions.Action;
import com.rs.game.player.actions.crafting.Crafting.ForgingBar;
import com.rs.game.player.actions.crafting.GemCutting.Gem;
import com.rs.net.decoders.handlers.InventoryOptionsHandler;
import com.rs.utils.Utils;

public class Crafting extends Action {

    public static final int NEEDLE = 1733, THREAD = 1734, WATERVIAL = 227;
    int random = Utils.random(700);

    
    
    public enum ForgingBar {

		/**
		 * Leather Working
		 * Leather
		 */
		LEATHER_GLOVES(1, 13.8, 1741, 1733, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1059), 25594),
		LEATHER_BOOTS(7, 16.3, 1741, 1733, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1061), 25594),
		LEATHER_VAMBS(11, 22, 1741, 1733, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1063), 25594),
		LEATHER_CHAPS(18, 27, 1741, 1733, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1095), 25594),
		LEATHER_BODY(14, 25, 1741, 1733, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1129), 25594),
		LEATHER_COWL(9, 18.5, 1741, 1733, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1167), 25594),
		LEATHER_SHIELD(19, 30, 1741, 1733, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(25806), 25594),
		COIF(38, 37, 1741, 1733, Skills.CRAFTING, new Item[] { new Item(1741) }, new Item(1169), 25594),
		/*
		 * Hard Leather
		 */
		HARDLEATHER_GLOVES(25, 32, 1743, 1733, Skills.CRAFTING, new Item[] { new Item(1743), new Item(THREAD) }, new Item(25875), 1249),
		HARDLEATHER_BOOTS(27, 34, 1743, 1733, Skills.CRAFTING, new Item[] { new Item(1743), new Item(THREAD) }, new Item(25821), 1249),
		HEARDLEATHER_BODY(28, 35, 1743, 1733, Skills.CRAFTING, new Item[] { new Item(1743), new Item(THREAD) }, new Item(1131), 1249),
		HARDLEATHER_SHIELD(29, 36, 1743, 1733, Skills.CRAFTING, new Item[] { new Item(1743), new Item(THREAD) }, new Item(25808), 1249),
		/*
		 * Imphide
		 */
		IMPHIDE_GLOVES(10, 10, 25545, 1733, Skills.CRAFTING, new Item[] { new Item(25545), new Item(THREAD) }, new Item(25851), 1249),
		IMPHIDE_BOOTS(11, 10, 25545, 1733, Skills.CRAFTING, new Item[] { new Item(25545), new Item(THREAD) }, new Item(25853), 1249),
		IMPHIDE_HOOD(12, 20, 25545, 1733, Skills.CRAFTING, new Item[] { new Item(25545, 2), new Item(THREAD) }, new Item(25845), 1249),
		IMPHIDE_ROBE_BOTTOM(13, 20, 25545, 1733, Skills.CRAFTING, new Item[] { new Item(25545, 2), new Item(THREAD) }, new Item(25849), 1249),
		IMPHIDE_ROBE_TOP(14, 30, 25545, 1733, Skills.CRAFTING, new Item[] { new Item(25545, 3), new Item(THREAD) }, new Item(25847), 1249),
		IMPHIDE_BOOK(15, 30, 25545, 1733, Skills.CRAFTING, new Item[] { new Item(25545, 3), new Item(THREAD) }, new Item(25662), 1249),
		IMPHIDE_WAND(16, 30, 25545, 1733, Skills.CRAFTING, new Item[] { new Item(25545, 3), new Item(THREAD) }, new Item(25642), 1249),
		IMPHIDE_SHIELD(17, 40, 25545, 1733, Skills.CRAFTING, new Item[] { new Item(25545, 4), new Item(THREAD) }, new Item(25855), 1249),
		/*
		 * Spidersilk
		 */
		SPIDERSILK_GLOVES(20, 12.5, 25547, 1733, Skills.CRAFTING, new Item[] { new Item(25547), new Item(THREAD) }, new Item(25843), 1249),
		SPIDERSILK_BOOTS(21, 12.5, 25547, 1733, Skills.CRAFTING, new Item[] { new Item(25547), new Item(THREAD) }, new Item(25843), 1249),
		SPIDERSILK_HOOD(22, 25, 25547, 1733, Skills.CRAFTING, new Item[] { new Item(25547, 2), new Item(THREAD) }, new Item(25835), 1249),
		SPIDERSILK_ROBE_BOTTOM(23, 25, 25547, 1733, Skills.CRAFTING, new Item[] { new Item(25547, 2), new Item(THREAD) }, new Item(25839), 1249),
		SPIDERSILK_ROBE_TOP(24, 37.5, 25547, 1733, Skills.CRAFTING, new Item[] { new Item(25547, 3), new Item(THREAD) }, new Item(25837), 1249),
		SPIDERSILK_ORB(25, 25, 25547, 1733, Skills.CRAFTING, new Item[] { new Item(25547, 2), new Item(THREAD) }, new Item(25658), 1249),
		SPIDERSILK_WAND(26, 25, 25547, 1733, Skills.CRAFTING, new Item[] { new Item(25547, 2), new Item(THREAD) }, new Item(25650), 1249),
		/*
		 * Carapace
		 */
		CARAPACE_GLOVES(30, 12, 25551, 1733, Skills.CRAFTING, new Item[] { new Item(25551), new Item(THREAD) }, new Item(25865), 1249),
		CARAPACE_BOOTS(31, 12, 25551, 1733, Skills.CRAFTING, new Item[] { new Item(25551), new Item(THREAD) }, new Item(25863), 1249),
		CARAPACE_HELM(33, 24, 25551, 1733, Skills.CRAFTING, new Item[] { new Item(25551, 2), new Item(THREAD) }, new Item(25857), 1249),
		CARAPACE_LEGS(34, 24, 25551, 1733, Skills.CRAFTING, new Item[] { new Item(25551, 2), new Item(THREAD) }, new Item(25861), 1249),
		CARAPACE_TORSO(35, 36, 25551, 1733, Skills.CRAFTING, new Item[] { new Item(25551, 3), new Item(THREAD) }, new Item(25859), 1249),
		/*
		 * Batwing
		 */
		BATWING_GLOVES(50, 50, 25549, 1733, Skills.CRAFTING, new Item[] { new Item(25549), new Item(THREAD) }, new Item(25829), 1249),
		BATWING_BOOTS(52, 50, 25549, 1733, Skills.CRAFTING, new Item[] { new Item(25549), new Item(THREAD) }, new Item(25833), 1249),
		BATWING_HOOD(54, 100, 25549, 1733, Skills.CRAFTING, new Item[] { new Item(25549, 2), new Item(THREAD) }, new Item(25825), 1249),
		BATWING_LEGS(55, 100, 25549, 1733, Skills.CRAFTING, new Item[] { new Item(25549, 2), new Item(THREAD) }, new Item(25831), 1249),
		BATWING_TORSO(56, 150, 25549, 1733, Skills.CRAFTING, new Item[] { new Item(25549, 3), new Item(THREAD) }, new Item(25827), 1249),
		BATWING_SHIELD(58, 200, 25549, 1733, Skills.CRAFTING, new Item[] { new Item(25549, 4), new Item(THREAD) }, new Item(25802), 1249),
		BATWING_BOOK(59, 200, 25549, 1733, Skills.CRAFTING, new Item[] { new Item(25549, 4), new Item(THREAD) }, new Item(25660), 1249),
		BATWING_WAND(61, 200, 25549, 1733, Skills.CRAFTING, new Item[] { new Item(25549, 4), new Item(THREAD) }, new Item(25648), 1249),
		/*
		 * Snakeskin
		 */
		SNAKESKIN_BOOTS(45, 30, 6289, 1733, Skills.CRAFTING, new Item[] { new Item(6289, 6), new Item(THREAD) }, new Item(6328), 1249),
		SNAKESKIN_VAMBS(47, 35, 6289, 1733, Skills.CRAFTING, new Item[] { new Item(6289, 8), new Item(THREAD) }, new Item(6330), 1249),
		SNAKESKIN_BANDANA(48, 45, 6289, 1733, Skills.CRAFTING, new Item[] { new Item(6289, 5), new Item(THREAD) }, new Item(6326), 1249),
		SNAKESKIN_CHAPS(51, 50, 6289, 1733, Skills.CRAFTING, new Item[] { new Item(6289, 12), new Item(THREAD) }, new Item(6324), 1249),
		SNAKESKIN_BODY(53, 55, 6289, 1733, Skills.CRAFTING, new Item[] { new Item(6289, 15), new Item(THREAD) }, new Item(6322), 1249),
		/*
		 * Green d'hide
		 */
		GREEN_D_VAMBS(57, 62, 1745, 1733, Skills.CRAFTING, new Item[] { new Item(1745), new Item(THREAD) }, new Item(1065), 1249),
		GREEN_D_CHAPS(60, 124, 1745, 1733, Skills.CRAFTING, new Item[] { new Item(1745, 2), new Item(THREAD) }, new Item(1099), 1249),
		GREEN_D_BODY(63, 186, 1745, 1733, Skills.CRAFTING, new Item[] { new Item(1745, 3), new Item(THREAD) }, new Item(1135), 1249),
		GREEN_D_SHIELD(64, 248, 1745, 1733, Skills.CRAFTING, new Item[] { new Item(1745, 4), new Item(THREAD) }, new Item(25794), 1249),
		/*
		 * Blue d'hide
		 */
		BLUE_D_VAMBS(66, 70, 2505, 1733, Skills.CRAFTING, new Item[] { new Item(2505), new Item(THREAD) }, new Item(2487), 1249),
		BLUE_D_CAHPS(68, 140, 2505, 1733, Skills.CRAFTING, new Item[] { new Item(2505, 2), new Item(THREAD) }, new Item(2493), 1249),
		BLUE_D_BODY(71, 210, 2505, 1733, Skills.CRAFTING, new Item[] { new Item(2505, 3), new Item(THREAD) }, new Item(2499), 1249),
		BLUE_D_SHIELD(72, 280, 2505, 1733, Skills.CRAFTING, new Item[] { new Item(2505, 4), new Item(THREAD) }, new Item(25796), 1249),
		/*
		 * Red d'hide
		 */
		RED_D_VAMBS(73, 78, 2507, 1733, Skills.CRAFTING, new Item[] { new Item(2507), new Item(THREAD) }, new Item(2489), 1249),
		RED_D_CHAPS(75, 156, 2507, 1733, Skills.CRAFTING, new Item[] { new Item(2507, 2), new Item(THREAD) }, new Item(2495), 1249),
		RED_D_BODY(77, 234, 2507, 1733, Skills.CRAFTING, new Item[] { new Item(2507, 3), new Item(THREAD) }, new Item(2501), 1249),
		RED_D_SHIELD(78, 312, 2507, 1733, Skills.CRAFTING, new Item[] { new Item(2507, 4), new Item(THREAD) }, new Item(25798), 1249),
		/*
		 * Black d'hide
		 */
		BLACK_D_VAMBS(79, 86, 2509, 1733, Skills.CRAFTING, new Item[] { new Item(2509), new Item(THREAD) }, new Item(2491), 1249),
		BLACK_D_CAHPS(82, 172, 2509, 1733, Skills.CRAFTING, new Item[] { new Item(2509, 2), new Item(THREAD) }, new Item(2497), 1249),
		BLACK_D_BODY(84, 258, 2509, 1733, Skills.CRAFTING, new Item[] { new Item(2509, 3), new Item(THREAD) }, new Item(2503), 1249),
		BLACK_D_SHIELD(85, 344, 2509, 1733, Skills.CRAFTING, new Item[] { new Item(2509, 4), new Item(THREAD) }, new Item(25801), 1249),
		/*
		 * Royal d'hide
		 */
		RYOAL_D_VAMBS(87, 94, 24374, 1733, Skills.CRAFTING, new Item[] { new Item(24374), new Item(THREAD) }, new Item(24376), 1249),
		RYOAL_D_CHAPS(89, 188, 24374, 1733, Skills.CRAFTING, new Item[] { new Item(24374, 2), new Item(THREAD) }, new Item(24379), 1249),
		RYOAL_D_BODY(93, 282, 24374, 1733, Skills.CRAFTING, new Item[] { new Item(24374, 3), new Item(THREAD) }, new Item(24382), 1249),
		/*
		 * Yak-hide
		 */
		YAKHIDE_LEGS(43, 32, 10820, 1733, Skills.CRAFTING, new Item[] { new Item(10820), new Item(THREAD) }, new Item(10824), 1249),
		YAKHIDE_TOP(46, 32, 10820, 1733, Skills.CRAFTING, new Item[] { new Item(10820, 2), new Item(THREAD) }, new Item(10822), 1249),
		/*
		 * Enhancements
		 */
		SPIKY_VAMBS(32, 5.8, 10113, 1063, Skills.CRAFTING, new Item[] { new Item(1063), new Item(10113) }, new Item(10077), 1249),
		GREEN_SPIKY_VAMBS(32, 5.8, 10113, 1065, Skills.CRAFTING, new Item[] { new Item(1065), new Item(10113) }, new Item(10079), 1249),
		BLUE_SPIKY_VAMBS(32, 5.8, 10113, 2487, Skills.CRAFTING, new Item[] { new Item(2487), new Item(10113) }, new Item(10081), 1249),
		RED_SPIKY_VAMBS(32, 5.8, 10113, 2489, Skills.CRAFTING, new Item[] { new Item(2489), new Item(10113) }, new Item(10083), 1249),
		BLACK_SPIKY_VAMBS(32, 5.8, 10113, 2491, Skills.CRAFTING, new Item[] { new Item(2491), new Item(10113) }, new Item(10085), 1249),
		ROYAL_SPIKY_VAMBS(32, 5.8, 10113, 24376, Skills.CRAFTING, new Item[] { new Item(24376), new Item(10113) }, new Item(25553), 1249),
		STUDDED_CHAPS(44, 42, 2370, 1095, Skills.CRAFTING, new Item[] { new Item(1095), new Item(2370) }, new Item(1097), 1249),
		STUDDED_BODY(41, 40, 2370, 1129, Skills.CRAFTING, new Item[] { new Item(1129), new Item(2370) }, new Item(1133), 1249),
		STUDDED_GLOVES(42, 40, 2370, 1059, Skills.CRAFTING, new Item[] { new Item(1059), new Item(2370) }, new Item(25877), 1249),
		STUDDED_BOOTS(43, 42, 2370, 1061, Skills.CRAFTING, new Item[] { new Item(1061), new Item(2370) }, new Item(25823), 1249),
		STUDDED_SHIELD(45, 43, 2370, 25806, Skills.CRAFTING, new Item[] { new Item(25806), new Item(2370) }, new Item(25810), 1249),
		/**
		 * Misc Crafting
		 * Crab 
		 */
		CRAB_HELMET(15, 32.5, 7538, 1733, Skills.CRAFTING, new Item[] { new Item(7538) }, new Item(7539), 1249),
		CRAB_CLAW(15, 32.5, 7536, 1733, Skills.CRAFTING, new Item[] { new Item(7536) }, new Item(7537), 1249),
		/*
		 * Battlestaves
		 */
		WATTER_BATTLESTAFF(54, 100, 1391, 571, Skills.CRAFTING, new Item[] { new Item(1391), new Item(571) }, new Item(1395), 16448),
		EARTH_BATTLESTAFF(58, 112.5, 1391, 575, Skills.CRAFTING, new Item[] { new Item(1391), new Item(575) }, new Item(1399), 16447),
		FIRE_BATTLESTAFF(62, 125, 1391, 569, Skills.CRAFTING, new Item[] { new Item(1391), new Item(569) }, new Item(1393), 16449),
		AIR_BATTLESTAFF(66, 137.5, 1391, 573, Skills.CRAFTING, new Item[] { new Item(1391), new Item(573) }, new Item(1397), 16446),
		ARMADYL_BATTLESTAFF(77, 150, 1391, 21775, Skills.CRAFTING, new Item[] { new Item(1391), new Item(21775) }, new Item(21777), 16450),
		/*
		 * Snelms
		 */
		MYRE_SNELM(15, 32.5, 3345, 1755, Skills.CRAFTING, new Item[] { new Item(3345) }, new Item(3327), 1249),
		MYRE_SNELM2(15, 32.5, 3355, 1755, Skills.CRAFTING, new Item[] { new Item(3355) }, new Item(3337), 1249),
		BLOODNTAR_SNELM(15, 32.5, 3347, 1755, Skills.CRAFTING, new Item[] { new Item(3347) }, new Item(3329), 1249),
		BLOODNTAR_SNELM2(15, 32.5, 3357, 1755, Skills.CRAFTING, new Item[] { new Item(3357) }, new Item(3339), 1249),
		OCHRE_SNELM(15, 32.5, 3349, 1755, Skills.CRAFTING, new Item[] { new Item(3349) }, new Item(3331), 1249),
		OCHRE_SNELM2(15, 32.5, 3359, 1755, Skills.CRAFTING, new Item[] { new Item(3359) }, new Item(3341), 1249),
		BRUISE_SNELM(15, 32.5, 3351, 1755, Skills.CRAFTING, new Item[] { new Item(3351) }, new Item(3333), 1249),
		BRUISE_SNELM2(15, 32.5, 3361, 1755, Skills.CRAFTING, new Item[] { new Item(3361) }, new Item(3343), 1249),
		BROKENBARK_SNELM(15, 32.5, 3353, 1755, Skills.CRAFTING, new Item[] { new Item(3353) }, new Item(3335), 1249),
		/*
		 * Amulet stringing
		 */
		MONKEYSPEAK_AMULET(1, 0, 4022, 1759, Skills.CRAFTING, new Item[] { new Item(4022), new Item(1759) }, new Item(4021), 1249),
		UNBLESSED_SYMBOL(16, 4, 1714, 1759, Skills.CRAFTING, new Item[] { new Item(1714), new Item(1759) }, new Item(1716), 1249),
		UNPOWERED_SYMBOL(17, 4, 1720, 1759, Skills.CRAFTING, new Item[] { new Item(1720), new Item(1759) }, new Item(1722), 1249),
		GOLD_AMULET(8, 4, 1673, 1759, Skills.CRAFTING, new Item[] { new Item(1673), new Item(1759) }, new Item(1692), 1249),
		SAPPHIRE_AMULET(24, 4, 1675, 1759, Skills.CRAFTING, new Item[] { new Item(1675), new Item(1759) }, new Item(1694), 1249),
		STRUNG_RABBIT_FOOT(37, 4, 10134, 1759, Skills.CRAFTING, new Item[] { new Item(10134), new Item(1759) }, new Item(10132), 1249),
		EMERALD_AMULET(31, 4, 1677, 1759, Skills.CRAFTING, new Item[] { new Item(1677), new Item(1759) }, new Item(1696), 1249),
		PRENATURE_AMULET(8, 4, 1677, 6038, Skills.CRAFTING, new Item[] { new Item(1677), new Item(6038) }, new Item(6041), 1249),
		RUBY_AMULET(50, 4, 1679, 1759, Skills.CRAFTING, new Item[] { new Item(1679), new Item(1759) }, new Item(1698), 1249),
		DIAMOND_AMULET(70, 4, 1681, 1759, Skills.CRAFTING, new Item[] { new Item(1681), new Item(1759) }, new Item(1700), 1249),
		DRAGONSTONE_AMULET(80, 4, 1683, 1759, Skills.CRAFTING, new Item[] { new Item(1683), new Item(1759) }, new Item(1702), 1249),
		ONYX_AMULET(90, 4, 6579, 1759, Skills.CRAFTING, new Item[] { new Item(6579), new Item(1759) }, new Item(6581), 1249),
		HYDRIX_AMULET(99, 4, 31861, 1759, Skills.CRAFTING, new Item[] { new Item(31861), new Item(1759) }, new Item(31863), 1249),
		/**
		 * Glass Blowing
		 * Molten glass
		 */
		BEER_GLASS(1, 17.5, 1775, 1785, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(1919), 884),
		CANDLE_LANTERN(4, 19, 1775, 1785, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(4527), 884),
		OIL_LAMP(12, 25, 1775, 1785, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(4525), 884),
		VIAL(33, 35, 1775, 1785, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(229), 884),
		FISHBOWL(42, 42.5, 1775, 1785, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(6667), 884),
		UNPOERED_ORB(46, 52.5, 1775, 1785, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(567), 884),
		LANTERN_LENS(49, 55, 1775, 1785, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(4542), 884),
		EMPTY_LIGHT_ORB(87, 70, 1775, 1785, Skills.CRAFTING, new Item[] { new Item(1775) }, new Item(10980), 884),
		/*
		 * Robust glass
		 */
		POTION_FLASK(89, 100, 23193, 1785, Skills.CRAFTING, new Item[] { new Item(23193) }, new Item(23191), 884),
		/*
		 * Crystal glass
		 */
		CRYSTAL_FLASK(89, 150, 32845, 1785, Skills.CRAFTING, new Item[] { new Item(32845) }, new Item(32843), 884),
		/**
		 * Herblore
		 * Herb cleaning
		 */
		GUAM(1, 2.5, 199, 199, Skills.HERBLORE, new Item[] { new Item(199) }, new Item(249), -1),
		SNAKE_WEED(3, 2.5, 1525, 1525, Skills.HERBLORE, new Item[] { new Item(1525) }, new Item(1526), -1),
		ARDRIGAL(3, 2.5, 1527, 1527, Skills.HERBLORE, new Item[] { new Item(1527) }, new Item(1528), -1),
		RGOUES_PURSE(3, 2.5, 1533, 1533, Skills.HERBLORE, new Item[] { new Item(1533) }, new Item(1534), -1),
		SITO_FOIL(3, 2.5, 1529, 1529, Skills.HERBLORE, new Item[] { new Item(1529) }, new Item(1530), -1),
		VOLENCIA_MOSS(3, 2.5, 1531, 1531, Skills.HERBLORE, new Item[] { new Item(1531) }, new Item(1532), -1),
		MARRENTILL(9, 5, 201, 201, Skills.HERBLORE, new Item[] { new Item(201) }, new Item(251), -1),
		TARROMIN(5, 3.8, 203, 203, Skills.HERBLORE, new Item[] { new Item(203) }, new Item(253), -1),
		HARRALANDER(20, 6.3, 205, 205, Skills.HERBLORE, new Item[] { new Item(205) }, new Item(255), -1),
		RANARR(25, 7.5, 207, 207, Skills.HERBLORE, new Item[] { new Item(207) }, new Item(257), -1),
		TOADFLAX(30, 8, 3049, 3049, Skills.HERBLORE, new Item[] { new Item(3049) }, new Item(2998), -1),
		SPIRIT_WEED(35, 7.8, 12174, 12174, Skills.HERBLORE, new Item[] { new Item(12174) }, new Item(12172), -1),
		IRIT(40, 8.8, 209, 209, Skills.HERBLORE, new Item[] { new Item(209) }, new Item(259), -1),
		WERGALI(41, 9.5, 14836, 14836, Skills.HERBLORE, new Item[] { new Item(14836) }, new Item(14854), -1),
		AVANTOE(48, 10, 211, 211, Skills.HERBLORE, new Item[] { new Item(211) }, new Item(261), -1),
		KWUARM(54, 11.3, 213, 213, Skills.HERBLORE, new Item[] { new Item(213) }, new Item(263), -1),
		SNAPDRAGON(59, 11.8, 3051, 3051, Skills.HERBLORE, new Item[] { new Item(3051) }, new Item(3000), -1),
		CADANTINE(65, 12.5, 215, 215, Skills.HERBLORE, new Item[] { new Item(215) }, new Item(265), -1),
		LANTADYME(67, 13.1, 1485, 1485, Skills.HERBLORE, new Item[] { new Item(1485) }, new Item(2481), -1),
		DWARF_WEED(70, 13.8, 217, 217, Skills.HERBLORE, new Item[] { new Item(217) }, new Item(267), -1),
		TORSTOL(75, 15, 219, 219, Skills.HERBLORE, new Item[] { new Item(219) }, new Item(269), -1),
		FELLSTALK(91, 16.8, 21626, 21626, Skills.HERBLORE, new Item[] { new Item(21626) }, new Item(21624), -1),
		/*
		 * Unfinished potions
		 */
		COCONUT_MILK(1, 1, 5976, 229, Skills.HERBLORE, new Item[] { new Item(5976), new Item(229) }, new Item(5935), 363),
		GUAM_POT(1, 1, 249, 227, Skills.HERBLORE, new Item[] { new Item(249), new Item(227) }, new Item(91), 363),
		SNAKEWEED_MIXTURE(3, 1, 1526, 227, Skills.HERBLORE, new Item[] { new Item(1526), new Item(227) }, new Item(737), 363),
		ARDRIGAL_MIXTURE(3, 1, 1528, 227, Skills.HERBLORE, new Item[] { new Item(1528), new Item(227) }, new Item(738), 363),
		ROGUESPURSE_POT(5, 1, 1534, 227, Skills.HERBLORE, new Item[] { new Item(1534), new Item(227) }, new Item(4840), 363),
		TARROMIN_POT(5, 1, 253, 227, Skills.HERBLORE, new Item[] { new Item(253), new Item(227) }, new Item(95), 363),
		MARRENTILL_POT(9, 1, 251, 227, Skills.HERBLORE, new Item[] { new Item(251), new Item(227) }, new Item(93), 363),
		HARRALANDER_POT(18, 1, 255, 227, Skills.HERBLORE, new Item[] { new Item(255), new Item(227) }, new Item(97), 363),
		RANARR_POT(25, 1, 257, 227, Skills.HERBLORE, new Item[] { new Item(257), new Item(227) }, new Item(99), 363),
		TOADFLAX_POT(30, 1, 2998, 227, Skills.HERBLORE, new Item[] { new Item(2998), new Item(227) }, new Item(3002), 363),
		SPIRITWEED_POT(35, 1, 12172, 227, Skills.HERBLORE, new Item[] { new Item(12172), new Item(227) }, new Item(12181), 363),
		IRIT_POT(40, 1, 259, 227, Skills.HERBLORE, new Item[] { new Item(259), new Item(227) }, new Item(101), 363),
		WERGALI_POT(41, 1, 14854, 227, Skills.HERBLORE, new Item[] { new Item(14854), new Item(227) }, new Item(14856), 363),
		AVANTOE_POT(48, 1, 261, 227, Skills.HERBLORE, new Item[] { new Item(261), new Item(227) }, new Item(103), 363),
		KWUARM_POT(54, 1, 263, 227, Skills.HERBLORE, new Item[] { new Item(263), new Item(227) }, new Item(105), 363),
		MAGIC_ESSENCEU(57, 1, 9017, 227, Skills.HERBLORE, new Item[] { new Item(9017), new Item(227) }, new Item(26809), 363),
		SNAPDRAGON_POT(59, 1, 3000, 227, Skills.HERBLORE, new Item[] { new Item(3000), new Item(227) }, new Item(3004), 363),
		CADANTINE_POT(65, 1, 265, 227, Skills.HERBLORE, new Item[] { new Item(265), new Item(227) }, new Item(107), 363),
		LANTADYME_POT(67, 1, 2481, 227, Skills.HERBLORE, new Item[] { new Item(2481), new Item(227) }, new Item(2483), 363),
		ANTIPOISONPU(68, 1, 2998, 5935, Skills.HERBLORE, new Item[] { new Item(2998), new Item(5935) }, new Item(5942), 363),
		DWARFWEED_POT(70, 1, 267, 227, Skills.HERBLORE, new Item[] { new Item(267), new Item(227) }, new Item(109), 363),
		WEAPON_POTP(73, 1, 6016, 5935, Skills.HERBLORE, new Item[] { new Item(6016), new Item(5935) }, new Item(5936), 363),
		TORSTOL_POT(75, 1, 269, 227, Skills.HERBLORE, new Item[] { new Item(269), new Item(227) }, new Item(111), 363),
		ANTIPOISONPPU(79, 1, 5935, 227, Skills.HERBLORE, new Item[] { new Item(259), new Item(5935) }, new Item(5951), 363),
		WEAPON_POTPP(82, 1, 2398, 5935, Skills.HERBLORE, new Item[] { new Item(2398), new Item(5935) }, new Item(5939), 363),
		FELLSTALK_POT(91, 1, 21624, 227, Skills.HERBLORE, new Item[] { new Item(21624), new Item(227) }, new Item(21628), 363),
		/*
		 * Potions
		 */
		ATTACK_POT(1, 25, 91, 221, Skills.HERBLORE, new Item[] { new Item(91), new Item(221) }, new Item(121), 363),
		RANGING_POT(3, 30, 91, 1951, Skills.HERBLORE, new Item[] { new Item(91), new Item(1951) }, new Item(27506), 363),
		MAGIC_POT(5, 35, 95, 1474, Skills.HERBLORE, new Item[] { new Item(95), new Item(1474) }, new Item(27514), 363),
		STRENGTH_POT(7, 40, 95, 225, Skills.HERBLORE, new Item[] { new Item(95), new Item(225) }, new Item(115), 363),
		RELICYMS_BALM(8, 40, 1526, 4840, Skills.HERBLORE, new Item[] { new Item(4840), new Item(1526) }, new Item(4844), 363),
		DEFENCE_POT(9, 45, 93, 948, Skills.HERBLORE, new Item[] { new Item(948), new Item(93) }, new Item(133), 363),
		ANTIPOISON(13, 50, 93, 235, Skills.HERBLORE, new Item[] { new Item(235), new Item(93) }, new Item(175), 363),
		SERUM207(15, 50, 95, 592, Skills.HERBLORE, new Item[] { new Item(592), new Item(95) }, new Item(3410), 363),
		GUTHIX_REST(18, 59.5, 97, 251, Skills.HERBLORE, new Item[] { new Item(251), new Item(97) }, new Item(4419), 363),
		RESTORE_POT(22, 62.5, 97, 223, Skills.HERBLORE, new Item[] { new Item(97), new Item(223) }, new Item(127), 363),
		GUTHIX_BALANCE_U(22, 25, 1550, 127, Skills.HERBLORE, new Item[] { new Item(127), new Item(1550) }, new Item(7654), 363),
		GUTHIX_BALANCE(22, 25, 7654, 7650, Skills.HERBLORE, new Item[] { new Item(7654), new Item(7650) }, new Item(7662), 363),
		BLAMISH_OIL(25, 80, 97, 1581, Skills.HERBLORE, new Item[] { new Item(97), new Item(1581) }, new Item(1582), 363),
		ENERGY_POT(26, 67.5, 97, 1975, Skills.HERBLORE, new Item[] { new Item(1975), new Item(97) }, new Item(3010), 363),
		SUPER_FISHING_EXPLOSIBE(31, 55, 91, 12630, Skills.HERBLORE, new Item[] { new Item(91), new Item(12630) }, new Item(12633), 363),
		AGILITY_POT(34, 80, 3002, 2152, Skills.HERBLORE, new Item[] { new Item(3002), new Item(2152) }, new Item(3034), 363),
		COMBAT_POT(36, 84, 97, 9736, Skills.HERBLORE, new Item[] { new Item(9736), new Item(97) }, new Item(9741), 363),
		GOBLIN_POT(37, 85, 3002, 11807, Skills.HERBLORE, new Item[] { new Item(11807), new Item(3002) }, new Item(11810), 363),
		PRAYER_POT(38, 87.5, 99, 231, Skills.HERBLORE, new Item[] { new Item(99), new Item(231) }, new Item(139), 363),
		SUMMONING_POT(40, 92, 12181, 12654, Skills.HERBLORE, new Item[] { new Item(12181), new Item(12654) }, new Item(12142), 363),
		CRAFTING_POT(42, 95, 14856, 5004, Skills.HERBLORE, new Item[] { new Item(5004), new Item(14856) }, new Item(14840), 363),
		SUPER_ATTACK(45, 100, 101, 221, Skills.HERBLORE, new Item[] { new Item(102), new Item(221) }, new Item(145), 363),
		SUPER_ANTIPOISON(48, 106.3, 101, 235, Skills.HERBLORE, new Item[] { new Item(101), new Item(235) }, new Item(181), 363),
		FISHING_POT(50, 112.5, 103, 231, Skills.HERBLORE, new Item[] { new Item(103), new Item(231) }, new Item(151), 363),
		SUPER_ENERGY(52, 117.5, 103, 2970, Skills.HERBLORE, new Item[] { new Item(103), new Item(2970) }, new Item(3018), 363),
		HUNTER_POT(53, 120, 103, 10111, Skills.HERBLORE, new Item[] { new Item(103), new Item(10111) }, new Item(1000), 363),
		SUPER_STRENGTH(55, 125, 105, 225, Skills.HERBLORE, new Item[] { new Item(105), new Item(225) }, new Item(157), 363),
		MAGIC_ESSENCE(57, 130, 26808, 26809, Skills.HERBLORE, new Item[] { new Item(26808), new Item(26809) }, new Item(26811), 363),
		FLETCHING_POT(58, 132, 14856, 11525, Skills.HERBLORE, new Item[] { new Item(14856), new Item(11525) }, new Item(14848), 363),
		WEAPON_POISON(60, 137.5, 105, 241, Skills.HERBLORE, new Item[] { new Item(105), new Item(241) }, new Item(187), 363),
		SUPER_RESTORE(63, 142.5, 223, 3004, Skills.HERBLORE, new Item[] { new Item(3004), new Item(223) }, new Item(3026), 363),
		MIXTURE1(65, 47.5, 3026, 235, Skills.HERBLORE, new Item[] { new Item(235), new Item(3026) }, new Item(10911), 363),
		MIXTURE2(65, 52.5, 10915, 1526, Skills.HERBLORE, new Item[] { new Item(10915), new Item(1526) }, new Item(10919), 363),
		SANFEW_SERUM(65, 60, 10923, 10937, Skills.HERBLORE, new Item[] { new Item(10923), new Item(10937) }, new Item(10927), 363),
		SUPER_DEFENCE(66, 150, 107, 239, Skills.HERBLORE, new Item[] { new Item(107), new Item(239) }, new Item(163), 363),
		ANTIPOISONP(68, 155, 6049, 5942, Skills.HERBLORE, new Item[] { new Item(5942), new Item(6049) }, new Item(5943), 363),
		ANTIFIRE(69, 157.5, 241, 2483, Skills.HERBLORE, new Item[] { new Item(2483), new Item(241) }, new Item(2454), 363),
		SUPER_RANGING_POTION(72, 162.5, 109, 245, Skills.HERBLORE, new Item[] { new Item(109), new Item(245) }, new Item(169), 363),
		WEAPON_POISONP(73, 165, 223, 5936, Skills.HERBLORE, new Item[] { new Item(5936), new Item(223) }, new Item(5937), 363),
		SUPER_MAGIC(76, 172.5, 2483, 3138, Skills.HERBLORE, new Item[] { new Item(3138), new Item(2483) }, new Item(3042), 363),
		ZAMORAK_BREW(78, 175, 111, 247, Skills.HERBLORE, new Item[] { new Item(111), new Item(247) }, new Item(189), 363),
		ANTIPOISONPP(79, 177.5, 5951, 6051, Skills.HERBLORE, new Item[] { new Item(5951), new Item(6051) }, new Item(5952), 363),
		SARADOMIN_BREW(81, 180, 3002, 6693, Skills.HERBLORE, new Item[] { new Item(3002), new Item(6693) }, new Item(6687), 363),
		WEAPON_POISONPP(82, 190, 5939, 6018, Skills.HERBLORE, new Item[] { new Item(5939), new Item(6018) }, new Item(5940), 363),
		ADRENALINE_POT(84, 200, 3018, 5972, Skills.HERBLORE, new Item[] { new Item(3018), new Item(5972) }, new Item(15301), 363),
		SUPER_ANTIFIRE(85, 210, 2454, 4621, Skills.HERBLORE, new Item[] { new Item(2454), new Item(4621) }, new Item(15305), 363),
		EXTREME_ATTACK(88, 220, 145, 261, Skills.HERBLORE, new Item[] { new Item(261), new Item(145) }, new Item(15309), 363),
		EXTREME_STRENGTH(89, 230, 157, 267, Skills.HERBLORE, new Item[] { new Item(267), new Item(157) }, new Item(15313), 363),
		EXTREME_DEFENCE(90, 240, 163, 2481, Skills.HERBLORE, new Item[] { new Item(2481), new Item(163) }, new Item(15317), 363),
		EXTREME_MAGIC(91, 250, 3042, 9594, Skills.HERBLORE, new Item[] { new Item(3042), new Item(9594) }, new Item(15321), 363),
		EXTREME_RANGING(92, 260, 169, 12539, Skills.HERBLORE, new Item[] { new Item(169), new Item(12539) }, new Item(15325), 363),
		SUPER_ZAMORAK_BREW(93, 180, 245, 189, Skills.HERBLORE, new Item[] { new Item(189), new Item(245) }, new Item(28201), 363),
		SUPER_SARADOMIN_BREW(93, 180, 6687, 28256, Skills.HERBLORE, new Item[] { new Item(6687), new Item(28256) }, new Item(28193), 363),
		SUPER_GUTHIX_REST(93, 59.5, 28253, 4419, Skills.HERBLORE, new Item[] { new Item(28253), new Item(4419) }, new Item(28209), 363),
		SUPER_PRAYER(94, 270, 139, 4255, Skills.HERBLORE, new Item[] { new Item(139), new Item(4255) }, new Item(15329), 363),
		PRAYER_RENEWAL(94, 190, 21628, 21622, Skills.HERBLORE, new Item[] { new Item(21628), new Item(21622) }, new Item(21632), 363),
		OVERLOAD(96, 1000, 269, 15309, Skills.HERBLORE, new Item[] { new Item(269), new Item(15309), new Item(15313), new Item(15317), new Item(15321), new Item(15325) }, new Item(15333), 363),
		OVERLOAD2(96, 1000, 269, 15313, Skills.HERBLORE, new Item[] { new Item(269), new Item(15309), new Item(15313), new Item(15317), new Item(15321), new Item(15325) }, new Item(15333), 363),
		OVERLOAD3(96, 1000, 269, 15317, Skills.HERBLORE, new Item[] { new Item(269), new Item(15309), new Item(15313), new Item(15317), new Item(15321), new Item(15325) }, new Item(15333), 363),
		OVERLOAD4(96, 1000, 269, 15321, Skills.HERBLORE, new Item[] { new Item(269), new Item(15309), new Item(15313), new Item(15317), new Item(15321), new Item(15325) }, new Item(15333), 363),
		OVERLOAD5(96, 1000, 269, 15325, Skills.HERBLORE, new Item[] { new Item(269), new Item(15309), new Item(15313), new Item(15317), new Item(15321), new Item(15325) }, new Item(15333), 363),
		/*
		 * Juju herbs
		 */
		ERZILLE(54, 10, 19984, 19984, Skills.HERBLORE, new Item[] { new Item(19984) }, new Item(19989), -1),
		UGUNE(55, 11.5, 19986, 19986, Skills.HERBLORE, new Item[] { new Item(19986) }, new Item(19991), -1),
		ARGWAY(56, 11.6, 19985, 19985, Skills.HERBLORE, new Item[] { new Item(19985) }, new Item(19990), -1),
		SHENGO(57, 11.7, 19987, 19987, Skills.HERBLORE, new Item[] { new Item(19987) }, new Item(19992), -1),
		SAMADEN(58, 11.7, 19988, 19988, Skills.HERBLORE, new Item[] { new Item(19988) }, new Item(19993), -1),
		/*
		 * Unfinished juju potions
		 */
		ERZILLE_UNF(54, 1, 19989, 19994, Skills.HERBLORE, new Item[] { new Item(19989), new Item(19994) }, new Item(19998), 363),
		UGUNE_UNF(55, 1, 19991, 19994, Skills.HERBLORE, new Item[] { new Item(19991), new Item(19994) }, new Item(19999), 363),
		ARGWAY_UNF(56, 1, 19990, 19994, Skills.HERBLORE, new Item[] { new Item(19990), new Item(19994) }, new Item(20000), 363),
		SHENGO_UNF(57, 1, 19992, 19994, Skills.HERBLORE, new Item[] { new Item(19992), new Item(19994) }, new Item(20001), 363),
		SAMADEN_UNF(58, 1, 19993, 19994, Skills.HERBLORE, new Item[] { new Item(19993), new Item(19994) }, new Item(20002), 363),
		/*
		 * Todo
		 * Comination, juju, and barbarian potions
		 * Grinding and crushing
		 */
		/*
		 * Crushing
		 */
		//herblore
		DRAGON_SCALE_DUST(1, 1, 233, 243, Skills.HERBLORE, new Item[] { new Item(243) }, new Item(241), 364),
		UNICORN_HORN_DUST(1, 1, 233, 237, Skills.HERBLORE, new Item[] { new Item(237) }, new Item(235), 364),
		CRUSHED_BIRD_NEST(1, 1, 5075, 5075, Skills.HERBLORE, new Item[] { new Item(5075) }, new Item(6693), -1),
		KEBBIT_TEETH_DUST(1, 1, 233, 10109, Skills.HERBLORE, new Item[] { new Item(10109) }, new Item(10111), 364),
		GOAT_HORN_DUST(1, 1, 233, 9735, Skills.HERBLORE, new Item[] { new Item(9735) }, new Item(9736), 364),
		GROUND_MUD_RUNE(1, 1, 233, 4698, Skills.HERBLORE, new Item[] { new Item(4698) }, new Item(9594), 364),
		ANCHOVIE_PASTE(1, 1, 233, 319, Skills.HERBLORE, new Item[] { new Item(319) }, new Item(11266), 364),
		GORAK_CLAW_POWDER(1, 1, 233, 9016, Skills.HERBLORE, new Item[] { new Item(9016) }, new Item(9018), 364),
		GROUND_ASHES(1, 1, 233, 592, Skills.HERBLORE, new Item[] { new Item(592) }, new Item(8865), 364),
		GROUND_TOOTH(1, 1, 233, 9079, Skills.HERBLORE, new Item[] { new Item(9079) }, new Item(9082), 364),
		DUST_OF_ARMADYL(1, 1, 233, 21776, Skills.HERBLORE, new Item[] { new Item(21776) }, new Item(21774, 8), 364),
		//cooking
		CHOCOLATE_DUST(1, 1, 233, 1973, Skills.COOKING, new Item[] { new Item(1973) }, new Item(1975), 364),
		GROUND_GUAM(1, 1, 233, 249, Skills.COOKING, new Item[] { new Item(249) }, new Item(6681), 364),
		GROUND_SEAWEED(1, 1, 233, 401, Skills.COOKING, new Item[] { new Item(401) }, new Item(6683), 364),
		GROUND_CRAB_MEAT(1, 1, 233, 7518, Skills.COOKING, new Item[] { new Item(7518) }, new Item(7527), 364),
		GROUND_COD(1, 1, 233, 341, Skills.COOKING, new Item[] { new Item(341) }, new Item(7528), 364),
		GROUND_KELP(1, 1, 233, 7516, Skills.COOKING, new Item[] { new Item(7516) }, new Item(7517), 364),
		BREADCRUMBS(1, 1, 233, 2309, Skills.COOKING, new Item[] { new Item(2309) }, new Item(7515), 364),
		//salamander tar
		GUAM_TAR(19, 30, 1939, 249, Skills.HERBLORE, new Item[] { new Item(1939, 15), new Item(249) }, new Item(10142, 15), -1),
		MARRENTILL_TAR(31, 42.5, 1939, 251, Skills.HERBLORE, new Item[] { new Item(1939, 15), new Item(251) }, new Item(10143, 15), -1),
		TARROMIN_TAR(39, 55, 1939, 253, Skills.HERBLORE, new Item[] { new Item(1939, 15), new Item(253) }, new Item(10144, 15), -1),
		HARRALANDER_TAR(44, 72.5, 1939, 255, Skills.HERBLORE, new Item[] { new Item(1939, 15), new Item(255) }, new Item(10145, 15), -1),
		/**
		 * Divination
		 * Weaving
		 * Pale
		 */
		DIVINE_CRAYFISH(1, 1, 29313, 13435, Skills.DIVINATION, new Item[] { new Item(29313, 5), new Item(13435, 20) }, new Item(31080), -1),
		PORTENT_OF_RESTORATION_I(2, 1, 29313, 13433, Skills.DIVINATION, new Item[] { new Item(29313, 30), new Item(13433, 1) }, new Item(29209), -1),
		DIVINE_BRONZE_ROCK(3, 1.2, 29313, 436, Skills.DIVINATION, new Item[] { new Item(29313, 20), new Item(436, 20) }, new Item(29294), -1),
		DIVINE_BRONZE_ROCK2(3, 1.2, 29313, 438, Skills.DIVINATION, new Item[] { new Item(438, 20), new Item(29313, 20) }, new Item(29294), -1),
		DIVINE_KEBBIT(4, 1.3, 29313, 9986, Skills.DIVINATION, new Item[] { new Item(29313, 25), new Item(9986, 20) }, new Item(29300), -1),
		ATTUNED_PORTENT_OF_REST_I(5, 1.5, 29313, 13433, Skills.DIVINATION, new Item[] { new Item(29313, 30), new Item(13433, 20) }, new Item(29259), -1),
		SIGN_OF_THE_PORTER_I(1, 1, 29313, 1656, Skills.DIVINATION, new Item[] { new Item(29313, 30), new Item(1656, 1) }, new Item(29275), -1),
		DIVINE_TREE(7, 1.8, 29313, 1511, Skills.DIVINATION, new Item[] { new Item(29313, 5), new Item(1511, 20) }, new Item(29304), -1),
		SIGN_OF_RESPITE_I(8, 2, 29313, 3211, Skills.DIVINATION, new Item[] { new Item(29313, 25), new Item(3211, 4) }, new Item(29269), -1),
		BOON_OF_FLICKERING_ENERGY(10, 3, 29313, 29313, Skills.DIVINATION, new Item[] { new Item(29313, 100) }, new Item(29373), -1),
		/*
		 * Flickering
		 */
		DIVINE_HERRING(11, 3, 29314, 345, Skills.DIVINATION, new Item[] { new Item(29314, 15), new Item(345, 20) }, new Item(31081), -1),
		DIVINE_HERB_I(12, 3.1, 29314, 249, Skills.DIVINATION, new Item[] { new Item(29314, 5), new Item(249, 10) }, new Item(29310), -1),
		OAK_LOG(13, 3.3, 29314, 1511, Skills.DIVINATION, new Item[] { new Item(29314, 2), new Item(1511, 3) }, new Item(1521), -1),
		PORTENT_OF_REST_II(15, 3.4, 29314, 333, Skills.DIVINATION, new Item[] { new Item(29314, 30), new Item(333, 1) }, new Item(29241), -1),
		RAW_TROUT(16, 3.6, 29314, 327, Skills.DIVINATION, new Item[] { new Item(29314, 2), new Item(327, 3) }, new Item(335), -1),
		IRON_ORE(17, 3.7, 29314, 436, Skills.DIVINATION, new Item[] { new Item(29314, 2), new Item(436, 3) }, new Item(440), -1),
		ATTUNED_PORTENT_OF_REST_II(18, 3.9, 29314, 333, Skills.DIVINATION, new Item[] { new Item(29314, 30), new Item(333, 1) }, new Item(29260), -1),
		DIVINE_IRON(19, 4, 29314, 440, Skills.DIVINATION, new Item[] { new Item(29314, 20), new Item(440, 15) }, new Item(29295), -1),
		BOON_OF_BRIGHT_ENERGY(20, 5, 29314, 29314, Skills.DIVINATION, new Item[] { new Item(29314, 300) }, new Item(29374), -1),
		/*
		 * Bright
		 */
		DIVINE_TROUT(20, 5, 29315, 335, Skills.DIVINATION, new Item[] { new Item(29315, 15), new Item(335, 20) }, new Item(31082), -1),
		DIVINE_OAK_TREE(21, 5.1, 29315, 1521, Skills.DIVINATION, new Item[] { new Item(29315, 15), new Item(1521, 20) }, new Item(29305), -1),
		SILVER_ORE(22, 5.2, 29315, 440, Skills.DIVINATION, new Item[] { new Item(29315, 2), new Item(440, 3) }, new Item(442), -1),
		SIGN_OF_RESPITE_II(23, 5.3, 29315, 3211, Skills.DIVINATION, new Item[] { new Item(29315, 30), new Item(3211, 4) }, new Item(29271), -1),
		DIVINE_BIRD_SNARE(24, 5.4, 29315, 9978, Skills.DIVINATION, new Item[] { new Item(29315, 30), new Item(9978, 20) }, new Item(29301), -1),
		PORTENT_OF_REST_III(25, 5.6, 29315, 329, Skills.DIVINATION, new Item[] { new Item(29315, 30), new Item(329, 1) }, new Item(29243), -1),
		UNCUT_EMERALD(26, 5.7, 29315, 1623, Skills.DIVINATION, new Item[] { new Item(29315, 2), new Item(1623, 3) }, new Item(1621), -1),
		ATTUNED_PORTENT_OF_REST_III(27, 5.8, 29315, 329, Skills.DIVINATION, new Item[] { new Item(29315, 30), new Item(329, 1) }, new Item(29261), -1),
		SIGN_OF_THE_PORTER_II(28, 5.9, 29315, 1656, Skills.DIVINATION, new Item[] { new Item(29315, 35), new Item(1656, 1) }, new Item(29279), -1),
		COAL(29, 6, 29315, 440, Skills.DIVINATION, new Item[] { new Item(29315, 2), new Item(440, 3) }, new Item(453), -1),
		BOON_OF_GLOWING_ENERGY(30, 7, 29315, 29314, Skills.DIVINATION, new Item[] { new Item(29315, 500) }, new Item(29375), -1),
		/*
		 * Glowing
		 */
		DIVINE_SALMON(30, 7, 29316, 331, Skills.DIVINATION, new Item[] { new Item(29316, 45), new Item(331, 20) }, new Item(31083), -1),
		DIVINE_WILLOW(31, 7.2, 29316, 1519, Skills.DIVINATION, new Item[] { new Item(29316, 20), new Item(1519, 20) }, new Item(29306), -1),
		DIVINE_COAL(31, 7.2, 29316, 453, Skills.DIVINATION, new Item[] { new Item(29316, 30), new Item(453, 20) }, new Item(29296), -1),
		WILLOW_LOGS(32, 7.3, 29316, 1521, Skills.DIVINATION, new Item[] { new Item(29316, 2), new Item(1521, 3) }, new Item(1519), -1),
		UNCUT_RUBY(33, 7.4, 29316, 1621, Skills.DIVINATION, new Item[] { new Item(29316, 2), new Item(1621, 3) }, new Item(1619), -1),
		DIVINE_DEADFALL(34, 7.5, 29316, 10113, Skills.DIVINATION, new Item[] { new Item(29316, 45), new Item(10113, 24) }, new Item(29302), -1),
		PORTENT_OF_RESTORATION_IV(35, 7.6, 29316, 361, Skills.DIVINATION, new Item[] { new Item(29316, 30), new Item(361, 1) }, new Item(29245), -1),
		RAW_TUNA(36, 7.7, 29316, 335, Skills.DIVINATION, new Item[] { new Item(29316, 2), new Item(335, 4) }, new Item(359), -1),
		ATTUNED_PORTENT_OF_RESTORATION_IV(37, 7.8, 29316, 361, Skills.DIVINATION, new Item[] { new Item(29316, 30), new Item(361, 1) }, new Item(29262), -1),
		SIGN_OF_RESPITE_III(38, 7.9, 29316, 3211, Skills.DIVINATION, new Item[] { new Item(29316, 35), new Item(3211, 4) }, new Item(29273), -1),
		GOLD_ORE(39, 8, 29316, 442, Skills.DIVINATION, new Item[] { new Item(29316, 2), new Item(442, 3) }, new Item(444), -1),
		BOON_OF_SPARKLING_ENERGY(40, 9, 29316, 29316, Skills.DIVINATION, new Item[] { new Item(29316, 600) }, new Item(29376), -1),
		/*
		 * Sparkling
		 */
		DIVINE_LOBSTER(41, 10, 29317, 377, Skills.DIVINATION, new Item[] { new Item(29317, 70), new Item(377, 20) }, new Item(31084), -1),
		UNCUT_DIAMOND(42, 9.1, 29317, 1619, Skills.DIVINATION, new Item[] { new Item(29317, 2), new Item(1619, 3) }, new Item(1617), -1),
		DIVINE_MAPLE_TREE(44, 9.3, 29317, 1517, Skills.DIVINATION, new Item[] { new Item(29317, 25), new Item(1517, 20) }, new Item(29307), -1),
		PORTENT_OF_RESTORATION_V(45, 9.4, 29317, 379, Skills.DIVINATION, new Item[] { new Item(29317, 35), new Item(379, 1) }, new Item(29213), -1),
		RAW_BASS(46, 9.6, 29317, 359, Skills.DIVINATION, new Item[] { new Item(29317, 2), new Item(359, 3) }, new Item(363), -1),
		ATTUNED_PORTENT_OF_RESTORATION_V(47, 9.7, 29317, 379, Skills.DIVINATION, new Item[] { new Item(29317, 35), new Item(379, 1) }, new Item(29263), -1),
		SIGN_OF_THE_PORTER_III(48, 9.9, 29317, 1658, Skills.DIVINATION, new Item[] { new Item(29317, 40), new Item(1658) }, new Item(29279), -1),
		MAPLE_LOGS(49, 10, 29317, 1519, Skills.DIVINATION, new Item[] { new Item(1519, 3), new Item(29317, 2) }, new Item(1517), -1),
		BOON_OF_GLEAMING_ENERGY(50, 11, 29317, 29317, Skills.DIVINATION, new Item[] { new Item(29317, 800) }, new Item(29377), -1),
		/*
		 * Gleaming
		 */
		DIVINE_HERB_II(51, 11.3, 29318, 259, Skills.DIVINATION, new Item[] { new Item(29318, 20), new Item(259, 20) }, new Item(29310), -1),
		DIVINE_SWORDFISH(53, 13, 29318, 371, Skills.DIVINATION, new Item[] { new Item(29318, 70), new Item(371, 20) }, new Item(31085), -1),
		PORTENT_OF_RESTORATION_VI(55, 11.5, 29318, 373, Skills.DIVINATION, new Item[] { new Item(29318, 40), new Item(373, 1) }, new Item(29214), -1),
		ATTUNED_PORTENT_OF_RESTORATION_VI(57, 11.8, 29318, 373, Skills.DIVINATION, new Item[] { new Item(29318, 40), new Item(373, 1) }, new Item(29264), -1),
		UNCUT_DRAGONSTONE(58, 12, 29318, 1617, Skills.DIVINATION, new Item[] { new Item(29318, 2), new Item(1617, 5) }, new Item(1631), -1),
		BOON_OF_VIBRANT_ENERGY(60, 13, 29318, 29318, Skills.DIVINATION, new Item[] { new Item(29318, 1000) }, new Item(29378), -1),
		/*
		 * Vibrant
		 */
		DIVINE_MITHRIL(61, 13.1, 29319, 447, Skills.DIVINATION, new Item[] { new Item(29319, 30), new Item(447, 20) }, new Item(29297), -1),
		DIVINE_YEW(62, 13.2, 29319, 1515, Skills.DIVINATION, new Item[] { new Item(29319, 30), new Item(1515, 20) }, new Item(29308), -1),
		MITHRIL_ORE(63, 13.3, 29319, 453, Skills.DIVINATION, new Item[] { new Item(29319, 2), new Item(453, 3) }, new Item(447), -1),
		GREEN_CHARM(64, 134, 29319, 12158, Skills.DIVINATION, new Item[] { new Item(29319, 250), new Item(12158, 20) }, new Item(12159, 10), -1),
		DIVINE_BOX(64, 13.4, 29319, 9976, Skills.DIVINATION, new Item[] { new Item(29319, 45), new Item(9976, 20) }, new Item(29303), -1),
		PORTENT_OF_RESTORATION_VII(65, 13.6, 29319, 7946, Skills.DIVINATION, new Item[] { new Item(29319, 45), new Item(7946, 1) }, new Item(29214), -1),
		RAW_MONKFISH(66, 13.7, 29319, 363, Skills.DIVINATION, new Item[] { new Item(29319, 2), new Item(363, 3) }, new Item(7944), -1),
		ATTUNED_PORTENT_OF_RESTORATION_VII(67, 13.8, 29319, 7946, Skills.DIVINATION, new Item[] { new Item(29319, 45), new Item(7946, 1) }, new Item(29264), -1),
		SIGN_OF_THE_PORTER_IV(68, 13.9, 29319, 1658, Skills.DIVINATION, new Item[] { new Item(29319, 45), new Item(1658) }, new Item(29281), -1),
		SIGN_OF_ITEM_PROTECTION(69, 14, 29319, 2434, Skills.DIVINATION, new Item[] { new Item(29319, 45), new Item(2434, 4) }, new Item(29287), -1),
		BOON_OF_LUSTROUS_ENERGY(70, 15, 29319, 29319, Skills.DIVINATION, new Item[] { new Item(29319, 1250) }, new Item(29379), -1),
		/*
		 * LUSTROUS
		 */
		YEW_LOGS(72, 15.2, 29320, 1517, Skills.DIVINATION, new Item[] { new Item(29320, 2), new Item(1517, 3) }, new Item(1515), -1),
		DIVINE_ADAMANTITE(73, 15.3, 29320, 449, Skills.DIVINATION, new Item[] { new Item(29320, 40), new Item(449, 25) }, new Item(29298), -1),
		CRIMSON_CHARM(74, 154, 29320, 12159, Skills.DIVINATION, new Item[] { new Item(29320, 750), new Item(12159, 30) }, new Item(12160), -1),
		PORTENT_OF_RESTORATION_VIII(75, 15.5, 29320, 385, Skills.DIVINATION, new Item[] { new Item(29320, 50), new Item(385, 1) }, new Item(29216), -1),
		ADAMANT_ORE(76, 15.7, 29320, 447, Skills.DIVINATION, new Item[] { new Item(29320, 2), new Item(447, 3) }, new Item(449), -1),
		ATTUNED_PORTENT_OF_RESTORATION_VIII(77, 15.8, 29320, 385, Skills.DIVINATION, new Item[] { new Item(29320, 50), new Item(385, 1) }, new Item(29266), -1),
		SIGN_OF_LIFE(78, 16, 29320, 1643, Skills.DIVINATION, new Item[] { new Item(29320, 100), new Item(1643, 1) }, new Item(29290), -1),
		DIVINE_SHARK(79, 16, 29320, 383, Skills.DIVINATION, new Item[] { new Item(29320, 60), new Item(383, 20) }, new Item(31086), -1),
		BOON_OF_BRILLIANT_ENERGY(80, 17, 29320, 29320, Skills.DIVINATION, new Item[] { new Item(29320, 1500) }, new Item(29380), -1),
		/*
		 * ELDER
		 */
		/*DIVINE_SIMULACRUM_I(75, 16, , , Skills.DIVINATION, new Item[] { new Item(, ), new Item(, ) }, new Item(), -1),
		PORTENT_OF_DEGREDATION_I(75, 15.5)
		ATTUNED_PORTENT_OF_DEGREDATION_I(77, 15.8)
		SIGN_OF_DEATH(79, 16)
		AVIANSIE_TALONS(81, 1)
		DEMON_HORN(81, 1)
		ICYENE_FEATHER(81, 1)
		VAMPYRE_FANGS(81, 1)
		PORTENT_OF_DEGREDATION_II(86, 19.3)
		ATTUNED_PORTENT_OF_DEGREDATION_II(87, 19.7)
		DIVINE_SIMULACRUM_II(92, 16)
		PORTENT_OF_DEGREDATION_III(97, 23.4)
		ATTUNED_PORTENT_OF_DEGREDATION_III(98, 23.6)
		PORTENT_OF_DEATH(99, 24)
		BOON_OF_ELDER_ENERGY(75, 16)
		/*
		 * Brilliant
		 */
		/*DIVINE_HERB_III(82, 17.5, , , Skills.DIVINATION, new Item[] { new Item(, ), new Item(, ) }, new Item(), -1),
		DIVINE_MAGIC(83, 18)
		BLUE_CHARM(84, 174)
		BOON_OF_RADIANT_ENERGY(85, 19)
		/*
		 * RADIANT
		 */
		/*PORTENT_OF_RESTORATION_IX(86, 19.3, , , Skills.DIVINATION, new Item[] { new Item(, ), new Item(, ) }, new Item(), -1),
		ATTUNED_PORTENT_OF_RESTORATION_IX(87, 19.7)
		SIGN_OF_THE_PORTER_V(88, 20)
		DIVINE_CAVEFISH(89, 20)
		BOON_OF_LUMINOUS_ENERGY(90, 21)
		/*
		 * Luminous
		 */
		/*DIVINE_ROCKTAIL(91, 21, , , Skills.DIVINATION, new Item[] { new Item(, ), new Item(, ) }, new Item(), -1),
		PORTENT_OF_ITEM_PROTECTION(92, 21.3)
		MAGIC_LOGS(93, 21.7)
		DIVINE_RUNE(94, 22)
		BOON_OF_INCANDESCENT_ENERGY(95, 23)
		/*
		 * Incandescent
		 */
		/*RUNE_ORE(96, 23.2, , , Skills.DIVINATION, new Item[] { new Item(, ), new Item(, ) }, new Item(), -1),
		PORTENT_OF_RESTORATION_X(97, 23.4)
		ATTUNED_PORTENT_OF_RESTORATION_X(98, 23.6)
		SIGN_OF_THE_PORTER_VI(99, 24)
		PORTENT_OF_LIFE(99, 24)*/
		;


		public static ForgingBar getBarByProduce(int id) {
			for(ForgingBar bar : ForgingBar.values()) {
			if(bar.getProducedItem().getId() == id)
				return bar;
			}
			return null;
		}

		public static ForgingBar getBar(int id) {
			for(ForgingBar bar : ForgingBar.values()) {
			for(Item item : bar.getItemsRequired())
				if(item.getId() == id)
				return bar;
			}
			return null;
		}

		public static ForgingBar getBar(Player player) {
	    	for(ForgingBar bar : ForgingBar.values()) {
				for(Item item : bar.getItemsRequired())
		    		if(player.getInventory().containsItems(new Item(item.getId())))
						return bar;
	    	}
	    return null;
	}

	private int levelRequired;
	private double experience;
	private int starter;
	private int secondary;
	private Item[] barsRequired;
	private Item producedItem;
	private int anim;
	private int skillType;
	

	private ForgingBar(int levelRequired, double experience, int starter, int secondary, int skillType, Item[] itemsRequired, Item producedItem, int anim) {
	    this.levelRequired = levelRequired;
	    this.experience = experience;
	    this.starter = starter;
	    this.secondary = secondary;
	    this.skillType = skillType;
	    this.barsRequired = itemsRequired;
	    this.producedItem = producedItem;
	    this.anim = anim;
	}

	public Item[] getItemsRequired() {
	    return barsRequired;
	}

	public int getLevelRequired() {
	    return levelRequired;
	}
	
	public int getStarter() {
	    return starter;
	}
	
	public int getSecond() {
	    return secondary;
	}
	
	public int getSkillType() {
	    return skillType;
	}

	public Item getProducedItem() {
	    return producedItem;
	}

	public double getExperience() {
	    return experience;
	}
	
	public int getAnim() {
	    return anim;
	}

    }

    
    
    public ForgingBar bar;
    public static WorldObject object;
    public int ticks;

    public Crafting(ForgingBar bar, WorldObject object, int ticks) {
	this.object = object;
	this.bar = bar;
	this.ticks = ticks;
    }
    
    	public static boolean isCrafting(Player player, Item item1, Item item2) {
    	    for (ForgingBar item : ForgingBar.values()) {
		if ((item.starter == item1.getId() && item.secondary == item2.getId()) 
		    || (item.secondary == item1.getId() && item.starter == item2.getId())) {
		    player.getDialogueManager().startDialogue("CraftingD", object, item);
			return true;
		}
	}
    	    return false;
    	}
    
	public static boolean isCrafting(Player player, int itemId) {
		for (ForgingBar item : ForgingBar.values()) {
		    	if (itemId == 319 || itemId == 21776)
		    	    return false;
		    	if (itemId == 1511 || itemId == 1513 || itemId == 1515 || itemId == 1517 || itemId == 1519 || itemId == 1521)
		    	    return false;
			if (item.starter == itemId) {
			    player.getDialogueManager().startDialogue("CraftingD", object, item);
				return true;
			}
			if (item.secondary == itemId) {
			    player.getDialogueManager().startDialogue("CraftingD", object, item);
				return true;
			}
		}
		return false;
	}

    @Override
    public boolean start(Player player) {
	if (bar == null || player == null) {
	    return false;
	}
	//if (!player.getInventory().containsItem(HAMMER, 1)) {
	//    player.getPackets().sendGameMessage("You need a hammer to create a " + bar.getProducedItem().getDefinitions().getName() + ".");
	//    return false;
	//}
	if (bar.getItemsRequired().length > 1) {
	    if (!player.getInventory().containsItemToolBelt(bar.getItemsRequired()[0].getId(), bar.getItemsRequired()[0].getAmount())) {
		player.getPackets().sendGameMessage("You need " + bar.getItemsRequired()[0].getAmount() + " " + bar.getItemsRequired()[0].getDefinitions().getName() + "'s to create a " + bar.getProducedItem().getDefinitions().getName() + ".");
		return false;
	    }
	}
	if (bar.getItemsRequired().length > 2) {
	    if (!player.getInventory().containsItemToolBelt(bar.getItemsRequired()[1].getId(), bar.getItemsRequired()[1].getAmount())) {
		player.getPackets().sendGameMessage("You need " + bar.getItemsRequired()[1].getAmount() + " " + bar.getItemsRequired()[1].getDefinitions().getName() + "'s to create a " + bar.getProducedItem().getDefinitions().getName() + ".");
		return false;
	    }
	}
	if (player.getSkills().getLevel(bar.getSkillType()) < bar.getLevelRequired()) {
	    player.getPackets().sendGameMessage("You need a Smithing level of at least " + bar.getLevelRequired() + " to create " + bar.getProducedItem().getDefinitions().getName());
	    return false;
	}
	player.getPackets().sendGameMessage("You place the required bars and attempt to create a " + bar.getProducedItem().getDefinitions().getName() + ".", true);
	return true;
    }

    @Override
    public boolean process(Player player) {
	if (bar == null || player == null) {
	    return false;
	}
	//if (!player.getInventory().containsItem(HAMMER, 1)) {
	//    player.getPackets().sendGameMessage("You need a hammer to create a " + bar.getProducedItem().getDefinitions().getName() + ".");
	//    return false;
	//}
	if (bar.getItemsRequired().length > 1) {
	    if (!player.getInventory().containsItemToolBelt(bar.getItemsRequired()[0].getId(), bar.getItemsRequired()[0].getAmount())) {
		player.getPackets().sendGameMessage("You need " + bar.getItemsRequired()[0].getAmount() + " " + bar.getItemsRequired()[0].getDefinitions().getName() + "'s to create a " + bar.getProducedItem().getDefinitions().getName() + ".");
		return false;
	    }
	}
	if (bar.getItemsRequired().length > 2) {
	    if (!player.getInventory().containsItemToolBelt(bar.getItemsRequired()[1].getId(), bar.getItemsRequired()[1].getAmount())) {
		player.getPackets().sendGameMessage("You need " + bar.getItemsRequired()[1].getAmount() + " " + bar.getItemsRequired()[1].getDefinitions().getName() + "'s to create a " + bar.getProducedItem().getDefinitions().getName() + ".");
		return false;
	    }
	}
	if (player.getSkills().getLevel(bar.getSkillType()) < bar.getLevelRequired()) {
	    player.getPackets().sendGameMessage("You need a Smithing level of at least " + bar.getLevelRequired() + " to create " + bar.getProducedItem().getDefinitions().getName());
	    return false;
	}
	//player.faceObject(object);
	return true;
    }

    @Override
    public int processWithDelay(Player player) {
	if (bar.getSecond() == 227 || bar.getStarter() == 227)
	    ticks = player.getInventory().getAmountOf(227);
	if (bar.getSecond() == 21776 || bar.getStarter() == 21776)
	    ticks = player.getInventory().getAmountOf(21776);
	ticks--;
	player.getPackets().sendGameMessage(""+ticks+"");
	player.setNextAnimation(new Animation(bar.getAnim()));
	double xp = bar.getExperience() * 1;
	player.getSkills().addXp(bar.getSkillType(), xp);
	
	
	if (random == 57 && !player.getInventory().containsItem(32084, 1) && !player.getBank().containsItem(32084) && player.getInventory().getFreeSlots() >= 1 && player.getSkills().getLevelForXp(Skills.AGILITY) >= 99){
	    player.getInventory().addItem(32084, 1);
	    player.getPackets().sendGameMessage("<col=a6aba6>As you are begin smithing, a lump of crystal detaches itself from the bar, you quickly place it in your backpack.");
	}
	
	else if (random == 57 && !player.getInventory().containsItem(32084, 1) && !player.getBank().containsItem(32084) && player.getInventory().getFreeSlots() == 0 && player.getSkills().getLevelForXp(Skills.AGILITY) >= 99){
	    player.getBank().addItem(32084, 1, true);
	    player.getPackets().sendGameMessage("<col=a6aba6>As you are begin smithing, a lump of crystal detaches itself from the bar, the crystal has been sent to your bank.");
	}
	
	
	for (Item required : bar.getItemsRequired()) {
	    if (required.getId() == 4 || required.getId() == 2976 || required.getId() == 1594 || required.getId() == 1599 || required.getId() == 5523)
		continue;
	    player.getInventory().deleteItem(required.getId(), required.getAmount());
	}
	int amount = bar.getProducedItem().getAmount();
	if (bar.getProducedItem().getDefinitions().isStackable())
	    amount *= 1;
	player.getInventory().addItem(bar.getProducedItem().getId(), amount);
	player.getPackets().sendGameMessage("You have successfully created a " + bar.getProducedItem().getDefinitions().getName() + ".", true);
	if (ticks > 0) {
	    if (bar.getSkillType() == Skills.HERBLORE) {
		return 0;
	    } else {
		return 2;
	    }
	}
	return -1;
    }

    @Override
    public void stop(Player player) {
	setActionDelay(player, 3);
    }
}