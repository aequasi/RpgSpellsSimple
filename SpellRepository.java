package com.unrulymyth;

import com.unrulymyth.spells.SpellInterface;
import com.unrulymyth.spells.SpellTaunt;
import com.unrulymyth.spells.SpellTeleport;

public class SpellRepository {

    private SpellInterface[] spellClasses;

    public SpellRepository(RpgSpells plugin) {
        this.spellClasses = new SpellInterface[]{
            new SpellTeleport(plugin),
            new SpellTaunt(plugin)
        };
    }

    public SpellInterface getSpell(String name) {
    	try {
    		for (SpellInterface spell : this.spellClasses) {
                if (spell.getName().toLowerCase().equalsIgnoreCase(name.toLowerCase())) {
                    return spell;
                }
            }	
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("Exception in SpellRepository");
    	}
		return null;
    } 
}