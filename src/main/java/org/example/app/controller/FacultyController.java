package org.example.app.controller;

import lombok.RequiredArgsConstructor;
import org.example.app.dto.FacultyDTO;
import org.example.app.services.FacultyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {
  private final FacultyService service;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("faculties", service.getAll());
    return "faculties/list";
  }

  @GetMapping("/create")
  public String createForm(Model model) {
    model.addAttribute("faculty", new FacultyDTO());
    return "faculties/create";
  }

  @PostMapping("/create")
  public String create(@ModelAttribute FacultyDTO dto) {
    service.create(dto);
    return "redirect:/faculties";
  }

  @GetMapping("/edit/{id}")
  public String editForm(@PathVariable Long id, Model model) {
    model.addAttribute("faculty", service.getById(id));
    return "faculties/edit";
  }

  @PostMapping("/edit/{id}")
  public String edit(@PathVariable Long id, @ModelAttribute FacultyDTO dto) {
    service.update(id, dto);
    return "redirect:/faculties";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    service.delete(id);
    return "redirect:/faculties";
  }
}
