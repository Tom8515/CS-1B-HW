import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The creates a Media list and adds, deletes, change, and search the various
 * media types stored in the list.//JP
 */

public class Main {// JP
	private static GUI gui;// JB
	private static Library ourLibrary;// JB

	/**
	 * gets user input from the view and sets its values to a new Book object
	 * and adds it to the library
	 * @throws IOException
	 */
	public static void gotNewBook(String authorInput, String title,
			String format, String location, String notes) {
		Book newBook = new Book(authorInput, title, format, location, notes);
		try {
			ourLibrary.add(newBook);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * gets user input from the view and sets its values to a new Song object
	 * and adds it to the library
	 */
	public static void gotNewSong(String artistInput, String title,
			String genre, String format, String location, String notes) {
		Song newSong = new Song(artistInput, title, genre, format, location,
				notes);
		try {
			ourLibrary.add(newSong);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * gets user input from the view and sets its values to a new Video object
	 * and adds it to the library
	 */
	public static void gotNewVideo(String title, String starInput,
			String format, String location, String notes) {
		Video newVideo = new Video(title, starInput, format, location, notes);
		try {
			ourLibrary.add(newVideo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * gets user input from the view and sets its values to a new VideoGame
	 * object and adds it to the library
	 */
	public static void gotNewVideoGame(String title, String format,
			String location, String notes) {
		VideoGame newVideoGame = new VideoGame(title, format, location, notes);
		try {
			ourLibrary.add(newVideoGame);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * calls the Library's toString() and returns the entire library to the view
	 * to be printed out.
	 * @return
	 * @throws IOException 
	 */
	public static String printLibrary() throws IOException {
		try{
			ourLibrary.sort();
		}catch(IOException e){
			e.printStackTrace();
		}
		return ourLibrary.toString();
	}

	/**
	 * calls the library's retrieve by title function and sends it to the view to be 
	 * printed out
	 * @param args
	 */
	public static String searchTitle(String title) {
		String stringResult = " ";
		Media newMedia = new Media(title, null, null, null);
		try {
			ArrayList<Media> result = ourLibrary.retrieveByTitle(newMedia);
			for (Media m : result) {
				stringResult += m.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stringResult;

	}

	/**
	 * calls the library's retrieve by media function and sends it to the view 
	 * to be printed out
	 * @param args
	 */
	public static String searchMedia(String media) {
		String stringResult = " ";
		Media newMedia = new Media();
		if (media.equals("book") || media.equals("Book") )
			newMedia.setType(1);
		else if (media.equals("song") || media.equals("Song"))
			newMedia.setType(2);
		else if (media.equals("video") || media.equals("Video"))
			newMedia.setType(3);
		else if (media.equals("video game") || media.equals("Video Game"))
			newMedia.setType(4);
		try {
			ArrayList<Media> result = ourLibrary.retrieveByMedia(newMedia);

			for (Media m : result) {
				stringResult += m.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringResult;
	}

	/**
	 * calls the library's retrieve by both function and sends it to the
	 * view to be printed out
	 * @param args
	 */
	public static String searchBoth(String title, String media) {
		String stringResult = " ";
		Media newMedia = new Media();
		newMedia.setTitle(title);
		if (media.equals("Book"))
			newMedia.setType(1);
		else if (media.equals("Song"))
			newMedia.setType(2);
		else if (media.equals("Video"))
			newMedia.setType(3);
		else if (media.equals("Video Game"))
			newMedia.setType(4);
		try {
			ArrayList<Media> result = ourLibrary
					.retrieveByTitleAndMedia(newMedia);
			for (Media m : result) {
				stringResult += m.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringResult;
	}

	/**
	 * calls the library's retrieve by title then deletes the specific entry.
	 */
	public static void deleteByTitle(String title) {
		Media newMedia = new Media();
		newMedia.setTitle(title);
		try {
			ourLibrary.delete(newMedia);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * deletes by media type
	 * @param media
	 */
	public static void deleteByMedia(String media){
		Media newMedia = new Media();
		if (media.equals("Book") || media.equals("book"))
			newMedia.setType(1);
		else if(media.equals("Song") || media.equals("song"))
			newMedia.setType(2);
		else if(media.equals("Video") || media.equals("video"))
			newMedia.setType(3);
		else if(media.equals("Video Game") || media.equals("video game"))
			newMedia.setType(4);
		try{
			ourLibrary.deleteMedia(newMedia);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * our main function
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		gui = new GUI();
		ourLibrary = new Library();

	}
}
