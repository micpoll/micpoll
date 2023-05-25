package com.example.DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {
    private ZamowienieRepo zamowienieRepo;
    @Autowired
    public controller(ZamowienieRepo zamowienieRepo) {
        this.zamowienieRepo = zamowienieRepo;
    }
// DODAJ
    @PostMapping("/dodaj")
    public String FORM(
            @RequestParam("date") String date,
            @RequestParam("zrealizowane") String zrealizowane,
            @RequestParam("cena") Integer cena,
            @RequestParam("email") String email,
            @RequestParam("telefon") String telefon,
            Model model) {
        Zamowienie zamowienie = new Zamowienie(date, zrealizowane, cena, email, telefon, true);
        System.out.println(zamowienie);

        zamowienieRepo.save(zamowienie); // Zapis do Bazy

        model.addAttribute("zamowienie", zamowienie);
        return "widok";
    }

    // Pokaz
    @RequestMapping("/pokaz")
    public String pokaz(Model model) {
        Iterable<Zamowienie> zamowienia = zamowienieRepo.findAll();
        zamowienia.forEach(System.out::println);
        model.addAttribute("zamowienia", zamowienia);
        return "pokaz";
    }
    @RequestMapping("/kasuj")
    public String kasuj(@RequestParam("id") Integer id, Model model){
        zamowienieRepo.deleteById(id);
        model.addAttribute("zamowienia", zamowienieRepo.findAll());

        return "pokaz";
    }
    @RequestMapping("/wyszukaj")
    public String wyszukaj(@RequestParam("date") String date, Model model){
        model.addAttribute("zamowienia", zamowienieRepo.findAllBydate(date));
        return "pokaz";
    }





}

