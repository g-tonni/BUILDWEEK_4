package giada_tonni.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super("L'elemento con id " + id + " non è stato trovato");
    }
}
