package com.ultech.dao;

import com.ultech.model.FileModel;
import com.ultech.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FileModelDao extends CrudRepository<FileModel, Integer> {
}
