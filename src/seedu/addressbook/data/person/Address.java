package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

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
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
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