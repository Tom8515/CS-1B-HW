import java.util.ArrayList;
import java.util.Comparator;
import java.io.*; // JB
import java.util.Collections;

/**
 * one object of this class creates a library and has methods that adds, prints,
 * deletes, and retrieves the data.
 */
public class Library implements Serializable {

	private ArrayList<Media> library;
	private ObjectInputStream input;
	private ObjectOutputStream output;

	/**
	 * default constructor JP
	 */
	public Library() {
		library = new ArrayList<Media>();
	}

	/**
	 * adds a media object to the library JB
	 */
	public void add(Media m) throws IOException {
		if (m.getTitle().isEmpty()) {// JB
			System.out.println("You must add a title.");// JB
			return;
		}
		library.clear();
		try {
			try {
				openReadFile();
				while (true) {
					Media med = (Media) input.readObject();
					library.add(med);
				}
			} catch (EOFException endOfFileException) {
				// Read passed end of file
			} catch (ClassNotFoundException classNotFoundException) {
				System.out.println("Unable to create object");
			} catch (IOException ioException) {
				// Read empty file
			} finally {
				closeReadFile();
			}
			library.add(m);
			//Collections.sort(library);
			openWriteFile();
			for (Media med : library) {
				output.writeObject(med);
			}
			closeWriteFile();
			library.clear();
		} catch (IOException ioException) {
			throw new IOException("Error writing to file");
		}
	}
	/**
	 * sorts the all the entries in the list JP
	 */
	public void sort()throws IOException{
		library.clear();
		try{
			try{
				openReadFile();
				while (true){
					Media med = (Media) input.readObject();
					library.add(med);
					Collections.sort(library);
				}
			}
			catch (EOFException endOfFileException){
				//Read passed end of file
			}
			catch (ClassNotFoundException classNotFoundException){
				System.out.println("Unable to create object");
			}
			catch (IOException ioException){
				// Read empty file
			}
			finally{
				closeReadFile();
			}
			Collections.sort(library);
			openWriteFile();
			for(Media med: library){
				output.writeObject(med);
			}
			closeWriteFile();
			library.clear();
		}
		catch (IOException ioException){
			throw new IOException("Error writing to file");
		}

	}	
	/**
	 * opens a text file so objects may be read into it //JB
	 */

	public void openReadFile() throws IOException {
		try {
			input = new ObjectInputStream(new FileInputStream("library.ser"));
		} catch (IOException ioException) {
			throw ioException;
		}
	}

	/**
	 * opens the text file so objects can be read from it and displayed //JB
	 */
	public void openWriteFile() throws IOException {
		try {
			output = new ObjectOutputStream(new FileOutputStream("library.ser"));
		} catch (IOException ioException) {
			System.out.println("Error opening file.");
		}
	}

	/**
	 * closes text file after all objects have been added to it //JB
	 */
	public void closeReadFile() {
		try {
			if (input != null)
				input.close();
		} catch (IOException ioException) {
			System.out.println("Error closing file.");
		}
	}

	/**
	 * closes text file after contents of file have been displayed //JB
	 */
	public void closeWriteFile() {
		try {
			if (output != null)
				output.close();
		} catch (IOException ioException) {
			System.out.println("Error closing file.");
		}
	}

	/**
	 * Returns a string containing all the data stored in this object JB
	 */
	public String toString() {
		String result = "Library Contents:\n " + "\n";
		try {
			openReadFile();
			while (true) {
				Media m = (Media) input.readObject();
				result += m.toString() + "\n";
			}
		} catch (EOFException endOfFileException) {

		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println("Unable to create object");
		} catch (IOException ioException) {

		} finally {
			closeReadFile();
		}
		return result;
	}

	/**
	 * takes in the title as a parameter and searches the list of that same
	 * title TB
	 */
	public ArrayList<Media> retrieveByTitle(Media t) throws IOException {
		library.clear(); 
		try { //JB
			openReadFile();
			while (true) {
				Media med = (Media) input.readObject();
				if (med.getTitle().equals(t.getTitle()))
					library.add(med);
			}
		} catch (EOFException endOfFileException) {
			// Read passed end of file
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println("Unable to create object");
		} catch (IOException ioException) {
			// Read empty file
		} finally {
			closeReadFile();
		}

		return library;// JB
	}

	/**
	 * takes in the media type and title as a parameter and searches the list of
	 * that same media type and title JP
	 */
	public ArrayList<Media> retrieveByTitleAndMedia(Media m)
			throws IOException {
		library.clear();
		try { //JP
			openReadFile();
			while (true) {
				Media med = (Media) input.readObject();
				if (med.getTitle().equals(m.getTitle())
						&& med.getType() == m.getType())
					library.add(med);
			}
		} catch (EOFException endOfFileException) {
			// Read passed end of file
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println("Unable to create object");
		} catch (IOException ioException) {
			// Read empty file
		} finally {
			closeReadFile();
		}

		return library;// JB
	}

	/**
	 * retrieve by Media type
	 * @param m
	 * @return
	 * @throws IOException //JP JB
	 */
	public ArrayList<Media> retrieveByMedia(Media m) throws IOException {
		library.clear();
		try {
			openReadFile();
			while (true) {
				Media med = (Media) input.readObject();
				if (m.getType() == med.getType())
					library.add(med);
			}
		} catch (EOFException endOfFileException) {
			// Read passed end of file
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println("Unable to create object");
		} catch (IOException ioException) {
			// Read empty file
		} finally {
			closeReadFile();
		}

		return library;// JB
	}

	/**
	 * deletes an entry by media from an ArrayList JP
	 */
	public void deleteMedia(Media m) throws IOException {

		if (m.getTitle().isEmpty()) {// JB
			System.out.println("You must add a title.");// JB
			return;
		}
		library.clear();
		try {

			try {	
				openReadFile();
				while (true) {
					Media med = (Media) input.readObject();
					if ((med.getType() != (m.getType())))
						library.add(med);
				}
			} catch (EOFException endOfFileException) {
				// Read passed end of file
			} catch (ClassNotFoundException classNotFoundException) {
				System.out.println("Unable to create object");
			} catch (IOException ioException) {
				// Read empty file
			} finally {
				closeReadFile();
			}
			openWriteFile();
			for (Media med : library) {
				output.writeObject(med);
			}
			closeWriteFile();
			library.clear();
		} catch (IOException ioException) {
			throw new IOException("Error writing to file");
		}
	}
	/**
	 * deletes an entry by title from an ArrayList JP
	 */
	public void delete(Media m) throws IOException {

		if (m.getTitle().isEmpty()){// JB
			m.setTitle(null);
			System.out.println("You must add a title.");// JB
			return;
		}
		library.clear();
		try {

			try {	
				openReadFile();
				while (true) {
					Media med = (Media) input.readObject();
					if (!med.getTitle().equals(m.getTitle()))
						library.add(med);
				}
			} catch (EOFException endOfFileException) {
				// Read passed end of file
			} catch (ClassNotFoundException classNotFoundException) {
				System.out.println("Unable to create object");
			} catch (IOException ioException) {
				// Read empty file
			} finally {
				closeReadFile();
			}
			openWriteFile();
			for (Media med : library) {
				output.writeObject(med);
			}
			closeWriteFile();
			library.clear();
		} catch (IOException ioException) {
			throw new IOException("Error writing to file");
		}
	}
}
