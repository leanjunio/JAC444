package sample;

public class Query {
    private int year;
    private char gender;
    private String name;
    private int rank;

    public Query(int year, char gender, String name, int rank) {
        this.year = year;
        this.gender = gender;
        this.name = name;
        this.rank = rank;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(Character.toString(this.gender));
        sb.append(" name ").append(this.name);
        sb.append(" is ranked #").append(this.rank);
        sb.append(" in ").append(this.year).append(" year");
        return sb.toString();
    }
}
