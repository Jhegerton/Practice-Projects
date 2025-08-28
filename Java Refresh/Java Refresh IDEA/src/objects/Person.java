package objects;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import utilities.UtilityFunctions;

/**
 * This class defines people
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
	 * default constructor
	 */
	public Person() {
        super();
    }
	
	/**
	 * constructor with LocalDate object
	 * @param name given name
	 * @param number phone number
	 * @param dob date of birth
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
	 * constructor with time values
	 * @param name given name
	 * @param number phone number
	 * @param day day of birth
	 * @param month month of birth
	 * @param year year of birth
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
	 * getter name
	 * @return name given name
	 */
	public String name() { 
		return this.name;
	}

	/**
	 * setter name
	 * @param name given name
	 */
	public void name(String name) {
		this.name = name;
	}
	
	/**
	 * getter number
	 * @return number phone number
	 */
	public String number() {
		return this.number;
	}
	
	/**
	 * setter number
	 * @param number phone number
	 */
	public void number(String number) {
		this.name = number;
	}
	
	/**
	 * getter dob
	 * @return dob date of birth
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
	 * setter dob with LocalDate object
	 * @param dob date of birth
	 */
	public void dob(LocalDate dob) {
		// dob is immutable
		// requires write over
		this.dob = dob;
	}
	
	/**
	 * setter dob with time values
	 * @param day day of birth
     * @param month month of birth
     * @param year year of birth
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
	 * deep check equals method
	 * @param p Person object
	 * @return if equal
	 */
	public boolean equals(Person p) {
		return
				this.name.equals(p.name) &&
				this.number.equals(p.number) &&
				this.dob.equals(p.dob);
				
	}

    /**
     * redefines the toString for Person objects
     * @return String version of self
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
