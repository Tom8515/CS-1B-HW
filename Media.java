import java.io.*;//JB
import java.util.Collections; //JP

/**
 * One object of class Media stores a list of the various media types.
 * @author JessicaPak
 * 
 */
public class Media implements Serializable, Comparable<Media> { // JB,JP
	private int type;
	private String title; // JB
	private String format; // JP
	private String location; // JP
	private String notes; // JP

	/**
	 * default constructor//JP
	 */

	public Media() {// JP
		title = "Title";// JB
		format = "Format";// JP
		location = "Location";// JP
		notes = "Notes";// JP
		type = 1;
	}

	/**
	 * parameterized constructor//JP
	 * 
	 * @param title
	 * @param format
	 * @param location
	 * @param notes
	 */

	public Media(String newTitle, String newFormat, // JB
			String newLocation, String newNotes) {// JP
		title = newTitle;
		format = newFormat;
		location = newLocation;
		notes = newNotes;		
	}

	/**
	 * returns the current value of type//JB
	 */
	public int getType() {// JB
		return type;// JB
	}

	/**
	 * returns the current value of title//JB
	 */
	public String getTitle() {// JB
		return title;// JB
	}

	/**
	 * returns the current value of format//JP
	 */
	public String getFormat() {// JP
		return format;// JP
	}

	/**
	 * returns the current value of location//JP
	 */
	public String getLocation() {// JP
		return location;// JP
	}

	/**
	 * returns the current value of notes//JP
	 */
	public String getNotes() {// JP
		return notes;// JP
	}

	/**
	 * sets the value of type to newType//JB
	 * @param newType
	 *            //JB
	 */
	public void setType(int newType) {// JB
		type = newType;// JB
	}

	/**
	 * sets the value of title to newTitle//JB
	 * @param newTitle
	 *            //JB
	 */
	public void setTitle(String newTitle) {// JB
		title = newTitle;// JB
	}

	/**
	 * sets the value of format to newFormat//JP
	 * @param newFormat
	 *            //JP
	 */
	public void setFormat(String newFormat) {// JP
		format = newFormat;// JP
	}

	/**
	 * sets the value of location to newLocation//JP
	 * @param newLocation
	 */
	public void setLocation(String newLocation) {// JP
		location = newLocation;// JP
	}

	/**
	 * sets the value of notes to newNotes//JP
	 * @param newNotes
	 */
	public void setNotes(String newNotes) {// JP
		notes = newNotes;// JP
	}

	/**
	 * Returns a String containing all the data stored in this object. JP
	 */
	public String toString() {// JP
		String result = "";
		result = "Title: " + this.getTitle() + "\n" + "Format: "
				+ this.getFormat() + "\n" + "Location: " + this.getLocation()// JB
				+ "\n" + "Notes: " + this.getNotes() + "\n";// JP
		return result;
	}

	/**
	 * Compares entries to allow them to be sorted.//JB JP
	 */
	public int compareTo(Media m) {
		if (this.getType() < m.getType()) {
			return -1;
		} else if (this.getType() >m.getType()) {
			return 1;
		} else {
			return this.getTitle().compareTo(m.getTitle());
		}
	}
}
