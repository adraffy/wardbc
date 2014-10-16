package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ItemData extends LazyRowId {
    
    static public final String FILE = "Item-sparse.db2";
    
    public int quality;
    public int itemFlag1;
    public int itemFlag2;
    public int unk_14732;
    public int unk_14732_2;
    public int unk_14890;
    public int unk_16173; // BuyCount?
    public int buyPrice;
    public int sellPrice;
    public int equipId;
    public int allowClassMask;
    public int allowRaceMask;
    public int itemLevel;
    public int reqLevel;
    public int reqSkill;
    public int reqSkillRank;
    public int reqSpellId;
    public int _reqHonorRank; // always zero
    public int _reqCityRank; // always zero
    public int reqRepId;
    public int reqRepRank;
    public int maxCount;
    public int stackable;
    public int containerSize;
    static public final int MAX_STAT = 10;
    public final int[] statId = new int[MAX_STAT];
    public final int[] statValue = new int[MAX_STAT];
    public final int[] statAlloc = new int[MAX_STAT]; 
    public final float[] statSocketMod = new float[MAX_STAT]; 
    public int ssdId; // scalingStatDistributionId
    public int damageType;
    public int weaponSwing;
    public float RangedModRange; 
    public int bindId;
    public String name;
    public String[] OtherNames = new String[3];
    public String text;
    public int PageText;
    public int IdLang;
    public int PageMaterial;
    public int StartQuest;
    public int IdLock;
    public int Material;
    public int Stealth;
    public int oldSuffixGroupId;
    public int newSuffixGroupId;
    public int itemSetId;
    public int reqArea;//ForeignKey("required_zone", "AreaTable"),
    public int reqInstance; //ForeignKey("required_instance", "reqInstance"),
    public int bagFamilyMask;
    public int TotemCategory;
    static public final int MAX_SOCKET = 3;
    public final int[] socketColor = new int[3];
    public int socketBonusEnchantId;
    public int gemPropId;
    public float ItemDamageModifier;
    public int Duration;
    public int itemLimitCategoryId;
    public int IdHoliday;
    public float weaponRange;
    public int Unknown130; // always always 0
    public int Unknown131; // almost always 0
    public int nameDescId;

  
    
}
