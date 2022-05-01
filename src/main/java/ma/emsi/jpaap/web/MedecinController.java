package ma.emsi.jpaap.web;

import ma.emsi.jpaap.entities.Medecin;
import ma.emsi.jpaap.repositories.MedecinRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class MedecinController {

  MedecinRepository medecinRepository;
@Autowired
  @GetMapping(path = "/user/listMedecins")
  @ResponseBody
  public  List<Medecin> listMedecins(){
    return  medecinRepository.findAll();
  }

  @GetMapping(path = "/user/medecins")
  public String medecins(Model model,
                         @RequestParam(name = "page",defaultValue = "0") int page ,
                         @RequestParam(name = "size",defaultValue = "5") int size,
                         @RequestParam(name = "keyword",defaultValue = "") String  keyword){
    Page<Medecin> pageMedecins = medecinRepository.findByNomContains(keyword,PageRequest.of(page,size));
    model.addAttribute("listMedecins",pageMedecins.getContent());
    model.addAttribute("pages",new int[pageMedecins.getTotalPages()] );
    model.addAttribute("currentPage",page);
    model.addAttribute("keyword",keyword);
       return "medecins";
  }
  @GetMapping(path = "/admin/deleteMedecin")
  public String delete(Long id , String keyword , int page){
    medecinRepository.deleteById(id);
    return "redirect:/user/medecins?page="+page+"&keyword="+keyword;
  }

  @GetMapping(path = "/admin/formMedecin")
  public String formMedecin(Model model){
    model.addAttribute("medecin",new Medecin());
    return "formMedecin";

}
  @PostMapping(path = "/admin/saveMedecin")
  public String save(Model model , @Valid Medecin medecin, BindingResult bindingResult,
                     @RequestParam(defaultValue = "0") int page,
                     @RequestParam(defaultValue = "") String keyword){
    if (bindingResult.hasErrors()) return "formMedecin";
    medecinRepository.save(medecin);
    return "redirect:/user/medecins?page"+page+"keyword"+keyword;
  }
  @GetMapping(path = "/admin/editMedecin")
  public String edit(Model model,Long id ,String keyword , int page){
    Medecin medecin = medecinRepository.findById(id).orElse(null);
    if (medecin==null) throw new RuntimeException("Medecin introuvable");
    model.addAttribute("medecin",medecin);
    model.addAttribute("page",page);
    model.addAttribute("keyword",keyword);

    return "editMedecin";
  }
}
