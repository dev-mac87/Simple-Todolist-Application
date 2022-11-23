import java.util.Arrays;
import java.util.Collection;

public class SimpleTodolistApp {

    public static String[] todoLists = new String[10];
    public static void main(String[] args) {
        testAddTodoList();
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {
        for (int i = 0; i < todoLists.length; i++) {
            var todo = todoLists[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        todoLists[0] = "Belajar Java Dasar";
        todoLists[1] = "Belajar Studi Kasus Java Dasar : Aplikasi Todo List";
        showTodoList();
    }
    /**
     * Menambahkan todo list
     */
    public static void addTodoList(String todo) {
        // Cek data array sudah penuh atau belum
        var isFull = true;
        for (int i = 0; i < todoLists.length; i++) {
            if (todoLists[i] == null) {
                isFull = false;
                break;
            }
        }

        // Jika penuh risize array
        if (isFull) {
            var todoListsTemp = todoLists;
            todoLists = new String[todoLists.length * 2];

            for (int i = 0;i < todoListsTemp.length; i++) {
                todoLists[i] = todoListsTemp[i];
            }
        }

        // Menambahkan ke posisi yang data array nya kosong
        for (int i = 0; i < todoLists.length; i++) {
            if (todoLists[i] == null) {
                todoLists[i] = todo;
                break;
            }
        }

    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Todo List ke-"+i);
        }
        showTodoList();
    }

    /**
     * Menghapus todo list
     */
    public static void removeTodoList() {

    }

    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList() {

    }

    /**
     * Menampilkan view add todo list
     */
    public static void viewAddTodoList() {

    }

    /**
     * Menampilkan view remove todo list
     */
    public static void viewRemoveTodoList() {

    }

}
