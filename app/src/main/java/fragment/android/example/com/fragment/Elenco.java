package fragment.android.example.com.fragment;

public class Elenco {

    private String  Name;
    private String Surname;
    private int Photo;

    public Elenco(String name, String surname, int photo) {
        Name = name;
        Surname = surname;
        Photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
