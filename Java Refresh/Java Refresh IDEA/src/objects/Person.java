package objects;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import utilities.UtilityFunctions;

/**
 * This class defines people.
 */
public class Person {

    // define class variables
	private static final UtilityFunctions U =
            UtilityFunctions.getInstance();
	
	// Object variables
	private String name; // given name
	private String number; // phone number
	private LocalDate dob; // date of birth
	
	/**
	 * The default constructor.
	 */
	public Person() {
        super();
    }
	
	/**
	 * The alternate constructor with a local date object.
	 * @param name The person's given name.
	 * @param number The person's phone number.
	 * @param dob The person's date of birth.
	 */
	public Person(
            String name,
            String number,
            LocalDate dob
    ) {
		this.name = name;
		this.number = number;
		this.dob = dob;
	}
	
	/**
	 * Alternate constructor with individual time values.
	 * @param name The person's given name.
	 * @param number The person's phone number.
	 * @param day The person's day of birth.
	 * @param month The person's month of birth.
	 * @param year The person's year of birth.
	 */
	public Person(
            String name,
            String number,
            int day,
            int month,
            int year
    ) {
		this.name = name;
		this.number = number;
		this.dob = LocalDate.of(
                year,
                month,
                day
        );
	}
	
	/**
	 * The getter for  a person's given name.
	 * @return The person's given name.
	 */
	public String name() { 
		return this.name;
	}

	/**
	 * The setter for a person's given name.
	 * @param name The person's given name.
	 */
	public void name(String name) {
		this.name = name;
	}
	
	/**
	 * The getter for a person's phone number.
	 * @return The person's phone number.
	 */
	public String number() {
		return this.number;
	}
	
	/**
	 * The setter for a person's phone number.
	 * @param number The person's phone number.
	 */
	public void number(String number) {
		this.name = number;
	}
	
	/**
	 * The getter for the person's date of birth.
	 * @return The person's date of birth.
	 */
	public LocalDate dob() {
		return this.dob;
	}
	
	public String dobToString() {

        return this.dob.format(
                DateTimeFormatter
                        // format for dob String
                        .ofPattern("MM/dd/yyyy")
        );
	}
	
	/**
	 * The setter for the person's date of birth using a local
     * date object.
	 * @param dob The person's date of birth.
	 */
	public void dob(LocalDate dob) {
		// dob is immutable
		// requires write over
		this.dob = dob;
	}
	
	/**
	 * The setter for the person's date of birth using individual
     * time values.
	 * @param day The person's day of birth.
     * @param month The person's month of birth.
     * @param year The person's year of birth.
	 */
	public void dob(
            int day,
            int month,
            int year
    ) {
		this.dob.atTime(
                year,
                month,
                day
        );
	}
	
	
	/**
	 * The method to deep check two people.
	 * @param p The person to compare with this person object.
	 * @return The boolean flag whether the two people are the same.
	 */
	public boolean equals(Person p) {
		return
				this.name.equals(p.name) &&
				this.number.equals(p.number) &&
				this.dob.equals(p.dob);
				
	}

    /**
     * This method redefines the string representation
     * of the class instance.
     * @return A custom string version of the instance.
     */
	@Override
	public String toString() {
		return String.format(
				"<<class=%s, id=%s> name=%s, number=%s, dob=%s>", 
				U.findMyClass(this),
				this.hashCode(),
				this.name, 
				this.number,
				this.dobToString()	
				);
		
	}
	
}
