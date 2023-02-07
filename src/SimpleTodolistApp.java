public class SimpleTodolistApp {

    public static String[] todoLists = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {
        System.out.println("=======> TODOLIST <=======");
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
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= todoLists.length) {
            return false;
        } else if (todoLists[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < todoLists.length; i++) {
                if (i == (todoLists.length - 1)) {
                    todoLists[i] = null;
                } else {
                    todoLists[i] = todoLists[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("Todo ke 1");
        addTodoList("Todo ke 2");
        addTodoList("Todo ke 3");
        addTodoList("Todo ke 4");
        addTodoList("Todo ke 5");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(6);
        System.out.println(result);

        result = removeTodoList(1);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Name");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println("Channel " + channel);
    }
    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();
            System.out.println("=======> MENU <=======");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")){
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewTodoList() {
        addTodoList("Todo Ke 1");
        addTodoList("Todo Ke 2");
        addTodoList("Todo Ke 3");
        addTodoList("Todo Ke 4");
        addTodoList("Todo Ke 5");
        addTodoList("Todo Ke 6");
        viewShowTodoList();
    }

    /**
     * Menampilkan view add todo list
     */
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x Jika Batal)");
        if (todo.equals("x")) {
            // Batal
        } else {
            System.out.println("Start Add");
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("Todo Ke 1");
        addTodoList("Todo Ke 2");
        viewAddTodoList();
        showTodoList();
    }
    /**
     * Menampilkan view remove todo list
     */
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODOLIST");
        var number = input("Nomor yang dihapus (x Jika Batal)");
        if (number.equals("x")) {
            //Batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("Todo Ke 1");
        addTodoList("Todo Ke 2");
        addTodoList("Todo Ke 3");
        addTodoList("Todo Ke 4");
        addTodoList("Todo Ke 5");
        addTodoList("Todo Ke 6");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
