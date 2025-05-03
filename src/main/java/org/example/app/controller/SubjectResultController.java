package org.example.app.controller;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.app.dto.ApplicationFormattedDTO;
import org.example.app.dto.SubjectResultDTO;
import org.example.app.services.ApplicationService;
import org.example.app.services.SubjectResultService;
import org.example.app.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subject-results")
@RequiredArgsConstructor
public class SubjectResultController {
  private final SubjectResultService service;
  private final ApplicationService applicationService;
  private final SubjectService subjectService;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("subjectResults", service.getAll());
    return "subject-results/list";
  }

  @GetMapping("/create")
  public String createForm(Model model) {
    model.addAttribute("subjectResult", new SubjectResultDTO());
    model.addAttribute("applications", applicationService.getAll()
            .stream()
            .map(application -> new ApplicationFormattedDTO()
                    .setApplicantId(application.getApplicantId())
                    .setId(application.getId())
                    .setFormattedDate(application.getDate().toString())
                    .setSpecialtyId(application.getSpecialtyId()))
            .collect(Collectors.toList()));
    model.addAttribute("subjects", subjectService.getAll());
    return "subject-results/create";
  }

  @PostMapping("/create")
  public String create(@ModelAttribute SubjectResultDTO dto) {
    service.create(dto);
    return "redirect:/subject-results";
  }

  @GetMapping("/edit/{id}")
  public String editForm(@PathVariable Long id, Model model) {
    model.addAttribute("subjectResult", service.getById(id));
    model.addAttribute("applications", applicationService.getAll());
    model.addAttribute("subjects", subjectService.getAll());
    return "subject-results/edit";
  }

  @PostMapping("/edit/{id}")
  public String edit(@PathVariable Long id, @ModelAttribute SubjectResultDTO dto) {
    service.update(id, dto);
    return "redirect:/subject-results";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    service.delete(id);
    return "redirect:/subject-results";
  }
}
