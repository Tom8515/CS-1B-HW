import java.io.Serializable;

/**
 * One object of class VideoGame stores the information of one video game. One
 * video game consists of the information of the video game title, format,
 * location, and notes JP
 */
public class VideoGame extends Media implements Serializable { // JB JP

	/**
	 * default constructor JP
	 */
	public VideoGame() {
		super();
		super.setType(4);// JB
	}

	/**
	 * parameterized constructor JP
	 */

	public VideoGame(String newTitle, String newFormat, String newLocation,
			String newNotes) {
		super(newTitle, newFormat, newLocation, newNotes);
		super.setType(4);
	}

	/**
	 * Returns a String containing all the data stored in this object.//JP
	 */

	public String toString() {// JB
		return "\t" + "Video Game:" + "\n" + super.toString();// JB
	}
}
