package Backend;

public class Picture {
    private int picture_id;
    private String picture_address, picture_name;

    public Picture(int picture_id, String picture_address, String picture_name){
        this.picture_id = picture_id;
        if (picture_address != null){
            this.picture_address = picture_address;
        }
        if (picture_name != null){
            this.picture_name = picture_name;
        }
    }

    // setters
    public void setPicture_address(String picture_address) {
        this.picture_address = picture_address;
    }

    public void setPicture_id(int picture_id) {
        this.picture_id = picture_id;
    }

    public void setPicture_name(String picture_name) {
        this.picture_name = picture_name;
    }

    // Getters
    public int getPicture_id() {
        return picture_id;
    }

    public String getPicture_address() {
        return picture_address;
    }

    public String getPicture_name() {
        return picture_name;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "picture_id=" + picture_id +
                ", picture_address='" + picture_address + '\'' +
                ", picture_name='" + picture_name + '\'' +
                '}';
    }
}
