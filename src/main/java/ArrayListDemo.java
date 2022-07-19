import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ObservableList<Integer> olNumbers= FXCollections.observableArrayList();
        olNumbers.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> change) {
                System.out.println("Subscriber 1");
            }
        });
        olNumbers.add(10);

    }
}
