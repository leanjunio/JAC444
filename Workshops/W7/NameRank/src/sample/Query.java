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

    Query(Query query) {
        this.year = query.year;
        this.gender = query.gender;
        this.name = query.name;
        this.rank = query.rank;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        String gender = (this.gender == 'M') ? "Boy" : "Girl";
        final StringBuffer sb = new StringBuffer(gender);
        sb.append(" name ").append(this.name);
        sb.append(" is ranked #").append(this.rank);
        sb.append(" in ").append("year ").append(this.year);
        return sb.toString();
    }
}
