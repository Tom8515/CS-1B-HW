/**
 * one object of this class creates a graphical user
 * interface JP/JB
 */
import java.awt.event.*;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.applet.Applet;
import java.io.IOException;

public class GUI extends JFrame implements ActionListener {
	public JLabel prompt; // JP
	private JButton addBook;// JP
	private JButton addSong;// JP
	private JButton addVideo;// JP
	private JButton addVideoGame;// JP

	private JButton search; // JP

	private JButton displayAll; // JP
	private JButton delete; // JP

	/**
	 * creates components and adds the components to the frame JP
	 */
	private void initialize() {
		this.setLayout(new FlowLayout());
		this.setSize(600, 300);

		addBook = new JButton("Add Book");
		this.add(addBook);
		addBook.addActionListener(this);

		addSong = new JButton("Add Song");
		this.add(addSong);
		addSong.addActionListener(this);

		addVideo = new JButton("Add Video");
		this.add(addVideo);
		addVideo.addActionListener(this);

		addVideoGame = new JButton("Add Video Game");
		this.add(addVideoGame);
		addVideoGame.addActionListener(this);

		search = new JButton("Search");
		this.add(search);
		search.addActionListener(this);

		displayAll = new JButton("Display All");
		this.add(displayAll);
		displayAll.addActionListener(this);

		delete = new JButton("Delete");
		this.add(delete);
		delete.addActionListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	/**
	 * default constructor JP
	 */
	public GUI() {
		this.initialize();
	}

	/**
	 * contains the code response to the components JP
	 */
	public void actionPerformed(ActionEvent evt) {
		if (prompt != null) //JP
			this.remove(prompt);
		if (evt.getSource() == addBook) { //JP JB
			String authorInput = JOptionPane.showInputDialog(null,
					"Enter Author: ");
			String title = JOptionPane.showInputDialog(null, "Enter Title: ");
			String format = JOptionPane.showInputDialog(null, "Enter Format: ");
			String location = JOptionPane.showInputDialog(null,
					"Enter Location: ");
			String notes = JOptionPane.showInputDialog(null, "Enter Notes: ");

			Main.gotNewBook(authorInput, title, format, location, notes);
		} else if (evt.getSource() == addSong) { //JP JB
			String artistInput = JOptionPane.showInputDialog(null,
					"Enter Artist: ");
			String title = JOptionPane.showInputDialog(null, "Enter Title: ");
			String genre = JOptionPane.showInputDialog(null, "Enter Genre: ");
			String format = JOptionPane.showInputDialog(null, "Enter Format: ");
			String location = JOptionPane.showInputDialog(null,
					"Enter Location: ");
			String notes = JOptionPane.showInputDialog(null, "Enter Notes: ");

			Main.gotNewSong(artistInput, title, genre, format, location, notes);
		} else if (evt.getSource() == addVideo) { //JP JB
			String starInput = JOptionPane
					.showInputDialog(null, "Enter Star: ");
			String title = JOptionPane.showInputDialog(null, "Enter Title: ");
			String format = JOptionPane.showInputDialog(null, "Enter Format: ");
			String location = JOptionPane.showInputDialog(null,
					"Enter Location: ");
			String notes = JOptionPane.showInputDialog(null, "Enter Notes: ");

			Main.gotNewVideo(starInput, title, format, location, notes);
		} else if (evt.getSource() == addVideoGame) { //JP JB
			String title = JOptionPane.showInputDialog(null, "Enter Title: ");
			String format = JOptionPane.showInputDialog(null, "Enter Format: ");
			String location = JOptionPane.showInputDialog(null,
					"Enter Location: ");
			String notes = JOptionPane.showInputDialog(null, "Enter Notes: ");

			Main.gotNewVideoGame(title, format, location, notes);
		} else if (evt.getSource() == search) { //JP JB
			String option = JOptionPane.showInputDialog(null,
					"Would you like to search by title or media type?"
							+ " Please enter Title or Media");
			if (option.equals("Title")) {
				String title = JOptionPane.showInputDialog(null,
						"Enter Title: ");
				JTextArea textArea2 = null;
				textArea2 = new JTextArea(Main.searchTitle(title));
				JScrollPane scrollPane2 = new JScrollPane(textArea2);
				textArea2.setLineWrap(true);
				textArea2.setWrapStyleWord(true);
				scrollPane2.setPreferredSize(new Dimension(500, 500));
				JOptionPane.showMessageDialog(null, scrollPane2,
						Main.searchMedia(title), EXIT_ON_CLOSE, null);
			} else if (option.equals("Media")) { //JP JB

				String media = JOptionPane.showInputDialog(null,
						"Enter Media: ");
				JTextArea textArea = null;
				textArea = new JTextArea(Main.searchMedia(media));
				JScrollPane scrollPane = new JScrollPane(textArea);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				scrollPane.setPreferredSize(new Dimension(500, 500));
				JOptionPane.showMessageDialog(null, scrollPane,
						Main.searchMedia(media), EXIT_ON_CLOSE, null);
				String input = JOptionPane.showInputDialog(null,
						"Please enter the title of the entry "
								+ "you would like to search?");
				JTextArea textArea1 = null;
				textArea1 = new JTextArea(Main.searchTitle(input));
				JScrollPane scrollPane1 = new JScrollPane(textArea1);
				textArea1.setLineWrap(true);
				textArea1.setWrapStyleWord(true);
				scrollPane1.setPreferredSize(new Dimension(500, 500));
				JOptionPane.showMessageDialog(null, scrollPane1,
						Main.searchMedia(input), EXIT_ON_CLOSE, null);
			}
		} else if (evt.getSource() == displayAll) { //JP JB
			JTextArea textArea = null;
			try {
				textArea = new JTextArea(Main.printLibrary());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JScrollPane scrollPane = new JScrollPane(textArea);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			try {
				JOptionPane.showMessageDialog(null, scrollPane,
						Main.printLibrary(), EXIT_ON_CLOSE, null);
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (evt.getSource() == delete) { //JP JB
			String option = JOptionPane.showInputDialog(null,
					"Would you like to delete by title or media type?"
							+ " Please enter Title or Media");
			if (option.equals("Title")) {
				String title = JOptionPane.showInputDialog(null,
						"Enter Title: ");
				Main.deleteByTitle(title);
			} else if (option.equals("Media")) {

				String media = JOptionPane.showInputDialog(null,
						"Enter Media: ");
				JTextArea textArea = null;
				textArea = new JTextArea(Main.searchMedia(media));
				JScrollPane scrollPane = new JScrollPane(textArea);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				scrollPane.setPreferredSize(new Dimension(500, 500));
				JOptionPane.showMessageDialog(null, scrollPane,
						Main.searchMedia(media), EXIT_ON_CLOSE, null);
				String input = JOptionPane.showInputDialog(null,
						"Please enter the title of the entry "
								+ "you would like to delete?");
				Main.deleteByTitle(input);
			}
		}
		validate();
	}
}
