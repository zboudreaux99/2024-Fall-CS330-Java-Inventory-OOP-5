package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable implements Item
{
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Dur: %s%n",
        "  Def: %d%n",
        "  Mtl: %s%n",
        "  Mdr: %s (Lvl %d)%n",
        "  Emt: %s%n"
    );

    /**
     * The amount of damage that can be negated.
     */
    protected int defense;

    /**
     * Default to a armour with a defense of zero.
     */
    public Armour()
    {
        super();
        this.defense = 0;
    }

    /**
     * Create a fully initialized Armour.
     */
    public Armour(String nme, int dur, int def, String mtl, String mdr, int lvl, String emt)
    {
        super(nme, dur, mtl, mdr, lvl, emt);

        this.defense = def;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier,
     * modifierLevel, element, and defense.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Armour)) {
            return false;
        } else if (this == rhs) {
            return true;
        }

        Armour rhsItem = (Armour) rhs;

        return this.getName().equals(rhsItem.getName()) &&
               this.getMaterial().equals(rhsItem.getMaterial()) &&
               this.getModifier().equals(rhsItem.getModifier()) &&
               this.getModifierLevel() == (rhsItem.getModifierLevel()) &&
               this.getElement().equals(rhsItem.getElement()) &&
               this.getDefense() == (rhsItem.getDefense());
    }

    /**
     * Compute hashCode based on name, material, modifier, modifierLevel,
     * element, and defense.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(
            this.getName(),
            this.getMaterial(),
            this.getModifier(),
            this.getModifierLevel(),
            this.getElement(),
            this.getDefense()
        );
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {
        return String.format(FMT_STR, this.getName(), this.getDurability(), this.getDefense(), this.getMaterial(), this.getModifier(), this.getModifierLevel(), this.getElement());
    }
}




