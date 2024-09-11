package org.geekmozo.dao;

import org.geekmozo.entities.Student;

public interface StudentDao {

    public void registerStudent(Student student);

    public Student authenticateStudent(Student student);
}
