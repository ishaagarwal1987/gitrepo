package lockedme;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Test {
	
	void menu()
	{
		System.out.println();
		System.out.println("1. Add File");
		System.out.println("2. Delete File");
		System.out.println("3. Display Files");
		System.out.println("4. Search File");
		System.out.println("5. Exit");
	}

	public static void main(String[] args) throws IOException {

		FileUtil util = new FileUtil();
		Test obj = new Test();
		int ch;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\t Welcome to LockedMe.com !! ");
		System.out.println("\tI am Isha Agarwal - Developer of the application. ");
		System.out.println("\tPlease select any one of the options listed below to proceed further. ");
		
		while (true) {
			
			obj.menu();
			System.out.println("Enter your Choice: ");
			try {
				ch = Integer.parseInt(br.readLine());
				switch (ch) {
				case 1:
					String fileName;
					System.out.println("Enter the File Name without extensions : ");
					fileName = br.readLine();
					util.addFile(fileName);
					break;
				case 2:
					String fileName1;
					System.out.println("Enter the File Name : ");
					fileName1 = br.readLine();
					util.deleteFile(fileName1);
					break;
				case 3:
					List<MyFile> files = util.getFiles();
					for (MyFile f : files)
						System.out.println(f.getId() + "\t" + f.getFilename());
					break;

				case 4:
					String fileName2;
					System.out.println("Enter the File Name : ");
					fileName2 = br.readLine();
					if (util.search(fileName2)) {
						System.out.println("File Existed.\n");
					} else {
						System.out.println("File Not Existed. \n");
					}
					break;
				case 5:System.out.println("Byee! See you later.\n ");
					br.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please enter your choices betwen 1 to 5 only. \n");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter the numbers only.\n");
				
			}
		}

	}
}
