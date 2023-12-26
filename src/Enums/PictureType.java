package Enums;

public enum PictureType {
    PORTRAITS("портрет"),
    BLANK("пустой холст"),
    GRAFFITI("граффити");

    private String type;

    PictureType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}

