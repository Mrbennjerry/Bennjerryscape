package com.rs.game.player.actions;

public class Skillfu {
    
    public static enum Skillfus {

    /*
     * Mining
     */
    STRONGARM_MINING(20284, 3998),
    CHI_BLAST_MINING(17310, 3304),
    HEADBUTT_MINING(17083, -1),
    BLAST_MINING(17947, 241),
    BLAST_MINING_TALL(17947, 3918),
    CRYSTAL_SINGER_MINING(24626, 5162),
    CRYSTAL_SINGER_MINING_TALL(24624, 5161),
    /*
     * Woodcutting
     */
    //LUMBERJACK_WOODCUTTING(17091, -1), emote 17085 - emote 17096 depends on axe
    ROUNDHOUSE_WOODCUTTING(17304, 3301),
    ROUNDHOUSE_WOODCUTTING_TALL(17304, 3307),
    EXPLOSIVE_WOODCUTTING(17948, 3457),
    STRONGARM_WOODCUTTING(20302, 4006),
    CRYSTAL_SINGER_WOODCUTTING(24621, 5157),
    CRYSTAL_SINGER_WOODCUTTING_TALL(24629, 5160),
    /*
     * Fishing
     */
    DEEPSEA_FISHING(17084, -1),
    DEPTH_CHARGE_FISHING(17953, 3459),
    ARCANE_FISIHNG(20301, 4007),
    /*
     * Firemaking
     */
    EXPLOSIVE_FIREMAKING(17955, -1),
    BOMB_FIREMAKING(16699, 3461),
    PARTYHAT_FIREMAKING(16699, 4726),//4726 - 4735 random colors
    /*
     * Herblore
     */
    ENHANCED_POTION_MAKING(17097, -1),
    /*
     * Smithing
     */
    IRONFIST_SMITHING(17309, -1),
    ARCANE_SMELTING(20292, 4000),
    /*
     * Cooking
     */
    SAMURAI_COOKING(17314, 3306),
    ARCANE_COOKING(20298, 3999),
    /*
     * Fletching
     */
    KARATECHOP_FLETCHING(17299, -1),
    /*
     * Prayer
     */
    STRONGARM_BURIAL(20294, 4001),
    /*
     * Divination
     */
    POWERFUL_DIVINATION(22856, 4619),
    AGILE_DIVINATION(22857, 4620),
    POWERFUL_CONVERSION(22858, 4625),
    AGILE_CONVERSION(22861, 4627),
    /*
     * Magic
     */
    ENHANCED_HIGH_ALCHEMY(17099, 3214),
    UNSTABLE_ALCHEMY(17952, 2458),
    /*
     * Resting
     */
    /*
     * Teleport
     */
    /*
     * Deaths
     */
    AIR(20162, 3955),
    WATER(20164, 3956),
    EARTH(20166, 3957),
    FIRE(20168, 3958)
    ;

    private int animation;
    private int graphic;
    
    private Skillfus(int animation, int graphic) {
	this.animation = animation;
	this.graphic = graphic;
    }
    
    public int getAnimation() {
	return animation;
    }
    
    public int getGraphic() {
	return graphic;
    }
    }
}
