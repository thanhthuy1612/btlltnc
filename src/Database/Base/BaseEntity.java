package Database.Base;

public abstract class BaseEntity {
    public BaseEntity(){

    }
    public abstract Integer getId();
    public String textSearch = "";
    public void setTextSearch(String textSearch){
        this.textSearch = textSearch;
    }
}
