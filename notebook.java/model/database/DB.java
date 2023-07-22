package model.database;

import java.util.List;



public interface DB<T> {
    void saveAll(List<String> data);
    List<String> readAll();
}
