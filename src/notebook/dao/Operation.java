package notebook.dao;

import java.util.List;

/**
 * Data Access Object (DAO) ����, � �������� ��� ������ � ��
 * @param <T> ��� ������� ��� ������/������.
 */
public interface Operation<T> {
    List<T> readAllNewFormat();
    List<T> readAllOldFormat();
    void saveAllNewFormat(List<T> data);
    void saveAllOldFormat(List<T> data);
}
