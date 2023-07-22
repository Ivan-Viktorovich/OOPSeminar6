
import controller.NoteController;
import model.Note;
import model.database.DBFunctional;
import repository.Repository;
import repository.impl.Reposit;
import view.NoteView;

import static model.database.DBConnector.DB_PATH;
import static model.database.DBConnector.createDB;

public class Main {

    public static void main(String[] args) {
        createDB();
        DBFunctional data = new DBFunctional(DB_PATH);
        Repository<Note, Long> repository = new Reposit(data);
        NoteController controller = new NoteController(repository);
        NoteView view = new NoteView(controller);
        view.run();
        
    }
}
