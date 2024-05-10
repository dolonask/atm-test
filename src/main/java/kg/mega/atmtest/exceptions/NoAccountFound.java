package kg.mega.atmtest.exceptions;

public class NoAccountFound extends RuntimeException{

    public NoAccountFound(String message) {
        super("Аккаунт клиента не найден! accountNumber = " + message);
    }
}
