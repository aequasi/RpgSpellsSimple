package com.unrulymyth;

import com.unrulymyth.spells.SpellInterface;
import com.unrulymyth.spells.SpellTaunt;
import com.unrulymyth.spells.SpellTeleport;

public class SpellRepository {

    private RpgSpells plugin;

    private SpellInterface[] spellClasses;

    public SpellRepository(RpgSpells instance) {
        plugin = instance;

        spellClasses = new SpellInterface[]{
            new SpellTeleport(plugin),
            new SpellTaunt(plugin)
        };
    }

    public SpellInterface getSpell(String name) {
    	try {
    		System.out.println(spellClasses.length);
    		for (SpellInterface spell : this.spellClasses) {
                if (spell.getName().toLowerCase() == name.toLowerCase()) {
                	System.out.println(spell.getName());
                    return spell;
                }
            }	
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("Exception in SpellRepository");
    	}
		return false;
    } 
}