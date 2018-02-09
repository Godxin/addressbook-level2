package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must contain the following fields: "
                                                             + "BLOCK, STREET, UNIT, POSTAL_CODE\n"
    public static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";
    public static final String ADDRESS_SPLIT_DELIMITER = ",";

    private static final int BLOCK_INDEX = 0;
+   private static final int STREET_INDEX = 1;
+   private static final int UNIT_INDEX = 2;
+   private static final int POSTALCODE_INDEX = 3;

    public final String value;
    public Block BlockNumber;
    public Street StreetName;
    public Unit UnitNumber;
    public Postal_Code PostalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        String[] SplitAddress = trimmedAddress.split(ADDRESS_SPLIT_DELIMITER);
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.BlockNumber = new Block(SplitAddress[BLOCK_INDEX]);
        this.StreetName = new Street(SplitAddress[STREET_INDEX]);
        this.UnitNumber = new Unit(SplitAddress[UNIT_INDEX]);
        this.PostalCode = new Postal_Code(SplitAddress[POSTALCODE_INDEX]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

public class Block {

    private final String BlockNumber;

    public Block( String Block_Number){
        BlockNumber = Block_Number;
    }

    public String getBlock(){
        return BlockNumber;
    }
}

public class Street {

    private final String StreetName;

    public Street( String Street_Name){
        StreetName = Street_Name;
    }

    public String getStreet(){
        return StreetName;
    }
}

public class Unit {

    private final String UnitNumber;

    public Unit( String Unit_Number){
        UnitNumber = Unit_Number;
    }

    public String getUnit(){
        return UnitNumber;
    }
}

public class Postal_Code {

    private final String code;

    public Block( String Pcode){
        code = Pcode;
    }

    public String getPostalCode(){
        return code;
    }
}