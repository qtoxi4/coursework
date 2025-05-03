package org.example.app.controller;

import lombok.RequiredArgsConstructor;
import org.example.app.dto.DocumentDTO;
import org.example.app.services.ApplicantService;
import org.example.app.services.DocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {
  private final DocumentService service;
  private final ApplicantService applicantService;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("documents", service.getAll());
    return "documents/list";
  }

  @GetMapping("/create")
  public String createForm(Model model) {
    model.addAttribute("document", new DocumentDTO());
    model.addAttribute("applicants", applicantService.getAll());
    return "documents/create";
  }

  @PostMapping("/create")
  public String create(@ModelAttribute DocumentDTO dto) {
    service.create(dto);
    return "redirect:/documents";
  }

  @GetMapping("/edit/{id}")
  public String editForm(@PathVariable Long id, Model model) {
    model.addAttribute("document", service.getById(id));
    model.addAttribute("applicants", applicantService.getAll());
    return "documents/edit";
  }

  @PostMapping("/edit/{id}")
  public String edit(@PathVariable Long id, @ModelAttribute DocumentDTO dto) {
    service.update(id, dto);
    return "redirect:/documents";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    service.delete(id);
    return "redirect:/documents";
  }
}
