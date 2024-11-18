class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

public class genericPractice {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        Box<Integer> intBox = new Box<>();
        String s1 = "hello";
        stringBox.setItem(s1);
        System.out.println(stringBox.getItem());
        int i1 = 1;
        intBox.setItem(i1);
        System.out.println(intBox.getItem());
    }
}
