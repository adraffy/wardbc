package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class SkillLineAbility extends LazyRowId {

    static public final String FILE = "SkillLineAbility.dbc";
    
    /*
      'SkillLineAbility.dbc' : [
          'id',          ( 'id_skill', '%4u' ),   'id_spell',        ( 'mask_race', '%#.8x' ),        ( 'mask_class', '%#.8x' ),
          'req_skill_level', 'replace_id', 'unk_3', 'max_learn_skill', 'unk_5', 'reward_skill_pts', 'idx'
    ],
    */

    public int skillId;
    public int spellId;
    public int reqRace;
    public int reqClass;
    public int reqSkillLevel;
    public int replaceId;
    public int unk_1;
    public int maxSkill; // gray
    public int midSkill; // yellow
    public int reward;
    public int index;
    public int id_filter;
    
}
