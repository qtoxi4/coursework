package org.example.app.controller;

import lombok.RequiredArgsConstructor;
import org.example.app.dto.SubjectDTO;
import org.example.app.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
  private final SubjectService service;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("subjects", service.getAll());
    return "subjects/list";
  }

  @GetMapping("/create")
  public String createForm(Model model) {
    model.addAttribute("subject", new SubjectDTO());
    return "subjects/create";
  }

  @PostMapping("/create")
  public String create(@ModelAttribute SubjectDTO dto) {
    service.create(dto);
    return "redirect:/subjects";
  }

  @GetMapping("/edit/{id}")
  public String editForm(@PathVariable Long id, Model model) {
    model.addAttribute("subject", service.getById(id));
    return "subjects/edit";
  }

  @PostMapping("/edit/{id}")
  public String edit(@PathVariable Long id, @ModelAttribute SubjectDTO dto) {
    service.update(id, dto);
    return "redirect:/subjects";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    service.delete(id);
    return "redirect:/subjects";
  }
}
