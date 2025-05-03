package org.example.app.controller;

import lombok.RequiredArgsConstructor;
import org.example.app.dto.SubjectCoefficientDTO;
import org.example.app.services.FacultyService;
import org.example.app.services.SubjectCoefficientService;
import org.example.app.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subject-coefficients")
@RequiredArgsConstructor
public class SubjectCoefficientController {
  private final SubjectCoefficientService service;
  private final SubjectService subjectService;
  private final FacultyService facultyService;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("subjectCoefficients", service.getAll());
    return "subject-coefficients/list";
  }

  @GetMapping("/create")
  public String createForm(Model model) {
    model.addAttribute("subjectCoefficient", new SubjectCoefficientDTO());
    model.addAttribute("subjects", subjectService.getAll());
    model.addAttribute("faculties", facultyService.getAll());

    return "subject-coefficients/create";
  }

  @PostMapping("/create")
  public String create(@ModelAttribute SubjectCoefficientDTO dto) {
    service.create(dto);
    return "redirect:/subject-coefficients";
  }

  @GetMapping("/edit/{id}")
  public String editForm(@PathVariable Long id, Model model) {
    model.addAttribute("subjectCoefficient", service.getById(id));
    model.addAttribute("subjects", subjectService.getAll());
    model.addAttribute("faculties", facultyService.getAll());
    return "subject-coefficients/edit";
  }

  @PostMapping("/edit/{id}")
  public String edit(@PathVariable Long id, @ModelAttribute SubjectCoefficientDTO dto) {
    service.update(id, dto);
    return "redirect:/subject-coefficients";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    service.delete(id);
    return "redirect:/subject-coefficients";
  }
}
