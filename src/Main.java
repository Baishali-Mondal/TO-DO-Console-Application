import Controller.ToDoController;

//[ARCHITECTURE] : MAIN -> CONTROLLER -> SERVICE -> REPOSITORY(DAO) -> ARRAYLIST(DB)

public class Main {
    public static void main(String[] args){
//        ToDoController controller = new ToDoController();
//        controller.runToDoApp();
        new ToDoController().runToDoApp(); //main  purpose is to start the application
    }

}
