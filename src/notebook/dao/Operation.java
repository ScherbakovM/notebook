package notebook.dao;

import java.util.List;

/**
 * Data Access Object (DAO) слой, с методами для работы с БД
 * @param <T> тип объекта для чтения/записи.
 */
public interface Operation<T> {
    List<T> readAllNewFormat();
    List<T> readAllOldFormat();
    void saveAllNewFormat(List<T> data);
    void saveAllOldFormat(List<T> data);
}
