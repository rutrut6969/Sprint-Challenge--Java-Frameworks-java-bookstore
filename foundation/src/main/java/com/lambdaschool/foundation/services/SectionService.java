package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Section;

import java.util.List;

public interface SectionService {

    // CRUD Operation Function Initialization goes here:
    // Create
    Section createNewSection(Section newSection);

    // Read

    //Find By Section ID
    Section findSectionById(long id);

    //Find by Section Name
    Section findSectionByName(String name);

    // Find All Sections
    List<Section> findAllSections();

    // Update
    Section updateSection(long id, Section updateInfo);

    // Delete
    void deleteSection(long id);
}
