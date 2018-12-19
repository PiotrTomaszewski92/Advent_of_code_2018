public class Day3_claim {

    private int id;
    private int top;
    private int left;
    private int weight;
    private int height;

    @Override
    public String toString() {
        return "Day3_claim{" +
                "id=" + id +
                ", top=" + top +
                ", left=" + left +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    public Day3_claim(int id, int left, int top, int weight, int height) {
        this.id = id;
        this.top = top;
        this.left = left;
        this.weight = weight;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
