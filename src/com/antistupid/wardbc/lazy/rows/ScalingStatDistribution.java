package com.antistupid.wardbc.lazy.rows;

import com.antistupid.wardbc.lazy.LazyRowId;

public class ScalingStatDistribution extends LazyRowId {
    
    static public final String FILE = "ScalingStatDistribution.dbc";
    /*
    struct ScalingStatDistributionEntry // sizeof(0x58)
{
   m_ID; // +0x0, size 0x4, type 0
   m_statID; // +0x4, size 0x28, type 0
   m_bonus; // +0x2C, size 0x28, type 0
   m_maxlevel; // +0x54, size 0x4, type 0
};
    */

    public int minLevel;
    public int maxLevel;
    public int curveId; // {956-961}
    
}
