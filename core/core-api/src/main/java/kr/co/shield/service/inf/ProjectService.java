package kr.co.shield.service.inf;

import kr.co.shield.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    public List<ProjectDto> findAll();
    public ProjectDto findProject(int seq);
}
