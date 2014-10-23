package com.antistupid.wardbc;

import com.antistupid.wardbc.lazy.rows.ItemData;
import com.antistupid.wardbc.lazy.rows.SpellEffect;
import com.antistupid.wardbc.lazy.rows.RulesetItemUpgrade;
import com.antistupid.wardbc.lazy.rows.RandPropPoints;
import java.nio.file.Paths;
import com.antistupid.wardbc.lazy.LazyDBC;
import com.antistupid.wardbc.lazy.rows.*;

public class Main {

    static public void main(String[] args) {
      
        LazyDBC lazy = new LazyDBC(Paths.get("/Users/raffy/Desktop/DBFilesClient"));
        
        lazy.list(RulesetItemUpgrade.class).stream().filter(x -> x.upgradeId <= 380).forEach(System.out::println);
        /*
        id(373) chainId(89) itemLevelDelta(4) prevId(0) currencyId(396) currencyCost(75000)
        id(374) chainId(89) itemLevelDelta(8) prevId(373) currencyId(396) currencyCost(75000)
        id(375) chainId(90) itemLevelDelta(4) prevId(0) currencyId(0) currencyCost(0)
        id(376) chainId(90) itemLevelDelta(4) prevId(375) currencyId(0) currencyCost(0)
        id(377) chainId(90) itemLevelDelta(4) prevId(376) currencyId(0) currencyCost(0)
        id(378) chainId(91) itemLevelDelta(7) prevId(0) currencyId(0) currencyCost(0)
        id(379) chainId(91) itemLevelDelta(4) prevId(0) currencyId(0) currencyCost(0)
        id(380) chainId(91) itemLevelDelta(4) prevId(379) currencyId(0) currencyCost(0)
        */
        
        lazy.list(RandPropPoints.class).forEach(System.out::println);
        /*
        id(13) epic([11, 8, 6, 5, 3]) superior([7, 5, 4, 3, 2]) uncommon([3, 2, 2, 1, 1])
        id(14) epic([11, 8, 6, 5, 3]) superior([7, 5, 4, 3, 2]) uncommon([3, 2, 2, 1, 1])
        id(15) epic([12, 9, 7, 5, 4]) superior([8, 6, 5, 3, 3]) uncommon([4, 3, 2, 2, 1])
        */
        
        Tally.dump(lazy.map(ItemData.class), x -> x.quality);
        /*
        Tally: Unique(8) Total(81930)
        0: 4009
        1: 16653
        2: 17870
        3: 15931
        4: 27178
        5: 96
        6: 7
        7: 186
        */
        
        lazy.map(SpellEffect.class).get(5221).dump();
        /*
        wardbc.lazy.rows.SpellEffect
                             id = 5221
                    unk_15589_1 = 0
                           type = 47
                 multiple_value = 0.0
                        subType = 0
                      amplitude = 0
                     base_value = 0
                    coefficient = 0.0
                 dmg_multiplier = 1.0
                   chain_target = 0
                      die_sides = 0
                      item_type = 0
                       mechanic = 0
                     misc_value = 0
                   misc_value_2 = 0
        points_per_combo_points = 0.0
                      id_radius = 0
                  id_radius_max = 0
                       real_ppm = 0.0
                     class_mask = [0, 0, 0, 0]
                  trigger_spell = 0
                    unk_15589_2 = 0.0
              implicit_target_1 = 0
              implicit_target_2 = 0
                       id_spell = 12180
                          index = 0
                      unk_14040 = 0
                 ap_coefficient = 0.0
        */
        
        
    }
    
}
