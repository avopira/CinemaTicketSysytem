package Cinema;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CinemaTicketSystem {

    private Map<Integer, Movie> movies = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Ticket> tickets = new HashMap<>();
    private int currentMovieId = 1;
    private int currentUserId = 1;
    private int currentTicketId = 1;


    public CinemaTicketSystem() {
    }

    public int addMovie(String movieName) {
        int id = currentMovieId++;
        movies.put(id, new Movie(movieName, id));
        return id;
    }

    public void showAllMovies() {
        System.out.println("Список фильмов: ");
        for (Movie movie : movies.values()) {
            System.out.println(movie);   
        }
    }


    public int addUser(String userName) {
        int id = currentUserId++;
        users.put(id, new User(userName, id));
        return id;
    }

    public int buyTicket(int userId, int movieId) {
        if (users.containsKey(userId) && movies.containsKey(movieId)) {
            int ticketId = currentTicketId++;
            tickets.put(ticketId, new Ticket(userId, movieId, ticketId));
            return ticketId;
        }
        throw new IllegalArgumentException("User or movie not found.");
    }

    public boolean cancelTicket(int ticketId) {
        if (tickets.containsKey(ticketId)) {
            tickets.remove(ticketId);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CinemaTicketSystem system = new CinemaTicketSystem();
        Scanner scanner = new Scanner(System.in);
        boolean work = true;
        System.out.println("Здравствуйте!");

        while (work){
            System.out.println("У вас есть следующие доступные функции:");
            System.out.println("1. Добавить новый фильм;");
            System.out.println("2. Показать все доступные фильмы;");
            System.out.println("3. Добавить нового пользователя;");
            System.out.println("4. Купить билет;");
            System.out.println("5. Отменить покупку билета;");
            System.out.println("6. Завершить");
            System.out.print("Выберите функцию");
            System.out.println("\n");

            String answer = scanner.nextLine();
            switch (answer) {
                case "1":
                System.out.print("Введите название фильма: \n");
                String movieName = scanner.nextLine();
                int movieId = system.addMovie(movieName);
                System.out.println("Фильм " + movieName + " с номером ID " + movieId + " добавлен");
                break;
            case "2":
                system.showAllMovies();
                break;
            case "3":
                System.out.print("Введите имя пользователя:");
                String userName = scanner.nextLine();
                int userId = system.addUser(userName);
                System.out.println("Пользователь " + userName + " с номером ID " + userId + " добавлен");
                break;
            case "4":
                System.out.print("Введите ID пользователя: ");
                String userIdString = scanner.nextLine();
                int BuyUserId = Integer.parseInt(userIdString);
                System.out.print("Введите ID фильма: ");
                String movieIdString = scanner.nextLine(); 
                int BuyMovieId = Integer.parseInt(movieIdString);
                int ticketId = system.buyTicket(BuyUserId, BuyMovieId);
                System.out.println("Куплен билет с номером ID " + ticketId);
                break;
            case "5":
                System.out.print("Введите номер ID билета: ");
                String ticketIdToCancelString = scanner.nextLine();
                int ticketIdToCancel = Integer.parseInt(ticketIdToCancelString);
                boolean canceled = system.cancelTicket(ticketIdToCancel);
                System.out.println(canceled);
                break;
            case "6":
                System.out.println("До свидания!");
                scanner.close();
                return;
            default:
                System.out.println("Введено неверное значение. Попробуйте еще раз");
            }
        }


        // int movieId1 = system.addMovie("Inception");
        // int movieId2 = system.addMovie("The Matrix");
        // int movieId3 = system.addMovie("Hatiko");
        
        // system.showAllMovies();

        // int userId1 = system.addUser("Alice");
        // int userId2 = system.addUser("Bob");

        // int ticketId1 = system.buyTicket(userId1, movieId1);
        // int ticketId2 = system.buyTicket(userId2, movieId2);
        // int ticketId3 = system.buyTicket(userId1, movieId3);
        
        // boolean canceled = system.cancelTicket(ticketId1);
        // boolean canceled1 = system.cancelTicket(999);
        // System.out.println(canceled);
        // System.out.println(canceled1);
    }
}