package client;

import java.util.Scanner;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) {
		ItfIhmMoteur ihm = new SimpleIHM();
		scanner = new Scanner(System.in);
		String commande = new String();

		while (!commande.equals("exit")) {
			ihm.afficher();
			System.out.print("$>");
			commande = scanner.nextLine();
			String[] arguments = commande.split(" ");

			switch (arguments[0]) {
			case "copier":
				ihm.pressCopier();
				break;
			case "coller":
				ihm.pressColler();
				break;
			case "couper":
				ihm.pressCouper();
				break;
			case "sauv":
				if (arguments.length > 1) {
					ihm.pressSauvegarder(arguments[1]);
				}
				break;
			case "charge":
				if (arguments.length > 1) {
					ihm.pressCharger(arguments[1]);
				}
				break;
			case "select":
				if (!(arguments.length > 2)) {
					System.err.println("il faut deux arguements int et int\nexemple : select 0 0");
					break;
				}
				try {
					int arg1 = Integer.parseInt(arguments[1]);
					int arg2 = Integer.parseInt(arguments[2]);
					ihm.pressSelection(arg1, arg2);
				} catch (Exception e) {
					System.err.println("il faut deux arguements int et int\nexemple : select 0 0");
				}
				break;
			case "insert":
				if (arguments.length > 1 ) {

					String ajout = new String();
					for (int i = 1; i < arguments.length; i++) {
						ajout = ajout.concat(arguments[i] + " ");

					}
					char before = ajout.charAt(0);
					
					for (int j = 0; j < ajout.length() - 1; j++) {
						char c = ajout.charAt(j);
						
						if (before == '\\' && c == 'n') {
							ihm.pressInsertion('\n');
						} else if(c == '\\') {
							
						}else if(before == '\\' && c != 'n'){
							ihm.pressInsertion('\\');
							ihm.pressInsertion(c);
						}else{
							ihm.pressInsertion(c);
						}
						before = c;
					}

				}
				break;
			case "sup":
				ihm.pressSupprimer();
				break;
			case "start":
				ihm.pressDebut();
				break;
			case "stop":
				ihm.pressStop();
				break;
			case "rejouer":
				ihm.pressRejouer();
				break;
			case "exit":
				System.out.println("see you later");
				break;
			default:
				System.out.println("pas imple");
				break;
			}

		}

	}

}
