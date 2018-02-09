package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    private static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must contain the following fields: "
            + "BLOCK, STREET, UNIT, POSTAL_CODE\n";
    private static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";
    private static final String ADDRESS_SPLIT_DELIMITER = ",";

    private static final int BLOCK_INDEX = 0;

    private static final int STREET_INDEX = 1;

    private static final int UNIT_INDEX = 2;

    private static final int POSTALCODE_INDEX = 3;


    private Block blockNumber;
    private Street streetName;
    private Unit unitNumber;
    private Postal_Code postalCode;

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
        blockNumber = new Block(SplitAddress[BLOCK_INDEX]);
        streetName = new Street(SplitAddress[STREET_INDEX]);
        unitNumber = new Unit(SplitAddress[UNIT_INDEX]);
        postalCode = new Postal_Code(SplitAddress[POSTALCODE_INDEX]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", blockNumber, streetName, unitNumber, postalCode);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
    

    
   