package notebook.dao;

import java.util.List;

/**
 * Data Access Object (DAO) слой, с методами для работы с БД
 *
 * @param <T> тип объекта для чтения/записи.
 */
public interface Operation<T> {
    List<T> readAllNewFormat(); // Форматирование документа через пробел
    // и пустую строку между линиями, заменить методы в UserRepository.

    List<T> readAllOldFormat();

    void saveAllNewFormat(List<T> data); // Форматирование документа через
    // пробел и пустую строку между линиями, заменить в UserRepository.

    void saveAllOldFormat(List<T> data);
}
