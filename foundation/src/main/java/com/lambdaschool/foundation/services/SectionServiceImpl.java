package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.exceptions.ResourceFoundException;
import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.Section;
import com.lambdaschool.foundation.repository.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Service(value = "sectionService")
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionRepo secRepo;

    @Override
    public Section createNewSection(Section newSection) {
        Section section = new Section();

        section.setSectionname(newSection.getSectionname());
        if (newSection.getBooks().size() > 0){
            throw new ResourceFoundException("Don't add Books inside of a section");
        }


        return secRepo.save(section);
    }

    @Override
    public Section findSectionById(long id) {
        return secRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Section id " + id + " not found!"));
    }

    @Override
    public Section findSectionByName(String name) {
        Section ss = secRepo.findByName(name.toLowerCase());
        if (ss == null)
        {
            throw new ResourceNotFoundException("User name " + name + " not found!");
        }
        return ss;
    }

    @Override
    public List<Section> findAllSections() {

        List<Section> foundSections = new ArrayList<>();
        secRepo.findAll().iterator().forEachRemaining(foundSections::add);
        return foundSections;
    }

    @Override
    public Section updateSection(long id, Section updateInfo) {
        Section section = findSectionById(id);
        if (section.getSectionname() != null){
            section.setSectionname(updateInfo.getSectionname());
        }
        return secRepo.save(section);
    }

    @Override
    public void deleteSection(long id) {

        Section section = findSectionById(id);
        secRepo.delete(section);

    }
}
