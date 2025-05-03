package org.example.app.controller;

import lombok.RequiredArgsConstructor;
import org.example.app.dto.ApplicationDTO;
import org.example.app.services.ApplicantService;
import org.example.app.services.ApplicationService;
import org.example.app.services.SpecialtyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {
  private final ApplicationService service;
  private final ApplicantService applicantService;
  private final SpecialtyService specialtyService;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("applications", service.getAll());
    return "applications/list";
  }

  @GetMapping("/create")
  public String createForm(Model model) {
    model.addAttribute("application", new ApplicationDTO());
    model.addAttribute("applicants", applicantService.getAll());
    model.addAttribute("specialties", specialtyService.getAll());
    return "applications/create";
  }

  @PostMapping("/create")
  public String create(@ModelAttribute ApplicationDTO dto) {
    service.create(dto);
    return "redirect:/applications";
  }

  @GetMapping("/edit/{id}")
  public String editForm(@PathVariable Long id, Model model) {
    model.addAttribute("application", service.getById(id));
    model.addAttribute("applicants", applicantService.getAll());
    model.addAttribute("specialties", specialtyService.getAll());
    return "applications/edit";
  }

  @PostMapping("/edit/{id}")
  public String edit(@PathVariable Long id, @ModelAttribute ApplicationDTO dto) {
    service.update(id, dto);
    return "redirect:/applications";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    service.delete(id);
    return "redirect:/applications";
  }
}
