package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Armour;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ArmourCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ArmourCreation construct()
    {
        return new ArmourCreation();
    }

    @Override
    public Item fromDefaults()
    {
        // Return a **Default** Armour
        return new Armour();
    }

    @Override
    public int requiredNumberOfValues()
    {
        // Replace the return value;
        return 7;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {
        Armour armour = new Armour();
        armour.setName(tokens[0]);
        armour.setMaterial(tokens[1]);
        armour.setDurability(Integer.parseInt(tokens[2]));
        armour.setDefense(Integer.parseInt(tokens[3]));
        armour.setModifier(tokens[4]);
        armour.setModifierLevel(Integer.parseInt(tokens[5]));
        armour.setElement(tokens[6]);
        return armour;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal",
        "PMD.OnlyOneReturn"
    })
    @Override
    public Item fromExisting(final Item original)
    {
        if (!(original instanceof Armour)) {
            return null;
        }

        Armour theOriginal = (Armour) original;
        Armour newArmour = new Armour();

        newArmour.setName(theOriginal.getName());
        newArmour.setDurability(theOriginal.getDurability());
        newArmour.setDefense(theOriginal.getDefense());
        newArmour.setMaterial(theOriginal.getMaterial());
        newArmour.setModifier(theOriginal.getModifier());
        newArmour.setModifierLevel(theOriginal.getModifierLevel());
        newArmour.setElement(theOriginal.getElement());
        return newArmour;
    }
}
