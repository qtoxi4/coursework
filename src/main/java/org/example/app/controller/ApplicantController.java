package org.example.app.controller;

import lombok.RequiredArgsConstructor;
import org.example.app.dto.ApplicantDTO;
import org.example.app.services.ApplicantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/applicants")
@RequiredArgsConstructor
public class ApplicantController {

  private final ApplicantService applicantService;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("applicants", applicantService.getAll());
    return "applicants/list";
  }

  @GetMapping("/create")
  public String createForm(Model model) {
    model.addAttribute("applicant", new ApplicantDTO());
    return "applicants/create";
  }

  @PostMapping("/create")
  public String create(@ModelAttribute ApplicantDTO dto) {
    applicantService.create(dto);
    return "redirect:/applicants";
  }

  @GetMapping("/edit/{id}")
  public String editForm(@PathVariable Long id, Model model) {
    model.addAttribute("applicant", applicantService.getById(id));
    return "applicants/edit";
  }

  @PostMapping("/edit/{id}")
  public String edit(@PathVariable Long id, @ModelAttribute ApplicantDTO dto) {
    applicantService.update(id, dto);
    return "redirect:/applicants";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    applicantService.delete(id);
    return "redirect:/applicants";
  }
}
