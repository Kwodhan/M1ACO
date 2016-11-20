package receiver;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Gére le chargement et la sauvegarde d'un fichier texte
 * 
 * @author kwodhan
 *
 */
public class FluxFile {
	/**
	 * Chargement d'un fichier
	 * @param nameFile nom du fichier à charger
	 * @return un buffer
	 * @throws IOException
	 * @throws ErreurInsertionException
	 */
	protected Buffer FileToBuffer(String nameFile) throws IOException, ErreurInsertionException {
		FileReader inputStream = null;
		Buffer buffer = new Buffer();

		try {
			inputStream = new FileReader("sauvegarde/" + nameFile + ".txt");

			int c;
			while ((c = inputStream.read()) != -1) {
				buffer.AddChar(buffer.length(), new Character((char) c));
			}
		} finally {
			System.out.println("Fichier " + nameFile + " chargé");
			if (inputStream != null) {

				inputStream.close();

			}

		}
		return buffer;
	}

	/**
	 * Sauvegarde d'un fichier
	 * @param buffer le buffer à enregister
	 * @param namefile le nom du fichier à enregistrer
	 * @throws IOException
	 * @throws ErreurInsertionException
	 */
	protected void BufferToFile(Buffer buffer, String namefile) throws IOException, ErreurInsertionException {

		File fichier = new java.io.File("sauvegarde/" + namefile + ".txt");
		if (fichier.exists()) {
			System.out.println("Fichier " + namefile + " ecrasé");

		} else {
			System.out.println("Fichier " + namefile + " crée");

			fichier.createNewFile();

		}

		PrintWriter outputStream = null;

		try {

			outputStream = new PrintWriter(new FileWriter("sauvegarde/" + namefile + ".txt"));

			int i = 0;
			while (i < buffer.length()) {

				outputStream.write(buffer.charAt(i));
				i++;
			}
		} finally {
			System.out.println("Fichier " + namefile + " sauvegardé dans " + fichier.getAbsolutePath());
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

}