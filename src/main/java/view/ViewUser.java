package view;

import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Scanner;

public class ViewUser {
    private UserRepository userRepository;

    public ViewUser() {
        userRepository = new UserRepository();
    }

    public void meniu() {
        System.out.println("Apasa tasta 1 pentru a afisa toate userele din baza de date");
        System.out.println("Apasa tasta 2 pentru a insera un nou user in baza de date");
        System.out.println("Apasa tasta 3 pentru a sterge oun user din baza de date");
        System.out.println("Apasa tasta 4 pentru a schimba data ");
        System.out.println("Apasa tasta 5 pentru a sterge dupa user din baza de date");
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int alegere = 0;
        while (run = true) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    showUser();
                    break;
                case 2:insertUser();
                break;
                case 3:stergeUnUser();
                break;
                case 4:updateCreatedAt();
                break;
                case 5:stergeUsername();
                break;
            }
        }
    }


    public void showUser() {
        List<User> masini = userRepository.allUsers();
        for (User m : masini) {
            System.out.println(m.toString());
        }
    }

    public void insertUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti usernameul");
        String username = scanner.nextLine();
        System.out.println("Introduceti created_at");
        String created_at = scanner.nextLine();


        User user=new User(id,username,created_at);
        userRepository.insertUser(user);


    }


    public void stergeUnUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id ul userului pe care doriti s-l sterget");
        int id = Integer.parseInt(scanner.nextLine());
        userRepository.stergeUserById(id);
        System.out.println("User s-a sters");

    }

    public void updateCreatedAt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti userul carui dorit sa modificati data");
        String user= scanner.nextLine();
        System.out.println("Introduceti date nou");
       String created_at=scanner.nextLine();
        userRepository.updateCreatedAt(user, created_at);
    }


    public void stergeUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Itroduceti userul care doriti sa-l stergeti");
        String username = scanner.nextLine();
        userRepository.deleteUsername(username);
    }
}
