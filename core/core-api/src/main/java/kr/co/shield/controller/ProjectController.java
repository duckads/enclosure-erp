package kr.co.shield.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.dto.ProjectDto;
import kr.co.shield.service.inf.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "/project", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@RestController
public class ProjectController {
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDto>> list(HttpServletRequest request) {
        List<ProjectDto> rtnList = null;

        rtnList = this.projectService.findAll();

        return ResponseEntity.ok(rtnList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> get(HttpServletRequest request, @PathVariable(required = true, name = "id") final String id) {
        ProjectDto rtnObj = null;

        ProjectDto user = (ProjectDto)request.getAttribute(ShieldProperty.TKN_USER);

        Map<String, Object> props = Map.of("id", id);

        rtnObj = this.projectService.findProject(Integer.parseInt(id));

        return ResponseEntity.ok(rtnObj);
    }
}
