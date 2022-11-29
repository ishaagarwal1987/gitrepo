package lockedme;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	static int count = 0;
	List<MyFile> files = new ArrayList<>();

	public FileUtil() {
		File f = new File("D:\\test");

		String[] fs = f.list();
		if (fs != null) {
			for (String file : fs) {
				count++;
				files.add(new MyFile(count, file));
			}
		} else
			System.out.println("Specified Path is incorrect. Please specify the correct path.\n ");

	}

	public List<MyFile> getFiles() {
		File f = new File("D:\\test");

		String[] fs = f.list();

		files.clear();
		count = 0;
		for (String file : fs) {
			count++;
			files.add(new MyFile(count, file));
		}

		return files;
	}

	public void addFile(String fileName) throws IOException {

		if (this.search(fileName))
			System.out.println("File already exist.\n");
		else {
			File f = new File("D:\\test\\" + fileName + ".txt");
			f.createNewFile();
			System.out.println("Congratulations!! Your file has been successfully created.\n");
		}
	}

	public void deleteFile(String fileName) {
		boolean isDeleted = false;
		files = getFiles();

		for (MyFile file : files) {
			if (file.getFilename().startsWith(fileName)) {
				File f = new File("D:\\test\\" + fileName + ".txt");
				f.delete();
				isDeleted = true;
				break;
			}
		}

		if (isDeleted) {
			System.out.println("Your file has been successfully deleted. \n");
		} else {
			System.out.println("File Not Found. \n");
		}
	}

	public boolean search(String fileName) {
		boolean isIdentified = false;
		files = getFiles();

		for (MyFile file : files) {
			if (file.getFilename().startsWith(fileName)) {
				isIdentified = true;
				break;
			}
		}

		return isIdentified;
	}
}
