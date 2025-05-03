package org.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

  @GetMapping("/about")
  public String about() {
    return "about";
  }

  @GetMapping("/")
  public String home() {
    return "redirect:/applicants";
  }
}
