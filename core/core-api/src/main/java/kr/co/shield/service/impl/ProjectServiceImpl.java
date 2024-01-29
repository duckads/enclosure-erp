package kr.co.shield.service.impl;

import jakarta.transaction.Transactional;
import kr.co.shield.domain.Project;
import kr.co.shield.dto.ProjectDto;
import kr.co.shield.repository.ProjectRepository;
import kr.co.shield.service.inf.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Override
    public List<ProjectDto> findAll() {
        List<ProjectDto> rtnList = null;

        List<Project> projects = this.projectRepository.findAll();
        if (projects.isEmpty()) {
            rtnList = Collections.emptyList();
        } else {
            rtnList = projects.stream()
                    .map(e -> e.getDto())
                    .collect(Collectors.toList());
        }
        return rtnList;
    }

    @Override
    @Transactional
    public ProjectDto findProject(int seq) {
        ProjectDto rtnObj = null;

        Optional<Project> project = this.projectRepository.findById(seq);
        rtnObj = project.get().getDto();

        return rtnObj;
    }
}
