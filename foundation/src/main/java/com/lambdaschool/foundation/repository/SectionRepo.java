package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.Section;
import com.lambdaschool.foundation.models.User;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepo extends CrudRepository<Section, Long> {
    Section findByName(String sectionName);
}
