package org.example.app.controller;

import lombok.RequiredArgsConstructor;
import org.example.app.dto.SpecialtyDTO;
import org.example.app.services.FacultyService;
import org.example.app.services.SpecialtyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/specialties")
@RequiredArgsConstructor
public class SpecialtyController {
  private final SpecialtyService service;
  private final FacultyService facultyService;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("specialties", service.getAll());
    return "specialties/list";
  }

  @GetMapping("/create")
  public String createForm(Model model) {
    model.addAttribute("specialty", new SpecialtyDTO());
    model.addAttribute("faculties", facultyService.getAll());
    return "specialties/create";
  }

  @PostMapping("/create")
  public String create(@ModelAttribute SpecialtyDTO dto) {
    service.create(dto);
    return "redirect:/specialties";
  }

  @GetMapping("/edit/{id}")
  public String editForm(@PathVariable Long id, Model model) {
    model.addAttribute("specialty", service.getById(id));
    return "specialties/edit";
  }

  @PostMapping("/edit/{id}")
  public String edit(@PathVariable Long id, @ModelAttribute SpecialtyDTO dto) {
    service.update(id, dto);
    return "redirect:/specialties";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    service.delete(id);
    return "redirect:/specialties";
  }
}
