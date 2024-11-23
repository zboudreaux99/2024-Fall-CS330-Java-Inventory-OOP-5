package edu.odu.cs.cs330.items;

/**
 * This class represents one tool--as found in most video games. This includes
 * pickaxes and shovels.
 *
 * Tools may not be stacked. All Constructors must initialize Item::stackable
 * to false.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal",
    "PMD.ShortClassName",
})
public class Tool extends Equippable implements Item {
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Dur: %d%n",
        "  Spd: %d%n",
        "  Mtl: %s%n",
        "  Mdr: %s (Lvl %d)%n"
    );

    /**
     * Base operation (e.g., harvest/mine) speed.
     */
    protected final int speed;

    /**
     * Default to an unstackable tool with zero speed.
     */
    public Tool()
    {
        super();

        this.speed = 0;
    }

    /**
     * Create a fully initialized Tool.
     */
    public Tool(String nme, int dur, int spd, String mtl, String mdr, int lvl)
    {
        super(nme, dur, mtl, mdr, lvl, "No Element");

        this.speed = spd;
    }

    /**
     * Retrieve tool speed.
     *
     * @return how quickly a tool operates
     */
    public int getSpeed()
    {
        return this.speed;
    }

    /**
     * Check for logical equivalence--based on name, speed, material, modifier,
     * and modifierLevel
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Tool)) {
            System.out.println("failed for instanceof");
            return false;
        } else if (this == rhs) {
            System.out.println("true for this == rhs");
            return true;
        }

        Tool rhsItem = (Tool) rhs;

        return this.getName().equals(rhsItem.getName()) &&
               this.getSpeed() == rhsItem.getSpeed() &&
               this.getMaterial().equals(rhsItem.getMaterial()) &&
               this.getModifier().equals(rhsItem.getModifier()) &&
               this.getModifierLevel() == rhsItem.getModifierLevel();
    }

    /**
     * Compute hashCode using name, speed, material, modifier,
     * and modifierLevel.
     */
    @Override
    public int hashCode()
    {
        int hash = this.getName().hashCode();
        hash += 2 * this.getMaterial().hashCode();
        hash += 4 * this.getModifier().hashCode();
        hash += 8 * this.getModifierLevel();
        hash += 32 * this.getSpeed();

        return hash;
    }

    /**
     * *Print* a Tool.
     */
    @Override
    public String toString()
    {
        return String.format(
           FMT_STR,
           this.getName(),
           this.getDurability(),
           this.getSpeed(),
           this.getMaterial(),
           this.getModifier(),
           this.getModifierLevel()
        );
    }
}
